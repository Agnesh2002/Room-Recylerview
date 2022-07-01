package com.example.roomtest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {

    @Insert
    fun addUser(user: User)

    @Query("select * from user_table")
    fun getUsers(): List<User>

}