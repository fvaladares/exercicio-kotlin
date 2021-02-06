package dev.estudos.kotlin.json

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.io.InputStream


class LeitorJson {

    private val classLoader: ClassLoader = Thread.currentThread().contextClassLoader
    private lateinit var inputStream: InputStream
    fun read() {
        // this.javaClass.getResourceAsStream()
    }

    fun readArray(jsonPath: String): JsonArray {
        classLoader.getResourceAsStream(jsonPath).also { inputStream = it }
        return Gson().fromJson(inputStream.reader(), JsonArray::class.java)
    }


    fun readObject(jsonPath: String): JsonObject {
        classLoader.getResourceAsStream(jsonPath).also { inputStream = it }

        return Gson().fromJson(inputStream.reader(), JsonObject::class.java)
    }

}