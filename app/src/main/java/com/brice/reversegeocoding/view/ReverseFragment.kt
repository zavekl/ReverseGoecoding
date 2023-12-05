package com.brice.reversegeocoding.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brice.reversegeocoding.R

/**
 * A simple [Fragment] subclass.
 * Use the [ReverseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReverseFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reverse, container, false)
    }

    companion object {
        fun newInstance(): ReverseFragment {
            return ReverseFragment()
        }
    }
}