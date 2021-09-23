package com.example.testlesson2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testlesson2.databinding.ItemUserBinding
import com.example.testlesson2.presentation.IUserListPresenter
import com.example.testlesson2.view.UserItemView

class UsersRVAdapter(val presenter: IUserListPresenter):RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)).apply {
            itemView.setOnClickListener{presenter.itemClickListener?.invoke(this)}
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class ViewHolder(val vb:ItemUserBinding): RecyclerView.ViewHolder(vb.root),UserItemView{
        override var pos: Int = -1

        override fun setLogin(text: String) {
            vb.tvLogin.text = text
        }
    }
}