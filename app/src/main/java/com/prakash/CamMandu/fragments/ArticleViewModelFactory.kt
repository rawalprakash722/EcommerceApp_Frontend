package com.prakash.CamMandu.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prakash.CamMandu.repository.ArticleRepository

class ArticleViewModelFactory(val repository: ArticleRepository): ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass:Class<T>):T{
        return ArticleViewModel(repository) as T
    }
}