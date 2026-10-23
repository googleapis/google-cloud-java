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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.CompanionAgentsClient.ListCompanionAgentsPagedResponse;
import static com.google.cloud.dialogflow.v2.CompanionAgentsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.CompanionAgent;
import com.google.cloud.dialogflow.v2.CreateCompanionAgentRequest;
import com.google.cloud.dialogflow.v2.DeleteCompanionAgentRequest;
import com.google.cloud.dialogflow.v2.GetCompanionAgentRequest;
import com.google.cloud.dialogflow.v2.ListCompanionAgentsRequest;
import com.google.cloud.dialogflow.v2.ListCompanionAgentsResponse;
import com.google.cloud.dialogflow.v2.UpdateCompanionAgentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the CompanionAgents service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcCompanionAgentsStub extends CompanionAgentsStub {
  private static final MethodDescriptor<CreateCompanionAgentRequest, CompanionAgent>
      createCompanionAgentMethodDescriptor =
          MethodDescriptor.<CreateCompanionAgentRequest, CompanionAgent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.CompanionAgents/CreateCompanionAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCompanionAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CompanionAgent.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetCompanionAgentRequest, CompanionAgent>
      getCompanionAgentMethodDescriptor =
          MethodDescriptor.<GetCompanionAgentRequest, CompanionAgent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.CompanionAgents/GetCompanionAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCompanionAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CompanionAgent.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateCompanionAgentRequest, CompanionAgent>
      updateCompanionAgentMethodDescriptor =
          MethodDescriptor.<UpdateCompanionAgentRequest, CompanionAgent>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.CompanionAgents/UpdateCompanionAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCompanionAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CompanionAgent.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteCompanionAgentRequest, Empty>
      deleteCompanionAgentMethodDescriptor =
          MethodDescriptor.<DeleteCompanionAgentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.CompanionAgents/DeleteCompanionAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCompanionAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListCompanionAgentsRequest, ListCompanionAgentsResponse>
      listCompanionAgentsMethodDescriptor =
          MethodDescriptor.<ListCompanionAgentsRequest, ListCompanionAgentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2.CompanionAgents/ListCompanionAgents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCompanionAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCompanionAgentsResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateCompanionAgentRequest, CompanionAgent>
      createCompanionAgentCallable;
  private final UnaryCallable<GetCompanionAgentRequest, CompanionAgent> getCompanionAgentCallable;
  private final UnaryCallable<UpdateCompanionAgentRequest, CompanionAgent>
      updateCompanionAgentCallable;
  private final UnaryCallable<DeleteCompanionAgentRequest, Empty> deleteCompanionAgentCallable;
  private final UnaryCallable<ListCompanionAgentsRequest, ListCompanionAgentsResponse>
      listCompanionAgentsCallable;
  private final UnaryCallable<ListCompanionAgentsRequest, ListCompanionAgentsPagedResponse>
      listCompanionAgentsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCompanionAgentsStub create(CompanionAgentsStubSettings settings)
      throws IOException {
    return new GrpcCompanionAgentsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCompanionAgentsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCompanionAgentsStub(
        CompanionAgentsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCompanionAgentsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCompanionAgentsStub(
        CompanionAgentsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCompanionAgentsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCompanionAgentsStub(
      CompanionAgentsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCompanionAgentsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCompanionAgentsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCompanionAgentsStub(
      CompanionAgentsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateCompanionAgentRequest, CompanionAgent>
        createCompanionAgentTransportSettings =
            GrpcCallSettings.<CreateCompanionAgentRequest, CompanionAgent>newBuilder()
                .setMethodDescriptor(createCompanionAgentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetCompanionAgentRequest, CompanionAgent> getCompanionAgentTransportSettings =
        GrpcCallSettings.<GetCompanionAgentRequest, CompanionAgent>newBuilder()
            .setMethodDescriptor(getCompanionAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateCompanionAgentRequest, CompanionAgent>
        updateCompanionAgentTransportSettings =
            GrpcCallSettings.<UpdateCompanionAgentRequest, CompanionAgent>newBuilder()
                .setMethodDescriptor(updateCompanionAgentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "companion_agent.name",
                          String.valueOf(request.getCompanionAgent().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteCompanionAgentRequest, Empty> deleteCompanionAgentTransportSettings =
        GrpcCallSettings.<DeleteCompanionAgentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCompanionAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListCompanionAgentsRequest, ListCompanionAgentsResponse>
        listCompanionAgentsTransportSettings =
            GrpcCallSettings.<ListCompanionAgentsRequest, ListCompanionAgentsResponse>newBuilder()
                .setMethodDescriptor(listCompanionAgentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
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

    this.createCompanionAgentCallable =
        callableFactory.createUnaryCallable(
            createCompanionAgentTransportSettings,
            settings.createCompanionAgentSettings(),
            clientContext);
    this.getCompanionAgentCallable =
        callableFactory.createUnaryCallable(
            getCompanionAgentTransportSettings,
            settings.getCompanionAgentSettings(),
            clientContext);
    this.updateCompanionAgentCallable =
        callableFactory.createUnaryCallable(
            updateCompanionAgentTransportSettings,
            settings.updateCompanionAgentSettings(),
            clientContext);
    this.deleteCompanionAgentCallable =
        callableFactory.createUnaryCallable(
            deleteCompanionAgentTransportSettings,
            settings.deleteCompanionAgentSettings(),
            clientContext);
    this.listCompanionAgentsCallable =
        callableFactory.createUnaryCallable(
            listCompanionAgentsTransportSettings,
            settings.listCompanionAgentsSettings(),
            clientContext);
    this.listCompanionAgentsPagedCallable =
        callableFactory.createPagedCallable(
            listCompanionAgentsTransportSettings,
            settings.listCompanionAgentsSettings(),
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
  public UnaryCallable<CreateCompanionAgentRequest, CompanionAgent> createCompanionAgentCallable() {
    return createCompanionAgentCallable;
  }

  @Override
  public UnaryCallable<GetCompanionAgentRequest, CompanionAgent> getCompanionAgentCallable() {
    return getCompanionAgentCallable;
  }

  @Override
  public UnaryCallable<UpdateCompanionAgentRequest, CompanionAgent> updateCompanionAgentCallable() {
    return updateCompanionAgentCallable;
  }

  @Override
  public UnaryCallable<DeleteCompanionAgentRequest, Empty> deleteCompanionAgentCallable() {
    return deleteCompanionAgentCallable;
  }

  @Override
  public UnaryCallable<ListCompanionAgentsRequest, ListCompanionAgentsResponse>
      listCompanionAgentsCallable() {
    return listCompanionAgentsCallable;
  }

  @Override
  public UnaryCallable<ListCompanionAgentsRequest, ListCompanionAgentsPagedResponse>
      listCompanionAgentsPagedCallable() {
    return listCompanionAgentsPagedCallable;
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
