package com.example.optionmenu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_context_menu.*

class contextMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)
        //đăng ký menu ngữ cảnh
        registerForContextMenu(txtContext)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //add(int groupID, int itemID, int order,charSequence title)
        menu?.add(1,1,1,"Red")
        menu?.add(1,2,2,"Green")
        menu?.add(1,3,3,"Black")
        menu?.add(1,4,4,"Blue")

        //sub menu
        var subMenu = menu?.addSubMenu("Giới tính")
        subMenu?.add(2,21,1,"Male")?.setChecked(true)
        subMenu?.add(2,22,2,"Female")
        subMenu?.setGroupCheckable(2,true, true)

        /*
        * setGroupCheckable(int group, boolean checkable, boolean exclusive
        * 1.group: id của group muốn có nút check
        * 2.checkable: true cho phép dấu kiểm, false sẽ không cho phép, mạc định sẽ là false
        * 3.exclusive: true cho phép chỉ chọn 1 item trong group, false cho phép chọn nhiều item
        * ?.setChecked(true) chọn mặc định*/
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1->{txtOption.setTextColor(Color.RED)}
            2->{txtOption.setTextColor(Color.GREEN)}
            3->{txtOption.setTextColor(Color.BLACK)}
            4->{txtOption.setTextColor(Color.BLUE)}
            //submenu
            21->{txtContext.setText("Male")}
            22->{txtContext.setText("Female")}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(3,31,1,"Red")
        menu?.add(3,32,2,"Green")
        menu?.add(3,33,3,"Black")
        menu?.setHeaderTitle("Mời chọn màu")

    }
//xử lý sự kiện context menu
    override fun onContextItemSelected(item: MenuItem): Boolean {
    when(item.itemId){
        31->{txtContext.setTextColor(Color.RED)}
        32->{txtContext.setTextColor(Color.GREEN)}
        33->{txtContext.setTextColor(Color.BLACK)}

    }
        return super.onContextItemSelected(item)
    }
}
