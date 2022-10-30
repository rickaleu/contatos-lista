package com.picpay.desafio.android.presentation.userlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data.response.UserResponse
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.domain.User
import com.picpay.desafio.android.utils.loadImage
import com.squareup.picasso.Picasso

class UserListItemViewHolder private constructor(private val binding: ListItemUserBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bind(userListItem: User){

//        val img: String,
//        val name: String,
//        val id: Int,
//        val username: String

        val context = binding.root.context
        binding.itemListName.text = userListItem.name
        binding.itemListUsername.text = userListItem.username
        loadImage(binding.itemListPicture, null)
//        binding.launchCard.setOnClickListener {
//            it.findNavController().navigate(HomeFragmentDirections.navigateToDetail(launchItem))
//        }
    }

    companion object{
        fun from(parent: ViewGroup): UserListItemViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ListItemUserBinding.inflate(inflater, parent, false)
            return UserListItemViewHolder(binding)
        }
    }
}


//    (
//    itemView: View
//) : RecyclerView.ViewHolder(itemView) {
//
//    fun bind(userResponse: UserResponse) {
//        itemView.name.text = user.name
//        itemView.username.text = user.username
//        itemView.progressBar.visibility = View.VISIBLE
//        Picasso.get()
//            .load(userResponse.img)
//            .error(R.drawable.ic_round_account_circle)
//            .into(itemView.picture, object : Callback {
//                override fun onSuccess() {
//                    itemView.progressBar.visibility = View.GONE
//                }
//
//                override fun onError(e: Exception?) {
//                    itemView.progressBar.visibility = View.GONE
//                }
//            })
//    }
//}