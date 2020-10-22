class CommentToNote(
    val noteID: Int = 10,
    val commentID: Int = 100,
    val ownerID: Int = 100,
    var text: String = "Some text in comment"
)

    var bufferCommentID: Int = 0
    var comments = ArrayList<CommentToNote>()
    var deletedComments = ArrayList<CommentToNote>()

    fun createComment(noteID: Int = 10, ownerID: Int = 100, text: String): Int {
        val comment = CommentToNote(commentID = bufferCommentID)
        bufferCommentID++
        comments.plus(comment)
        return comment.commentID
    }

    fun editComment(commentID: Int, ownerID: Int = 100, message: String): Boolean {
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

    fun deleteComment(commentID: Int, ownerID: Int = 100): Boolean {
        if (isCommentDeleted(commentID)) {
            for ((index, comment) in comments.withIndex()) {
                if (comment.commentID == commentID) {
                    deletedComments.add(comments[index])
                    comments.remove(comments[index])
                    println("Комментарий к заметке удален")
                    return true
                }
            }
        }
        if (!isCommentDeleted(commentID)) {
            println("Данный комментарий уже удалён")
        }
        println("Не удалось удалить комментарий к заметке")
        return false
    }

    fun deleteAllCommentsToOneNote(noteID: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (comment.noteID == noteID) {
                deleteComment(comment.commentID)
            }
            return true
        }
        return false
    }

    fun restoreComment(commentID: Int, ownerID: Int = 100): Boolean {
        if (isComment(commentID)) {
            for ((index, comment) in comments.withIndex()) {
                if (comment.commentID == commentID) {
                    comments.add(comments[index])
                    deletedComments.remove(comments[index])
                    println("Комментарий к заметке восстановлен")
                    return true
                }
            }
        }
        if (!isComment(commentID)) {
            println("Данный комментарий не удалён")
        }
        println("Не удалось восстановить комментарий к заметке")
        return false
    }

    fun getComments(commentID: Int, ownerID: Int = 100): CommentToNote? {
        for ((index, comment) in comments.withIndex()) {
            if (comment.commentID == commentID) {
                println("Комментарий найден")
                return comments[index]
            }
        }
        println("Не удалось найти комментарий")
        return null
}

    fun isCommentDeleted(commentID: Int): Boolean {
        for ((index, comment) in deletedComments.withIndex()) {
            if (comment.commentID == commentID) {
                return true
            }
        }
        return false
    }

    fun isComment(commentID: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (comment.commentID == commentID) {
                return true
            }
        }
        return false
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