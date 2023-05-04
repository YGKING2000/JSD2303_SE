package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

@AutoRunClass
public class Student {
    @AutoRunMethod()
    public void study(){
        System.out.println("学生:good good study,day day up！");
    }

    public void playGame(){
        System.out.println("学生:玩游戏");
    }

    @AutoRunMethod
    public void sleep(){
        System.out.println("学生:睡觉");
    }

}
