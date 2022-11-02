package com.picpay.desafio.android.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.picpay.desafio.android.domain.usecase.GetAllLocalUsersUseCase
import com.picpay.desafio.android.domain.usecase.GetAllRemoteUsersUseCase
import com.picpay.desafio.android.getDomainUserListStub
import com.picpay.desafio.android.getOrAwaitValue
import com.picpay.desafio.android.presentation.userlist.LocalUiState
import com.picpay.desafio.android.presentation.userlist.UserListViewModel
import com.picpay.desafio.android.presentation.userlist.RemoteUiState
import com.picpay.desafio.android.utils.MainCoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val getAllRemoteUsersUseCase = mockk<GetAllRemoteUsersUseCase>(relaxed = true)
    private val getAllLocalUsersUseCase = mockk<GetAllLocalUsersUseCase>(relaxed = true)
    private val dispatcher = Dispatchers.Unconfined

    private val target = UserListViewModel(
        getAllRemoteUsersUseCase = getAllRemoteUsersUseCase,
        getAllLocalUsersUseCase = getAllLocalUsersUseCase,
        dispatcher = dispatcher
    )

    @Test
    fun `when getAllUsers returns success should trigger success state`() {
        mainCoroutineRule.runBlockingTest {}
        // Given
        val expectedResult = getDomainUserListStub()
        coEvery { getAllRemoteUsersUseCase() } returns flowOf(expectedResult)

        // When
        target.getRemoteUserList()
        val state = target.userListRemote.getOrAwaitValue()

        // Then
        assertEquals(state, RemoteUiState.Success(expectedResult))
    }

    @Test
    fun `when getAllUsers returns error should trigger error state`() {
        mainCoroutineRule.runBlockingTest {
            // Given
            val expectedError = Exception("Error")
            coEvery { getAllRemoteUsersUseCase() } returns flow { throw expectedError }

            // When
            target.getRemoteUserList()
            val state = target.userListRemote.getOrAwaitValue()

            // Then
            assertEquals(state, RemoteUiState.Error("Error"))
        }
    }

}