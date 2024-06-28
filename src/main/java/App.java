import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());

        //так как у бина "helloworld" "Scope = Singleton" (тоесть по умолчанию),
        // то bean2 == bean
        HelloWorld bean2 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean2.getMessage());

        System.out.printf("Сравнение бинов helloworld. Бины равны? %s\n", bean == bean2);

        // В AppConfig мы присвоили бину, который создает объект CAT
        // "Scope = Prototype", то каждая переменная будет ссылаться на свой объект "Cat"
        // об этом говорит нам проверки на == и выведенное поле "name" объекта
        Cat bean3 = (Cat) applicationContext.getBean("cat");
        bean3.setName("Musya");
        System.out.println(bean3.getName());

        Cat bean4 = (Cat) applicationContext.getBean("cat");
        bean4.setName("Barsik");
        System.out.println(bean4.getName());

        System.out.printf("Сравнение бинов helloworld. Бины равны? %s", bean3 == bean4);

    }
}