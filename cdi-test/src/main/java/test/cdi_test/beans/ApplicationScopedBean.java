package test.cdi_test.beans;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationScopedBean {
	public int getValue() {
		return 14;
	}
}