package com.example.testlesson2.presentation

import com.example.testlesson2.view.IItemView
import com.example.testlesson2.view.UserItemView

//интерфейс отображения элемента списка
interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int

}

//интерфейс (презентер) для отображения списка
interface IUserListPresenter:IListPresenter<UserItemView>{

}