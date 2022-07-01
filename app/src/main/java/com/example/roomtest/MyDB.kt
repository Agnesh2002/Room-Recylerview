package com.example.roomtest

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version=1)
abstract class MyDB : RoomDatabase() {

     abstract fun dao():Dao

}