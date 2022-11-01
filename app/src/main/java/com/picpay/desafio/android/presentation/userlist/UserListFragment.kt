package com.picpay.desafio.android.presentation.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.FragmentUserListBinding
import com.picpay.desafio.android.domain.User
import com.picpay.desafio.android.presentation.userlist.adapter.UserListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : Fragment() {

    private val binding: FragmentUserListBinding by lazy { FragmentUserListBinding.inflate(layoutInflater) }
//    private val adapter: UserListAdapter by lazy { UserListAdapter() }
    private val viewModel: UserListViewModel by viewModel()
    private val actionBar: ActionBar? by lazy {
        (requireActivity() as AppCompatActivity?)?.supportActionBar
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        actionBar?.title = "Contatinhos"

        viewModel.getUserList()
        viewModel.userList.observe(viewLifecycleOwner) { state ->
            when (state) {
                UserUiState.Loading -> showLoading()
                is UserUiState.Success -> showContent(state.users)
                is UserUiState.Error -> showError(state.error)
            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun showLoading() {
//        binding.userListContentGroup.visibility = View.GONE
        binding.userListProgressBar.visibility = View.VISIBLE
        binding.userListErrorMessage.visibility = View.GONE
    }

    private fun showContent(users: List<User>) {
//        binding.userListRecyclerview.adapter = adapter
//        adapter.submitList(users)
        with(binding.userListRecyclerview) {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            setHasFixedSize(true)
            adapter = UserListAdapter(users)
        }

//        binding.userListContentGroup.visibility = View.VISIBLE
        binding.userListProgressBar.visibility = View.GONE
        binding.userListErrorMessage.visibility = View.GONE
    }

    private fun showError(error: String?) {
        with(binding) {
            error?.let { userListErrorMessage.text = getString(R.string.error) }
            userListErrorMessage.visibility = View.VISIBLE
//            userListContentGroup.visibility = View.GONE
            userListProgressBar.visibility = View.GONE
        }
    }

}