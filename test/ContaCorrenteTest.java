import static org.junit.Assert.*;

import org.junit.Test;

public class ContaCorrenteTest{

	@Test
	public void deveAtualizarSaldoAposSaque() throws SaldoInsuficienteException, ValorInvalidoException{
		ContaCorrente cc = new ContaCorrente();
		cc.depositar(1000);
		cc.sacar(200);
		assertEquals(900, cc.getSaldo(),0);
	}
	
	@Test
	public void deveAtualizarSaldoAposDepositar() throws SaldoInsuficienteException, ValorInvalidoException{
		ContaCorrente cc = new ContaCorrente();
		cc.depositar(200);
		assertEquals(300, cc.getSaldo(),0);
	}
	
	@Test (expected = SaldoInsuficienteException.class)
	public void naoDeveSacarValorMaiorQueLimite() throws SaldoInsuficienteException{
		ContaCorrente cc = new ContaCorrente();
		 cc.sacar(500);
	}
	
	@Test
	public void deveSacarMostrandoOSaldoAposSaque() throws SaldoInsuficienteException{
		ContaCorrente cc = new ContaCorrente();
		 cc.sacar(100);
		 assertEquals(0.0,cc.getSaldo(),0);
	}
	
	@Test
	public void deveAtualizarSaldoContaAtualEContaDestinoAposTransferir() throws SaldoInsuficienteException, ValorInvalidoException{
		ContaCorrente cc = new ContaCorrente();
		ContaCorrente dd = new ContaCorrente();
		cc.depositar(200);
		cc.tranferir(dd, 200);
		assertEquals(100,cc.getSaldo(),0);
		assertEquals(300,dd.getSaldo(),0);
	}	
	
}
