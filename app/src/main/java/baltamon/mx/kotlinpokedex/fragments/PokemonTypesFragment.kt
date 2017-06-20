package baltamon.mx.kotlinpokedex.fragments

import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import baltamon.mx.kotlinpokedex.R
import baltamon.mx.kotlinpokedex.adapters.RVAdapterPokemonTypes
import baltamon.mx.kotlinpokedex.models.NamedAPIResource
import kotlinx.android.synthetic.main.fragment_pokemon_moves.view.*

/**
 * Created by Baltazar Rodriguez on 01/06/2017.
 */

private const val MY_OBJECT_KEY = "types_list"

class PokemonTypesFragment : Fragment() {

    companion object {
        fun newInstance(types: ArrayList<NamedAPIResource>): PokemonTypesFragment {
            val fragment = PokemonTypesFragment()
            val bundle = Bundle()
            bundle.putParcelableArrayList(MY_OBJECT_KEY, types)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_types, container, false)
        showMoves(view)
        return view
    }

    fun showMoves(view: View) {
        val recyclerView = view.recycler_view
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val moves = arguments.getParcelableArrayList<Parcelable>(MY_OBJECT_KEY) as ArrayList<NamedAPIResource>
        val adapter = RVAdapterPokemonTypes(moves, context)

        recyclerView.adapter = adapter
    }

}