package com.example.room.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.room.database.User

class MainViewModel : ViewModel() {

    fun insert(context: Context, user: User) {
        Repository.insert(context, user)
    }

    fun getAllUsers(context: Context): LiveData<List<User>> {
        return Repository.getAllUsers(context)
    }

}