package com.picpay.desafio.android.presentation.userlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.domain.User
import com.picpay.desafio.android.utils.loadImage

class UserListAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val binding = ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bindView(userList[position])
    }

    override fun getItemCount() = userList.count()

    class UserListViewHolder(private val itemBinding: ListItemUserBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindView(user: User) {
            loadImage(itemBinding.itemListPicture, user.img)
            itemBinding.itemListName.text = user.name
            itemBinding.itemListUsername.text = user.username
        }
    }
}