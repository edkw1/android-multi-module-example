package com.example.multimodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.multimodule.di.AppComponent
import com.example.multimodule.routing.GlobalNavigatorFactory
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import ru.ufanet.erpmobile.GlobalScreenNames
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorFactory: GlobalNavigatorFactory

    private val navigator by lazy {
        navigatorFactory.create(this, R.id.container)
    }

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppComponent.get().inject(this)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
        router.navigateTo(GlobalScreenNames.MainFeatureScreen)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }

}