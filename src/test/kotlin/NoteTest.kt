import junit.framework.Assert.assertEquals
import org.junit.Test

internal class NoteTest {

    @Test
    fun add() {
        val noteFunctions = NoteFunctions()
        var testParam: Boolean = true
        if (noteFunctions.add("text for the first note", "some text") == 0)
            testParam = false
            assertEquals(true, testParam)
    }

    @Test
    fun editRealNote() {
        val noteFunctions = NoteFunctions()
        noteFunctions.add("first note", "some text")
        assertEquals(true, noteFunctions.edit(noteID = 100, title = "first edited note", text = "some another text"))
    }

    @Test
    fun editNotRealNote() {
        val noteFunctions = NoteFunctions()
        noteFunctions.add("first note", "some text")
        assertEquals(false, noteFunctions.edit(noteID = 101, title = "first edited note", text = "some another text"))
    }
}