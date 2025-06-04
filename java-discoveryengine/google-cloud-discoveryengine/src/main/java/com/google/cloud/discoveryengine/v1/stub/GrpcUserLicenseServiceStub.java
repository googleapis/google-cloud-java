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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.UserLicenseServiceClient.ListUserLicensesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesMetadata;
import com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesRequest;
import com.google.cloud.discoveryengine.v1.BatchUpdateUserLicensesResponse;
import com.google.cloud.discoveryengine.v1.ListUserLicensesRequest;
import com.google.cloud.discoveryengine.v1.ListUserLicensesResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the UserLicenseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcUserLicenseServiceStub extends UserLicenseServiceStub {
  private static final MethodDescriptor<ListUserLicensesRequest, ListUserLicensesResponse>
      listUserLicensesMethodDescriptor =
          MethodDescriptor.<ListUserLicensesRequest, ListUserLicensesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.UserLicenseService/ListUserLicenses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUserLicensesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUserLicensesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchUpdateUserLicensesRequest, Operation>
      batchUpdateUserLicensesMethodDescriptor =
          MethodDescriptor.<BatchUpdateUserLicensesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.UserLicenseService/BatchUpdateUserLicenses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateUserLicensesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListUserLicensesRequest, ListUserLicensesResponse>
      listUserLicensesCallable;
  private final UnaryCallable<ListUserLicensesRequest, ListUserLicensesPagedResponse>
      listUserLicensesPagedCallable;
  private final UnaryCallable<BatchUpdateUserLicensesRequest, Operation>
      batchUpdateUserLicensesCallable;
  private final OperationCallable<
          BatchUpdateUserLicensesRequest,
          BatchUpdateUserLicensesResponse,
          BatchUpdateUserLicensesMetadata>
      batchUpdateUserLicensesOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcUserLicenseServiceStub create(UserLicenseServiceStubSettings settings)
      throws IOException {
    return new GrpcUserLicenseServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcUserLicenseServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcUserLicenseServiceStub(
        UserLicenseServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcUserLicenseServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcUserLicenseServiceStub(
        UserLicenseServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcUserLicenseServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcUserLicenseServiceStub(
      UserLicenseServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcUserLicenseServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcUserLicenseServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcUserLicenseServiceStub(
      UserLicenseServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListUserLicensesRequest, ListUserLicensesResponse>
        listUserLicensesTransportSettings =
            GrpcCallSettings.<ListUserLicensesRequest, ListUserLicensesResponse>newBuilder()
                .setMethodDescriptor(listUserLicensesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchUpdateUserLicensesRequest, Operation>
        batchUpdateUserLicensesTransportSettings =
            GrpcCallSettings.<BatchUpdateUserLicensesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchUpdateUserLicensesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listUserLicensesCallable =
        callableFactory.createUnaryCallable(
            listUserLicensesTransportSettings, settings.listUserLicensesSettings(), clientContext);
    this.listUserLicensesPagedCallable =
        callableFactory.createPagedCallable(
            listUserLicensesTransportSettings, settings.listUserLicensesSettings(), clientContext);
    this.batchUpdateUserLicensesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateUserLicensesTransportSettings,
            settings.batchUpdateUserLicensesSettings(),
            clientContext);
    this.batchUpdateUserLicensesOperationCallable =
        callableFactory.createOperationCallable(
            batchUpdateUserLicensesTransportSettings,
            settings.batchUpdateUserLicensesOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListUserLicensesRequest, ListUserLicensesResponse>
      listUserLicensesCallable() {
    return listUserLicensesCallable;
  }

  @Override
  public UnaryCallable<ListUserLicensesRequest, ListUserLicensesPagedResponse>
      listUserLicensesPagedCallable() {
    return listUserLicensesPagedCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateUserLicensesRequest, Operation>
      batchUpdateUserLicensesCallable() {
    return batchUpdateUserLicensesCallable;
  }

  @Override
  public OperationCallable<
          BatchUpdateUserLicensesRequest,
          BatchUpdateUserLicensesResponse,
          BatchUpdateUserLicensesMetadata>
      batchUpdateUserLicensesOperationCallable() {
    return batchUpdateUserLicensesOperationCallable;
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
