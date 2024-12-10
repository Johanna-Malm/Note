package com.example.myapplicationnote

data class Note(
    var id: Int,
    var title: String,
    var text: String,
)

//fun fakeNote(): List<Note> {
//    return listOf<Note>(
//        Note(1, "Title 1", "Text 1"),
//        Note(2, "Title 2", "Text 2"),
//        Note(3, "Title 3", "Text 3"),
//        Note(4, "Title 4", "Text 4"),
//        Note(5, "Title 5", "Text 5"),
//        Note(6, "Title 6", "Text 6"),
//        Note(7, "Title 7", "Text 7"),
//        Note(8, "Title 8", "Text 8"),
//        Note(9, "Title 9", "Text 9"),
//        Note(10, "Title 10", "Text 10"),
//        Note(11, "Title 11", "Text 11"),
//        Note(12, "Title 12", "Text 12"),
//        Note(13, "Title 13", "Text 13"),
//        Note(14, "Title 14", "Text 14"),
//        Note(15, "Title 15", "Text 15"),
//        Note(16, "Title 16", "Text 16"),
//        Note(17, "Title 17", "Text 17"),
//        Note(18, "Title 18", "Text 18"),
//    )
//}