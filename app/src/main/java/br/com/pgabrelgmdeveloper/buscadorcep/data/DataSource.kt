package br.com.pgabrelgmdeveloper.buscadorcep.data

import br.com.pgabrelgmdeveloper.buscadorcep.api.ViaCep
import br.com.pgabrelgmdeveloper.buscadorcep.listners.ResponseApi
import br.com.pgabrelgmdeveloper.buscadorcep.model.Endereco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class DataSource @Inject constructor() {
    private val retrofit: ViaCep = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://viacep.com.br/")
        .build()
        .create(ViaCep::class.java)

    fun responseApi(cep: String, responseApi: ResponseApi) {
        if (cep.isEmpty()){
            responseApi.onFailure("Preenchar o campo CEP !")
        }else {
            retrofit.setEndereco(cep).enqueue(object : Callback<Endereco>{
                override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                    if(response.code() == 200) {
                        val logradouro = response.body()?.logradouro.toString()
                        val bairro = response.body()?.bairro.toString()
                        val cidade = response.body()?.localidade.toString()
                        val uf = response.body()?.uf.toString()

                        responseApi.onSuccess(logradouro,bairro,cidade,uf)

                    }else {
                        responseApi.onFailure("CEP invalido !")
                    }
                }

                override fun onFailure(call: Call<Endereco>, t: Throwable) {
                    responseApi.onFailure("Error Inesperado !")
                }

            })
        }

    }
}