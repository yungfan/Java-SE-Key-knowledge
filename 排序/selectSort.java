/**
选择排序的基本思想是遍历数组的过程中，以 i 代表当前需要排序的序号，
则需要在剩余的 [i…n-1] 中找出其中的最小值，然后将找到的最小值与 i 
指向的值进行交换。因为每一趟确定元素的过程中都会有一个选择最值的
子流程，所以人们形象地称之为选择排序。
*/
public class selectSort 
{      public selectSort()
     {          
		 int a[]={1,54,6,3,78,34,12,45};          
		 int position=0;          
		 for(int i=0;i<a.length;i++)
		 {                            
			 int j=i+1;             
             position=i;  //position指向的最小的值的位置            
             int temp=a[i];             
             for(;j<a.length;j++)
             {              
	           if(a[j]<temp)
	           {                 
		          temp=a[j];           
		          position=j;             
		       }            
		      }              
		     a[position]=a[i];             
		     a[i]=temp;          
		}          
		for(int i=0;i<a.length;i++)             
		System.out.println(a[i]);     
	} 
}  