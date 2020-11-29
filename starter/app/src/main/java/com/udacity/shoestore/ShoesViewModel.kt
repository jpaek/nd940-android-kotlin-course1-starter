package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel(){

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    init {
        _shoes.value = emptyList()
    }

    fun onSave(name: String, company: String, size: String, description: String) {
        _shoes.value = _shoes.value?.plus(Shoe(name, size.toDouble(), company, description))
    }

}