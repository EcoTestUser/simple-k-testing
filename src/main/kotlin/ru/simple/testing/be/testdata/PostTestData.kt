package ru.simple.testing.be.testdata

import ru.simple.testing.be.dto.PostDto

object PostTestData : TestData<PostDto> {

    override val testDataProvider: () -> List<PostDto> = {
        listOf(
            PostDto(
                id = 1,
                userId = 1,
                title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
            ),
            PostDto(
                id = 48,
                userId = 5,
                title = "ut voluptatem illum ea doloribus itaque eos",
                body = "voluptates quo voluptatem facilis iure occaecati\nvel assumenda rerum officia et\nillum perspiciatis ab deleniti\nlaudantium repellat ad ut et autem reprehenderit"
            )
        )
    }
}