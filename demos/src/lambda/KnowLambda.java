package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.junit.Test;


/**
 * 总结:
 *     1. 凡是被FuntionalInterface注解的类型都可以称之为功能接口，如果
 *     参数是功能接口类型，那么就可以使用lambda表达式进行替换，替换时
 *     应该注意参数和返回值应该与该功能接口的唯一方法的参数与返回值
 *     相匹配，不然会编译报错。
 *     2. 至于什么接口可以被FunctionalInterface注解，标准很简单：只有一个显式
 *     声明的抽象方法
 *     3. 一个lambda表达式的目标类型可能有多个，由编译器来匹配
 *     Ref: http://blog.csdn.net/ioriogami/article/details/12782141/
 *
 */
public class KnowLambda {

    @Test
    public void testTheadApply() {
        // No need to implicitly declare that the parameter passed to Thread
        // constructor is a runnable instance, java could infer that based on
        // the contexts
        Thread t = new Thread(() -> {
            System.out.println("Hello World");
        });
        t.start();
    }

    @Test
    public void collectionInternalIterating() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4,5));
        // forEach could leverage multiple processors to improve iterating
        // performance, which is an major advantage of internal iterating.
        list.forEach(element -> {
            System.out.println(element);
        });
    }
    @Test
    public void testComparator() {
        Set<Integer> s = new TreeSet<>((a, b) -> {
            return a - b;
        }); // 这里如果返回值是一个数，那么甚至连函数体花括号都可以省略
        s.add(5); s.add(4); s.add(3); s.add(2); s.add(1);
        s.forEach(element -> {
            System.out.println(element);
        });
    }
}
