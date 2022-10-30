package com.picpay.desafio.android.presentation.userlist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.domain.User

object UserListDiffCallback: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}