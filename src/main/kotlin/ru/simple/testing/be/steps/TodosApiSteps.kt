package ru.simple.testing.be.steps

import ru.simple.testing.be.dto.TodoDto

class TodosApiSteps : AbstractApiSteps<TodoDto>(
    baseUrl = "https://jsonplaceholder.typicode.com",
    endpoint = "/todos",
    tClass = TodoDto::class
)
