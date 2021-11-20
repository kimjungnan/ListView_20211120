package com.neppplus.listview_20211120

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_student_details.*

class ViewStudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student_details)

        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val age = intent.getIntExtra("age", 0)

        txtName.text = name
        txtAddress.text = address
        txtAge.text = "${age} 세"
    }
}