package LabProgram1308;
/*
 * There are N bags of marbles. The number of marbles in each bag may be different. 
 * When you take a marble out of a bag, you will earn certain amount of points, 
 * depending on the number of marbles in that bag. For example, if a bag contains K marbles, 
 * you will earn K point if you take a marble from that bag. You can take only one marble each time. 
 * Now, you are allowed to take up to M marbles in total, what is the maximum points you can earn? Input file:

The first line consists of N and M. N denotes the number of marble bags and M denotes the maximum number 
of marbles you can take out from those bags. Next line consists of N space separated integers X1,X2,X4…. XN 
where Xi denotes the number of marbles initially in the ith bag.

Please implement the following method:

public long maxPoints(String input)

For example, given the following data file, calling maxPoints(“input.data”) should return 13. 
Taking out a marble from the third bag earned 5 points, taking out one from the second bag earns 4 points, 
and the last marble from the third bag earns 4 points, so total points is 5+4+4=13.
 */

import java.util.*;
import java.io.*;

public class MaxPoints {
	public long maxPoints(String input) {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(input));
		} catch (Exception e) {
			return 0;
		}
		String line = null, dataLine = null;
		try {
			line = br.readLine();
			dataLine = br.readLine();
			br.close();
		} catch (Exception e) {
			return 0;
		}
		Scanner in = new Scanner(line);
		int N = in.nextInt();
		int M = in.nextInt();
		in = new Scanner(dataLine);
		Comparator<Integer> myc = new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		};
		PriorityQueue<Integer> pq = new PriorityQueue<>(myc);
		while (in.hasNextInt()) {
			pq.add(in.nextInt());
		}
		in.close();
		long total = 0;
		while (M-- > 0 && pq.isEmpty() == false) {
			int data = pq.poll();
			total += data--;
			if (data > 0)
				pq.add(data);
		}
		return total;
	}
}
