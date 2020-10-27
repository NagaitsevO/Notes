
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

    println(theFirstPost)
    wallservice.add(theFirstPost)
    println(wallservice.update(theFirstPost))
    println(theFirstPost)

    val noteFunctions = NoteFunctions()
    println(noteFunctions.add("first note", "some text"))
    noteFunctions.printNotes()
    noteFunctions.edit(noteID = 100, title = "first edited note", text = "some another text")
    noteFunctions.printNotes()

    val theFirstNoteID = noteFunctions.add("first note", "some text")
    val commentToNoteFunctions = CommentToNoteFunctions()
    commentToNoteFunctions.createComment(noteID = theFirstNoteID, text = "some text in comment")
    println("theFirstNoteID = $theFirstNoteID")
    noteFunctions.delete(theFirstNoteID)
    println("theFirstNoteID = $theFirstNoteID")
    noteFunctions.restore(theFirstNoteID)
    println("theFirstNoteID = $theFirstNoteID")
}