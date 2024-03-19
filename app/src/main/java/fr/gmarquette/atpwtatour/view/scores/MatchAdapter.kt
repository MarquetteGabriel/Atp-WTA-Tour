package fr.gmarquette.atpwtatour.view.scores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.gmarquette.atpwtatour.R
import fr.gmarquette.atpwtatour.accessData.extractApis.FlagsAPI
import fr.gmarquette.atpwtatour.databinding.CalendarHeaderBinding
import fr.gmarquette.atpwtatour.databinding.MatchBinding
import fr.gmarquette.atpwtatour.view.scores.MatchObject.MATCH_HEADER
import fr.gmarquette.atpwtatour.view.scores.MatchObject.MATCH_ITEM

class MatchAdapter(private val clickListener: (MatchData.Item) -> Unit, private val clickListenerTournament: (MatchData.Header) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    class MatchesViewHolder(private val matchesBinding: MatchBinding, clickAtPosition: (Int) -> Unit
    ) : RecyclerView.ViewHolder(matchesBinding.root) {

        init {
            itemView.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }

        fun bind(matches: MatchData.Item) {
            val context = matchesBinding.root.context
            val resources = context.resources
            matchesBinding.match = matches
            if(matches.match.score.playerOneSetOne == "6" && matches.match.score.playerTwoSetOne != "7")
            {
                matchesBinding.set1player2Text.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerOneSetTwo == "6" && matches.match.score.playerTwoSetTwo != "7")
            {
                matchesBinding.set2player2Text.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerOneSetThree == "6" && matches.match.score.playerTwoSetThree != "7")
            {
                matchesBinding.set3player2Text.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerOneSetFour == "6" && matches.match.score.playerTwoSetFour != "7")
            {
                matchesBinding.set4player2Text.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerOneSetFive == "6" && matches.match.score.playerTwoSetFive != "7")
            {
                matchesBinding.set5player2Text.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerTwoSetOne == "6" && matches.match.score.playerOneSetOne != "7")
            {
                matchesBinding.set1player1Text.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerTwoSetTwo == "6" && matches.match.score.playerOneSetTwo != "7")
            {
                matchesBinding.set2player1Text.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerTwoSetThree == "6" && matches.match.score.playerOneSetThree != "7")
            {
                matchesBinding.set3player1Text.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerTwoSetFour == "6" && matches.match.score.playerOneSetFour != "7")
            {
                matchesBinding.set4player1Text.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerTwoSetFive == "6" && matches.match.score.playerOneSetFive != "7")
            {
                matchesBinding.set5player1Text.setTextColor(resources.getColor(R.color.loose))

            }
            if(matches.match.score.playerOneSetOne == "7")
            {
                matchesBinding.set1player2Text.setTextColor(resources.getColor(R.color.loose))
                matchesBinding.tiebreak1player2.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerOneSetTwo == "7")
            {
                matchesBinding.set2player2Text.setTextColor(resources.getColor(R.color.loose))
                matchesBinding.tiebreak2player2.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerOneSetThree == "7")
            {
                matchesBinding.set3player2Text.setTextColor(resources.getColor(R.color.loose))
                matchesBinding.tiebreak3player2.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerOneSetFour == "7")
            {
                matchesBinding.set4player2Text.setTextColor(resources.getColor(R.color.loose))
                matchesBinding.tiebreak4player2.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerOneSetFive == "7")
            {
                matchesBinding.set5player2Text.setTextColor(resources.getColor(R.color.loose))
                matchesBinding.tiebreak5player2.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerTwoSetOne == "7")
            {
                matchesBinding.set1player1Text.setTextColor(resources.getColor(R.color.loose))
                matchesBinding.tiebreak1player1.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerTwoSetTwo == "7")
            {
                matchesBinding.set2player1Text.setTextColor(resources.getColor(R.color.loose))
                matchesBinding.tiebreak2player1.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerTwoSetThree == "7")
            {
                matchesBinding.set3player1Text.setTextColor(resources.getColor(R.color.loose))
                matchesBinding.tiebreak3player1.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerTwoSetFour == "7")
            {
                matchesBinding.set4player1Text.setTextColor(resources.getColor(R.color.loose))
                matchesBinding.tiebreak4player1.setTextColor(resources.getColor(R.color.loose))
            }
            if(matches.match.score.playerTwoSetFive == "7")
            {
                matchesBinding.set5player1Text.setTextColor(resources.getColor(R.color.loose))
                matchesBinding.tiebreak5player1.setTextColor(resources.getColor(R.color.loose))
            }

            if(!matches.match.score.isLive())
            {
                if(matches.match.score.getResult() == 1)
                {
                    matchesBinding.player1.setTextColor(resources.getColor(R.color.loose))
                    matchesBinding.serie1.setTextColor(resources.getColor(R.color.loose_tete_de_serie))
                }
                else
                {
                    matchesBinding.player2.setTextColor(resources.getColor(R.color.loose))
                    matchesBinding.serie2.setTextColor(resources.getColor(R.color.loose_tete_de_serie))
                }
            }



            FlagsAPI.getFlag(matches.match.playerOne.nationality, matchesBinding.flag1, context)
            FlagsAPI.getFlag(matches.match.playerTwo.nationality, matchesBinding.flag2, context)
            matchesBinding.executePendingBindings()
        }

    }

    class HeaderViewHolder(private val matchesHeaderBinding: CalendarHeaderBinding, clickAtPosition: (Int) -> Unit) : RecyclerView.ViewHolder(matchesHeaderBinding.root)  {

        init {
            itemView.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }

        fun bind(header: MatchData.Header) {
            matchesHeaderBinding.header = header.tournamentName
            matchesHeaderBinding.executePendingBindings()
        }
    }

    private val itemList = arrayListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MATCH_HEADER -> HeaderViewHolder(CalendarHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)) {
                clickListenerTournament(itemList[it] as MatchData.Header)}
            MATCH_ITEM -> MatchesViewHolder(MatchBinding.inflate(LayoutInflater.from(parent.context), parent, false))  {
                clickListener(itemList[it] as MatchData.Item)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind(itemList[position] as MatchData.Header)
            is MatchesViewHolder -> holder.bind(itemList[position] as MatchData.Item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is MatchData.Header -> MATCH_HEADER
            is MatchData.Item -> MATCH_ITEM
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }

    fun updateList(list: List<Any>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }
}