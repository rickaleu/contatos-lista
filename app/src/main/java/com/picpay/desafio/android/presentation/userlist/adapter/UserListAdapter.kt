package com.picpay.desafio.android.presentation.userlist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.picpay.desafio.android.domain.User

class UserListAdapter: ListAdapter<User, UserListItemViewHolder>(UserListDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder {
        return UserListItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}