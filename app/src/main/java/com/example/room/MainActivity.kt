package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room.adapter.ClickListener
import com.example.room.adapter.MyAdapter
import com.example.room.data.MainViewModel
import com.example.room.database.User
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), ClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = MyAdapter(this, ArrayList<User>(), this)

        recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            //adapter = myAdapter
        }

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getAllUsers(this).observe(this, Observer {
            recycler_view.adapter = myAdapter
            myAdapter.setData(it)
        })

        btn_add.setOnClickListener {
            val name = edit_name.text.toString()
            val email = edit_email.text.toString()

            val user = User(name, email)
            viewModel.insert(applicationContext, user)
            Toast.makeText(this, "INSERTED", Toast.LENGTH_SHORT).show()

            edit_name.setText("")
            edit_email.setText("")

        }

    }

    override fun onClick(user: User) {
        viewModel.delete(applicationContext, user)
    }
}