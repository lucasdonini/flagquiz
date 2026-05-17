package com.kluska.flagquiz.di

import com.kluska.flagquiz.infra.LoggerImpl
import com.kluska.flagquiz.infra.mocks.MockQuestionRepository
import com.kluska.flagquiz.repository.Logger
import com.kluska.flagquiz.repository.QuestionRepository
import org.koin.dsl.module

val appModule = module {
    single<QuestionRepository> { MockQuestionRepository() }
    single<Logger> { LoggerImpl() }
}
