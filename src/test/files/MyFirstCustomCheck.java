package com.finger.alirules.checks;


public class UnderlineDollarRuleMapper {
	private int num,num_two;
	public void mysum(int x,int y){
		num = x;
		num_two = y;
		system.out.println("sum is:" +(num+num_two));
	}
	
	public void mysum_abc(int x,int y){
		num = x;
		num_two = y;
		system.out.println("sum is:" +(num-num_two));
	}
	
	public static void main(String arg[]){
		test a = new test();
		a.mysum(1,2);
		a.mysum_two(2,1);
		String s = "abc";
	}
    

    public void abc(){}  // Noncompliant

}