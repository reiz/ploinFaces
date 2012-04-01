package org.ploin.web.faces.core;

import org.ploin.web.faces.phaselistener.*;

import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ProjectStage;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import java.util.Iterator;

/**
 * $LastChangedBy: robert $<br>
 * $Revision: 1 $<br>
 * $Date: Jan 10, 2010 $<br>
 * <p/>
 * Created by: robert
 * Created date: Jan 10, 2010 - 11:26:43 AM
 * <p/>
 * Description:
 */
public class PhaseListenerInstallationListener implements SystemEventListener{

	public void processEvent(SystemEvent event) throws AbortProcessingException {

		LifecycleFactory factory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
		for (Iterator iterator = factory.getLifecycleIds(); iterator.hasNext();) {
			String id = (String) iterator.next();
			Lifecycle lifecycle = factory.getLifecycle( id );

			System.out.println("add BlockSaveListener");
			lifecycle.addPhaseListener(new BlockSaveListener());

			System.out.println("add JsfPhaseListener01");
			lifecycle.addPhaseListener(new JsfPhaseListener01());

			System.out.println("add JsfPhaseListener02");
			lifecycle.addPhaseListener(new JsfPhaseListener02());

			System.out.println("add JsfPhaseListener03");
			lifecycle.addPhaseListener(new JsfPhaseListener03());

			System.out.println("add JsfPhaseListener04");
			lifecycle.addPhaseListener(new JsfPhaseListener04());

			System.out.println("add JsfPhaseListener05");
			lifecycle.addPhaseListener(new JsfPhaseListener05());

			System.out.println("add JsfPhaseListener06");
			lifecycle.addPhaseListener(new JsfPhaseListener06());
		}

		Application application = (Application) event.getSource();
		application.unsubscribeFromEvent(PostConstructApplicationEvent.class, this);
	}

	public boolean isListenerForSource(Object source) {
		if (source instanceof Application) {
			Application application = (Application) source;
			return (application.getProjectStage() == ProjectStage.Development);
		}
		return false;
	}

}
