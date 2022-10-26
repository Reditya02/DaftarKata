package com.example.daftarkata.view.listword

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.daftarkata.databinding.CardBinding


class WordAdapter(
    private val listItem: ArrayList<String>,
    private val onClick: (String) -> Unit?
) : Adapter<WordAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = CardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item =  listItem[position]

        holder.binding.apply {
            label.text = item

            cardLetter.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    class Holder(val binding: CardBinding) : ViewHolder(binding.root)
}