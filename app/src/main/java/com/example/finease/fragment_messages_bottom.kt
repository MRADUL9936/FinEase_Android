package com.example.finease

import android.content.Context
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_messages_bottom.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_messages_bottom : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
      private lateinit var adaptor: MymessageAdaptor
      private lateinit var recyclerView: RecyclerView
      private lateinit var message:ArrayList<Message>

      lateinit var title:Array<String>
      lateinit var description: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        dataInitialize()
        val args=this.arguments
        val title = args?.getString("title")
        val desc = args?.getString("message")
        if (!title.isNullOrEmpty() && !desc.isNullOrEmpty()) {
            // Process the title and message as needed
            val msg=Message(title,desc)
            message.add(msg)
        } else {
            Log.d("FragmentMessagesBottom", "Title or description is null or empty")
        }

        return inflater.inflate(R.layout.fragment_messages_bottom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val layoutmanager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.msg_recyclerview)
        recyclerView.layoutManager = layoutmanager
        recyclerView.setHasFixedSize(true)

        adaptor = MymessageAdaptor(message)
        recyclerView.adapter = adaptor


    }


    private fun dataInitialize(){
        message= arrayListOf<Message>()

        title= arrayOf(
           getString( R.string.title_1),
            getString(R.string.title_2),
            getString(R.string.title_3),
            getString(R.string.title_4)
        )
        description= arrayOf(
            getString(R.string.desc_1),
            getString(R.string.desc_2),
            getString(R.string.desc_3),
            getString(R.string.desc_4)
        )

        for(i in title.indices){
            val msg=Message(title[i],description[i])
            message.add(msg)
        }


    }
}