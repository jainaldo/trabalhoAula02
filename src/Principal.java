import com.livraria.views.PanelInicial;
import com.livraria.views.TelaFrame;


public class Principal {
	public static void main(String[] args) {
		TelaFrame tela= new TelaFrame();
		PanelInicial inicial = new PanelInicial(tela);
		tela.setContentPane(inicial);
		tela.validate();
		tela.setVisible(true);
	}
}
