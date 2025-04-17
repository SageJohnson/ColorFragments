package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorFragment : Fragment() {

    private var myIndex: Int? = 0

    private val chosenColorTV: TextView?

        get() = view?.findViewById<TextView>(R.id.mycolor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // check for first time instantiation of fragment(s)
        if (arguments == null) {
            fragmentCount = 1
            myIndex = fragmentCount
        }

        if (arguments != null) {
            fragmentCount++
            myIndex = fragmentCount
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val choiceId = arguments?.getInt("COLOR CHOICE", 0) ?: 0

        val tv = view.findViewById<TextView>(R.id.mycolor)

        // set background color, write text into textview, and UID!

        if (choiceId == 1) {
            tv.setText("GENERIC BLUE FRAGMENT - UID $myIndex")
            tv.setBackgroundColor(Color.rgb(150, 150, 255))
        } else if (choiceId == 2) {
            tv.setText("GENERIC RED FRAGMENT - UID $myIndex")
            tv.setBackgroundColor(Color.rgb(255, 150, 150))
        }




    }

    companion object {
        @JvmStatic
        var fragmentCount: Int = 0

        fun get(): Int {
            return fragmentCount
        }


        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment ColorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(colorChoice: Int) =
            ColorFragment().apply {
                arguments = Bundle().apply {
                    putInt("COLOR CHOICE", colorChoice)
                }
            }
    }
}