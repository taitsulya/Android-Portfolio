package com.taits.portfoliotaits.ui.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.taits.fifthapplication.ui.contacts.DataStorage
import com.taits.fifthapplication.ui.contacts.EducationAdapter
import com.taits.portfoliotaits.MainActivity
import com.taits.portfoliotaits.R

class EducationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_education, container, false)
        val institutions = DataStorage.getEducationList()
        val adapter = EducationAdapter(context, institutions)
        val recyclerView: RecyclerView = view.findViewById(R.id.institutions)
        recyclerView.adapter = adapter
        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity?)!!.setNavItemChecked(R.id.nav_education)
        (activity as MainActivity?)!!.supportActionBar?.title = "Моя учёба"
    }

    companion object {
        fun newInstance(): EducationFragment {
            return EducationFragment()
        }
    }
}