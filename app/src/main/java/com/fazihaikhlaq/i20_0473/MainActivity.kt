package com.fazihaikhlaq.i20_0473

// Import the necessary libraries
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var signUptext: TextView
        signUptext = findViewById(R.id.signUp)
        var str = "Sign up"
        val mSpannableString = SpannableString(str)

        mSpannableString.setSpan(UnderlineSpan(), 0, mSpannableString.length, 0)

        signUptext.text = mSpannableString

        signUptext.setOnClickListener{
            startActivity(Intent(this,SignUp::class.java))
        }
        var f_pass = findViewById<TextView>(R.id.textView8)
        f_pass.setOnClickListener{
            startActivity(Intent(this,forgot_pass::class.java))
        }

        findViewById<Button>(R.id.signup_btn).setOnClickListener {
            startActivity(Intent(this,Mentors::class.java))
        }


    }
}