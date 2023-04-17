package disney.character.info.data

import disney.character.info.data.remote.Api
import disney.character.info.data.remote.models.CharactersResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DataManager(private val api: Api) : IDataManager {

    override fun getCharacters(
        onSuccess: (response: CharactersResponse) -> Unit,
        onFailure: (error: Throwable) -> Unit
    ) {
        val request =
            api.getCharacters().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    onSuccess(it)
                }, { error ->
                    onFailure(error)
                })
    }


}