package com.android.uas.septiannugraha.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.uas.septiannugraha.DataResponse
import com.android.uas.septiannugraha.R


class CountryAdapter(
    private val list: ArrayList<DataResponse>,
    private val clickListener:(DataResponse) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_all_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as CountryViewHolder
        viewHolder.bind(list[position], clickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}