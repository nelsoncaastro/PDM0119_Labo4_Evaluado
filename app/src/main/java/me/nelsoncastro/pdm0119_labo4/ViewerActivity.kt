package me.nelsoncastro.pdm0119_labo4

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_viewer.*
import org.json.JSONArray
import org.json.JSONObject

class ViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer)

        val recieverBundle = intent
        val Textviews: ArrayList<TextView> = arrayListOf(vproduct1cont, vproduct2cont, vproduct3cont, vproduct4cont, vproduct5cont, vproduct6cont, vproduct7cont, vproduct8cont, vproduct9cont)
        val jsonroot = JSONObject(recieverBundle.getStringExtra("json"))
        val jsonproducts = jsonroot.getJSONArray("products")

        vusuario.text = jsonroot.getString("username")
        vcorreo.text = jsonroot.getString("email")
        vtotal.text = jsonroot.getString("total")
        for ((index, cont) in Textviews.withIndex()){
           cont.text = jsonproducts[index].toString()
        }

        sharebutton.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT,
                    """FACTURA DE COMPRA
                        |
                        |Cliente: ${vusuario.text}
                        |Correo: ${vcorreo.text}
                        |Producto 1: ${vproduct1cont.text}
                        |Producto 2: ${vproduct2cont.text}
                        |Producto 3: ${vproduct3cont.text}
                        |Producto 4: ${vproduct4cont.text}
                        |Producto 5: ${vproduct5cont.text}
                        |Producto 6: ${vproduct6cont.text}
                        |Producto 7: ${vproduct7cont.text}
                        |Producto 8: ${vproduct8cont.text}
                        |Producto 9: ${vproduct9cont.text}
                        |
                        |Total de productos: ${vtotal.text}
                    """.trimMargin())
            shareIntent.type = "text/plain"
            startActivity(Intent.createChooser(shareIntent, "Share ticket"))
        }
    }

}