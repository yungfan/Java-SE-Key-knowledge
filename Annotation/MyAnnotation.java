import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
*定义一个Annotation  Retention的类型是RUNTIME 而且可以看出注解可以修饰注解
*/
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation
{
	String hello() default "shengsiyuan";

	String world();
}
