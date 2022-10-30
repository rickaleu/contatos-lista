package com.picpay.desafio.android.presentation.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.picpay.desafio.android.databinding.FragmentUserListBinding
import com.picpay.desafio.android.domain.User
import com.picpay.desafio.android.presentation.userlist.adapter.UserListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : Fragment() {

    private val binding: FragmentUserListBinding by lazy { FragmentUserListBinding.inflate(layoutInflater) }
    private val adapter: UserListAdapter by lazy { UserListAdapter() }
    private val viewModel: UserListViewModel by viewModel()
    private val actionBar: ActionBar? by lazy {
        (requireActivity() as AppCompatActivity?)?.supportActionBar
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        actionBar?.title = "Contatinhos"

//        viewModel.getAllLaunches()
//        viewModel.state.observe(viewLifecycleOwner) { state ->
//            when (state) {
//                HomeUiState.Loading -> showLoading()
//                is HomeUiState.Success -> showContent(state.launches)
//                is HomeUiState.Error -> showError(state.error)
//            }
//        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun showLoading() {
        with(binding) {
//            contentGroup.isVisible = false
            binding.userListProgressBar.visibility = View.VISIBLE
//            errorContent.isVisible = false
        }
    }

    private fun showContent(users: List<User>) {
        binding.userListRecyclerview.adapter = adapter
        adapter.submitList(users)
//        binding.contentGroup.isVisible = true
        binding.userListProgressBar.visibility = View.GONE
//        binding.errorContent.isVisible = false
    }

}