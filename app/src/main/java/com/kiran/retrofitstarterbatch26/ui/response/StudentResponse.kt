package com.kiran.retrofitstarterbatch26.ui.response

import com.kiran.retrofitstarterbatch26.ui.model.Student

// server bata aaune response ma hune kura haru
data class StudentResponse(
    val success: Boolean? = null,
    val token: String? = null,
    val data:MutableList<Student>?=null
)
