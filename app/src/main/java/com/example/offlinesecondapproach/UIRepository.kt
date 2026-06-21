package com.example.offlinesecondapproach

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UIRepository @Inject constructor(
    private val apiService : ApiService,
    private val userDao: UserDao
) {

    fun getUsers() : Flow<List<UserEntity>> = userDao.getAllUsers()

    suspend fun refreshUsers() {
        try {
            val users = apiService.getUsers()
            userDao.clearAll()
            userDao.insertAll(users.map {it.toEntity()})
        } catch (e: Exception) {

        }
    }
}