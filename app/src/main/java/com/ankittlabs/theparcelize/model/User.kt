package com.ankittlabs.theparcelize.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val userName:String, val userId:Int):Parcelable