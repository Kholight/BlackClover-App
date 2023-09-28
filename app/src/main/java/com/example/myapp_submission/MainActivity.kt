package com.example.myapp_submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvKarakter: RecyclerView
    private val list = ArrayList<Karakter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKarakter = findViewById(R.id.rv_karakter)
        rvKarakter.setHasFixedSize(true)
        supportActionBar?.title = resources.getString(R.string.judul_menu)
        list.addAll(getListKarakter())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_about -> {
                val intent = Intent(this,AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListKarakter(): ArrayList<Karakter> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataStatus = resources.getStringArray(R.array.data_status)
        val listKarakter = ArrayList<Karakter>()
        for (i in dataName.indices) {
            val karakter = Karakter(dataName[i],dataStatus[i],dataPhoto[i] ,dataDescription[i] )
            listKarakter.add(karakter)
        }
        return listKarakter
    }

    private fun showRecyclerList() {
        rvKarakter.layoutManager = LinearLayoutManager(this)
        val listKarakterAdapter = ListKarakterAdapter(list)
        rvKarakter.adapter = listKarakterAdapter
    }
}