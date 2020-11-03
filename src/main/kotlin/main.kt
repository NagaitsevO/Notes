
fun main() {

    val wallservice = WallService()
    val theFirstComments = CommentsInfoToPost (
            canPost = true
    )
    val theFirstLikes = Likes (
            canLike = true
    )
    val theFirstReposts = Reposts ()
    val theFirstViewsObject = ViewsObject (
            count = 1
    )
    val theFirstVideo = AttachmentVideo (player = null)
    val theFirstPhoto = AttachmentPhoto (sizes = null)
    val theFirstAttach = arrayOf(theFirstPhoto, theFirstVideo)

    val theFirstPost = Post (
            id = 1,
            commentsInfoToPost = theFirstComments,
            likes = theFirstLikes,
            reposts = theFirstReposts,
            viewsObject = theFirstViewsObject,
            postType = PostType.POST,
            attach = theFirstAttach
    )

    val theSecondPost = Post (
            id = 5,
            commentsInfoToPost = theFirstComments,
            likes = theFirstLikes,
            reposts = theFirstReposts,
            viewsObject = theFirstViewsObject,
            postType = PostType.POST,
            attach = theFirstAttach
    )

    var notes = ArrayList<Note>()
    var deletedNotes = ArrayList<Note>()
    var comments = ArrayList<CommentToNote>()
    var deletedComments = ArrayList<CommentToNote>()


    println(theFirstPost)
    wallservice.add(theFirstPost)
    println(wallservice.update(theFirstPost))
    println(theFirstPost)

    val noteFunctions = NoteFunctions()
    println(noteFunctions.add("first note", "some text", notes))
    println(notes)
    noteFunctions.edit(noteID = 100, title = "first edited note", text = "some another text", notes)
    println(notes)

    /*val theFirstNoteID = noteFunctions.add("first note", "some text",notes)
    val commentToNoteFunctions = CommentToNoteFunctions()
    commentToNoteFunctions.createComment(noteID = theFirstNoteID, text = "some text in comment", comments = comments)
    println("theFirstNoteID = $theFirstNoteID")
    noteFunctions.delete(theFirstNoteID, notes, deletedNotes, comments, deletedComments)
    println("theFirstNoteID = $theFirstNoteID")
    noteFunctions.restore(theFirstNoteID, notes, deletedNotes)
    println("theFirstNoteID = $theFirstNoteID")*/


    val commentToNoteFunctions = CommentToNoteFunctions()
    val theFirstNoteID = noteFunctions.add("first note", "some text", notes)
    val commentID = commentToNoteFunctions.createComment(
            noteID = theFirstNoteID,
            text = "some text in comment",
            comments = comments
    )
    println("theFirstNoteID = $theFirstNoteID")
    println("commentID = $commentID")
    commentToNoteFunctions.printComment(comments[0])
    noteFunctions.delete(theFirstNoteID, notes, deletedNotes, comments, deletedComments)

    println(commentToNoteFunctions.isComment(commentID, comments))
}