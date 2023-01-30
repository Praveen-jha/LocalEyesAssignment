package com.mr_praveen_jha_.localeyesassignment.adapters

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mr_praveen_jha_.localeyesassignment.R
import com.mr_praveen_jha_.localeyesassignment.activities.ChatActivity
import com.mr_praveen_jha_.localeyesassignment.databinding.ChatUserItemLayoutBinding
import com.mr_praveen_jha_.localeyesassignment.model.UserModel

class ChatAdapter(val context: Context, var list: ArrayList<UserModel>) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(view:View): RecyclerView.ViewHolder(view){
        var binding :ChatUserItemLayoutBinding = ChatUserItemLayoutBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.chat_user_item_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        var user = list[position]
        Glide.with(context).load(user.imageUrl).into(holder.binding.userImage)
        holder.binding.userName.text  = user.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context,ChatActivity::class.java)
            intent.putExtra("uid",user.uid)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}