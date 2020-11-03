class NoteFunctions {

    var bufferNoteID: Int = 100


    fun add(title: String, text: String, notes: MutableList<Note>): Int {
        val note = Note(noteID = bufferNoteID, title = title, text = text)
        bufferNoteID++
        notes.add(note)
        return note.noteID
    }

    fun edit(noteID: Int, title: String, text: String, notes: MutableList<Note>): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (note.noteID == noteID) {
                notes[index].title = title
                notes[index].text = text
                println("Заметка откорректирована")
                return true
            }
        }
        println("Не удалось откорректировать заметку")
        return false
    }

    fun delete(noteID: Int, notes: MutableList<Note>, deletedNotes: MutableList<Note>, comments: MutableList<CommentToNote>, deletedComments: MutableList<CommentToNote>): Boolean {
        val commentToNoteFunctions = CommentToNoteFunctions()
        if (!isNoteDeleted(noteID, deletedNotes)) {
            for ((index, note) in notes.withIndex()) {
                if (note.noteID == noteID) {
                    deletedNotes.add(notes[index])
                    notes.remove(notes[index])
                    commentToNoteFunctions.deleteAllCommentsToOneNote(noteID, comments, deletedComments)
                    println("Заметка удалена")
                    return true
                }
            }
        }
        if (isNoteDeleted(noteID, deletedNotes)) {
            println("Данная заметка уже удалена")
        }
        println("Не удалось удалить заметку")
        return false
    }

    fun restore(noteID: Int, notes: MutableList<Note>, deletedNotes: MutableList<Note>): Boolean {
        if (!isNote(noteID, notes)) {
            for ((index, note) in deletedNotes.withIndex()) {
                if (note.noteID == noteID) {
                    notes.add(deletedNotes[index])
                    deletedNotes.remove(notes[index])
                    println("Заметка восстановлена")
                    return true
                }
            }
        }
        if (isNote(noteID, notes)) {
            println("Данная заметка не удалена")
        }
        println("Не удалось восстановить заметку")
        return false
    }

    fun getByID(noteID: Int, ownerID: Int = 100, notes: MutableList<Note>): Note? {
        for ((index, note) in notes.withIndex()) {
            if (note.noteID == noteID) {
                println("Заметка найдена")
                return notes[index]
            }
        }
        println("Не удалось найти заметку")
        return null
    }

    fun getNotes(noteIDs: Array<Int>, ownerID: Int = 100, notes: MutableList<Note>): ArrayList<Note>? {
        var i: Int = 0
        var foundNotes = ArrayList<Note>()
        for ((index, note) in notes.withIndex()) {
            for (i in 0..noteIDs.size) {
                if (note.noteID == noteIDs[i])
                    foundNotes.add(note)
            }
        }
        if (foundNotes.isEmpty()) {
            println("Не удалось найти заметку")
            return null
        }
        println("Найденные заметки:")
        return foundNotes
    }

    fun isNoteDeleted(noteID: Int, deletedNotes: MutableList<Note>): Boolean {
        for ((index, note) in deletedNotes.withIndex()) {
            if (note.noteID == noteID) {
                return true
            }
        }
        return false
    }

    fun isNote(noteID: Int, notes: MutableList<Note>): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (note.noteID == noteID) {
                return true
            }
        }
        return false
    }
}


/*
Методы для работы с заметками.
==add Создает новую заметку у текущего пользователя. = Int (ID созданной заметки)
    ==title заголовок заметки. строка, обязательный параметр
    ==text текст заметки. строка, обязательный параметр
===createComment Добавляет новый комментарий к заметке. = Int (ID созданного комментария)
    ==note_id идентификатор заметки. положительное число, обязательный параметр
    ==owner_id идентификатор владельца заметки. положительное число, по умолчанию идентификатор текущего пользователя
==delete Удаляет заметку текущего пользователя. = Boolean
    ==note_id идентификатор заметки. положительное число, обязательный параметр
===deleteComment Удаляет комментарий к заметке. = Boolean
    comment_id идентификатор комментария. положительное число, обязательный параметр
    owner_id идентификатор владельца заметки. положительное число, по умолчанию идентификатор текущего пользователя
==edit Редактирует заметку текущего пользователя. = Boolean
    ==note_id идентификатор заметки. положительное число, обязательный параметр
    ==title заголовок заметки. строка, обязательный параметр
    ==text текст заметки. строка, обязательный параметр
===editComment Редактирует указанный комментарий у заметки. = Boolean
    comment_id идентификатор комментария. положительное число, обязательный параметр
    ==owner_id идентификатор владельца заметки. положительное число, по умолчанию идентификатор текущего пользователя
    message новый текст комментария. строка, минимальная длина 2
==get Возвращает список заметок, созданных пользователем.
    note_ids идентификаторы заметок, информацию о которых необходимо получить. список положительных чисел, разделенных запятыми
    user_id идентификатор пользователя, информацию о заметках которого требуется получить.
    положительное число, по умолчанию идентификатор текущего пользователя
==getById Возвращает заметку по её id. =
                                После успешного выполнения возвращает список объектов заметок с дополнительными полями:
                                privacy — уровень доступа к заметке
                                (0 — все пользователи,
                                1 — только друзья,
                                2 — друзья и друзья друзей,
                                3 — только пользователь);
                                comment_privacy — уровень доступа к комментированию заметки
                                (0 — все пользователи,
                                1 — только друзья,
                                2 — друзья и друзья друзей,
                                3 — только пользователь);
                                can_comment — может ли текущий пользователь комментировать заметку
                                (1 — может,
                                0 — не может).
    note_id идентификатор заметки. положительное число, обязательный параметр
    owner_id идентификатор владельца заметки. положительное число, по умолчанию идентификатор текущего пользователя
===getComments Возвращает список комментариев к заметке. =
                                Возвращает массив объектов comment, каждый из которых содержит следующие поля:
                                id — идентификатор комментария;
                                uid — идентификатор автора комментария;
                                nid — идентификатор заметки;
                                oid — идентификатор владельца заметки;
                                date — дата добавления комментария в формате unixtime;
                                message — текст комментария;
                                reply_to — идентификатор пользователя, в ответ на комментарий которого был оставлен текущий комментарий (если доступно).
    note_id идентификатор заметки. положительное число, обязательный параметр
    owner_id идентификатор владельца заметки. положительное число, по умолчанию идентификатор текущего пользователя
===restoreComment Восстанавливает удалённый комментарий. = Boolean
    comment_id идентификатор удаленного комментария. положительное число, обязательный параметр
    owner_id идентификатор владельца заметки. положительное число, по умолчанию идентификатор текущего пользователя
 */