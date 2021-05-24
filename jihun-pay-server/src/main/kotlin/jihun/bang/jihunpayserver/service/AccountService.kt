package jihun.bang.jihunpayserver.service

import jihun.bang.jihunpayserver.model.Account
import org.springframework.stereotype.Service

@Service
interface AccountService {
    fun getAllAccounts(): List<Account>

    fun getAccount(id: Int): Account?

    fun addAccount(model: Account): Boolean

    fun updateAccount(id: Int, model: Account): Boolean

    fun deleteAccount(id: Int): Boolean
}