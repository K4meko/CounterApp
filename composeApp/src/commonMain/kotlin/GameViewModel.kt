import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlin.math.min

class GameViewModel {
    private val redScore = mutableStateOf(0)
    private val blueScore = mutableStateOf(0)

    fun increaseRedScore() {
        redScore.value++
    }
    fun increaseBlueScore() {
        blueScore.value++
    }
    fun refreshScores() {
        redScore.value = 0
        blueScore.value = 0
    }
    fun getRedScore() = redScore
    fun getBlueScore() = blueScore


}