class AttachmentLink(
    override val id: Int,
    override val albumID: Int,
    override val ownerID: Int,
    override val userID: Int,
    override val type: AttachmentType = AttachmentType.LINK,
    val url: String,
    val title: String,
    val caption: String?

) : Attachment {
}