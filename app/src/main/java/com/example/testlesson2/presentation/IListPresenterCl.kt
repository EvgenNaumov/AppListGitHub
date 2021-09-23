package com.example.testlesson2.presentation

import com.example.testlesson2.view.IItemView

//интерфейс отображения элемента списка
interface IListPresenterCl<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int

}