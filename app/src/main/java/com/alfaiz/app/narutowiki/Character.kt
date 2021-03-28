package com.alfaiz.app.narutowiki
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize

data class Character(
    val image: String = "",
    val name: String = "",
    val team: String = "",
    val detail: String = "",
):Parcelable