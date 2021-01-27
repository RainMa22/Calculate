import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
	String s="65 70 60 74 71 75 56 68\n" +
			"85 72 82 74 61 75 83 62\n" +
			"72 64 81 71 90 71 78 73\n" +
			"65 74 69 71 70 76 80 69";
	s=s.replace("\n"," ");
	while (s.contains("  ")){
		s=s.replace("  "," ").replace("\n"," ");
	}
	Object[] ss=s.split(" ");
	ss= Arrays.stream(ss).sorted().toArray();
	ArrayList<Double> doubles=new ArrayList<>(0);
	for (Object sss:ss){
		doubles.add(Double.parseDouble((String) sss));
		Object[] objs=doubles.stream().sorted().toArray();
		doubles=new ArrayList<>(0);
		for (Object o:objs) {
			doubles.add((double)o);
		}
	}
	double i=0;
	//double d=0;
		ArrayList<Double> existing=new ArrayList(0);
		ArrayList<Integer> count=new ArrayList(0);

	for (double s1:doubles){
		double num=s1;
		i+=num;
		if (!existing.contains(num)){
			existing.add(num);
			count.add(1);
		}else for (int j = 0; j < existing.size(); j++) {
			if (existing.get(j)!=num) continue;
			else{
				count.set(j,count.get(j)+1);
				break;
			}
		}
    }
	double median,mode;
	System.out.println(ss.length);
	if (ss.length%2==0){
		double a,b;
		a=Double.parseDouble((String)ss[(ss.length-1)/2]);
		b=Double.parseDouble((String)ss[(ss.length-1)/2+1]);
		median=(a+b)/2;
	}else{
		median= Double.parseDouble((String) ss[(int)((ss.length-1)/2)+1]);
	}
	int prev=0;
	mode=0;
		for (int j = 0; j < existing.size(); j++) {
			if (count.get(j)>prev){
				mode=existing.get(j);
				prev=count.get(j);
			}
		}
	double mean=i/ss.length;
		double range=doubles.get(doubles.size()-1)-doubles.get(0);
		System.out.println("total: "+i);
	System.out.println("mean: "+mean);
	System.out.println("median: "+median);
	System.out.println("mode: "+mode);
	System.out.println("range: "+range);
	i=0;
	int repetition=0;
	//System.out.println(d);
		for (Object s1:ss){
			if(Double.parseDouble((String) s1)==mean){
				repetition++;
				continue;
			}
			double tmp=Double.parseDouble((String) s1)-mean;
			i+=tmp*tmp;
		}
		double sd=Math.sqrt(i/(ss.length-repetition));
		System.out.println(sd);
		for (double d:doubles) {
			System.out.print(d+" ");
		}
		System.out.println("");
		for (int j = 0; j < existing.size(); j++) {
			System.out.print(existing.get(j)+":"+count.get(j)+" ");
		}
    }
}
