class AttachmentPhoto(
    override val id: Int = 100,
    override val albumID: Int = 100,
    override val ownerID: Int = 100,
    override val userID: Int = 100,
    override val type: AttachmentType = AttachmentType.PHOTO,
    val text: String = "Photo1",
    val date: Int = 0,
    val sizes: Array<AttachmentPhotoProperties>?

) : Attachment {
}