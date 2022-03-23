package com.android.uas.septiannugraha.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.uas.septiannugraha.DataResponse
import com.android.uas.septiannugraha.adapter.CountryAdapter
import com.android.uas.septiannugraha.api.CountryClient
import com.android.uas.septiannugraha.databinding.ActivityAllCountryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllCountryActivity : AppCompatActivity() {

    private val list = ArrayList<DataResponse>()
    private lateinit var binding: ActivityAllCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        back()
        showCountry()
    }

    private fun showCountry() {
        binding.rvAllCountry.setHasFixedSize(true)
        binding.rvAllCountry.layoutManager = LinearLayoutManager(this)

        CountryClient.instance.getPosts().enqueue(object: Callback<ArrayList<DataResponse>> {
            override fun onResponse(
                call: Call<ArrayList<DataResponse>>,
                response: Response<ArrayList<DataResponse>>
            ) {
                val responseCode = response.code().toString()
                binding.tvResponCode.text = responseCode
                response.body()?.let { list.addAll(it) }


                fun countryClicked(dataResponse: DataResponse){
                    Toast.makeText(this@AllCountryActivity, dataResponse.name.common, Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@AllCountryActivity, CountryDetailActivity::class.java)

                    intent.putExtra(CountryDetailActivity.name1, dataResponse.name.common)
                    intent.putExtra(CountryDetailActivity.name2, dataResponse.name.official)

                    intent.putExtra(CountryDetailActivity.flags, dataResponse.flags.png)
                    intent.putExtra(CountryDetailActivity.lambang, dataResponse.coatOfArms.png)

                    val capital = "${dataResponse.capital}"
                    intent.putExtra(CountryDetailActivity.capital, capital)

                    intent.putExtra(CountryDetailActivity.region, dataResponse.region)
                    intent.putExtra(CountryDetailActivity.subregion, dataResponse.subregion)
                    intent.putExtra(CountryDetailActivity.area, dataResponse.area)
                    intent.putExtra(CountryDetailActivity.population, dataResponse.population)

                    val domain = "${dataResponse.tld}"
                    intent.putExtra(CountryDetailActivity.domain, domain)


                    startActivity(intent)
                }

                val adapter = CountryAdapter(list, ::countryClicked)
                binding.rvAllCountry.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<DataResponse>>, t: Throwable) {
                Toast.makeText(this@AllCountryActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun back() {
        binding.viewHome.setOnClickListener {
            onBackPressed()
            onSupportNavigateUp()
            return@setOnClickListener
        }

        binding.tvHome.setOnClickListener {
            onBackPressed()
            onSupportNavigateUp()
            return@setOnClickListener
        }

        binding.cvAll.setOnClickListener {
            onBackPressed()
            onSupportNavigateUp()
            return@setOnClickListener
        }
    }
}