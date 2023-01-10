/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= Controller2Client =======================
 *
 * <p>Service Description: The Controller service provides the API for orchestrating a collection of
 * debugger agents to perform debugging tasks. These agents are each attached to a process of an
 * application which may include one or more replicas.
 *
 * <p>The debugger agents register with the Controller to identify the application being debugged,
 * the Debuggee. All agents that register with the same data, represent the same Debuggee, and are
 * assigned the same `debuggee_id`.
 *
 * <p>The debugger agents call the Controller to retrieve the list of active Breakpoints. Agents
 * with the same `debuggee_id` get the same breakpoints list. An agent that can fulfill the
 * breakpoint request updates the Controller with the breakpoint result. The controller selects the
 * first result received and discards the rest of the results. Agents that poll again for active
 * breakpoints will no longer have the completed breakpoint in the list and should remove that
 * breakpoint from their attached process.
 *
 * <p>The Controller service does not provide a way to retrieve the results of a completed
 * breakpoint. This functionality is available using the Debugger service.
 *
 * <p>Sample for Controller2Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (Controller2Client controller2Client = Controller2Client.create()) {
 *   Debuggee debuggee = Debuggee.newBuilder().build();
 *   RegisterDebuggeeResponse response = controller2Client.registerDebuggee(debuggee);
 * }
 * }</pre>
 *
 * <p>======================= Debugger2Client =======================
 *
 * <p>Service Description: The Debugger service provides the API that allows users to collect
 * run-time information from a running application, without stopping or slowing it down and without
 * modifying its state. An application may include one or more replicated processes performing the
 * same work.
 *
 * <p>A debugged application is represented using the Debuggee concept. The Debugger service
 * provides a way to query for available debuggees, but does not provide a way to create one. A
 * debuggee is created using the Controller service, usually by running a debugger agent with the
 * application.
 *
 * <p>The Debugger service enables the client to set one or more Breakpoints on a Debuggee and
 * collect the results of the set Breakpoints.
 *
 * <p>Sample for Debugger2Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (Debugger2Client debugger2Client = Debugger2Client.create()) {
 *   String debuggeeId = "debuggeeId-1833285553";
 *   Breakpoint breakpoint = Breakpoint.newBuilder().build();
 *   String clientVersion = "clientVersion771880589";
 *   SetBreakpointResponse response =
 *       debugger2Client.setBreakpoint(debuggeeId, breakpoint, clientVersion);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.debugger.v2;

import javax.annotation.Generated;
