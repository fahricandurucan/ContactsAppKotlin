package com.example.contactsapp_kotlin.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.contactsapp_kotlin.R
import com.example.contactsapp_kotlin.databinding.FragmentDetailPageBinding

class DetailPageFragment : Fragment() {
    private lateinit var binding: FragmentDetailPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_page, container, false)


        binding.toolbarDetailPage.title = " Contact Detail"

        val bundle : DetailPageFragmentArgs by navArgs()
        val gelenContact = bundle.contact

        binding.editTextName.setText(gelenContact.name)
        binding.editTextPhoneNumber.setText(gelenContact.phoneNumber)


        binding.button2.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val phoneNumber = binding.editTextPhoneNumber.text.toString()
            update(gelenContact.id,name,phoneNumber)
        }


        return binding.root
    }

    fun update(id:Int,name:String,phoneNumber:String){
        Log.e("UPDATED","$id - $name - $phoneNumber")
    }

}