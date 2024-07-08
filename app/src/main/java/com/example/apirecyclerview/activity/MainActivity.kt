package com.example.apirecyclerview.activity

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apirecyclerview.Retrofit.ApiClient
import com.example.apirecyclerview.databinding.ActivityMainBinding
import com.example.apirecyclerview.model.ModelChar
import com.example.apirecyclerview.adapter.AdapterFollowUp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val context: Context = this@MainActivity
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiCallCharacter()

    }

    private fun apiCallCharacter() {

        ApiClient.apiService.character(
        )
            .enqueue(object : Callback<ModelChar> {
                @SuppressLint("LogNotTimber")
                override fun onResponse(
                    call: Call<ModelChar>, response: Response<ModelChar>
                ) {
                    try {
                        if (response.code() == 500) {
                            Toast.makeText(this@MainActivity, "Server Error", Toast.LENGTH_LONG)
                                .show()

                        } else if (response.body()!!.results.isEmpty()) {
                            Toast.makeText(this@MainActivity, "No data found", Toast.LENGTH_LONG)
                                .show()

                        } else {
                            binding.recyclerView.apply {
                                adapter =
                                    AdapterFollowUp(this@MainActivity, response.body()!!.results)
                            }
                        }
                    } catch (e: Exception) {
                        Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_LONG)
                            .show()
                        e.printStackTrace()

                    }
                }


                override fun onFailure(call: Call<ModelChar>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message.toString(), Toast.LENGTH_LONG)
                        .show()


                }

            })
    }

}


