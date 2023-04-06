package com.example.android_kotlin_shoe_store

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_kotlin_shoe_store.models.Shoe

class MainViewModel : ViewModel() {

    var currentShoe: Shoe? = null

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    private val _eventCloseScreen = MutableLiveData<Boolean>()
    val eventCloseScreen: LiveData<Boolean>
        get() = _eventCloseScreen

    private val _eventShowWelcomeScreen = MutableLiveData<Boolean>()
    val eventShowWelcomeScreen: LiveData<Boolean>
        get() = _eventShowWelcomeScreen

    private val _eventShowInstructionScreen = MutableLiveData<Boolean>()
    val eventShowInstructionScreen: LiveData<Boolean>
        get() = _eventShowInstructionScreen

    private val _eventShowShoeListScreen = MutableLiveData<Boolean>()
    val eventShowShoeListScreen: LiveData<Boolean>
        get() = _eventShowShoeListScreen


    init {
        // initialize temp shoes list ....
        _shoes.value = mutableListOf<Shoe>(
            Shoe("Originals Vegan Samba", 36.0, "adidas", "Originals Vegan Samba trainers in white"),
            Shoe("Nike ZoomX SuperRep Surge", 38.0, "Nike", "Very comfortable"),
            Shoe("Originals Vegan Samba", 36.0, "adidas", "Originals Vegan Samba trainers in white"),
            Shoe("Nike ZoomX SuperRep Surge", 38.0, "Nike", "Very comfortable"),
            Shoe("Originals Vegan Samba", 36.0, "adidas", "Originals Vegan Samba trainers in white"),
            Shoe("Nike ZoomX SuperRep Surge", 38.0, "Nike", "Very comfortable"),
        )

        Log.i("", "${_shoes.value}")
    }


    fun close() {
        _eventCloseScreen.value = true
    }

    fun onEventCloseComplete() {
        _eventCloseScreen.value = false
    }

    fun showWelcomeScreen() {
        _eventShowWelcomeScreen.value = true
    }

    fun onEventShowWelcomeScreenComplete() {
        _eventShowWelcomeScreen.value = false
    }

    fun showInstructionScreen() {
        _eventShowInstructionScreen.value = true
    }

    fun onEventShowInstructionScreenComplete() {
        _eventShowInstructionScreen.value = false
    }

    fun showShoeListScreen() {
        _eventShowShoeListScreen.value = true
    }

    fun onEventShowShowListScreenComplete() {
        _eventShowShoeListScreen.value = false
    }

    // -----------------------------------------------------------------------------
    fun createNewShoe() {
        currentShoe = Shoe("", 0.0, "", "")
    }

    fun save() {
        //val tempShoes = mutableListOf<Shoe>()

        //_shoes.value?.let {
        //    tempShoes.addAll(it)
        //}

        currentShoe?.let {
            //tempShoes.add(it)
            var tempList = mutableListOf<Shoe>()
            _shoes.value?.let { shoes -> tempList.addAll(shoes) }
            tempList.add(it)
            _shoes.value = tempList
        }

        //_shoes.value = tempShoes
        _eventCloseScreen.value = true
    }
}