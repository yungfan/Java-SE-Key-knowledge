/**
* 枚举实现权限验证
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
                //valueOf可以将字符串转换成对应的枚举类型
		AccessRight accessRight = AccessRight.valueOf("MANAGER");
		
		System.out.println(checkRight(accessRight));
	}
}
