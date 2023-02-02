package ru.simple.testing.be

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test
import ru.simple.testing.be.dto.PostDto
import ru.simple.testing.be.steps.JsonPlaceholderPostApiSteps
import ru.simple.testing.be.testdata.PostTestData

class JsonPlaceholderPostCrudTests {

    @Test
    fun createPostTest() {
        val dtoForCreate = PostDto(userId = 189, title = "Test title", body = "Test body")
        val result = JsonPlaceholderPostApiSteps().createPost(dtoForCreate)

        assertThat(result.userId, equalTo(dtoForCreate.userId))
        assertThat(result.title, equalTo(dtoForCreate.title))
        assertThat(result.body, equalTo(dtoForCreate.body))
    }

    @Test
    fun createPostWithEmptyBodyTest() {
        val dtoForCreate = PostDto(userId = 189, title = "Test title")
        val (id, userId, title, body) = JsonPlaceholderPostApiSteps().createPost(dtoForCreate)

        assertThat(userId, equalTo(dtoForCreate.userId))
        assertThat(title, equalTo(dtoForCreate.title))
        assertThat(body, nullValue())
    }

    @Test
    fun getPostTest() {
        val expectedEntity = PostTestData.getById(1)
        val actualDto = JsonPlaceholderPostApiSteps().getPost(1)

        assertThat(expectedEntity.userId, equalTo(actualDto.userId))
        assertThat(expectedEntity.title, equalTo(actualDto.title))
        assertThat(expectedEntity.body, equalTo(actualDto.body))
    }

    @Test
    fun getListTest() {
        //TODO
    }
}