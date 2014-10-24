import java.io.*;
import java.net.*;
import java.lang.Runtime;
import java.lang.Object;
public class Server1
{ 
public static void main(String args[])throws IOException
{
ServerSocket ss=new ServerSocket(8081);
Socket s=ss.accept();
String cmd[]=new String[3];
cmd[0]="/bin/sh";
cmd[1]="-c";
BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
PrintWriter out=new PrintWriter(s.getOutputStream(),true);
cmd[2]=in.readLine();
Runtime r= Runtime.getRuntime();
Process p=null;
try
{   
p=r.exec(cmd);
System.out.println("Executing command : "+cmd);
BufferedReader inp=new BufferedReader(new InputStreamReader(s.getInputStream()));
BufferedReader inp1=new BufferedReader(new InputStreamReader(p.getInputStream()));
String line;
String k="";
while((line=inp1.readLine())!=null)
{

k=k+line+"\n";

} 
out.println(k);
int x=p.waitFor();
System.out.println("error"+x);
}
catch(Exception e)
{ 
System.out.println("Error"+e);
}

s.close();
} 
}

 
