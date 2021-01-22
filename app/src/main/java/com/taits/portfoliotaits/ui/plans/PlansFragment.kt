package com.taits.portfoliotaits.ui.plans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.taits.portfoliotaits.MainActivity
import com.taits.portfoliotaits.R
import kotlinx.android.synthetic.main.app_bar_main.*

class PlansFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_plans, container, false)
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity?)!!.setNavItemChecked(R.id.nav_plans)
        (activity as MainActivity?)!!.supportActionBar?.title = "Мои планы"
    }

    companion object {
        fun newInstance(): PlansFragment {
            return PlansFragment()
        }
    }
}