package com.example.contactsapp_kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp_kotlin.R
import com.example.contactsapp_kotlin.data.model.Contacts
import com.example.contactsapp_kotlin.databinding.ContactListItemBinding
import com.example.contactsapp_kotlin.ui.fragment.HomePageFragmentDirections

class ContactsAdapter(var mContext:Context,var contactsList:List<Contacts>)
    : RecyclerView.Adapter<ContactsAdapter.ContactListItemHolder>() {

    inner class ContactListItemHolder(var binding:ContactListItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListItemHolder {
        val binding : ContactListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.contact_list_item,parent,false)
        return ContactListItemHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: ContactListItemHolder, position: Int) {
        val contact = contactsList.get(position)
        val t = holder.binding
        t.textViewInfo.text = "${contact.name} - ${contact.phoneNumber}"
        t.textViewLetter.text = "${contact.name.get(0).toUpperCase()}"

        t.cardViewContact.setOnClickListener {
            val gecis = HomePageFragmentDirections.toDetailPage(contact=contact)
            Navigation.findNavController(it).navigate(gecis)
        }
    }
}