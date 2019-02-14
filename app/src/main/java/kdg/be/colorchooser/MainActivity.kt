package kdg.be.colorchooser

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    private lateinit var rSb:SeekBar
    private lateinit var gSb:SeekBar
    private lateinit var bSb:SeekBar
    private lateinit var rEt:EditText
    private lateinit var gEt:EditText
    private lateinit var bEt:EditText
    private lateinit var hexEt:EditText
    private lateinit var colorV:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        addEventListeners()
    }

    private fun initializeViews(){
        rSb = findViewById(R.id.rSeekBar)
        gSb = findViewById(R.id.gSeekBar)
        bSb = findViewById(R.id.bSeekBar)
        rEt = findViewById(R.id.rEditText)
        gEt = findViewById(R.id.gEditText)
        bEt = findViewById(R.id.bEditText)
        hexEt = findViewById(R.id.hexEditText)
        colorV = findViewById(R.id.colorView)
    }

    private fun addEventListeners(){
        val color:Int = Color.YELLOW
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)

        rSb.progress = red
        rEt.setText(red.toString())
        gSb.progress = green
        gEt.setText(green.toString())
        bSb.progress = blue
        bEt.setText(blue.toString())
        hexEt.setText(String.format("%06X", Color.argb(0, red, green, blue)))
        colorV.setBackgroundColor(color)
    }
}
