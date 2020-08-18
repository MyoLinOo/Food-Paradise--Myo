import com.myogardener.foodparadise.api.ApiInterface
import com.myogardener.foodparadise.model.Categories
import com.myogardener.foodparadise.model.Category
import com.myogardener.foodparadise.model.SingleCategory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    private val apiInterface: ApiInterface

    init {


        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getCategories(): Call<Categories> {
        return apiInterface.getPost()
    }
    fun getSingleMealFun(
        singleMeal: String
    ): Call<SingleCategory> {
        return apiInterface.getSingleMeal(singleMeal)
    }

}