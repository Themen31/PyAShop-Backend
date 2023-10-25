package com.pyashop.application;

import com.pyashop.domain.Producto;
import com.pyashop.domain.Usuario;
import com.pyashop.infrastracture.ProductoRepository;
import com.pyashop.infrastracture.UsuarioRepository;
import com.pyashop.domain.services.UsuarioService;
import com.pyashop.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private  final UsuarioService usuarioService;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Usuario>> registrarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioNew = usuarioService.crearUsuario(usuario);
        return new WrapperResponse<>(true,"success", usuarioNew).createResponse();
    }
    @PostMapping("/login")
    public ResponseEntity<WrapperResponse<Usuario>> logIn (@Valid @RequestBody Usuario user) throws Exception{
        String correoUsuario= user.getCorreoUsuario();
        String contrasenaUsuario= user.getContrasenaUsuario();
        Usuario userObj=null;
        if (correoUsuario !=null && contrasenaUsuario!= null){
            userObj=usuarioService.fetchUserByCorreoyContra(correoUsuario,contrasenaUsuario);
        }
        if(userObj==null){
            throw new Exception("Escriba correctamente sus datos.");
        }
        return new WrapperResponse<>(true,"success", userObj).createResponse();}

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Usuario>>> listarUsuario(){
        List<Usuario> usuarios = usuarioService.listarUsuario();
        return new WrapperResponse<>(true, "success", usuarios).createResponse();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<WrapperResponse<Usuario>> obtenerUsuarioPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        Usuario usuario = usuarioService.obtenerUsuarioPorIdUsuario(idUsuario);
        return new WrapperResponse<>(true,"success",usuario).createResponse();
    }
    @PutMapping("/{idUsuario}/milista/{idProduct}")
    public Usuario agregarProductoListaCompra(@PathVariable Integer idUsuario, @PathVariable Integer idProduct){
        Producto producto = productoRepository.findById(idProduct).get();
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        usuarioService.agregarProductoListaCompra(usuario,producto);
        return usuarioRepository.save(usuario);
    }

    @GetMapping("{idUsuario}/milista")
    public Set<Producto> obtenerListaCompraPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
        Usuario usuario = usuarioService.obtenerUsuarioPorIdUsuario(idUsuario);
        return usuario.getLista_compra();
    }
    @GetMapping("/{idUsuario}/carrito")
    public Set<Producto> obtenerCarritoPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        Usuario usuario = usuarioService.obtenerUsuarioPorIdUsuario(idUsuario);
        return usuario.getCarritoCompras();

    }
    @PutMapping("/{idUsuario}/carrito/{idProduct}")
    public Usuario agregarProductoAlCarrito(@PathVariable Integer idUsuario, @PathVariable Integer idProduct) {
        Producto productoN = productoRepository.findById(idProduct).get();
        Usuario usuarioN = usuarioRepository.findById(idUsuario).get();
        usuarioService.agregarProductoAlCarrito(usuarioN, productoN);
        return usuarioRepository.save(usuarioN);

    }
    @DeleteMapping("/{idUsuario}/carrito/{idProducto}")
    public Usuario eliminarProductoAlCarrito(@PathVariable Integer idUsuario, @PathVariable Integer idProducto) {
        Producto productoN = productoRepository.findById(idProducto).get();
        Usuario usuarioN = usuarioRepository.findById(idUsuario).get();
        usuarioService.eliminarProductoAlCarrito(usuarioN, productoN);
        return usuarioRepository.save(usuarioN);

    }
    @DeleteMapping("/{idUsuario}/milista/{idProducto}")
    public Usuario eliminarProductoListaCompra(@PathVariable Integer idUsuario, @PathVariable Integer idProducto) {
        Producto productoN = productoRepository.findById(idProducto).get();
        Usuario usuarioN = usuarioRepository.findById(idUsuario).get();
        usuarioService.eliminarProductoListaCompra(usuarioN, productoN);
        return usuarioRepository.save(usuarioN);

    }

}
