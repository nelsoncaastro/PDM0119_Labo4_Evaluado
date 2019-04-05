package me.nelsoncastro.pdm0119_labo4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.text.Layout
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    fun refreshCount(v: TextView) { v.text = addOne(v) }

    fun addOne(v: TextView): String =  (getInt(v) + 1).toString()

    fun getInt(v: TextView): Int = if(isHashtag(v)) 0 else v.text.toString().toInt()

    fun isHashtag(v: TextView): Boolean = v.text.toString() == "#"

    fun fetchEditText(v: EditText): String = if (v.text.isEmpty()) "N/A" else v.text.toString()

    fun getTotal(): Int = (getInt(product1cont)+getInt(product2cont)+getInt(product3cont)+getInt(product4cont)+getInt(product5cont)+getInt(product6cont)+getInt(product7cont)+getInt(product8cont)+getInt(product9cont))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Layouts: ArrayList<ConstraintLayout> = arrayListOf(lproduct1, lproduct2, lproduct3, lproduct4, lproduct5, lproduct6, lproduct7, lproduct8, lproduct9)
        val Textviews: ArrayList<TextView> = arrayListOf(product1cont, product2cont, product3cont, product4cont, product5cont, product6cont, product7cont, product8cont, product9cont)

        for ((index, layout) in Layouts.withIndex()){
            layout.setOnClickListener { refreshCount(Textviews[index]) }
        }



        sendbutton.setOnClickListener {

            val senderjson: String = """
            |{
            |"username":"${fetchEditText(eusuario)}",
            |"email":"${fetchEditText(ecorreo)}",
            |"total":"${getTotal()}",
            |"products":["${getInt(product1cont)}", "${getInt(product2cont)}", "${getInt(product3cont)}", "${getInt(product4cont)}", "${getInt(product5cont)}", "${getInt(product6cont)}", "${getInt(product7cont)}", "${getInt(product8cont)}", "${getInt(product9cont)}"]
            |}
            """.trimMargin()

            val sendIntent = Intent(this, ViewerActivity::class.java)
            sendIntent.putExtra("json", senderjson)
            sendIntent.type = "intern"
            startActivity(sendIntent)
        }
    }

}
