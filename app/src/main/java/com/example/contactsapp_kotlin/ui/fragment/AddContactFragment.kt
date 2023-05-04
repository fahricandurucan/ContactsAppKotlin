package com.example.contactsapp_kotlin.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.contactsapp_kotlin.R
import com.example.contactsapp_kotlin.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment() {
    private lateinit var binding : FragmentAddContactBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_contact, container, false)

        binding.toolbarAddContact.title = "New Contact"

        binding.buttonAddContact.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val phoneNumber = binding.editTextPhoneNumber.text.toString()
            saveNewContact(name,phoneNumber)

        }

        return binding.root
    }

    fun saveNewContact(name:String,phoneNumber:String){
        Log.e("NEW CONTACT","$name - $phoneNumber")
    }

}