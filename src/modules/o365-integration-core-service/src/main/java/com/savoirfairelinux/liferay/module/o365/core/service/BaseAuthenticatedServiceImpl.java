package com.savoirfairelinux.liferay.module.o365.core.service;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import com.savoirfairelinux.liferay.module.o365.core.adapter.O365AuthenticationLiferayAdapter;
import com.savoirfairelinux.liferay.module.o365.core.api.AuthenticatedService;
import com.savoirfairelinux.liferay.module.o365.core.model.O365Authentication;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * The base implementation of the {@link AuthenticatedService} interface. It should extend all service implementation
 * that required to be authenticated.
 *
 * This is currently hardcoded with the {@link O365AuthenticationLiferayAdapter} that provide authentication persistence
 * in a Liferay environment
 */
public abstract class BaseAuthenticatedServiceImpl implements AuthenticatedService
{
	@Override
	public O365Authentication getAuthentication(HttpServletRequest request) {
		return new O365AuthenticationLiferayAdapter(request);
	}

	@Override
	public O365Authentication getAuthentication(PortletRequest request) {
		return new O365AuthenticationLiferayAdapter(request);
	}
	
	/**
	 * Give access to the graphClient api configured with the provided authentication
	 *
	 * @param authentication the user already validated authentication
	 * @return The graphClient api
	 */
	protected IGraphServiceClient getGraphClient(O365Authentication authentication) {
		IAuthenticationProvider authenticationProvider = new ScribejavaAuthenticationProvider(authentication);
		
		return GraphServiceClient
	    .builder()
	    .authenticationProvider(authenticationProvider)
	    .buildClient();
	}
    
}
