package com.example.twitt

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twitt.Styles.Colors

val colors = Colors()

@Composable
fun GenerateTuit(){
    Column{
        Tuit()
        TuitDivider()
    }
}


@Composable
fun Tuit(){
    var chat by remember { mutableStateOf(false) }
    var rt by remember { mutableStateOf(false) }
    var like by remember { mutableStateOf(false) }

    Row(
        Modifier
            .fillMaxWidth()
            .background( colors.backgroundDefaultColor )
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profile image",
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .size(55.dp)
        )

        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                TextTitle( "Italo", Modifier.padding(end = 8.dp))
                DefaultText("@Italo", Modifier.padding(end = 8.dp))
                DefaultText("4h", Modifier.padding(end = 8.dp))
                Spacer( modifier = Modifier.weight(1f))
                Icon(
                    painterResource(id = R.drawable.ic_dots),
                    contentDescription = "icon",
                    tint = Color.White
                )
            }

            textBody("frase larga sdjfiojdfiodfsjdfiojdfsiofd" +
                    "frase larga sdjfiojdfiodfsjdfiojdfsiofd" +
                    "frase larga sdjfiojdfiodfsjdfiojdfsiofd" +
                    "frase larga sdjfiojdfiodfsjdfiojdfsiofd",
                Modifier.padding(bottom = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Crop
            )

            Row(
                Modifier.padding(top = 16.dp)
            ){
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_chat),
                            contentDescription = "",
                            tint = colors.tintDefaultColor
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_chat_filled),
                            contentDescription = "",
                            tint = colors.tintDefaultColor
                        )
                    },
                    isSelected = chat
                ) {
                    chat = !chat
                }



                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_rt),
                            contentDescription = "",
                            tint = colors.tintDefaultColor
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_rt),
                            contentDescription = "",
                            tint = Color(0xFF00FF27)
                        )
                    },
                    isSelected = rt
                ) {
                    rt = !rt
                }


                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_like),
                            contentDescription = "",
                            tint = colors.tintDefaultColor
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_like_filled),
                            contentDescription = "",
                            tint = Color(0xFFFF0000)
                        )
                    },
                    isSelected = like
                ) {
                    like = !like
                }
            }
        }
    }
}


@Composable
fun SocialIcon(modifier: Modifier,
               unselectedIcon : @Composable () -> Unit,
               selectedIcon : @Composable () -> Unit,
               isSelected : Boolean,
               onItemSelected : () -> Unit
) {
    val defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ){
        if( isSelected ) {
            selectedIcon()
        }else{
            unselectedIcon()
        }

        Text(
            text = if( isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}


@Composable
fun TuitDivider(){
    Divider(
        Modifier.padding(top = 4.dp).height(0.5.dp).fillMaxWidth(),
        color = Color( 0XFF7E8B98)
    )
}


@Composable
fun textBody(text : String, modifier : Modifier = Modifier){
    Text(
        text = text,
        color = Color.White,
        modifier = modifier
    )
}


@Composable
fun TextTitle( title: String, modifier : Modifier = Modifier){
    Text(
        text = title,
        color = Color.White,
        fontWeight = FontWeight.ExtraBold,
        modifier = modifier
    )
}


@Composable
fun DefaultText( title: String, modifier : Modifier = Modifier){
    Text(
        text = title,
        color = Color.Gray,
        modifier = modifier
    )
}