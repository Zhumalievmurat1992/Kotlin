package kg.geektech.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.kotlin.databinding.ActivityMainBinding
import kg.geektech.kotlin.keys.Constans.KEY_MAIN

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataSend()
        registerForActivityResult = registerForActivityResult(
            ActivityResultContracts
                .StartActivityForResult()
        ) { result ->
            binding.et.setText(result.data?.getStringExtra(KEY_MAIN))
        }
    }

    private fun dataSend() {
        binding.btn.setOnClickListener {
            if (binding.et.text.toString().isEmpty()) {
                Toast.makeText(this, getString(R.string.entertext), Toast.LENGTH_SHORT).show()
            } else {
                Intent(this@MainActivity, SecondActivity::class.java).apply {
                    putExtra(KEY_MAIN, binding.et.text.toString())
                    registerForActivityResult.launch(this)
                }
            }
        }
    }
}