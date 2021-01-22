package com.taits.portfoliotaits.ui.contacts

import android.content.Intent
import android.net.Uri
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
        val view = inflater.inflate(R.layout.fragment_contacts, container, false)
        val email: TextView = view.findViewById(R.id.my_email)
        email.setOnClickListener {
            val myEmail = Intent(Intent.ACTION_SEND)
            myEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf("iojibka_2000@mail.ru"))
            myEmail.putExtra(Intent.EXTRA_SUBJECT, "Job offer")
            myEmail.putExtra(Intent.EXTRA_TEXT, "Hello, Julia!")
            myEmail.type = "message/rfc822"
            startActivity(Intent.createChooser(myEmail, "Choose an Email client :"))
        }
        val phone: TextView = view.findViewById(R.id.my_phone)
        phone.setOnClickListener {
            val myPhone = Intent(Intent.ACTION_DIAL)
            myPhone.data = Uri.parse("tel:+79817477744")
            startActivity(Intent.createChooser(myPhone, "Choose a Phone client :"))
        }
        return view
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