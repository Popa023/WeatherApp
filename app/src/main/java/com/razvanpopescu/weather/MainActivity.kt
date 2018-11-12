package com.razvanpopescu.weather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import khttp.responses.Response
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val response : Response = khttp.get("http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=9339bb97061b8aeef4241a95974604fb" )
//        val obj : JSONObject = response.jsonObject
//        print(obj["someProperty"])
//        thread {
//            val response : Response = khttp.get("http://minifootball.eu-west-2.elasticbeanstalk.com/team/getAll")
//            val teamJson : JSONArray = response.jsonArray
//            val team = Gson().fromJson(teamJson.toString(), Array<Team>::class.java)
//            print(team)
//        }
//        thread {
//            val response : Response = khttp.get("http://minifootball.eu-west-2.elasticbeanstalk.com/team/get?id=20")
//            val teamJson : JSONArray = response.jsonArray
//            val desc = (((teamJson[0] as JSONObject).get("players") as JSONArray).get(0) as JSONObject).get("description")
//            print(teamJson)
//        }

    }

    fun search(v : View?){
        thread {
            val city = searchEditText.text
            val response: Response = khttp.get("http://api.openweathermap.org/data/2.5/weather?q=$city&APPID=9339bb97061b8aeef4241a95974604fb")
            val tempJson: JSONObject = response.jsonObject
            displayTemm(tempJson)
        }
    }

    fun displayTemm(tempJson: JSONObject){

        var temperature = (tempJson.get("main") as JSONObject).get("temp") as Double
        temperature -= 273
        resultTextView.text = temperature.toString()

    }

}


