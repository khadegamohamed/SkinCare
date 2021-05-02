package com.example.skincare.ui.main

import android.os.Parcel
import android.os.Parcelable

data class Market( val img :Int , val  tex1 :String , val text2:String)  {
    override fun toString(): String {
        return "$img ,$tex1 , $text2"
    }

}