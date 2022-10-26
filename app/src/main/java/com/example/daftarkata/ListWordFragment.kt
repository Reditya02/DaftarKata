package com.example.daftarkata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarkata.Data.letterData

class ListWordFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    private var list: ArrayList<String> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedWord = (activity as MainActivity).getSelectedWord()

        recyclerView = view.findViewById(R.id.recycler_view)
        letterData[selectedWord]?.forEach {
            list.add(it)
        }
        showRecycler()
    }

    private fun showRecycler() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = WordAdapter(
                listItem =  list,
                onClick = {
                    (activity as MainActivity).onLetterClick(it)
                }
            )
        }
    }

}