data class Post(
    var id: Int,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    var text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    var friendsOnly: Boolean = false,
    val commentsInfoToPost: CommentsInfoToPost,
    val copyright: String = "",
    val likes: Likes,
    val reposts: Reposts,
    val viewsObject: ViewsObject,
    var postType: PostType,
    val signerId: Int = 0,
    var canPin: Boolean = false,
    var canDelete: Boolean = false,
    var canEdit: Boolean = false,
    var isPinned: Boolean = false,
    var markedAsAds: Boolean = false,
    var isFavorite: Boolean = false,
    var postponedId: Int = 0,
    var attach: Array<Attachment>

) {}


/*
id integer	идентификатор записи.
owner_id integer	идентификатор владельца стены, на которой размещена запись. В версиях API ниже 5.7 это поле называется to_id.
from_id integer	идентификатор автора записи (от чьего имени опубликована запись).
created_by integer	идентификатор администратора, который опубликовал запись (возвращается только для сообществ при запросе с ключом доступа администратора). Возвращается в записях, опубликованных менее 24 часов назад.
date integer	время публикации записи в формате unixtime.
text string	текст записи.
reply_owner_id integer	идентификатор владельца записи, в ответ на которую была оставлена текущая.
reply_post_id integer	идентификатор записи, в ответ на которую была оставлена текущая.
friends_only integer, [1]	1, если запись была создана с опцией «Только для друзей».
comments object	информация о комментариях к записи, объект с полями:
    count (integer) — количество комментариев;
    can_post* (integer, [0,1]) — информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
    groups_can_post (integer, [0,1]) — информация о том, могут ли сообщества комментировать запись;
    can_close(boolean) — может ли текущий пользователь закрыть комментарии к записи;
    can_open(boolean) — может ли текущий пользователь открыть комментарии к записи.
copyright string	источник материала.
likes object	информация о лайках к записи, объект с полями:
    count (integer) — число пользователей, которым понравилась запись;
    user_likes* (integer, [0,1]) — наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
    can_like* (integer, [0,1]) — информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);
    can_publish* (integer, [0,1]) — информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).
reposts object	информация о репостах записи («Рассказать друзьям»), объект с полями:
    count (integer) — число пользователей, скопировавших запись;
    user_reposted* (integer, [0,1]) — наличие репоста от текущего пользователя (1 — есть, 0 — нет).
views object	информация о просмотрах записи. Объект с единственным полем:
    count (integer) — число просмотров записи.
post_type string	тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
post_source object - НЕ НУЖНО Поле возвращается только для Standalone-приложений с ключом доступа, полученным в Implicit Flow.	информация о способе размещения записи. Описание объекта находится на отдельной странице.
attachments array - НЕ НУЖНО	медиавложения записи (фотографии, ссылки и т.п.). Описание массива attachments находится на отдельной странице.
geo object - НЕ НУЖНО информация о местоположении , содержит поля:
    type (string) — тип места;
    coordinates (string) — координаты места;
    place (object) — описание места (если оно добавлено). Объект места.
signer_id integer	идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
copy_history array - НЕ НУЖНО	массив, содержащий историю репостов для записи. Возвращается только в том случае, если запись является репостом. Каждый из объектов массива, в свою очередь, является объектом-записью стандартного формата.
can_pin integer, [0,1]	информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
can_delete integer, [0,1]	информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).
can_edit integer, [0,1]	информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).
is_pinned integer, [1]	информация о том, что запись закреплена.
marked_as_ads integer, [0,1]	информация о том, содержит ли запись отметку "реклама" (1 — да, 0 — нет).
is_favorite boolean	true, если объект добавлен в закладки у текущего пользователя.
postponed_id integer	идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.

 */