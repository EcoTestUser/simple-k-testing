package ru.simple.testing.be.testdata

import ru.simple.testing.be.dto.Identifiable

interface TestData<T : Identifiable> {

    val testDataProvider: () -> List<T>

    fun getById(id: Int): T {
        return testDataProvider().find { it.id == id } ?: throw RuntimeException("Системе не найдена сущность с id = $id")
    }
}