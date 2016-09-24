package lambda;

import lambda.functionalinterfaces.Cat;
import lambda.functionalinterfaces.Dog;

import org.junit.Test;

public class PetPlayer {
    public void playPet(Dog d) {
        d.spark();
    }
//    public void playPet(Cat c) {
//        c.meow();
//    }
    @Test
    public void play() {
        // ���playPet���������أ����Խ�������functional interfaces��Ϊ����
        // ��������functional interface�Ĳ����б�ͷ���ֵ��һ����ô�˴����ᱨ��
        // ��Ϊ�������޷��жϵ���Ҫ���㴫���lambda���ʽת���ɺ���Ŀ������
        // ע�⣺ֻҪ��ֻ��һ���������壬��ô��Ĭ����functional interface
        // �����Ƿ���FunctionalInterface����ע��
        playPet(() -> {
            System.out.println("Wang!");
        });
    }
}
