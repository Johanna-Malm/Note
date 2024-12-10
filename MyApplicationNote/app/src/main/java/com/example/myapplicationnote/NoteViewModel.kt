package com.example.myapplicationnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoteViewModel : ViewModel() {
    private var _noteList = MutableLiveData<List<Note>>()
    val noteList: LiveData<List<Note>> = _noteList

    fun getAllNotes(){
        _noteList.value = NoteManager.getAllNotes()
    }

    fun addNote(title: String, text: String){
        NoteManager.addNote(title, text)
        getAllNotes()
    }

    fun deleteNote(id: Int){
        NoteManager.deleteNote(id)
        getAllNotes()
    }

    fun getNoteById(id: Int): Note{
        return NoteManager.getNoteById(id)
    }

    fun editNote(id: Int, title: String, text: String){
        NoteManager.editNote(id, title, text)
        getAllNotes()
    }
}