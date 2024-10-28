package com.anbinh.gmaillist
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sample data
        val emailList = listOf(
            Email("Edurila.com", "Learn Web Design for $19 only!", "12:34 PM", true),
            Email("Chris Abad", "Help make Campaign Monitor better", "11:22 AM", false),
            Email("Tuto.com", "Free courses on Photoshop and more!", "11:04 AM", true),
            Email("Support", "Support message from OVH", "10:26 AM", false),
            Email("Matt from Ionic", "The New Ionic Creator is here!", "9:34 AM", true)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(emailList)


        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.divider_color)))
        recyclerView.addItemDecoration(divider)
    }
}
