package abhishek.pathak.moviefiner

import abhishek.pathak.moviefiner.ui.theme.White
import abhishek.pathak.moviefiner.ui.theme.dp_10
import abhishek.pathak.moviefiner.ui.theme.dp_4
import abhishek.pathak.moviefiner.ui.theme.sp_12
import abhishek.pathak.moviefiner.ui.theme.sp_14
import abhishek.pathak.moviefiner.ui.theme.sp_20
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PopularScreenUIPrev() {
    PopularScreenUI()
}

@Composable
fun PopularScreenUI() {
    Column(modifier = Modifier.fillMaxSize().background(White)) {
        Row(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().background(color = White)
        ) {
            IconButton(
                onClick = { },
                Modifier.paint(painterResource(id = R.drawable.baseline_arrow_back_24))
            ) { }

            Text(
                text = stringResource(id = R.string.popular),
                fontWeight = FontWeight.Bold,
                fontSize = sp_20,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        val columns = 3
        LazyVerticalGrid(
            GridCells.Fixed(columns),
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
        ) {
            items(18) {
                for (i in 0..18) {
                    ItemView()
                }
            }
        }
    }
}




@Composable
fun ItemView() {

    Card(
        modifier = Modifier.padding(dp_10),
        elevation = CardDefaults.cardElevation(dp_4)
    ){
        Box(
            Modifier
                .fillMaxWidth()
        ){
            Column {
                Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null, modifier = Modifier.fillMaxWidth())
                Text(text = stringResource(R.string.title),
                    fontSize = sp_14,
                    modifier = Modifier
                        .padding(dp_10)
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Text(text = stringResource(R.string.date),
                    fontSize = sp_12,
                    modifier = Modifier
                        .padding(start = dp_10, end = dp_10, bottom = dp_10)
                        .fillMaxWidth())
                }
            }
        }
}
