package kg.geektech.kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.geektech.kotlin.databinding.ActivitySecondBinding
import kg.geektech.kotlin.keys.Constans.KEY_SECOND

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.et2.setText(intent.getStringExtra("key"))

        binding.btn2.setOnClickListener {
            if (binding.et2.text.toString().isEmpty())
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()

            setResult(RESULT_OK, Intent().putExtra(KEY_SECOND, binding.et2.text.toString()))
            finish()
        }
    }
    override fun onBackPressed() {
        setResult(Activity.RESULT_OK)
        finish()
    }
}