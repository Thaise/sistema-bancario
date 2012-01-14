public class Cliente {

	private String nome;
	private String endereco;
	private String telefone;
	private String cpf;
	
	public void setNome(String nome) throws DadosIncorretosClienteException{
		if(nome.equals("") || nome == null){
			throw new DadosIncorretosClienteException("O nome n�o pode ser vazio!");
		}else{
			this.nome = nome;
		}		
	}

	public String getNome() {
		return nome;
	}
	
	public void setEndereco(String endereco) throws DadosIncorretosClienteException{
		if(endereco.equals("") || endereco == null){
			throw new DadosIncorretosClienteException("O endere�o n�o pode ser vazio!");
		}else{
			this.endereco = endereco;
		}		
	}

	public String getEndereco(){
		return endereco;
	}
	
	public void setTelefone(String telefone) throws DadosIncorretosClienteException{
		if(telefone.equals("") || telefone.length() > 10 || telefone.length() < 10){
			throw new DadosIncorretosClienteException("O telefone deve conter 10 digitos e n�o pode ser vazio!");
		}else{
			this.telefone = telefone;	
		}
	}

	public String getTelefone() {
		return telefone;
	}
	
	public void setCpf(String cpf) throws DadosIncorretosClienteException{
		if(cpf == null || cpf == "" || cpf.length() > 11 || cpf.toString().length() < 10){
			throw new DadosIncorretosClienteException("O CPF deve conter 11 digitos e n�o pode ser vazio!");
		}else{
			this.cpf = cpf;	
		}
	}

	public String getCpf() {
		return cpf;
	}
	
}
