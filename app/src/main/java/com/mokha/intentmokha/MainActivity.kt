package com.mokha.intentmokha

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveWithData: Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnResultFromActivity: Button
    private lateinit var tvResult: TextView

    private lateinit var btnExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        btnMoveWithData = findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        btnDialNumber = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        btnResultFromActivity = findViewById(R.id.btn_result_from_activity)
        btnResultFromActivity.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
        ColorReceived()

        btnExit = findViewById(R.id.btn_kill_it)
        btnExit.setOnClickListener(this)

    }

    private fun ColorReceived() {
        val bundle = intent.extras
        val warna = bundle?.getString("Warna")
        tvResult.text = warna
    }

    fun hello_mok(view: View) {
        val toast = Toast.makeText(this,"ya... maybe :)", Toast.LENGTH_SHORT)
        toast.show()
    }

    fun hello_mok2(view: View) {
        /*val toast2 = */Toast.makeText(this,"hai aku moka ;)", Toast.LENGTH_SHORT).show()
        /*toast2.show()*/
    }


    override fun onClick(v: View?) {
        if (v != null){
            when(v.id){
                R.id.btn_move_activity -> run {
                    val intent = Intent(this, MoveActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"Pindah Activity", Toast.LENGTH_SHORT).show()
                }
                R.id.btn_move_with_data -> run {
                    val intent = Intent(this, MoveWithDataActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString("Nama", "Mochammad Khafidz")
                    bundle.putString("NIM", "20.52.0005")
                    bundle.putString("Prodi", "S1 - Teknologi Informasi")
                    bundle.putString("Alamat", "Batu")
                    intent.putExtras(bundle)
                    startActivity(intent)
                    Toast.makeText(this,"Pindah Activity + Data", Toast.LENGTH_SHORT).show()
                }
                R.id.btn_dial_number -> run {
                    var dialNumber = "089666666666"
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dialNumber))
                    startActivity(intent)
                }
                R.id.btn_result_from_activity -> run {
                    val intent = Intent(this, MoveForResultActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_kill_it -> run {
                    finishAffinity()
                }
            }
        }
    }
}