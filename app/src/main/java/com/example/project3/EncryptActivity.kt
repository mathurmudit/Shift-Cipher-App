package com.example.project3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EncryptActivity : AppCompatActivity() {

    private lateinit var shiftAmountTV : TextView
    private lateinit var encryptButton: Button
    private lateinit var encryptPromptEditText : EditText
    private lateinit var encryptionResultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encrypt)

        val goBackButton : Button = findViewById<Button>( R.id.go_back_button )
        goBackButton.setOnClickListener { goBack( ) }

        shiftAmountTV = findViewById(R.id.shift_amount)
        encryptButton = findViewById(R.id.encrypt_button)
        encryptPromptEditText = findViewById(R.id.encrypt_prompt)
        encryptionResultTextView = findViewById(R.id.encryption_result)

        var shiftAmount = MainActivity.cryptosystem.getShift()
        shiftAmountTV.text = "Shift = " + shiftAmount.toString()

    }

    fun encrypt(v: View) {
        var ciphertext : String = MainActivity.cryptosystem.encrypt(encryptPromptEditText.text.toString())
        encryptionResultTextView.text = ciphertext
    }

    fun goBack( ) {
        finish()
    }

}