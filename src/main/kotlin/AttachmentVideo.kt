class AttachmentVideo(
    override val id: Int = 10,
    override val albumID: Int = 10,
    override val ownerID: Int = 10,
    override val userID: Int = 10,
    override val type: AttachmentType = AttachmentType.VIDEO,
    val title: String = "video1",
    val description: String = "Super Video",
    val duration: Int = 600,
    val player: String?, // ссылка на плеер, который используется для воспроизведения
    val date: Int = 0
) : Attachment {

}