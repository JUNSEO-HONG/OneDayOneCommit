package VersionTest;


interface Lambda1Inter{
	//基本のメソッド宣言方法
	int plus(int a, int b);
}

public class Lambda1 {

	public static void main(String[] args) {
		
		//基本のメソッド具現
		Lambda1Inter lb1 = new Lambda1Inter() {
			@Override
			public int plus(int a, int b) {
				return a+b;
			}
		};
		
		System.out.println(lb1.plus(10, 5));
		
		//Lambdaを利用して具現
		Lambda1Inter lb2 = (x, y) ->  x + y;
	
		System.out.println(lb2.plus(15,5));
		
		//Lambdaの表現式はinterfaceにメソッドが1つしかない場合のみ可能
		//それでplusのメソッド名が省略可能
		//引数のタープが省略できることもリターンのこともパソコンは全部わかるので省略可能。。。
		//というより元々interfaceを具現する規則がOverrideなので省略してもわかる。
		
		// それで System.out.println(lb2.plus("日本語","勉強するほど難しい！！！"));
		// これはエラーになる。

	}

}
