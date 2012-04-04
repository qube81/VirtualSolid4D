import java.util.Iterator;

public class Permutation implements Iterator {

	private int N;
	private int c[], k;
	private Object[] objs;

	public Permutation(Object[] items) {
		N = items.length;
		c = new int[N + 1];
		for(int i=0; i<=N; i++) c[i] = i;
		objs = items;
		k = 1;
	}

	public boolean hasNext() {
		return (k < N);
	}

	public Object next() {
		int i = 0;
		if((k & 1) != 0) i = c[k];

		Object tmp = objs[k];
		objs[k] = objs[i];
		objs[i] = tmp;

		k = 1;
		while(c[k] == 0) c[k] = k++;

		c[k]--;
		return objs;
	}
	
	public void remove(){}


}
