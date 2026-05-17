package com.kluska.flagquiz.repository

import com.kluska.flagquiz.model.Question

interface QuestionRepository {
    suspend fun getQuestions(amount: Int): List<Question>
}
