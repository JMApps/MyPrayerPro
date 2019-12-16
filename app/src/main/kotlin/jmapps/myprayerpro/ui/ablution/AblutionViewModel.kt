package jmapps.myprayerpro.ui.ablution

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class AblutionViewModel : ViewModel() {

    private val currentIndex = MutableLiveData<Int>()

    private val currentPicture = arrayListOf(
        "ic_ablution_1",
        "ic_ablution_2",
        "ic_ablution_3",
        "ic_ablution_4",
        "ic_ablution_5",
        "ic_ablution_6",
        "ic_ablution_7",
        "ic_ablution_8",
        "ic_ablution_9",
        "ic_ablution_10",
        "ic_ablution_11"
    )

    val pictures: LiveData<String> = Transformations.map(currentIndex) {
        currentPicture[currentIndex.value!! - 1]
    }

    fun setIndex(index: Int) {
        currentIndex.value = index
    }
}