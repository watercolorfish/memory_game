package orlie.laba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var couples = intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0)
    var choosen = intArrayOf(0,0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
