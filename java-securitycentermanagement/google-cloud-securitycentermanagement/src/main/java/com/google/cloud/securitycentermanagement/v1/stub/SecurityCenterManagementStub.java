/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.securitycentermanagement.v1.stub;

import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListDescendantEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEffectiveEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListSecurityCenterServicesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListSecurityHealthAnalyticsCustomModulesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securitycentermanagement.v1.CreateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.CreateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.DeleteEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.DeleteSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModule;
import com.google.cloud.securitycentermanagement.v1.EffectiveSecurityHealthAnalyticsCustomModule;
import com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule;
import com.google.cloud.securitycentermanagement.v1.GetEffectiveEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.GetEffectiveSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.GetSecurityCenterServiceRequest;
import com.google.cloud.securitycentermanagement.v1.GetSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ListDescendantEventThreatDetectionCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListDescendantEventThreatDetectionCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListDescendantSecurityHealthAnalyticsCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListDescendantSecurityHealthAnalyticsCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveEventThreatDetectionCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveEventThreatDetectionCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveSecurityHealthAnalyticsCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveSecurityHealthAnalyticsCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListSecurityCenterServicesRequest;
import com.google.cloud.securitycentermanagement.v1.ListSecurityCenterServicesResponse;
import com.google.cloud.securitycentermanagement.v1.ListSecurityHealthAnalyticsCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListSecurityHealthAnalyticsCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.SecurityCenterService;
import com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule;
import com.google.cloud.securitycentermanagement.v1.SimulateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.SimulateSecurityHealthAnalyticsCustomModuleResponse;
import com.google.cloud.securitycentermanagement.v1.UpdateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.UpdateSecurityCenterServiceRequest;
import com.google.cloud.securitycentermanagement.v1.UpdateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ValidateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ValidateEventThreatDetectionCustomModuleResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SecurityCenterManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SecurityCenterManagementStub implements BackgroundResource {

  public UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable()");
  }

  public UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEffectiveSecurityHealthAnalyticsCustomModulesCallable()");
  }

  public UnaryCallable<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getEffectiveSecurityHealthAnalyticsCustomModuleCallable()");
  }

  public UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      listSecurityHealthAnalyticsCustomModulesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSecurityHealthAnalyticsCustomModulesPagedCallable()");
  }

  public UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse>
      listSecurityHealthAnalyticsCustomModulesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSecurityHealthAnalyticsCustomModulesCallable()");
  }

  public UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable()");
  }

  public UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDescendantSecurityHealthAnalyticsCustomModulesCallable()");
  }

  public UnaryCallable<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getSecurityHealthAnalyticsCustomModuleCallable()");
  }

  public UnaryCallable<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSecurityHealthAnalyticsCustomModuleCallable()");
  }

  public UnaryCallable<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSecurityHealthAnalyticsCustomModuleCallable()");
  }

  public UnaryCallable<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSecurityHealthAnalyticsCustomModuleCallable()");
  }

  public UnaryCallable<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: simulateSecurityHealthAnalyticsCustomModuleCallable()");
  }

  public UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
      listEffectiveEventThreatDetectionCustomModulesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEffectiveEventThreatDetectionCustomModulesPagedCallable()");
  }

  public UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse>
      listEffectiveEventThreatDetectionCustomModulesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEffectiveEventThreatDetectionCustomModulesCallable()");
  }

  public UnaryCallable<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getEffectiveEventThreatDetectionCustomModuleCallable()");
  }

  public UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesPagedResponse>
      listEventThreatDetectionCustomModulesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEventThreatDetectionCustomModulesPagedCallable()");
  }

  public UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse>
      listEventThreatDetectionCustomModulesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEventThreatDetectionCustomModulesCallable()");
  }

  public UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesPagedResponse>
      listDescendantEventThreatDetectionCustomModulesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDescendantEventThreatDetectionCustomModulesPagedCallable()");
  }

  public UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse>
      listDescendantEventThreatDetectionCustomModulesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDescendantEventThreatDetectionCustomModulesCallable()");
  }

  public UnaryCallable<GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getEventThreatDetectionCustomModuleCallable()");
  }

  public UnaryCallable<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEventThreatDetectionCustomModuleCallable()");
  }

  public UnaryCallable<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEventThreatDetectionCustomModuleCallable()");
  }

  public UnaryCallable<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteEventThreatDetectionCustomModuleCallable()");
  }

  public UnaryCallable<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: validateEventThreatDetectionCustomModuleCallable()");
  }

  public UnaryCallable<GetSecurityCenterServiceRequest, SecurityCenterService>
      getSecurityCenterServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getSecurityCenterServiceCallable()");
  }

  public UnaryCallable<ListSecurityCenterServicesRequest, ListSecurityCenterServicesPagedResponse>
      listSecurityCenterServicesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSecurityCenterServicesPagedCallable()");
  }

  public UnaryCallable<ListSecurityCenterServicesRequest, ListSecurityCenterServicesResponse>
      listSecurityCenterServicesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSecurityCenterServicesCallable()");
  }

  public UnaryCallable<UpdateSecurityCenterServiceRequest, SecurityCenterService>
      updateSecurityCenterServiceCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSecurityCenterServiceCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
