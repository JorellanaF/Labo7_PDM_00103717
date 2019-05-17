package com.example.labo7.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GithubDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: GithubRepo)

    @Query("SELECT * FROM repos")
    fun getAllRepos(): LiveData<List<GithubRepo>>

    @Query("DELETE FROM repos")
    fun nukeTable()
}