package com.kkyoungs.mvvm

class Database {
    private val personList = ArrayList<Person>()
    var winner: String? = null
    private var databaseListener: DatabaseListener? = null
    private var instance: Database? = null
    init {
        // Model인 Database 생성
        personList.add(Person(0, "똥꼬"))
        personList.add(Person(1, "조로똥"))
        personList.add(Person(2, "조꼬미"))
        personList.add(Person(3, "똥갱"))
        personList.add(Person(4, "똥고몽"))
    }

    val user: Unit
        get() {
            // 당첨자 획득
            winner = personList[(Math.random() * 5).toInt()].name
            notifyChange()
        }

    private fun notifyChange() {
        if (databaseListener != null) {
            // Model | Data 변경 되어 notify 하라고 알림
            databaseListener!!.onChanged()
        }
    }

    fun setOnDatabaseListener(databaseListener: DatabaseListener) {
         println("DatabaseListener 구현 객체 참조 변수 세팅 (arg1 : %s)" +databaseListener.javaClass.simpleName)
        this.databaseListener = databaseListener
    }
    fun getInstance(): Database? {
        // Model에 접근 할 수 있도록 DB 인스턴스 값 요청
        if (instance == null) {
            instance = Database()
        }
        return instance
    }
    interface DatabaseListener {
        fun onChanged()
    }


}
