package com.kiran.retrofitstarterbatch26.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.kiran.retrofitstarterbatch26.R
import com.kiran.retrofitstarterbatch26.ui.model.User
import com.kiran.retrofitstarterbatch26.ui.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var tvRegister: TextView
    private lateinit var btnLogin: Button
    private lateinit var chkRememberMe: CheckBox
    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        tvRegister = findViewById(R.id.tvRegister)
        btnLogin = findViewById(R.id.btnLogin)

        tvRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        val user = User(username = username, password = password)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = UserRepository()
                val response = repository.login(user)
                if (response.success == true) {
                    startActivity(
                        Intent(
                            this@LoginActivity, FetchStudentActivity::class.java
                        )
                    )
                    finish()

                } else {
                    withContext(Dispatchers.Main) {
                        val snack =
                            Snackbar.make(linearLayout, "Invalid credential", Snackbar.LENGTH_LONG)
                    }
                }

            }catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@LoginActivity, "Successfully Logged In", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this@LoginActivity,FetchStudentActivity::class.java))
                    finish()
                }
            }
        }
    }
}