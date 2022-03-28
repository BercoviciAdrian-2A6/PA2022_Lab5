package exceptions;

public class DuplicateCommandTriggerException extends Exception
{
    public DuplicateCommandTriggerException (String duplicateCommand)
    {
        System.out.println("'" + duplicateCommand + "'" + " triggers multiple commands!");
    }
}
