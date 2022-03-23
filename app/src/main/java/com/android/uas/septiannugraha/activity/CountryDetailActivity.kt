package com.android.uas.septiannugraha.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.uas.septiannugraha.databinding.ActivityCountryDetailBinding

import com.android.uas.septiannugraha.digit
import com.android.uas.septiannugraha.digitdes
import com.squareup.picasso.Picasso
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class CountryDetailActivity : AppCompatActivity() {

    companion object{
        const val name1 = "name1"
        const val name2 = "name2"

        const val flags = "flags"
        const val lambang = "lambang"

        const val capital = "capital"
        const val region = "region"
        const val subregion = "subregion"
        const val area = "area"
        const val population = "population"
        const val domain = "domain"
    }

    private lateinit var binding: ActivityCountryDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        back()
        intentData()
    }

    private fun intentData() {

        val penerimaName1 = intent.getStringExtra(name1)
        val teks = "$penerimaName1"
        binding.tvName1.text = teks

        val penerimaName2 = intent.getStringExtra(name2)
        val teks2 = "$penerimaName2"
        binding.tvName2.text = teks2

        val penerimaFlags = intent.getStringExtra(flags)
        val bendera = "$penerimaFlags"
        Picasso.get().load(bendera).into(binding.ivBendera)

        val penerimaLambang = intent.getStringExtra(lambang)
        val lambang = "$penerimaLambang"
        Picasso.get().load(lambang).into(binding.ivLambang)

        val penerimaCapital = intent.getStringExtra(capital)
        val capital = "$penerimaCapital"
        binding.tvCapitalValue.text = capital

        val penerimaRegion = intent.getStringExtra(region)
        val region = "$penerimaRegion"
        binding.tvRegionValue.text = region

        val penerimaSub = intent.getStringExtra(subregion)
        val sub = "${penerimaSub}"
        binding.tvSubregionValue.text = sub

        val penerimaArea = intent.getStringExtra(area)
        val area = "${penerimaArea}"
        binding.tvLuasValue.text = area.toDouble().digitdes()

        val penerimaPopulasi = intent.getStringExtra(population)
        val populasi = "${penerimaPopulasi}"
        binding.tvPopulasiValue.text = populasi.toDouble().digit()

        val penerimaDomain = intent.getStringExtra(domain)
        val domain = "${penerimaDomain}"
        binding.tvDomainValue.text = domain

    }

    private fun back() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
            onSupportNavigateUp()
            return@setOnClickListener
        }
    }
}