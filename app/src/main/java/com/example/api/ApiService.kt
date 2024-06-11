package com.example.api

import com.example.response.Brand
import com.example.response.CategoryResponseItem
import com.example.response.LoginResponse
import com.example.response.Product
import com.example.response.RegisterResponse
import com.example.response.UserProfileResponseItem
import com.example.response.WishlistResponseItem
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @FormUrlEncoded
    @POST("auth/register")
    suspend fun register(
        @Field("fullName") fullName: String,
        @Field("address") address: String,
        @Field("phone") phone: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("picture") picture: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String, @Field("password") password: String
    ): LoginResponse

    @GET("auth/dbhsj/profile")
    suspend fun getProfile(@Header("Authorization") token: String): List<UserProfileResponseItem>

    @GET("products")
    suspend fun getAllProducts(): List<Product>

    @GET("brands")
    suspend fun getBrands(): List<Brand>

    @GET("products/{id}")
    suspend fun getProductDetail(@Path("id") productId: String): Response<List<Product>>

    @GET("categories")
    suspend fun getCategories(): List<CategoryResponseItem>

    @GET("wishlist")
    suspend fun getWishlist(): List<WishlistResponseItem>
}