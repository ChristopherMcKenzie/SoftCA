/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;
import Daos.*;
import Dtos.*;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
                String forwardToJsp = "";
        
                String Entry1 = request.getParameter("userName");
                String Password = request.getParameter("password");
                String UserName = null;
                int id = 0;
                //ChrisTest
                if (Entry1 != null && Password != null && !Entry1.equals("") && !Password.equals(""))
                {
                    try
                    {
                        HttpSession session = request.getSession();
                        UserDao userDao = new UserDao("musicdatabase");
                        //this is so they can use there email as well as the username.
                        if(Entry1.contains("@")){
                          UserName = userDao.getUser(id).getUserName();
                        }
                        else if(!Entry1.contains("@")){
                          UserName = Entry1;
                        }
                        
                        
                        Users result = userDao.loggingUser(UserName, Password);

                            if(result != null)
                            {
                              session.setAttribute("CurrentUser", result);
                              forwardToJsp = "index.jsp";     
                            }
                            else if(result == null)
                            {
                                
                                String msg = "Login";
                                session.setAttribute("Type", msg);
                                session.setAttribute("AccountFail", UserName);  
                                forwardToJsp = "AccountFail.jsp";
                            }
                       
                    }catch (InputMismatchException e)
                    {
                        
                        forwardToJsp = "error.jsp";
                        
                        HttpSession session = request.getSession();
                        
                        session.setAttribute("errorMessage", "Text was supplied for parameters is not he right type.");
                    }
  
                }else
                {
                    
                    forwardToJsp = "error.jsp";
                    
                    HttpSession session = request.getSession();

                    
                    session.setAttribute("errorMessage", "A parameter value required for login was missing");
                }
                
                return forwardToJsp;
    } 
}

