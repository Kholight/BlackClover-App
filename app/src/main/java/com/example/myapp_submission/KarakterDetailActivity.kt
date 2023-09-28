package com.example.myapp_submission

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapp_submission.databinding.ActivityAboutBinding
import com.example.myapp_submission.databinding.ActivityKarakterDetailBinding
import com.example.myapp_submission.databinding.ActivityMainBinding

class KarakterDetailActivity : AppCompatActivity() {

    companion object{
        const val KEY_KARAKTER = "key_karakter"
    }

    private lateinit var binding:ActivityKarakterDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKarakterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val karakter = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra(KEY_KARAKTER, Karakter::class.java)
        }else    {
            @Suppress ("DEPRECATION")
            intent.getParcelableExtra(KEY_KARAKTER)
        }

        if (karakter != null) {
            binding. apply {
                Glide.with(this@KarakterDetailActivity)
                    .load(karakter.description)
                    .into(imageView)
                tvKarakterNameDetail.text = karakter.name
                tvDeskripsiDetail.text = karakter.photo
                tvStatus.text = karakter.status
                actionShare.setOnClickListener {
                    val share = Intent(Intent.ACTION_SEND)
                    val link = "https://myanimelist.net/anime/34572/Black_Clover?q=black%20clo&cat=anime"
                    share.putExtra(Intent.EXTRA_TEXT, "Halo: ${link}")
                    share.type = "text/plain"
                    startActivity(Intent.createChooser(share, "Share To:"))
                }
            }



    }
}
}