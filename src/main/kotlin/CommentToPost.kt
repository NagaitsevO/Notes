data class CommentToPost (
    val id: Int = 200,
    val postID: Int = 1,
    val fromId: Int = 300,
    val date: Int = 0,
    var text: String = "",
    var attachment: Array<Attachment>,
    var count: Int = 10,
    var canPost: Boolean = true,
    var groupsCanPost: Boolean = false
)
{

}

/* id integer	идентификатор комментария.
from_id integer	идентификатор автора комментария.
date integer	дата создания комментария в формате Unixtime.
text string	текст комментария.
reply_to_user integer - не будем делать = идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
reply_to_comment integer - не будем делать = идентификатор комментария, в ответ на который оставлен текущий (если применимо).
attachments object	- просто массив сделаем = медиавложения комментария (фотографии, ссылки и т.п.). Описание массива attachments находится на отдельной странице.
parents_stack array	- не будем делать = массив идентификаторов родительских комментариев.
thread object - не будем делать = Информация о вложенной ветке комментариев, объект с полями:
count (integer) — количество комментариев в ветке.
items (array) — не будем делать = массив объектов комментариев к записи (только для метода wall.getComments).
can_post (boolean) – может ли текущий пользователь оставлять комментарии в этой ветке.
show_reply_button (boolean) – не будем делать = нужно ли отображать кнопку «ответить» в ветке.
groups_can_post (boolean) – могут ли сообщества оставлять комментарии в ветке.*/