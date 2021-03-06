/*
 * Copyright (c) 2019 Savoir-faire Linux Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU LesserGeneral Public License as published by
 * the Free Software Foundation, either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU LesserGeneral Public License for more details.
 *
 * You should have received a copy of the GNU LesserGeneral Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.savoirfairelinux.liferay.module.o365.core.api;

import com.savoirfairelinux.liferay.module.o365.core.model.O365Authentication;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Base service that give access to the authentication to implementing service. This interface should extend any service
 * interface that require an authentication
 */
public interface AuthenticatedService
{
	
	/**
	 * @param request used to initialise the Authentication
	 * @return an o365Authentication for the current user
	 */
	O365Authentication getAuthentication(HttpServletRequest request);
	
	/**
	 * @param portletRequest used to initialise the Authentication
	 * @return an o365Authentication for the current user
	 */
	O365Authentication getAuthentication(PortletRequest portletRequest);
	
	String getRequiredScope();
}
