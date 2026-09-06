package by.arsy.androidstudybytinkoff.event

import by.arsy.androidstudybytinkoff.R


class EventGenerator {

    fun getGeneratedEvents(count: Int): List<Event> {
        val eventList = mutableListOf<Event>()

        repeat(count) {
            eventList.add(Event(
                R.drawable.calendar,
                "name$it",
                "1${it % 10}:00"
            ))
        }

        return eventList
    }
}