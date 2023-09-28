package com.example.myapp_submission

import android.content.ClipData.Item
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapp_submission.databinding.ActivityKarakterDetailBinding
import com.example.myapp_submission.databinding.ItemRowKarakterBinding

class ListKarakterAdapter(private val listKarakter: ArrayList<Karakter>) : RecyclerView.Adapter<ListKarakterAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemRowKarakterBinding) : RecyclerView.ViewHolder(binding.root)

    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnItemClickCallBack(onItemClickCallback:OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback{
        fun onItemClicked(data:Karakter)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowKarakterBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listKarakter.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,status , photo) = listKarakter[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = status
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, KarakterDetailActivity::class.java)
            intentDetail.putExtra("key_karakter", listKarakter[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

}