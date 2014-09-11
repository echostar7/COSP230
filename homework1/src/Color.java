
public class Color {

	private String name;
	private int red;
	private int blue;
	private int green;
	
	public Color(String name, int red,int blue,int green){
		this.name = name;
		this.red = red;
		this.blue = blue;
		this.green = green;
	}
	public void setName(String name){
		this.name = name;	
	}
	public void setRed(int red){
		this.red = red;
	}
	public void setBlue(int blue){
		this.blue = blue;
	}
	public void setGreen(int green){
		this.green = green;
	}
	public String getName() {
		return name;
	}
	public int getRed(){
		return red;
	}
	public int getGreen(){
		return green;
	}
	public int getBlue(){
		return blue;
	} 
	public static void main(String[] args) {
		
		 
		Color c1 = new Color("\norange",255,50,0);
		System.out.println("\ncolor: "+c1.getName()); //should be orange
		System.out.println("red value: "+c1.getRed()); //should be 255
		System.out.println("Green value: "+c1.getGreen()); //should be 50
		System.out.println("Blue value: "+c1.getBlue()); // should be 0
		c1.setName("white");
		c1.setRed(255);
		c1.setGreen(255);
		c1.setBlue(255);
		
		System.out.println("\ncolor: "+c1.getName()); //should be white
		System.out.println("red value: "+c1.getRed()); //should be 255
		System.out.println("Green value: "+c1.getGreen()); //should be 255
		System.out.println("Blue value: "+c1.getBlue()); // should be 255
	}

}
