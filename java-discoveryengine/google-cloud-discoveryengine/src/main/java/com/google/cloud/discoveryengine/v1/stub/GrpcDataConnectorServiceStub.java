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

package com.google.cloud.discoveryengine.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.DataConnector;
import com.google.cloud.discoveryengine.v1.GetDataConnectorRequest;
import com.google.cloud.discoveryengine.v1.SetUpDataConnectorMetadata;
import com.google.cloud.discoveryengine.v1.SetUpDataConnectorRequest;
import com.google.cloud.discoveryengine.v1.UpdateDataConnectorRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataConnectorService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcDataConnectorServiceStub extends DataConnectorServiceStub {
  private static final MethodDescriptor<SetUpDataConnectorRequest, Operation>
      setUpDataConnectorMethodDescriptor =
          MethodDescriptor.<SetUpDataConnectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.DataConnectorService/SetUpDataConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetUpDataConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataConnectorRequest, DataConnector>
      getDataConnectorMethodDescriptor =
          MethodDescriptor.<GetDataConnectorRequest, DataConnector>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.DataConnectorService/GetDataConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataConnector.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataConnectorRequest, DataConnector>
      updateDataConnectorMethodDescriptor =
          MethodDescriptor.<UpdateDataConnectorRequest, DataConnector>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.DataConnectorService/UpdateDataConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataConnector.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<SetUpDataConnectorRequest, Operation> setUpDataConnectorCallable;
  private final OperationCallable<
          SetUpDataConnectorRequest, DataConnector, SetUpDataConnectorMetadata>
      setUpDataConnectorOperationCallable;
  private final UnaryCallable<GetDataConnectorRequest, DataConnector> getDataConnectorCallable;
  private final UnaryCallable<UpdateDataConnectorRequest, DataConnector>
      updateDataConnectorCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataConnectorServiceStub create(DataConnectorServiceStubSettings settings)
      throws IOException {
    return new GrpcDataConnectorServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataConnectorServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataConnectorServiceStub(
        DataConnectorServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataConnectorServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataConnectorServiceStub(
        DataConnectorServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataConnectorServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataConnectorServiceStub(
      DataConnectorServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataConnectorServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataConnectorServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataConnectorServiceStub(
      DataConnectorServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SetUpDataConnectorRequest, Operation> setUpDataConnectorTransportSettings =
        GrpcCallSettings.<SetUpDataConnectorRequest, Operation>newBuilder()
            .setMethodDescriptor(setUpDataConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetDataConnectorRequest, DataConnector> getDataConnectorTransportSettings =
        GrpcCallSettings.<GetDataConnectorRequest, DataConnector>newBuilder()
            .setMethodDescriptor(getDataConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateDataConnectorRequest, DataConnector>
        updateDataConnectorTransportSettings =
            GrpcCallSettings.<UpdateDataConnectorRequest, DataConnector>newBuilder()
                .setMethodDescriptor(updateDataConnectorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_connector.name",
                          String.valueOf(request.getDataConnector().getName()));
                      return builder.build();
                    })
                .build();

    this.setUpDataConnectorCallable =
        callableFactory.createUnaryCallable(
            setUpDataConnectorTransportSettings,
            settings.setUpDataConnectorSettings(),
            clientContext);
    this.setUpDataConnectorOperationCallable =
        callableFactory.createOperationCallable(
            setUpDataConnectorTransportSettings,
            settings.setUpDataConnectorOperationSettings(),
            clientContext,
            operationsStub);
    this.getDataConnectorCallable =
        callableFactory.createUnaryCallable(
            getDataConnectorTransportSettings, settings.getDataConnectorSettings(), clientContext);
    this.updateDataConnectorCallable =
        callableFactory.createUnaryCallable(
            updateDataConnectorTransportSettings,
            settings.updateDataConnectorSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SetUpDataConnectorRequest, Operation> setUpDataConnectorCallable() {
    return setUpDataConnectorCallable;
  }

  @Override
  public OperationCallable<SetUpDataConnectorRequest, DataConnector, SetUpDataConnectorMetadata>
      setUpDataConnectorOperationCallable() {
    return setUpDataConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<GetDataConnectorRequest, DataConnector> getDataConnectorCallable() {
    return getDataConnectorCallable;
  }

  @Override
  public UnaryCallable<UpdateDataConnectorRequest, DataConnector> updateDataConnectorCallable() {
    return updateDataConnectorCallable;
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
