package cn.itcast.demo1;


import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by Administrator on 2016/8/19.
 */
public class demo1 {
    public static void main(String[] args) {
        System.out.println(GRADE.A.name());
        System.out.println(GRADE.B.ordinal());

        //字符串转枚举
        GRADE grade = GRADE.valueOf("A");
        System.out.println(grade);

        GRADE[] grades = GRADE.values();
        for (GRADE a : grades) {
            System.out.print(a);
        }
    }

    //可变参数
    public void printNums(int ...nums) {
        for (int a : nums) {
            System.out.print(a);
        }
    }

}
enum GRADE {
    A("a") {
        public String localValue() {
            return "优秀";
        }
    },B("b") {
        public String localValue () {
            return "良好";
        }
    };

    private String value;
    private GRADE(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
    //抽象
    public abstract String localValue();
}
