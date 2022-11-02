package com.picpay.desafio.android.data.repository

import app.cash.turbine.test
import com.picpay.desafio.android.data.datasource.UserListDataSource
import com.picpay.desafio.android.data.mapper.toDomain
import com.picpay.desafio.android.data.repository.UserListRepositoryImpl
import com.picpay.desafio.android.getEntityUserListStub
import com.picpay.desafio.android.getResponseUserListStub
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
class UserListRepositoryImplTest {

    private val datasourceMock = mockk<UserListDataSource>(relaxed = true)
    private val target = UserListRepositoryImpl(datasource = datasourceMock)

    @Test
    fun `when getAllUsers returns success should emit a user domain list`() = runBlocking {
        // Given
        val expectedObject = getResponseUserListStub()
        coEvery { datasourceMock.getAllUsers() } returns flowOf(expectedObject)

        // When
        val result = target.getAllUsers()

        // Then
        result.collect { assertEquals(expectedObject.toDomain(), it) }
    }

    @Test
    fun `when dataSource returns error getAllUsers should emit an exception`() = runBlocking {
        // Given
        val expectedThrowable = Exception("Generic Error")
        coEvery { datasourceMock.getAllUsers() } returns flow { throw expectedThrowable }

        // When
        val result = target.getAllUsers()

        // Then
        result.test { Assert.assertSame(expectedThrowable, awaitError()) }
    }

    @Test
    fun `when getLocalUsers returns success should emit a user domain list`() = runBlocking {
        // Given
        val expectedObject = getEntityUserListStub()
        coEvery { datasourceMock.getAllLocalUsers() } returns flowOf(expectedObject)

        // When
        val result = target.getAllLocalUsers()

        // Then
        result.collect { assertEquals(expectedObject.toDomain(), it) }
    }

    @Test
    fun `when dataSource returns error getLocalUsers should emit an exception`() = runBlocking {
        // Given
        val expectedThrowable = Exception("Generic Error")
        coEvery { datasourceMock.getAllLocalUsers() } returns flow { throw expectedThrowable }

        // When
        val result = target.getAllLocalUsers()

        // Then
        result.test { Assert.assertSame(expectedThrowable, awaitError()) }
    }
}