package com.brice.reversegeocoding.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import com.brice.reversegeocoding.R
import com.brice.reversegeocoding.model.LocationResult
import com.brice.reversegeocoding.utils.KeyboardUtils
import com.brice.reversegeocoding.viewmodel.ForwardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForwardFragment : Fragment() {
    private lateinit var etAddress: EditText
    private lateinit var bConfirm: Button
    private lateinit var tvResult: TextView

    private val forwardViewModel: ForwardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_forward, container, false)

        etAddress = view.findViewById(R.id.et_address)
        bConfirm = view.findViewById(R.id.b_forward_confirm)
        tvResult = view.findViewById(R.id.tv_forward_result)

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
            if (!etAddress.text.isNullOrEmpty()) {
                forwardViewModel.searchForwardLocation(
                    etAddress.text.toString(),
                    "6a2eb36e55d3ee824df90e2f8f77dbc0"
                )
                    .subscribe(
                        { result ->
                            Log.d("test", "manageButtonConfirm: $result")
                            if (!result.results.isNullOrEmpty()) {
                                val location: LocationResult = result.results.first()
                                Log.d("test", "manageButtonConfirm: " + location)
                                requireActivity().runOnUiThread {
                                    tvResult.text =
                                        "Latitude : ${location.geometry?.location?.lat}, Longitude : ${location.geometry?.location?.lng}"
                                    Log.d("reverse result", "Latitude : ${location.geometry?.location?.lat}, Longitude : ${location.geometry?.location?.lng}")
                                }
                            } else {
                                requireActivity().runOnUiThread {
                                    Log.d("reverse result", "Aucun résultat")
                                    tvResult.text = getString(R.string.no_result)
                                }
                            }
                        }, { error ->
                            requireActivity().runOnUiThread {
                                tvResult.text = getString(R.string.no_result)
                            }
                            Log.e("ERROR", "GEOKEO ERROR ",error )
                        }

                    )
            } else {
                Toast.makeText(requireContext(), "L'adresse est vide", LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance(): ForwardFragment {
            return ForwardFragment()
        }
    }
}