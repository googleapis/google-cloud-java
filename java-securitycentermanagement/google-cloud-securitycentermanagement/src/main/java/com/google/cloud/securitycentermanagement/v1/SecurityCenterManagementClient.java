/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.securitycentermanagement.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securitycentermanagement.v1.stub.SecurityCenterManagementStub;
import com.google.cloud.securitycentermanagement.v1.stub.SecurityCenterManagementStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SecurityCenterManagementClient securityCenterManagementClient =
 *     SecurityCenterManagementClient.create()) {
 *   EffectiveSecurityHealthAnalyticsCustomModuleName name =
 *       EffectiveSecurityHealthAnalyticsCustomModuleName
 *           .ofProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
 *               "[PROJECT]", "[LOCATION]", "[EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]");
 *   EffectiveSecurityHealthAnalyticsCustomModule response =
 *       securityCenterManagementClient.getEffectiveSecurityHealthAnalyticsCustomModule(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the SecurityCenterManagementClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>ListEffectiveSecurityHealthAnalyticsCustomModules</td>
 *      <td><p> Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors (no descendants).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listEffectiveSecurityHealthAnalyticsCustomModules(ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listEffectiveSecurityHealthAnalyticsCustomModules(FolderLocationName parent)
 *           <li>listEffectiveSecurityHealthAnalyticsCustomModules(LocationName parent)
 *           <li>listEffectiveSecurityHealthAnalyticsCustomModules(OrganizationLocationName parent)
 *           <li>listEffectiveSecurityHealthAnalyticsCustomModules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable()
 *           <li>listEffectiveSecurityHealthAnalyticsCustomModulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetEffectiveSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Gets details of a single EffectiveSecurityHealthAnalyticsCustomModule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getEffectiveSecurityHealthAnalyticsCustomModule(GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getEffectiveSecurityHealthAnalyticsCustomModule(EffectiveSecurityHealthAnalyticsCustomModuleName name)
 *           <li>getEffectiveSecurityHealthAnalyticsCustomModule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getEffectiveSecurityHealthAnalyticsCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListSecurityHealthAnalyticsCustomModules</td>
 *      <td><p> Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors (no descendants).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listSecurityHealthAnalyticsCustomModules(ListSecurityHealthAnalyticsCustomModulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listSecurityHealthAnalyticsCustomModules(FolderLocationName parent)
 *           <li>listSecurityHealthAnalyticsCustomModules(LocationName parent)
 *           <li>listSecurityHealthAnalyticsCustomModules(OrganizationLocationName parent)
 *           <li>listSecurityHealthAnalyticsCustomModules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listSecurityHealthAnalyticsCustomModulesPagedCallable()
 *           <li>listSecurityHealthAnalyticsCustomModulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListDescendantSecurityHealthAnalyticsCustomModules</td>
 *      <td><p> Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent and all of the parent’s CRM descendants.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listDescendantSecurityHealthAnalyticsCustomModules(ListDescendantSecurityHealthAnalyticsCustomModulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listDescendantSecurityHealthAnalyticsCustomModules(FolderLocationName parent)
 *           <li>listDescendantSecurityHealthAnalyticsCustomModules(LocationName parent)
 *           <li>listDescendantSecurityHealthAnalyticsCustomModules(OrganizationLocationName parent)
 *           <li>listDescendantSecurityHealthAnalyticsCustomModules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable()
 *           <li>listDescendantSecurityHealthAnalyticsCustomModulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Retrieves a SecurityHealthAnalyticsCustomModule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getSecurityHealthAnalyticsCustomModule(GetSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getSecurityHealthAnalyticsCustomModule(SecurityHealthAnalyticsCustomModuleName name)
 *           <li>getSecurityHealthAnalyticsCustomModule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getSecurityHealthAnalyticsCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent, and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the given parent. These modules are enabled by default.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createSecurityHealthAnalyticsCustomModule(CreateSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createSecurityHealthAnalyticsCustomModule(FolderLocationName parent, SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule)
 *           <li>createSecurityHealthAnalyticsCustomModule(LocationName parent, SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule)
 *           <li>createSecurityHealthAnalyticsCustomModule(OrganizationLocationName parent, SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule)
 *           <li>createSecurityHealthAnalyticsCustomModule(String parent, SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createSecurityHealthAnalyticsCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update mask. Updating the enablement state is supported on both resident and inherited modules (though resident modules cannot have an enablement state of "inherited"). Updating the display name and custom config of a module is supported on resident modules only.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateSecurityHealthAnalyticsCustomModule(UpdateSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateSecurityHealthAnalyticsCustomModule(SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateSecurityHealthAnalyticsCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM hierarchy. This method is only supported for resident custom modules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteSecurityHealthAnalyticsCustomModule(DeleteSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>deleteSecurityHealthAnalyticsCustomModule(SecurityHealthAnalyticsCustomModuleName name)
 *           <li>deleteSecurityHealthAnalyticsCustomModule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteSecurityHealthAnalyticsCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>SimulateSecurityHealthAnalyticsCustomModule</td>
 *      <td><p> Simulates a given SecurityHealthAnalyticsCustomModule and Resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>simulateSecurityHealthAnalyticsCustomModule(SimulateSecurityHealthAnalyticsCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>simulateSecurityHealthAnalyticsCustomModule(String parent, CustomConfig customConfig, SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>simulateSecurityHealthAnalyticsCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListEffectiveEventThreatDetectionCustomModules</td>
 *      <td><p> Lists all effective Event Threat Detection custom modules for the given parent. This includes resident modules defined at the scope of the parent along with modules inherited from its ancestors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listEffectiveEventThreatDetectionCustomModules(ListEffectiveEventThreatDetectionCustomModulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listEffectiveEventThreatDetectionCustomModules(FolderLocationName parent)
 *           <li>listEffectiveEventThreatDetectionCustomModules(LocationName parent)
 *           <li>listEffectiveEventThreatDetectionCustomModules(OrganizationLocationName parent)
 *           <li>listEffectiveEventThreatDetectionCustomModules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listEffectiveEventThreatDetectionCustomModulesPagedCallable()
 *           <li>listEffectiveEventThreatDetectionCustomModulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetEffectiveEventThreatDetectionCustomModule</td>
 *      <td><p> Gets an effective ETD custom module. Retrieves the effective module at the given level. The difference between an EffectiveCustomModule and a CustomModule is that the fields for an EffectiveCustomModule are computed from ancestors if needed. For example, the enablement_state for a CustomModule can be either ENABLED, DISABLED, or INHERITED. Where as the enablement_state for an EffectiveCustomModule is always computed to ENABLED or DISABLED (the effective enablement_state).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getEffectiveEventThreatDetectionCustomModule(GetEffectiveEventThreatDetectionCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getEffectiveEventThreatDetectionCustomModule(EffectiveEventThreatDetectionCustomModuleName name)
 *           <li>getEffectiveEventThreatDetectionCustomModule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getEffectiveEventThreatDetectionCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListEventThreatDetectionCustomModules</td>
 *      <td><p> Lists all Event Threat Detection custom modules for the given Resource Manager parent. This includes resident modules defined at the scope of the parent along with modules inherited from ancestors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listEventThreatDetectionCustomModules(ListEventThreatDetectionCustomModulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listEventThreatDetectionCustomModules(FolderLocationName parent)
 *           <li>listEventThreatDetectionCustomModules(LocationName parent)
 *           <li>listEventThreatDetectionCustomModules(OrganizationLocationName parent)
 *           <li>listEventThreatDetectionCustomModules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listEventThreatDetectionCustomModulesPagedCallable()
 *           <li>listEventThreatDetectionCustomModulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListDescendantEventThreatDetectionCustomModules</td>
 *      <td><p> Lists all resident Event Threat Detection custom modules under the given Resource Manager parent and its descendants.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listDescendantEventThreatDetectionCustomModules(ListDescendantEventThreatDetectionCustomModulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listDescendantEventThreatDetectionCustomModules(FolderLocationName parent)
 *           <li>listDescendantEventThreatDetectionCustomModules(LocationName parent)
 *           <li>listDescendantEventThreatDetectionCustomModules(OrganizationLocationName parent)
 *           <li>listDescendantEventThreatDetectionCustomModules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listDescendantEventThreatDetectionCustomModulesPagedCallable()
 *           <li>listDescendantEventThreatDetectionCustomModulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetEventThreatDetectionCustomModule</td>
 *      <td><p> Gets an Event Threat Detection custom module.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getEventThreatDetectionCustomModule(GetEventThreatDetectionCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getEventThreatDetectionCustomModule(EventThreatDetectionCustomModuleName name)
 *           <li>getEventThreatDetectionCustomModule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getEventThreatDetectionCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateEventThreatDetectionCustomModule</td>
 *      <td><p> Creates a resident Event Threat Detection custom module at the scope of the given Resource Manager parent, and also creates inherited custom modules for all descendants of the given parent. These modules are enabled by default.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createEventThreatDetectionCustomModule(CreateEventThreatDetectionCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>createEventThreatDetectionCustomModule(FolderLocationName parent, EventThreatDetectionCustomModule eventThreatDetectionCustomModule)
 *           <li>createEventThreatDetectionCustomModule(LocationName parent, EventThreatDetectionCustomModule eventThreatDetectionCustomModule)
 *           <li>createEventThreatDetectionCustomModule(OrganizationLocationName parent, EventThreatDetectionCustomModule eventThreatDetectionCustomModule)
 *           <li>createEventThreatDetectionCustomModule(String parent, EventThreatDetectionCustomModule eventThreatDetectionCustomModule)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createEventThreatDetectionCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateEventThreatDetectionCustomModule</td>
 *      <td><p> Updates the Event Threat Detection custom module with the given name based on the given update mask. Updating the enablement state is supported for both resident and inherited modules (though resident modules cannot have an enablement state of "inherited"). Updating the display name or configuration of a module is supported for resident modules only. The type of a module cannot be changed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateEventThreatDetectionCustomModule(UpdateEventThreatDetectionCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>updateEventThreatDetectionCustomModule(EventThreatDetectionCustomModule eventThreatDetectionCustomModule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateEventThreatDetectionCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteEventThreatDetectionCustomModule</td>
 *      <td><p> Deletes the specified Event Threat Detection custom module and all of its descendants in the Resource Manager hierarchy. This method is only supported for resident custom modules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteEventThreatDetectionCustomModule(DeleteEventThreatDetectionCustomModuleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>deleteEventThreatDetectionCustomModule(EventThreatDetectionCustomModuleName name)
 *           <li>deleteEventThreatDetectionCustomModule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteEventThreatDetectionCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ValidateEventThreatDetectionCustomModule</td>
 *      <td><p> Validates the given Event Threat Detection custom module.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>validateEventThreatDetectionCustomModule(ValidateEventThreatDetectionCustomModuleRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>validateEventThreatDetectionCustomModuleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listLocationsPagedCallable()
 *           <li>listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of
 * SecurityCenterManagementSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityCenterManagementSettings securityCenterManagementSettings =
 *     SecurityCenterManagementSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * SecurityCenterManagementClient securityCenterManagementClient =
 *     SecurityCenterManagementClient.create(securityCenterManagementSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityCenterManagementSettings securityCenterManagementSettings =
 *     SecurityCenterManagementSettings.newBuilder().setEndpoint(myEndpoint).build();
 * SecurityCenterManagementClient securityCenterManagementClient =
 *     SecurityCenterManagementClient.create(securityCenterManagementSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecurityCenterManagementSettings securityCenterManagementSettings =
 *     SecurityCenterManagementSettings.newHttpJsonBuilder().build();
 * SecurityCenterManagementClient securityCenterManagementClient =
 *     SecurityCenterManagementClient.create(securityCenterManagementSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class SecurityCenterManagementClient implements BackgroundResource {
  private final SecurityCenterManagementSettings settings;
  private final SecurityCenterManagementStub stub;

  /** Constructs an instance of SecurityCenterManagementClient with default settings. */
  public static final SecurityCenterManagementClient create() throws IOException {
    return create(SecurityCenterManagementSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of SecurityCenterManagementClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final SecurityCenterManagementClient create(
      SecurityCenterManagementSettings settings) throws IOException {
    return new SecurityCenterManagementClient(settings);
  }

  /**
   * Constructs an instance of SecurityCenterManagementClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(SecurityCenterManagementSettings).
   */
  public static final SecurityCenterManagementClient create(SecurityCenterManagementStub stub) {
    return new SecurityCenterManagementClient(stub);
  }

  /**
   * Constructs an instance of SecurityCenterManagementClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected SecurityCenterManagementClient(SecurityCenterManagementSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((SecurityCenterManagementStubSettings) settings.getStubSettings()).createStub();
  }

  protected SecurityCenterManagementClient(SecurityCenterManagementStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SecurityCenterManagementSettings getSettings() {
    return settings;
  }

  public SecurityCenterManagementStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (EffectiveSecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listEffectiveSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list effective custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse
      listEffectiveSecurityHealthAnalyticsCustomModules(FolderLocationName parent) {
    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
        ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEffectiveSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EffectiveSecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listEffectiveSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list effective custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse
      listEffectiveSecurityHealthAnalyticsCustomModules(LocationName parent) {
    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
        ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEffectiveSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (EffectiveSecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listEffectiveSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list effective custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse
      listEffectiveSecurityHealthAnalyticsCustomModules(OrganizationLocationName parent) {
    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
        ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEffectiveSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (EffectiveSecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listEffectiveSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list effective custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse
      listEffectiveSecurityHealthAnalyticsCustomModules(String parent) {
    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
        ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent)
            .build();
    return listEffectiveSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (EffectiveSecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listEffectiveSecurityHealthAnalyticsCustomModules(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse
      listEffectiveSecurityHealthAnalyticsCustomModules(
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request) {
    return listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<EffectiveSecurityHealthAnalyticsCustomModule> future =
   *       securityCenterManagementClient
   *           .listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (EffectiveSecurityHealthAnalyticsCustomModule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return stub.listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This
   * includes resident modules defined at the scope of the parent, and inherited modules, inherited
   * from CRM ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListEffectiveSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEffectiveSecurityHealthAnalyticsCustomModulesResponse response =
   *         securityCenterManagementClient
   *             .listEffectiveSecurityHealthAnalyticsCustomModulesCallable()
   *             .call(request);
   *     for (EffectiveSecurityHealthAnalyticsCustomModule element :
   *         response.getEffectiveSecurityHealthAnalyticsCustomModulesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesCallable() {
    return stub.listEffectiveSecurityHealthAnalyticsCustomModulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EffectiveSecurityHealthAnalyticsCustomModule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   EffectiveSecurityHealthAnalyticsCustomModuleName name =
   *       EffectiveSecurityHealthAnalyticsCustomModuleName
   *           .ofProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
   *               "[PROJECT]", "[LOCATION]", "[EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]");
   *   EffectiveSecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.getEffectiveSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the SHA custom module.
   *     <p>Its format is:
   *     <p>&#42;
   *     "organizations/{organization}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{module_id}".
   *     &#42;
   *     "folders/{folder}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{module_id}".
   *     &#42;
   *     "projects/{project}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{module_id}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EffectiveSecurityHealthAnalyticsCustomModule
      getEffectiveSecurityHealthAnalyticsCustomModule(
          EffectiveSecurityHealthAnalyticsCustomModuleName name) {
    GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request =
        GetEffectiveSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEffectiveSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EffectiveSecurityHealthAnalyticsCustomModule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String name =
   *       EffectiveSecurityHealthAnalyticsCustomModuleName
   *           .ofOrganizationLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
   *               "[ORGANIZATION]",
   *               "[LOCATION]",
   *               "[EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
   *           .toString();
   *   EffectiveSecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.getEffectiveSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the SHA custom module.
   *     <p>Its format is:
   *     <p>&#42;
   *     "organizations/{organization}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{module_id}".
   *     &#42;
   *     "folders/{folder}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{module_id}".
   *     &#42;
   *     "projects/{project}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{module_id}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EffectiveSecurityHealthAnalyticsCustomModule
      getEffectiveSecurityHealthAnalyticsCustomModule(String name) {
    GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request =
        GetEffectiveSecurityHealthAnalyticsCustomModuleRequest.newBuilder().setName(name).build();
    return getEffectiveSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EffectiveSecurityHealthAnalyticsCustomModule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request =
   *       GetEffectiveSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               EffectiveSecurityHealthAnalyticsCustomModuleName
   *                   .ofProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   EffectiveSecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.getEffectiveSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EffectiveSecurityHealthAnalyticsCustomModule
      getEffectiveSecurityHealthAnalyticsCustomModule(
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request) {
    return getEffectiveSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EffectiveSecurityHealthAnalyticsCustomModule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request =
   *       GetEffectiveSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               EffectiveSecurityHealthAnalyticsCustomModuleName
   *                   .ofProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EffectiveSecurityHealthAnalyticsCustomModule> future =
   *       securityCenterManagementClient
   *           .getEffectiveSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EffectiveSecurityHealthAnalyticsCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.getEffectiveSecurityHealthAnalyticsCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityHealthAnalyticsCustomModulesPagedResponse
      listSecurityHealthAnalyticsCustomModules(FolderLocationName parent) {
    ListSecurityHealthAnalyticsCustomModulesRequest request =
        ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityHealthAnalyticsCustomModulesPagedResponse
      listSecurityHealthAnalyticsCustomModules(LocationName parent) {
    ListSecurityHealthAnalyticsCustomModulesRequest request =
        ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityHealthAnalyticsCustomModulesPagedResponse
      listSecurityHealthAnalyticsCustomModules(OrganizationLocationName parent) {
    ListSecurityHealthAnalyticsCustomModulesRequest request =
        ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityHealthAnalyticsCustomModulesPagedResponse
      listSecurityHealthAnalyticsCustomModules(String parent) {
    ListSecurityHealthAnalyticsCustomModulesRequest request =
        ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder().setParent(parent).build();
    return listSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listSecurityHealthAnalyticsCustomModules(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSecurityHealthAnalyticsCustomModulesPagedResponse
      listSecurityHealthAnalyticsCustomModules(
          ListSecurityHealthAnalyticsCustomModulesRequest request) {
    return listSecurityHealthAnalyticsCustomModulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SecurityHealthAnalyticsCustomModule> future =
   *       securityCenterManagementClient
   *           .listSecurityHealthAnalyticsCustomModulesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (SecurityHealthAnalyticsCustomModule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      listSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return stub.listSecurityHealthAnalyticsCustomModulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes
   * resident modules defined at the scope of the parent, and inherited modules, inherited from CRM
   * ancestors (no descendants).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSecurityHealthAnalyticsCustomModulesResponse response =
   *         securityCenterManagementClient
   *             .listSecurityHealthAnalyticsCustomModulesCallable()
   *             .call(request);
   *     for (SecurityHealthAnalyticsCustomModule element :
   *         response.getSecurityHealthAnalyticsCustomModulesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse>
      listSecurityHealthAnalyticsCustomModulesCallable() {
    return stub.listSecurityHealthAnalyticsCustomModulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listDescendantSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse
      listDescendantSecurityHealthAnalyticsCustomModules(FolderLocationName parent) {
    ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
        ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDescendantSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listDescendantSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse
      listDescendantSecurityHealthAnalyticsCustomModules(LocationName parent) {
    ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
        ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDescendantSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listDescendantSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse
      listDescendantSecurityHealthAnalyticsCustomModules(OrganizationLocationName parent) {
    ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
        ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDescendantSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listDescendantSecurityHealthAnalyticsCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse
      listDescendantSecurityHealthAnalyticsCustomModules(String parent) {
    ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
        ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
            .setParent(parent)
            .build();
    return listDescendantSecurityHealthAnalyticsCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SecurityHealthAnalyticsCustomModule element :
   *       securityCenterManagementClient
   *           .listDescendantSecurityHealthAnalyticsCustomModules(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse
      listDescendantSecurityHealthAnalyticsCustomModules(
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest request) {
    return listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SecurityHealthAnalyticsCustomModule> future =
   *       securityCenterManagementClient
   *           .listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (SecurityHealthAnalyticsCustomModule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return stub.listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent
   * and all of the parent’s CRM descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListDescendantSecurityHealthAnalyticsCustomModulesRequest request =
   *       ListDescendantSecurityHealthAnalyticsCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDescendantSecurityHealthAnalyticsCustomModulesResponse response =
   *         securityCenterManagementClient
   *             .listDescendantSecurityHealthAnalyticsCustomModulesCallable()
   *             .call(request);
   *     for (SecurityHealthAnalyticsCustomModule element :
   *         response.getSecurityHealthAnalyticsCustomModulesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesCallable() {
    return stub.listDescendantSecurityHealthAnalyticsCustomModulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a SecurityHealthAnalyticsCustomModule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   SecurityHealthAnalyticsCustomModuleName name =
   *       SecurityHealthAnalyticsCustomModuleName
   *           .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
   *               "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]");
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.getSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule getSecurityHealthAnalyticsCustomModule(
      SecurityHealthAnalyticsCustomModuleName name) {
    GetSecurityHealthAnalyticsCustomModuleRequest request =
        GetSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a SecurityHealthAnalyticsCustomModule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String name =
   *       SecurityHealthAnalyticsCustomModuleName
   *           .ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
   *               "[ORGANIZATION]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
   *           .toString();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.getSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule getSecurityHealthAnalyticsCustomModule(
      String name) {
    GetSecurityHealthAnalyticsCustomModuleRequest request =
        GetSecurityHealthAnalyticsCustomModuleRequest.newBuilder().setName(name).build();
    return getSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a SecurityHealthAnalyticsCustomModule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   GetSecurityHealthAnalyticsCustomModuleRequest request =
   *       GetSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               SecurityHealthAnalyticsCustomModuleName
   *                   .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
   *                       "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.getSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule getSecurityHealthAnalyticsCustomModule(
      GetSecurityHealthAnalyticsCustomModuleRequest request) {
    return getSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a SecurityHealthAnalyticsCustomModule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   GetSecurityHealthAnalyticsCustomModuleRequest request =
   *       GetSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               SecurityHealthAnalyticsCustomModuleName
   *                   .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
   *                       "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SecurityHealthAnalyticsCustomModule> future =
   *       securityCenterManagementClient
   *           .getSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityHealthAnalyticsCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.getSecurityHealthAnalyticsCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent,
   * and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the
   * given parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
   *       SecurityHealthAnalyticsCustomModule.newBuilder().build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.createSecurityHealthAnalyticsCustomModule(
   *           parent, securityHealthAnalyticsCustomModule);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent for the module. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @param securityHealthAnalyticsCustomModule Required. The resource being created
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule createSecurityHealthAnalyticsCustomModule(
      FolderLocationName parent,
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule) {
    CreateSecurityHealthAnalyticsCustomModuleRequest request =
        CreateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
            .build();
    return createSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent,
   * and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the
   * given parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
   *       SecurityHealthAnalyticsCustomModule.newBuilder().build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.createSecurityHealthAnalyticsCustomModule(
   *           parent, securityHealthAnalyticsCustomModule);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent for the module. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @param securityHealthAnalyticsCustomModule Required. The resource being created
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule createSecurityHealthAnalyticsCustomModule(
      LocationName parent,
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule) {
    CreateSecurityHealthAnalyticsCustomModuleRequest request =
        CreateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
            .build();
    return createSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent,
   * and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the
   * given parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
   *       SecurityHealthAnalyticsCustomModule.newBuilder().build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.createSecurityHealthAnalyticsCustomModule(
   *           parent, securityHealthAnalyticsCustomModule);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent for the module. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @param securityHealthAnalyticsCustomModule Required. The resource being created
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule createSecurityHealthAnalyticsCustomModule(
      OrganizationLocationName parent,
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule) {
    CreateSecurityHealthAnalyticsCustomModuleRequest request =
        CreateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
            .build();
    return createSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent,
   * and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the
   * given parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
   *       SecurityHealthAnalyticsCustomModule.newBuilder().build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.createSecurityHealthAnalyticsCustomModule(
   *           parent, securityHealthAnalyticsCustomModule);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the parent for the module. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @param securityHealthAnalyticsCustomModule Required. The resource being created
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule createSecurityHealthAnalyticsCustomModule(
      String parent, SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule) {
    CreateSecurityHealthAnalyticsCustomModuleRequest request =
        CreateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setParent(parent)
            .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
            .build();
    return createSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent,
   * and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the
   * given parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   CreateSecurityHealthAnalyticsCustomModuleRequest request =
   *       CreateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setSecurityHealthAnalyticsCustomModule(
   *               SecurityHealthAnalyticsCustomModule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.createSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule createSecurityHealthAnalyticsCustomModule(
      CreateSecurityHealthAnalyticsCustomModuleRequest request) {
    return createSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent,
   * and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the
   * given parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   CreateSecurityHealthAnalyticsCustomModuleRequest request =
   *       CreateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setSecurityHealthAnalyticsCustomModule(
   *               SecurityHealthAnalyticsCustomModule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<SecurityHealthAnalyticsCustomModule> future =
   *       securityCenterManagementClient
   *           .createSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityHealthAnalyticsCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.createSecurityHealthAnalyticsCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update
   * mask. Updating the enablement state is supported on both resident and inherited modules (though
   * resident modules cannot have an enablement state of "inherited"). Updating the display name and
   * custom config of a module is supported on resident modules only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule =
   *       SecurityHealthAnalyticsCustomModule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.updateSecurityHealthAnalyticsCustomModule(
   *           securityHealthAnalyticsCustomModule, updateMask);
   * }
   * }</pre>
   *
   * @param securityHealthAnalyticsCustomModule Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     SecurityHealthAnalyticsCustomModule resource by the update. The fields specified in the
   *     update_mask are relative to the resource, not the full request. A field will be overwritten
   *     if it is in the mask. If the user does not provide a mask then all fields will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule updateSecurityHealthAnalyticsCustomModule(
      SecurityHealthAnalyticsCustomModule securityHealthAnalyticsCustomModule,
      FieldMask updateMask) {
    UpdateSecurityHealthAnalyticsCustomModuleRequest request =
        UpdateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
            .setUpdateMask(updateMask)
            .build();
    return updateSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update
   * mask. Updating the enablement state is supported on both resident and inherited modules (though
   * resident modules cannot have an enablement state of "inherited"). Updating the display name and
   * custom config of a module is supported on resident modules only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   UpdateSecurityHealthAnalyticsCustomModuleRequest request =
   *       UpdateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSecurityHealthAnalyticsCustomModule(
   *               SecurityHealthAnalyticsCustomModule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   SecurityHealthAnalyticsCustomModule response =
   *       securityCenterManagementClient.updateSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SecurityHealthAnalyticsCustomModule updateSecurityHealthAnalyticsCustomModule(
      UpdateSecurityHealthAnalyticsCustomModuleRequest request) {
    return updateSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update
   * mask. Updating the enablement state is supported on both resident and inherited modules (though
   * resident modules cannot have an enablement state of "inherited"). Updating the display name and
   * custom config of a module is supported on resident modules only.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   UpdateSecurityHealthAnalyticsCustomModuleRequest request =
   *       UpdateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSecurityHealthAnalyticsCustomModule(
   *               SecurityHealthAnalyticsCustomModule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<SecurityHealthAnalyticsCustomModule> future =
   *       securityCenterManagementClient
   *           .updateSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SecurityHealthAnalyticsCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.updateSecurityHealthAnalyticsCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM
   * hierarchy. This method is only supported for resident custom modules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   SecurityHealthAnalyticsCustomModuleName name =
   *       SecurityHealthAnalyticsCustomModuleName
   *           .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
   *               "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]");
   *   securityCenterManagementClient.deleteSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the SHA custom module.
   *     <p>Its format is:
   *     <p>&#42;
   *     "organizations/{organization}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}".
   *     &#42;
   *     "folders/{folder}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}".
   *     &#42;
   *     "projects/{project}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecurityHealthAnalyticsCustomModule(
      SecurityHealthAnalyticsCustomModuleName name) {
    DeleteSecurityHealthAnalyticsCustomModuleRequest request =
        DeleteSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM
   * hierarchy. This method is only supported for resident custom modules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String name =
   *       SecurityHealthAnalyticsCustomModuleName
   *           .ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
   *               "[ORGANIZATION]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
   *           .toString();
   *   securityCenterManagementClient.deleteSecurityHealthAnalyticsCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the SHA custom module.
   *     <p>Its format is:
   *     <p>&#42;
   *     "organizations/{organization}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}".
   *     &#42;
   *     "folders/{folder}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}".
   *     &#42;
   *     "projects/{project}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecurityHealthAnalyticsCustomModule(String name) {
    DeleteSecurityHealthAnalyticsCustomModuleRequest request =
        DeleteSecurityHealthAnalyticsCustomModuleRequest.newBuilder().setName(name).build();
    deleteSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM
   * hierarchy. This method is only supported for resident custom modules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   DeleteSecurityHealthAnalyticsCustomModuleRequest request =
   *       DeleteSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               SecurityHealthAnalyticsCustomModuleName
   *                   .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
   *                       "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .build();
   *   securityCenterManagementClient.deleteSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSecurityHealthAnalyticsCustomModule(
      DeleteSecurityHealthAnalyticsCustomModuleRequest request) {
    deleteSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM
   * hierarchy. This method is only supported for resident custom modules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   DeleteSecurityHealthAnalyticsCustomModuleRequest request =
   *       DeleteSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setName(
   *               SecurityHealthAnalyticsCustomModuleName
   *                   .ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
   *                       "[PROJECT]", "[LOCATION]", "[SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       securityCenterManagementClient
   *           .deleteSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.deleteSecurityHealthAnalyticsCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String parent = "parent-995424086";
   *   CustomConfig customConfig = CustomConfig.newBuilder().build();
   *   SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource resource =
   *       SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource.newBuilder().build();
   *   SimulateSecurityHealthAnalyticsCustomModuleResponse response =
   *       securityCenterManagementClient.simulateSecurityHealthAnalyticsCustomModule(
   *           parent, customConfig, resource);
   * }
   * }</pre>
   *
   * @param parent Required. The relative resource name of the organization, project, or folder. For
   *     more information about relative resource names, see [Relative Resource
   *     Name](https://cloud.google.com/apis/design/resource_names#relative_resource_name) Example:
   *     `organizations/{organization_id}`.
   * @param customConfig Required. The custom configuration that you need to test.
   * @param resource Required. Resource data to simulate custom module against.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SimulateSecurityHealthAnalyticsCustomModuleResponse
      simulateSecurityHealthAnalyticsCustomModule(
          String parent,
          CustomConfig customConfig,
          SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource resource) {
    SimulateSecurityHealthAnalyticsCustomModuleRequest request =
        SimulateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
            .setParent(parent)
            .setCustomConfig(customConfig)
            .setResource(resource)
            .build();
    return simulateSecurityHealthAnalyticsCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   SimulateSecurityHealthAnalyticsCustomModuleRequest request =
   *       SimulateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCustomConfig(CustomConfig.newBuilder().build())
   *           .setResource(
   *               SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource.newBuilder()
   *                   .build())
   *           .build();
   *   SimulateSecurityHealthAnalyticsCustomModuleResponse response =
   *       securityCenterManagementClient.simulateSecurityHealthAnalyticsCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SimulateSecurityHealthAnalyticsCustomModuleResponse
      simulateSecurityHealthAnalyticsCustomModule(
          SimulateSecurityHealthAnalyticsCustomModuleRequest request) {
    return simulateSecurityHealthAnalyticsCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Simulates a given SecurityHealthAnalyticsCustomModule and Resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   SimulateSecurityHealthAnalyticsCustomModuleRequest request =
   *       SimulateSecurityHealthAnalyticsCustomModuleRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setCustomConfig(CustomConfig.newBuilder().build())
   *           .setResource(
   *               SimulateSecurityHealthAnalyticsCustomModuleRequest.SimulatedResource.newBuilder()
   *                   .build())
   *           .build();
   *   ApiFuture<SimulateSecurityHealthAnalyticsCustomModuleResponse> future =
   *       securityCenterManagementClient
   *           .simulateSecurityHealthAnalyticsCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   SimulateSecurityHealthAnalyticsCustomModuleResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleCallable() {
    return stub.simulateSecurityHealthAnalyticsCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all effective Event Threat Detection custom modules for the given parent. This includes
   * resident modules defined at the scope of the parent along with modules inherited from its
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (EffectiveEventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listEffectiveEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list effective custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveEventThreatDetectionCustomModulesPagedResponse
      listEffectiveEventThreatDetectionCustomModules(FolderLocationName parent) {
    ListEffectiveEventThreatDetectionCustomModulesRequest request =
        ListEffectiveEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEffectiveEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all effective Event Threat Detection custom modules for the given parent. This includes
   * resident modules defined at the scope of the parent along with modules inherited from its
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EffectiveEventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listEffectiveEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list effective custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveEventThreatDetectionCustomModulesPagedResponse
      listEffectiveEventThreatDetectionCustomModules(LocationName parent) {
    ListEffectiveEventThreatDetectionCustomModulesRequest request =
        ListEffectiveEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEffectiveEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all effective Event Threat Detection custom modules for the given parent. This includes
   * resident modules defined at the scope of the parent along with modules inherited from its
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (EffectiveEventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listEffectiveEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list effective custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveEventThreatDetectionCustomModulesPagedResponse
      listEffectiveEventThreatDetectionCustomModules(OrganizationLocationName parent) {
    ListEffectiveEventThreatDetectionCustomModulesRequest request =
        ListEffectiveEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEffectiveEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all effective Event Threat Detection custom modules for the given parent. This includes
   * resident modules defined at the scope of the parent along with modules inherited from its
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (EffectiveEventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listEffectiveEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list effective custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveEventThreatDetectionCustomModulesPagedResponse
      listEffectiveEventThreatDetectionCustomModules(String parent) {
    ListEffectiveEventThreatDetectionCustomModulesRequest request =
        ListEffectiveEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent)
            .build();
    return listEffectiveEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all effective Event Threat Detection custom modules for the given parent. This includes
   * resident modules defined at the scope of the parent along with modules inherited from its
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListEffectiveEventThreatDetectionCustomModulesRequest request =
   *       ListEffectiveEventThreatDetectionCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (EffectiveEventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listEffectiveEventThreatDetectionCustomModules(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEffectiveEventThreatDetectionCustomModulesPagedResponse
      listEffectiveEventThreatDetectionCustomModules(
          ListEffectiveEventThreatDetectionCustomModulesRequest request) {
    return listEffectiveEventThreatDetectionCustomModulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all effective Event Threat Detection custom modules for the given parent. This includes
   * resident modules defined at the scope of the parent along with modules inherited from its
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListEffectiveEventThreatDetectionCustomModulesRequest request =
   *       ListEffectiveEventThreatDetectionCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<EffectiveEventThreatDetectionCustomModule> future =
   *       securityCenterManagementClient
   *           .listEffectiveEventThreatDetectionCustomModulesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (EffectiveEventThreatDetectionCustomModule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
      listEffectiveEventThreatDetectionCustomModulesPagedCallable() {
    return stub.listEffectiveEventThreatDetectionCustomModulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all effective Event Threat Detection custom modules for the given parent. This includes
   * resident modules defined at the scope of the parent along with modules inherited from its
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListEffectiveEventThreatDetectionCustomModulesRequest request =
   *       ListEffectiveEventThreatDetectionCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEffectiveEventThreatDetectionCustomModulesResponse response =
   *         securityCenterManagementClient
   *             .listEffectiveEventThreatDetectionCustomModulesCallable()
   *             .call(request);
   *     for (EffectiveEventThreatDetectionCustomModule element :
   *         response.getEffectiveEventThreatDetectionCustomModulesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse>
      listEffectiveEventThreatDetectionCustomModulesCallable() {
    return stub.listEffectiveEventThreatDetectionCustomModulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an effective ETD custom module. Retrieves the effective module at the given level. The
   * difference between an EffectiveCustomModule and a CustomModule is that the fields for an
   * EffectiveCustomModule are computed from ancestors if needed. For example, the enablement_state
   * for a CustomModule can be either ENABLED, DISABLED, or INHERITED. Where as the enablement_state
   * for an EffectiveCustomModule is always computed to ENABLED or DISABLED (the effective
   * enablement_state).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   EffectiveEventThreatDetectionCustomModuleName name =
   *       EffectiveEventThreatDetectionCustomModuleName
   *           .ofProjectLocationEffectiveEventThreatDetectionCustomModuleName(
   *               "[PROJECT]", "[LOCATION]", "[EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE]");
   *   EffectiveEventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.getEffectiveEventThreatDetectionCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ETD custom module.
   *     <p>Its format is:
   *     <p>&#42;
   *     "organizations/{organization}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}".
   *     &#42;
   *     "folders/{folder}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}".
   *     &#42;
   *     "projects/{project}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EffectiveEventThreatDetectionCustomModule
      getEffectiveEventThreatDetectionCustomModule(
          EffectiveEventThreatDetectionCustomModuleName name) {
    GetEffectiveEventThreatDetectionCustomModuleRequest request =
        GetEffectiveEventThreatDetectionCustomModuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEffectiveEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an effective ETD custom module. Retrieves the effective module at the given level. The
   * difference between an EffectiveCustomModule and a CustomModule is that the fields for an
   * EffectiveCustomModule are computed from ancestors if needed. For example, the enablement_state
   * for a CustomModule can be either ENABLED, DISABLED, or INHERITED. Where as the enablement_state
   * for an EffectiveCustomModule is always computed to ENABLED or DISABLED (the effective
   * enablement_state).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String name =
   *       EffectiveEventThreatDetectionCustomModuleName
   *           .ofOrganizationLocationEffectiveEventThreatDetectionCustomModuleName(
   *               "[ORGANIZATION]",
   *               "[LOCATION]",
   *               "[EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
   *           .toString();
   *   EffectiveEventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.getEffectiveEventThreatDetectionCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ETD custom module.
   *     <p>Its format is:
   *     <p>&#42;
   *     "organizations/{organization}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}".
   *     &#42;
   *     "folders/{folder}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}".
   *     &#42;
   *     "projects/{project}/locations/{location}/effectiveEventThreatDetectionCustomModules/{effective_event_threat_detection_custom_module}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EffectiveEventThreatDetectionCustomModule
      getEffectiveEventThreatDetectionCustomModule(String name) {
    GetEffectiveEventThreatDetectionCustomModuleRequest request =
        GetEffectiveEventThreatDetectionCustomModuleRequest.newBuilder().setName(name).build();
    return getEffectiveEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an effective ETD custom module. Retrieves the effective module at the given level. The
   * difference between an EffectiveCustomModule and a CustomModule is that the fields for an
   * EffectiveCustomModule are computed from ancestors if needed. For example, the enablement_state
   * for a CustomModule can be either ENABLED, DISABLED, or INHERITED. Where as the enablement_state
   * for an EffectiveCustomModule is always computed to ENABLED or DISABLED (the effective
   * enablement_state).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   GetEffectiveEventThreatDetectionCustomModuleRequest request =
   *       GetEffectiveEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setName(
   *               EffectiveEventThreatDetectionCustomModuleName
   *                   .ofProjectLocationEffectiveEventThreatDetectionCustomModuleName(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   EffectiveEventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.getEffectiveEventThreatDetectionCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EffectiveEventThreatDetectionCustomModule
      getEffectiveEventThreatDetectionCustomModule(
          GetEffectiveEventThreatDetectionCustomModuleRequest request) {
    return getEffectiveEventThreatDetectionCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an effective ETD custom module. Retrieves the effective module at the given level. The
   * difference between an EffectiveCustomModule and a CustomModule is that the fields for an
   * EffectiveCustomModule are computed from ancestors if needed. For example, the enablement_state
   * for a CustomModule can be either ENABLED, DISABLED, or INHERITED. Where as the enablement_state
   * for an EffectiveCustomModule is always computed to ENABLED or DISABLED (the effective
   * enablement_state).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   GetEffectiveEventThreatDetectionCustomModuleRequest request =
   *       GetEffectiveEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setName(
   *               EffectiveEventThreatDetectionCustomModuleName
   *                   .ofProjectLocationEffectiveEventThreatDetectionCustomModuleName(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EffectiveEventThreatDetectionCustomModule> future =
   *       securityCenterManagementClient
   *           .getEffectiveEventThreatDetectionCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EffectiveEventThreatDetectionCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleCallable() {
    return stub.getEffectiveEventThreatDetectionCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Event Threat Detection custom modules for the given Resource Manager parent. This
   * includes resident modules defined at the scope of the parent along with modules inherited from
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (EventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventThreatDetectionCustomModulesPagedResponse
      listEventThreatDetectionCustomModules(FolderLocationName parent) {
    ListEventThreatDetectionCustomModulesRequest request =
        ListEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Event Threat Detection custom modules for the given Resource Manager parent. This
   * includes resident modules defined at the scope of the parent along with modules inherited from
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventThreatDetectionCustomModulesPagedResponse
      listEventThreatDetectionCustomModules(LocationName parent) {
    ListEventThreatDetectionCustomModulesRequest request =
        ListEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Event Threat Detection custom modules for the given Resource Manager parent. This
   * includes resident modules defined at the scope of the parent along with modules inherited from
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (EventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventThreatDetectionCustomModulesPagedResponse
      listEventThreatDetectionCustomModules(OrganizationLocationName parent) {
    ListEventThreatDetectionCustomModulesRequest request =
        ListEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Event Threat Detection custom modules for the given Resource Manager parent. This
   * includes resident modules defined at the scope of the parent along with modules inherited from
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (EventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventThreatDetectionCustomModulesPagedResponse
      listEventThreatDetectionCustomModules(String parent) {
    ListEventThreatDetectionCustomModulesRequest request =
        ListEventThreatDetectionCustomModulesRequest.newBuilder().setParent(parent).build();
    return listEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Event Threat Detection custom modules for the given Resource Manager parent. This
   * includes resident modules defined at the scope of the parent along with modules inherited from
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListEventThreatDetectionCustomModulesRequest request =
   *       ListEventThreatDetectionCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (EventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listEventThreatDetectionCustomModules(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventThreatDetectionCustomModulesPagedResponse
      listEventThreatDetectionCustomModules(ListEventThreatDetectionCustomModulesRequest request) {
    return listEventThreatDetectionCustomModulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Event Threat Detection custom modules for the given Resource Manager parent. This
   * includes resident modules defined at the scope of the parent along with modules inherited from
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListEventThreatDetectionCustomModulesRequest request =
   *       ListEventThreatDetectionCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<EventThreatDetectionCustomModule> future =
   *       securityCenterManagementClient
   *           .listEventThreatDetectionCustomModulesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (EventThreatDetectionCustomModule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesPagedResponse>
      listEventThreatDetectionCustomModulesPagedCallable() {
    return stub.listEventThreatDetectionCustomModulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Event Threat Detection custom modules for the given Resource Manager parent. This
   * includes resident modules defined at the scope of the parent along with modules inherited from
   * ancestors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListEventThreatDetectionCustomModulesRequest request =
   *       ListEventThreatDetectionCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEventThreatDetectionCustomModulesResponse response =
   *         securityCenterManagementClient
   *             .listEventThreatDetectionCustomModulesCallable()
   *             .call(request);
   *     for (EventThreatDetectionCustomModule element :
   *         response.getEventThreatDetectionCustomModulesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse>
      listEventThreatDetectionCustomModulesCallable() {
    return stub.listEventThreatDetectionCustomModulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all resident Event Threat Detection custom modules under the given Resource Manager
   * parent and its descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   for (EventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listDescendantEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantEventThreatDetectionCustomModulesPagedResponse
      listDescendantEventThreatDetectionCustomModules(FolderLocationName parent) {
    ListDescendantEventThreatDetectionCustomModulesRequest request =
        ListDescendantEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDescendantEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all resident Event Threat Detection custom modules under the given Resource Manager
   * parent and its descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listDescendantEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantEventThreatDetectionCustomModulesPagedResponse
      listDescendantEventThreatDetectionCustomModules(LocationName parent) {
    ListDescendantEventThreatDetectionCustomModulesRequest request =
        ListDescendantEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDescendantEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all resident Event Threat Detection custom modules under the given Resource Manager
   * parent and its descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (EventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listDescendantEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantEventThreatDetectionCustomModulesPagedResponse
      listDescendantEventThreatDetectionCustomModules(OrganizationLocationName parent) {
    ListDescendantEventThreatDetectionCustomModulesRequest request =
        ListDescendantEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDescendantEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all resident Event Threat Detection custom modules under the given Resource Manager
   * parent and its descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (EventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listDescendantEventThreatDetectionCustomModules(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent to list custom modules. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantEventThreatDetectionCustomModulesPagedResponse
      listDescendantEventThreatDetectionCustomModules(String parent) {
    ListDescendantEventThreatDetectionCustomModulesRequest request =
        ListDescendantEventThreatDetectionCustomModulesRequest.newBuilder()
            .setParent(parent)
            .build();
    return listDescendantEventThreatDetectionCustomModules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all resident Event Threat Detection custom modules under the given Resource Manager
   * parent and its descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListDescendantEventThreatDetectionCustomModulesRequest request =
   *       ListDescendantEventThreatDetectionCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (EventThreatDetectionCustomModule element :
   *       securityCenterManagementClient
   *           .listDescendantEventThreatDetectionCustomModules(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDescendantEventThreatDetectionCustomModulesPagedResponse
      listDescendantEventThreatDetectionCustomModules(
          ListDescendantEventThreatDetectionCustomModulesRequest request) {
    return listDescendantEventThreatDetectionCustomModulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all resident Event Threat Detection custom modules under the given Resource Manager
   * parent and its descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListDescendantEventThreatDetectionCustomModulesRequest request =
   *       ListDescendantEventThreatDetectionCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<EventThreatDetectionCustomModule> future =
   *       securityCenterManagementClient
   *           .listDescendantEventThreatDetectionCustomModulesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (EventThreatDetectionCustomModule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesPagedResponse>
      listDescendantEventThreatDetectionCustomModulesPagedCallable() {
    return stub.listDescendantEventThreatDetectionCustomModulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all resident Event Threat Detection custom modules under the given Resource Manager
   * parent and its descendants.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListDescendantEventThreatDetectionCustomModulesRequest request =
   *       ListDescendantEventThreatDetectionCustomModulesRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDescendantEventThreatDetectionCustomModulesResponse response =
   *         securityCenterManagementClient
   *             .listDescendantEventThreatDetectionCustomModulesCallable()
   *             .call(request);
   *     for (EventThreatDetectionCustomModule element :
   *         response.getEventThreatDetectionCustomModulesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse>
      listDescendantEventThreatDetectionCustomModulesCallable() {
    return stub.listDescendantEventThreatDetectionCustomModulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Event Threat Detection custom module.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   EventThreatDetectionCustomModuleName name =
   *       EventThreatDetectionCustomModuleName
   *           .ofProjectLocationEventThreatDetectionCustomModuleName(
   *               "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]");
   *   EventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.getEventThreatDetectionCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ETD custom module.
   *     <p>Its format is:
   *     <p>&#42;
   *     "organizations/{organization}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   *     &#42;
   *     "folders/{folder}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   *     &#42;
   *     "projects/{project}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventThreatDetectionCustomModule getEventThreatDetectionCustomModule(
      EventThreatDetectionCustomModuleName name) {
    GetEventThreatDetectionCustomModuleRequest request =
        GetEventThreatDetectionCustomModuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Event Threat Detection custom module.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String name =
   *       EventThreatDetectionCustomModuleName
   *           .ofOrganizationLocationEventThreatDetectionCustomModuleName(
   *               "[ORGANIZATION]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
   *           .toString();
   *   EventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.getEventThreatDetectionCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ETD custom module.
   *     <p>Its format is:
   *     <p>&#42;
   *     "organizations/{organization}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   *     &#42;
   *     "folders/{folder}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   *     &#42;
   *     "projects/{project}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventThreatDetectionCustomModule getEventThreatDetectionCustomModule(String name) {
    GetEventThreatDetectionCustomModuleRequest request =
        GetEventThreatDetectionCustomModuleRequest.newBuilder().setName(name).build();
    return getEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Event Threat Detection custom module.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   GetEventThreatDetectionCustomModuleRequest request =
   *       GetEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setName(
   *               EventThreatDetectionCustomModuleName
   *                   .ofProjectLocationEventThreatDetectionCustomModuleName(
   *                       "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   EventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.getEventThreatDetectionCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventThreatDetectionCustomModule getEventThreatDetectionCustomModule(
      GetEventThreatDetectionCustomModuleRequest request) {
    return getEventThreatDetectionCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an Event Threat Detection custom module.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   GetEventThreatDetectionCustomModuleRequest request =
   *       GetEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setName(
   *               EventThreatDetectionCustomModuleName
   *                   .ofProjectLocationEventThreatDetectionCustomModuleName(
   *                       "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<EventThreatDetectionCustomModule> future =
   *       securityCenterManagementClient
   *           .getEventThreatDetectionCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EventThreatDetectionCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleCallable() {
    return stub.getEventThreatDetectionCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident Event Threat Detection custom module at the scope of the given Resource
   * Manager parent, and also creates inherited custom modules for all descendants of the given
   * parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
   *   EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
   *       EventThreatDetectionCustomModule.newBuilder().build();
   *   EventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.createEventThreatDetectionCustomModule(
   *           parent, eventThreatDetectionCustomModule);
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent for the module. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @param eventThreatDetectionCustomModule Required. The module to create. The
   *     event_threat_detection_custom_module.name will be ignored and server generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventThreatDetectionCustomModule createEventThreatDetectionCustomModule(
      FolderLocationName parent,
      EventThreatDetectionCustomModule eventThreatDetectionCustomModule) {
    CreateEventThreatDetectionCustomModuleRequest request =
        CreateEventThreatDetectionCustomModuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
            .build();
    return createEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident Event Threat Detection custom module at the scope of the given Resource
   * Manager parent, and also creates inherited custom modules for all descendants of the given
   * parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
   *       EventThreatDetectionCustomModule.newBuilder().build();
   *   EventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.createEventThreatDetectionCustomModule(
   *           parent, eventThreatDetectionCustomModule);
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent for the module. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @param eventThreatDetectionCustomModule Required. The module to create. The
   *     event_threat_detection_custom_module.name will be ignored and server generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventThreatDetectionCustomModule createEventThreatDetectionCustomModule(
      LocationName parent, EventThreatDetectionCustomModule eventThreatDetectionCustomModule) {
    CreateEventThreatDetectionCustomModuleRequest request =
        CreateEventThreatDetectionCustomModuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
            .build();
    return createEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident Event Threat Detection custom module at the scope of the given Resource
   * Manager parent, and also creates inherited custom modules for all descendants of the given
   * parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
   *       EventThreatDetectionCustomModule.newBuilder().build();
   *   EventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.createEventThreatDetectionCustomModule(
   *           parent, eventThreatDetectionCustomModule);
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent for the module. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @param eventThreatDetectionCustomModule Required. The module to create. The
   *     event_threat_detection_custom_module.name will be ignored and server generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventThreatDetectionCustomModule createEventThreatDetectionCustomModule(
      OrganizationLocationName parent,
      EventThreatDetectionCustomModule eventThreatDetectionCustomModule) {
    CreateEventThreatDetectionCustomModuleRequest request =
        CreateEventThreatDetectionCustomModuleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
            .build();
    return createEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident Event Threat Detection custom module at the scope of the given Resource
   * Manager parent, and also creates inherited custom modules for all descendants of the given
   * parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
   *       EventThreatDetectionCustomModule.newBuilder().build();
   *   EventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.createEventThreatDetectionCustomModule(
   *           parent, eventThreatDetectionCustomModule);
   * }
   * }</pre>
   *
   * @param parent Required. Name of parent for the module. Its format is
   *     "organizations/{organization}/locations/{location}",
   *     "folders/{folder}/locations/{location}", or "projects/{project}/locations/{location}"
   * @param eventThreatDetectionCustomModule Required. The module to create. The
   *     event_threat_detection_custom_module.name will be ignored and server generated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventThreatDetectionCustomModule createEventThreatDetectionCustomModule(
      String parent, EventThreatDetectionCustomModule eventThreatDetectionCustomModule) {
    CreateEventThreatDetectionCustomModuleRequest request =
        CreateEventThreatDetectionCustomModuleRequest.newBuilder()
            .setParent(parent)
            .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
            .build();
    return createEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident Event Threat Detection custom module at the scope of the given Resource
   * Manager parent, and also creates inherited custom modules for all descendants of the given
   * parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   CreateEventThreatDetectionCustomModuleRequest request =
   *       CreateEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setEventThreatDetectionCustomModule(
   *               EventThreatDetectionCustomModule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   EventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.createEventThreatDetectionCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventThreatDetectionCustomModule createEventThreatDetectionCustomModule(
      CreateEventThreatDetectionCustomModuleRequest request) {
    return createEventThreatDetectionCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a resident Event Threat Detection custom module at the scope of the given Resource
   * Manager parent, and also creates inherited custom modules for all descendants of the given
   * parent. These modules are enabled by default.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   CreateEventThreatDetectionCustomModuleRequest request =
   *       CreateEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setEventThreatDetectionCustomModule(
   *               EventThreatDetectionCustomModule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<EventThreatDetectionCustomModule> future =
   *       securityCenterManagementClient
   *           .createEventThreatDetectionCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EventThreatDetectionCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleCallable() {
    return stub.createEventThreatDetectionCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Event Threat Detection custom module with the given name based on the given update
   * mask. Updating the enablement state is supported for both resident and inherited modules
   * (though resident modules cannot have an enablement state of "inherited"). Updating the display
   * name or configuration of a module is supported for resident modules only. The type of a module
   * cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   EventThreatDetectionCustomModule eventThreatDetectionCustomModule =
   *       EventThreatDetectionCustomModule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.updateEventThreatDetectionCustomModule(
   *           eventThreatDetectionCustomModule, updateMask);
   * }
   * }</pre>
   *
   * @param eventThreatDetectionCustomModule Required. The module being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     EventThreatDetectionCustomModule resource by the update. The fields specified in the
   *     update_mask are relative to the resource, not the full request. A field will be overwritten
   *     if it is in the mask. If the user does not provide a mask then all fields will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventThreatDetectionCustomModule updateEventThreatDetectionCustomModule(
      EventThreatDetectionCustomModule eventThreatDetectionCustomModule, FieldMask updateMask) {
    UpdateEventThreatDetectionCustomModuleRequest request =
        UpdateEventThreatDetectionCustomModuleRequest.newBuilder()
            .setEventThreatDetectionCustomModule(eventThreatDetectionCustomModule)
            .setUpdateMask(updateMask)
            .build();
    return updateEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Event Threat Detection custom module with the given name based on the given update
   * mask. Updating the enablement state is supported for both resident and inherited modules
   * (though resident modules cannot have an enablement state of "inherited"). Updating the display
   * name or configuration of a module is supported for resident modules only. The type of a module
   * cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   UpdateEventThreatDetectionCustomModuleRequest request =
   *       UpdateEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEventThreatDetectionCustomModule(
   *               EventThreatDetectionCustomModule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   EventThreatDetectionCustomModule response =
   *       securityCenterManagementClient.updateEventThreatDetectionCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EventThreatDetectionCustomModule updateEventThreatDetectionCustomModule(
      UpdateEventThreatDetectionCustomModuleRequest request) {
    return updateEventThreatDetectionCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Event Threat Detection custom module with the given name based on the given update
   * mask. Updating the enablement state is supported for both resident and inherited modules
   * (though resident modules cannot have an enablement state of "inherited"). Updating the display
   * name or configuration of a module is supported for resident modules only. The type of a module
   * cannot be changed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   UpdateEventThreatDetectionCustomModuleRequest request =
   *       UpdateEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEventThreatDetectionCustomModule(
   *               EventThreatDetectionCustomModule.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<EventThreatDetectionCustomModule> future =
   *       securityCenterManagementClient
   *           .updateEventThreatDetectionCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EventThreatDetectionCustomModule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleCallable() {
    return stub.updateEventThreatDetectionCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Event Threat Detection custom module and all of its descendants in the
   * Resource Manager hierarchy. This method is only supported for resident custom modules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   EventThreatDetectionCustomModuleName name =
   *       EventThreatDetectionCustomModuleName
   *           .ofProjectLocationEventThreatDetectionCustomModuleName(
   *               "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]");
   *   securityCenterManagementClient.deleteEventThreatDetectionCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ETD custom module.
   *     <p>Its format is:
   *     <p>&#42;
   *     "organizations/{organization}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   *     &#42;
   *     "folders/{folder}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   *     &#42;
   *     "projects/{project}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEventThreatDetectionCustomModule(
      EventThreatDetectionCustomModuleName name) {
    DeleteEventThreatDetectionCustomModuleRequest request =
        DeleteEventThreatDetectionCustomModuleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Event Threat Detection custom module and all of its descendants in the
   * Resource Manager hierarchy. This method is only supported for resident custom modules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   String name =
   *       EventThreatDetectionCustomModuleName
   *           .ofOrganizationLocationEventThreatDetectionCustomModuleName(
   *               "[ORGANIZATION]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
   *           .toString();
   *   securityCenterManagementClient.deleteEventThreatDetectionCustomModule(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ETD custom module.
   *     <p>Its format is:
   *     <p>&#42;
   *     "organizations/{organization}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   *     &#42;
   *     "folders/{folder}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   *     &#42;
   *     "projects/{project}/locations/{location}/eventThreatDetectionCustomModules/{event_threat_detection_custom_module}".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEventThreatDetectionCustomModule(String name) {
    DeleteEventThreatDetectionCustomModuleRequest request =
        DeleteEventThreatDetectionCustomModuleRequest.newBuilder().setName(name).build();
    deleteEventThreatDetectionCustomModule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Event Threat Detection custom module and all of its descendants in the
   * Resource Manager hierarchy. This method is only supported for resident custom modules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   DeleteEventThreatDetectionCustomModuleRequest request =
   *       DeleteEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setName(
   *               EventThreatDetectionCustomModuleName
   *                   .ofProjectLocationEventThreatDetectionCustomModuleName(
   *                       "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .build();
   *   securityCenterManagementClient.deleteEventThreatDetectionCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEventThreatDetectionCustomModule(
      DeleteEventThreatDetectionCustomModuleRequest request) {
    deleteEventThreatDetectionCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified Event Threat Detection custom module and all of its descendants in the
   * Resource Manager hierarchy. This method is only supported for resident custom modules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   DeleteEventThreatDetectionCustomModuleRequest request =
   *       DeleteEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setName(
   *               EventThreatDetectionCustomModuleName
   *                   .ofProjectLocationEventThreatDetectionCustomModuleName(
   *                       "[PROJECT]", "[LOCATION]", "[EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
   *                   .toString())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       securityCenterManagementClient
   *           .deleteEventThreatDetectionCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleCallable() {
    return stub.deleteEventThreatDetectionCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates the given Event Threat Detection custom module.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ValidateEventThreatDetectionCustomModuleRequest request =
   *       ValidateEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setRawText("rawText985734517")
   *           .setType("type3575610")
   *           .build();
   *   ValidateEventThreatDetectionCustomModuleResponse response =
   *       securityCenterManagementClient.validateEventThreatDetectionCustomModule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ValidateEventThreatDetectionCustomModuleResponse
      validateEventThreatDetectionCustomModule(
          ValidateEventThreatDetectionCustomModuleRequest request) {
    return validateEventThreatDetectionCustomModuleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates the given Event Threat Detection custom module.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ValidateEventThreatDetectionCustomModuleRequest request =
   *       ValidateEventThreatDetectionCustomModuleRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setRawText("rawText985734517")
   *           .setType("type3575610")
   *           .build();
   *   ApiFuture<ValidateEventThreatDetectionCustomModuleResponse> future =
   *       securityCenterManagementClient
   *           .validateEventThreatDetectionCustomModuleCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ValidateEventThreatDetectionCustomModuleResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleCallable() {
    return stub.validateEventThreatDetectionCustomModuleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : securityCenterManagementClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       securityCenterManagementClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         securityCenterManagementClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = securityCenterManagementClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (SecurityCenterManagementClient securityCenterManagementClient =
   *     SecurityCenterManagementClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       securityCenterManagementClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse
      extends AbstractPagedListResponse<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          EffectiveSecurityHealthAnalyticsCustomModule,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPage,
          ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    public static ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
        createAsync(
            PageContext<
                    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                    ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
                    EffectiveSecurityHealthAnalyticsCustomModule>
                context,
            ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesPage> futurePage =
          ListEffectiveSecurityHealthAnalyticsCustomModulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse(
        ListEffectiveSecurityHealthAnalyticsCustomModulesPage page) {
      super(
          page,
          ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection
              .createEmptyCollection());
    }
  }

  public static class ListEffectiveSecurityHealthAnalyticsCustomModulesPage
      extends AbstractPage<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          EffectiveSecurityHealthAnalyticsCustomModule,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPage> {

    private ListEffectiveSecurityHealthAnalyticsCustomModulesPage(
        PageContext<
                ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
                EffectiveSecurityHealthAnalyticsCustomModule>
            context,
        ListEffectiveSecurityHealthAnalyticsCustomModulesResponse response) {
      super(context, response);
    }

    private static ListEffectiveSecurityHealthAnalyticsCustomModulesPage createEmptyPage() {
      return new ListEffectiveSecurityHealthAnalyticsCustomModulesPage(null, null);
    }

    @Override
    protected ListEffectiveSecurityHealthAnalyticsCustomModulesPage createPage(
        PageContext<
                ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
                EffectiveSecurityHealthAnalyticsCustomModule>
            context,
        ListEffectiveSecurityHealthAnalyticsCustomModulesResponse response) {
      return new ListEffectiveSecurityHealthAnalyticsCustomModulesPage(context, response);
    }

    @Override
    public ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesPage> createPageAsync(
        PageContext<
                ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
                EffectiveSecurityHealthAnalyticsCustomModule>
            context,
        ApiFuture<ListEffectiveSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse,
          EffectiveSecurityHealthAnalyticsCustomModule,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPage,
          ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    private ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection(
        List<ListEffectiveSecurityHealthAnalyticsCustomModulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection
        createEmptyCollection() {
      return new ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection createCollection(
        List<ListEffectiveSecurityHealthAnalyticsCustomModulesPage> pages, int collectionSize) {
      return new ListEffectiveSecurityHealthAnalyticsCustomModulesFixedSizeCollection(
          pages, collectionSize);
    }
  }

  public static class ListSecurityHealthAnalyticsCustomModulesPagedResponse
      extends AbstractPagedListResponse<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListSecurityHealthAnalyticsCustomModulesPage,
          ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    public static ApiFuture<ListSecurityHealthAnalyticsCustomModulesPagedResponse> createAsync(
        PageContext<
                ListSecurityHealthAnalyticsCustomModulesRequest,
                ListSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ApiFuture<ListSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      ApiFuture<ListSecurityHealthAnalyticsCustomModulesPage> futurePage =
          ListSecurityHealthAnalyticsCustomModulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSecurityHealthAnalyticsCustomModulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSecurityHealthAnalyticsCustomModulesPagedResponse(
        ListSecurityHealthAnalyticsCustomModulesPage page) {
      super(
          page,
          ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSecurityHealthAnalyticsCustomModulesPage
      extends AbstractPage<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListSecurityHealthAnalyticsCustomModulesPage> {

    private ListSecurityHealthAnalyticsCustomModulesPage(
        PageContext<
                ListSecurityHealthAnalyticsCustomModulesRequest,
                ListSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ListSecurityHealthAnalyticsCustomModulesResponse response) {
      super(context, response);
    }

    private static ListSecurityHealthAnalyticsCustomModulesPage createEmptyPage() {
      return new ListSecurityHealthAnalyticsCustomModulesPage(null, null);
    }

    @Override
    protected ListSecurityHealthAnalyticsCustomModulesPage createPage(
        PageContext<
                ListSecurityHealthAnalyticsCustomModulesRequest,
                ListSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ListSecurityHealthAnalyticsCustomModulesResponse response) {
      return new ListSecurityHealthAnalyticsCustomModulesPage(context, response);
    }

    @Override
    public ApiFuture<ListSecurityHealthAnalyticsCustomModulesPage> createPageAsync(
        PageContext<
                ListSecurityHealthAnalyticsCustomModulesRequest,
                ListSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ApiFuture<ListSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListSecurityHealthAnalyticsCustomModulesPage,
          ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    private ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection(
        List<ListSecurityHealthAnalyticsCustomModulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection
        createEmptyCollection() {
      return new ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection createCollection(
        List<ListSecurityHealthAnalyticsCustomModulesPage> pages, int collectionSize) {
      return new ListSecurityHealthAnalyticsCustomModulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse
      extends AbstractPagedListResponse<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListDescendantSecurityHealthAnalyticsCustomModulesPage,
          ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    public static ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
        createAsync(
            PageContext<
                    ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                    ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
                    SecurityHealthAnalyticsCustomModule>
                context,
            ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesPage> futurePage =
          ListDescendantSecurityHealthAnalyticsCustomModulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse(
        ListDescendantSecurityHealthAnalyticsCustomModulesPage page) {
      super(
          page,
          ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection
              .createEmptyCollection());
    }
  }

  public static class ListDescendantSecurityHealthAnalyticsCustomModulesPage
      extends AbstractPage<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListDescendantSecurityHealthAnalyticsCustomModulesPage> {

    private ListDescendantSecurityHealthAnalyticsCustomModulesPage(
        PageContext<
                ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ListDescendantSecurityHealthAnalyticsCustomModulesResponse response) {
      super(context, response);
    }

    private static ListDescendantSecurityHealthAnalyticsCustomModulesPage createEmptyPage() {
      return new ListDescendantSecurityHealthAnalyticsCustomModulesPage(null, null);
    }

    @Override
    protected ListDescendantSecurityHealthAnalyticsCustomModulesPage createPage(
        PageContext<
                ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ListDescendantSecurityHealthAnalyticsCustomModulesResponse response) {
      return new ListDescendantSecurityHealthAnalyticsCustomModulesPage(context, response);
    }

    @Override
    public ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesPage> createPageAsync(
        PageContext<
                ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
                SecurityHealthAnalyticsCustomModule>
            context,
        ApiFuture<ListDescendantSecurityHealthAnalyticsCustomModulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse,
          SecurityHealthAnalyticsCustomModule,
          ListDescendantSecurityHealthAnalyticsCustomModulesPage,
          ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection> {

    private ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection(
        List<ListDescendantSecurityHealthAnalyticsCustomModulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection
        createEmptyCollection() {
      return new ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection
        createCollection(
            List<ListDescendantSecurityHealthAnalyticsCustomModulesPage> pages,
            int collectionSize) {
      return new ListDescendantSecurityHealthAnalyticsCustomModulesFixedSizeCollection(
          pages, collectionSize);
    }
  }

  public static class ListEffectiveEventThreatDetectionCustomModulesPagedResponse
      extends AbstractPagedListResponse<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse,
          EffectiveEventThreatDetectionCustomModule,
          ListEffectiveEventThreatDetectionCustomModulesPage,
          ListEffectiveEventThreatDetectionCustomModulesFixedSizeCollection> {

    public static ApiFuture<ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
        createAsync(
            PageContext<
                    ListEffectiveEventThreatDetectionCustomModulesRequest,
                    ListEffectiveEventThreatDetectionCustomModulesResponse,
                    EffectiveEventThreatDetectionCustomModule>
                context,
            ApiFuture<ListEffectiveEventThreatDetectionCustomModulesResponse> futureResponse) {
      ApiFuture<ListEffectiveEventThreatDetectionCustomModulesPage> futurePage =
          ListEffectiveEventThreatDetectionCustomModulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEffectiveEventThreatDetectionCustomModulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEffectiveEventThreatDetectionCustomModulesPagedResponse(
        ListEffectiveEventThreatDetectionCustomModulesPage page) {
      super(
          page,
          ListEffectiveEventThreatDetectionCustomModulesFixedSizeCollection
              .createEmptyCollection());
    }
  }

  public static class ListEffectiveEventThreatDetectionCustomModulesPage
      extends AbstractPage<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse,
          EffectiveEventThreatDetectionCustomModule,
          ListEffectiveEventThreatDetectionCustomModulesPage> {

    private ListEffectiveEventThreatDetectionCustomModulesPage(
        PageContext<
                ListEffectiveEventThreatDetectionCustomModulesRequest,
                ListEffectiveEventThreatDetectionCustomModulesResponse,
                EffectiveEventThreatDetectionCustomModule>
            context,
        ListEffectiveEventThreatDetectionCustomModulesResponse response) {
      super(context, response);
    }

    private static ListEffectiveEventThreatDetectionCustomModulesPage createEmptyPage() {
      return new ListEffectiveEventThreatDetectionCustomModulesPage(null, null);
    }

    @Override
    protected ListEffectiveEventThreatDetectionCustomModulesPage createPage(
        PageContext<
                ListEffectiveEventThreatDetectionCustomModulesRequest,
                ListEffectiveEventThreatDetectionCustomModulesResponse,
                EffectiveEventThreatDetectionCustomModule>
            context,
        ListEffectiveEventThreatDetectionCustomModulesResponse response) {
      return new ListEffectiveEventThreatDetectionCustomModulesPage(context, response);
    }

    @Override
    public ApiFuture<ListEffectiveEventThreatDetectionCustomModulesPage> createPageAsync(
        PageContext<
                ListEffectiveEventThreatDetectionCustomModulesRequest,
                ListEffectiveEventThreatDetectionCustomModulesResponse,
                EffectiveEventThreatDetectionCustomModule>
            context,
        ApiFuture<ListEffectiveEventThreatDetectionCustomModulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEffectiveEventThreatDetectionCustomModulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse,
          EffectiveEventThreatDetectionCustomModule,
          ListEffectiveEventThreatDetectionCustomModulesPage,
          ListEffectiveEventThreatDetectionCustomModulesFixedSizeCollection> {

    private ListEffectiveEventThreatDetectionCustomModulesFixedSizeCollection(
        List<ListEffectiveEventThreatDetectionCustomModulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEffectiveEventThreatDetectionCustomModulesFixedSizeCollection
        createEmptyCollection() {
      return new ListEffectiveEventThreatDetectionCustomModulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEffectiveEventThreatDetectionCustomModulesFixedSizeCollection createCollection(
        List<ListEffectiveEventThreatDetectionCustomModulesPage> pages, int collectionSize) {
      return new ListEffectiveEventThreatDetectionCustomModulesFixedSizeCollection(
          pages, collectionSize);
    }
  }

  public static class ListEventThreatDetectionCustomModulesPagedResponse
      extends AbstractPagedListResponse<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse,
          EventThreatDetectionCustomModule,
          ListEventThreatDetectionCustomModulesPage,
          ListEventThreatDetectionCustomModulesFixedSizeCollection> {

    public static ApiFuture<ListEventThreatDetectionCustomModulesPagedResponse> createAsync(
        PageContext<
                ListEventThreatDetectionCustomModulesRequest,
                ListEventThreatDetectionCustomModulesResponse,
                EventThreatDetectionCustomModule>
            context,
        ApiFuture<ListEventThreatDetectionCustomModulesResponse> futureResponse) {
      ApiFuture<ListEventThreatDetectionCustomModulesPage> futurePage =
          ListEventThreatDetectionCustomModulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEventThreatDetectionCustomModulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEventThreatDetectionCustomModulesPagedResponse(
        ListEventThreatDetectionCustomModulesPage page) {
      super(page, ListEventThreatDetectionCustomModulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEventThreatDetectionCustomModulesPage
      extends AbstractPage<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse,
          EventThreatDetectionCustomModule,
          ListEventThreatDetectionCustomModulesPage> {

    private ListEventThreatDetectionCustomModulesPage(
        PageContext<
                ListEventThreatDetectionCustomModulesRequest,
                ListEventThreatDetectionCustomModulesResponse,
                EventThreatDetectionCustomModule>
            context,
        ListEventThreatDetectionCustomModulesResponse response) {
      super(context, response);
    }

    private static ListEventThreatDetectionCustomModulesPage createEmptyPage() {
      return new ListEventThreatDetectionCustomModulesPage(null, null);
    }

    @Override
    protected ListEventThreatDetectionCustomModulesPage createPage(
        PageContext<
                ListEventThreatDetectionCustomModulesRequest,
                ListEventThreatDetectionCustomModulesResponse,
                EventThreatDetectionCustomModule>
            context,
        ListEventThreatDetectionCustomModulesResponse response) {
      return new ListEventThreatDetectionCustomModulesPage(context, response);
    }

    @Override
    public ApiFuture<ListEventThreatDetectionCustomModulesPage> createPageAsync(
        PageContext<
                ListEventThreatDetectionCustomModulesRequest,
                ListEventThreatDetectionCustomModulesResponse,
                EventThreatDetectionCustomModule>
            context,
        ApiFuture<ListEventThreatDetectionCustomModulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEventThreatDetectionCustomModulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse,
          EventThreatDetectionCustomModule,
          ListEventThreatDetectionCustomModulesPage,
          ListEventThreatDetectionCustomModulesFixedSizeCollection> {

    private ListEventThreatDetectionCustomModulesFixedSizeCollection(
        List<ListEventThreatDetectionCustomModulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEventThreatDetectionCustomModulesFixedSizeCollection
        createEmptyCollection() {
      return new ListEventThreatDetectionCustomModulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEventThreatDetectionCustomModulesFixedSizeCollection createCollection(
        List<ListEventThreatDetectionCustomModulesPage> pages, int collectionSize) {
      return new ListEventThreatDetectionCustomModulesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDescendantEventThreatDetectionCustomModulesPagedResponse
      extends AbstractPagedListResponse<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse,
          EventThreatDetectionCustomModule,
          ListDescendantEventThreatDetectionCustomModulesPage,
          ListDescendantEventThreatDetectionCustomModulesFixedSizeCollection> {

    public static ApiFuture<ListDescendantEventThreatDetectionCustomModulesPagedResponse>
        createAsync(
            PageContext<
                    ListDescendantEventThreatDetectionCustomModulesRequest,
                    ListDescendantEventThreatDetectionCustomModulesResponse,
                    EventThreatDetectionCustomModule>
                context,
            ApiFuture<ListDescendantEventThreatDetectionCustomModulesResponse> futureResponse) {
      ApiFuture<ListDescendantEventThreatDetectionCustomModulesPage> futurePage =
          ListDescendantEventThreatDetectionCustomModulesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDescendantEventThreatDetectionCustomModulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDescendantEventThreatDetectionCustomModulesPagedResponse(
        ListDescendantEventThreatDetectionCustomModulesPage page) {
      super(
          page,
          ListDescendantEventThreatDetectionCustomModulesFixedSizeCollection
              .createEmptyCollection());
    }
  }

  public static class ListDescendantEventThreatDetectionCustomModulesPage
      extends AbstractPage<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse,
          EventThreatDetectionCustomModule,
          ListDescendantEventThreatDetectionCustomModulesPage> {

    private ListDescendantEventThreatDetectionCustomModulesPage(
        PageContext<
                ListDescendantEventThreatDetectionCustomModulesRequest,
                ListDescendantEventThreatDetectionCustomModulesResponse,
                EventThreatDetectionCustomModule>
            context,
        ListDescendantEventThreatDetectionCustomModulesResponse response) {
      super(context, response);
    }

    private static ListDescendantEventThreatDetectionCustomModulesPage createEmptyPage() {
      return new ListDescendantEventThreatDetectionCustomModulesPage(null, null);
    }

    @Override
    protected ListDescendantEventThreatDetectionCustomModulesPage createPage(
        PageContext<
                ListDescendantEventThreatDetectionCustomModulesRequest,
                ListDescendantEventThreatDetectionCustomModulesResponse,
                EventThreatDetectionCustomModule>
            context,
        ListDescendantEventThreatDetectionCustomModulesResponse response) {
      return new ListDescendantEventThreatDetectionCustomModulesPage(context, response);
    }

    @Override
    public ApiFuture<ListDescendantEventThreatDetectionCustomModulesPage> createPageAsync(
        PageContext<
                ListDescendantEventThreatDetectionCustomModulesRequest,
                ListDescendantEventThreatDetectionCustomModulesResponse,
                EventThreatDetectionCustomModule>
            context,
        ApiFuture<ListDescendantEventThreatDetectionCustomModulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDescendantEventThreatDetectionCustomModulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse,
          EventThreatDetectionCustomModule,
          ListDescendantEventThreatDetectionCustomModulesPage,
          ListDescendantEventThreatDetectionCustomModulesFixedSizeCollection> {

    private ListDescendantEventThreatDetectionCustomModulesFixedSizeCollection(
        List<ListDescendantEventThreatDetectionCustomModulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDescendantEventThreatDetectionCustomModulesFixedSizeCollection
        createEmptyCollection() {
      return new ListDescendantEventThreatDetectionCustomModulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDescendantEventThreatDetectionCustomModulesFixedSizeCollection createCollection(
        List<ListDescendantEventThreatDetectionCustomModulesPage> pages, int collectionSize) {
      return new ListDescendantEventThreatDetectionCustomModulesFixedSizeCollection(
          pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
