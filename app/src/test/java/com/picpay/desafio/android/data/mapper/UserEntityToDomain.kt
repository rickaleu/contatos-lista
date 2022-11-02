package com.picpay.desafio.android.data.mapper

import com.picpay.desafio.android.getDomainUserListStub
import com.picpay.desafio.android.getDomainUserStub
import com.picpay.desafio.android.getEntityUserListStub
import com.picpay.desafio.android.getEntityUserStub
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test

class UserEntityToDomainKtTest {

    @Test
    fun `toDomain should return list from entity user to domain one`() {
        // Given
        val entityList = getEntityUserListStub()
        val expectedDomainList = getDomainUserListStub()

        // When
        val domainList = entityList.toDomain()

        // Then
        Assert.assertNotSame(entityList, domainList)
        assertEquals(expectedDomainList, domainList)
    }

    @Test
    fun `toDomain should return an object from entity user to domain one`() {
        // Given
        val entityUser = getEntityUserStub()
        val expectedDomainObject = getDomainUserStub()

        // When
        val domainUser = entityUser.toDomain()

        // Then
        Assert.assertNotSame(entityUser, domainUser)
        assertEquals(expectedDomainObject, domainUser)
    }

    @Test
    fun `toEntity should return list from domain user to entity one`() {
        // Given
        val domainList = getDomainUserListStub()
        val expectedEntityList = getEntityUserListStub()

        // When
        val entityList = domainList.toEntity()

        // Then
        Assert.assertNotSame(domainList, entityList)
        assertEquals(expectedEntityList, entityList)
    }

    @Test
    fun `toEntity should return an object from domain user to entity one`() {
        // Given
        val domainUser = getDomainUserStub()
        val expectedEntityObject = getEntityUserStub()

        // When
        val entityUser = domainUser.toEntity()

        // Then
        Assert.assertNotSame(domainUser, entityUser)
        assertEquals(expectedEntityObject, entityUser)
    }
}