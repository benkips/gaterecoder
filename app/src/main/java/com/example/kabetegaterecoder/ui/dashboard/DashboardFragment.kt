package com.example.kabetegaterecoder.ui.dashboard

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kabetegaterecoder.R
import com.example.kabetegaterecoder.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashboardBinding.bind(view)

        val items = listOf("Uthiru", "Muthua", "Cooperation", "Ndumbuini","87")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (binding.autxtview as? AutoCompleteTextView)?.setAdapter(adapter)

        val fullnames=binding.fnames.text
        val phone=binding.phone.text
        val age=binding.ages.text
        val residence=binding.residence.text
        val fellowship=binding.autxtview.text

        binding.addrecords.setOnClickListener {
            Toast.makeText(this.context, "$fullnames+$phone+$age+$residence+$fellowship", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this.context, "$fullnames+$phone+$age+$residence+$fellowship", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}