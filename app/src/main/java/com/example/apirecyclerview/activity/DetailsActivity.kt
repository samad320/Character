package com.example.apirecyclerview.activity

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.apirecyclerview.R
import com.example.apirecyclerview.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    private val context: Context = this@DetailsActivity
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name=intent.getStringExtra("name").toString()
        val status=intent.getStringExtra("status").toString()
        val image=intent.getStringExtra("image").toString()
        binding.tvName.text=name
        binding.tvStatus.text=status
        binding.imgFav.setOnClickListener {
            binding.imgFavRed.visibility=View.VISIBLE
            binding.imgFav.visibility=View.GONE
        }

        binding.imgFavRed.setOnClickListener {
            binding.imgFav.visibility=View.VISIBLE
            binding.imgFavRed.visibility=View.GONE
        }

        if (image != null) {
            Picasso.get().load(image)
                .placeholder(R.drawable.placeholder_n)
                .error(R.drawable.error_placeholder)
                .into(binding.imgProfile)

        }

    }
}