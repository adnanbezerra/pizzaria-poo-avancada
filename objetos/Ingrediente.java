package objetos;

public class Ingrediente {
	  private String nome;
	  private int vezesUsado;

	  public Ingrediente(String nome) {
	    this.nome = nome;
	    this.vezesUsado = 0;
	  }

	  public String getNome() {
	    return this.nome;
	  }

	  public void usarIngrediente() {
	    this.vezesUsado++;
	  }

	  public void cancelarUsoDoIngrediente() {
	    this.vezesUsado--;
	  }

	  @Override
	  public boolean equals(Object outroIngrediente) {
	    Ingrediente convertido = (Ingrediente) outroIngrediente;
	    return nome.equals(convertido.nome);
	  }

	  @Override
	  public String toString() {
	    return "Ingrediente: " + this.nome + ", vezes usado: " + this.vezesUsado;
	  }
	}
	  