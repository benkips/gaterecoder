package com.example.kabetegaterecoder.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kabetegaterecoder.Models.MyResponse
import com.example.kabetegaterecoder.Network.Resource
import com.example.kabetegaterecoder.Repo.Repostuff
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChurchAttendanceModel @Inject constructor(private val repostuff: Repostuff) : ViewModel() {

    private val _urlzResponse: MutableLiveData<Resource<MyResponse>> = MutableLiveData()

    val urlzResponse: LiveData<Resource<MyResponse>>
        get() = _urlzResponse


    fun addrecords(
        x: String,
        y: String,
        z: String,
        q: String,
        r: String,
    ) = viewModelScope.launch {
        _urlzResponse.value = Resource.Loading
        _urlzResponse.value = repostuff.addRecords(
            x,
            y,
            z,
            q,
            r,
        )
    }



}