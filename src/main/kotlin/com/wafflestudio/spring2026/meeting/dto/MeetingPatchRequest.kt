package com.wafflestudio.spring2026.meeting.dto

import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Pattern

data class MeetingPatchRequest(
    @field:Pattern(regexp = ".*\\S.*", message = "모임 제목은 비어 있을 수 없습니다.")
    val title: String?,

    @field:Positive(message = "모임 정원은 1명 이상이어야 합니다.")
    val capacity: Int?,
)