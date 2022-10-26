package com.example.daftarkata.view.listletter

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarkata.data.Data.letterData
import com.example.daftarkata.R

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var list: ArrayList<String> = arrayListOf()

    private var isList = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)

        list.clear()
        letterData.keys.forEach {
            list.add(it)
        }

        showRecycler()
    }

    private fun showRecycler() {
        recyclerView.apply {
            layoutManager = if (isList)
                LinearLayoutManager(context)
            else
                GridLayoutManager(context, 3)
            adapter = LetterAdapter(
                listItem = list,
                onClick = {
                    val toListLetterFragment = HomeFragmentDirections.actionHomeFragmentToListLetterFragment()
                    toListLetterFragment.letter = it
                    findNavController().navigate(toListLetterFragment)
                }
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.change_recycler) {
            isList = !isList
            showRecycler()
        }
        return true
    }
}