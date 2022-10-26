package com.example.daftarkata

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        return inflater.inflate(R.layout.fragment_list_letter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedWord = ListWordFragmentArgs.fromBundle(arguments as Bundle).letter

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
                    onWordClick(it)
                }
            )
        }
    }

    fun onWordClick(word: String?) {
        val url = "https://www.google.com/search?q=$word"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

}