package jmapps.myprayerpro.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val currentIndex = MutableLiveData<Int>()

    private val currentTitle = arrayListOf(
        "Омовение",
        "Молитва",
        "Азкары"
    )

    private val currentPicture = arrayListOf(
        "ic_ablution",
        "ic_prayer",
        "ic_prayer"
    )

    val titles: LiveData<String> = Transformations.map(currentIndex) {
        currentTitle[currentIndex.value!! - 1]
    }

    val pictures: LiveData<String> = Transformations.map(currentIndex) {
        currentPicture[currentIndex.value!! - 1]
    }

    fun setIndex(index: Int) {
        currentIndex.value = index
    }
}