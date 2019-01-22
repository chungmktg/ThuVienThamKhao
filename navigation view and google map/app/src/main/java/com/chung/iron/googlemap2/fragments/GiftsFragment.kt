package com.chung.iron.googlemap2.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.chung.iron.googlemap2.R

class GiftsFragment : Fragment() {

    companion object {
        fun newInstance() = GiftsFragment()
    }

    private lateinit var viewModel: GiftsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gifts_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GiftsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
