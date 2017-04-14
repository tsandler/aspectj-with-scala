package aspects;

import model.JavaEntity;
import model.ScalaEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnnotationAspectTest {

    private ScalaEntity scalaEntity;
    private JavaEntity javaEntity;

    @Before
    public void setUp(){
        scalaEntity = new ScalaEntity();
        javaEntity = new JavaEntity();
    }

    @Test
    public void testingInterceptWithScala(){
        scalaEntity.name_$eq("newName");
        Assert.assertEquals("intercepted", scalaEntity.name());
    }

    @Test
    public void testingInterceptWithJava(){
        javaEntity.setName("newName");
        Assert.assertEquals("intercepted", javaEntity.getName());
    }
}
