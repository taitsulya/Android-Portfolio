package com.taits.portfoliotaits.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.taits.portfoliotaits.MainActivity
import com.taits.portfoliotaits.R

class ContactsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity?)!!.setNavItemChecked(R.id.nav_contacts)
        (activity as MainActivity?)!!.supportActionBar?.title = "Контакты"
    }

    companion object {
        fun newInstance(): ContactsFragment {
            return ContactsFragment()
        }
    }
}