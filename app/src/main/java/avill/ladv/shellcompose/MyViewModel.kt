package avill.ladv.shellcompose

import androidx.lifecycle.ViewModel
import avill.ladv.shellcompose.data.Repository
import avill.ladv.shellcompose.domain.GetPuppiesByBreed
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    //here you can Inject
    private val getQuotesUseCase: GetPuppiesByBreed,
    private val myApi:Repository,
): ViewModel() {

    init {

    }
}