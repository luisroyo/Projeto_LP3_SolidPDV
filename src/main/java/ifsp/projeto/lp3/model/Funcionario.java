package ifsp.projeto.lp3.model;


public class Funcionario extends Usuario implements UsuarioInterface {

private String cpf;



public Funcionario(String login, String senha) {
    super(login, senha);
    
}

public Funcionario(String nome, String login, String senha, String cpf) {
    super(nome, login, senha);
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
    // TODO Auto-generated method stub
    
}

@Override
public boolean Login(UsuarioInterface usuario) {
    // TODO Auto-generated method stub
    return false;
}
 
}
