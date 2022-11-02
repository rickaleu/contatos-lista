package com.picpay.desafio.android.data.datasource.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.picpay.desafio.android.data.datasource.local.model.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM tb_user_list")
    suspend fun getAllUsers(): List<UserEntity>

    @Insert(onConflict = ABORT)
    suspend fun insertUser(user: UserEntity)

}