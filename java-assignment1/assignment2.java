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

Q3
class FetchData extends Thread{  
    public void run(){ 
    try{
        Thread.sleep(500);
    }
    catch(InterruptedException e){
        System.out.println(e);
        
    }  
        System.out.println("fetchData is running"); 
    }  
    public static void main(String args[]){  
    FetchData t1=new FetchData();  
    t1.start();  
     }  
    }
    
     class ProcessData implements Runnable{  
    public void run(){ 
    try{
        Thread.sleep(1000);
    }
    catch(InterruptedException e){
        System.out.println(e);
        
    }  
        System.out.println("processData is running"); 
    }  
    public static void main(String args[]){  
    ProcessData p1=new ProcessData();  
    Thread t1 =new Thread(p1);  
    t1.start();  
     }  
    }
    
    public class result {
        public static void main(String args[]){  
        FetchData f1 = new FetchData();
        ProcessData p1 = new ProcessData();
        Thread t2 =new Thread(p1); 
        t2.setPriority(Thread.MIN_PRIORITY);  
        f1.setPriority(Thread.MAX_PRIORITY);  
        f1.start();
        t2.start();
       
     }  
    }
class fetchData extends Thread{  
    public void run(){ 
        try{
            // long startTime = System.currentTimeMillis();
            Thread.sleep(500);
            long endTime = System.currentTimeMillis();
            System.out.println("fd "+(endTime - Main.startTime)+"ms");
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
            System.out.println("pd "+(endTime - Main.startTime)+"ms");
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