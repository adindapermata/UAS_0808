package com.adindapermata.github0808.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adindapermata.github0808.data.model.User
import com.adindapermata.github0808.databinding.ItemUserBinding
import com.bumptech.glide.Glide

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    private val list = ArrayList<User>()

    private var onItemClickCallBack: OnItemClickCallBack? = null

    fun setOnItemClickCallBlack (onItemClickCallBack: OnItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack
    }

    fun setList(users: ArrayList<User>){
        list.clear()
        list.addAll(users)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.root.setOnClickListener{
                onItemClickCallBack?.onItemClicked(user)
            }
            binding.apply {
                Glide.with(itemView)
                    .load(user.avatar_url)
                    .centerCrop()
                    .into(ivUser)
                tvUsername.text = user.login
                itemDescription.text = user.url
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder((view))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
    interface OnItemClickCallBack{
        fun onItemClicked(data: User)
    }
}