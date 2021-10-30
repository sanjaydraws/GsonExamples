package com.example.gsonexamples

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gsonexamples.databinding.ActivityMainBinding
import com.example.gsonexamples.models.Address
import com.example.gsonexamples.models.BaseApiModel
import com.example.gsonexamples.models.FamilyMember
import com.example.gsonexamples.models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


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
//        val user1 = convertFromJson(json,User::class.java)
//        Log.d(TAG, "onCreate: jsonToObject  $user1")



//        /* convert map to json */
//        val map:MutableMap<String?,Any> = mutableMapOf()
//        map["user1"] = user
//        map["i1"] = 23
//        Log.d(TAG, "onCreate: mapToJson  ${mapToJsonStr(map)}")


        // convert json String to array list direct
        val listJson = "[{\"age\":30,\"role\":\"Wife\"},{\"age\":5,\"role\":\"Daughter\"}]"
        val familyType: Type = object : TypeToken<ArrayList<FamilyMember>>() {}.type
        var family: ArrayList<FamilyMember> = gson.fromJson(listJson, familyType)
        Log.d(TAG, "onCreate: arrayListStrToArrayList1  $family") //[FamilyMember(mRole=Wife, mAge=30), FamilyMember(mRole=Daughter, mAge=5)]
        var family2 = convertToArrayList<FamilyMember>(listJson)
        Log.d(TAG, "onCreate: arrayListStrToArrayList2  $family2")

        // to convert in array
//        FamilyMember[] family = gson.fromJson(json,FamilyMember[].class);



//        ===================================================================
//        val base = BaseApiModel(status = 200, message = "Success", data = user)
//        Log.d(TAG, "onCreate: BAse  ${convertToJson(base)}")

        val response1 = "{\"data\":{\"address\":{\"firstAddress\":\"Green Street\",\"secondAddress\":\"USA\"},\"age\":23,\"firstName\":\"Justin\",\"lastName\":\" Bieber\",\"numbers\":[\"2345678\",\"9039023\"]},\"message\":\"Success\",\"status\":200}"
        val baseData1 =convertFromJson(response1,BaseApiModel::class.java)
        Log.d(TAG, "onCreate: BAse  $baseData1") //BaseApiModel(status=200, message=Success, data={"address":{"firstAddress":"Green Street","secondAddress":"USA"},"age":23,"firstName":"Justin","lastName":" Bieber","numbers":["2345678","9039023"]})

        val response2 = "{\"data\":[{\"age\":30,\"role\":\"Wife\"},{\"age\":5,\"role\":\"Daughter\"}],\"message\":\"Success\",\"status\":200}"
        val baseData2 =convertFromJson(response2,BaseApiModel::class.java)
        Log.d(TAG, "onCreate: BAse2  $baseData2") // BaseApiModel(status=200, message=Success, data=[{"age":30,"role":"Wife"},{"age":5,"role":"Daughter"}])

        // convert from jsonElement to any model
        val user2 = gson.fromJsonElement<User>(baseData1?.data)
        Log.d(TAG, "onCreate: USER2  $user2") //User(firstName=Justin, lastName= Bieber, age=23, address=Address(firstAddress=Green Street, secondAddress=USA), numbers=[2345678, 9039023])


    }
}