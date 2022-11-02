package com.picpay.desafio.android.data.datasource

import app.cash.turbine.test
import com.picpay.desafio.android.data.datasource.UserListDataSourceImpl
import com.picpay.desafio.android.data.datasource.local.LocalDataSource
import com.picpay.desafio.android.data.datasource.remote.RemoteDataSource
import com.picpay.desafio.android.getEntityUserListStub
import com.picpay.desafio.android.getResponseUserListStub
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
class UserListDataSourceImplTest {

    private val remoteDataSourceMock = mockk<RemoteDataSource>(relaxed = true)
    private val localDataSourceMock = mockk<LocalDataSource>()
    private val target = UserListDataSourceImpl(remoteDataSourceMock, localDataSourceMock)

    @Test
    fun `when getAllUsers returns success should emit a user response list`() = runBlocking {
        // Given
        val expectedObject = getResponseUserListStub()
        every { remoteDataSourceMock.getAllUsers() } returns flowOf(expectedObject)

        // When
        val result = target.getAllUsers()

        // Then
        result.collect { assertEquals(expectedObject, it) }
    }

    @Test
    fun `when remoteDataSource returns error getAllUsers should emit an exception`() = runBlocking {
        // Given
        val expectedThrowable = Exception("Generic Error")
        coEvery { remoteDataSourceMock.getAllUsers() } returns flow { throw expectedThrowable }

        // When
        val result = target.getAllUsers()

        // Then
        result.test { Assert.assertSame(expectedThrowable, awaitError()) }
    }

    @Test
    fun `when getLocalUsers returns success should emit a user entity list`() = runBlocking {
        // Given
        val expectedObject = getEntityUserListStub()
        every { localDataSourceMock.getAllLocalUsers() } returns flowOf(expectedObject)

        // When
        val result = target.getAllLocalUsers()

        // Then
        result.collect { assertEquals(expectedObject, it) }
    }

    @Test
    fun `when localDataSource returns error getLocalUsers should emit an exception`() = runBlocking {
        // Given
        val expectedThrowable = Exception("Generic Error")
        coEvery { localDataSourceMock.getAllLocalUsers() } returns flow { throw expectedThrowable }

        // When
        val result = target.getAllLocalUsers()

        // Then
        result.test { Assert.assertSame(expectedThrowable, awaitError()) }
    }
}