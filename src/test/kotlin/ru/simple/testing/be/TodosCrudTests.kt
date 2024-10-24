package ru.simple.testing.be

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test
import ru.simple.testing.be.dto.TodoDto
import ru.simple.testing.be.steps.TodosApiSteps
import ru.simple.testing.be.testdata.TodosTestData

class TodosCrudTests {

    @Test
    fun createTodoTest() {
        val dtoForCreate = TodoDto(id = 189, userId = 189, title = "Buy milk", completed = false)

        val result = TodosApiSteps().create(dtoForCreate)

        assertThat(result.id, equalTo(dtoForCreate.id))
        assertThat(result.userId, equalTo(dtoForCreate.userId))
        assertThat(result.title, equalTo(dtoForCreate.title))
        assertThat(result.completed, equalTo(dtoForCreate.completed))
    }

    @Test
    fun createTodoWithEmptyTitleTest() {
        val dtoForCreate = TodoDto(userId = 189, completed = false)
        val (id, userId, title, completed) = TodosApiSteps().create(dtoForCreate)

        assertThat(userId, equalTo(dtoForCreate.userId))
        assertThat(title, nullValue())
        assertThat(completed, equalTo(dtoForCreate.completed))
    }

    @Test
    fun getTodoTest() {
        val expectedEntity = TodosTestData.getById(1)
        val actualDto = TodosApiSteps().get(1)

        assertThat(expectedEntity.userId, equalTo(actualDto.userId))
        assertThat(expectedEntity.title, equalTo(actualDto.title))
        assertThat(expectedEntity.completed, equalTo(actualDto.completed))
    }

    @Test
    fun updateTodoTest() {
        //TODO
    }
}