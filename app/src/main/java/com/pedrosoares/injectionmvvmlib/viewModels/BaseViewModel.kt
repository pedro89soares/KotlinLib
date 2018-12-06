package tassks.agap2.com.common_core.viewModels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.os.Bundle
import com.pedrosoares.injectionmvvmlib.viewModels.interfaces.DialogService
import com.pedrosoares.injectionmvvmlib.viewModels.interfaces.SharedPreferencesService
import tassks.agap2.com.common_core.interfaces.NavigationService
import tassks.agap2.com.common_core.utils.ResourceUtils
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    protected lateinit var navigationService: NavigationService

    @Inject
    protected lateinit var dialogService: DialogService

    @Inject
    protected lateinit var sharedPreferences: SharedPreferencesService

    @Inject
    lateinit var resourceUtils: ResourceUtils

    var isLoading = ObservableBoolean(false)

    /**
     * called after Injects occur.
     */
    open fun lateInit() {

    }

    /**
     * called after a navigation occurs. Ideal to set any value than was passed in navigation.
     */
    open fun onNavigation(bundle: Bundle?) {

    }

    /**
     * called after a back navigation occurs using the INavigationService.navigateBackTo. Can be used to pass a value back from another activity like StartActivityForResult() -> OnResult().
     */
    open fun onReturnResult(bundle: Bundle?) {

    }

    /**
     * method to perform a simple back navigation.
     */
    fun goBack() {
        navigationService.back()
    }
}