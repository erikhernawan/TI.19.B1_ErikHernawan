package com.erikhernawan.myapplication

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.erikhernawan.myapplication.adapter.AdapterDataSayur
import com.erikhernawan.myapplication.databinding.ActivityMainBinding
import com.erikhernawan.myapplication.model.Sayuran

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listSayuran = ArrayList<Sayuran>()
        listSayuran.add(
            Sayuran(
                "Bayam",
                R.drawable.bayam,
                "Hijau muda",
                "Amaranthus",
                "Vitamin A,B,C,E,K",
                "20-25 cm"
            )
        )

        listSayuran.add(
            Sayuran(
                "Kangkung",
                R.drawable.kangkung,
                "Hijau",
                "Ipomoea aquatica",
                "Vitamin A,B,C",
                "10-15 cm"
            )
        )

        listSayuran.add(
            Sayuran(
                "Katuk",
                R.drawable.katuk,
                "Hijau gelap",
                "Sauropus androgynus",
                "Vitamin A,B,C,K",
                "5-8 cm"
            )
        )

        listSayuran.add(
            Sayuran(
                "Sawi",
                R.drawable.sawi,
                "Hijau",
                "Brassica",
                "Vitamin A,B,C,E,K",
                "20-30 cm"
            )
        )
        listSayuran.add(
            Sayuran(
                "Kacang Panjang",
                R.drawable.kacangpanjang,
                "Hijau",
                "Vigna unguiculata",
                "Vitamin A,C",
                "20-30 cm"
            )
        )
        listSayuran.add(
            Sayuran(
                "Brokoli",
                R.drawable.brokoli,
                "Hijau muda",
                "Brassica oleracea",
                "Vitamin A,B,C,E,K",
                "10-40 cm"
            )
        )
        listSayuran.add(
            Sayuran(
                "Mentimun",
                R.drawable.mentimun,
                "Hijau",
                "Cucumis sativus",
                "Vitamin A,B,C",
                "20-30 cm"
            )
        )
        listSayuran.add(
            Sayuran(
                "Terong",
                R.drawable.terong,
                "Ungu",
                "Solanum melongena",
                "Vitamin B,C,D",
                "20-40 cm"
            )
        )
        listSayuran.add(
            Sayuran(
                "Wortel",
                R.drawable.wortel,
                "Jingga",
                "Daucus carota",
                "Vitamin A,B,C,K",
                "15–35 cm"
            )
        )
        listSayuran.add(
            Sayuran(
                "Cabai",
                R.drawable.cabai,
                "Merah,Hijau",
                "Carota",
                "Vitamin B,C,D",
                "5-25 cm"
            )
        )
        binding.list.adapter =
            AdapterDataSayur(this, listSayuran, object : AdapterDataSayur.OnClickListener {
                override fun detailData(item: Sayuran?) {
                    Dialog(this@MainActivity).apply {
                        requestWindowFeature(Window.FEATURE_NO_TITLE)
                        setCancelable(true)
                        setContentView(R.layout.detail_data_sayur)


                        val image = this.findViewById<ImageView>(R.id.image_sayur)
                        val nama = this.findViewById<TextView>(R.id.txt_namasayur)
                        val warna = this.findViewById<TextView>(R.id.txt_warna)
                        val spesies = this.findViewById<TextView>(R.id.txt_spesies)
                        val manfaat = this.findViewById<TextView>(R.id.txt_manfaat)
                        val panjang = this.findViewById<TextView>(R.id.txt_panjang)
                        val btn = this.findViewById<Button>(R.id.btnClose)

                        image.setImageResource(item?.foto ?: 0)
                        nama.text = "${item?.nama}"
                        warna.text = "${item?.warna}"
                        spesies.text = "${item?.spesies}"
                        manfaat.text = "${item?.manfaat}"
                        panjang.text = "${item?.panjang}"

                        btn.setOnClickListener {
                            this.dismiss()
                        }
                    }.show()
                }

                override fun detailData() {
                    TODO("Not yet implemented")
                }

            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.myprofile -> {
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)
            }
        }
    }

}
