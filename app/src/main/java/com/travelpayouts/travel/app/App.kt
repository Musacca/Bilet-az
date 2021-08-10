package com.travelpayouts.travel.app

import android.content.res.Configuration
import com.travelpayouts.travel.sdk.Config
import com.travelpayouts.travel.sdk.Config.Tab
import com.travelpayouts.travel.sdk.TravelApp
import java.util.*


class App : TravelApp() {

    override fun onCreate() {
        super.onCreate()
        if (Locale.getDefault().getLanguage() == "az")
            setLocale("tr");
    }

    override val config: Config = Config(
            tabs = setOf(
                    Tab.Flights,
                    Tab.Hotels,
                    Tab.AppInfo
            )
    )

    fun setLocale(languageCode: String?) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources = applicationContext.resources
        val config = Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

}
