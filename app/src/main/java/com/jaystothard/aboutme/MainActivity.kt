package com.jaystothard.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.jaystothard.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Jay Stothard")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
//        findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }
        binding.doneButton.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(view:View) {

    binding.apply {
//        nicknameText.text = binding.nicknameEdit.text
        myName?.nickname = nicknameEdit.text.toString()
        invalidateAll()
        nicknameEdit.visibility = View.GONE
        doneButton.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE
    }


        // Hide Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}