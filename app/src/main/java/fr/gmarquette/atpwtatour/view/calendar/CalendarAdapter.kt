package fr.gmarquette.atpwtatour.view.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.gmarquette.atpwtatour.databinding.CalendarHeaderBinding
import fr.gmarquette.atpwtatour.databinding.TournamentBinding
import fr.gmarquette.atpwtatour.view.calendar.Calendar.TYPE_HEADER
import fr.gmarquette.atpwtatour.view.calendar.Calendar.TYPE_ITEM

class CalendarAdapter(private val clickListener: (CalendarTournament.Item) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class TournamentViewHolder(private val tournamentBinding: TournamentBinding, clickAtPosition: (Int) -> Unit
    ) : RecyclerView.ViewHolder(tournamentBinding.root) {

        init {
            itemView.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }

        fun bind(tournament: CalendarTournament.Item) {
            tournamentBinding.tournament = tournament
            tournamentBinding.executePendingBindings()
        }
    }

    class HeaderViewHolder(private val calendarHeaderBinding: CalendarHeaderBinding) : RecyclerView.ViewHolder(calendarHeaderBinding.root)  {
        fun bind(header: CalendarTournament.Header) {
            calendarHeaderBinding.header = header.month
            calendarHeaderBinding.executePendingBindings()
        }
    }

    private val itemList = arrayListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(CalendarHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TYPE_ITEM -> TournamentViewHolder(TournamentBinding.inflate(LayoutInflater.from(parent.context), parent, false))  {
                clickListener(itemList[it] as CalendarTournament.Item)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }

    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind(itemList[position] as CalendarTournament.Header)
            is TournamentViewHolder -> holder.bind(itemList[position] as CalendarTournament.Item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is CalendarTournament.Header -> TYPE_HEADER
            is CalendarTournament.Item -> TYPE_ITEM
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }

    fun updateList(updatedList: List<Any>) {
        itemList.clear()
        itemList.addAll(updatedList)
        notifyDataSetChanged()
    }
}
