package com.kkyoungs.mvvm

import androidx.databinding.BaseObservable
import com.kkyoungs.mvvm.Database.DatabaseListener
class ViewModel(): BaseObservable() {
    private var database : Database?= null
    var items : List<Person> = ArrayList()
    var winner : String ?= null

        /**
         * viewModel 생성자 실행
         * DB(Model) 참조
         */
        constructor(database: Database) : this() {
            this.database = database
            this.database!!.setOnDatabaseListener(object : DatabaseListener {
                // 리스너 실행

                override fun onChanged() {
                    winner = null
                    winner = database.winner
                    notifyChange()
                }
            })
        }



        fun getUser(){
            // dp에게 user (winner)을 달라고 요청
            database!!.user
        }



}