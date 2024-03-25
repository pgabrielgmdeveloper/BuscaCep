package br.com.pgabrelgmdeveloper.buscadorcep.listners

interface ResponseApi {
    fun onSuccess(logradouro:String, bairro: String, cidade: String, estado: String)
    fun onFailure(error: String)
}