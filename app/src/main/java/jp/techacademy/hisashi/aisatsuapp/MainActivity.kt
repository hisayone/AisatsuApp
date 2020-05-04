package jp.techacademy.hisashi.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import  android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener{
            //テキストビューの表示内容を初期化
            textview1.text = ""
            //タイムピッカーダイアログを呼び出し
            showTimePickerDialog()
        }
    }

    //タイムピッカーダイアログの呼び出し関数
    private fun showTimePickerDialog() {
        val ohayorange = 2..9 //おはようの時間を設定(2:00 ~ 9:59 )
        val konnichiwarange = 10..17//こんにちはの時間を設定(10:00 ~ 17:59)
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->

                //時刻に応じて挨拶を変更
                if (hour in ohayorange){
                    //おはよう(2:00 ~ 9:59 )
                    textview1.text = "おはよう"
                }else if(hour in konnichiwarange ){
                    //こんにちは(10:00 ~ 17:59)
                    textview1.text = "こんにちは"
                }else{
                    //こんばんは(上記以外の時刻なので18：00~1:59)
                    textview1.text = "こんばんは"
                }

                Log.d("UI_PARTS", "$hour:$minute")
            },
            13, 0, true)
        timePickerDialog.show()
    }

}
