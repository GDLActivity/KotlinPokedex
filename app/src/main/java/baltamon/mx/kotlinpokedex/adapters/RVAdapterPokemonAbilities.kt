package baltamon.mx.kotlinpokedex.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import baltamon.mx.kotlinpokedex.R
import baltamon.mx.kotlinpokedex.models.PokemonAbility
import kotlinx.android.synthetic.main.item_abilities.view.*

/**
 * Created by Baltazar Rodriguez on 13/06/2017.
 */
class RVAdapterPokemonAbilities internal constructor(abilities: List<PokemonAbility>, context: Context) :
        RecyclerView.Adapter<RVAdapterPokemonAbilities.AbilityViewHolder>() {

    internal var abilities = abilities
    internal var context = context

    class AbilityViewHolder internal constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        internal var moveName = itemView.tv_ability_name
        internal var cardView = itemView.card_view
    }

    override fun getItemCount(): Int {
        return abilities.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_abilities, parent, false)
        val pvh = RVAdapterPokemonAbilities.AbilityViewHolder(v)
        return pvh
    }

    override fun onBindViewHolder(holder: AbilityViewHolder, position: Int) {
        holder.moveName.text = abilities[position].ability.name
        holder.cardView.setOnClickListener {  }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
    }
}