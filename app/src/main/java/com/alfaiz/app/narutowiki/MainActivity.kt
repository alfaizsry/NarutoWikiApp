package com.alfaiz.app.narutowiki


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alfaiz.app.narutowiki.databinding.ActivityMainBinding
import splitties.activities.start

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        showRecycleList()
    }

    private fun showRecycleList (){
        with(activityMainBinding) {
            rvCharacter.setHasFixedSize(true)
            rvCharacter.layoutManager = LinearLayoutManager(this@MainActivity)
            val characterAdapter = CharacterAdapter(DummyCharacter.getAll())
            rvCharacter.adapter = characterAdapter

            characterAdapter.setOnItemClickCallback(object : OnItemClickCallback{
                override fun onItemClick(character: Character) {
                    showSelectedCharacter(character)
                }
            })
        }
    }

    private fun showSelectedCharacter(character: Character) {
        start<CharacterDetailActivity> {
            putExtra(CharacterDetailActivity.EXTRA_PRODUCT, character)
        }
    }
}