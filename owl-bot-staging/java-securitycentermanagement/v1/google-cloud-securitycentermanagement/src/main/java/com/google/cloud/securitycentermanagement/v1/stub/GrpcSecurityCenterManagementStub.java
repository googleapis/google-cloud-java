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
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListSecurityHealthAnalyticsCustomModulesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.cloud.securitycentermanagement.v1.ListSecurityHealthAnalyticsCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListSecurityHealthAnalyticsCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule;
import com.google.cloud.securitycentermanagement.v1.SimulateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.SimulateSecurityHealthAnalyticsCustomModuleResponse;
import com.google.cloud.securitycentermanagement.v1.UpdateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.UpdateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ValidateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ValidateEventThreatDetectionCustomModuleResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SecurityCenterManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSecurityCenterManagementStub extends SecurityCenterManagementStub {
  private static final MethodDescriptor<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesMethodDescriptor =
          MethodDescriptor
              .<ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                  ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListEffectiveSecurityHealthAnalyticsCustomModules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListEffectiveSecurityHealthAnalyticsCustomModulesRequest
                          .getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListEffectiveSecurityHealthAnalyticsCustomModulesResponse
                          .getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          MethodDescriptor
              .<GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
                  EffectiveSecurityHealthAnalyticsCustomModule>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/GetEffectiveSecurityHealthAnalyticsCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetEffectiveSecurityHealthAnalyticsCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      EffectiveSecurityHealthAnalyticsCustomModule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse>
      listSecurityHealthAnalyticsCustomModulesMethodDescriptor =
          MethodDescriptor
              .<ListSecurityHealthAnalyticsCustomModulesRequest,
                  ListSecurityHealthAnalyticsCustomModulesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListSecurityHealthAnalyticsCustomModules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListSecurityHealthAnalyticsCustomModulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListSecurityHealthAnalyticsCustomModulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesMethodDescriptor =
          MethodDescriptor
              .<ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                  ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListDescendantSecurityHealthAnalyticsCustomModules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListDescendantSecurityHealthAnalyticsCustomModulesRequest
                          .getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListDescendantSecurityHealthAnalyticsCustomModulesResponse
                          .getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          MethodDescriptor
              .<GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/GetSecurityHealthAnalyticsCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetSecurityHealthAnalyticsCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SecurityHealthAnalyticsCustomModule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          MethodDescriptor
              .<CreateSecurityHealthAnalyticsCustomModuleRequest,
                  SecurityHealthAnalyticsCustomModule>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/CreateSecurityHealthAnalyticsCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateSecurityHealthAnalyticsCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SecurityHealthAnalyticsCustomModule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          MethodDescriptor
              .<UpdateSecurityHealthAnalyticsCustomModuleRequest,
                  SecurityHealthAnalyticsCustomModule>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/UpdateSecurityHealthAnalyticsCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateSecurityHealthAnalyticsCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SecurityHealthAnalyticsCustomModule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          MethodDescriptor.<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/DeleteSecurityHealthAnalyticsCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteSecurityHealthAnalyticsCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          MethodDescriptor
              .<SimulateSecurityHealthAnalyticsCustomModuleRequest,
                  SimulateSecurityHealthAnalyticsCustomModuleResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/SimulateSecurityHealthAnalyticsCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SimulateSecurityHealthAnalyticsCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      SimulateSecurityHealthAnalyticsCustomModuleResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse>
      listEffectiveEventThreatDetectionCustomModulesMethodDescriptor =
          MethodDescriptor
              .<ListEffectiveEventThreatDetectionCustomModulesRequest,
                  ListEffectiveEventThreatDetectionCustomModulesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListEffectiveEventThreatDetectionCustomModules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListEffectiveEventThreatDetectionCustomModulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListEffectiveEventThreatDetectionCustomModulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleMethodDescriptor =
          MethodDescriptor
              .<GetEffectiveEventThreatDetectionCustomModuleRequest,
                  EffectiveEventThreatDetectionCustomModule>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/GetEffectiveEventThreatDetectionCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetEffectiveEventThreatDetectionCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      EffectiveEventThreatDetectionCustomModule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse>
      listEventThreatDetectionCustomModulesMethodDescriptor =
          MethodDescriptor
              .<ListEventThreatDetectionCustomModulesRequest,
                  ListEventThreatDetectionCustomModulesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListEventThreatDetectionCustomModules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListEventThreatDetectionCustomModulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListEventThreatDetectionCustomModulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse>
      listDescendantEventThreatDetectionCustomModulesMethodDescriptor =
          MethodDescriptor
              .<ListDescendantEventThreatDetectionCustomModulesRequest,
                  ListDescendantEventThreatDetectionCustomModulesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListDescendantEventThreatDetectionCustomModules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListDescendantEventThreatDetectionCustomModulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListDescendantEventThreatDetectionCustomModulesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleMethodDescriptor =
          MethodDescriptor
              .<GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/GetEventThreatDetectionCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetEventThreatDetectionCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EventThreatDetectionCustomModule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleMethodDescriptor =
          MethodDescriptor
              .<CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/CreateEventThreatDetectionCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateEventThreatDetectionCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EventThreatDetectionCustomModule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleMethodDescriptor =
          MethodDescriptor
              .<UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/UpdateEventThreatDetectionCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateEventThreatDetectionCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EventThreatDetectionCustomModule.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleMethodDescriptor =
          MethodDescriptor.<DeleteEventThreatDetectionCustomModuleRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/DeleteEventThreatDetectionCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteEventThreatDetectionCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleMethodDescriptor =
          MethodDescriptor
              .<ValidateEventThreatDetectionCustomModuleRequest,
                  ValidateEventThreatDetectionCustomModuleResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ValidateEventThreatDetectionCustomModule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ValidateEventThreatDetectionCustomModuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ValidateEventThreatDetectionCustomModuleResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesCallable;
  private final UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable;
  private final UnaryCallable<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse>
      listSecurityHealthAnalyticsCustomModulesCallable;
  private final UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      listSecurityHealthAnalyticsCustomModulesPagedCallable;
  private final UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesCallable;
  private final UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable;
  private final UnaryCallable<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse>
      listEffectiveEventThreatDetectionCustomModulesCallable;
  private final UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
      listEffectiveEventThreatDetectionCustomModulesPagedCallable;
  private final UnaryCallable<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse>
      listEventThreatDetectionCustomModulesCallable;
  private final UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesPagedResponse>
      listEventThreatDetectionCustomModulesPagedCallable;
  private final UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse>
      listDescendantEventThreatDetectionCustomModulesCallable;
  private final UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesPagedResponse>
      listDescendantEventThreatDetectionCustomModulesPagedCallable;
  private final UnaryCallable<
          GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSecurityCenterManagementStub create(
      SecurityCenterManagementStubSettings settings) throws IOException {
    return new GrpcSecurityCenterManagementStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSecurityCenterManagementStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSecurityCenterManagementStub(
        SecurityCenterManagementStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSecurityCenterManagementStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSecurityCenterManagementStub(
        SecurityCenterManagementStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSecurityCenterManagementStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecurityCenterManagementStub(
      SecurityCenterManagementStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSecurityCenterManagementCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSecurityCenterManagementStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecurityCenterManagementStub(
      SecurityCenterManagementStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
            ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
        listEffectiveSecurityHealthAnalyticsCustomModulesTransportSettings =
            GrpcCallSettings
                .<ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                    ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(
                    listEffectiveSecurityHealthAnalyticsCustomModulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
            EffectiveSecurityHealthAnalyticsCustomModule>
        getEffectiveSecurityHealthAnalyticsCustomModuleTransportSettings =
            GrpcCallSettings
                .<GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
                    EffectiveSecurityHealthAnalyticsCustomModule>
                    newBuilder()
                .setMethodDescriptor(
                    getEffectiveSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListSecurityHealthAnalyticsCustomModulesRequest,
            ListSecurityHealthAnalyticsCustomModulesResponse>
        listSecurityHealthAnalyticsCustomModulesTransportSettings =
            GrpcCallSettings
                .<ListSecurityHealthAnalyticsCustomModulesRequest,
                    ListSecurityHealthAnalyticsCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(listSecurityHealthAnalyticsCustomModulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
            ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
        listDescendantSecurityHealthAnalyticsCustomModulesTransportSettings =
            GrpcCallSettings
                .<ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                    ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(
                    listDescendantSecurityHealthAnalyticsCustomModulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        getSecurityHealthAnalyticsCustomModuleTransportSettings =
            GrpcCallSettings
                .<GetSecurityHealthAnalyticsCustomModuleRequest,
                    SecurityHealthAnalyticsCustomModule>
                    newBuilder()
                .setMethodDescriptor(getSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        createSecurityHealthAnalyticsCustomModuleTransportSettings =
            GrpcCallSettings
                .<CreateSecurityHealthAnalyticsCustomModuleRequest,
                    SecurityHealthAnalyticsCustomModule>
                    newBuilder()
                .setMethodDescriptor(createSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        updateSecurityHealthAnalyticsCustomModuleTransportSettings =
            GrpcCallSettings
                .<UpdateSecurityHealthAnalyticsCustomModuleRequest,
                    SecurityHealthAnalyticsCustomModule>
                    newBuilder()
                .setMethodDescriptor(updateSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "security_health_analytics_custom_module.name",
                          String.valueOf(
                              request.getSecurityHealthAnalyticsCustomModule().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
        deleteSecurityHealthAnalyticsCustomModuleTransportSettings =
            GrpcCallSettings.<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            SimulateSecurityHealthAnalyticsCustomModuleRequest,
            SimulateSecurityHealthAnalyticsCustomModuleResponse>
        simulateSecurityHealthAnalyticsCustomModuleTransportSettings =
            GrpcCallSettings
                .<SimulateSecurityHealthAnalyticsCustomModuleRequest,
                    SimulateSecurityHealthAnalyticsCustomModuleResponse>
                    newBuilder()
                .setMethodDescriptor(simulateSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListEffectiveEventThreatDetectionCustomModulesRequest,
            ListEffectiveEventThreatDetectionCustomModulesResponse>
        listEffectiveEventThreatDetectionCustomModulesTransportSettings =
            GrpcCallSettings
                .<ListEffectiveEventThreatDetectionCustomModulesRequest,
                    ListEffectiveEventThreatDetectionCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(listEffectiveEventThreatDetectionCustomModulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            GetEffectiveEventThreatDetectionCustomModuleRequest,
            EffectiveEventThreatDetectionCustomModule>
        getEffectiveEventThreatDetectionCustomModuleTransportSettings =
            GrpcCallSettings
                .<GetEffectiveEventThreatDetectionCustomModuleRequest,
                    EffectiveEventThreatDetectionCustomModule>
                    newBuilder()
                .setMethodDescriptor(getEffectiveEventThreatDetectionCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListEventThreatDetectionCustomModulesRequest,
            ListEventThreatDetectionCustomModulesResponse>
        listEventThreatDetectionCustomModulesTransportSettings =
            GrpcCallSettings
                .<ListEventThreatDetectionCustomModulesRequest,
                    ListEventThreatDetectionCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(listEventThreatDetectionCustomModulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListDescendantEventThreatDetectionCustomModulesRequest,
            ListDescendantEventThreatDetectionCustomModulesResponse>
        listDescendantEventThreatDetectionCustomModulesTransportSettings =
            GrpcCallSettings
                .<ListDescendantEventThreatDetectionCustomModulesRequest,
                    ListDescendantEventThreatDetectionCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(
                    listDescendantEventThreatDetectionCustomModulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        getEventThreatDetectionCustomModuleTransportSettings =
            GrpcCallSettings
                .<GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                    newBuilder()
                .setMethodDescriptor(getEventThreatDetectionCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        createEventThreatDetectionCustomModuleTransportSettings =
            GrpcCallSettings
                .<CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                    newBuilder()
                .setMethodDescriptor(createEventThreatDetectionCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        updateEventThreatDetectionCustomModuleTransportSettings =
            GrpcCallSettings
                .<UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                    newBuilder()
                .setMethodDescriptor(updateEventThreatDetectionCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "event_threat_detection_custom_module.name",
                          String.valueOf(request.getEventThreatDetectionCustomModule().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteEventThreatDetectionCustomModuleRequest, Empty>
        deleteEventThreatDetectionCustomModuleTransportSettings =
            GrpcCallSettings.<DeleteEventThreatDetectionCustomModuleRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteEventThreatDetectionCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ValidateEventThreatDetectionCustomModuleRequest,
            ValidateEventThreatDetectionCustomModuleResponse>
        validateEventThreatDetectionCustomModuleTransportSettings =
            GrpcCallSettings
                .<ValidateEventThreatDetectionCustomModuleRequest,
                    ValidateEventThreatDetectionCustomModuleResponse>
                    newBuilder()
                .setMethodDescriptor(validateEventThreatDetectionCustomModuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listEffectiveSecurityHealthAnalyticsCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listEffectiveSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listEffectiveSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listEffectiveSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listEffectiveSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.getEffectiveSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            getEffectiveSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.getEffectiveSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.listSecurityHealthAnalyticsCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.listSecurityHealthAnalyticsCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.listDescendantSecurityHealthAnalyticsCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listDescendantSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listDescendantSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listDescendantSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listDescendantSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.getSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            getSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.getSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.createSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            createSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.createSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.updateSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            updateSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.updateSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.deleteSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            deleteSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.deleteSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.simulateSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            simulateSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.simulateSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.listEffectiveEventThreatDetectionCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listEffectiveEventThreatDetectionCustomModulesTransportSettings,
            settings.listEffectiveEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.listEffectiveEventThreatDetectionCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listEffectiveEventThreatDetectionCustomModulesTransportSettings,
            settings.listEffectiveEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.getEffectiveEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            getEffectiveEventThreatDetectionCustomModuleTransportSettings,
            settings.getEffectiveEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.listEventThreatDetectionCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listEventThreatDetectionCustomModulesTransportSettings,
            settings.listEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.listEventThreatDetectionCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listEventThreatDetectionCustomModulesTransportSettings,
            settings.listEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.listDescendantEventThreatDetectionCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listDescendantEventThreatDetectionCustomModulesTransportSettings,
            settings.listDescendantEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.listDescendantEventThreatDetectionCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listDescendantEventThreatDetectionCustomModulesTransportSettings,
            settings.listDescendantEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.getEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            getEventThreatDetectionCustomModuleTransportSettings,
            settings.getEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.createEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            createEventThreatDetectionCustomModuleTransportSettings,
            settings.createEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.updateEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            updateEventThreatDetectionCustomModuleTransportSettings,
            settings.updateEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.deleteEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            deleteEventThreatDetectionCustomModuleTransportSettings,
            settings.deleteEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.validateEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            validateEventThreatDetectionCustomModuleTransportSettings,
            settings.validateEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesCallable() {
    return listEffectiveSecurityHealthAnalyticsCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleCallable() {
    return getEffectiveSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse>
      listSecurityHealthAnalyticsCustomModulesCallable() {
    return listSecurityHealthAnalyticsCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      listSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return listSecurityHealthAnalyticsCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesCallable() {
    return listDescendantSecurityHealthAnalyticsCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleCallable() {
    return getSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleCallable() {
    return createSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleCallable() {
    return updateSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleCallable() {
    return deleteSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleCallable() {
    return simulateSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse>
      listEffectiveEventThreatDetectionCustomModulesCallable() {
    return listEffectiveEventThreatDetectionCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
      listEffectiveEventThreatDetectionCustomModulesPagedCallable() {
    return listEffectiveEventThreatDetectionCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleCallable() {
    return getEffectiveEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse>
      listEventThreatDetectionCustomModulesCallable() {
    return listEventThreatDetectionCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesPagedResponse>
      listEventThreatDetectionCustomModulesPagedCallable() {
    return listEventThreatDetectionCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse>
      listDescendantEventThreatDetectionCustomModulesCallable() {
    return listDescendantEventThreatDetectionCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesPagedResponse>
      listDescendantEventThreatDetectionCustomModulesPagedCallable() {
    return listDescendantEventThreatDetectionCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleCallable() {
    return getEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleCallable() {
    return createEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleCallable() {
    return updateEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleCallable() {
    return deleteEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleCallable() {
    return validateEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
