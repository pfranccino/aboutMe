package com.pfranccino.learnApp.util

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pfranccino.learnApp.model.Profile
import com.pfranccino.learnApp.model.ProfileDAO


@Database(entities = [Profile::class], version = 1)
@TypeConverters(DateTypeConverter::class)
abstract  class AppDataBase : RoomDatabase() {

    abstract  fun profileDAO() : ProfileDAO

    companion object{
        var INSTANCE : AppDataBase? = null
        fun getAppDataBase(context: Context) : AppDataBase?{
            if (INSTANCE == null){
                synchronized(AppDataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "bioDB").allowMainThreadQueries().build()
                }
            }

            return  INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

}