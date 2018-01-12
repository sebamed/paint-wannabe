package oblici;

public abstract class PovrsinskiOblik extends Oblik{

	private String bojaUnutrasnjosti;
	
	public String getBojaUnutrasnjosti() {
		return this.bojaUnutrasnjosti;
	}
	
	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	public abstract double povrsina();
	public abstract double obim();
	
}
