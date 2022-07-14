package com.example.roomtest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RoomDao {

    @Insert
    fun putData(userData: UserData)

    @Query("select * from user_table")
    fun getData():List<UserData>

}