package com.example.scoreboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var local : Int = 0
    private var visitante : Int = 0

    private var juegosLocal : Int = 0
    private var juegosVisitante : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bLocal : Button         = findViewById(R.id.bLocal)
        val bVisitante : Button     = findViewById(R.id.bVisitante)

        bLocal.setOnClickListener {
            local++
            ganaLocal()
            actualizarMarcadores()
        }

        bVisitante.setOnClickListener {
            visitante++
            actualizarMarcadores()
        }

    }

    private fun ganaLocal() {
        //Voleibol
        if(local > 14){ //¿ganó el juego?
            juegosLocal++
            actualizarMarcadoresJuegos()

            reiniciarMarcadores()
        }
    }

    // se define el layout del menú de la Actividad
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // click a las opciones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.opc_futbol -> { // cuando click sobre Fútbol
                reiniciarMarcadores() //números rojo
                reiniciarMarcadoresJuegos() //números amarillos

                //R.string.futbol -> ID númerico del string
                //getString función que devuelve el valor del String dado por el Id
                actualizarDeporte( getString(R.string.futbol) )
            }
            R.id.opc_tenis -> { // cuando click sobre Tenis
                reiniciarMarcadores()
                reiniciarMarcadoresJuegos()

                actualizarDeporte( getString(R.string.tenis) )
            }
            R.id.opc_voleibol -> { // cuando click sobre Voleibol
                reiniciarMarcadores()
                reiniciarMarcadoresJuegos()

                actualizarDeporte( getString(R.string.voleibol) )
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun reiniciarMarcadores(){
        local = 0
        visitante = 0
        actualizarMarcadores()
    }

    private fun reiniciarMarcadoresJuegos(){
        juegosLocal = 0
        juegosVisitante = 0
        actualizarMarcadoresJuegos()
    }

    private fun actualizarDeporte( deporte: String ){
        val tvDeporte : TextView = findViewById(R.id.tvDeporte)
        tvDeporte.setText( deporte )
    }

    private fun actualizarMarcadores() {
        val tvLocal : TextView = findViewById(R.id.tvLocal)
        tvLocal.setText( local.toString() )

        val tvVisitante : TextView = findViewById(R.id.tvVisitante)
        tvVisitante.setText( visitante.toString() )
    }

    private fun actualizarMarcadoresJuegos(){
        val tvSetLocal : TextView       = findViewById(R.id.tvSetLocal)
        val tvSetVisitante : TextView   = findViewById(R.id.tvSetVisitante)

        tvSetLocal.setText(juegosLocal.toString())
        tvSetVisitante.setText(juegosVisitante.toString())
    }
}