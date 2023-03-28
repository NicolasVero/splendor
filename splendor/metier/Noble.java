package splendor.metier;

public class Noble
{
	private String cout;
	private String url;
	private int points;

	public Noble(String cout, String url)
	{
		this.cout = cout;
		this.url = url;
		this.points = 3;
	}

	public String getCout() { return this.cout; }
	public String getUrl() { return this.url; }
	public int getPoints() { return this.points; }
	
	public int getCout(int i) {
		return Integer.parseInt(Character.toString(this.cout.charAt(i)));
	}

	public String toString() { return this.cout + " " + this.url; }
}