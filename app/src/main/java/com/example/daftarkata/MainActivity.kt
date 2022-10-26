package com.example.daftarkata

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private var selectedWord: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()

        navigateFragment(homeFragment, false)
    }

    fun setSelectedWord(word: String) {
        selectedWord = word
    }

    fun getSelectedWord(): String {
        return selectedWord
    }

    fun onLetterClick(letter: String?) {
        val url = "https://www.google.com/search?q=$letter"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    fun navigateFragment(fragment: Fragment, isBackStack: Boolean) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame, fragment)
            if (isBackStack) addToBackStack(null)
            commit()
        }
    }
}