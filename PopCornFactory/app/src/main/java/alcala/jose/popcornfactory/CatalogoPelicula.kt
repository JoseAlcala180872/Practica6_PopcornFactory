package alcala.jose.popcornfactory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CatalogoPelicula : AppCompatActivity() {
    var adapter:PeliculaAdapter?=null
    var peliculas=ArrayList<Pelicula>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_catalogo_pelicula)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarPeliculas()
        adapter=PeliculaAdapter(this,peliculas)
        //gridview.adapter=adapter

    }
    fun cargarPeliculas(){
        peliculas.add(Pelicula("Bones", R.drawable.bones, R.drawable.bonesheader, "Dr. Temperance Brennan is a brilliant, but lonely, anthropologist whom is approached by an\n" +
                "ambitious FBI agent, named Seely Booth, to help the bureau solve a series of unsolved crimes by\n" +
                "identifying the long-dead bodies of missing persons by their bone structure. But both Agent Booth\n" +
                "\n" +
                "and Dr. Brennan and her team come up again a variety of interference from red tape, corruption,\n" +
                "and local noncooperation."))
    }
    class PeliculaAdapter: BaseAdapter {
        var peliculas=ArrayList<Pelicula>()
        var context: Context?=null

        constructor(context: Context, peliculas: ArrayList<Pelicula>){
            this.peliculas=peliculas
            this.context=context
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var pelicula=peliculas[position]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista=inflator.inflate(R.layout.pelicula, null)
            //imagen
            var imagen:ImageView=vista.findViewById(R.id.iv_pelicula)
            //titulo
            var titulo:TextView=vista.findViewById(R.id.tv_titulo)


            imagen.setOnClickListener(){
                var intent=Intent(context, DetallePelicula::class.java)
                intent.putExtra("titulo",pelicula.titulo)
                intent.putExtra("image",pelicula.image)
                intent.putExtra("header",pelicula.header)
                intent.putExtra("sinopsis",pelicula.sinopsis)
                context!!.startActivity(intent)
            }
            return vista
        }
    }
}