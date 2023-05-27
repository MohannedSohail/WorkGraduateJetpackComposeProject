package com.example.workgraduateproject.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.workgraduateproject.R
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch


@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(

                    colors = listOf(Color(0xff346EDF), Color(0xff6FC8FB))
                )
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_setting),
                    contentDescription = "",
                    tint = Color.White
                )

            }

        }


        Box(
            modifier = Modifier
                .weight(4f)
                .background(Color.Red), contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    elevation = 10.dp,
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                ) {


                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.height(15.dp))

                        Box(modifier = Modifier, contentAlignment = Alignment.TopEnd) {


                            Text(
                                modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                                text = "Mohanned Sohail",
                                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
                            )

                            Image(
                                modifier = Modifier.clickable(onClick = {}),
                                painter = painterResource(id = R.drawable.edit),
                                contentDescription ="",
                            )


                        }
                        Text(text = "Riyadh, Saudi Arabia")


                    }


                }


                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    elevation = 10.dp,

                    ) {


                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        MySettingsItem("Language",true)
                        MySettingsItem("My Rates",false)
                        MySettingsItem("Contact us",false)
                        MySettingsItem("Share App",false)



                    }


                }

                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = 10.dp,

                    ) {

                    Button(
                        onClick = {
                        },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .size(50.dp),
//                                .shadow(
//                                    elevation = 10.dp,
//                                    ambientColor = Color(0xffE9C75E),
//                                    spotColor = Color(0xffE9C75E),
//                                    shape = RoundedCornerShape(5.dp)
//                                )
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        elevation = ButtonDefaults.elevation(0.dp, pressedElevation = 0.dp),

                        ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.padding(horizontal = 10.dp),
                                tint = Color(0xffAF8344),
                                painter = painterResource(id = R.drawable.logout),
                                contentDescription = "",
                            )


                            Text(
                                text = "SIGN OUT",
                                color = Color(0xff0E4DFB),
                                style = TextStyle(fontSize = 16.sp),
                            )

                        }
                    }


                }


            }
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .offset(x = 0.dp, y = -50.dp),
                painter = painterResource(id = R.drawable.img),
                contentDescription = ""
            )


        }


    }


}

@Composable
fun MySettingsItem(title:String, isShow:Boolean=false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true) {
//                                    Toast
//                                        .makeText(context, item.title, Toast.LENGTH_SHORT)
//                                        .show()
            }
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 18.sp,

                    )
            )

            // Right arrow icon

            if(isShow){
                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "English",
                        style = TextStyle(

                        ),
                        color = Color(0xffC2CECE)
                    )

                    Icon(
                        modifier = Modifier
                            .weight(weight = 1f, fill = false),
                        imageVector = Icons.Outlined.ChevronRight,
                        contentDescription = "icon",
                        tint = Color(0xffC2CECE)
                    )

                }

            }else
            {
                Icon(
                    modifier = Modifier
                        .weight(weight = 1f, fill = false),
                    imageVector = Icons.Outlined.ChevronRight,
                    contentDescription = "icon",
                    tint = Color(0xffC2CECE)
                )

            }
        }

    }
}


//@Composable
//private fun OptionsItemStyle(item: OptionsData, context: Context) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable(enabled = true) {
//                Toast
//                    .makeText(context, item.title, Toast.LENGTH_SHORT)
//                    .show()
//            }
//            .padding(all = 16.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//        // Icon
////        Icon(
////            modifier = Modifier
////                .size(32.dp),
////            imageVector = item.icon,
////            contentDescription = item.title,
////            tint = MaterialTheme.colors.primary
////        )
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = item.title,
//                style = TextStyle(
//                    fontSize = 18.sp,
//
//                )
//            )
//
//            // Right arrow icon
//            Icon(
//                modifier = Modifier
//                    .weight(weight = 1f, fill = false),
//                imageVector = Icons.Outlined.ChevronRight,
//                contentDescription = item.title,
//                tint = Color.Black.copy(alpha = 0.70f)
//            )
//        }
//
//    }
//}