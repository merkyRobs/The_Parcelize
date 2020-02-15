package com.ankittlabs.theparcelize.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ankittlabs.theparcelize.R
import com.ankittlabs.theparcelize.fragment.UserFragment.Companion.KEY_PARSE_DATA
import com.ankittlabs.theparcelize.model.User

class DisplayFragment : Fragment() {

    private var textUserName: TextView? = null
    private var textUserNumber: TextView? = null

    companion object {
        fun newInstance(): DisplayFragment {
            return DisplayFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textUserName = view.findViewById(R.id.text_name)
        textUserNumber = view.findViewById(R.id.text_number)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            val users = bundle.getParcelable<User>(KEY_PARSE_DATA)
            textUserName!!.setText(users?.userName)
            textUserNumber!!.setText(users?.userId.toString())
        }
    }
}