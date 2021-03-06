package com.neppplus.listview_20211120

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.neppplus.listview_20211120.adapters.StudentAdapter
import com.neppplus.listview_20211120.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mStudentAdapter : StudentAdapter


    val mStudentList = ArrayList<StudentData>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        mStudentList.add( StudentData("조경진", birthYear = 1988, "서울시 동대문구"))
        mStudentList.add( StudentData("구영모", birthYear = 1990, "경기도부천시"))
        mStudentList.add( StudentData("김정난", birthYear = 1976, "서울시 용산구"))
        mStudentList.add( StudentData("김정환", birthYear = 1981, "서울시 즁랑구"))
        mStudentList.add( StudentData("김찬수", birthYear = 1996, "서울시 성북구"))
        mStudentList.add( StudentData("김창배", birthYear = 1993, "서울시 노원구"))
        mStudentList.add( StudentData("성연진", birthYear = 1994, "서울시 마포구"))

        mStudentAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        studentListView.adapter = mStudentAdapter

        studentListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedStudent = mStudentList[position]

//            Toast.makeText(this, "${clickedStudent.name} 클릭됨", Toast.LENGTH_SHORT).show()
            val myIntent = Intent (this, ViewStudentDetailsActivity::class.java)

            myIntent.putExtra("name", clickedStudent.name)
            myIntent.putExtra("age", clickedStudent.getAgeByYear(2021))
            myIntent.putExtra("address", clickedStudent.address)

            startActivity(myIntent)

        }

            studentListView.setOnItemLongClickListener { adapterView, view, position, l ->
//                길게 눌렸을때
                val longClickedStudent = mStudentList[position]

//                Toast.makeText(this, "${longClickedStudent.name} 길게 클릭됨", Toast.LENGTH_SHORT).show()

//                학생 제거 전 진짜로 삭제할 건지 물어보자

                val alert = AlertDialog.Builder( this)
                alert.setTitle("학생 삭제 확인")
                alert.setMessage("정말 ${longClickedStudent.name} 학생을 삭제하시겠습니까?")

                alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->

//                    확인 버튼이 눌릴때 실행 할 코드

                    mStudentList.remove(longClickedStudent)

//                어댑터 새로고침
                    mStudentAdapter.notifyDataSetChanged()


                } )
                alert.setNegativeButton("취소", null )

                alert.show()

                return@setOnItemLongClickListener true

            }

    }
}