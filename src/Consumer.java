/**
 * @author yanlz
 * @data 2017/7/17.
 * desc:
 */
public class Consumer extends Thread {
    private int needNum; //每次需要消费的数量
    private Store store; //仓库

    public Consumer(int needNum, Store store) {
        this.needNum = needNum;
        this.store = store;
    }

    @Override
    public void run() {
        this.store.custome(this.needNum);
    }
}
