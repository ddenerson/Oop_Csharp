import model.ProdutoDAO;

public class Main {

	public Main()
	{
		ProdutoDAO produtoDAO = new ProdutoDAO();
		System.out.println(produtoDAO.listarTodosProdutos());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Main();
		
	}
	
	
	
	public void iniciar()
	{
		// ProdutoDAO produtoDAO = new ProdutoDAO()
	}
	
	

}


