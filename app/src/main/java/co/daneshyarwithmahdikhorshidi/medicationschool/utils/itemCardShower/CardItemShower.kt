package co.daneshyarwithmahdikhorshidi.medicationschool.utils.itemCardShower

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Medication
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import co.daneshyarwithmahdikhorshidi.medicationschool.models.dataclassesForDB.Drug


@Composable
fun CardItemShowerForDB(
    modifier: Modifier = Modifier,
    drug: Drug,
    expand:MutableState<Boolean> = mutableStateOf(false),
    onItemClicked: (drugId: Int) -> Unit = {},
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                expand.value = !expand.value
            },
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        backgroundColor = Color.White,
        border = BorderStroke(0.5.dp, color = Color.Gray),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                    }
                    Icon(
                        imageVector = Icons.Default.Medication,
                        contentDescription = "Medication",
                        tint = Color(0xFF10AF10)
                    )

                }

                Row(
                    modifier = Modifier.weight(6f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column(
                        modifier = Modifier.padding(5.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "${drug.faname}",
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Serif,
                            color = Color.Black
                        )
                        Text(
                            text = "${drug.enname}",
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            color = Color.DarkGray
                        )
                        Text(
                            text = "${drug.company}",
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Serif,
                            color = Color.Gray
                        )
                    }

                }
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {

                    IconButton(onClick = {
                        expand.value = !expand.value
                    }) {
                        Icon(
                            imageVector = if (expand.value) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                            contentDescription = "ExpandIcon",
                            tint = Color(0xFF10AF10)
                        )
                    }


                }
            }
            AnimatedVisibility(visible = expand.value) {
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : اشکال دارویی ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.type}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : نحوه مصرف ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.method}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : ترکیبات ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.compounds}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )

                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : موارد مصرف ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.mavaredmasraf}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )

                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : عوارض ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.avarez}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : اثر جانبی ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.asarjanebi}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : هشدار ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.hoshdar}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : نکات ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.nokat}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : تداخل ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.tadakhol}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : فارماکوپه (فارماکنیتیک) ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.pharmacokinetics}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(" : اسم کامل ")
                                append("\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) {
                                append("${drug.fullname}")
                            }
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(20.dp),
                        textAlign = TextAlign.Right
                    )
                    Divider(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        thickness = 0.5.dp,
                        color = Color(0xFF10AF10)
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {
                                onItemClicked(drug.id)
                            }, modifier = Modifier.padding(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFF10AF10),
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = " ذخیره دارو")
                        }
                    }


                }
            }


        }


    }


}




