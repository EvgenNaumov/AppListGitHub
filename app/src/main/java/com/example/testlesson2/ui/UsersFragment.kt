package com.example.testlesson2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testlesson2.App
import com.example.testlesson2.databinding.FragmentUsersBinding
import com.example.testlesson2.model.GitHubUsersRepo
import com.example.testlesson2.presentation.UsersPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView {
    private var vb: FragmentUsersBinding? = null;

    val presenter by moxyPresenter { UsersPresenter(GitHubUsersRepo(), App.instance.router) }

    private val adapter by lazy { UsersRVAdapter(presenter.userListPresenter) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentUsersBinding.inflate(inflater, container, false).also{vb = it}.root
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(requireContext())
        vb?.rvUsers?.adapter= adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

}