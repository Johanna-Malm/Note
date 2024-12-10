package com.example.myapplicationnote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NewNote(navController: NavController, viewModel: NoteViewModel){

    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    var isTitleError by remember { mutableStateOf(false) }
    var isTextError by remember { mutableStateOf(false) }

    Column {
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = title,
            onValueChange = {
                title = it
                isTitleError = (it.length < 3 || it.length > 50 || it.isEmpty())
        },
            label = { Text(text = "Title")},
            isError = isTitleError,
            supportingText = {if(isTitleError) {Text(text = "Title must be between 3 and 50 characters")}},
            modifier = Modifier.fillMaxWidth()
                .padding(2.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = text,
            onValueChange = {
                text = it
                isTextError = (it.length > 120 || it.isEmpty())
            },
            label = { Text(text = "Text")},
            isError = isTextError,
            supportingText = {if(isTextError) {Text(text = "Text must be less than 120 characters")}},
            modifier = Modifier.fillMaxWidth()
                .padding(2.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            if(!isTextError && !isTitleError && title.isNotBlank() && text.isNotBlank()){
                viewModel.addNote(title, text)
                navController.navigate(Routes.MainScreen)
            }
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
            Text(text = "Create Note")
        }

    }

}

@Preview
@Composable
fun NewNotePreview(){
}