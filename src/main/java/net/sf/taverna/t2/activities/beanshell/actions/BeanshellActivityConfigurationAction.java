/*******************************************************************************
 * Copyright (C) 2007 The University of Manchester   
 * 
 *  Modifications to the initial code base are copyright of their
 *  respective authors, or their employers as appropriate.
 * 
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 *    
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *    
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 ******************************************************************************/
package net.sf.taverna.t2.activities.beanshell.actions;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import net.sf.taverna.t2.activities.beanshell.BeanshellActivity;
import net.sf.taverna.t2.activities.beanshell.BeanshellActivityConfigurationBean;
import net.sf.taverna.t2.activities.beanshell.views.BeanshellConfigView;
import net.sf.taverna.t2.workbench.ui.actions.activity.ActivityConfigurationAction;
import net.sf.taverna.t2.workbench.ui.views.contextualviews.activity.ActivityConfigurationDialog;

@SuppressWarnings("serial")
public class BeanshellActivityConfigurationAction extends ActivityConfigurationAction<BeanshellActivity, BeanshellActivityConfigurationBean>{

	public static final String EDIT_BEANSHELL_SCRIPT = "Edit beanshell script";

	public BeanshellActivityConfigurationAction(BeanshellActivity activity, Frame owner) {
		super(activity);
		putValue(NAME, EDIT_BEANSHELL_SCRIPT );
	}

	public void actionPerformed(ActionEvent e) {
		ActivityConfigurationDialog currentDialog = ActivityConfigurationAction.getDialog(getActivity());
		if (currentDialog != null) {
			currentDialog.toFront();
			return;
		}
		final BeanshellConfigView beanshellConfigView = new BeanshellConfigView((BeanshellActivity)getActivity());
		final ActivityConfigurationDialog<BeanshellActivity, BeanshellActivityConfigurationBean> dialog =
			new ActivityConfigurationDialog<BeanshellActivity, BeanshellActivityConfigurationBean>(getActivity(), beanshellConfigView);

		ActivityConfigurationAction.setDialog(getActivity(), dialog);	
		
	}

}
