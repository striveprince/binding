package binding.com.demo.base.cycle;

import android.app.Service;

import com.binding.model.util.ReflectUtil;
import binding.com.demo.inject.component.DaggerServiceComponent;
import binding.com.demo.inject.component.ServiceComponent;
import binding.com.demo.ui.DemoApplication;

import java.lang.reflect.Method;

/**
 * Created by pc on 2017/9/14.
 */

public abstract class BaseService extends Service {
    private ServiceComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        try {
            Method method = ServiceComponent.class.getDeclaredMethod("inject", getClass());
            ReflectUtil.invoke(method, getComponent(), this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public ServiceComponent getComponent() {
        if (component == null) {
            component = DaggerServiceComponent.builder()
                    .appComponent(DemoApplication.getAppComponent())
                    .build();
        }
        return component;
    }
}
