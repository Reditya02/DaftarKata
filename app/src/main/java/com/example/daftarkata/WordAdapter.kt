package com.example.daftarkata

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarkata.databinding.CardBinding

class WordAdapter(
    private val listItem: ArrayList<String>,
    private val setSelectedWord: (String) -> Unit,
    private val onClick: () -> Unit
) : RecyclerView.Adapter<WordAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = CardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item =  listItem[position]

        holder.binding.apply {
            label.text = item

            cardLetter.setOnClickListener {
                setSelectedWord(item)
                onClick()
            }
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    class Holder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root)
}