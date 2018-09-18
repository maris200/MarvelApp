package com.mari.test.view.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.mari.test.R
import com.mari.test.model.MarvelCharacter
import com.mari.test.view.common.ItemAdapter
import com.mari.test.view.common.bindView
import com.mari.test.view.common.loadImage

class CharacterItemAdapter(
        val character: MarvelCharacter,
        val clicked: (MarvelCharacter) -> Unit
) : ItemAdapter<CharacterItemAdapter.ViewHolder>(R.layout.item_character) {

    override fun onCreateViewHolder(itemView: View) = ViewHolder(itemView)

    override fun ViewHolder.onBindViewHolder() {
        itemView.setOnClickListener { clicked(character) }
        textView.text = character.name
        imageView.loadImage(character.imageUrl)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView by bindView<TextView>(R.id.textView)
        val imageView by bindView<ImageView>(R.id.imageView)
    }
}
