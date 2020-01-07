package jmapps.myprayerpro.ui.prayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class PrayerViewModel : ViewModel() {

    private val currentIndex = MutableLiveData<Int>()

    private val currentPicture = arrayListOf(
        "ic_prayer_1",
        "ic_prayer_2",
        "ic_prayer_3",
        "ic_prayer_2",
        "ic_prayer_4",
        "ic_prayer_2",
        "ic_prayer_1",
        "ic_prayer_7",
        "ic_prayer_8",
        "ic_prayer_7",
        "ic_prayer_8",
        "ic_prayer_3",
        "ic_prayer_2",
        "ic_prayer_4",
        "ic_prayer_2",
        "ic_prayer_1",
        "ic_prayer_7",
        "ic_prayer_8",
        "ic_prayer_7",
        "ic_prayer_9",
        "ic_prayer_10",
        "ic_prayer_11"
    )

    val pictures: LiveData<String> = Transformations.map(currentIndex) {
        currentPicture[currentIndex.value!! - 1]
    }

    fun setIndex(index: Int) {
        currentIndex.value = index
    }
}