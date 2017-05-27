package baltamon.mx.kotlinpokedex

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        setUpNavigationView()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home)
            openDrawer()
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (isDrawerOpen())
            closeDrawer()
        else
            super.onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val option: Int = item.itemId
        when(option){
            R.id.item_pokemons -> {showToast("Pokemones")}
            R.id.item_moves -> {showToast("Moves")}
            R.id.item_abilities -> {showToast("Abilities")}
            R.id.item_types -> {showToast("Types")}
            else -> showToast("No option selected")
        }

        return true
    }

    fun setUpNavigationView(){
        val navigationView : NavigationView? = findViewById(R.id.navigation_view) as NavigationView
        navigationView!!.setNavigationItemSelectedListener(this)
    }


    fun setToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)

        val actionBar : ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.title = "Pokedex"
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu)
            actionBar.setDisplayShowTitleEnabled(true)
        }
    }

    fun openDrawer(){
        val drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        drawerLayout.openDrawer(GravityCompat.START)
    }

    fun closeDrawer(){
        val drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        drawerLayout.closeDrawers()
    }

    fun isDrawerOpen() : Boolean{
        val drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            return true
        return false
    }

    fun showToast(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
