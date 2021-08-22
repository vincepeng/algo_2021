发现Java scheduleExecutor里面的DelayWorkQueue非常有意思.

### 背景

Java里面有个延迟线程池--ScheduleExecutor,里面支持动态添加延迟任务执行.

### 实现方案

如果让我来实现,肯定不用考虑放一个优先级队列支持排序,然后当worker空闲时间,则去检查队首是否到达执行时间 如果到达则执行

但是这里面有一些问题,由于线程池添加任务比较频繁,然后有一些任务会存在超时未执行取消,这些操作都需要对延迟队列重新排序, 为了线程安全有需要加锁,发现实现起来性能就很差了.

Doug Lea又是怎么实现的呢?

### 官方实现

他其实基于最小堆来实现了一个优先级队列 因为堆应用这个场景刚好合适,就是保证父节点一定比子节点小,后面是叶子节点是否有序不关键. 因此他只需要保持每次取得第一个是最小的就行了.

这里面比较复杂的是siftUp(),siftDown(),其实就是堆的插入和删除.其实就是实现堆的插入,这里使用的是交换的方法,只是用了一个移位;

```java
        /**
 * Sifts element added at bottom up to its heap-ordered spot.
 * Call only when holding lock.
 */
private void siftUp(int k,RunnableScheduledFuture<?> key){
        while(k>0){
        int parent=(k-1)>>>1;
        RunnableScheduledFuture<?> e=queue[parent];
        if(key.compareTo(e)>=0)
        break;
        queue[k]=e;
        setIndex(e,k);
        k=parent;
        }
        queue[k]=key;
        setIndex(key,k);
        }
        ![如下图:](./resources/static/images/delayedWorkQueue.png)


```

### 感想

doug.l 真是一个天才人物

[具体说明](https://www.jianshu.com/p/925dba9f5969)