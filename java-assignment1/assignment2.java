//Q1
//Implement own abstract classs
abstract class Bike{  
    abstract void run();  
  }  
  class Honda4 extends Bike{  
  void run(){System.out.println("running safely");}  
  public static void main(String args[]){  
   Bike obj = new Honda4();  
   obj.run();  
  }  
  }  
  //Implement own interface 
  interface Drawable{  
    void draw();  
    }   
    class Rectangle implements Drawable{  
    public void draw(){System.out.println("drawing rectangle");}  
    }  
    class Circle implements Drawable{  
    public void draw(){System.out.println("drawing circle");}  
    }    
    class TestInterface1{  
    public static void main(String args[]){  
    Drawable d=new Circle(); 
    d.draw();  
    }}  

//Q2
class EncapsulationDemo{
    private int ssn;
    private String empName;
    private int empAge;

    public int getEmpSSN(){
        return ssn;
    }

    public String getEmpName(){
        return empName;
    }

    public int getEmpAge(){
        return empAge;
    }

    public void setEmpAge(int newValue){
        empAge = newValue;
    }

    public void setEmpName(String newValue){
        empName = newValue;
    }

    public void setEmpSSN(int newValue){
        ssn = newValue;
    }
}
public class EncapsTest{
    public static void main(String args[]){
         EncapsulationDemo obj = new EncapsulationDemo();
         obj.setEmpName("Mario");
         obj.setEmpAge(32);
         obj.setEmpSSN(112233);
         System.out.println("Employee Name: " + obj.getEmpName());
         System.out.println("Employee SSN: " + obj.getEmpSSN());
         System.out.println("Employee Age: " + obj.getEmpAge());
    } 
}

//Q3
class fetchData extends Thread{  
    public void run(){ 
        try{
            // long startTime = System.currentTimeMillis();
            Thread.sleep(500);
            long endTime = System.currentTimeMillis();
            for(int i=0;i<5;i++){
            System.out.println("fd "+(endTime - Main.startTime)+"ms"+i);
            }
        }
        catch(InterruptedException e){
            System.out.println(e);
        }  
    System.out.println("fetchData executed\n"); 
    }  
}
    
class processData implements Runnable{  
    public void run(){ 
        try{
            // long startTime = System.currentTimeMillis();
            Thread.sleep(500);
            long endTime = System.currentTimeMillis();
            for(int i=0;i<5;i++){
                 System.out.println("pd "+(endTime - Main.startTime)+"ms"+i);
            }
        }
        catch(InterruptedException e){
            System.out.println(e);     
        }  
    System.out.println("processData executed\n"); 
    }  
}
    
public class Main {
    static long startTime = System.currentTimeMillis();
    
    public static void main(String args[]){  
        fetchData f1 = new fetchData();
        processData p1 = new processData();
        
        Thread t2 =new Thread(p1); 
        t2.setPriority(Thread.MIN_PRIORITY);  
        f1.setPriority(Thread.MAX_PRIORITY);  
        
        try {
            f1.start();
            f1.join();
            t2.start();
        } catch(InterruptedException e) {
             System.out.println(e);    
        }
    }  
}

//Q4

class MessageResource {
	private String message = "";

	public MessageResource() {
		if (message=="") {
			this.message = "Intial Synchronised Message";
		}
	}

	public synchronized String readResource() {
		return message;
	}

	public synchronized String writeResource(String newMessage) throws Exception {
		if (newMessage=="") {
			throw new Exception("Message cannot be empty");
		}
		this.message = newMessage;
		return this.message;
	}
}

class ReaderThread extends Thread{
    private MessageResource resource;

    ReaderThread(MessageResource resource){
        this.resource=resource;
    }

    @Override
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println(resource.readResource());
        }
    }
}

class WriterThread extends Thread{
    private MessageResource resource;
    private String message;

    WriterThread(MessageResource resource,String message){
        this.resource=resource;
        this.message=message;
    }

    @Override
    public void run(){
        try{
            for(int i=0;i<=5;i++){
                String dataWritten= this.resource.writeResource(this.message);
                System.out.println("Following message was written to resource = "+ dataWritten);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}


class main{
    public static void main(String[] args) throws Exception {
        MessageResource messageObject=new MessageResource();

        Thread ReaderThread= new ReaderThread(messageObject);
        Thread WriterThread= new WriterThread(messageObject,"Loading the sample data!!");

        //starting both of the threads.
        ReaderThread.start();
        WriterThread.start();

    }
}