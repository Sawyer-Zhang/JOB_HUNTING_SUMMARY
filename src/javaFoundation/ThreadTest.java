package javaFoundation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * @description 学习线程和线程池的测试代码
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年10月27日
 */
public class ThreadTest {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println("测试继承方式实现线程");
			}
		}.start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("测试实现接口方式创建线程");
			}
		}).start();
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int result = 0;
				for (int i = 0; i < 10; i++) {
					result += i;
					System.out.println(result);
				}
				return result;
			}
		};
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}