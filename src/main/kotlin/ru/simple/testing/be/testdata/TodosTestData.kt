package ru.simple.testing.be.testdata

import ru.simple.testing.be.dto.TodoDto

object TodosTestData : TestData<TodoDto> {

    override val testDataProvider: () -> List<TodoDto> = {
        listOf(
            TodoDto(id = 1, userId = 1, title = "delectus aut autem", completed = false),
            TodoDto(id = 48, userId = 3, title = "sit reprehenderit omnis quia", completed = false)
        )
    }
}