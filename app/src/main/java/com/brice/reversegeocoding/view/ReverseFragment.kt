package com.brice.reversegeocoding.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.brice.reversegeocoding.R
import com.brice.reversegeocoding.model.LocationResult
import com.brice.reversegeocoding.utils.KeyboardUtils
import com.brice.reversegeocoding.viewmodel.ReverseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ReverseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReverseFragment : Fragment() {
    private val viewModel: ReverseViewModel by viewModel()
    private lateinit var etLat: AppCompatEditText
    private lateinit var etLng: AppCompatEditText
    private lateinit var bConfirm: Button
    private lateinit var tvResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reverse, container, false)
        etLat = view.findViewById(R.id.et_lat)
        etLng = view.findViewById(R.id.et_lng)
        bConfirm = view.findViewById(R.id.b_confirm)
        tvResult = view.findViewById(R.id.tv_result)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        manageButtonConfirm()
    }


    @SuppressLint("CheckResult")
    private fun manageButtonConfirm() {
        bConfirm.setOnClickListener {
            KeyboardUtils.hideKeyboard(requireActivity())
            if (!etLat.text.isNullOrEmpty() && !etLng.text.isNullOrEmpty()) {
                viewModel.searchReverseLocation(
                    etLat.text.toString().toDouble(),
                    etLng.text.toString().toDouble(),
                    "6a2eb36e55d3ee824df90e2f8f77dbc0"
                )
                    .subscribe(
                        { result ->
                            if (!result.results.isNullOrEmpty()) {
                                val location: LocationResult = result.results.first()
                                requireActivity().runOnUiThread {
                                    tvResult.text = location.formattedAddress
                                    Log.d("reverse result", location.formattedAddress!!)
                                }
                            } else {
                                requireActivity().runOnUiThread {
                                    tvResult.text = getString(R.string.no_result)
                                }
                            }
                        },
                        { error ->
                            Log.e("Error", "API GEOKEO ERROR : ", error)
                        }
                    )
            } else {
                Toast.makeText(requireContext(),"Coordonnées GPS incomplête", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance(): ReverseFragment {
            return ReverseFragment()
        }
    }
}