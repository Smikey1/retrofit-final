package com.kiran.retrofitstarterbatch26.ui.repository

import com.kiran.retrofitstarterbatch26.ui.api.MyApiRequest
import com.kiran.retrofitstarterbatch26.ui.api.StudentAPI
import com.kiran.retrofitstarterbatch26.ui.api.ServiceBuilder
import com.kiran.retrofitstarterbatch26.ui.response.StudentResponse

class StudentRepository :MyApiRequest() {
    // retrofit ko object/instance chaiyo so that retroft ma define bhako method(such as login, register) lai call garna sakos hamile
    private val studentAPI =
        ServiceBuilder.buildService(StudentAPI::class.java)

    suspend fun fetchAllStudent():StudentResponse {
        return apiRequest {
            studentAPI.fetchAllStudent()
        }
    }










}
