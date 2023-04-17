package disney.character.info.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import disney.character.info.data.DataManager
import disney.character.info.data.remote.models.CharactersResponse

import disney.character.info.ui.main.contentAdapter.ContentModel


class MainViewModel(private val dataManager: DataManager) : ViewModel() {

    val contentLiveData: MutableLiveData<List<ContentModel>> = MutableLiveData()


    fun getContent() {
        dataManager.getCharacters(
            onSuccess = {
                contentLiveData.postValue(responseToUImodel(it))
            },
            onFailure = {
                it.message
            }
        )
    }

    private fun responseToUImodel(response: CharactersResponse): List<ContentModel> {
        val list = mutableListOf<ContentModel>()
        for (i in response.data.indices) {
            list.add(ContentModel(response.data[i].name, response.data[i].imageUrl))
        }
        return list
    }

}