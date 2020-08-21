import com.myogardener.foodparadise.api.ApiInterface
import com.myogardener.foodparadise.model.alphabet.Alphabet
import com.myogardener.foodparadise.model.country.Country
import com.myogardener.foodparadise.model.detail_model.Detail
import com.myogardener.foodparadise.model.detail_model.Meal
import com.myogardener.foodparadise.model.home_model.Categories
import com.myogardener.foodparadise.model.ingredients.Ingredients
import com.myogardener.foodparadise.model.single_model.SingleCategory
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

    fun getMealIDFun(
        mealID:String
    ):Call<Detail>{
        return  apiInterface.getMealID(mealID)
    }


    fun getAlphabetFun(
        word:String
    ):Call <Alphabet>{
        return apiInterface.getAlphabetMeal(word)
    }

    fun getCountryFun(
        countryName:String
    ):Call<Country>{
        return apiInterface.getCountry(countryName)
    }

    fun getIngredientFun(
        ingregientName:String
    ):Call<Ingredients>{
        return apiInterface.getIngredients(ingregientName)
    }
}