package com.prakash.CamMandu.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.prakash.CamMandu.dao.ProductDAO
import com.prakash.CamMandu.entity.Product

@Database(
        entities = [(Product::class)],
        version = 1,
        exportSchema = false
)

    abstract class ProductDB : RoomDatabase(){
    abstract fun getProductDAO() : ProductDAO

    companion object{
        @Volatile
        private var instance : ProductDB? = null

        fun getInstance(context : Context) : ProductDB{
            if(instance == null){
                synchronized(ProductDB::class){
                    instance = buildDatabase(context)
                }
            }

            return instance!!
        }

        private fun buildDatabase(context : Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        ProductDB::class.java,
                        "ProductDatabase"
                ).build()

    }
}