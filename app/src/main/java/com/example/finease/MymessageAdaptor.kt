package com.example.finease

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MymessageAdaptor(private val message:ArrayList<Message>):
    RecyclerView.Adapter<MymessageAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val itemview=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent
        ,false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentText=message[position]
        holder.title.text=currentText.title
        holder.description.text=currentText.description

    }

    override fun getItemCount(): Int {
        return message.size
    }

    class MyViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
       val title=itemview.findViewById<TextView>(R.id.txt_title)
        val description=itemview.findViewById<TextView>(R.id.txt_description)
    }




}