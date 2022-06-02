package ifsp.projeto.lp3.model;


public class UsuarioCaixa extends Usuario implements UsuarioInterface {

private String cpf;

public UsuarioCaixa(String login, String senha) {
    super(login, senha);
    
}

public UsuarioCaixa(String nome, String login, String senha, String cpf) {
    super(nome, login, senha);
    this.cpf = cpf;
}

public UsuarioCaixa(String nome, String login, String senha, String cpf, String telefone) {
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
public void cadastarUsuario(UsuarioInterface usuario) {
   
}

@Override
public boolean Login(UsuarioInterface usuario) {
    
    return false;
}
 
}
