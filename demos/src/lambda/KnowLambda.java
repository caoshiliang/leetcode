package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.junit.Test;


/**
 * �ܽ�:
 *     1. ���Ǳ�FuntionalInterfaceע������Ͷ����Գ�֮Ϊ���ܽӿڣ����
 *     �����ǹ��ܽӿ����ͣ���ô�Ϳ���ʹ��lambda���ʽ�����滻���滻ʱ
 *     Ӧ��ע������ͷ���ֵӦ����ù��ܽӿڵ�Ψһ�����Ĳ����뷵��ֵ
 *     ��ƥ�䣬��Ȼ����뱨��
 *     2. ����ʲô�ӿڿ��Ա�FunctionalInterfaceע�⣬��׼�ܼ򵥣�ֻ��һ����ʽ
 *     �����ĳ��󷽷�
 *     3. һ��lambda���ʽ��Ŀ�����Ϳ����ж�����ɱ�������ƥ��
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
        }); // �����������ֵ��һ��������ô�����������廨���Ŷ�����ʡ��
        s.add(5); s.add(4); s.add(3); s.add(2); s.add(1);
        s.forEach(element -> {
            System.out.println(element);
        });
    }
}
