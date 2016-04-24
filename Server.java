import java.io.*;
import java.net.*;
import java.util.*;
class BasicServer
{
  public static void main(String[] args) throws Exception
  {

	ServerSocket sersock = new ServerSocket(3004);
	System.out.println("Server for computation");
	boolean bool=true;int id=0;
	ArrayList<helper> activeNode=new ArrayList<>();
	loop:while(bool){ 
	Socket sock = sersock.accept();                                         
	helper helpr ;	
      	  BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
      	  OutputStream outputstream = sock.getOutputStream(); 
      	  PrintWriter pwrite = new PrintWriter(outputstream, true);
      	  InputStream inputstream = sock.getInputStream();
      	  BufferedReader getbackoutput = new BufferedReader(new InputStreamReader(inputstream));
          String input,output;int xx=5;
    
    
	output=getbackoutput.readLine();
	if(output.equals("ashish")){
	id++;
	helpr = new helper(sock,id);
        helpr.start();
	activeNode.add(helpr);
	pwrite.println("authintication done"+helpr.id);
	}else{
	pwrite.println("authintication failed"+id);
	}
        
System.out.println(output);
	if(output.equals("exit")){
	break loop;
	}
	}
	Iterator<helper> itr=activeNode.iterator();
	while(itr.hasNext()){
	helper h=itr.next();
	if(h.status)
	System.out.println(h.id);	

}


try{
sersock.close();
//sock.close();
}catch(Exception e){
}               
}                    

} 

class helper extends Thread{

 Socket socket = null;
int id;
boolean status;
 helper(Socket socket,int id) {

        super("helper"+id);
        this.socket = socket;
	this.id=id;
	status=true;
    }

    public void run(){
try{            //input and process
	InputStream inputstream = socket.getInputStream();
      BufferedReader getbackoutput = new BufferedReader(new InputStreamReader(inputstream));

while(status)
      {
String output="";
        if((output=getbackoutput.readLine()) != null)  
        {
           System.out.println(id+"->>"+output);
		if(output.equals("exit")){
			System.out.println("helper node number "+id+"disconected");
					
		status=false;}         
           
        }         
      }


}
catch(Exception e){
System.out.println(e);

}
}    

}
  













