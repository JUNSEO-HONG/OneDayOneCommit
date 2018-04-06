package Study;

import java.util.ArrayList;
import java.util.List;

interface Camera{
	void picture();
	
	void movie();
}

interface Android{

}

interface Ios{
	
}

class Phone{
	String color;
	String os;
	int version;
	int width;
	int height;
	int volume;
	
	Phone(){}
	
	Phone(String color, int version, int volume){
		this.color = color;
		this.version = version;
		this.volume = volume;
	}
	
	void upVolume(int v) {
		volume += v;
	}
	
	void downVolume(int v) {
		volume -= v;
	}
	
	<T> void versionDown(T x, int v) {
		if(x instanceof Android) {
			version -= v;
		}else {
			System.out.println("顧客様 IPONEは保安のため現在ダウングレードはできません。");
		}
	}
	
	void objectVersionDown(Object x, int v) {
		if(x instanceof Android) {
			version -= v;
		}
	}
}

class Galaxy extends Phone implements Camera, Android{
	
	public Galaxy() {
		
	}
	
	Galaxy(String color, int version, int volume){
		super(color, version, volume);
	}



	@Override
	public void picture() {
		System.out.println("galaxyは撮影もできます。");
		
	}

	@Override
	public void movie() {
		System.out.println("galaxyは映画も見ます。");
		
	}

	@Override
	public String toString() {
		return "galaxyです! 色は : " + color + " OSは 最新で : ver." + version + " / 現在 ボリュームは! : " + volume +" です";
	}
	
	public void point() {
		picture();
		movie();
	}
	
}

class GalaxyNote extends Phone implements Android{
	public GalaxyNote(String string, int i, int j) {
		super(string, i, j);
	}
	void draw(){
		System.out.println("ノートでは絵も描けます。");
	}
	@Override
	public String toString() {
		return "ノートです。色は : " + color + " OSは 最新で : ver." + version + " / 現在 ボリュームは! : " + volume +" です";
	}
	
	public void point() {
		draw();
	}

}

class Iphone extends Phone implements Camera, Ios{

	public Iphone(String string, int i, int j) {
		super(string, i, j);
	}

	@Override
	public void picture() {
		System.out.println("IPHONEは撮影もできます。");
		
	}

	@Override
	public void movie() {
		System.out.println("IPHONEは映画も見ます。");
		
	}
	@Override
	public String toString() {
		return "IPHONEです！高いよ！！。色は : " + color + " OSは 最新で : ver." + version + " / 現在 ボリュームは! : " + volume +" です";
	}
	
}


public class InterfaceTest {
	
	static List<Phone> p = new ArrayList();
	
	public static void main(String[] args) {

		Galaxy galaxy = new Galaxy("BLACK", 6, 5);
		GalaxyNote galaxyNote = new GalaxyNote("WHITE", 5, 9);
		Iphone iphone = new Iphone("BLACK", 3, 40);
		
		
		p.add(galaxy);
		p.add(galaxyNote);
		p.add(iphone);
		
		System.out.println("携帯見せてください");
		message();
		
		
		System.out.println("\nボリュームの調整はできますか？");
		galaxy.upVolume(5);
		galaxyNote.upVolume(3);
		iphone.downVolume(15);
		message();
		
		System.out.println("\nVERSIONが高いのは不安ですがダウングレードができますか？?");
		galaxy.versionDown(galaxy, 1);
		galaxyNote.objectVersionDown(galaxyNote, 1);
		iphone.versionDown(iphone, 1);
		message();
		
		System.out.println("\nそれなら galaxyとノートにはどの機能がありますか？");
		galaxy.point();
		galaxyNote.point();
	}
	
	public static void message() {
	
		for(int i=0; i<p.size(); i++){
			System.out.println(p.get(i));
		}
	}

}
