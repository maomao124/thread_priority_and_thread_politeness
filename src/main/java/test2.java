/**
 * Project name(项目名称)：线程的优先级和线程礼让
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/29
 * Time(创建时间)： 20:22
 * Version(版本): 1.0
 * Description(描述)：  yield() 方法将一个线程的操作暂时让给其他线程执行
 */

class MyThread1 implements Runnable
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
            if (i == 2)
            {
                System.out.print(Thread.currentThread().getName()+"线程礼让：");
                Thread.yield();
            }
        }
    }
}

public class test2
{
    public static void main(String[] args)
    {
        MyThread1 thread1 = new MyThread1();
        Thread t1 = new Thread(thread1, "线程1");
        Thread t2 = new Thread(thread1, "线程2");
        Thread t3 = new Thread(thread1, "线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}
