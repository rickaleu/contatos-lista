package com.picpay.desafio.android.domain.usecase

import app.cash.turbine.test
import com.picpay.desafio.android.data.repository.UserListRepository
import com.picpay.desafio.android.getDomainUserListStub
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
class GetAllRemoteUsersUseCaseTest {

    private val repositoryMock = mockk<UserListRepository>()
    private val useCase = GetAllRemoteUsersUseCase(repositoryMock)

    @Test
    fun `when repository returns success useCase should emit a list of domain user`() = runBlocking {
        // Given
        val domainList = getDomainUserListStub()
        coEvery { repositoryMock.getAllUsers() } returns flowOf(domainList)

        // When
        val result = useCase()

        // Then
        result.test {
            assertEquals(domainList, awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `when repository returns error useCase should emit exception`() = runBlocking {
        // Given
        val expectedThrowable = Exception("Generic Error")
        coEvery { repositoryMock.getAllUsers() } returns flow { throw expectedThrowable }

        // When
        val result = useCase()

        // Then
        result.test { Assert.assertSame(expectedThrowable, awaitError()) }
    }
}