package com.wafflestudio.spring2026.meeting.repository

import com.wafflestudio.spring2026.meeting.model.Meeting
import org.springframework.stereotype.Repository

@Repository
class MeetingRepository {
    // ponytail: sequential seminar store; replace with a database-backed repository before concurrent use.
    private val meetings = mutableMapOf<Long, Meeting>()
    private var nextId = 1L

    fun save(
        title: String,
        capacity: Int,
    ): Meeting {
        val meeting = Meeting(
            id = nextId,
            title = title,
            capacity = capacity,
        )

        nextId += 1
        meetings[meeting.id] = meeting

        return meeting
    }

    fun findById(id: Long): Meeting? = meetings[id]

    fun findAll(): List<Meeting> = meetings.values.toList()

    fun update(id: Long, title: String?, capacity: Int?): Meeting? {
        val existing = meetings[id] ?: return null

        val updated = Meeting(
            id = existing.id,
            title = title ?: existing.title,
            capacity = capacity ?: existing.capacity,
        )

        meetings[id] = updated
        return updated
    }

    fun delete(id: Long): Meeting? = meetings.remove(id)
}
