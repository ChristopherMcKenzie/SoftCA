
package Commands;

/**
 *
 * Author Ben , Chris
 */
public class CommandFactory {
   public Command createCommand(String action)
    {
       if("Play".equals(action)){
               return new PlayMusicCommand();
       }
       else if("upload".equals(action)){
               return new UploadCommand();
       }
       return null;
    }
}
