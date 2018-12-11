java中接口实现回调方法2017 年12月 25日  0255:35 hyc9200 阅读数：775 标签： java cass 
更多 个人分类： Jaa基础知识
 在学习过程中，看Java源码时，经常出现一个词就是回调方法，网上查看别人解释，五花八门，看得人云里雾里，通过揣摩理解，在这里我来说一说我的理解。 一、回调方法概念 
举例说明  这里写图片描述 图中是这么个场景，类A实现时要调用类B的b(),这时我们会怎么做呢，我们直接在类A中实例化一个类B对象b，然后调用b.b(),我们叫这种调用为直接调用；但是此时类B中b()的实现，要依赖于类A的a()方法，我们叫这个方法a()为回调方法，这就是回调方法概念。 
我们发现这种2个类之间相互调用，这种设计不利于代码维护，因为改了类A的代码，可能就要改类B代码，相反也一样。有没有方法避免这种情况呢？使A、B之间相对独立，Java中可以采用接口实现回调，我们来看一看. 
二、接口实现回调 
接口定义

public interface CallBack {
        public void a();
    }1 2 3 类A定义

    public class A implements CallBack {
        // 持有B的引用
        public B bb;

        @Override
        public void a() {
            System.out.print("Hello my name is A");
        }
    }1 2 3 4 5 6 7 8 类B定义

    public class B {
        public CallBack callBack;

        public B(CallBack callBack) {
            this.callBack = callBack;
        }

        public void b() {
            // 只关注接口，与实现接口的类A隔离、解耦，提高代码灵活性，可复用性，
            callBack.a();
        }
    }1 2 3 4 5 6 7 8 9 10 我们来测试下

    public class Test {
    public static void main(String[] args){
        A a = new A();
        B b = new B(a);
        a.bb = b;
        a.bb.b();
    }
}1 2 3 4 5 6 7 8 三、结论 使用接口实现回调的方式可以使各模块实现解耦，提高代码的灵活性与可复用性。