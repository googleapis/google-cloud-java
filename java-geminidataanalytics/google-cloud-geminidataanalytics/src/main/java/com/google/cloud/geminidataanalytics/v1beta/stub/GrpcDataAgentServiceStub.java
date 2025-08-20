/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.geminidataanalytics.v1beta.stub;

import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListAccessibleDataAgentsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListDataAgentsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataAgentServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.geminidataanalytics.v1beta.CreateDataAgentRequest;
import com.google.cloud.geminidataanalytics.v1beta.DataAgent;
import com.google.cloud.geminidataanalytics.v1beta.DeleteDataAgentRequest;
import com.google.cloud.geminidataanalytics.v1beta.GetDataAgentRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListAccessibleDataAgentsResponse;
import com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsRequest;
import com.google.cloud.geminidataanalytics.v1beta.ListDataAgentsResponse;
import com.google.cloud.geminidataanalytics.v1beta.OperationMetadata;
import com.google.cloud.geminidataanalytics.v1beta.UpdateDataAgentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataAgentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataAgentServiceStub extends DataAgentServiceStub {
  private static final MethodDescriptor<ListDataAgentsRequest, ListDataAgentsResponse>
      listDataAgentsMethodDescriptor =
          MethodDescriptor.<ListDataAgentsRequest, ListDataAgentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataAgentService/ListDataAgents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataAgentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse>
      listAccessibleDataAgentsMethodDescriptor =
          MethodDescriptor
              .<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataAgentService/ListAccessibleDataAgents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccessibleDataAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccessibleDataAgentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataAgentRequest, DataAgent>
      getDataAgentMethodDescriptor =
          MethodDescriptor.<GetDataAgentRequest, DataAgent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataAgentService/GetDataAgent")
              .setRequestMarshaller(ProtoUtils.marshaller(GetDataAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataAgent.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDataAgentRequest, Operation>
      createDataAgentMethodDescriptor =
          MethodDescriptor.<CreateDataAgentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataAgentService/CreateDataAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataAgentRequest, Operation>
      updateDataAgentMethodDescriptor =
          MethodDescriptor.<UpdateDataAgentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataAgentService/UpdateDataAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDataAgentRequest, Operation>
      deleteDataAgentMethodDescriptor =
          MethodDescriptor.<DeleteDataAgentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataAgentService/DeleteDataAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.geminidataanalytics.v1beta.DataAgentService/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.geminidataanalytics.v1beta.DataAgentService/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
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

  private final UnaryCallable<ListDataAgentsRequest, ListDataAgentsResponse> listDataAgentsCallable;
  private final UnaryCallable<ListDataAgentsRequest, ListDataAgentsPagedResponse>
      listDataAgentsPagedCallable;
  private final UnaryCallable<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse>
      listAccessibleDataAgentsCallable;
  private final UnaryCallable<
          ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsPagedResponse>
      listAccessibleDataAgentsPagedCallable;
  private final UnaryCallable<GetDataAgentRequest, DataAgent> getDataAgentCallable;
  private final UnaryCallable<CreateDataAgentRequest, Operation> createDataAgentCallable;
  private final OperationCallable<CreateDataAgentRequest, DataAgent, OperationMetadata>
      createDataAgentOperationCallable;
  private final UnaryCallable<UpdateDataAgentRequest, Operation> updateDataAgentCallable;
  private final OperationCallable<UpdateDataAgentRequest, DataAgent, OperationMetadata>
      updateDataAgentOperationCallable;
  private final UnaryCallable<DeleteDataAgentRequest, Operation> deleteDataAgentCallable;
  private final OperationCallable<DeleteDataAgentRequest, Empty, OperationMetadata>
      deleteDataAgentOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataAgentServiceStub create(DataAgentServiceStubSettings settings)
      throws IOException {
    return new GrpcDataAgentServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataAgentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataAgentServiceStub(
        DataAgentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataAgentServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataAgentServiceStub(
        DataAgentServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataAgentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataAgentServiceStub(
      DataAgentServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataAgentServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataAgentServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataAgentServiceStub(
      DataAgentServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListDataAgentsRequest, ListDataAgentsResponse>
        listDataAgentsTransportSettings =
            GrpcCallSettings.<ListDataAgentsRequest, ListDataAgentsResponse>newBuilder()
                .setMethodDescriptor(listDataAgentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse>
        listAccessibleDataAgentsTransportSettings =
            GrpcCallSettings
                .<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse>newBuilder()
                .setMethodDescriptor(listAccessibleDataAgentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataAgentRequest, DataAgent> getDataAgentTransportSettings =
        GrpcCallSettings.<GetDataAgentRequest, DataAgent>newBuilder()
            .setMethodDescriptor(getDataAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDataAgentRequest, Operation> createDataAgentTransportSettings =
        GrpcCallSettings.<CreateDataAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataAgentRequest, Operation> updateDataAgentTransportSettings =
        GrpcCallSettings.<UpdateDataAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_agent.name", String.valueOf(request.getDataAgent().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDataAgentRequest, Operation> deleteDataAgentTransportSettings =
        GrpcCallSettings.<DeleteDataAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
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

    this.listDataAgentsCallable =
        callableFactory.createUnaryCallable(
            listDataAgentsTransportSettings, settings.listDataAgentsSettings(), clientContext);
    this.listDataAgentsPagedCallable =
        callableFactory.createPagedCallable(
            listDataAgentsTransportSettings, settings.listDataAgentsSettings(), clientContext);
    this.listAccessibleDataAgentsCallable =
        callableFactory.createUnaryCallable(
            listAccessibleDataAgentsTransportSettings,
            settings.listAccessibleDataAgentsSettings(),
            clientContext);
    this.listAccessibleDataAgentsPagedCallable =
        callableFactory.createPagedCallable(
            listAccessibleDataAgentsTransportSettings,
            settings.listAccessibleDataAgentsSettings(),
            clientContext);
    this.getDataAgentCallable =
        callableFactory.createUnaryCallable(
            getDataAgentTransportSettings, settings.getDataAgentSettings(), clientContext);
    this.createDataAgentCallable =
        callableFactory.createUnaryCallable(
            createDataAgentTransportSettings, settings.createDataAgentSettings(), clientContext);
    this.createDataAgentOperationCallable =
        callableFactory.createOperationCallable(
            createDataAgentTransportSettings,
            settings.createDataAgentOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDataAgentCallable =
        callableFactory.createUnaryCallable(
            updateDataAgentTransportSettings, settings.updateDataAgentSettings(), clientContext);
    this.updateDataAgentOperationCallable =
        callableFactory.createOperationCallable(
            updateDataAgentTransportSettings,
            settings.updateDataAgentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDataAgentCallable =
        callableFactory.createUnaryCallable(
            deleteDataAgentTransportSettings, settings.deleteDataAgentSettings(), clientContext);
    this.deleteDataAgentOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataAgentTransportSettings,
            settings.deleteDataAgentOperationSettings(),
            clientContext,
            operationsStub);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
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
  public UnaryCallable<ListDataAgentsRequest, ListDataAgentsResponse> listDataAgentsCallable() {
    return listDataAgentsCallable;
  }

  @Override
  public UnaryCallable<ListDataAgentsRequest, ListDataAgentsPagedResponse>
      listDataAgentsPagedCallable() {
    return listDataAgentsPagedCallable;
  }

  @Override
  public UnaryCallable<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsResponse>
      listAccessibleDataAgentsCallable() {
    return listAccessibleDataAgentsCallable;
  }

  @Override
  public UnaryCallable<ListAccessibleDataAgentsRequest, ListAccessibleDataAgentsPagedResponse>
      listAccessibleDataAgentsPagedCallable() {
    return listAccessibleDataAgentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataAgentRequest, DataAgent> getDataAgentCallable() {
    return getDataAgentCallable;
  }

  @Override
  public UnaryCallable<CreateDataAgentRequest, Operation> createDataAgentCallable() {
    return createDataAgentCallable;
  }

  @Override
  public OperationCallable<CreateDataAgentRequest, DataAgent, OperationMetadata>
      createDataAgentOperationCallable() {
    return createDataAgentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAgentRequest, Operation> updateDataAgentCallable() {
    return updateDataAgentCallable;
  }

  @Override
  public OperationCallable<UpdateDataAgentRequest, DataAgent, OperationMetadata>
      updateDataAgentOperationCallable() {
    return updateDataAgentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAgentRequest, Operation> deleteDataAgentCallable() {
    return deleteDataAgentCallable;
  }

  @Override
  public OperationCallable<DeleteDataAgentRequest, Empty, OperationMetadata>
      deleteDataAgentOperationCallable() {
    return deleteDataAgentOperationCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
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
