package com.example.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.roomtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddUser.setOnClickListener(View.OnClickListener {

            var uname = binding.etName.text.toString()
            var mail = binding.etEmail.text.toString()

            var db = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "users_db").allowMainThreadQueries().build()
            var userData = UserData(0,uname,mail)
            db.accessDao().putData(userData)
            Toast.makeText(applicationContext,"Data added successfully",Toast.LENGTH_SHORT).show()

            var list: List<UserData> = db.accessDao().getData()

            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            val adapter = CustomAdapter(list)
            binding.recyclerView.adapter = adapter

        })

//        binding.btnShowUsers.setOnClickListener(View.OnClickListener {
//
//            val db = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "users_db").allowMainThreadQueries().build()
//            list = db.accessDao().getData()
//
//            for(user:UserData in list)
//            {
//                var id = user.id
//                var name = user.username
//                var email = user.email
//                var data:String = binding.tvData.text.toString()
//                binding.tvData.text = data+"\n"+id.toString()+" | "+name+" | "+email
//
//            }
//
//        })






    }
}