/**
 * 请求者角色  junit中我们扮演的角色
 * @author 杨帆
 *
 */
public class Invoker
{
	private Command command;
	
	public Invoker(Command command)
	{
		this.command = command;
	}
	
	public void doInvokerAction()
	{
		command.execute();
	}
}
