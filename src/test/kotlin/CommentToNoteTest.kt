import junit.framework.Assert.assertEquals
import org.junit.Test

internal class CommentToNoteTest {

    @Test
    fun createComment() {
        val commentToNoteFunctions = CommentToNoteFunctions()
        var testParam: Boolean = true
        if (commentToNoteFunctions.createComment(noteID = 100, ownerID = 10, "some text to comment") == 0)
            testParam = false
        assertEquals(true, testParam)
    }

    @Test
    fun editRealComment() {
        val commentToNoteFunctions = CommentToNoteFunctions()
        commentToNoteFunctions.createComment(noteID = 100, ownerID = 10, "some text to comment")
        assertEquals(true, commentToNoteFunctions.editComment(commentID = 1, message = "first edited comment"))
    }

    @Test
    fun editNotRealComment() {
        val commentToNoteFunctions = CommentToNoteFunctions()
        commentToNoteFunctions.createComment(noteID = 100, ownerID = 10, "some text to comment")
        assertEquals(false, commentToNoteFunctions.editComment(commentID = 2, message = "first edited comment"))
    }
}