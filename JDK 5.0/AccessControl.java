/**
* ö��ʵ��Ȩ����֤
*/
public class AccessControl
{
	public static boolean checkRight(AccessRight accessRight)
	{
		if(accessRight == AccessRight.MANAGER)
		{
			return true;
		}

		else if(accessRight == AccessRight.DEPARTMENT)
		{
			return false;
		}

		return false;
	}
	
	public static void main(String[] args)
	{
                //valueOf���Խ��ַ���ת���ɶ�Ӧ��ö������
		AccessRight accessRight = AccessRight.valueOf("MANAGER");
		
		System.out.println(checkRight(accessRight));
	}
}
