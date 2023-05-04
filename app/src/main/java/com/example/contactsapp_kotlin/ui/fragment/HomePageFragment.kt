package com.example.contactsapp_kotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.contactsapp_kotlin.R
import com.example.contactsapp_kotlin.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {
    private lateinit var binding : FragmentHomePageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page, container, false)

        binding.toolbarHomePage.title = "Contacts"

        binding.buttonDetail.setOnClickListener {
            val contact = com.example.contactsapp_kotlin.data.model.Contacts(1,"fahrican","05364958888")
            val gecis = HomePageFragmentDirections.toDetailPage(contact = contact)
            Navigation.findNavController(it).navigate(gecis)
        }
        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toAddContact)
        }


        return binding.root
    }


}