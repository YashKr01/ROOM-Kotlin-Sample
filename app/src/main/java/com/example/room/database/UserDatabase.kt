package com.example.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase? {

            if (INSTANCE == null) {

                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder(context, UserDatabase::class.java, "database")
                                .fallbackToDestructiveMigration()
                                .build()
                    }
                }

            }


            return INSTANCE
        }

    }

}