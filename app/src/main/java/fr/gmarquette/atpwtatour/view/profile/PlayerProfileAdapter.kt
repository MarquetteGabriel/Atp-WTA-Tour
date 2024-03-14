package fr.gmarquette.atpwtatour.view.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.gmarquette.atpwtatour.R

class PlayerProfileAdapter(private val menuList: List<String>,
    private val clickListener: (String) -> Unit) : RecyclerView.Adapter<PlayerProfileAdapter.ViewHolder>()
{

    class ViewHolder(itemView: View, clickAtPosition: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val menuName = itemView.findViewById(R.id.playerProfileItemTextView) as TextView

        init {
            itemView.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.player_profile_item, parent, false))
        {
            clickListener(menuList[it])
        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuName = menuList[position]
        holder.menuName.text = menuName

        holder.itemView.setOnClickListener {
            clickListener(menuList[position])
        }
    }
}