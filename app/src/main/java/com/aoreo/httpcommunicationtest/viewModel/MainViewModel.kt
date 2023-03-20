package com.aoreo.httpcommunicationtest.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aoreo.httpcommunicationtest.api.MyApi
import com.aoreo.httpcommunicationtest.api.RetrofitInstance
import com.aoreo.httpcommunicationtest.model.Post
import kotlinx.coroutines.launch
import retrofit2.create

class MainViewModel : ViewModel() {

    private val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)

    private var _mutableWord1 = MutableLiveData<String>()
    val liveWord1 : LiveData<String>
        get() = _mutableWord1

    private var _mutableWord2 = MutableLiveData<String>()
    val liveWord2 : LiveData<String>
        get() = _mutableWord2

    private var _mutableWordList = MutableLiveData<List<Post>>()
    val liveWordList : LiveData<List<Post>>
    get() = _mutableWordList

    fun getPost1() = viewModelScope.launch {
        val post = retrofitInstance.getPost1()
        Log.d("MainViewModel",post.toString())
        _mutableWord1.value=post.title
    }

    fun getPostNumber(number :Int) = viewModelScope.launch{
        val postNumber = retrofitInstance.getPostNumber(number)
        Log.d("MainViewModel",postNumber.toString())
        _mutableWord2.value=postNumber.title
    }

    fun getPostAll() = viewModelScope.launch {
        val postAll = retrofitInstance.getPostAll()
        Log.d("MainViewModel",postAll.toString())
        _mutableWordList.value= postAll
    }
}