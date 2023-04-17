package disney.character.info.data.remote

import disney.character.info.data.remote.models.CharactersResponse
import io.reactivex.Single
import retrofit2.http.GET

interface Api {

    @GET("character")
    fun getCharacters(): Single<CharactersResponse>

}