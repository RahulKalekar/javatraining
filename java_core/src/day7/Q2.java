package day7;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class Q2 {
    //to read the annotations
    public static void readAnnotation(AnnotatedElement element){
        Annotation[] annotations= element.getAnnotations();
        for(Annotation annotation:annotations){
            if(annotation instanceof Author){
                Author author=(Author) annotation;
                System.out.println("Author:" + author.name());
            }
            if(annotation instanceof Version){
                Version version=(Version) annotation;
                System.out.println("VErsion"+ version.number());
            }
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("Class Annotations:");
        readAnnotation(AnnotatedClass.class);

        System.out.println("Method annotatedMethod1 Annotations:");
        Method method1 = AnnotatedClass.class.getMethod("annotatedMethod1");
        readAnnotation(method1);

        System.out.println("Method annotatedMethod2 Annotations:");
        Method method2 = AnnotatedClass.class.getMethod("annotatedMethod2");
        readAnnotation(method2);
    }
}
