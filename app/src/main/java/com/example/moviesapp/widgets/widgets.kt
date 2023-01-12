package com.example.moviesapp.widgets

import android.util.Size
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.foundation.shape.CornerSize

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color


import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter


import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.getMovies



@Preview
@Composable
fun MovieRow(movie: Movie= getMovies()[0],
             onItemClick:(String)->Unit ={}){
    var expanded by remember{
        mutableStateOf(false)

    }

    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
       // .height(130.dp)
        .clickable {
            onItemClick(movie.id)
        },
        shape = RoundedCornerShape(corner= CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp) {



                AsyncImage(
                    movie.images.first(),
                    contentDescription = "Movie Image",
                    modifier = Modifier.clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
            

//               Icon(imageVector = Icons.Default.AccountBox,
//                    contentDescription = "Movie Image")
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Director: ${movie.title}",
                    style = MaterialTheme.typography.caption
                )
                Text(
                    text = "Released: ${movie.year}",
                    style = MaterialTheme.typography.caption
                )

                AnimatedVisibility(visible = expanded) {
                    
                    Column() {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.DarkGray,
                            fontSize = 13.sp)){
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(color = Color.DarkGray,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                            )
                            )
                            {
                                append(movie.plot)
                            }
                        })
                    }
                }



                Icon(
                    imageVector =if (expanded) Icons.Filled.KeyboardArrowUp else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        },
                    tint = Color.DarkGray
                )

            }

        }





    }
}


