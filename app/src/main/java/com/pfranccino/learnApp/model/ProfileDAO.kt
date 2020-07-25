package com.pfranccino.learnApp.model

import androidx.room.*

@Dao
interface ProfileDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(profile: Profile)

    @Update
    fun updateProfile(profile: Profile)

    @Delete
    fun deleteProfile(profile: Profile)

    @Query("SELECT * FROM Profile WHERE email == :email")
    fun getUser(email : String) : Profile

}