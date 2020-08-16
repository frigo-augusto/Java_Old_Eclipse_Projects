package testes;
import javax.swing.JOptionPane;

public class Carro {
	
	//atributos
	public String marca;
	public int ano;
	public int marcha;
	public boolean on;
	public int velocidade = 0;
	
	public void acelerar(int velocidade)
	{
		this.velocidade += velocidade;
		JOptionPane.showMessageDialog(null, "a velocidade e" + this.velocidade);
	}
	
	
}
