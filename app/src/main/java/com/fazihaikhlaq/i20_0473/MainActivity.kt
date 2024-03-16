package com.fazihaikhlaq.i20_0473

// Import the necessary libraries
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this,Mentors::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        auth = Firebase.auth



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
            // get email and password and verify them

            var email: String = findViewById<EditText>(R.id.editTextTextEmailAddress2).text.toString()
            var password: String = findViewById<EditText>(R.id.editTextTextPassword).text.toString()


            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Firebase message", "signInWithEmail:success")
                        val user = auth.currentUser

                        // verified user will be logged in
                        startActivity(Intent(this,Mentors::class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Firebase Message", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }



        }


    }
}