
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
           case "Stop":
               return new StopMusicCommand();
           case "Upload":
               return new UploadCommand();
           case "register":
               return new RegisterCommand();
           case "login":
               return new LoginCommand();
           case "Logout":
               return new LogoutCommand();
           default:
               break;
       }
    
       return null;
    }
}
