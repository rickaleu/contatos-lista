package com.picpay.desafio.android.data.datasource.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.picpay.desafio.android.data.datasource.local.dao.UserDao
import com.picpay.desafio.android.data.datasource.local.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDao
}

private lateinit var INSTANCE: UserDatabase

fun getDataBase(context: Context): UserDatabase {
    synchronized(UserDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "user_db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    return INSTANCE
}