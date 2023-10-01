package com.example.localdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.localdatabase.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val context=this
        val db=DatabaseHelper(context)


        binding.btnkaydet.setOnClickListener{
            var etadsoyad=binding.etadsoyad.text.toString()
            var etyas=binding.etyas.text.toString()

            if (etadsoyad.isNotEmpty()&&etyas.isNotEmpty()){
                var kullanicilar=Kullanici(etadsoyad,etyas.toInt())
                db.insertData(kullanicilar)
            }else{
                Toast.makeText(applicationContext,"Boş Alanları Doldurun",Toast.LENGTH_LONG).show()
            }
        }

        binding.btnoku.setOnClickListener{
            var data=db.readData()
            binding.txtsonuc.text=""
            for (i in 0 until data.size){

                binding.txtsonuc.append(data.get(i).id.toString()+" "+data.get(i).adSoyad+" "+
                data.get(i).yas+" \n")

            }
        }

        }


}
