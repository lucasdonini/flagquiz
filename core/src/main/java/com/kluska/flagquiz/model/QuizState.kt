package com.kluska.flagquiz.model

data class QuizState(
    val questions: List<Question>,
    val currentIndex: Int = 0,
    val results: List<QuizResult> = emptyList()
) {
    val currentQuestion: Question get() = questions[currentIndex]
    val isFinished: Boolean get() = currentIndex >= questions.size
    val score: Int get() = results.filterIsInstance<QuizResult.Correct>().size
}
