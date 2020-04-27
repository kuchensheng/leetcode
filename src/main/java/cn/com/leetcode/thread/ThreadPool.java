package cn.com.leetcode.thread;

public interface ThreadPool<Job extends Runnable> {

    /**
     * zhixing'job
     * @param job
     */
    void execute(Job job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 添加工作线程
     * @param num
     */
    void addWorkers(int num);

    /**
     * 移除工作线程
     * @param nums
     */
    void removeWorkers(int nums);

    /**
     * 获取正在等待的任务数量
     * @return
     */
    int getJobSize();
}
