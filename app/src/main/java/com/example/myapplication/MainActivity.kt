package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1: Button = findViewById(R.id.button)
        val btn2: Button = findViewById(R.id.button2)
        fm = supportFragmentManager
        btn1.setOnClickListener (this)
        btn2.setOnClickListener (this)
    }

    override fun onClick(p0: View) {
        if(p0.id == R.id.button) {
            loadFragments(FirstFragment())
        } else {
            loadFragments(SecondFragment())
        }
    }

    private fun loadFragments(f: Fragment) {
        val transaction: FragmentTransaction = fm.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, f)
        transaction.commit()
    }
}