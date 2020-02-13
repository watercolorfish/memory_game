package orlie.laba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.util.LogPrinter
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(){

    var couples: MutableMap<Button?,String> = mutableMapOf()
    var choosen: String? = null
    var last: Button?=null
    //var lastv: View?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val handler = android.os.Handler()
        RandGen()
        for ((k) in couples){
            k?.setOnClickListener {
                if (last==null){ // если никакая не выбрана
                    //last = button // занести нынешнюю в выбранную
                    //choosen = couples[last]
                    last = it as Button
                    //last?.setText("$couples[last]") // раскрываем выбранную
                    var str: String? = couples[last]
                    choosen = str
                    it.setText("$str")
                } else {
                    if (last!=it){ // если выбранная ранее не эта же
                        //val clicksText = findViewById<Button>(R.id.button1)
                        var str: String? = couples[it] as? String
                        //clicksText.setText("$str")
                        (it as Button)?.setText("$str") // раскрываем выбранную
                        //SystemClock.sleep(1000)
                        handler.postDelayed({
                            if (couples[it].equals(choosen)){ // если значения совпадают
                                Log.e("Look","$choosen")
                            //it.setVisibility(View.GONE) // скрываем выбранную
                            //last?.setVisibility(View.GONE) // скрываем выбранную ранее
                        } else {
                                Log.e("Looks","$choosen")
                            it.setText("") // закрываем выбранную
                            last?.setText("")// закрываем выбранную ранее
                        }
                            choosen = ""
                            last = null
                        }, 2000)
                        /*if (couples[it]===choosen){ // если значения совпадают
                            it.setVisibility(View.GONE) // скрываем выбранную
                            last?.setVisibility(View.GONE) // скрываем выбранную ранее
                        } else {
                            it.setText("") // закрываем выбранную
                            last?.setText("")// закрываем выбранную ранее
                        }*/
                        //last = null // обнуляем выбранную ранее
                        /*choosen = ""
                        last = null*/
                    }
                }
            }
        }
    }

    fun RandGen(){
        var pl = 0
        val arr = arrayOf(0,0,0,0,0,0,0,0,0,0,0,0)
        repeat(2){
            var s = 6
            do {
                pl = Random.nextInt(0, 12)
                if (arr[pl] == 0) {
                    arr[pl]=s
                    s--
                }
            } while(s>0)
        }
        couples.put(findViewById(R.id.button1),arr[0].toString())
        couples.put(findViewById(R.id.button2),arr[1].toString())
        couples.put(findViewById(R.id.button3),arr[2].toString())
        couples.put(findViewById(R.id.button4),arr[3].toString())
        couples.put(findViewById(R.id.button5),arr[4].toString())
        couples.put(findViewById(R.id.button6),arr[5].toString())
        couples.put(findViewById(R.id.button7),arr[6].toString())
        couples.put(findViewById(R.id.button8),arr[7].toString())
        couples.put(findViewById(R.id.button9),arr[8].toString())
        couples.put(findViewById(R.id.button10),arr[9].toString())
        couples.put(findViewById(R.id.button11),arr[10].toString())
        couples.put(findViewById(R.id.button12),arr[11].toString())
    }
}
