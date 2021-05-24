package jihun.bang.jihunpayserver.repository

import jihun.bang.jihunpayserver.model.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : CrudRepository<Account, Int>