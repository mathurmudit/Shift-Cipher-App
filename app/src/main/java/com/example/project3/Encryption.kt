package com.example.project3

class Encryption {
    private var shift : Int = 0

    fun encrypt (word: String) : String {
        var ciphertext : String = ""
        for (character in word) {
            var cipher = character + shift
            if (cipher.code > 90) {
                cipher = (cipher.code % 91).toChar()
                cipher += 65
            }
            ciphertext += cipher
        }
        return ciphertext
    }

    fun setShift( shiftAmt : Int) {
        shift = shiftAmt
    }

    fun getShift () : Int {
        return shift
    }
}