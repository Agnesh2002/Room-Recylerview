package com.example.roomtest

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun accessDao():RoomDao

}