package com.alfaiz.app.narutowiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.alfaiz.app.narutowiki.databinding.ActivityCharacterDetailBinding

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailBinding

    companion object{
        const val EXTRA_PRODUCT = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val charDetail = intent.getParcelableExtra<Character>(EXTRA_PRODUCT)
        binding.tvNameCharacter.text = charDetail?.name
        binding.tvImageCharacter.load(charDetail?.image)
        binding.tvDetailCharacter.text = charDetail?.detail
    }
}