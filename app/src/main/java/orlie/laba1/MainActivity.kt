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
        RandGen()
    }
    fun OnBut1(button: Button, view: View) {
        if(choosen[1]==0) {
            choosen[0]=1
            choosen[1]=couples[choosen[0]-1]
            val clicksText = findViewById<Button>(R.id.button1)
            clicksText.setText("$couples[choosen[0]-1]") // показ номера скрытого в кнопке
        } else if (choosen[1]!=0 && choosen[0]!=1) {
            val clicksText = findViewById<Button>(R.id.button1)
            clicksText.setText("$couples[choosen[0]-1]") // показ номера скрытого в кнопке
            if (choosen[1]==couples[0]) {
                view.setVisibility(View.GONE)
                // скрываем кнопки, молодец
                choosen = intArrayOf(0,0)
            } else {
                // закрываем кнопки, накосячил

                choosen = intArrayOf(0,0)
            }
        }
        /*if(choosen[1]!=0) {
            if (choosen[1] != couples[0]) { //button.text.toString().toInt()

            }
        }
        val clicksText = findViewById<Button>(R.id.button1)
        clicksText.setText("$couples Clicks")*/
    }

    fun RandGen(){
        var s = 6
        var pl = 0
        do {
            pl = Random.nextInt(0, 12)
            if (couples[pl] == 0) {
                couples[pl]=s
                s--
            }
        } while(s>0)
        s = 6
        do {
            pl = Random.nextInt(0, 12)
            if (couples[pl] == 0) {
                couples[pl]=s
                s--
            }
        } while(s>0)
    }
}
