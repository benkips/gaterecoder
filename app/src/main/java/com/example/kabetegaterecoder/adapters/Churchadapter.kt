package com.example.kabetegaterecoder.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kabetegaterecoder.Models.MyRecordResponse
import com.example.kabetegaterecoder.databinding.UrlinfBinding



class Churchadapter(private val churches: List<MyRecordResponse>) :
    RecyclerView.Adapter<Churchadapter.Churchholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Churchholder {

        val binding = UrlinfBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return Churchholder(binding)

    }

    override fun getItemCount(): Int {
        var itemCount: Int = churches.size
        return itemCount
    }

    override fun onBindViewHolder(holder: Churchholder, position: Int) {
        val currentitem = churches[position];
        if (currentitem != null) {
            holder.bind(currentitem)
        }
    }



    inner class Churchholder(val binding: UrlinfBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(urldata: MyRecordResponse) {
            binding.apply {
                fname.text = urldata.data[0].date
                fcount.text = urldata.data[0].records.toString()
            }
            }

        }
    }



