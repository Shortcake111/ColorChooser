package kdg.be.colorchooser

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    private lateinit var redSb: SeekBar
    private lateinit var greenSb: SeekBar
    private lateinit var blueSb: SeekBar
    private lateinit var redEt: EditText
    private lateinit var greenEt: EditText
    private lateinit var blueEt: EditText
    private lateinit var hexEt: EditText
    private lateinit var colorV: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        addEventListeners()
    }

    private fun initializeViews() {
        redSb = findViewById(R.id.rSeekBar)
        greenSb = findViewById(R.id.gSeekBar)
        blueSb = findViewById(R.id.bSeekBar)
        redEt = findViewById(R.id.rEditText)
        greenEt = findViewById(R.id.gEditText)
        blueEt = findViewById(R.id.bEditText)
        hexEt = findViewById(R.id.hexEditText)
        colorV = findViewById(R.id.colorView)
    }

    private fun updateColor(color: Int) {
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)

        redSb.progress = red
        greenSb.progress = green
        blueSb.progress = blue

        redEt.setText(red.toString())
        greenEt.setText(green.toString())
        blueEt.setText(blue.toString())

        hexEt.setText(String.format("%06X", Color.argb(0, red, green, blue)))
        colorV.setBackgroundColor(color)
    }

    private fun addEventListeners() {
        val seekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, newValue: Int, userChanged: Boolean) {
                if (userChanged) {
                    updateColor(Color.rgb(redSb.progress, greenSb.progress, blueSb.progress))
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        }

        redSb.setOnSeekBarChangeListener(seekBarChangeListener)
        greenSb.setOnSeekBarChangeListener(seekBarChangeListener)
        blueSb.setOnSeekBarChangeListener(seekBarChangeListener)
    }
}
