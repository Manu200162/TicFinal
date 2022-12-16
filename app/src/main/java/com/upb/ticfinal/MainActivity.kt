package com.upb.ticfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.upb.ticfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val database = Firebase.database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        workWithUpdates()
    }
    private fun workWithUpdates(){
            val parkingRef = database.getReference("Test")
            parkingRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val temp = ArrayList<DataSnapshot>()
                    for(child in snapshot.children){
                        temp.add(child)
                    }
                    Toast.makeText(this@MainActivity,"$temp",Toast.LENGTH_LONG).show()
                    updateScreen(temp)
                    print(temp)
                    //Todo hacer que reciba solo la ultima linea actualizada
                    // en el realtime database cambiar de formato y que solo lea p1:0  0 p5:1

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_LONG).show()
                }

            })
        }

    private fun loadImage(imageView: ImageView,image:Int){
        if (image ==1){
            imageView.setImageResource(R.drawable.empty)
        }else{
            //Todo cargar la imgagen sin el auto
        }
        //imageView.setImageDrawable()
    }
    private fun updateScreen(temp: List<DataSnapshot>){
        for (element in temp){
            val state = (element.value as Long).toInt()
            when(element.key){
                "P1" -> {
                    //loadImage(view,state)
                    val sum = (element.value as Long).toInt() + 10
                    Toast.makeText(this,"$sum",Toast.LENGTH_SHORT).show()
                }
                "P2" -> {

                }
                "P3" -> {

                }
                "P4" -> {

                }
                "P5" -> {

                }
                "P6" -> {

                }
                "P7" -> {

                }
                "P8" -> {

                }
                "P9" -> {

                }
                "P10" -> {

                }
                "P11" -> {

                }
                "P12" -> {

                }
                "P13" -> {

                }
                "P14" -> {

                }
                "P15" -> {

                }
                "P16" -> {

                }
                "P17" -> {

                }
                "P18" -> {

                }
                "P19" -> {

                }
                "P20" -> {

                }
                "P21" -> {

                }
                "P22" -> {

                }
                "P23" -> {

                }
                "P24" -> {

                }
                "P25" -> {

                }
                "P26" -> {

                }
                "P27" -> {

                }
                "P28" -> {

                }
                "P29" -> {

                }
                "P30" -> {

                }
                "P31" -> {

                }
                "P32" -> {

                }
                "P33" -> {

                }
                "P34" -> {

                }
                "P35" -> {

                }
                "P36" -> {

                }
                "P37" -> {

                }
                "P38" -> {

                }
                "P39" -> {

                }
                "P40" -> {

                }
                "P41" -> {

                }
                "P42" -> {

                }
                "P43" -> {

                }
                "P44" -> {

                }
                "P45" -> {

                }
                "P46" -> {

                }
                "P47" -> {

                }
                "P48" -> {

                }
                "P49" -> {

                }
                "50" -> {

                }
            }

        }
    }
}