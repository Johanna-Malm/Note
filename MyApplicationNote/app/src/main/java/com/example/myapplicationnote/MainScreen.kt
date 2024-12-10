package com.example.myapplicationnote

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController, viewModel: NoteViewModel){

    val notes by viewModel.noteList.observeAsState()

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate(Routes.NewNote)
        },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(20.dp),
            colors = buttonColors(
                containerColor = LightGray,
                contentColor = Black
            )
        ){
            Text(text = "New Note")
        }
        notes?.let {
            LazyColumn {
                itemsIndexed(it) { index: Int, note: Note ->
                    NoteItem(note = note,
                        onDelete = { viewModel.deleteNote(note.id)},
                        onEdit = { navController.navigate("editNote/${note.id}")})
                }
            }
        }

    }
}


@Composable
fun NoteItem(note: Note, onDelete: ()-> Unit, onEdit: (Note)-> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onEdit(note) }
            .background(color = Color(216, 234, 255), shape = RoundedCornerShape(5.dp)),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(text = note.title,
                fontSize = 20.sp)
            Text(text = note.text,
                fontSize = 16.sp)
        }
        IconButton(onClick = onDelete){
            Icon(painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = Color.DarkGray)
        }
        IconButton(onClick = { onEdit(note) }) {
            Icon(
                painterResource(id = R.drawable.baseline_edit_24),
                contentDescription = "Edit",
                tint = Color.DarkGray
            )
        }
    }
}

