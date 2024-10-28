package com.anbinh.gmaillist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: TextView = itemView.findViewById(R.id.avatar)
        val senderName: TextView = itemView.findViewById(R.id.senderName)
        val messagePreview: TextView = itemView.findViewById(R.id.messagePreview)
        val timestamp: TextView = itemView.findViewById(R.id.timestamp)
        val favoriteIcon: ImageView = itemView.findViewById(R.id.favoriteIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]
        holder.senderName.text = email.senderName
        holder.messagePreview.text = email.messagePreview
        holder.timestamp.text = email.timestamp
        holder.avatar.text = email.senderName.first().toString() // Show first letter of the sender's name

        // Set the favorite icon color based on the favorite status
        if (email.isFavorite) {
            holder.favoriteIcon.setImageResource(R.drawable.ic_star_filled)
        } else {
            holder.favoriteIcon.setImageResource(R.drawable.ic_star)
        }
    }

    override fun getItemCount(): Int = emails.size
}
