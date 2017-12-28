/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.UserDao;
import Dtos.Users;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.NoSuchProviderException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RegisterCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

                String UserName = request.getParameter("userName");
                String Password = request.getParameter("password");
                String Email = request.getParameter("email");
                String FavGenre = request.getParameter("genre");
                

                if (UserName != null && Password != null && !UserName.equals("") && !Password.equals("") && !Email.equals(""))
                {
                    HttpSession session = request.getSession();
                    UserDao userDao = new UserDao("musicdatabase");
                    boolean Action = userDao.registerUser(UserName, Password, Email,FavGenre);
                    if(Action == true){
                        session.setAttribute("RegSuccess", UserName);
                        
                        forwardToJsp = "index.jsp";
                        
                    }
                    else if(Action == false)
                    {
                        String msg = " Registration failed ";
                        session.setAttribute("Type", msg);
                        session.setAttribute("RegSuccess", msg);
                        
                        
                        forwardToJsp = "index.jsp";
                    } 
                }else
                {
                    
                    forwardToJsp = "error.jsp";
                    
                    HttpSession session = request.getSession();

                    
                    session.setAttribute("errorMessage", "A parameter value required for Registration was missing");
                }
                
                
                return forwardToJsp;
    }                    
}

