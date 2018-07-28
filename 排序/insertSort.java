/**
插入排序的基本思想是在遍历数组的过程中，假设在序号 i 之前的元素
即 [0..i-1] 都已经排好序，本趟需要找到 i 对应的元素 x 的正确位置
k ，并且在寻找这个位置 k 的过程中逐个将比较过的元素往后移一位，
为元素 x “腾位置”，最后将 k 对应的元素值赋为 x ，插入排序也是根据
排序的特性来命名的。
*/
public class insertSort 
	{  public insertSort()
	   {      
		   int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};      
		   int temp=0;      
		   for(int i=1;i<a.length;i++)
			   {         
			     int j=i-1;         
			     temp=a[i];         
			     for(;j>=0&&temp<a[j];j--)
				   {         
				       a[j+1]=a[j];  //将大于temp的值整体后移一个单位         
				   }         
				 a[j+1]=temp; //插入到正确位置    
			   }      
		    for(int i=0;i<a.length;i++)        
		    System.out.println(a[i]);  
		}  
	} 