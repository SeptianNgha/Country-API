package com.android.uas.septiannugraha.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.uas.septiannugraha.DataResponse
import com.android.uas.septiannugraha.databinding.ItemAllCountryBinding


class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private val binding = ItemAllCountryBinding.bind(itemView)

    fun bind(dataResponse: DataResponse,
             clickListener: (DataResponse) -> Unit){
        with(binding){

            val text1 =  "${dataResponse.name.common}"
            val text2 =  "${dataResponse.name.official}"
            val capital = "${dataResponse.capital}"

            binding.tvName1.text = text1
            binding.tvName2.text = text2

            itemView.setOnClickListener {
                clickListener(dataResponse)
            }
        }


    }
}