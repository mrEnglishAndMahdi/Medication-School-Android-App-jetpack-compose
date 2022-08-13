package co.daneshyarwithmahdikhorshidi.medicationschool.screens.aboutUsScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import co.daneshyarwithmahdikhorshidi.medicationschool.R

@Composable
fun AboutUsScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center,
                text = "\u200F\u200Fبانک جامع اطلاعات دارویی\n" +
                        "\u200F یک داروخانه کامل با بیش از هزاران دارو هم به زبان فارسی و هم به زبان انگلیسی با توضحیات کامل از دارو شامل : موارد و مقدار مصرف ، عوارض جانبی ، تداخل دارویی ، مکانیسم اثر ، نکات قابل توصیه به بیمار ، اشکالات مربوط به دارو و اطلاعات دیگر از دارو می باشد\n" +
                        "\u200F این اپلیکیشن در مرکز توسعه فناوری اطلاعات و رسانه های دیجیتال به ثبت رسیده است"
            )
            Text(modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center, text = "\u200F برخی از قابلیت های برنامه\n" +
                        "\u200F -امکان جستجو در بین تمامی داروها هم به فارسی و هم به انگلیسی\n" +
                        "\u200F -امکان افزودن به لیست جستجوی آفلاین\n" +
                        "\u200F -قابلیت ارسال دارو به همراه مشخصات آن از طریق تلگرام ، اینستاگرام و سایر شبکه های اجتماعی و همچنین پیامک وغیره\n" +
                        "\u200F -گرافیک مناسب و دل نشین\n" +
                        "\u200F -وغیره"
            )
            Text(modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center,
                text = "\u200F امیدواریم مورد توجه شما عزیزان قرار بگیرد\n" +
                        "\u200F هر گونه نقطه نظر، انتقاد و پیشنهاد خود را می توانید از طریق پست الکترونیک و یا قسمت ارتباط با پشتیبانی کانال تلگرام، با ما در میان بگذارید  ما در اسرع وقت پاسخگوی شما خواهیم بود و از نظرات و انتقادات شما را در آپدیت بعدی برنامه اعمال خواهیم کرد"
            )
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                elevation = 10.dp,
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                backgroundColor = Color.White,
                border = BorderStroke(1.dp, color = Color.Cyan),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.person),
                        contentDescription ="PersonImage",
                    contentScale = ContentScale.Crop)
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start) {
                        Text(
                            text = "Email : Mr.English.1998@gmail.com")
                        Text(
                            text = "Telegram : MrEnglish_25")
                        Text(
                            text = "Developer : Mahdi Khorshidi")
                    }
                }
            }
        }
    }
}