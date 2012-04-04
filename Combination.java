import java.util.Iterator;
import java.util.BitSet;


public class Combination implements Iterator {

	private int N;
	private BitSet X;
	private Object[] items;
	private Object[] array;

	public Combination(Object[] items, int k) {
		this.items = items;
		N = items.length;
		array = new Object[k];
		X  = new BitSet(N + 1);
		for(int i=0; i<k; i++) X.set(i);
	}

	public boolean hasNext() {
		return ! X.get(N);
	}

	// 右から見て最初に１となる位置を返す
	// オール０なら -1 を返す
	// bs = 10011100
	// return 2
	private int findOne(BitSet bs) {
		int len = bs.size();
		for(int i=0; i<=N; i++) {
			if(bs.get(i)) return i;
		}
		return -1;
	}

	// 指定された位置でインクリメントする
	// 桁上がりした分の桁数を返す
	// bs = 10011100, n = 2
	// bs = 10100000
	// return 3
	private int incr(BitSet bs, int n) {
		int a = 0;
		for(;;) {
			if(bs.get(n)) {
				bs.clear(n); n++; a++;
			} else {
				bs.set(n); break;
			}
		}
		return a;
	}

	public Object next() {
		int k = 0;
		for(int i=0; i<=N; i++) {
			if(X.get(i)) array[k++] = items[i];
		}
		int u = incr(X, findOne(X)) - 1;
		for(int i=0; i<u; i++) X.set(i);
		return array;
	}
	
	public void remove(){}
	

}
/*
N=6
K=3
{1, 2, 3}
{1, 2, 4}
{1, 3, 4}
{2, 3, 4}
{1, 2, 5}
{1, 3, 5}
{2, 3, 5}
{1, 4, 5}
{2, 4, 5}
{3, 4, 5}
{1, 2, 6}
{1, 3, 6}
{2, 3, 6}
{1, 4, 6}
{2, 4, 6}
{3, 4, 6}
{1, 5, 6}
{2, 5, 6}
{3, 5, 6}
{4, 5, 6}
count=20
*/
