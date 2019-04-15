package usuarios.usuarios

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "usuarios")
class Usuarios(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0,
        var name: String?,
        var age: Int?
)

data class UsuariosDTO(
        var id: Long? = null,
        var name: String? = null,
        var age: Int? = null
)

fun mapDTOToUser(usuariosDTO: UsuariosDTO): Usuarios {
        return Usuarios(
                id = usuariosDTO.id,
                name = usuariosDTO.name,
                age = usuariosDTO.age
        )
}