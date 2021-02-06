package dev.estudos.kotlin.exercicios.json

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import dev.estudos.kotlin.json.LeitorJson
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LeitorJsonTest {
    lateinit var leitorJson: LeitorJson

    @BeforeEach
    fun init() {
        leitorJson = LeitorJson()
    }

    @Test
    fun readArray() {

        val jsonArray: JsonArray = leitorJson.readArray("pessoas.json")

        assertEquals(2, jsonArray.size())
    }

    @Test
    fun readObject() {

        val jsonObj: JsonObject = leitorJson.readObject("configuracao.json")

        assertNotNull(jsonObj)
        assertEquals("192.168.1.100", jsonObj.get("host").asString)
        assertEquals("1933", jsonObj.get("port").asString)
        assertEquals("clientes", jsonObj.get("database").asString)
        assertEquals("root", jsonObj.get("username").asString)
        assertEquals("teste", jsonObj.get("password").asString)

    }

}