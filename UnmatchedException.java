public class UnmatchedException extends Exception 
{

	private static final long serialVersionUID = 1L;

	public UnmatchedException()
	{
		super("Passwords do not match");
	}
}
