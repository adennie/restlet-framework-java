/*
 * Copyright 2005-2006 Jerome LOUVEL
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.txt
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * http://www.opensource.org/licenses/cddl1.txt
 * If applicable, add the following below this CDDL
 * HEADER, with the fields enclosed by brackets "[]"
 * replaced with your own identifying information:
 * Portions Copyright [yyyy] [name of copyright owner]
 */

package org.restlet;

import java.io.IOException;

import org.restlet.component.Component;
import org.restlet.connector.Client;
import org.restlet.connector.Server;
import org.restlet.data.*;

/**
 * Factory implemented by Restlet implementations.
 */
public interface Factory
{
   /**
    * Creates a challenge response for a specific scheme using a user ID and a password as the credentials.<br/>
    * @param scheme The challenge scheme to use.
    * @param userId The user identifier to use.
    * @param password The user password.
    * @return The challenge response to attach to an uniform call.
    */
   public ChallengeResponse createChallengeResponse(ChallengeScheme scheme, String userId, String password);

   /**
    * Create a new client connector for a given protocol.
    * @param protocol The connector protocol.
    * @param name The unique connector name.
    * @return The new client connector.
    */
   public Client createClient(Protocol protocol, String name);

   /**
    * Creates a delegate Restlet call.
    * @return A delegate Restlet call.
    */
   public RestletCall createDelegateCall();

   /**
    * Creates a delegate Chainlet for internal usage by the AbstractChainlet.<br/>
    * If you need a Chainlet for your application, you should be subclassing the AbstractChainlet instead. 
    * @param parent The parent component.
    * @return A new Chainlet.
    */
   public Chainlet createDelegateChainlet(Component parent);

   /**
    * Creates a delegate Maplet for internal usage by the DefaultMaplet.<br/>
    * If you need a Maplet for your application, you should be using the DefaultMaplet instead. 
    * @param parent The parent component.
    * @return A new Maplet.
    */
   public Maplet createDelegateMaplet(Component parent);

   /**
    * Creates an empty form.
    * @param query Query string to parse or null for an empty form.
    * @return A new form.
    */
   public Form createForm(String query) throws IOException;

   /**
    * Create a new server connector for a given protocol.
    * @param protocol The connector protocol.
    * @param name The unique connector name.
    * @param target The target Restlet.
    * @param address The optional listening IP address (local host used if null).
    * @param port The listening port.
    * @return The new server connector.
    */
   public Server createServer(Protocol protocol, String name, Restlet target, String address, int port);
}
