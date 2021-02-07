package dev.estudos.kotlin.exercicios.json

data class DBConfig(
    var host: String = "localhost",
    var port: String = "1930",
    var databaseName: String = "Clients",
    var userName: String = "user",
    var password: String = "password",
)
