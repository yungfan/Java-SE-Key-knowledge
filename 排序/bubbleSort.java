/**
冒泡排序可以算是最经典的排序算法了，记得小弟上学时最先接触的也就是这个
算法了，因为实现方法最简单，两层 for 循环，里层循环中判断相邻两个元素
是否逆序，是的话将两个元素交换，外层循环一次，就能将数组中剩下的元素中
最小的元素“浮”到最前面，所以称之为冒泡排序。
*/
public class bubbleSort 
	{  
	   public  bubbleSort()
	   {       
		   int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};      
		   int temp=0;      
		   for(int i=0;i<a.length-1;i++)
		   {          
			   for(int j=0;j<a.length-1-i;j++)
			   {          
				   if(a[j]>a[j+1])
				   {              
					   temp=a[j];              
					   a[j]=a[j+1];              
					   a[j+1]=temp;          
					}          
				}      
			}      
			for(int i=0;i<a.length;i++)      
			System.out.println(a[i]);    
		}  
	} 