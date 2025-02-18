package alcala.jose.popcornfactory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
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
        var gridView: GridView =findViewById(R.id.gridview)

        gridView.adapter=adapter

    }
    fun cargarPeliculas(){
        peliculas.add(Pelicula("Big hero 6", R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the\n" +
                "midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go\n" +
                "Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to\n" +
                "uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called\n" +
                "&quot;Big Hero 6.&quot;", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("1917", R.drawable.milnovecientosdiezysiete, R.drawable.milnovecientosdiezysiete_header, "British trenches somewhere in France. World war has been going on for the third year,\n" +
                "heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly,\n" +
                "sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two\n" +
                "young soldiers, Blake and Schofield, are summoned to the general, who instructs them to\n" +
                "send an important message to Colonel MacKenzie in the Second Devonshire Battalion,\n" +
                "whose telephone connection was cut off by the enemy.",arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Leap year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish\n" +
                "tradition which occurs every time the date February 29 rolls around, faces a major setback\n" +
                "when bad weather threatens to derail her planned trip to Dublin. With the help of an\n" +
                "innkeeper, however, her cross-country odyssey just might result in her getting engaged.",arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Men in Black", R.drawable.mib, R.drawable.mibheader, "Based off of the comic book. Unbeknownst to other people, there is a private agency code\n" +
                "named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then,\n" +
                "one of the agency&#39;s finest men only going by the name &quot;K&quot; (Tommy Lee Jones) , is\n" +
                "recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of\n" +
                "the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of\n" +
                "the &quot;Bug&quot; race. He takes the body of a farmer (Vincent D&#39;Onofrio) and heads to New York.\n" +
                "He is searching for a super energy source called &quot;The Galaxy&quot;. Now, Agents J and K must\n" +
                "stop the bug before it can escape with the galaxy.", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the &#39;secret life of toys&#39; when people are not around. When Buzz\n" +
                "Lightyear, a space-ranger, takes Woody&#39;s place as Andy&#39;s favorite toy, Woody doesn&#39;t like\n" +
                "the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and\n" +
                "Woody is accused by all the other toys of having killed him. He has to go out of the house\n" +
                "to look for him so that they can both return to Andys room. But while on the outside they\n" +
                "get into all kind of trouble while trying to get home.",arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Inception", R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing\n" +
                "valuable secrets from deep within the subconscious during the dream state, when the\n" +
                "mind is at its most vulnerable. Cobb&#39;s rare ability has made him a coveted player in this\n" +
                "treacherous new world of corporate espionage, but it has also made him an international\n" +
                "fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at\n" +
                "redemption. One last job could give him his life back but only if he can accomplish the\n" +
                "impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to\n" +
                "pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it\n" +
                "could be the perfect crime. But no amount of careful planning or expertise can prepare the\n" +
                "team for the dangerous enemy that seems to predict their every move. An enemy that only\n" +
                "Cobb could have seen coming.",arrayListOf<Cliente>()))
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

            imagen.setImageResource(pelicula.image)
            titulo.setText(pelicula.titulo)

            imagen.setOnClickListener(){
                var seatsAvailable=20-pelicula.seats.size
                Log.d("SEATS", "$seatsAvailable")
                var intent=Intent(context, DetallePelicula::class.java)
                intent.putExtra("titulo",pelicula.titulo)
                intent.putExtra("sinopsis",pelicula.sinopsis)
                intent.putExtra("header",pelicula.header)
                intent.putExtra("image",pelicula.image)
                intent.putExtra("numberSeats",(20-pelicula.seats.size))
                intent.putExtra("pos", position)
                context!!.startActivity(intent)
            }
            return vista
        }
    }
}