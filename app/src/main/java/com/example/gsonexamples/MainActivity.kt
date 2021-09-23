package com.example.gsonexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gsonexamples.databinding.ActivityMainBinding
import com.example.gsonexamples.models.Address
import com.example.gsonexamples.models.User
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? = null
    companion object{
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(binding?.root)
        }

        val address  = Address("Green Street", "USA")
        val user = User("Justin"," Bieber", age = 23,address= address,numbers= listOf("2345678","9039023"))
        val gson = Gson()

        /*Convert Object to Json */
        val jsonString = convertToJson(user)
        Log.d(TAG, "onCreate: $jsonString")
       /*
       * {"address":{"firstAddress":"Green Street","secondAddress":"USA"},"age":23,"firstName":"Justin","lastName":" Bieber","numbers":["2345678","9039023"]}
       * */



    }
}