package com.neppplus.listview_20211120.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neppplus.listview_20211120.R
import com.neppplus.listview_20211120.datas.StudentData

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StudentData>) : ArrayAdapter<StudentData> (mContext,resId,mList) {

//        Adapter 역할

//
    val mInflater = LayoutInflater.from(mContext)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null ){
            tempRow = mInflater.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!!

//        row 실제 데이터 가공
//        근더 데이터 가져오기
        val data = mList[position]

//        뿌려질 UI 가져오자
        val txtStudentName = row.findViewById<TextView>(R.id.txtStudentName)
        val txtAge = row.findViewById<TextView>(R.id.txtAge)
        val txtAddress = row.findViewById<TextView>(R.id.txtAddress)

        txtStudentName.text = data.name
        txtAge.text ="${data.birthYear} 년생"

        txtAddress.text = data.address

        return row


    }


}