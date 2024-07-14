// GROUP SUBMISSION FOR MUDIT MATHUR (UID: 117564921) AND BHARGAV TUMKUR (UID:117526318)

package com.example.project3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var shiftWarningTV : TextView
    private lateinit var shiftPromptEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cryptosystem = Encryption()

        shiftWarningTV = findViewById(R.id.shift_warning)
        shiftPromptEditText = findViewById(R.id.shift_prompt)
    }

    override fun onRestart() {
        super.onRestart()
        shiftWarningTV.text = ""
    }

    fun setShift(v : View) {
        // evaluate the shift number (v.text) to see if it's 1-25, if so shift and if not populate the shift warning
        // for this I need a reference to shift warning, and let's get one to shift prompt just in case
        var shiftAmount = shiftPromptEditText.text.toString()
        if (shiftAmount == "") {
            shiftWarningTV.text = "ENTER A NUMBER BETWEEN 1 AND 25"
        }
        else if (shiftAmount.toInt() < 1 || shiftAmount.toInt() > 25) {
            shiftWarningTV.text = "NUMBER MUST BE BETWEEN 1 AND 25"
        } else {
            cryptosystem.setShift(shiftAmount.toInt())
            // let's go to the second View
            var myIntent : Intent = Intent(this, EncryptActivity::class.java)
            this.startActivity(myIntent)
        }



    }

    companion object {
        lateinit var cryptosystem : Encryption
    }
}