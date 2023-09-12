package kompas.technical.test.common

object Constants {
    private const val API_KEY = "ddbda7cf6cf04ade9adb80ed99e0edc6"
    const val BASE_URL = "https://api.rawg.io/api/"
    const val GET_GAME = "games?key=$API_KEY"
    const val GET_GAME_DETAIL = "games/{id}?key=$API_KEY"
}