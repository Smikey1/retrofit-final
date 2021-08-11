package com.kiran.retrofitstarterbatch26.ui.api

import com.kiran.retrofitstarterbatch26.ui.response.StudentResponse
import retrofit2.Response
import retrofit2.http.GET

interface StudentAPI {
    @GET("student/")
    suspend fun fetchAllStudent():Response<StudentResponse>
}