package disney.character.info.data

import disney.character.info.data.remote.models.CharactersResponse

interface IDataManager {


    fun getCharacters(
        onSuccess: (response: CharactersResponse) -> Unit,
        onFailure: (error: Throwable) -> Unit
    )


}