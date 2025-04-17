package edu.msudenver.cs3013.colorfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ReportFragment.Companion.reportFragment

interface ChoiceListener {

    fun onSelected(id: Int)

}

class MainActivity : AppCompatActivity(), ChoiceListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // check if this is first time app has run
        if (savedInstanceState == null) {
            val cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container)

            val choiceFragment = ChoiceFragment()

            supportFragmentManager.beginTransaction().
                add(cfv.id, choiceFragment).commit()
        }
    }

    override fun onSelected(id: Int) {
        val fcv = findViewById<FragmentContainerView>(R.id.lowerfragment_container)

        val colorFragment = ColorFragment.newInstance(id) // id: 1 for BLUE, 2 for RED

        supportFragmentManager.beginTransaction().replace(fcv.id, colorFragment).
                                addToBackStack(null).commit()
    }
}