package com.example.temalivre

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.name)
        var textBirthday = findViewById<TextView>(R.id.textBirthday)
        val button = findViewById<Button>(R.id.generateText)

        button.setOnClickListener { view ->
            val nome = input.getText().toString()
            if (nome == "") {
                Snackbar.make(view, "Digite um nome!",
                    Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val birthdayMessage = "Olá $nome, parabéns pelo seu dia! Te desejo muitas felicidades, paz, saúde, dinheiro, prosperidade e vida longa!\nEu tenho muito orgulho de tê-lo em minha vida e espero que nossa relação perdure por muito mais tempo, pois sei que você é uma pessoa maravilhosa e merecedora de tudo o que tem!\nEspero que aproveite bem seu dia, abraços e beijos de luz n'alma!!!"

                textBirthday.text = birthdayMessage

                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Texto de Aniversário", birthdayMessage)
                clipboard.setPrimaryClip(clip)
                Snackbar.make(view, "Texto copiado para o clipboard!", Snackbar.LENGTH_SHORT).show()
                }
        }
    }
}