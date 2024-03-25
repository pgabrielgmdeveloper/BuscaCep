package br.com.pgabrelgmdeveloper.buscadorcep.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.pgabrelgmdeveloper.buscadorcep.listners.ResponseApi
import br.com.pgabrelgmdeveloper.buscadorcep.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuscarCepViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun responseApi(cep: String, repostaApi: ResponseApi){
        viewModelScope.launch {
            repository.respostaAPI(cep, repostaApi)
        }
    }
}