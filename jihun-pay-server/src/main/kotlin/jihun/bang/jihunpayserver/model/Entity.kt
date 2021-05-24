package jihun.bang.jihunpayserver.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "",
    val bank: String = "",
    val balance: Int = 0
)

@Entity
data class History(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val user_key: Int = 0,
    val from: String = "",
    val to: String = "",
    val action: String = "",
    val money: Int = 0
)