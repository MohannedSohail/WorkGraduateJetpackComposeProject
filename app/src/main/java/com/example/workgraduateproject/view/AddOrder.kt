package com.example.workgraduateproject.view

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.example.workgraduateproject.R
import com.example.workgraduateproject.FileHelper
import com.example.workgraduateproject.navigation.Screens
import com.google.gson.Gson

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddOrder(navController: NavController, id: Int) {


    var imgDetails by remember { mutableStateOf(value = "") }

    var selectedMultiImages by remember {
        mutableStateOf<List<Uri>>(emptyList())
    }
    val context = LocalContext.current
//
//    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
//    val token = sharedPreferences.getString("token", "")


    val multiplePhotosPickerLuncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) {
            selectedMultiImages = it
        }

//    Toast
//        .makeText(
//            LocalContext.current,
//            " Work ID ${id}",
//            Toast.LENGTH_LONG
//        )
//        .show()


//    Toast
//        .makeText(
//            LocalContext.current,
//            " UserToken ${token}",
//            Toast.LENGTH_LONG
//        )
//        .show()


//    Toast
//        .makeText(
//            LocalContext.current,
//            " My Selected Images ${selectedMultiImages}",
//            Toast.LENGTH_LONG
//        )
//        .show()


    Scaffold(

        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .paint(
                        painterResource(id = R.drawable.choicecardbackground),
                        contentScale = ContentScale.Crop
                    ),
                content = {
                    Box(contentAlignment = Alignment.CenterStart) {

                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = "Smith",
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontSize = 20.sp),
                                color = Color.White
                            )
                        }


                        IconButton(modifier = Modifier,
                            onClick = {navController.popBackStack() }, content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.back),
                                    null,
                                    tint = Color.White
                                )
                            })

                    }

                },

                )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp, horizontal = 15.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)

            ) {

                val stroke = Stroke(
                    width = 2f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)
                )
                Box(contentAlignment = Alignment.TopStart) {
                    Box(modifier = Modifier.fillMaxWidth()) {

                        Row(
                            modifier = Modifier.then(
                                if (selectedMultiImages.isNotEmpty()) Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                                    .padding(start = 8.dp, end = 8.dp)
                                    .clickable(enabled = false, onClick = {

                                        multiplePhotosPickerLuncher.launch("image/*")


                                    }) else Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .padding(start = 8.dp, end = 8.dp)
                                    .clickable(enabled = true, onClick = {

                                        multiplePhotosPickerLuncher.launch("image/*")
                                    })
                            ),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            if (selectedMultiImages.isNotEmpty()) {

                                LazyVerticalGrid(
                                    modifier = Modifier.padding(5.dp),
                                    columns = GridCells.Fixed(3),
                                    content = {
                                        items(selectedMultiImages) { uri ->


                                            SubcomposeAsyncImage(
                                                model = ImageRequest.Builder(LocalContext.current)
                                                    .data(uri)
                                                    .crossfade(true)
                                                    .placeholder(R.drawable.iconimage)
                                                    .build(),
                                                contentDescription = "",
                                                modifier = Modifier
                                                    .size(120.dp)
                                                    .fillMaxWidth()
                                                    .padding(5.dp)
                                                    .clip(RoundedCornerShape(10.dp)),
                                                contentScale = ContentScale.Crop
                                            ) {
                                                val state = painter.state
                                                if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                                                    CircularProgressIndicator(
                                                        color = Color(0xff346EDF)

                                                    )
                                                } else {
                                                    SubcomposeAsyncImageContent()
                                                }
                                            }
                                        }
                                    })

                            } else {

                                Icon(
                                    painter = painterResource(id = R.drawable.selectimage),
                                    contentDescription = ""
                                )

                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Image Problem",
                                    textAlign = TextAlign.Center
                                )

                            }

                        }


                        Canvas(
                            Modifier.then(
                                if (selectedMultiImages.isNotEmpty()) Modifier
                                    .fillMaxWidth()
                                    .height(180.dp) else Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                            )

                        ) {
                            drawRoundRect(
                                color = Color(0xff0E4DFB),
                                style = stroke,
                                cornerRadius = CornerRadius(x = 13F, y = 13F)
                            )

                        }


                    }

                    if (selectedMultiImages.isNotEmpty())
                        Icon(
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .clickable { selectedMultiImages = emptyList() },
                            imageVector = Icons.Filled.Close,
                            contentDescription = "",
                            tint = Color.Red,
                        )

                }


                Text(
                    modifier = Modifier.padding(vertical = 13.dp),
                    text = "image must be no more than 2 MB Max 5 Image",
                    color = Color(0xff7F8FA6),
                    fontSize = 11.sp
                )

                Spacer(modifier = Modifier.height(40.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text = "More Details About Problem …...") },
                    minLines = 7,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color(0xff0E4DFB),
                        focusedBorderColor = Color(0xff0E4DFB),

                        ),
                    value = imgDetails, onValueChange = { value -> imgDetails = value },
                )


            }




            Button(
                onClick = {

//                    val details = "Test"
                    val imgPath = FileHelper.mapUrisToPaths(selectedMultiImages)
                    val imagesJson =
                        Gson().toJson(imgPath.toTypedArray(), Array<String>::class.java)

                    if (imgDetails.isNotEmpty()){

                        navController.navigate(
                            Screens.AddOrderScreen.AddLocation.route + "/${id}" + "/${imgDetails}" + "/${
                                Uri.encode(
                                    imagesJson
                                )
                            }"
                        )
                        Log.d("selectedMultiImages", selectedMultiImages.toString())
                    }else{
                        Toast.makeText(
                            context,
                            "Please Add Information About Your Problem!",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }

                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(50.dp)
                    .shadow(
                        elevation = 10.dp,
                        ambientColor = Color(0xffE9C75E),
                        spotColor = Color(0xffE9C75E),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .background(
                        color = Color(0xff222328)
                    ),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = ButtonDefaults.elevation(0.dp, pressedElevation = 0.dp)

            ) {
                Text(
                    text = "NEXT",
                    color = Color.White,

                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                )
            }

        }


    }
}

//private fun convertUriToFile(context: Context, uri: Uri): File? {
//    val inputStream = context.contentResolver.openInputStream(uri)
//    val fileName = "image_${System.currentTimeMillis()}"
//    val file = File(context.cacheDir, fileName)
//    inputStream?.use { input ->
//        file.outputStream().use { output ->
//            input.copyTo(output)
//        }
//        return file
//    }
//    return null
//}