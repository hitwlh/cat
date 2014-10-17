
public class index {
	private String bod;
	public String getBod() {
		return bod;
	}
	public void setBod(String bod) {
		this.bod = bod;
	}
	public String res(){
		if(bod!=null&&bod.equals("1"))
			return "1";
		else
			return "2";
	}
}
