package com.ankittlabs.theparcelize.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.ankittlabs.theparcelize.R
import com.ankittlabs.theparcelize.model.User

class UserFragment : Fragment() {

    private var editUserName: EditText? = null
    private var editUserNumber: EditText? = null
    private var buttonSave: Button? = null

    private var userName: String? = null
    private var userId: Int? = null

    companion object {
        var KEY_PARSE_DATA: String = "com.ankittlabs.theparcelize.fragment.UserFragment"
        fun newInstance(): UserFragment {
            return UserFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_user,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editUserName = view.findViewById(R.id.edit_user_name)
        editUserNumber = view.findViewById(R.id.edit_number)
        buttonSave = view.findViewById(R.id.buttonSave)
        buttonSave?.setOnClickListener {
            userName = editUserName?.text.toString()
            userId = editUserNumber?.text.toString().toInt()
            val user: User = User(userName!!, userId!!)
            val displayFragment = DisplayFragment()
            val bundle = Bundle()
            bundle.putParcelable(KEY_PARSE_DATA, user)
            displayFragment.arguments= bundle
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment_container_view,displayFragment)
                commit()
            }
        }
    }
}