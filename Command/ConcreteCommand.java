/**
 * 具体命令角色   在junit框架里面就是我们写的testCase
 * @author 杨帆
 *
 */
public class ConcreteCommand implements Command
{
	private Receiver receiver;
	
	public ConcreteCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}
	
	@Override
	public void execute()
	{
		receiver.doAction();
	}
}
