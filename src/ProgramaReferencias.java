
public class ProgramaReferencias {
	
	public static void main(String[] args) throws SaldoInsuficienteException, DadosIncorretosClienteException {
		ContaCorrente c1 = new ContaCorrente();
		//System.out.println("Imprimindo c1: "+c1);
		c1.cliente.setNome("Thaise");
		
		ContaCorrente c2 = new ContaCorrente();
		//System.out.println("Imprimindo c2: "+c2);
		c2.cliente.setNome("Jonas");
		
		System.out.println("Saldo do cliente c1: "+c1.getSaldo());
		System.out.println("Saldo do cliente c2: "+c2.getSaldo());
		
		c1.sacar(200);
		
		System.out.println("Saldo do cliente c1: "+c1.getSaldo());
		System.out.println("Saldo do cliente c2: "+c2.getSaldo());
		
		
		
		//__________________________________________________________________________________________
		
		
		
		ContaCorrente c3 = c1;
		//System.out.println("Imprimindo c3: "+c3);
		
		/*//no if = compara se as referências estão apontado para a mesma instância, 
		 * se esses objetos(valores na memória) são iguais, não os valores 
		 * atribuidos a eles, esses serão comparados por equals.
		 */
		if(c1 == c3){
			//System.out.println("c1 é a mesma intância que c3");
		}else{
			//System.out.println("c1 e c3 são instâncias difentes");
		}
		/*//no if = compara se os valores de referências que estão apontado para instâncias
		 * diferentes, mas têm o mesmo valor,por isso utilizamos equals para comparar.
		 */
		if(c1.cliente.getNome().equals(c2.cliente.getNome())){
			//System.out.println("c1 tem o mesmo valor que c2");
		}else{
			//System.out.println("c1 NÃO tem o mesmo valor de c2");
		}
		
		
			
	}
}
