package jihun.bang.jihunpayserver.service

import jihun.bang.jihunpayserver.model.History
import org.springframework.stereotype.Service

@Service
interface HistoryService {
    fun getAllHistories(): List<History>

    fun getHistory(id: Int): History?

    fun addHistory(model: History): Boolean

    fun updateHistory(id: Int, model: History): Boolean

    fun deleteHistory(id: Int): Boolean
}