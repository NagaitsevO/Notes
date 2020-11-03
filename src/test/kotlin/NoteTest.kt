import junit.framework.Assert.assertEquals
import org.junit.Test

internal class NoteTest {

    var notes = ArrayList<Note>()
    var deletedNotes = ArrayList<Note>()
    var comments = ArrayList<CommentToNote>()
    var deletedComments = ArrayList<CommentToNote>()

    @Test
    fun add() {
        val noteFunctions = NoteFunctions()
        var testParam: Boolean = true
        if (noteFunctions.add("text for the first note", "some text", notes) == 0)
            testParam = false
            assertEquals(true, testParam)
    }

    @Test
    fun editRealNote() {
        val noteFunctions = NoteFunctions()
        noteFunctions.add("first note", "some text", notes)
        assertEquals(true, noteFunctions.edit(noteID = 100, title = "first edited note", text = "some another text", notes))
    }

    @Test
    fun editNotRealNote() {
        val noteFunctions = NoteFunctions()
        noteFunctions.add("first note", "some text", notes)
        assertEquals(false, noteFunctions.edit(noteID = 101, title = "first edited note", text = "some another text", notes))
    }

    @Test
    fun deleteNote() {
        val noteFunctions = NoteFunctions()
        val theFirstNoteID = noteFunctions.add("first note", "some text", notes)
        val commentToNoteFunctions = CommentToNoteFunctions()
        commentToNoteFunctions.createComment(noteID = theFirstNoteID, text = "some text in comment", comments = comments)
        assertEquals(true, noteFunctions.delete(theFirstNoteID, notes, deletedNotes, comments, deletedComments))
    }

    @Test
    fun restoreNote() {
        val noteFunctions = NoteFunctions()
        val theFirstNoteID = noteFunctions.add("first note", "some text", notes)
        val commentToNoteFunctions = CommentToNoteFunctions()
        commentToNoteFunctions.createComment(noteID = theFirstNoteID, text = "some text in comment", comments = comments)
        noteFunctions.delete(theFirstNoteID, notes, deletedNotes, comments, deletedComments)
        assertEquals(true, noteFunctions.restore(theFirstNoteID, notes, deletedNotes))
    }
}