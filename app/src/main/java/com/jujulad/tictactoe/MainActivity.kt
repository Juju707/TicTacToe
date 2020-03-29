package com.jujulad.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        btn_single.setOnClickListener{
            val intent=Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        btn_multi.setOnClickListener{
            val intent=Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

}
