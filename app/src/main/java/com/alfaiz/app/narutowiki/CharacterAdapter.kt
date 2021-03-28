package com.alfaiz.app.narutowiki

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.alfaiz.app.narutowiki.databinding.CharacterListBinding

class CharacterAdapter(private val list: MutableList<Character>) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(private val binding: CharacterListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            with(binding) {
                tvImageCharacter.load(character.image)
                tvNameCharacter.text = character.name
                tvTeamCharacter.text = character.team

                itemView.setOnClickListener { onItemClickCallback?.onItemClick(character) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
        return ViewHolder(
            CharacterListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list .size
}