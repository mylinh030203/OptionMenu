package com.example.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
//khởi tạo menu
    override fun onCreateOptionsMenu(menu1: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu, menu1)
    menuInflater.inflate(R.menu.menu2, menu1)
        return true;
    }
//xủ lý sự kiện với item được chọn
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when(item.itemId){
        R.id.mnuExit -> finish()
        R.id.mnuHome -> Toast.makeText(this, "home", Toast.LENGTH_SHORT).show()
        R.id.mnuSearch -> Toast.makeText(this, "search", Toast.LENGTH_SHORT).show()

    }
        return super.onOptionsItemSelected(item)
    }
}