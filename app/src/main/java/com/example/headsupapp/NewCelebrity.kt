package com.example.headsupapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewCelebrity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etT1: EditText
    private lateinit var etT2: EditText
    private lateinit var etT3: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnReturn: Button
    lateinit var celebDB: CelebrityDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_celebrity)
        etName = findViewById(R.id.etName)
        etT1 = findViewById(R.id.etT1)
        etT2 = findViewById(R.id.etT2)
        etT3 = findViewById(R.id.etT3)
        btnAdd = findViewById(R.id.btnAdd)
        btnReturn = findViewById(R.id.btnRetern)

        btnAdd.setOnClickListener {

            addCelebrity()
        }
        btnReturn.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addCelebrity() {
        celebDB = CelebrityDatabase.getInstance(applicationContext)

        if (etName.text.isNotEmpty() && etT1.text.isNotEmpty() &&
            etT2.text.isNotEmpty() && etT3.text.isNotEmpty()
        ) {

            celebDB.CelebrityDoa().addCelebrity(
                Celebrity(
                    name = etName.text.toString(),
                    taboo1 = etT1.text.toString(),
                    taboo2 = etT2.text.toString(),
                    taboo3 = etT3.text.toString()
                )
            )

            Toast.makeText(this, "clebrity added ", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "One or more fields is empty", Toast.LENGTH_LONG).show()
        }
    }

}