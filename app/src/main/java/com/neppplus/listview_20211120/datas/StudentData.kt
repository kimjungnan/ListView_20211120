package com.neppplus.listview_20211120.datas

class StudentData (
    val name: String,
    val birthYear: Int,
    val address: String) {

//    학생 클래스 기능을 추가 => 년도 넣으면 나이로 계산 (함수 제작)
    fun getAgeByYear(year: Int) : Int {

        val age = year - this.birthYear + 1

    return age
    }

}