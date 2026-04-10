package com.ucc.itdept

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StaffAdapter(private val staffList: List<Staff>) :
    RecyclerView.Adapter<StaffAdapter.StaffViewHolder>() {

    class StaffViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.staffPhoto)
        val name: TextView = itemView.findViewById(R.id.staffName)
        val title: TextView = itemView.findViewById(R.id.staffTitle)
        val phone: TextView = itemView.findViewById(R.id.staffPhone)
        val email: TextView = itemView.findViewById(R.id.staffEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaffViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_staff, parent, false)
        return StaffViewHolder(view)
    }

    override fun onBindViewHolder(holder: StaffViewHolder, position: Int) {
        val staff = staffList[position]
        holder.name.text = staff.name
        holder.title.text = staff.title
        holder.phone.text = staff.phone
        holder.email.text = staff.email
        holder.photo.setImageResource(staff.photoResId)

        // Tap phone number to call
        holder.phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${staff.phone}"))
            holder.itemView.context.startActivity(intent)
        }

        // Tap email to send email
        holder.email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${staff.email}")
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = staffList.size
}