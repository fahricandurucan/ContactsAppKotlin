package com.example.contactsapp_kotlin.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsapp_kotlin.R
import com.example.contactsapp_kotlin.data.model.Contacts
import com.example.contactsapp_kotlin.databinding.FragmentHomePageBinding
import com.example.contactsapp_kotlin.ui.adapter.ContactsAdapter

class HomePageFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding : FragmentHomePageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page, container, false)

        binding.toolbarHomePage.title = "Contacts"

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHomePage)


        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        val contactList = ArrayList<Contacts>()
        val c1 = Contacts(1,"Fahrican","05363878956")
        val c2 = Contacts(2,"Simge","05519560101")
        val c3 = Contacts(3,"Alya","05481287557")

        contactList.add(c1)
        contactList.add(c2)
        contactList.add(c3)

        val adapter = ContactsAdapter(requireContext(),contactList)
        binding.rv.adapter = adapter



        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                //toolbar menu yu buraya tanıtıyorıux
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomePageFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner, Lifecycle.State.RESUMED)  //search iconu kopyalanmasın diye yazdık







        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toAddContact)
        }


        return binding.root
    }

    override fun onQueryTextSubmit(query: String): Boolean { //arama buonuna basıldığında
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean { //harf girdikçe ve sildikçe
        search(newText)
        return true
    }


    fun search(search:String){
        Log.e("SEARCH","$search")
    }


}