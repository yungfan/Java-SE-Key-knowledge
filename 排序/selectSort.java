/**
ѡ������Ļ���˼���Ǳ�������Ĺ����У��� i ����ǰ��Ҫ�������ţ�
����Ҫ��ʣ��� [i��n-1] ���ҳ����е���Сֵ��Ȼ���ҵ�����Сֵ�� i 
ָ���ֵ���н�������Ϊÿһ��ȷ��Ԫ�صĹ����ж�����һ��ѡ����ֵ��
�����̣�������������س�֮Ϊѡ������
*/
public class selectSort 
{      public selectSort()
     {          
		 int a[]={1,54,6,3,78,34,12,45};          
		 int position=0;          
		 for(int i=0;i<a.length;i++)
		 {                            
			 int j=i+1;             
             position=i;  //positionָ�����С��ֵ��λ��            
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