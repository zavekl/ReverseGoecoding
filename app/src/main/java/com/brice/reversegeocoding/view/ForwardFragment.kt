package com.brice.reversegeocoding.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brice.reversegeocoding.R

/**
 * A simple [Fragment] subclass.
 * Use the [ForwardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForwardFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forward, container, false)
    }

    companion object {
        fun newInstance(): ForwardFragment {
            return ForwardFragment()
        }
    }
}