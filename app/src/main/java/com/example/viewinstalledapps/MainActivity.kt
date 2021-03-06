package com.example.viewinstalledapps

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var mApplicationList:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApplicationList = findViewById(R.id.appsList)
        val array_list = ArrayList<String>()

        val packageManager = this.packageManager

        val intent = Intent(Intent.ACTION_MAIN)

        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val apps_list = packageManager.queryIntentActivities(intent,PackageManager.PERMISSION_GRANTED)
        for (resolveInfo:ResolveInfo in apps_list)
        {
            array_list.add(resolveInfo.activityInfo.applicationInfo.loadLabel(packageManager).toString())
        }

        mApplicationList.adapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,apps_list)
    }
}