package com.example.kabetegaterecoder.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kabetegaterecoder.Network.Resource
import com.example.kabetegaterecoder.R
import com.example.kabetegaterecoder.Util.handleApiError
import com.example.kabetegaterecoder.Util.visible
import com.example.kabetegaterecoder.adapters.Churchadapter
import com.example.kabetegaterecoder.databinding.FragmentHomeBinding
import com.example.kabetegaterecoder.viewModel.ChurchAttendanceRecordsModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private  var _binding : FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private  val viewmodel by viewModels<ChurchAttendanceRecordsModel>()
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        _binding=FragmentHomeBinding.bind(view)

        binding.pgbar.visible(false)
        recyclerView =binding.rvpdf
        fetchingurls()
        viewmodel.urlzResponses.observe(viewLifecycleOwner, Observer {
            binding.pgbar.visible(it is Resource.Loading)
            when (it) {
                is Resource.Success -> {
                    binding.rvpdf.also {rv->
                        val llm = LinearLayoutManager(requireContext())
                        llm.orientation = LinearLayoutManager.VERTICAL
                        rv.layoutManager = llm
                        rv.setHasFixedSize(true)
                        rv.adapter= Churchadapter(it.value)
                    }

                }
                is Resource.Failure -> handleApiError(it) { fetchingurls() }

                else -> {}
            }
        })




    }
    private fun fetchingurls(){
        viewmodel.viewrecords()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}