package com.example.testlesson2

import com.example.testlesson2.model.GitHubUser
import com.example.testlesson2.model.GitHubUsersRepo
import com.example.testlesson2.presentation.IUserListPresenter
import com.example.testlesson2.view.UserItemView
import moxy.MvpPresenter

class MainPresenter(val repo: GitHubUsersRepo):MvpPresenter<MainView>() {
}