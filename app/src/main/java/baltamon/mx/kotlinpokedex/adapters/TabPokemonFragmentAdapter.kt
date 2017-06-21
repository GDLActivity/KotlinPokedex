package baltamon.mx.kotlinpokedex.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import baltamon.mx.kotlinpokedex.fragments.PokemonAbilitiesFragment
import baltamon.mx.kotlinpokedex.fragments.PokemonAboutFragment
import baltamon.mx.kotlinpokedex.fragments.PokemonMovesFragment
import baltamon.mx.kotlinpokedex.models.NamedAPIResource
import baltamon.mx.kotlinpokedex.models.Pokemon

/**
 * Created by Baltazar Rodriguez on 28/05/2017.
 */
class TabPokemonFragmentAdapter(fm: FragmentManager, pokemon: Pokemon) : FragmentPagerAdapter(fm) {

    internal var pokemon: Pokemon = pokemon

    override fun getItem(position: Int): Fragment {
        when (position){
            0 -> return PokemonAboutFragment().newInstance(pokemon)
            1 -> {
                val abilities: ArrayList<NamedAPIResource> = ArrayList()
                pokemon.abilities.mapTo(abilities) {it.ability}
                return PokemonAbilitiesFragment().newInstance(abilities)
            }
            else -> {
                val moves: ArrayList<NamedAPIResource> = ArrayList()
                pokemon.moves.mapTo(moves) {it.move}
                return PokemonMovesFragment.newInstance(moves)
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        val titles = arrayOf("About", "Abilities", "Moves")
        return titles[position]
    }


}