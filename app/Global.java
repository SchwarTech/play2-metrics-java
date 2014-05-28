import com.kenshoo.play.metrics.MetricsFilterJava;
import play.GlobalSettings;
import play.api.mvc.EssentialFilter;

/**
 * Created by jeff on 5/27/14.
 */
public class Global extends GlobalSettings {
    @Override
    public <T extends EssentialFilter> Class<T>[] filters() {
        Class<T>[] classes = new Class[] {MetricsFilterJava.class};
        return classes;
    }
}
