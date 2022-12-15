package com.upb.ticfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            val parkingRef = database.getReference("parking")
            parkingRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val temp = ArrayList<ParkingLot>()
                    for(child in snapshot.children){
                        child.getValue(ParkingLot::class.java)?.also { temp.add(it) }
                    }
                    Toast.makeText(this@MainActivity,"$temp",Toast.LENGTH_LONG).show()
                    print(temp)
                    //Todo hacer que reciba solo la ultima linea actualizada
                    // en el realtime database cambiar de formato y que solo lea p1:0  0 p5:1

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_LONG).show()
                }

            })
        }
}