
public class LengthException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public LengthException()
	{
		super("The password must be at least 6 characters long");
	}
}
