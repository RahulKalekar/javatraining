package day9;
//private method inside an interface
//interface Foof{
//}
/*
 interface Java8DBLogging
{
    default void logInfo(String message)
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log Info Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

    default void logWarn(String message)
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log warn Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

    default void logError(String message)
    {
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log error Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

}

 */
interface MyLogging{
     default void logInfo(String message){
         log(message,"INFO");
     }
     default void logWarn(String message){
         log(message,"WARN");
     }
     default void logError(String message){
         log(message,"ERROR");
     }
     private void log(String message,String level) {
         System.out.println("Step1: COnnection to DB");
         System.out.println("Step 2: Log the message to level" + level);
         System.out.println("Step 3 closr the connection");
     }

}
class MyLoggingImp implements MyLogging{

}
public class A_PrivateMethodInsideInterface {
    public static void main(String[] args) {
        MyLogging myLogging=new MyLoggingImp();
        myLogging.logWarn("some jdbc code");
    }
}
















