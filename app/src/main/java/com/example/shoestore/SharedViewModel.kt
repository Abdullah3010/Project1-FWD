package com.example.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel :ViewModel()  {

    val shoe = ShoeModel()

    private val _onSave = MutableLiveData<Boolean>()
    val onSave :LiveData<Boolean>
    get() = _onSave


    val shoes: MutableList<ShoeModel> = mutableListOf()

    fun onSaveShoe(){
        _onSave.value = true
        shoes.add(shoe.copy())
    }

    fun onSaveShoeDone(){
        _onSave.value = false
        shoe.clear()
        shoe.increment()
    }
}