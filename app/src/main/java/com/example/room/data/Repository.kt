package com.example.room.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.room.database.User
import com.example.room.database.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class Repository {

    companion object {

        private var database: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase? {
            return UserDatabase.getDatabase(context)
        }

        fun insert(context: Context, user: User) {
            database = getDatabase(context)
            CoroutineScope(IO).launch {
                database!!.getDao().insertUser(user)
            }
        }

        fun getAllUsers(context: Context): LiveData<List<User>> {
            database = getDatabase(context)
            return database!!.getDao().getAllUsers()
        }

        fun delete(context: Context,user: User){
            database = getDatabase(context)
            CoroutineScope(IO).launch {
                database!!.getDao().delete(user)
            }
        }

    }

}