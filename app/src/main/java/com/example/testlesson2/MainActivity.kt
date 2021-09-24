package com.example.testlesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testlesson2.databinding.ActivityMainBinding
import com.example.testlesson2.model.GitHubUsersRepo
import com.example.testlesson2.ui.UsersRVAdapter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    private val presenter by moxyPresenter { MainPresenter(GitHubUsersRepo()) }
    private var _vb:ActivityMainBinding? = null;

    private val vb
        get() =_vb!!

    private val adapter by lazy { UsersRVAdapter(presenter.userListPresenter) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
    }

    override fun init() {
        vb.rvUsers.layoutManager = LinearLayoutManager(this)
        vb.rvUsers.adapter= adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }
}