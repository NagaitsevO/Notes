class AttachmentDoc(
    override val id: Int,
    override val albumID: Int,
    override val ownerID: Int,
    override val userID: Int,
    override val type: AttachmentType = AttachmentType.DOC,
    val title: String,
    val size: Int,
    val url: String,
    val ext: String, //расширение
    val date: Int
) : Attachment {

}