package net.effective.가변성_제한
class UserRepository {
    private val storedUsers: MutableMap<Int, String> = mutableMapOf()

    // loadAll 은 Private 프로퍼티를 외부로 노출시키고 storeUsers 내 요소 수정을 가능하게 한다.
//    fun loadAll(): MutableMap<Int, String> {
//        return storedUsers
//    }

    // 이렇게 하면 읽기 전용 불변 컬렉션을 반환할 수 있다.
    fun loadAll(): Map<Int, String> {
        return storedUsers.toMap()
    }
}