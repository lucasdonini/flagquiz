package com.kluska.flagquiz.model

sealed class QuizResult {
    data class Correct(val question: Question) : QuizResult()
    data class Wrong(val question: Question, val givenAnswer: String) : QuizResult()
}
