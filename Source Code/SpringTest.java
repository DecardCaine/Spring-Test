import java.util.Scanner;
import java.math.*;
public class SpringTest {
	public static void main(String[] args) 
	{
		Scanner scan= new Scanner(System.in);
		double a;//initial length of the spring from the equilibrium point
		double x;//Length of the spring over time
		double y=0;//the previous length of x
		double t=0;//time elapsed
		double s;//time lapse
		double m;//mass of the object that attached to the spring 
		double w0;//undamped oscillation frequency
		double w1;//fixed angular frequency
		double V;//the damping constant
		double K;//the spring constant(stiffness);
		//NOTE:The length of the spring can be displayed as negative number because the initial length of the spring (the equilibrium point) supposed as 0 meter
		System.out.println("Please enter the initial distance of the spring from it's equilibrium point(meter)");
		a=scan.nextDouble();
		System.out.println("Please enter the time lapse (seconds)");
		s=scan.nextDouble();
		System.out.println("Please enter the mass of the object(kilogram)");
		m=scan.nextDouble();
		System.out.println("Please enter the stiffness of the spring (Newton/Kilogram)");
		K=scan.nextDouble();
		System.out.println("Please enter the damping constant as angular frequency (rad/second)");
		V=scan.nextDouble();
		if(s<=0||m<=0||K<=0||V<=0) 
		{
			System.out.println("Error! Do not enter any negative value or zero for these variables:time interval,mass,stiffness,damping constant");
			return;
		}
		w0=Math.sqrt(K/m);
		if(2*w0<=V) 
		{
			System.out.println("Error! Negative number inside of root at line 34 :2*stiffness*stifness/mass*mass should bigger than the damping constant ");
			return;
		}
		w1=Math.sqrt(w0*w0-V*V/4);
		//Math.sqrt means : square root(variable)
		while(true)
		{
			x=a*Math.exp(-V*t/2)*Math.cos(w1*t);//calculates the spring length over time 
			//Math.exp means : e^(variable)
			if(0.000001>Math.abs(x)&& t>0)
			{
				if(Math.abs(y-x)<0.000001) 
				{
					break;
				}
			}	
			y=x;
			System.out.print("Time(second): ");
			System.out.format("%.6f",t );
			System.out.print(" | Lenght(meter) : ");
			System.out.format("%.6f",x );
			System.out.println("");
			t+=s;
		}
	}
}
