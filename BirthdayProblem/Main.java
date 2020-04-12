public class Main{
  public static void main(String[] args){
    PF a = new PF(357876792);
    System.out.println(a.toDouble());
    
    PF num1 = new PF(125);
    PF num2 = new PF(25);
    PF num3 = num1.multiply(num2);
    System.out.println("Multiplication Testing: "+num1.toDouble()+"*"+num2.toDouble()+" = "+num3.toDouble());
    
    PF num4 = num3.divide(num2);
    System.out.println("Division Testing: "+num3.toDouble()+"/"+num2.toDouble()+" = "+num4.toDouble());
    
    PF exp = new PF(100);
    PF expOutput = exp.exp(3);
    System.out.println("Exponents Testing: "+exp.toDouble()+" to the 3rd "+"= "+ expOutput.toDouble());
    
    System.out.println();
    System.out.println("Birthday Problem:");
    //365!/365^n*(365-n)  formula from (https://en.wikipedia.org/wiki/Birthday_problem)
    int n = 100;
    PF fact = new PF(1);
    PF people = new PF(365);
    for(int index = 1;index<= people.toDouble();index++){
      PF temp1 = new PF(index);
      fact = fact.multiply(temp1);} //365!
    System.out.println("Factorial of "+people.toDouble()+" is: "+fact.toDouble());  
    
    PF threeSixFive = new PF(365); //365
    PF nSquare = threeSixFive.exp(n); //365^n
    
    PF fact2 = new PF(1);
    PF rest = new PF(365-n);
    for(int index2 = 1;index2<= rest.toDouble();index2++){
      PF temp2 = new PF(index2);
      fact2 = fact2.multiply(temp2);} //(365-n)!
    
    PF denominator = nSquare.multiply(fact2); //365^n*(365-n)!
    
    PF probability = fact.divide(denominator);
    System.out.println("The probability of "+n+" having same birthday is "+ probability.toDouble());  
    
  }}