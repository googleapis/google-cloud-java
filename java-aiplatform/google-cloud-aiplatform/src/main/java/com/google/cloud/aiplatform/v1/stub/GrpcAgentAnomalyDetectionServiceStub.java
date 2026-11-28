/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.AggregateAnalyzedSessionsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAgentAnomalyDetectionScopesPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAnalyzedInvocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListAnalyzedSessionsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceClient.ListMonitoredAgentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.AgentAnomalyDetectionScope;
import com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsRequest;
import com.google.cloud.aiplatform.v1.AggregateAnalyzedSessionsResponse;
import com.google.cloud.aiplatform.v1.AnalyzedInvocation;
import com.google.cloud.aiplatform.v1.AnalyzedSession;
import com.google.cloud.aiplatform.v1.ClearTrainingDataOperationMetadata;
import com.google.cloud.aiplatform.v1.ClearTrainingDataRequest;
import com.google.cloud.aiplatform.v1.ClearTrainingDataResponse;
import com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateAgentAnomalyDetectionScopeRequest;
import com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeOperationMetadata;
import com.google.cloud.aiplatform.v1.DeleteAgentAnomalyDetectionScopeRequest;
import com.google.cloud.aiplatform.v1.DisableMonitoredAgentOperationMetadata;
import com.google.cloud.aiplatform.v1.DisableMonitoredAgentRequest;
import com.google.cloud.aiplatform.v1.EnableMonitoredAgentOperationMetadata;
import com.google.cloud.aiplatform.v1.EnableMonitoredAgentRequest;
import com.google.cloud.aiplatform.v1.GetAgentAnomalyDetectionScopeRequest;
import com.google.cloud.aiplatform.v1.GetAnalyzedInvocationRequest;
import com.google.cloud.aiplatform.v1.GetAnalyzedSessionRequest;
import com.google.cloud.aiplatform.v1.GetMonitoredAgentRequest;
import com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesRequest;
import com.google.cloud.aiplatform.v1.ListAgentAnomalyDetectionScopesResponse;
import com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsRequest;
import com.google.cloud.aiplatform.v1.ListAnalyzedInvocationsResponse;
import com.google.cloud.aiplatform.v1.ListAnalyzedSessionsRequest;
import com.google.cloud.aiplatform.v1.ListAnalyzedSessionsResponse;
import com.google.cloud.aiplatform.v1.ListMonitoredAgentsRequest;
import com.google.cloud.aiplatform.v1.ListMonitoredAgentsResponse;
import com.google.cloud.aiplatform.v1.MonitoredAgent;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AgentAnomalyDetectionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcAgentAnomalyDetectionServiceStub extends AgentAnomalyDetectionServiceStub {
  private static final MethodDescriptor<
          GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
      getAgentAnomalyDetectionScopeMethodDescriptor =
          MethodDescriptor
              .<GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/GetAgentAnomalyDetectionScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAgentAnomalyDetectionScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AgentAnomalyDetectionScope.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMonitoredAgentRequest, MonitoredAgent>
      getMonitoredAgentMethodDescriptor =
          MethodDescriptor.<GetMonitoredAgentRequest, MonitoredAgent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/GetMonitoredAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMonitoredAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MonitoredAgent.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse>
      listMonitoredAgentsMethodDescriptor =
          MethodDescriptor.<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/ListMonitoredAgents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMonitoredAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMonitoredAgentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<EnableMonitoredAgentRequest, Operation>
      enableMonitoredAgentMethodDescriptor =
          MethodDescriptor.<EnableMonitoredAgentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/EnableMonitoredAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableMonitoredAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DisableMonitoredAgentRequest, Operation>
      disableMonitoredAgentMethodDescriptor =
          MethodDescriptor.<DisableMonitoredAgentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/DisableMonitoredAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableMonitoredAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAgentAnomalyDetectionScopeRequest, Operation>
      deleteAgentAnomalyDetectionScopeMethodDescriptor =
          MethodDescriptor.<DeleteAgentAnomalyDetectionScopeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/DeleteAgentAnomalyDetectionScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteAgentAnomalyDetectionScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAgentAnomalyDetectionScopeRequest, Operation>
      createAgentAnomalyDetectionScopeMethodDescriptor =
          MethodDescriptor.<CreateAgentAnomalyDetectionScopeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/CreateAgentAnomalyDetectionScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateAgentAnomalyDetectionScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesResponse>
      listAgentAnomalyDetectionScopesMethodDescriptor =
          MethodDescriptor
              .<ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/ListAgentAnomalyDetectionScopes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListAgentAnomalyDetectionScopesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListAgentAnomalyDetectionScopesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse>
      listAnalyzedSessionsMethodDescriptor =
          MethodDescriptor.<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/ListAnalyzedSessions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnalyzedSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnalyzedSessionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAnalyzedSessionRequest, AnalyzedSession>
      getAnalyzedSessionMethodDescriptor =
          MethodDescriptor.<GetAnalyzedSessionRequest, AnalyzedSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/GetAnalyzedSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnalyzedSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnalyzedSession.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse>
      listAnalyzedInvocationsMethodDescriptor =
          MethodDescriptor
              .<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/ListAnalyzedInvocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnalyzedInvocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnalyzedInvocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAnalyzedInvocationRequest, AnalyzedInvocation>
      getAnalyzedInvocationMethodDescriptor =
          MethodDescriptor.<GetAnalyzedInvocationRequest, AnalyzedInvocation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/GetAnalyzedInvocation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnalyzedInvocationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnalyzedInvocation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsResponse>
      aggregateAnalyzedSessionsMethodDescriptor =
          MethodDescriptor
              .<AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/AggregateAnalyzedSessions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AggregateAnalyzedSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AggregateAnalyzedSessionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ClearTrainingDataRequest, Operation>
      clearTrainingDataMethodDescriptor =
          MethodDescriptor.<ClearTrainingDataRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.AgentAnomalyDetectionService/ClearTrainingData")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ClearTrainingDataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
      getAgentAnomalyDetectionScopeCallable;
  private final UnaryCallable<GetMonitoredAgentRequest, MonitoredAgent> getMonitoredAgentCallable;
  private final UnaryCallable<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse>
      listMonitoredAgentsCallable;
  private final UnaryCallable<ListMonitoredAgentsRequest, ListMonitoredAgentsPagedResponse>
      listMonitoredAgentsPagedCallable;
  private final UnaryCallable<EnableMonitoredAgentRequest, Operation> enableMonitoredAgentCallable;
  private final OperationCallable<
          EnableMonitoredAgentRequest, MonitoredAgent, EnableMonitoredAgentOperationMetadata>
      enableMonitoredAgentOperationCallable;
  private final UnaryCallable<DisableMonitoredAgentRequest, Operation>
      disableMonitoredAgentCallable;
  private final OperationCallable<
          DisableMonitoredAgentRequest, MonitoredAgent, DisableMonitoredAgentOperationMetadata>
      disableMonitoredAgentOperationCallable;
  private final UnaryCallable<DeleteAgentAnomalyDetectionScopeRequest, Operation>
      deleteAgentAnomalyDetectionScopeCallable;
  private final OperationCallable<
          DeleteAgentAnomalyDetectionScopeRequest,
          Empty,
          DeleteAgentAnomalyDetectionScopeOperationMetadata>
      deleteAgentAnomalyDetectionScopeOperationCallable;
  private final UnaryCallable<CreateAgentAnomalyDetectionScopeRequest, Operation>
      createAgentAnomalyDetectionScopeCallable;
  private final OperationCallable<
          CreateAgentAnomalyDetectionScopeRequest,
          AgentAnomalyDetectionScope,
          CreateAgentAnomalyDetectionScopeOperationMetadata>
      createAgentAnomalyDetectionScopeOperationCallable;
  private final UnaryCallable<
          ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesResponse>
      listAgentAnomalyDetectionScopesCallable;
  private final UnaryCallable<
          ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesPagedResponse>
      listAgentAnomalyDetectionScopesPagedCallable;
  private final UnaryCallable<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse>
      listAnalyzedSessionsCallable;
  private final UnaryCallable<ListAnalyzedSessionsRequest, ListAnalyzedSessionsPagedResponse>
      listAnalyzedSessionsPagedCallable;
  private final UnaryCallable<GetAnalyzedSessionRequest, AnalyzedSession>
      getAnalyzedSessionCallable;
  private final UnaryCallable<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse>
      listAnalyzedInvocationsCallable;
  private final UnaryCallable<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsPagedResponse>
      listAnalyzedInvocationsPagedCallable;
  private final UnaryCallable<GetAnalyzedInvocationRequest, AnalyzedInvocation>
      getAnalyzedInvocationCallable;
  private final UnaryCallable<AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsResponse>
      aggregateAnalyzedSessionsCallable;
  private final UnaryCallable<
          AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsPagedResponse>
      aggregateAnalyzedSessionsPagedCallable;
  private final UnaryCallable<ClearTrainingDataRequest, Operation> clearTrainingDataCallable;
  private final OperationCallable<
          ClearTrainingDataRequest, ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
      clearTrainingDataOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAgentAnomalyDetectionServiceStub create(
      AgentAnomalyDetectionServiceStubSettings settings) throws IOException {
    return new GrpcAgentAnomalyDetectionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAgentAnomalyDetectionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAgentAnomalyDetectionServiceStub(
        AgentAnomalyDetectionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAgentAnomalyDetectionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAgentAnomalyDetectionServiceStub(
        AgentAnomalyDetectionServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcAgentAnomalyDetectionServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAgentAnomalyDetectionServiceStub(
      AgentAnomalyDetectionServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAgentAnomalyDetectionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAgentAnomalyDetectionServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAgentAnomalyDetectionServiceStub(
      AgentAnomalyDetectionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
        getAgentAnomalyDetectionScopeTransportSettings =
            GrpcCallSettings
                .<GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>newBuilder()
                .setMethodDescriptor(getAgentAnomalyDetectionScopeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GetMonitoredAgentRequest, MonitoredAgent> getMonitoredAgentTransportSettings =
        GrpcCallSettings.<GetMonitoredAgentRequest, MonitoredAgent>newBuilder()
            .setMethodDescriptor(getMonitoredAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse>
        listMonitoredAgentsTransportSettings =
            GrpcCallSettings.<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse>newBuilder()
                .setMethodDescriptor(listMonitoredAgentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<EnableMonitoredAgentRequest, Operation> enableMonitoredAgentTransportSettings =
        GrpcCallSettings.<EnableMonitoredAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(enableMonitoredAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DisableMonitoredAgentRequest, Operation>
        disableMonitoredAgentTransportSettings =
            GrpcCallSettings.<DisableMonitoredAgentRequest, Operation>newBuilder()
                .setMethodDescriptor(disableMonitoredAgentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<DeleteAgentAnomalyDetectionScopeRequest, Operation>
        deleteAgentAnomalyDetectionScopeTransportSettings =
            GrpcCallSettings.<DeleteAgentAnomalyDetectionScopeRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAgentAnomalyDetectionScopeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateAgentAnomalyDetectionScopeRequest, Operation>
        createAgentAnomalyDetectionScopeTransportSettings =
            GrpcCallSettings.<CreateAgentAnomalyDetectionScopeRequest, Operation>newBuilder()
                .setMethodDescriptor(createAgentAnomalyDetectionScopeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<
            ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesResponse>
        listAgentAnomalyDetectionScopesTransportSettings =
            GrpcCallSettings
                .<ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesResponse>
                    newBuilder()
                .setMethodDescriptor(listAgentAnomalyDetectionScopesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse>
        listAnalyzedSessionsTransportSettings =
            GrpcCallSettings.<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse>newBuilder()
                .setMethodDescriptor(listAnalyzedSessionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAnalyzedSessionRequest, AnalyzedSession>
        getAnalyzedSessionTransportSettings =
            GrpcCallSettings.<GetAnalyzedSessionRequest, AnalyzedSession>newBuilder()
                .setMethodDescriptor(getAnalyzedSessionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse>
        listAnalyzedInvocationsTransportSettings =
            GrpcCallSettings
                .<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse>newBuilder()
                .setMethodDescriptor(listAnalyzedInvocationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAnalyzedInvocationRequest, AnalyzedInvocation>
        getAnalyzedInvocationTransportSettings =
            GrpcCallSettings.<GetAnalyzedInvocationRequest, AnalyzedInvocation>newBuilder()
                .setMethodDescriptor(getAnalyzedInvocationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsResponse>
        aggregateAnalyzedSessionsTransportSettings =
            GrpcCallSettings
                .<AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsResponse>newBuilder()
                .setMethodDescriptor(aggregateAnalyzedSessionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ClearTrainingDataRequest, Operation> clearTrainingDataTransportSettings =
        GrpcCallSettings.<ClearTrainingDataRequest, Operation>newBuilder()
            .setMethodDescriptor(clearTrainingDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
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
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getResource())
                .build();

    this.getAgentAnomalyDetectionScopeCallable =
        callableFactory.createUnaryCallable(
            getAgentAnomalyDetectionScopeTransportSettings,
            settings.getAgentAnomalyDetectionScopeSettings(),
            clientContext);
    this.getMonitoredAgentCallable =
        callableFactory.createUnaryCallable(
            getMonitoredAgentTransportSettings,
            settings.getMonitoredAgentSettings(),
            clientContext);
    this.listMonitoredAgentsCallable =
        callableFactory.createUnaryCallable(
            listMonitoredAgentsTransportSettings,
            settings.listMonitoredAgentsSettings(),
            clientContext);
    this.listMonitoredAgentsPagedCallable =
        callableFactory.createPagedCallable(
            listMonitoredAgentsTransportSettings,
            settings.listMonitoredAgentsSettings(),
            clientContext);
    this.enableMonitoredAgentCallable =
        callableFactory.createUnaryCallable(
            enableMonitoredAgentTransportSettings,
            settings.enableMonitoredAgentSettings(),
            clientContext);
    this.enableMonitoredAgentOperationCallable =
        callableFactory.createOperationCallable(
            enableMonitoredAgentTransportSettings,
            settings.enableMonitoredAgentOperationSettings(),
            clientContext,
            operationsStub);
    this.disableMonitoredAgentCallable =
        callableFactory.createUnaryCallable(
            disableMonitoredAgentTransportSettings,
            settings.disableMonitoredAgentSettings(),
            clientContext);
    this.disableMonitoredAgentOperationCallable =
        callableFactory.createOperationCallable(
            disableMonitoredAgentTransportSettings,
            settings.disableMonitoredAgentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAgentAnomalyDetectionScopeCallable =
        callableFactory.createUnaryCallable(
            deleteAgentAnomalyDetectionScopeTransportSettings,
            settings.deleteAgentAnomalyDetectionScopeSettings(),
            clientContext);
    this.deleteAgentAnomalyDetectionScopeOperationCallable =
        callableFactory.createOperationCallable(
            deleteAgentAnomalyDetectionScopeTransportSettings,
            settings.deleteAgentAnomalyDetectionScopeOperationSettings(),
            clientContext,
            operationsStub);
    this.createAgentAnomalyDetectionScopeCallable =
        callableFactory.createUnaryCallable(
            createAgentAnomalyDetectionScopeTransportSettings,
            settings.createAgentAnomalyDetectionScopeSettings(),
            clientContext);
    this.createAgentAnomalyDetectionScopeOperationCallable =
        callableFactory.createOperationCallable(
            createAgentAnomalyDetectionScopeTransportSettings,
            settings.createAgentAnomalyDetectionScopeOperationSettings(),
            clientContext,
            operationsStub);
    this.listAgentAnomalyDetectionScopesCallable =
        callableFactory.createUnaryCallable(
            listAgentAnomalyDetectionScopesTransportSettings,
            settings.listAgentAnomalyDetectionScopesSettings(),
            clientContext);
    this.listAgentAnomalyDetectionScopesPagedCallable =
        callableFactory.createPagedCallable(
            listAgentAnomalyDetectionScopesTransportSettings,
            settings.listAgentAnomalyDetectionScopesSettings(),
            clientContext);
    this.listAnalyzedSessionsCallable =
        callableFactory.createUnaryCallable(
            listAnalyzedSessionsTransportSettings,
            settings.listAnalyzedSessionsSettings(),
            clientContext);
    this.listAnalyzedSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listAnalyzedSessionsTransportSettings,
            settings.listAnalyzedSessionsSettings(),
            clientContext);
    this.getAnalyzedSessionCallable =
        callableFactory.createUnaryCallable(
            getAnalyzedSessionTransportSettings,
            settings.getAnalyzedSessionSettings(),
            clientContext);
    this.listAnalyzedInvocationsCallable =
        callableFactory.createUnaryCallable(
            listAnalyzedInvocationsTransportSettings,
            settings.listAnalyzedInvocationsSettings(),
            clientContext);
    this.listAnalyzedInvocationsPagedCallable =
        callableFactory.createPagedCallable(
            listAnalyzedInvocationsTransportSettings,
            settings.listAnalyzedInvocationsSettings(),
            clientContext);
    this.getAnalyzedInvocationCallable =
        callableFactory.createUnaryCallable(
            getAnalyzedInvocationTransportSettings,
            settings.getAnalyzedInvocationSettings(),
            clientContext);
    this.aggregateAnalyzedSessionsCallable =
        callableFactory.createUnaryCallable(
            aggregateAnalyzedSessionsTransportSettings,
            settings.aggregateAnalyzedSessionsSettings(),
            clientContext);
    this.aggregateAnalyzedSessionsPagedCallable =
        callableFactory.createPagedCallable(
            aggregateAnalyzedSessionsTransportSettings,
            settings.aggregateAnalyzedSessionsSettings(),
            clientContext);
    this.clearTrainingDataCallable =
        callableFactory.createUnaryCallable(
            clearTrainingDataTransportSettings,
            settings.clearTrainingDataSettings(),
            clientContext);
    this.clearTrainingDataOperationCallable =
        callableFactory.createOperationCallable(
            clearTrainingDataTransportSettings,
            settings.clearTrainingDataOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
      getAgentAnomalyDetectionScopeCallable() {
    return getAgentAnomalyDetectionScopeCallable;
  }

  @Override
  public UnaryCallable<GetMonitoredAgentRequest, MonitoredAgent> getMonitoredAgentCallable() {
    return getMonitoredAgentCallable;
  }

  @Override
  public UnaryCallable<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse>
      listMonitoredAgentsCallable() {
    return listMonitoredAgentsCallable;
  }

  @Override
  public UnaryCallable<ListMonitoredAgentsRequest, ListMonitoredAgentsPagedResponse>
      listMonitoredAgentsPagedCallable() {
    return listMonitoredAgentsPagedCallable;
  }

  @Override
  public UnaryCallable<EnableMonitoredAgentRequest, Operation> enableMonitoredAgentCallable() {
    return enableMonitoredAgentCallable;
  }

  @Override
  public OperationCallable<
          EnableMonitoredAgentRequest, MonitoredAgent, EnableMonitoredAgentOperationMetadata>
      enableMonitoredAgentOperationCallable() {
    return enableMonitoredAgentOperationCallable;
  }

  @Override
  public UnaryCallable<DisableMonitoredAgentRequest, Operation> disableMonitoredAgentCallable() {
    return disableMonitoredAgentCallable;
  }

  @Override
  public OperationCallable<
          DisableMonitoredAgentRequest, MonitoredAgent, DisableMonitoredAgentOperationMetadata>
      disableMonitoredAgentOperationCallable() {
    return disableMonitoredAgentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAgentAnomalyDetectionScopeRequest, Operation>
      deleteAgentAnomalyDetectionScopeCallable() {
    return deleteAgentAnomalyDetectionScopeCallable;
  }

  @Override
  public OperationCallable<
          DeleteAgentAnomalyDetectionScopeRequest,
          Empty,
          DeleteAgentAnomalyDetectionScopeOperationMetadata>
      deleteAgentAnomalyDetectionScopeOperationCallable() {
    return deleteAgentAnomalyDetectionScopeOperationCallable;
  }

  @Override
  public UnaryCallable<CreateAgentAnomalyDetectionScopeRequest, Operation>
      createAgentAnomalyDetectionScopeCallable() {
    return createAgentAnomalyDetectionScopeCallable;
  }

  @Override
  public OperationCallable<
          CreateAgentAnomalyDetectionScopeRequest,
          AgentAnomalyDetectionScope,
          CreateAgentAnomalyDetectionScopeOperationMetadata>
      createAgentAnomalyDetectionScopeOperationCallable() {
    return createAgentAnomalyDetectionScopeOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesResponse>
      listAgentAnomalyDetectionScopesCallable() {
    return listAgentAnomalyDetectionScopesCallable;
  }

  @Override
  public UnaryCallable<
          ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesPagedResponse>
      listAgentAnomalyDetectionScopesPagedCallable() {
    return listAgentAnomalyDetectionScopesPagedCallable;
  }

  @Override
  public UnaryCallable<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse>
      listAnalyzedSessionsCallable() {
    return listAnalyzedSessionsCallable;
  }

  @Override
  public UnaryCallable<ListAnalyzedSessionsRequest, ListAnalyzedSessionsPagedResponse>
      listAnalyzedSessionsPagedCallable() {
    return listAnalyzedSessionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAnalyzedSessionRequest, AnalyzedSession> getAnalyzedSessionCallable() {
    return getAnalyzedSessionCallable;
  }

  @Override
  public UnaryCallable<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse>
      listAnalyzedInvocationsCallable() {
    return listAnalyzedInvocationsCallable;
  }

  @Override
  public UnaryCallable<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsPagedResponse>
      listAnalyzedInvocationsPagedCallable() {
    return listAnalyzedInvocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAnalyzedInvocationRequest, AnalyzedInvocation>
      getAnalyzedInvocationCallable() {
    return getAnalyzedInvocationCallable;
  }

  @Override
  public UnaryCallable<AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsResponse>
      aggregateAnalyzedSessionsCallable() {
    return aggregateAnalyzedSessionsCallable;
  }

  @Override
  public UnaryCallable<AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsPagedResponse>
      aggregateAnalyzedSessionsPagedCallable() {
    return aggregateAnalyzedSessionsPagedCallable;
  }

  @Override
  public UnaryCallable<ClearTrainingDataRequest, Operation> clearTrainingDataCallable() {
    return clearTrainingDataCallable;
  }

  @Override
  public OperationCallable<
          ClearTrainingDataRequest, ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
      clearTrainingDataOperationCallable() {
    return clearTrainingDataOperationCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
