package com.example.myapplicationnote

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

object NoteManager{
    val noteList = mutableStateListOf<Note>()

    fun getAllNotes(): List<Note>{
        return noteList
    }

    fun addNote(title: String, text: String){
        noteList.add(Note(System.currentTimeMillis().toInt(), title, text))
    }

    fun deleteNote(id: Int){
        noteList.removeIf { it.id == id }
    }

    fun getNoteById(id: Int): Note{
        return noteList.find { it.id == id }!!
    }

    fun editNote(id: Int, title: String, text: String){
        val note = getNoteById(id)
        note.title = title
        note.text = text
    }
}