package com.example.nagaparkmaster.ui.parking_history;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.nagaparkmaster.databinding.FragmentParkingHistoryBinding
import com.example.nagaparkmaster.ui.parking_history.ParkingHistoryViewModel

class ParkingHistoryFragment : Fragment() {

    private var _binding: FragmentParkingHistoryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val parkingHistoryViewModel =
            ViewModelProvider(this).get(ParkingHistoryViewModel::class.java)

        _binding = FragmentParkingHistoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textParkingHistory
        parkingHistoryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}