package com.example.finease


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager


class Fragment_Report : Fragment() {

private lateinit var titleEditText: EditText
    private lateinit var messageEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment__report, container, false)
        titleEditText = view.findViewById(R.id.myEditText)
        messageEditText = view.findViewById(R.id.editText)
        submitButton = view.findViewById(R.id.btn_report)
        submitButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val message = messageEditText.text.toString()
            val fragmentB = fragment_messages_bottom()
            val bundle = Bundle()
            bundle.putString("title", title)
            bundle.putString("message", message)
            fragmentB.arguments = bundle

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fr_main, fragmentB)
                addToBackStack(null) // Optional: Adds transaction to back stack
                commit()
            }

    }
    return view
    }



}