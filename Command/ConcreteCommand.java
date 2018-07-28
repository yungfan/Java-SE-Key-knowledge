/**
 * ���������ɫ   ��junit��������������д��testCase
 * @author �
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
