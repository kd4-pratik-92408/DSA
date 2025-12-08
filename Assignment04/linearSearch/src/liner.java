
public class liner {

	public static int findnum(int num,int oc,int arr[])
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==num)
			{
				count++;
				if(count==oc)
				{
					return 0;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int arr[]= {10,40,5,4,2,6,10,2,3,2,10};
		int res=findnum(10, 4, arr);
		if(res==0)
		{
			System.out.println("Element found !");
		}
		else
		{
			System.out.println("Occurance is not present .");
		}

	}

}
