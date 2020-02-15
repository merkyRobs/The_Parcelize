package com.ankittlabs.theparcelize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import com.ankittlabs.theparcelize.fragment.UserFragment

class ParcelActivity : AppCompatActivity() {

    private var actionBar:ActionBar?=null;
    private var toolbar:Toolbar?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container_view, UserFragment.newInstance())
            commit()
        }
    }

    private fun initUI() {
        toolbar= findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        actionBar?.title=getString(R.string.app_name)
    }
}
