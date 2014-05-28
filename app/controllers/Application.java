package controllers;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import com.kenshoo.play.metrics.MetricsRegistry;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() throws Exception {
        Object defaultRegistry = MetricsRegistry.class.getMethod("default").invoke(null);

        MetricRegistry mr2 = (MetricRegistry)defaultRegistry;
        Logger.info("defaultRegistry.class: " + defaultRegistry.getClass().getName());

        Timer.Context c = mr2.timer("CustomApplication-Timer").time();
        mr2.counter("CustomApplication-Counter").inc();

        c.stop();
        return ok(index.render("Your new application is ready."));
    }

}
