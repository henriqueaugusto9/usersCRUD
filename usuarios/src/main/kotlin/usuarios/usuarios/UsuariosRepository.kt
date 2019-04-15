package usuarios.usuarios

import org.springframework.data.jpa.repository.JpaRepository

interface UsuariosRepository : JpaRepository<Usuarios, Long> {
    fun findUserById(id: Long?) : Usuarios
}