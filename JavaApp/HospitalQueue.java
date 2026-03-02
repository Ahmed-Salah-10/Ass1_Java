package JavaApp.src;

public class HospitalQueue{

	static final int MAX_QUEUE = 5;
    String[] name = new String[MAX_QUEUE];
	boolean[] stat = new boolean[MAX_QUEUE];
	int len;
	int spec;

	HospitalQueue(int spec_) 
	{
		len = 0;
		spec = spec_;
	}

	void shift_left()
	{
		for(int i = 0; i < len-1; i++)
		{
			name[i] = name[i+1];
			stat[i] = stat[i+1];
		}
	}

	void shift_right()
	{
		for(int i = len; i > 0; i--)
		{
			name[i] = name[i-1];
			stat[i] = stat[i-1];
		}
	}

	void add(String name, int stat)
	{
		if(len >= MAX_QUEUE)
		{
			System.out.println("\nSorry we can't add more patients for this specialization\n");
			return;
		}

		if(stat != 0 && stat != 1)
		{
			System.out.println("Invalid Stat");
			return;
		}

		if(stat == 0)
		{
			this.name[len] = name;
			this.stat[len] = false;
			len++;
		}

		if(stat == 1)
		{
			shift_right();
			this.name[0] = name;
			this.stat[0] = true;
			len++;
		}

	}

	void print()
	{
		if(len > 0)
		{
			System.out.println("There are " + len + " patients in specialization " + spec);
			for(int i = 0; i < len; i++)
			{
				System.out.print(name[i] + " ");
				if(stat[i] == false) System.out.println("regular");
				else System.out.println("urgent");
			}
			System.out.println();
		}
		
	}

	void get_patient()
	{
		if(len == 0)
		{
			System.out.println("No patients at the moment. Have rest, Dr");
		}

		else
		{
			System.out.println("\n" + name[0] + " Please go with Dr\n");
			shift_left();
			len--;
		}
	}
}