package com.example.testlesson2.presentation

import com.example.testlesson2.model.GitHubUser
import com.example.testlesson2.model.GitHubUsersRepo
import com.example.testlesson2.ui.UsersView
import com.example.testlesson2.view.UserItemView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(val usersRepo: GitHubUsersRepo, val router: Router):MvpPresenter<UsersView>() {
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
        val users = usersRepo.getUsers()
        userListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed():Boolean{
        router.exit()
        return true
    }
}