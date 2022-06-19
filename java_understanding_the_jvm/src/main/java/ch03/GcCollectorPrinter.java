package ch03;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * # java 8 的默认收集器
 * $ java ch03.GcCollectorPrinter
 * PS Scavenge
 * PS MarkSweep
 * <p>
 * $ java -XX:+UseParallelGC ch03.GcCollectorPrinter
 * PS Scavenge
 * PS MarkSweep
 * <p>
 * $ java -XX:+UseParallelOldGC ch03.GcCollectorPrinter
 * PS Scavenge
 * PS MarkSweep
 * <p>
 * $ java -XX:+UseSerialGC ch03.GcCollectorPrinter
 * Copy
 * MarkSweepCompact
 * <p>
 * $ java -XX:+UseParNewGC ch03.GcCollectorPrinter
 * Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector with the Serial old collector is deprecated and will likely be removed in a future release
 * ParNew
 * MarkSweepCompact
 * <p>
 * $ java -XX:+UseConcMarkSweepGC ch03.GcCollectorPrinter
 * ParNew
 * ConcurrentMarkSweep
 * <p>
 * $ java -XX:+UseG1GC ch03.GcCollectorPrinter
 * G1 Young Generation
 * G1 Old Generation
 * <p>
 * $ java -version
 * java version "1.8.0_201"
 * Java(TM) SE Runtime Environment (build 1.8.0_201-b09)
 * Java HotSpot(TM) 64-Bit Server VM (build 25.201-b09, mixed mode)
 */
public class GcCollectorPrinter {
    public static void main(String[] args) {
        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : beans) {
            System.out.println(bean.getName());
        }
        System.out.println();
    }
}
