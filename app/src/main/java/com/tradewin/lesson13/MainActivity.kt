package com.tradewin.lesson13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.doAfterTextChanged
/**
 * Исчисляемые
        resources.getQuantityString(
        R.plurals.years,
        text.toString().toInt(),
        text.toString().toInt()
        )

 *Неисчисляемые с данными
         String.format(resources.getString(R.string.ios), cbIos.isChecked.toString())

 *Неисчисляемые с данными
        resources.getString(R.string.empty)
 **/


class MainActivity : AppCompatActivity() {

    private lateinit var cbAndroid: CheckBox
    private lateinit var cbIos: CheckBox
    private lateinit var tvCheckBoxSelected: TextView
    private lateinit var tvAge: TextView
    private lateinit var etAge: EditText

    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbAndroid = findViewById(R.id.cbAndroid)
        cbIos = findViewById(R.id.cbIos)
        tvCheckBoxSelected = findViewById(R.id.tvCheckBoxSelected)
        radioGroup = findViewById(R.id.radioGroup)
        tvAge = findViewById(R.id.tvAge)
        etAge = findViewById(R.id.etAge)
        etAge.doAfterTextChanged { text ->
            if (text.toString() != "") {
                tvAge.text = resources.getQuantityString(
                    R.plurals.years,
                    text.toString().toInt(),
                    text.toString().toInt()
                )
            } else {
                tvAge.text = resources.getString(R.string.empty)
            }

        }

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.first -> {
                    Toast.makeText(this, "first", Toast.LENGTH_SHORT).show()
                }
                R.id.second -> {
                    Toast.makeText(this, "second", Toast.LENGTH_SHORT).show()
                }
                R.id.four -> {
                    Toast.makeText(this, "four", Toast.LENGTH_SHORT).show()
                }
                R.id.seven -> {
                    Toast.makeText(this, "seven", Toast.LENGTH_SHORT).show()
                }
                R.id.twentyOne -> {
                    Toast.makeText(this, "twentyOne", Toast.LENGTH_SHORT).show()
                }
                R.id.hundred -> {
                    Toast.makeText(this, "hundred", Toast.LENGTH_SHORT).show()
                }
            }
        }
        cbAndroid.setOnCheckedChangeListener { compoundButton, b ->
            tvCheckBoxSelected.text =
                String.format(resources.getString(R.string.android), b.toString(), (!b).toString())
        }

        cbIos.setOnClickListener {
            tvCheckBoxSelected.text =
                String.format(resources.getString(R.string.ios), cbIos.isChecked.toString())
        }


    }
}