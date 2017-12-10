package qqq;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	 
	public static List<String> keys = new ArrayList<String>();
	public static List<String> values = new ArrayList<String>();
	public static List<Integer> lrus = new ArrayList<Integer>();

	public static int size_container;

	public static void put(String key, String value)
	{
		int max_index = -1, lru = 0, select_index = -1, count = keys.size();
		for (int i = 0; i < count; i++)
		{
			int tmp = lrus.get(i);
			lrus.set(i, tmp+1);
			
	//		lrus[i] ++;
			if (lrus.get(i) > lru)
			{
				max_index = i;
				lru = lrus.get(i);
			}
			if ((select_index < 0) && (keys.get(i) == key))
			{
				select_index = i;
			}
		}
		if (select_index >= 0)
		{
			values.set(select_index, value);
		}
		else if (count < size_container)
		{
			keys.add(key);
			values.add(value);
			select_index = count;
			lrus.add(0);
		}
		else
		{
			keys.set(max_index, key);
//			keys[max_index] = key;
			values.set(max_index, value);
//			values[max_index] = value;
			select_index = max_index;
		}
		lrus.set(select_index, 0);
//		lrus[select_index] = 0;
	}

public static void get(String key)
	{
		int count = keys.size(), select_index = -1;
		if (count!=0)
		{
			for (int i = 0; i < count; i++)
			{
				int tmp = lrus.get(i);
				lrus.set(i, tmp+1);
//				lrus[i]++;
				if ((select_index < 0) && (keys.get(i).equals( key)))
				{
					select_index = i;
				}
			}
		}
		if (select_index >= 0)
		{
			System.out.println(values.get(select_index));
//			cout << values[select_index] << endl;
		}
		else
		{
			System.out.println("null");
//			cout << "null" << endl;
		}
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		size_container = sc.nextInt();
		int input_size = sc.nextInt();
//		cin >> size_container >> input_size;
		int i = 0;
		String command, key, value;
		while (i++ < input_size)
		{
			command = sc.next();
			key = sc.next();
//			cin >> command >> key;
			if (command.trim().equals("put"))
			{
				value = sc.next();
//				cin >> value;
				put(key, value);
			}
			else
			{
				get(key);
			}
		}
	}
}
