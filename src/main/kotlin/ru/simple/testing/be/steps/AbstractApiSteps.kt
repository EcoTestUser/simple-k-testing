package ru.simple.testing.be.steps

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.specification.RequestSpecification
import ru.simple.testing.be.dto.Identifiable
import kotlin.reflect.KClass

abstract class AbstractApiSteps<T : Identifiable>(baseUrl: String, private val tClass: KClass<T>) {

    protected val api: RequestSpecification by lazy {
        val specs = RequestSpecBuilder().setBaseUri(baseUrl).build()
        RestAssured.given()
            .spec(specs)
            .contentType("application/json; charset=UTF-8")
            .filters(RequestLoggingFilter(), ResponseLoggingFilter())
    }

    fun createPost(dtoForCreate: T): T {
        return api.body(dtoForCreate).post("/posts").`as`(tClass.java)
    }

    fun getPost(id: Int): T = api.get("/posts/$id").`as`(tClass.java)
}