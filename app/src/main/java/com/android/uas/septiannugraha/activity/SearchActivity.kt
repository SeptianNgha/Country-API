package com.android.uas.septiannugraha.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.doOnAttach
import androidx.core.view.isEmpty
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.uas.septiannugraha.DataResponse
import com.android.uas.septiannugraha.adapter.CountryAdapter
import com.android.uas.septiannugraha.api.CountryClient
import com.android.uas.septiannugraha.databinding.ActivitySearchBinding
import com.android.uas.septiannugraha.hideKeyboard
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchActivity : AppCompatActivity() {

    companion object {
        const val by = "by"
    }

    private val list = ArrayList<DataResponse>()
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val penerimaBy = intent.getStringExtra(by)
        val teks = "$penerimaBy"
        binding.tvBy.text = teks

        back()
        searchShow()

    }

    private fun back() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
            onSupportNavigateUp()
            return@setOnClickListener
        }
    }

    private fun searchShow() {

        binding.cvSearch.setOnClickListener {

            binding.rvResult.setHasFixedSize(true)
            binding.rvResult.layoutManager = LinearLayoutManager(this)
            hideKeyboard()


            val searchBy = binding.tvBy.text
            val valueBy = binding.etTitle.text
            CountryClient.instance.getSearch(searchBy.toString(), valueBy.toString())
                .enqueue(object :
                    Callback<ArrayList<DataResponse>> {
                    override fun onResponse(
                        call: Call<ArrayList<DataResponse>>,
                        response: Response<ArrayList<DataResponse>>
                    ) {
                        val responseCode = response.code().toString()
                        binding.tvResponCode.text = responseCode
                        response.body()?.let { list.addAll(it) }

                        // Deklarasikan adapter
                        fun searchClicked(dataResponse: DataResponse) {
                            Toast.makeText(
                                this@SearchActivity,
                                dataResponse.name.common,
                                Toast.LENGTH_SHORT
                            ).show()

                            val intent =
                                Intent(this@SearchActivity, CountryDetailActivity::class.java)

                            intent.putExtra(
                                CountryDetailActivity.name1,
                                dataResponse.name.common
                            )
                            intent.putExtra(
                                CountryDetailActivity.name2,
                                dataResponse.name.official
                            )

                            intent.putExtra(CountryDetailActivity.flags, dataResponse.flags.png)
                            intent.putExtra(
                                CountryDetailActivity.lambang,
                                dataResponse.coatOfArms.png
                            )

                            val capital = "${dataResponse.capital}"
                            intent.putExtra(CountryDetailActivity.capital, capital)

                            intent.putExtra(CountryDetailActivity.region, dataResponse.region)
                            intent.putExtra(
                                CountryDetailActivity.subregion,
                                dataResponse.subregion
                            )
                            intent.putExtra(CountryDetailActivity.area, dataResponse.area)
                            intent.putExtra(
                                CountryDetailActivity.population,
                                dataResponse.population
                            )

                            val domain = "${dataResponse.tld}"
                            intent.putExtra(CountryDetailActivity.domain, domain)


                            startActivity(intent)
                        }

                        val adapter = CountryAdapter(list, ::searchClicked)
                        binding.rvResult.adapter = adapter

                    }

                    override fun onFailure(call: Call<ArrayList<DataResponse>>, t: Throwable) {
                        binding.tvResponCode.text = t.message
                    }

                })

            binding.etTitle.doAfterTextChanged {
                list.clear()
                binding.rvResult.adapter!!.notifyDataSetChanged()
            }

        }

    }

}