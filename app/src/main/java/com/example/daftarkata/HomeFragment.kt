package com.example.daftarkata

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarkata.Data.letterData

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var list: ArrayList<String> = arrayListOf()

    var isList = true

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
                setSelectedWord = {
                    (activity as MainActivity).setSelectedWord(it)
                },
                onClick = {
                    (activity as MainActivity).navigateFragment(ListWordFragment(), true)
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