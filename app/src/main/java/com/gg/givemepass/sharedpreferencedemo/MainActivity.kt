package com.gg.givemepass.sharedpreferencedemo

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var settings: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setEventListener()
    }

    private fun readData() {
        settings = getSharedPreferences(DATA, 0)
        nameField.setText(settings.getString(NAME, ""))
        phoneField.setText(settings.getString(PHONE, ""))
        sexField.setText(settings.getString(SEX, ""))
    }

    private fun saveData() {
        settings = getSharedPreferences(DATA, 0)
        settings.edit()
                .putString(NAME, nameField.text.toString())
                .putString(PHONE, phoneField.text.toString())
                .putString(SEX, sexField.text.toString())
                .apply()
    }

    private fun setEventListener() {
        saveButton.setOnClickListener {
            saveData()
            Toast.makeText(this@MainActivity, R.string.save_success, Toast.LENGTH_SHORT).show()
        }
        readButton.setOnClickListener {
            readData()
            Toast.makeText(this@MainActivity, R.string.read_success, Toast.LENGTH_SHORT).show()
        }
        clearButton.setOnClickListener {
            nameField.setText("")
            phoneField.setText("")
            sexField.setText("")
        }
    }

    companion object {
        private const val DATA = "DATA"
        private const val NAME = "NAME"
        private const val PHONE = "PHONE"
        private const val SEX = "SEX"
    }
}
