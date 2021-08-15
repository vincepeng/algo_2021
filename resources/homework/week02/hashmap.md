## hashMap

### 背景

考虑到HashMap在面试中常考,借这个机会,刚好了解一下. 因此以面试题方式进行总结HashMap

### 1.hash算法

```java
//方法一：
static final int hash(Object key){   //jdk1.8 & jdk1.7
        int h;
        // h = key.hashCode() 为第一步 取hashCode值
        // h ^ (h >>> 16)  为第二步 高位参与运算
        return(key==null)?0:(h=key.hashCode())^(h>>>16);
        }
//方法二：
static int indexFor(int h,int length){  //jdk1.7的源码，jdk1.8没有这个方法，但是实现原理一样的
        return h&(length-1);  //第三步 取模运算
        }
```

主要有两点要说明,第一点是为什么要移位异或(^),一个是为什么需要2的n次方. 先说Java 1.8的Hash算法,通过>>>16,让hashCode高位也参与到hash的计算中来,有助于在length较小时也得到均匀的hash

第二点就比较难点,HashMap的hash算法是比较巧妙的,也比较难懂,通过例子理解一下. 理想的hash值其实就是hashcode对数组长度求余,但是求余成本较高,当为数组长度2的n次方时,刚好可以通过与(&)得到. 举例子hashCode为14,数组长度为8.则求余结果为14%8=6.翻译成二进制

```
1110
%
1000
---
6
```

发现二进制条件取余,其实就是剩下的低位(14的低位为后三位110),这不是等价于与(0111)求与(&)么.如下

```
1110
&
0111
---
6
```

因此 hashCode%length=hashCode&(length-1)

### 2.HashMap的扩容过程

过程上将主要有以下几点? 1.一些必要的判断,是否超过map的最大容量(2^30)或者未初始化. 2.直接按照原先两倍进行扩容新建一个数组. 3.将原先的数组元素重新计算hash,然后根据结果不同移动到新数组里面来.这里比较巧妙的是,因为扩容是按照2倍来的,因此去hash=hashCode%(newCap)=hashCode&oldCap,其实就是需要查看
hashCode向前一位,因此巧妙通过hashCode&oldCap来判断最高位是否相等即可.如果不同就放原位置,如果都是0或者1则往后挪动oldCap即可,避免了1.7的重新计算 举例子hashCode为14和hashCode为22,数组长度为8.则求余结果为14%8=22%8=6.翻译成二进制

```
1110    10110
%       %
1000    1000
---     ----
6       6 
```

现在扩容2倍为16,依旧求余

```
01110   10110
%       %
10000   10000
---     ----
&       &
1000   1000
---     ----
14      6 
```

### 参考

[美团HashMap](https://tech.meituan.com/2016/06/24/java-hashmap.html)