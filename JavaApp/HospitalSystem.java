package JavaApp.src;
import java.util.Scanner;

public class HospitalSystem {
	Scanner input = new Scanner(System.in);

	static final int MAX_SPECIALIZATION = 20;
	HospitalQueue[] quires = new HospitalQueue[MAX_SPECIALIZATION+1];

	HospitalSystem()
	{
		for(int i = 0; i <= MAX_SPECIALIZATION; i++)
		{
			quires[i] = new HospitalQueue(i);
		}
	}

	void add_patient()
	{
		String name;
		int spec, stat;
		System.out.println("Enter specialization, name, stats:");
		spec = input.nextInt();
		name = input.next();
		stat = input.nextInt();
		if(spec > 0 && spec <= MAX_SPECIALIZATION)
		{
			quires[spec].add(name, stat);
		}
		else
		{
			System.out.println("Invaild specialization");
		}
	}

	void print_patirnts()
	{
		for(int i = 1; i <= MAX_SPECIALIZATION; i++)
		{
			quires[i].print();
		}
	}

	void get_next_patient()
	{
		int spec;
		System.out.print("Enter specialization: ");
		spec = input.nextInt();
		quires[spec].get_patient();
	}

	int menu()
	{
		int n;
		while(true)
		{
			System.out.println("Enter your choice:");
			System.out.println("1) Add new patient");
			System.out.println("2) Print all patients");
			System.out.println("3) Get next patient");
			System.out.println("4) Exit");

			n = input.nextInt();
			if(!(n >= 1 && n <= 4))
			{
				System.out.println("Invalid choice. Try again");
				continue;
			}
			return n;
		}
	}
	
	void hospital()
	{
		while(true)
		{
			int n = menu();
			if(n == 1) add_patient();
			if(n == 2) print_patirnts();
			if(n == 3) get_next_patient();
			if(n == 4) break;
		}
	}
	
}
