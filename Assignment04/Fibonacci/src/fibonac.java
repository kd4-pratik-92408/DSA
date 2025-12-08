
public class fibonac {

	public static int fibonac(int n)
	{
		if(n<=1)
		{
			return n;
		}
		return fibonac(n-1)+fibonac(n-2);
	}
	
	public static void main(String[] args) 
	{
		int re=fibonac(9);
		System.out.println("res : "+re);
		
	}

}
