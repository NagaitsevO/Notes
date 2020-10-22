import junit.framework.Assert.assertEquals
import org.junit.Test

internal class WallServiceTest {
    val theFirstComments = CommentsInfoToPost(
        canPost = true
    )
    val theFirstLikes = Likes(
        canLike = true
    )
    val theFirstReposts = Reposts()
    val theFirstViewsObject = ViewsObject(
        count = 1
    )
    val theFirstVideo = AttachmentVideo(player = null)
    val theFirstPhoto = AttachmentPhoto(sizes = null)
    val theFirstAttach = arrayOf(theFirstPhoto, theFirstVideo)

    val theFirstPost = Post(
        id = 1,
        commentsInfoToPost = theFirstComments,
        likes = theFirstLikes,
        reposts = theFirstReposts,
        viewsObject = theFirstViewsObject,
        postType = PostType.POST,
        attach = theFirstAttach
    )

    @Test
    fun add() {
        val wallservice = WallService()
        var testParam: Boolean = true
        wallservice.add(theFirstPost)
        if (theFirstPost.id == 0) testParam = false
        assertEquals(true, testParam)
    }

    @Test
    fun updateRealID() {
        val wallservice = WallService()
        wallservice.add(theFirstPost)
        assertEquals(true, wallservice.update(theFirstPost))
    }

    @Test
    fun updateNotRealID() {
        val wallservice = WallService()
        val theFirstComments = CommentsInfoToPost(
            canPost = true
        )
        val theFirstLikes = Likes(
            canLike = true
        )
        val theFirstReposts = Reposts()
        val theFirstViewsObject = ViewsObject(
            count = 1
        )

        val theSecondPost = Post(
            id = 5,
            commentsInfoToPost = theFirstComments,
            likes = theFirstLikes,
            reposts = theFirstReposts,
            viewsObject = theFirstViewsObject,
            postType = PostType.POST,
            attach = theFirstAttach
        )
        assertEquals(false, wallservice.update(theSecondPost))
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowOK() {
        val wallservice = WallService()
        var comment = CommentToPost(postID = 1, attachment = theFirstAttach)
        wallservice.createComment(comment)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowNotOK() {
        val wallservice = WallService()
        var comment = CommentToPost(postID = 10, attachment = theFirstAttach)
        wallservice.createComment(comment)
    }
}