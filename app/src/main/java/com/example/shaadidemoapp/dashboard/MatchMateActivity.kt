package com.example.shaadidemoapp.dashboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shaadidemoapp.ApplicationClass
import com.example.shaadidemoapp.R
import com.example.shaadidemoapp.dashboard.viewModel.MatchProfileViewModel
import com.example.shaadidemoapp.dashboard.viewModel.MatchProfileViewModelFactory
import com.example.shaadidemoapp.databinding.ActivityMatchMateBinding
import com.practice.demo.profileMatch.MatchProfileContract
import render.animations.Render

class MatchMateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMatchMateBinding
    lateinit var matchProfileViewModel: MatchProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_mate)

        val repository = (application as ApplicationClass).mainRepository

        matchProfileViewModel =
            ViewModelProvider(this, MatchProfileViewModelFactory(repository)).get(
                MatchProfileViewModel::class.java
            )

        binding.rvMatches.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        var render = Render(this)

        val adapter = MatchMateAdapter(
            profileEntityList = null,
            context = this@MatchMateActivity,
            render,
            object : MatchMateAdapter.BtnClickListener {
                override fun onAcceptClicked(
                    uuid: String,
                    status: MatchProfileContract.InteractionStatus
                ) {
                    matchProfileViewModel.updateInteraction(uuid, status)
                }

                override fun onDeclineClicked(
                    uuid: String,
                    status: MatchProfileContract.InteractionStatus
                ) {
                    matchProfileViewModel.updateInteraction(uuid, status)
                }

            })
        matchProfileViewModel.matches.observe(this, Observer {
            adapter.updateData(it)
        })
        binding.rvMatches.adapter = adapter
    }
}