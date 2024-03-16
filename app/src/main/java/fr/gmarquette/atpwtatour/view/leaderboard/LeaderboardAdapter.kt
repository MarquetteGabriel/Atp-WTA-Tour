package fr.gmarquette.atpwtatour.view.leaderboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.gmarquette.atpwtatour.R
import fr.gmarquette.atpwtatour.model.players.Profile
import fr.gmarquette.atpwtatour.model.players.flags.Flags

class LeaderboardAdapter(private val playerList: List<Profile>, private var context: Context,
                         private val clickListener: (Profile) -> Unit) : RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>()
{

    class ViewHolder(itemView: View, clickAtPosition: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val playerRank = itemView.findViewById(R.id.leaderboardItemRank) as TextView
        val playerUpdate = itemView.findViewById(R.id.leaderboardItemUpdate) as TextView
        val playerFlag = itemView.findViewById(R.id.leaderboardItemFlag) as ImageView
        val playerName = itemView.findViewById(R.id.leaderboardItemName) as TextView
        val playerPoints = itemView.findViewById(R.id.leaderboardItemPoints) as TextView

        init {
            itemView.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_item, parent, false))
        {
            clickListener(playerList[it])
        }
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = playerList[position]

        holder.playerRank.text = player.rank.currentRank.toString()
        holder.playerUpdate.text = player.rank.getRankUpdate(player.rank.previousRank, player.rank.currentRank)
        Flags.getFlag(player.codeID.lowercase(), holder.playerFlag, context)
        holder.playerName.text = player.fullName
        holder.playerPoints.text = player.rank.points.toString()

        holder.itemView.setOnClickListener {
            clickListener(playerList[position])
        }
    }
}