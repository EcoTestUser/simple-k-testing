package ru.simple.testing.be.steps

import ru.simple.testing.be.dto.PostDto

class JsonPlaceholderPostApiSteps : AbstractApiSteps<PostDto>(baseUrl = "https://jsonplaceholder.typicode.com", tClass = PostDto::class)