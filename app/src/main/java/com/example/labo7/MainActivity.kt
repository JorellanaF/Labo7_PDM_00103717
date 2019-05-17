package com.example.labo7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.labo7.DataBase.GithubRepo
import com.example.labo7.ViewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rv_1.apply{
        adapter = myadapter
        layouTmANAYER = LLMANAGER
        }


        val vieModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)

        btn.setOnClickListener {
            val name = et_palabra.text.toString()
            if (name.isNotEmpty() && name.isNotBlank()){
                vieModel.insert(GithubRepo(name))
            }
        }

        vieModel.getAll().observe(this, Observer {
            repos ->

            adapter.chageDataSet(repos)

            Log.d("LISTA DE REPOS", "__________________________________________________________-")

            for(repo in repos){
            Log.d("LISTA DE REPOS", repo.name)
        }
        })

    }
}
