/**
 * @author yanlz
 * @data 2017/7/17.
 * desc:
 */
public class Store {
    private final int max_size = 100;//最大库存容量
    private int curNum;//现有库存量

    public Store(int curNum) {
        this.curNum = curNum;
    }

    /**
     * 进行生产
     *
     * @param needNum 需要生产的数量
     */
    public synchronized void produce(int needNum) {
        //如果不需要生产，进入等待状态
        while (true) {
            while (this.curNum + needNum > this.max_size) {
                System.out.println(Thread.currentThread().getName() + "要生产的产品数量：" + needNum +
                        "已经超出库存容量：" + (this.max_size - this.curNum) + ",暂时不能进行生产任务。");
                try {
                    this.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.curNum += needNum;
            System.out.println(Thread.currentThread().getName() + "已经生产了" + needNum + ",现在库存是：" + this.curNum);
            this.notifyAll(); // 唤醒在此对象监视器上等待的所有线程
        }
    }

    /**
     * 进行消费
     *
     * @param needNum 需要消费的数量
     */
    public synchronized void custome(int needNum) {
        while (true) {
            /**
             * 如果不可以消费，进入等待状态
             */
            while (this.curNum < needNum) {
                System.out.println(Thread.currentThread().getName() + "要消费的产品数量" + needNum + "已经超出剩余库存量" + this.curNum + "，暂时不能进行消费！");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            /**
             * 满足了消费条件，进行产品消费
             */
            this.curNum -= needNum;
            System.out.println(Thread.currentThread().getName() + "已经消费了" + needNum + "，现存库存量是为：" + this.curNum);

            /**
             * 唤醒在此对象监视器上等待的所有线程
             */
            this.notifyAll();
        }
    }
}
