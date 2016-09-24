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
        // 如果playPet方法被重载，可以接受两种functional interfaces作为参数
        // 并且两种functional interface的参数列表和返回值都一样那么此处将会报错
        // 因为编译器无法判断到底要把你传入的lambda表达式转换成何种目标类型
        // 注意：只要是只有一个方法定义，那么就默认是functional interface
        // 无论是否用FunctionalInterface进行注解
        playPet(() -> {
            System.out.println("Wang!");
        });
    }
}
