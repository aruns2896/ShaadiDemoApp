package com.example.shaadidemoapp.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shaadidemoapp.R
import com.example.shaadidemoapp.databinding.ItemUserProfileBinding
import com.practice.demo.db.ProfileEntity
import com.practice.demo.profileMatch.MatchProfileContract

class MatchMateAdapter(
    private var profileEntityList: List<ProfileEntity>?,
    private val context: Context,
    private val btnClickListener: BtnClickListener,
) : RecyclerView.Adapter<MatchMateAdapter.MatchMateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchMateViewHolder {
        val binding = DataBindingUtil.inflate<ItemUserProfileBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_user_profile,
            parent,
            false
        )
        return MatchMateViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return profileEntityList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MatchMateViewHolder, position: Int) {
        val item = profileEntityList?.get(position)
        holder.bindData(item, context, btnClickListener)
    }

    fun updateData(list: List<ProfileEntity>){
        profileEntityList = list
        notifyDataSetChanged()
    }

    class MatchMateViewHolder(binding: ItemUserProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: ItemUserProfileBinding = binding

        fun bindData(item: ProfileEntity?, context: Context, btnClickListener: BtnClickListener) {

            val status = item?.interactionStatus
            when(status){
                MatchProfileContract.InteractionStatus.NONE, null -> {
                    binding.tvStatus.visibility = View.GONE
                    binding.btnAccept.visibility = View.VISIBLE
                    binding.btnDecline.visibility = View.VISIBLE
                }
                MatchProfileContract.InteractionStatus.ACCEPTED -> {
                    binding.tvStatus.visibility = View.VISIBLE
                    binding.btnAccept.visibility = View.GONE
                    binding.btnDecline.visibility = View.GONE
                    binding.tvStatus.text = context.getText(R.string.accepted)
                    binding.tvStatus.background = ContextCompat.getDrawable(context, R.drawable.green_rc_bg)
                }
                MatchProfileContract.InteractionStatus.DECLINED -> {
                    binding.tvStatus.visibility = View.VISIBLE
                    binding.btnAccept.visibility = View.GONE
                    binding.btnDecline.visibility = View.GONE
                    binding.tvStatus.text = context.getText(R.string.declined)
                    binding.tvStatus.background = ContextCompat.getDrawable(context, R.drawable.red_rc_bg)
                }
            }

            binding.tvNameAge.text = "${item?.name}, ${item?.age}"
            binding.tvLocation.text = "${item?.city}, ${item?.country}"
            binding.tvCall.text = "${item?.phone}"

            Glide.with(context).load(item?.pictureUrl).placeholder(R.color.grey).into(binding.ivProfileIcon)

            binding.btnAccept.setOnClickListener {
                btnClickListener.onAcceptClicked(uuid = item?.uuid.toString(), status = MatchProfileContract.InteractionStatus.ACCEPTED)
                Toast.makeText(context, "Accepted", Toast.LENGTH_SHORT).show()
            }
            binding.btnDecline.setOnClickListener {
                btnClickListener.onDeclineClicked(uuid = item?.uuid.toString(), status = MatchProfileContract.InteractionStatus.DECLINED)
                Toast.makeText(context, "Declined", Toast.LENGTH_SHORT).show()
            }
        }
    }

    interface BtnClickListener {
        fun onAcceptClicked(uuid: String, status: MatchProfileContract.InteractionStatus)
        fun onDeclineClicked(uuid: String, status: MatchProfileContract.InteractionStatus)
    }
}