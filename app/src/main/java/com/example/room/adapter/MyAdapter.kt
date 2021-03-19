package com.example.room.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.database.User

class MyAdapter(
    private val context: Context,
    private var userList: List<User>,
    private val listener: ClickListener
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.single_item, parent, false)
        )
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user: User = userList[position]
        holder.name.text = user.name
        holder.email.text = user.email
        holder.item.setOnClickListener {
            listener.onClick(user)
        }
    }

    fun setData(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.item_name)
        var email: TextView = itemView.findViewById(R.id.item_email)
        var item: CardView = itemView.findViewById(R.id.item)
    }

}