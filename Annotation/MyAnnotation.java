import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
*����һ��Annotation  Retention��������RUNTIME ���ҿ��Կ���ע���������ע��
*/
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation
{
	String hello() default "shengsiyuan";

	String world();
}
