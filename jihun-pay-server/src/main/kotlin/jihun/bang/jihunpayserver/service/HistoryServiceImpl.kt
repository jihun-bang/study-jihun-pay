package jihun.bang.jihunpayserver.service

import jihun.bang.jihunpayserver.model.History
import jihun.bang.jihunpayserver.repository.HistoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HistoryServiceImpl constructor(@Autowired private val repository: HistoryRepository) : HistoryService {
    override fun getAllHistories(): List<History> {
        return repository.findAll().toList().also { println("[HistoryServiceImpl][getAllHistories] $it") }
    }

    override fun getHistory(id: Int): History? {
        return repository.findById(id).orElse(null)
            .also { println("[HistoryServiceImpl][getHistory] [Input] $id [Result] $it") }
    }

    @Transactional
    override fun addHistory(model: History): Boolean {
        repository.save(model)
        return repository.findById(model.id).isPresent.also { println("[HistoryServiceImpl][addHistory] [Input] $model [Result] $it") }
    }

    @Transactional
    override fun updateHistory(id: Int, model: History): Boolean {
        repository.findById(id).let {
            if (it.isPresent) {
                repository.delete(it.get())
                repository.save(model)
            }
        }
        return repository.findById(id).isPresent.also { println("[HistoryServiceImpl][updateHistory] [Input] id=$id, model=$model [Result] $it") }
    }

    @Transactional
    override fun deleteHistory(id: Int): Boolean {
        repository.findById(id).let { if (it.isPresent) repository.delete(it.get()) }
        return repository.findById(id).isPresent.not()
            .also { println("[HistoryServiceImpl][deleteHistory] [Input] $id [Result] $it") }
    }
}