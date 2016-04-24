import java.io.*;
import java.net.*;
class Node
{
  public static void main(String[] args) throws Exception
  {
     Socket sock = new Socket("127.0.0.1", 3004);
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
     OutputStream outputstream = sock.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(outputstream, true);
     InputStream inputstream = sock.getInputStream();
     BufferedReader getfromserver = new BufferedReader(new InputStreamReader(inputstream));
 
     System.out.println("Starting Node");
 
     String input=keyRead.readLine(),output="",str="";               
pwrite.println(input);        
str = getfromserver.readLine();
        System.out.println(str);
              
      if(str.contains("authintication")){
 while(true)
     {                    
        input=keyRead.readLine();
        pwrite.println(input);
    
        pwrite.flush();  
      }






}             
    }                    
}  
