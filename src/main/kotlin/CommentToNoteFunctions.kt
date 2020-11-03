class CommentToNoteFunctions {
    var bufferCommentID: Int = 1
    //var comments = ArrayList<CommentToNote>()
    //var deletedComments = ArrayList<CommentToNote>()

    fun printComment(comment: CommentToNote) {
        print("commentID = ")
        println(comment.commentID)
        print("noteID = ")
        println(comment.noteID)
    }

    fun createComment(noteID: Int, ownerID: Int = 100, text: String, comments: MutableList<CommentToNote>): Int {
        val comment = CommentToNote(noteID = noteID, commentID = bufferCommentID)
        bufferCommentID++
        comments.add(comment)
        println("Комментарий к заметке создан")
        return comment.commentID
    }

    fun editComment(commentID: Int, ownerID: Int = 100, message: String, comments: MutableList<CommentToNote>): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (comment.commentID == commentID) {
                comments[index].text = message
                println("Комментарий к заметке откорректирован")
                return true
            }
        }
        println("Не удалось откорректировать комментарий к заметке")
        return false
    }

    fun deleteComment(commentID: Int, comments: MutableList<CommentToNote>, deletedComments: MutableList<CommentToNote>): Boolean {
        //if (!isCommentDeleted(commentID, deletedComments)) {
            for ((index, comment) in comments.withIndex()) {
                if (comment.commentID == commentID) {
                    deletedComments.add(comments[index])
                    comments.remove(comments[index])
                    println("Комментарий к заметке удален")
                    return true
                }
            }
        //}
        if (isCommentDeleted(commentID, deletedComments)) {
            println("Данный комментарий уже удалён")
        }
        println("Не удалось удалить комментарий к заметке")
        return false
    }

    fun deleteAllCommentsToOneNote(noteID: Int, comments: MutableList<CommentToNote>, deletedComments: MutableList<CommentToNote>): Boolean {
        for (comment in comments) {
            if (comment.noteID == noteID) {
                deleteComment(comment.commentID, comments, deletedComments)
            }
            return true
        }
        return false
    }

    fun restoreComment(commentID: Int, ownerID: Int = 100, comments: MutableList<CommentToNote>, deletedComments: MutableList<CommentToNote>): Boolean {
        if (isComment(commentID, comments)) {
            for ((index, comment) in comments.withIndex()) {
                if (comment.commentID == commentID) {
                    comments.add(comments[index])
                    deletedComments.remove(comments[index])
                    println("Комментарий к заметке восстановлен")
                    return true
                }
            }
        }
        if (!isComment(commentID, comments)) {
            println("Данный комментарий не удалён")
        }
        println("Не удалось восстановить комментарий к заметке")
        return false
    }

    fun getComments(commentID: Int, ownerID: Int = 100, comments: MutableList<CommentToNote>): CommentToNote? {
        for ((index, comment) in comments.withIndex()) {
            if (comment.commentID == commentID) {
                println("Комментарий найден")
                return comments[index]
            }
        }
        println("Не удалось найти комментарий")
        return null
    }

    fun isCommentDeleted(commentID: Int, deletedComments: MutableList<CommentToNote>): Boolean {
        for (comment in deletedComments) {
            if (comment.commentID == commentID) {
                return true
            }
        }
        return false
    }

    fun isComment(commentID: Int, comments: MutableList<CommentToNote>): Boolean {
        for (comment in comments) {
            if (comment.commentID == commentID) {
                return true
            }
        }
        return false
    }
}

/*
==createComment Добавляет новый комментарий к заметке. = Int (ID созданного комментария)
    ==note_id идентификатор заметки. положительное число, обязательный параметр
    ==owner_id идентификатор владельца заметки. положительное число, по умолчанию идентификатор текущего пользователя
==deleteComment Удаляет комментарий к заметке. = Boolean
    comment_id идентификатор комментария. положительное число, обязательный параметр
    owner_id идентификатор владельца заметки. положительное число, по умолчанию идентификатор текущего пользователя
==editComment Редактирует указанный комментарий у заметки. = Boolean
    comment_id идентификатор комментария. положительное число, обязательный параметр
    ==owner_id идентификатор владельца заметки. положительное число, по умолчанию идентификатор текущего пользователя
    message новый текст комментария. строка, минимальная длина 2
==getComments Возвращает список комментариев к заметке. =
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

==restoreComment Восстанавливает удалённый комментарий. = Boolean
    comment_id идентификатор удаленного комментария. положительное число, обязательный параметр
    owner_id идентификатор владельца заметки. положительное число, по умолчанию идентификатор текущего пользователя
 */