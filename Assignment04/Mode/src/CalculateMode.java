import java.util.Arrays;

public class CalculateMode {
	
	public static int  mode(int arr[])
	{
		Arrays.sort(arr);
		int count=1;
		int num=arr[0];
		int max=0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i-1]==arr[i])
			{
				count++;
			}
			else
			{
				if(max<count)
				{
					max=count;
					num=arr[i-1];
					count=1;
				}
			}
		}
		if(max<count)
		{
			max=count;
			return arr[arr.length-1];
		}
		
		return num;
	}
	

	public static void main(String[] args) {
		
		int arr[]= {10,30,30,20,30,20};
		int num=mode(arr);
		System.out.println(num+" is maximum occured data in the array");

	}

}
