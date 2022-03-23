package com.android.uas.septiannugraha.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.uas.septiannugraha.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvAll.setOnClickListener{
            val intent = Intent(this, AllCountryActivity::class.java)
            startActivity(intent)
        }

        binding.cvName.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra(SearchActivity.by, binding.tvSearchName.text)
            startActivity(intent)
        }

        binding.cvCapital.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra(SearchActivity.by, binding.tvSearchCapital.text)
            startActivity(intent)
        }

        binding.cvCode.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra(SearchActivity.by, binding.tvSearchCode.text)
            startActivity(intent)
        }

        binding.cvSubregion.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra(SearchActivity.by, binding.tvSearchSubregion.text)
            startActivity(intent)
        }

        binding.cvRegion.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra(SearchActivity.by, binding.tvSearchRegion.text)
            startActivity(intent)
        }
    }
}