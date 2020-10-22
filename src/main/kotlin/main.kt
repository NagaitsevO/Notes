
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

    var comment = CommentToPost (postID = 10, attachment = theFirstAttach)
    wallservice.createComment(comment)
    println(comment)



}