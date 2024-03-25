package br.com.pgabrelgmdeveloper.buscadorcep.repository

import br.com.pgabrelgmdeveloper.buscadorcep.data.DataSource
import br.com.pgabrelgmdeveloper.buscadorcep.listners.ResponseApi
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository @Inject constructor(private val dataSource: DataSource) {

    fun respostaAPI(cep: String, responseApi: ResponseApi){
        dataSource.responseApi(cep,responseApi)
    }

}