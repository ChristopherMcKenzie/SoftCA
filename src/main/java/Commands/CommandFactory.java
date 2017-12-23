
package Commands;

/**
 *
 * Author Ben , Chris
 */
public class CommandFactory {
   public Command createCommand(String action)
    {
       if(null != action)switch (action) {
           case "Play":
               return new PlayMusicCommand();
           case "upload":
               return new UploadCommand();
           case "register":
               return new RegisterCommand();
           case "login":
               return new LoginCommand();
           default:
               break;
       }
    
       return null;
    }
}
