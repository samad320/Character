package com.example.apirecyclerview.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apirecyclerview.R
import com.example.apirecyclerview.activity.DetailsActivity
import com.example.apirecyclerview.model.Result
import com.squareup.picasso.Picasso

class AdapterFollowUp(
    private val context: Context,
    private val list: List<Result>,
) :
    RecyclerView.Adapter<AdapterFollowUp.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.single_row_therapy, parent, false)
        )
    }

    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvName.text = list[position].name
        holder.tvStatus.text = list[position].status
            if (list[position].image != null) {
                Picasso.get().load(list[position].image)
                    .placeholder(R.drawable.placeholder_n)
                    .error(R.drawable.error_placeholder)
                    .into(holder.imgProfile)

            }

        holder.itemView.setOnClickListener {
            val intent = Intent(context as Activity, DetailsActivity::class.java)
                .putExtra("name", list[position].name)
                .putExtra("status", list[position].status)
                .putExtra("image", list[position].image)
             context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
        val imgProfile: ImageView = itemView.findViewById(R.id.imgProfile)

    }

}