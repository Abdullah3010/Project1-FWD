package com.example.shoestore


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShoeModel (
    var id: Int = 0,
    var name: String = "",
    var company: String = "",
    var size: Double = 0.0,
    var description: String = "",
): Parcelable{
    fun clear(){
        name = ""
        company = ""
        size = 0.0
        description = ""
    }

    fun increment(){
        id +=1
    }
}