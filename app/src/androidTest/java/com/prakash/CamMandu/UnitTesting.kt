package com.prakash.CamMandu

import com.prakash.CamMandu.api.ServiceBuilder
import com.prakash.CamMandu.entity.User
import com.prakash.CamMandu.repository.CartRepository
import com.prakash.CamMandu.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class UnitTesting {


    private lateinit var userRepository: UserRepository
    private lateinit var postRepository: CartRepository
    @Test
    fun checkLogin() = runBlocking {
        userRepository = UserRepository()
        val response = userRepository.checkUser("rawal@gmail.com", "asdf")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun checkSignup() = runBlocking {
        val user = User(user_contactno = "9808460444",user_email = "rawal@gmail.com",user_username = "prakash",user_password = "asdf")
        userRepository = UserRepository()
        val response = userRepository.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun deleteCart() = runBlocking {
        postRepository = CartRepository()
        userRepository = UserRepository()
        ServiceBuilder.token ="Bearer " + userRepository.checkUser("rawal@gmail.com","asdf").token
        val response = postRepository.deleteCart("607c61e7385cea3078d72946c",ServiceBuilder.token!!)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }











}