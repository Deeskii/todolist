package servlets;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/resource")
public class MyApplication extends Application{

    @Override
    public Set<Class<?>> getClasses()
    {
        HashSet hashSet = new HashSet<Class<?>>();
        hashSet.add( helloworld.class);
        return hashSet;
    }
}
