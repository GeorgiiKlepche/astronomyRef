import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class NewsViewModel : ViewModel() {

    // Остальной код без изменений

    init {
        resetNews()
        startNewsUpdater()
    }

    private fun startNewsUpdater() {
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(5000) // Обновление одной случайной новости каждые 5 секунд
                updateRandomNews()
            }
        }
    }

    private fun updateRandomNews() {
        CoroutineScope(Dispatchers.Main).launch {
            val indexToUpdate = Random.nextInt(0, newsState.size)
            val randomNews = _newsList.random()
            newsState[indexToUpdate] = NewsItem(randomNews, newsState[indexToUpdate].likes)
        }
    }
}
