package com.example.hoangvietandroidapplication.ui

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapplication.database.DatabaseClient
import com.example.demoapplication.model.Person
import com.example.hoangvietandroidapplication.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnSubmit.setOnClickListener {
            val firstName = edtFirstName.text.toString()
            val lastName = edtLastName.text.toString()
            val phoneNumber = edtPhoneNumber.text.toString()
            val email = edtEmail.text.toString()
            Thread(Runnable {
                val person = Person(0, firstName, lastName, phoneNumber, email)
                DatabaseClient.getDatabase(this@RegisterActivity).insertPerson(person)
                runOnUiThread {
                    setResult(Activity.RESULT_OK)
                    finish()
                }
            }).start()
        }
    }
}