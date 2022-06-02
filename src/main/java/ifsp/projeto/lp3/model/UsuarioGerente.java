package ifsp.projeto.lp3.model;
public class UsuarioGerente extends Usuario implements UsuarioInterface {

   private String cnpj;

public UsuarioGerente(String nome, String login, String senha, String telefone, String cnpj) {
    super(nome, login, senha, telefone);
    this.cnpj = cnpj;
}

public UsuarioGerente(String nome, String login, String senha, String cnpj) {
    super(nome, login, senha);
    this.cnpj = cnpj;
}

public UsuarioGerente( String login, String senha) {
    super( login, senha);
    this.login = login;
    this.senha = senha;    
}

public String getCnpj() {
    return cnpj;
}

public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
}

@Override
public void cadastarUsuario(UsuarioInterface usuario) {
    // TODO Auto-generated method stub
    
}

@Override
public boolean Login(UsuarioInterface usuario) {
    // TODO Auto-generated method stub
    return false;
}


    
}