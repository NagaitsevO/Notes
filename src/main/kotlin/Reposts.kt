data class Reposts (
        var count: Int = 0,
        var userReposted: Boolean = false
) {
}

/*reposts object	информация о репостах записи («Рассказать друзьям»), объект с полями:
    count (integer) — число пользователей, скопировавших запись;
    user_reposted* (integer, [0,1]) — наличие репоста от текущего пользователя (1 — есть, 0 — нет).

 */