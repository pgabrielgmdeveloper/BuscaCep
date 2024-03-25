package br.com.pgabrelgmdeveloper.buscadorcep.model

data class Endereco(
    val logradouro: String? = null,
    val bairro: String? = null,
    val localidade: String? = null,
    val uf: String? =null
)