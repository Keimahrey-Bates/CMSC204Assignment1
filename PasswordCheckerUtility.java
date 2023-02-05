import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * PasswordCheckerUtility Class
 * @author Keimahrey Bates
 *
 */
public class PasswordCheckerUtility
{
	/**
	 * Method is used to compare two passwords
	 * @param password and passwordConfirm string to check if they are equal to each other
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		if(password.equals(passwordConfirm) == false)
		{
			throw new UnmatchedException();
		}
		
		
	}
	/**
	 * Method is used to compare two passwords with a boolean return
	 * @param password and passwordConfirm string to check if they are equal to each other
	 * @return true if password and passwordConfirm are equal to each other, and false if they are not equal to each other
	 */
	public static boolean comparePasswordsWithReturn​(String password, String passwordConfirm)
	{
		if(password.equals(passwordConfirm) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Method is used to check if the password is a valid length
	 * @param password string to check if the password is long enough
	 * @return true if password has a higher length than 6 characters
	 * @throws LengthException
	 */
	public static boolean isValidLength​(String password) throws LengthException
	{
		if(password.length() < 6)
		{
			throw new LengthException();
		}
		else
		{
			return true;
		}
	}
	/**
	 * Method is used to check if the password has an uppercase character
	 * @param password string to check if the password has an uppercase character
	 * @return true if password has at least 1 uppercase character
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha​(String password) throws NoUpperAlphaException
	{
		for(int i = 0; i < password.length(); i++)
		{
			if(Character.isUpperCase(password.charAt(i)))
			{
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	/**
	 * Method is used to check if the password has a lowercase character
	 * @param password string to check if the password has a lowercase character
	 * @return true if password has at least 1 lowercase character
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		for(int i = 0; i < password.length(); i++)
		{
			if(Character.isLowerCase(password.charAt(i)))
			{
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	/**
	 * Method is used to check if the password has a digit
	 * @param password string to check if the password has a digit character
	 * @return true if password has at least 1 digit character
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException
	{
		for(int i = 0; i < password.length(); i++)
		{
			if(Character.isDigit(password.charAt(i)))
			{
				return true;
			}
		}
		throw new NoDigitException();
	}
	/**
	 * Method is used to check if the password has a special character
	 * @param password string to check if the password has a special character
	 * @return true if password has at least 1 special character
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException
	{
		for(int i = 0; i < password.length(); i++)
		{
			if (!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i)) && !Character.isWhitespace(password.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * Method is used to check if the password doesn't have more than two of the same character in a sequence
	 * @param password string to check if the password doesn't have more than two of the same character in a sequence
	 * @return true if password doesn't have more than two of the same character in a sequence
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence​(String password) throws InvalidSequenceException
	{
		for(int i = 0; i < password.length() - 2; i++)
		{
			if(password.charAt(i) == password.charAt(i+1))
			{
				if(password.charAt(i) == password.charAt(i + 2))
				{
				throw new InvalidSequenceException();
				}
			}
		}
		return true;
	}

	/**
	 * Method is used to check if the password is a valid password
	 * @param password string to check if the password is valid
	 * @return true if password passes all of the checks
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword​(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		return(isValidLength​(password) && hasUpperAlpha​(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar​(password) && NoSameCharInSequence​(password));
	
	}
	/**
	 * Method is used to check if the password has between 6 and 9 characters
	 * @param password string to check if the password has between 6 and 9 characters
	 * @return true if password is in between 6 and 9 characters in length and false if it is not between 6 and 9 characters
	 */
	public static boolean hasBetweenSixAndNineChars​(String password)
	{
		if(password.length() > 6 && password.length() < 9)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Method is used to check if the password is a weak password
	 * @param password string to check if the password is a weak password
	 * @return false if the password is not a weak password
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword​(String password) throws WeakPasswordException
	{
		
		if(hasBetweenSixAndNineChars​(password) == true)
		{
			throw new WeakPasswordException();
		}
		else
		{
			return false;
		}
		
	}
	/**
	 * Method is used to gather all the invalid passwords and put them into a single array list
	 * @param passwords array list string to see which passwords are invalid
	 * @return password array list string with all the invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> password = new ArrayList<String>();
		String invTest;
		for(int i = 0; i < passwords.size(); i++)
		{
			invTest = passwords.get(i);
			try {
				if(isValidPassword​(invTest))
				{
					
				}
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				password.add(invTest + " " +e.getMessage());
			}
		}
		return password;
		
	}
}