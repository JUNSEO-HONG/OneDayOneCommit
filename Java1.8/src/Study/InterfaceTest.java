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
		}
	}
	
	void objectVersionDown(Object x, int v) {
		if(x instanceof Android) {
			version -= v;
		}else {
			System.out.println("고객님 아이폰은 보안 때문에 현재 다운 그레이드를 허용하지 않습니다.");
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
		System.out.println("갤럭시는 사진도 봐요.");
		
	}

	@Override
	public void movie() {
		System.out.println("갤럭시는 동영상도 봐요.");
		
	}

	@Override
	public String toString() {
		return "갤럭시입니다!. 색상은 : " + color + " OS는 최신으로 : ver." + version + " / 현재 볼륨은! : " + volume +" 이에요";
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
		System.out.println("Note로는 그림도 그릴 수 있어요.");
	}
	@Override
	public String toString() {
		return "전 노트입니다. 색상은 : " + color + " OS는 최신으로 : ver." + version + " / 현재 볼륨은! : " + volume +" 이에요";
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
		System.out.println("아이폰은 사진도 봐요.");
		
	}

	@Override
	public void movie() {
		System.out.println("아이폰은 동영상도 봐요.");
		
	}
	@Override
	public String toString() {
		return "아이폰 비싸죠~ 스팩 갑니다. 색상은 : " + color + " OS는 최신으로 : ver." + version + " / 현재 볼륨은! : " + volume +" 이에요";
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
		
		System.out.println("핸드폰 보여주세요.");
		message();
		
		
		System.out.println("\n볼륨조절 되나요?");
		galaxy.upVolume(5);
		galaxyNote.upVolume(3);
		iphone.downVolume(15);
		message();
		
		System.out.println("\n버전 높은건 불안하던데 다운 그레이드 되나요?");
		galaxy.versionDown(galaxy, 1);
		galaxyNote.objectVersionDown(galaxyNote, 1);
		iphone.versionDown(iphone, 1);
		message();
		
		System.out.println("\n음 그럼 갤럭시로 가야할거 같은데 기능은 어떤게 있나요?");
		galaxy.point();
		galaxyNote.point();
	}
	
	public static void message() {
	
		for(int i=0; i<p.size(); i++){
			System.out.println(p.get(i));
		}
	}

}
