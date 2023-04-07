package avill.ladv.shellcompose.data.apis

import avill.ladv.shellcompose.data.model.*
import avill.ladv.shellcompose.data.model.Puppy
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PuppyApi {
    @GET ("breeds/image/random")
    suspend fun getRandomDog(): Response<Puppy>
    @GET ("breeds/image/random/16")
    suspend fun getPopularPuppies(): Response<PopularPuppies>
    @GET
    suspend fun getPuppyByBreed(@Url url:String): Response<BreedPuppy>
    @GET
    suspend fun getPuppiesByBreed(@Url url:String): Response<PopularPuppies>
}

/*@GET("/.json")
suspend fun getAllExample(): Response<List<ExampleModel>>

@GET("categories.php")
fun getCategories(): Call<CategoryList>

@GET("filter.php?")
fun getDogsByCategory(@Query("i") category:String): Call<PopularDogs>

@GET ("random.php")
fun getRandomDog(): Call<MealList>

@GET("lookup.php?")
fun getDogById(@Query("i") id:String): Call<MealList>

@GET("search.php?")
fun getDogByName(@Query("s") s:String): Call<MealList>*/