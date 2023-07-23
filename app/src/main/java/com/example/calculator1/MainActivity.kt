package com.example.calculator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var str = ""
        var operator = true
        var dot = false

        /*textviw*/
        val history = findViewById<TextView>(R.id._history)
        val output = findViewById<TextView>(R.id._output)

        /*row1*/
        /*root ids*/
        val btnClr = findViewById<Button>(R.id.clr)
        val btnMod = findViewById<Button>(R.id.mod)
        val btnDel = findViewById<Button>(R.id.del)
        val btnDiv = findViewById<Button>(R.id.div)
        /*click listeners*/
        btnClr.setOnClickListener {
            str = ""
            history.text = str
            output.text = str
            operator = true
            dot = false
        }
        btnMod.setOnClickListener {
            if(!operator){
                str += "%"
                output.text = str
                operator = true
                dot = false
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
        btnDel.setOnClickListener {
            str = str.dropLast(1)
            output.text = str
        }
        btnDiv.setOnClickListener {
            if(!operator){
                str += "/"
                output.text = str
                operator = true
                dot = false
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }

        /*row2*/
        /*root ids*/
        val btn7 = findViewById<Button>(R.id.seven)
        val btn8 = findViewById<Button>(R.id.eight)
        val btn9 = findViewById<Button>(R.id.nine)
        val btnMul = findViewById<Button>(R.id.mul)
        /*click listeners*/
        btn7.setOnClickListener {
            str += "7"
            output.text = str
            operator = false
        }
        btn8.setOnClickListener {
            str += "8"
            output.text = str
            operator = false
        }
        btn9.setOnClickListener {
            str += "9"
            output.text = str
            operator = false
        }
        btnMul.setOnClickListener {
            if(!operator){
                str += "*"
                operator = true
                output.text = str
                dot = false
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }

        /*row3*/
        /*root ids*/
        val btn4 = findViewById<Button>(R.id.four)
        val btn5 = findViewById<Button>(R.id.five)
        val btn6 = findViewById<Button>(R.id.six)
        val btnSub = findViewById<Button>(R.id.sub)
        /*click listeners*/
        btn4.setOnClickListener {
            str += "4"
            output.text = str
            operator = false
        }
        btn5.setOnClickListener {
            str += "5"
            output.text = str
            operator = false
        }
        btn6.setOnClickListener {
            str += "6"
            output.text = str
            operator = false
        }
        btnSub.setOnClickListener {
            if(!operator){
                str += "-"
                operator = true
                output.text = str
                dot = false
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }

        /*row4*/
        /*root ids*/
        val btn1 = findViewById<Button>(R.id.one)
        val btn2 = findViewById<Button>(R.id.two)
        val btn3 = findViewById<Button>(R.id.three)
        val btnAdd = findViewById<Button>(R.id.add)
        /*click listeners*/
        btn1.setOnClickListener {
            str += "1"
            output.text = str
            operator = false
        }
        btn2.setOnClickListener {
            str += "2"
            output.text = str
            operator = false
        }
        btn3.setOnClickListener {
            str += "3"
            output.text = str
            operator = false
        }
        btnAdd.setOnClickListener {
            if(!operator){
                str += "+"
                operator = true
                output.text = str
                dot = false
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }

        /*row5*/
        /*root ids*/
        val btn0 = findViewById<Button>(R.id.zero)
        val btnDot = findViewById<Button>(R.id.dot)
        val btnEqual = findViewById<Button>(R.id.equal)
        /*click listeners*/
        btn0.setOnClickListener {
            str += "0"
            output.text = str
            operator = false
        }
        btnDot.setOnClickListener {
            if(!dot){
                str += "."
                output.text = str
                operator = false
                dot = true
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
        btnEqual.setOnClickListener {
            if(!operator){
                val exp = ExpressionBuilder(str).build()
                val res = exp.evaluate()
                output.text = res.toString()
                history.text = str
                str = res.toString()
                operator = false
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }

    }
}