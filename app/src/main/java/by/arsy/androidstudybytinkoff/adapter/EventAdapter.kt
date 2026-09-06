package by.arsy.androidstudybytinkoff.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.arsy.androidstudybytinkoff.R
import by.arsy.androidstudybytinkoff.event.Event

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    var data: List<Event> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.event_item, parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: EventViewHolder,
        position: Int
    ) {
        data[position].let {
            holder.eventImage.setImageResource(it.imageResId)
            holder.eventName.text = it.name
            holder.eventTime.text = it.time
        }
    }

    override fun getItemCount(): Int = data.size

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventImage: ImageView = itemView.findViewById(R.id.event_image)
        val eventName: TextView = itemView.findViewById(R.id.event_name)
        val eventTime: TextView = itemView.findViewById(R.id.event_time)
    }
}