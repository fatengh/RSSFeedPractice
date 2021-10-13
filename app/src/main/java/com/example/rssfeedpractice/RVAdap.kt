package com.example.rssfeedpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdap(val result: MutableList<Question>?) : RecyclerView.Adapter<RVAdap.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row, parent, false
            )
        )

    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val question = result!![position]

        holder.itemView.apply {
            tvTitle.text = "َQuestion: ${question.title}"
            cardview.setOnClickListener {
                Toast.makeText(context, "written by :${question.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = result!!.size

}