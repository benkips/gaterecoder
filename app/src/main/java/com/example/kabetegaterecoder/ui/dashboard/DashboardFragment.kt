package com.example.kabetegaterecoder.ui.dashboard

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.kabetegaterecoder.Network.Resource
import com.example.kabetegaterecoder.R
import com.example.kabetegaterecoder.Util.handleApiError
import com.example.kabetegaterecoder.Util.visible
import com.example.kabetegaterecoder.databinding.FragmentDashboardBinding
import com.example.kabetegaterecoder.viewModel.ChurchAttendanceModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard), AdapterView.OnItemClickListener {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    var fellowship=""
    private  val viewmodel by viewModels<ChurchAttendanceModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashboardBinding.bind(view)

        val items = listOf("Uthiru", "Muthua", "Cooperation", "Ndumbuini","87","N/A")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (binding.autxtview as? AutoCompleteTextView)?.setAdapter(adapter)
        (binding.autxtview as? AutoCompleteTextView)?.onItemClickListener=this


        binding.addrecords.setOnClickListener {
            val fullnames= binding.fnames.text.toString()
            val phone=binding.phone.text.toString()
            val age=binding.ages.text.toString()
            val residence=binding.residence.text.toString()
          viewmodel.addrecords(fullnames,phone,age,residence,fellowship)
        }


        viewmodel.urlzResponse.observe(viewLifecycleOwner, Observer {
            binding.pgbar.visible(it is Resource.Loading)
            when (it) {
                is Resource.Success -> {

                }
                is Resource.Failure -> handleApiError(it) { }
                else -> {}
            }

        })
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
         fellowship= p0?.getItemAtPosition(p2).toString();
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}