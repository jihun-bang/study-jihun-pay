package jihun.bang.jihunpayserver.repository

import jihun.bang.jihunpayserver.model.History
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HistoryRepository : CrudRepository<History, Int>