package com.example.testlesson2

import com.example.testlesson2.model.GitHubUser
import com.example.testlesson2.model.GitHubUsersRepo
import com.example.testlesson2.presentation.IUserListPresenter
import com.example.testlesson2.view.UserItemView
import moxy.MvpPresenter

class MainPresenter(val repo: GitHubUsersRepo):MvpPresenter<MainView>() {
    class UserListPresenter:IUserListPresenter{

        val users = mutableListOf<GitHubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)?=null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount(): Int = users.size
    }

    val userListPresenter = UserListPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        userListPresenter.itemClickListener = {itemView ->

        }

    }

    private fun loadData() {
        val users = repo.getUsers()
        userListPresenter.users.addAll(users)
        viewState.updateList()
    }
}