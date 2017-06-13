package baltamon.mx.kotlinpokedex.fragments

import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import baltamon.mx.kotlinpokedex.R
import baltamon.mx.kotlinpokedex.models.Pokemon
import kotlinx.android.synthetic.main.fragment_pokemon_about.*

/**
 * Created by Baltazar Rodriguez on 28/05/2017.
 */

private const val MY_OBJECT_KEY = "pokemon_object"

class PokemonAboutFragment : Fragment() {

    fun newInstance(pokemon: Pokemon): PokemonAboutFragment{
        val fragment = PokemonAboutFragment()
        val bundle = Bundle()
        bundle.putParcelable(MY_OBJECT_KEY, pokemon)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_about, container, false)
        showDetails()
        return view
    }

    fun showDetails(){
        val pokemon: Pokemon = arguments.getParcelable<Parcelable>(MY_OBJECT_KEY) as Pokemon
        tv_pokemon_name.text = pokemon.name
    }

}