public class Template{
    public static void main(String[] args) {
        TemplateText jobA = new A();
        TemplateText jobB = new B();
        System.out.println(jobA.calculateTime());
        System.out.println(jobB.calculateTime());
    }
}

abstract class TemplateText {
    abstract void job();
    public long calculateTime(){
        long first = System.currentTimeMillis();
        job(); // 动态绑定机制
        long end = System.currentTimeMillis();
        return end-first;
    }
}

class A extends TemplateText{

    @Override
    void job() {
        long sum = 0;
        for (int i = 0; i < 100000000; i++) {
            sum++;
        }
    }
}

class B extends TemplateText{

    @Override
    void job() {
        long sum = 0;
        for (int i = 0; i < 50000; i++) {
            sum++;
        }
    }
}
