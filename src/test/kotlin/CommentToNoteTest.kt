import junit.framework.Assert.*
import org.junit.Test

internal class CommentToNoteTest {

    var notes = ArrayList<Note>()
    var deletedNotes = ArrayList<Note>()
    var comments = ArrayList<CommentToNote>()
    var deletedComments = ArrayList<CommentToNote>()

    @Test
    fun createComment() {
        val commentToNoteFunctions = CommentToNoteFunctions()
        var testParam: Boolean = true
        if (commentToNoteFunctions.createComment(noteID = 100, ownerID = 10, "some text to comment", comments) == 0)
            testParam = false
        assertEquals(true, testParam)
    }

    @Test
    fun editRealComment() {
        val commentToNoteFunctions = CommentToNoteFunctions()
        commentToNoteFunctions.createComment(noteID = 100, ownerID = 10, "some text to comment", comments)
        assertEquals(true, commentToNoteFunctions.editComment(commentID = 1, message = "first edited comment", comments = comments))
    }

    @Test
    fun editNotRealComment() {
        val commentToNoteFunctions = CommentToNoteFunctions()
        commentToNoteFunctions.createComment(noteID = 100, ownerID = 10, "some text to comment", comments)
        assertEquals(false, commentToNoteFunctions.editComment(commentID = 2, message = "first edited comment", comments = comments))
    }

    @Test
    fun deleteComments() {
        val commentToNoteFunctions = CommentToNoteFunctions()
        val noteFunctions = NoteFunctions()

        val theFirstNoteID = noteFunctions.add("first note", "some text", notes)
        val commentID = commentToNoteFunctions.createComment(
                noteID = theFirstNoteID,
                text = "some text in comment",
                comments = comments
        )
        noteFunctions.delete(theFirstNoteID, notes, deletedNotes, comments, deletedComments)

        assertFalse(commentToNoteFunctions.isComment(commentID, comments))
    }
}