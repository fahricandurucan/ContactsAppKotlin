package com.example.contactsapp_kotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.contactsapp_kotlin.R
import com.example.contactsapp_kotlin.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {
    private lateinit var binding : FragmentHomePageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page, container, false)

        return binding.root
    }


}