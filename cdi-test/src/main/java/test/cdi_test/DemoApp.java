package test.cdi_test;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import test.cdi_test.beans.ApplicationScopedBean;

public class DemoApp
{
    private static final Logger LOG = Logger.getLogger(DemoApp.class.getName());

    @Inject
    private ApplicationScopedBean applicationScopedBean;

    public static void main(String[] args)
    {
        CdiContainer container = CdiContainerLoader.getCdiContainer();
        container.boot();
        ContextControl contextControl = container.getContextControl();
        contextControl.startContexts();

        try
        {
            BeanProvider.injectFields(new DemoApp()).runApplicationLogic();
        }
        finally
        {
            container.shutdown();
        }
    }

    void runApplicationLogic()
    {
        LOG.info("Info of injected bean: " + this.applicationScopedBean.getValue());
    }
}
