package oblici;

public abstract class Oblik implements Comparable{
	
	private String boja;
	
	public Oblik() {
		
	}
	
	public String getBoja() {
		return this.boja;
	}
	
	public void setBoja(String boja) {
		this.boja = boja;
	}
	
}
