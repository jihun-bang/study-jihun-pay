package jihun.bang.jihunpayserver.service

import jihun.bang.jihunpayserver.model.Account
import jihun.bang.jihunpayserver.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountServiceImpl constructor(@Autowired private val repository: AccountRepository) : AccountService {
    override fun getAllAccounts(): List<Account> {
        return repository.findAll().toList().also { println("[AccountServiceImpl][getAllAccounts] $it") }
    }

    override fun getAccount(id: Int): Account? {
        return repository.findById(id).orElse(null)
            .also { println("[AccountServiceImpl][getAccount] [Input] $id [Result] $it") }
    }

    @Transactional
    override fun addAccount(model: Account): Boolean {
        repository.save(model)
        return repository.findById(model.id).isPresent.also { println("[AccountServiceImpl][addAccount] [Input] $model [Result] $it") }
    }

    @Transactional
    override fun updateAccount(id: Int, model: Account): Boolean {
        repository.findById(id).let {
            if (it.isPresent) {
                repository.delete(it.get())
                repository.save(model)
            }
        }
        return repository.findById(id).isPresent.also { println("[AccountServiceImpl][updateAccount] [Input] id=$id, model=$model [Result] $it") }
    }

    @Transactional
    override fun deleteAccount(id: Int): Boolean {
        repository.findById(id).let { if (it.isPresent) repository.delete(it.get()) }
        return repository.findById(id).isPresent.not()
            .also { println("[AccountServiceImpl][deleteAccount] [Input] $id [Result] $it") }
    }
}