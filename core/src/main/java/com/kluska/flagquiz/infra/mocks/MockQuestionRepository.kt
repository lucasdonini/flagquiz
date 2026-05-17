package com.kluska.flagquiz.infra.mocks

import com.kluska.flagquiz.model.Question
import com.kluska.flagquiz.repository.QuestionRepository

class MockQuestionRepository : QuestionRepository {

    private val allQuestions = listOf(
        Question("br", "Brasil", "América do Sul"),
        Question("ar", "Argentina", "América do Sul"),
        Question("us", "Estados Unidos", "América do Norte"),
        Question("jp", "Japão", "Ásia"),
        Question("de", "Alemanha", "Europa"),
        Question("fr", "França", "Europa"),
        Question("au", "Austrália", "Oceania"),
        Question("za", "África do Sul", "África"),
    )

    override suspend fun getQuestions(amount: Int): List<Question> = allQuestions
        .shuffled()
        .take(amount)

}
