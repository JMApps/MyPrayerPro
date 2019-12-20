package jmapps.myprayerpro.ui.mvp.other

interface OtherContract {

    interface OtherView {
        fun getTools()
        fun getNightMode(state: Boolean)
        fun getAboutUs()
    }

    interface OtherPresenter {
        fun setTools()
        fun setNightMode(state: Boolean)
        fun setAboutUs()
        fun setRate()
        fun setShare()
    }
}