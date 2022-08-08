package com.arsh

import android.R
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.arsh.databinding.CustomDialogBinding
import com.arsh.databinding.CustomdialogBinding
import com.arsh.databinding.FragmentArraylistBinding



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArraylistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArraylistFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var listFrag :MainActivity
    lateinit var binding : FragmentArraylistBinding
    var arrayList: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        listFrag = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArraylistBinding.inflate(layoutInflater)
        var adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, arrayList)
        arrayList.add("qwerty")
        arrayList.add("qwerty1")
        arrayList.add("qwerty2")
        arrayList.add("qwerty3")
        arrayList.add("qwerty4")
        binding.listItem.adapter = adapter
        binding.listItem.setOnItemClickListener { adapterView, view, i, 1 ->
            System.out.println("i $i $1")

            binding.btnFab.setOnClickListener {
                var dialogBinding = CustomDialogBinding.inflate(layoutInflater)
                var dialog = Dialog(listFrag)
                dialog.setCancelable(false)
                dialog.setContentView(dialogBinding.root)
                val layout = dialog.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                dialogBinding.btnUpdate.setOnClickListener {
                    if (dialogBinding.etUpdateItem.text.toString().isNullOrEmpty()) {
                        dialogBinding.etUpdateItem.setError("Please Add Item")
                    } else {
                        arrayList.add(dialogBinding.etUpdateItem.text.toString())
                        dialog.dismiss()
                    }
                }
                dialog.show()
            }
        }
        binding.listItem.setOnItemClickListener { adapterView, view, i, 1 ->
       System.out.println("i $i $1")
        var dialogBinding = CustomdialogBinding.inflate(layoutInflater)
        var dialog = Dialog(listFrag)
                dialog.setCancelable(false)
        dialog.setContentView(dialogBinding.root)
        val layout = dialog.window?.setLayout(

            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialogBinding.etAddItems.setText(arrayList[i])

        dialogBinding.btnOk.setOnClickListener {
            if (dialogBinding.etAddItems.text.toString().isNullOrEmpty()) {
                dialogBinding.etAddItems.setError("enter Item")
            }
            else {
                arrayList.set(i ,dialogBinding.etAddItems.text.toString())
                dialog.dismiss()
            }
        }
        dialog.show()
    }

        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ArraylistFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ArraylistFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}