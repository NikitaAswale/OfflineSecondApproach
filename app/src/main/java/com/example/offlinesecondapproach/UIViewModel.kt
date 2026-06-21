package com.example.offlinesecondapproach

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class UIViewModel @Inject constructor(
    private val repository : UIRepository
): ViewModel(){

    private val _user = MutableStateFlow<List<UserEntity>>(emptyList())
    val user : StateFlow<List<UserEntity>> = _user.asStateFlow()

    init {
        observeValue()
        refresh()
    }

    private fun observeValue(){
        viewModelScope.launch {
            repository.getUsers().collect { user ->
                _user.value = user

            }
        }
    }

    private fun refresh(){
        viewModelScope.launch {
            repository.refreshUsers()
        }

    }
}
