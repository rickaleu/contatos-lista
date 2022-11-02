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
import com.picpay.desafio.android.utils.ConnectionUtils
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : Fragment() {

    private val connectionUtils: ConnectionUtils by lazy { ConnectionUtils(context) }
    private val binding: FragmentUserListBinding by lazy { FragmentUserListBinding.inflate(layoutInflater) }
    private val viewModel: UserListViewModel by viewModel()
    private val actionBar: ActionBar? by lazy { (requireActivity() as AppCompatActivity?)?.supportActionBar }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        actionBar?.title = getString(R.string.title)
        checkNetwork()

        viewModel.userListRemote.observe(viewLifecycleOwner) { state ->
            when (state) {
                RemoteUiState.Loading -> showLoading()
                is RemoteUiState.Success -> showContent(state.users)
                is RemoteUiState.Error -> showError(state.error)
            }
        }

        viewModel.userListLocal.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LocalUiState.Success -> showContent(state.users)
                is LocalUiState.Error -> showError(state.error)
            }
        }

        //Observable commented so as not to break the app
//        viewModel.state.observe(viewLifecycleOwner) {
//                state -> handlerLocalState(state)
//        }

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun showLoading() {
        binding.userListProgressBar.visibility = View.VISIBLE
        binding.userListErrorMessage.visibility = View.GONE
    }

    private fun showContent(users: List<User>?) {
        if (users.isNullOrEmpty()) {
            viewModel.getRemoteUserList()
        } else {
            with(binding.userListRecyclerview) {
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL, false
                )
                setHasFixedSize(true)

                adapter = users?.let { UserListAdapter(it) }
            }

            //Loop commented so as not to break the app
//            for (user in users) {
//                viewModel.insertLocalUser(user)
//            }
        }

        binding.userListProgressBar.visibility = View.GONE
        binding.userListErrorMessage.visibility = View.GONE
    }

    private fun showError(error: String?) {
        with(binding) {
            error?.let { userListErrorMessage.text = getString(R.string.error, it) }
            userListErrorMessage.visibility = View.VISIBLE
            userListProgressBar.visibility = View.GONE
        }
    }

    private fun checkNetwork() {
        if (!connectionUtils.isConnectionAvailable(context)) {
            viewModel.getLocalUserList()
            showError(getString(R.string.error_no_connection))
        } else {
            viewModel.getRemoteUserList()
        }
    }

    //Method commented so as not to break the app
//    private fun handlerLocalState(localState: InsertLocalState) {
//        when (localState.hasBeenInserted) {
//            true -> viewModel.getLocalUserList()
//            else -> viewModel.getRemoteUserList()
//        }
//    }
}