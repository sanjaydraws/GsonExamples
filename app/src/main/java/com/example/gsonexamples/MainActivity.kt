package com.example.gsonexamples

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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

        /*convert json to object*/
        val json = "{ \"address\": {\"firstAddress\":\"Red Street\",\"secondAddress\":\"Japan\" },\"age\":13,\"firstName\":\"Kat\",\"lastName\":\" Bay\",\"numbers\":[\"8989898\",\"9938323989\"]}"
//        val user1 = gson.fromJson(json,User::class.java)
        val user1 = convertFromJson(json,User::class.java)
        Log.d(TAG, "onCreate: jsonToObject  $user1")



//        /* convert map to json */
//        val map:MutableMap<String?,Any> = mutableMapOf()
//        map["user1"] = user
//        map["i1"] = 23
//        Log.d(TAG, "onCreate: mapToJson  ${mapToJsonStr(map)}")


    }
}