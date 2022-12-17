package com.upb.ticfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.upb.ticfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val database = Firebase.database
    private var states: HashMap<String,Int> = HashMap()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStateMap()
        workWithUpdates()
    }
    private fun setStateMap(){
        states = hashMapOf("P1" to 0,"P2" to 0,"P3" to 0,"P4" to 0,
            "P5" to 0, "P6" to 0, "P7" to 0, "P8" to 0,"P9" to 0,"P10" to 0,"P11" to 0,"P12" to 0,
            "P13" to 0, "P14" to 0, "P15" to 0, "P16" to 0,"P17" to 0,"P18" to 0,"P19" to 0,"P20" to 0,
            "P21" to 0, "P22" to 0,"P23" to 0,"P24" to 0,"P35" to 0,"P36" to 0,"P37" to 0,"P38" to 0,
            "P39" to 0,"P30" to 0,"P31" to 0,"P32" to 0,"P33" to 0,"P34" to 0,"P35" to 0,"P36" to 0,
            "P37" to 0,"P38" to 0,"P39" to 0,"P40" to 0,"P41" to 0,"P42" to 0,"P43" to 0,"P44" to 0,
            "P45" to 0,"P46" to 0,"P47" to 0,"P48" to 0,"P49" to 0,"P50" to 0)
    }
    private fun workWithUpdates(){

        val parkingRef = database.getReference("Test")
        parkingRef.orderByKey().limitToLast(50).addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val temp = ArrayList<DataSnapshot>()
                    for(child in snapshot.children){
                        temp.add(child)
                    }
                    //Toast.makeText(this@MainActivity,"$temp",Toast.LENGTH_LONG).show()
                    //Toast.makeText(this@MainActivity,"${temp[1]}",Toast.LENGTH_LONG).show()
                    updateScreen(temp)

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_LONG).show()
                }

            })



        }

    private fun loadImage(imageView: ImageView,s:Int,key:String,textView: TextView){
        if(s != states.get(key)){
            if (s ==1){
                imageView.setImageResource(R.drawable.occuped1)
                textView.visibility = View.GONE
                with(states) { put(key, 1) }
            }else{
                imageView.setImageResource(R.drawable.empty)
                textView.visibility = View.VISIBLE
                with(states) { put(key, 0) }
            }
        }
    }
    private fun updateScreen(temp: List<DataSnapshot>){
        if (temp.size == 50) {
            loadImage(binding.P1img, (temp[0].value as Long).toInt(), temp[0].key as String,binding.P1tx)
            loadImage(binding.P2img, (temp[11].value as Long).toInt(), temp[11].key as String,binding.P2tx)
            loadImage(binding.P3img, (temp[22].value as Long).toInt(), temp[22].key as String,binding.P3tx)
            loadImage(binding.P4img, (temp[33].value as Long).toInt(), temp[33].key as String,binding.P4tx)
            loadImage(binding.P5img, (temp[44].value as Long).toInt(), temp[44].key as String,binding.P5tx)
            loadImage(binding.P6img, (temp[46].value as Long).toInt(), temp[46].key as String,binding.P6tx)
            loadImage(binding.P7img, (temp[47].value as Long).toInt(), temp[47].key as String,binding.P7tx)
            loadImage(binding.P8img, (temp[48].value as Long).toInt(), temp[48].key as String,binding.P8tx)
            loadImage(binding.P9img, (temp[49].value as Long).toInt(), temp[49].key as String,binding.P9tx)
            loadImage(binding.P10img, (temp[1].value as Long).toInt(), temp[1].key as String,binding.P10tx)
            loadImage(binding.P11img, (temp[2].value as Long).toInt(), temp[2].key as String,binding.P11tx)
            loadImage(binding.P12img, (temp[3].value as Long).toInt(), temp[3].key as String,binding.P12tx)
            loadImage(binding.P13img, (temp[4].value as Long).toInt(), temp[4].key as String,binding.P13tx)
            loadImage(binding.P14img, (temp[5].value as Long).toInt(), temp[5].key as String,binding.P14tx)
            loadImage(binding.P15img, (temp[6].value as Long).toInt(), temp[6].key as String,binding.P15tx)
            loadImage(binding.P16img, (temp[7].value as Long).toInt(), temp[7].key as String,binding.P16tx)
            loadImage(binding.P17img, (temp[8].value as Long).toInt(), temp[8].key as String,binding.P17tx)
            loadImage(binding.P18img, (temp[9].value as Long).toInt(), temp[9].key as String,binding.P18tx)
            loadImage(binding.P19img, (temp[10].value as Long).toInt(), temp[10].key as String,binding.P19tx)
            loadImage(binding.P20img, (temp[12].value as Long).toInt(), temp[12].key as String,binding.P20tx)
            loadImage(binding.P21img, (temp[13].value as Long).toInt(), temp[13].key as String,binding.P21tx)
            loadImage(binding.P22img, (temp[14].value as Long).toInt(), temp[14].key as String,binding.P22tx)
            loadImage(binding.P23img, (temp[15].value as Long).toInt(), temp[15].key as String,binding.P23tx)
            loadImage(binding.P24img, (temp[16].value as Long).toInt(), temp[16].key as String,binding.P24tx)
            loadImage(binding.P25img, (temp[17].value as Long).toInt(), temp[17].key as String,binding.P25tx)
            loadImage(binding.P26img, (temp[18].value as Long).toInt(), temp[18].key as String,binding.P26tx)
            loadImage(binding.P27img, (temp[19].value as Long).toInt(), temp[19].key as String,binding.P27tx)
            loadImage(binding.P28img, (temp[20].value as Long).toInt(), temp[20].key as String,binding.P28tx)
            loadImage(binding.P29img, (temp[21].value as Long).toInt(), temp[21].key as String,binding.P29tx)
            loadImage(binding.P30img, (temp[23].value as Long).toInt(), temp[23].key as String,binding.P30tx)
            loadImage(binding.P31img, (temp[24].value as Long).toInt(), temp[24].key as String,binding.P31tx)
            loadImage(binding.P32img, (temp[25].value as Long).toInt(), temp[25].key as String,binding.P32tx)
            loadImage(binding.P33img, (temp[26].value as Long).toInt(), temp[26].key as String,binding.P33tx)
            loadImage(binding.P34img, (temp[27].value as Long).toInt(), temp[27].key as String,binding.P34tx)
            loadImage(binding.P35img, (temp[28].value as Long).toInt(), temp[28].key as String,binding.P35tx)
            loadImage(binding.P36img, (temp[29].value as Long).toInt(), temp[29].key as String,binding.P36tx)
            loadImage(binding.P37img, (temp[30].value as Long).toInt(), temp[30].key as String,binding.P37tx)
            loadImage(binding.P38img, (temp[31].value as Long).toInt(), temp[31].key as String,binding.P38tx)
            loadImage(binding.P39img, (temp[32].value as Long).toInt(), temp[32].key as String,binding.P39tx)
            loadImage(binding.P40img, (temp[34].value as Long).toInt(), temp[34].key as String,binding.P40tx)
            loadImage(binding.P41img, (temp[35].value as Long).toInt(), temp[35].key as String,binding.P41tx)
            loadImage(binding.P42img, (temp[36].value as Long).toInt(), temp[36].key as String,binding.P42tx)
            loadImage(binding.P43img, (temp[37].value as Long).toInt(), temp[37].key as String,binding.P43tx)
            loadImage(binding.P44img, (temp[38].value as Long).toInt(), temp[38].key as String,binding.P44tx)
            loadImage(binding.P45img, (temp[39].value as Long).toInt(), temp[39].key as String,binding.P45tx)
            loadImage(binding.P46img, (temp[40].value as Long).toInt(), temp[40].key as String,binding.P46tx)
            loadImage(binding.P47img, (temp[41].value as Long).toInt(), temp[41].key as String,binding.P47tx)
            loadImage(binding.P48img, (temp[42].value as Long).toInt(), temp[42].key as String,binding.P48tx)
            loadImage(binding.P49img, (temp[43].value as Long).toInt(), temp[43].key as String,binding.P49tx)
            loadImage(binding.P50img, (temp[45].value as Long).toInt(), temp[45].key as String,binding.P50tx)
        }
    }
}