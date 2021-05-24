package jihun.bang.jihunpayserver.controller

import jihun.bang.jihunpayserver.model.History
import jihun.bang.jihunpayserver.service.HistoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class HistoryController {
    @Autowired
    private lateinit var historyService: HistoryService

    @GetMapping("/historyies")
    private fun getHistories(): ResponseEntity<Any> {
        println("[HistoryController][getHistories][Start]")
        return ResponseEntity
            .ok()
            .body(historyService.getAllHistories().also { println("[HistoryController][getHistories][Return] $it") })
    }

    @GetMapping("/history/{id}")
    private fun getHistoryById(@PathVariable id: Int): ResponseEntity<Any> {
        println("[HistoryController][getHistoryById][Start] id=$id")
        return ResponseEntity
            .ok()
            .body(
                (historyService.getHistory(id)
                    ?: "id=$id, Get Failed").also { println("[HistoryController][getHistoryById][Return] $it") })
    }

    @PostMapping("/history")
    private fun addHistory(@RequestBody model: History): ResponseEntity<Any> {
        println("[HistoryController][addHistory][Start] model=$model")
        return when (historyService.addHistory(model)) {
            true -> ResponseEntity.ok()
                .body("model=$model, Add Success".also { println("[HistoryController][addHistory][Return] $it") })
            false -> ResponseEntity.ok()
                .body("model=$model, Add Fail".also { println("[HistoryController][addHistory][Return] $it") })
        }
    }

    @PutMapping("/history/{id}")
    private fun updateHistory(@PathVariable id: Int, @RequestBody model: History): ResponseEntity<Any> {
        println("[HistoryController][addHistory][Start] id=$id, model=$model")
        return when (historyService.updateHistory(id, model = model)) {
            true -> ResponseEntity.ok()
                .body("id=$id, Update Success".also { println("[HistoryController][updateHistory][Return] $it") })
            false -> ResponseEntity.ok()
                .body("id=$id, Update Fail".also { println("[HistoryController][updateHistory][Return] $it") })
        }
    }

    @DeleteMapping("/history/{id}")
    private fun deleteHistory(@PathVariable id: Int): ResponseEntity<Any> {
        return when (historyService.deleteHistory(id)) {
            true -> ResponseEntity.ok()
                .body("id=$id, Delete Success".also { println("[HistoryController][deleteHistory][Return] $it") })
            false -> ResponseEntity.ok()
                .body("id=$id, Delete Fail".also { println("[HistoryController][deleteHistory][Return] $it") })
        }
    }
}