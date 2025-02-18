package alcala.jose.popcornfactory

import alcala.jose.popcornfactory.databinding.ActivityDetallePeliculaBinding
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePelicula : AppCompatActivity() {
    private lateinit var binding: ActivityDetallePeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetallePeliculaBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var buyTickets:Button=findViewById(R.id.buyTickets)
        var bundle=intent.extras
        var ns=0
        var id=-1
        var title=""

        if (bundle!=null){
            ns=bundle.getInt("numberSeats")
            title=bundle.getString("titulo")!!
            binding.ivPeliculaImagen.setImageResource(bundle.getInt("header"))
            binding.tvNombrePelicula.setText(bundle.getString("nombre"))
            binding.tvPeliculaDesc.setText(bundle.getString("sinopsis"))
            binding.seatsLeft.setText("$ns seats available")
            id=bundle.getInt("pos")
        }
        if (ns==0){
            buyTickets.isEnabled=false
        }else{
            buyTickets.setOnClickListener{
                buyTickets.isEnabled=true
                val intent:Intent=Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)

                this.startActivity(intent)
            }
        }

    }
}