package usuarios.usuarios

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioService{
    @Autowired
    lateinit var usuariosRepository: UsuariosRepository

    fun addUser(userDTO: UsuariosDTO ): Usuarios{
        val user = mapDTOToUser(usuariosDTO = userDTO)
        usuariosRepository.save(user)
        return user
    }

    fun findUser() : List<Usuarios>{
        return usuariosRepository.findAll()
    }

    fun editUser(id: Long, newUser: UsuariosDTO): Usuarios {
        val user = usuariosRepository.findUserById(id)

        if (newUser.name!!.isNotBlank() && newUser.name != user!!.name){
            user.name = newUser.name
        }
        if (newUser.age != null && newUser.age != user!!.age){
            user.age = newUser.age
        }

        usuariosRepository.save(user)

        return user
    }

    fun delele(id: Long){
        usuariosRepository.deleteById(id)
        return
    }
}