package ifsp.projeto.lp3.model;

import ifsp.projeto.lp3.dao.UsuarioDAO;

public class Funcionario extends Usuario  {

private String cpf;

UsuarioDAO usuarioDAO = new UsuarioDAO();

public Funcionario(String login, String senha) {
    super(login, senha);
    
}

public Funcionario(String nome, String login, String senha, String cpf) {
    super(nome, login, senha);
    this.cpf = cpf;
}

public Funcionario(String nome, String login, String senha,  String telefone,String cpf) {
    super(nome, login, senha, telefone);
    this.cpf = cpf;
}

public String getCpf() {
    return cpf;
}

public void setCpf(String cpf) {
    this.cpf = cpf;
}

@Override
public boolean login(String login, String senha) {
    
    return usuarioDAO.logar(login, senha);    
}

@Override
public void cadastarUsuario(Usuario usuario) {
    usuarioDAO.inserir(usuario);    
}



 
}
