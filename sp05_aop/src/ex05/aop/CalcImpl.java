package ex05.aop;

public class CalcImpl implements ICalc {

	@Override
	public int add(int x, int y) {
		//��������(cross-cutting-concern)
		int result = x + y;
		//��������(cross-cutting-concern)
		System.out.println("add �ְ��ɻ�");
		return result;
	}

	@Override
	public int mul(int x, int y) {
		int result = x * y;
		System.out.println("mul �ְ��ɻ�");
		return result;
	}

	@Override
	public int sub(int x, int y, int z) {
		
		if (y > x) {
			throw new IllegalArgumentException("y���� x���� Ů�ϴ�.");
		}
		int result = x - y - z;
		System.out.println("sub ---------------------");
		return result;
	}

}
