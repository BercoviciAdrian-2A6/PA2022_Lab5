package exceptions;

public class InvalidCommandException extends Exception
{
    public InvalidCommandException(String commandLine)
    {
        System.out.println("'" + commandLine + "' was invalid");
    }

    public InvalidCommandException(int insufficientArguments)
    {
        System.out.println("Insufficient number of arguments: " + insufficientArguments);
    }
}
