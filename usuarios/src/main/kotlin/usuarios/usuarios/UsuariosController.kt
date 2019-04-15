package usuarios.usuarios

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("usuarios")
class UsuariosController {

    @Autowired
    private lateinit var usuarioService: UsuarioService

    @GetMapping()
    fun list(): ResponseEntity<List<Usuarios?>> {
        return ResponseEntity.ok(usuarioService.findUser())
    }

    @PostMapping
    fun create(
        @RequestBody usuarioDTO : UsuariosDTO
    ): ResponseEntity<Usuarios>{
        return ResponseEntity.created(URI("")).body(usuarioService.addUser(usuarioDTO))
    }

    @PatchMapping("{id}")
    fun update(
        @PathVariable id : Long,
        @RequestBody usuariosDTO: UsuariosDTO
    ) : ResponseEntity<Usuarios> {
        return ResponseEntity.ok(usuarioService.editUser(id = id, newUser = usuariosDTO ))
    }

    @DeleteMapping("{id}")
    fun delete(
        @PathVariable id : Long
    ) : ResponseEntity<String> {
        usuarioService.delele(id)
        return ResponseEntity.noContent().build<String>()
    }
}