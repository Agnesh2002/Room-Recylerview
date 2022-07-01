package com.example.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.room.Room
import com.example.roomtest.databinding.ActivityMainBinding
import java.util.logging.Logger.global

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddUser.setOnClickListener(View.OnClickListener {

            val db:MyDB = Room.databaseBuilder(applicationContext,MyDB::class.java,"userdb").allowMainThreadQueries().build()
            var name:String = binding.etName.text.toString()
            var email:String = binding.etEmail.text.toString()
            var user = User(0,name,email)
            db.dao().addUser(user)
            Toast.makeText(this,"User added successfully",Toast.LENGTH_SHORT).show()

        })

        binding.btnShowUsers.setOnClickListener(View.OnClickListener {

            val db:MyDB = Room.databaseBuilder(applicationContext,MyDB::class.java,"userdb").allowMainThreadQueries().build()
            var arrayList:List<User> = db.dao().getUsers()

            for (user:User in arrayList)
            {
                var id = user.id
                var name = user.name
                var email = user.email
                var data:String = binding.tvData.text.toString()
                binding.tvData.text = data+"\n"+id.toString()+" | "+name+" | "+email
            }

        })

    }
}