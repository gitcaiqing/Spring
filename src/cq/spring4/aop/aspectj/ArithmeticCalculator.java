package cq.spring4.aop.aspectj;

public interface ArithmeticCalculator {
	/**
	 * ¼Ó
	 * @param i
	 * @param j
	 * @return
	 */
	int add(int i, int j);
	/**
	 * ¼õ
	 * @param i
	 * @param j
	 * @return
	 */
	int sub(int i, int j);
	/**
	 * ³Ë
	 * @param i
	 * @param j
	 * @return
	 */
	int mul(int i, int j);
	/**
	 * ³ı
	 * @param i
	 * @param j
	 * @return
	 */
	int div(int i, int j);
}
