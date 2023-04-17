package disney.character.info

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import disney.character.info.di.DI_MODULES


class App : Application() {


    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(context)
            modules(DI_MODULES)
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    init {
        context = this
    }

}
