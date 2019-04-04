package me.nelsoncastro.pdm0119_labo4

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_viewer.*

class ViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer)

        val recieverBundle = intent

        vproduct1cont.text = recieverBundle.getStringArrayListExtra("productos")[0]
        vproduct2cont.text = recieverBundle.getStringArrayListExtra("productos")[1]
        vproduct3cont.text = recieverBundle.getStringArrayListExtra("productos")[2]
        vproduct4cont.text = recieverBundle.getStringArrayListExtra("productos")[3]
        vproduct5cont.text = recieverBundle.getStringArrayListExtra("productos")[4]
        vproduct6cont.text = recieverBundle.getStringArrayListExtra("productos")[5]
        vproduct7cont.text = recieverBundle.getStringArrayListExtra("productos")[6]
        vproduct8cont.text = recieverBundle.getStringArrayListExtra("productos")[7]
        vproduct9cont.text = recieverBundle.getStringArrayListExtra("productos")[8]
        vusuario.text = recieverBundle.getStringExtra("username")
        vcorreo.text = recieverBundle.getStringExtra("email")
        vtotal.text = recieverBundle.getStringExtra("total")

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