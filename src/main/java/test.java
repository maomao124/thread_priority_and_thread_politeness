/**
 * Project name(项目名称)：线程的优先级和线程礼让
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/29
 * Time(创建时间)： 20:12
 * Version(版本): 1.0
 * Description(描述)：
 * 线程的优先级
 * 在 Java 的线程操作中，所有的线程在运行前都会保持在就绪状态，那么此时，哪个线程的优先级高，哪个线程就有可能会先被执行。
 */

class MyThread implements Runnable
{

    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + "休眠500毫秒");
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
        }
    }
}

public class test
{
    public static void main(String[] args)
    {
        MyThread thread = new MyThread();
        Thread t1 = new Thread(thread, "线程1");
        Thread t2 = new Thread(thread, "线程2");
        Thread t3 = new Thread(thread, "线程3");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        System.out.println();
        test2.main(null);
    }
}
