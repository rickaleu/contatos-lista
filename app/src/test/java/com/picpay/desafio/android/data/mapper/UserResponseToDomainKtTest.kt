package com.picpay.desafio.android.data.mapper

import com.picpay.desafio.android.data.mapper.toDomain
import com.picpay.desafio.android.getDomainUserListStub
import com.picpay.desafio.android.getResponseUserListStub
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test

class UserResponseToDomainKtTest {

    @Test
    fun `toDomain should return list from response user to domain one`() {
        // Given
        val responseList = getResponseUserListStub()

        // When
        val domainList = responseList.toDomain()

        // Then
        Assert.assertNotSame(responseList, domainList)
    }

    @Test
    fun `toDomain should mapping from user response to domain one`() {
        // Given
        val responseList = getResponseUserListStub()
        val domainList = getDomainUserListStub()

        // When
        val result = responseList.toDomain()

        // Then
        assertEquals(domainList, result)
    }
}