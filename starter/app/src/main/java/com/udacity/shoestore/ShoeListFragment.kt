package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ShoeListFragmentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)
//        setHasOptionsMenu(true)
        binding.showDetailButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        viewModel = (activity as MainActivity).viewModel
        viewModel.shoes.observe(this, Observer { shoes ->
            //binding.linearLayout.removeAllViewsInLayout()
            shoes.forEach { shoe ->
                val textView = TextView(this.context)
                textView.text = "Name: " + shoe.name + "\nCompany: " + shoe.company +
                        "\nSize: " + shoe.size + "\nDescription: " + shoe.description
                binding.linearLayout.addView(textView)
            }
        })
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }




//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.overflow_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
//                || super.onOptionsItemSelected(item)
//    }
}