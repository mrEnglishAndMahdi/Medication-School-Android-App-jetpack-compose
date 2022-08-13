package co.daneshyarwithmahdikhorshidi.medicationschool.utils.customTopApBarLayout

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import co.daneshyarwithmahdikhorshidi.medicationschool.R

@Composable
fun TopAppBarMainScreen() {

    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        elevation = 10.dp, backgroundColor = colorResource(id = R.color.MediumColor),
        contentColor = Color.White,
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "ShareIcon",
                    tint = Color.White
                )
            }
        },
        title = {
            Icon(
                imageVector = Icons.Default.Medication,
                contentDescription = "mainIcon"
            )
            Text(text = "دنیای دارو", fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold)
        }
    )
}