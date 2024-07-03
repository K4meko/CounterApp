import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GameView() {
    val viewModel: GameViewModel = remember { GameViewModel() }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier.fillMaxWidth() // Make boxes fill the width
                .height(50.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Blue)
                .weight(1f)
                .clickable { viewModel.increaseBlueScore()
                    println(viewModel.getBlueScore().value.toString() )  }
            ,
            contentAlignment = Alignment.Center
        )
        {
            Text(text = viewModel.getBlueScore().value.toString(), color = Color.White, style = MaterialTheme.typography.h5, fontSize = 50.sp)

        }

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text("Save to history", modifier = Modifier.padding( vertical = 8.dp).clickable {  })
            IconButton(onClick = { viewModel.refreshScores() }){
               Icon(Icons.Sharp.Refresh, contentDescription = "Refresh")
            }
            Text("Go to history", modifier = Modifier.padding( vertical = 8.dp).clickable {  })

        }


        Box(
            modifier = Modifier
                .fillMaxWidth() // Make boxes fill the width
                .height(50.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Red)
                .weight(1f)
                .clickable { viewModel.increaseRedScore() },
            contentAlignment = Alignment.Center
        )
        {
            Text(text = viewModel.getRedScore().value.toString(), color = Color.White,  style = MaterialTheme.typography.h5, fontSize = 50.sp)

        }
    }
}