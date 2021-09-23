package com.example.testlesson2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
//@Parcelize требует, чтобы все сериализованные свойства были объявлены в основном конструкторе.
//Плагин выдает предупреждение для каждого свойства с полем поддержки, объявленным в теле класса.
// Кроме того, вы не можете применить @Parcelize, если некоторые из основных параметров конструктора не являются свойствами.
@Parcelize
data class GitHubUser(val login: String):Parcelable {

}