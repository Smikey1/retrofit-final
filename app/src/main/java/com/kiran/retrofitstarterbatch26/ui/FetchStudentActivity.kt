package com.kiran.retrofitstarterbatch26.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kiran.retrofitstarterbatch26.R
import com.kiran.retrofitstarterbatch26.ui.fragment.AddStudentFragment
import com.kiran.retrofitstarterbatch26.ui.fragment.HomeFragment

class FetchStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_student)

        val fragment =supportFragmentManager.beginTransaction()
        fragment.replace(R.id.renderAnyFragment,HomeFragment())
        fragment.commit()

    }
}
