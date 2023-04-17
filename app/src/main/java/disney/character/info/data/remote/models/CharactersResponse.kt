package disney.character.info.data.remote.models

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("info")
    var info: Info
) {
    data class Data(
        @SerializedName("allies")
        var allies: List<Any>,
        @SerializedName("enemies")
        var enemies: List<Any>,
        @SerializedName("films")
        var films: List<String>,
        @SerializedName("_id")
        var id: Int, // 6
        @SerializedName("imageUrl")
        var imageUrl: String, // https://static.wikia.nocookie.net/disney/images/6/61/Olu_main.png
        @SerializedName("name")
        var name: String, // 'Olu Mel
        @SerializedName("parkAttractions")
        var parkAttractions: List<String>,
        @SerializedName("shortFilms")
        var shortFilms: List<String>,
        @SerializedName("tvShows")
        var tvShows: List<String>,
        @SerializedName("url")
        var url: String, // https://api.disneyapi.dev/characters/6
        @SerializedName("videoGames")
        var videoGames: List<String>
    )

    data class Info(
        @SerializedName("count")
        var count: Int, // 50
        @SerializedName("nextPage")
        var nextPage: String, // http://api.disneyapi.dev/character?page=2&pageSize=50
        @SerializedName("previousPage")
        var previousPage: Any, // null
        @SerializedName("totalPages")
        var totalPages: Int // 149
    )
}