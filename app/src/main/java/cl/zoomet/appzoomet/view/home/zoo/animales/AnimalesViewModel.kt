package cl.zoomet.appzoomet.view.home.zoo.animales

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.asStateFlow


data class AnimalVistoUiState(
    val placeholder: Boolean = false
)
open class AnimalesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AnimalVistoUiState())
    val uiState: StateFlow<AnimalVistoUiState> = _uiState
    private val repository = AnimalesRepository()

    // Exponemos la lista de animales como un StateFlow
    open val animales: StateFlow<List<Animal>> = repository.getAnimales()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(3000),
            initialValue = emptyList()
        )
}
