package model;

import java.time.LocalDate;

public class UsuarioDAO {

	Usuario[] usuarios = new Usuario[50];
	int contador;

	public UsuarioDAO() {

		Usuario u1 = new Usuario(1, "Denerson", "AV DEZ", "10543213617", "34984137603", "ddenerson", "1234",
				LocalDate.now(), LocalDate.now());
		Usuario u2 = new Usuario(2, "Alexssandra", "AV DEZ", "1054321385", "34984137602", "leleca", "5678",
				LocalDate.now(), LocalDate.now());
		Usuario u3 = new Usuario(3, "Alexssandra", "AV DEZ", "1054321385", "34984137602", "teste", "910",
				LocalDate.now(), LocalDate.now());
		this.insereUsuario(u1);
		this.insereUsuario(u2);
		this.insereUsuario(u3);

	}

	// Encontra uma posi��o est� vazia

	public int verificaPosicao() {

		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				return i;
			}
			contador++;
		}

		return -1;
	}

	// Insere um novo Produto.Se existe um espa�o vazio entre 2 produtos,
	// Ent�o o novo produto ser� criado nessa posi��o
	public boolean insereUsuario(Usuario novoUsuario) {

		int posicao = verificaPosicao();
		if (posicao == -1) {
			return false;
		}
		novoUsuario.setId(posicao + 1);
		this.usuarios[posicao] = novoUsuario;
		return true;

	}

	// Encontra a posi��o do produto
	public int encontrarUsuario(Usuario usuarioASerExcluido) {
		for (int i = 0; usuarios.length > i; i++) {
			if (usuarios[i] != null && usuarios[i].equals(usuarioASerExcluido)) {
				return i;
			}
		}
		return -1;
	}

	// Recebe um produto como par�metro e "exclui" - null

	public boolean deletaUsuario(Usuario usuarioASerExcluido) {
		int posicaoUsuario = encontrarUsuario(usuarioASerExcluido);

		if (posicaoUsuario == -1) {
			return false;
		}

		usuarios[posicaoUsuario] = null;
		return true;
	}

	public String listarUsario(Usuario c) {
		if (encontrarUsuario(c) != -1) {
			return usuarios[encontrarUsuario(c)].toString();
		}
		return "N�o encontrado.";
	}

	// Funcional

	public String listarTodosUsuarios() {

		String listaUsuarios = "-- Usuarios -- " + "\n";

		for (int i = 0; usuarios.length > i; i++) {
			if (usuarios[i] != null) {
				listaUsuarios += usuarios[i].toString();
			}
		}
		if (listaUsuarios.contentEquals("-- Usuarios -- " + "\n")) {
			listaUsuarios = "Nenhum produto usuarios.";
		}

		return listaUsuarios;
	}

	// Busca usu�rio
	public Usuario buscaUsuario(int id) {
		Usuario usuario = new Usuario(id);
		int pos = encontrarUsuario(usuario);

		if (pos != -1) {
			return this.usuarios[pos];
		}

		return null;
	}

	// Recebe um objeto do tipo Usuario contendo o id e as informa��es que ser�o
	// atualizadas
	public boolean atualizaUsuario(Usuario u) {

		// � realizada a busca pelo ususario que ser� atualizado
		Usuario usuario = buscaUsuario(u.getId());
		// � verificado quais informa��es foram preenchidas para atualizar
		if (u.getNome() != null) {
			usuario.setNome(u.getNome());
		}
		if (u.getEndereco() != null) {
			usuario.setEndereco(u.getEndereco());
		}
		if (u.getCpf() != null) {
			usuario.setCpf(u.getCpf());
		}
		if (u.getTelefone() != null) {
			usuario.setTelefone(u.getTelefone());
		}
		if (u.getLogin() != null) {
			usuario.setLogin(u.getLogin());
		}
		if (u.getSenha() != null) {
			usuario.setSenha(u.getSenha());
		}
		// atualiza a data de modifica��o para o momento em que � atualizada
		usuario.setDataModificacao(LocalDate.now());

		return true;
	}
	
	public boolean encontraLogin(String login, String senha) {
		
		boolean result = false;
		
		for (int i = 0; this.usuarios.length > i; i++) {
			if (usuarios[i] != null && usuarios[i].getLogin().equals(login)) {
				result = usuarios[i].getSenha().equals(senha) ? true : false;
			}
		}
		
		return result;
	}

}
