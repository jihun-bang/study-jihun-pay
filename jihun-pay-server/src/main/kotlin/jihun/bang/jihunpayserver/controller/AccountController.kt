package jihun.bang.jihunpayserver.controller

import jihun.bang.jihunpayserver.model.Account
import jihun.bang.jihunpayserver.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class AccountController {
    @Autowired
    private lateinit var accountService: AccountService

    @GetMapping("/accounts")
    private fun getAccounts(): ResponseEntity<Any> {
        println("[AccountController][getAccounts][Start]")
        return ResponseEntity
            .ok()
            .body(accountService.getAllAccounts().also { println("[AccountController][getAccounts][Return] $it") })
    }

    @GetMapping("/account/{id}")
    private fun getAccountById(@PathVariable id: Int): ResponseEntity<Any> {
        println("[AccountController][getAccountById][Start] id=$id")
        return ResponseEntity
            .ok()
            .body(
                (accountService.getAccount(id)
                    ?: "id=$id, Get Failed").also { println("[AccountController][getAccountById][Return] $it") })
    }

    @PostMapping("/account")
    private fun addAccount(@RequestBody model: Account): ResponseEntity<Any> {
        println("[AccountController][addAccount][Start] model=$model")
        return when (accountService.addAccount(model)) {
            true -> ResponseEntity.ok()
                .body("model=$model, Add Success".also { println("[AccountController][addAccount][Return] $it") })
            false -> ResponseEntity.ok()
                .body("model=$model, Add Fail".also { println("[AccountController][addAccount][Return] $it") })
        }
    }

    @PutMapping("/account/{id}")
    private fun updateAccount(@PathVariable id: Int, @RequestBody model: Account): ResponseEntity<Any> {
        println("[AccountController][addAccount][Start] id=$id, model=$model")
        return when (accountService.updateAccount(id, model = model)) {
            true -> ResponseEntity.ok()
                .body("id=$id, Update Success".also { println("[AccountController][updateAccount][Return] $it") })
            false -> ResponseEntity.ok()
                .body("id=$id, Update Fail".also { println("[AccountController][updateAccount][Return] $it") })
        }
    }

    @DeleteMapping("/account/{id}")
    private fun deleteAccount(@PathVariable id: Int): ResponseEntity<Any> {
        return when (accountService.deleteAccount(id)) {
            true -> ResponseEntity.ok()
                .body("id=$id, Delete Success".also { println("[AccountController][deleteAccount][Return] $it") })
            false -> ResponseEntity.ok()
                .body("id=$id, Delete Fail".also { println("[AccountController][deleteAccount][Return] $it") })
        }
    }
}