import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import database.Fruit
import database.FruitDao
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val fruitDao: FruitDao
) : ViewModel() {
    fun deleteFruit(fruit: Fruit) {
        viewModelScope.launch {
            fruitDao.deleteFruit(fruit)
        }
    }

    val fruits = fruitDao.getAllFruits()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    init {
        viewModelScope.launch {
            val fruitsList = listOf(
                Fruit("Apple"),
                Fruit("Apricot"),
                Fruit("Cherry")
            )
            fruitsList.forEach { fruit ->
                fruitDao.upsertFruit(fruit)
            }
        }
    }
}