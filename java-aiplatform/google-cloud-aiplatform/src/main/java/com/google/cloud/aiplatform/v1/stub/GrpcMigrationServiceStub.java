/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.aiplatform.v1.MigrationServiceClient.SearchMigratableResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.BatchMigrateResourcesOperationMetadata;
import com.google.cloud.aiplatform.v1.BatchMigrateResourcesRequest;
import com.google.cloud.aiplatform.v1.BatchMigrateResourcesResponse;
import com.google.cloud.aiplatform.v1.SearchMigratableResourcesRequest;
import com.google.cloud.aiplatform.v1.SearchMigratableResourcesResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MigrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcMigrationServiceStub extends MigrationServiceStub {
  private static final MethodDescriptor<
          SearchMigratableResourcesRequest, SearchMigratableResourcesResponse>
      searchMigratableResourcesMethodDescriptor =
          MethodDescriptor
              .<SearchMigratableResourcesRequest, SearchMigratableResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.MigrationService/SearchMigratableResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchMigratableResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchMigratableResourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchMigrateResourcesRequest, Operation>
      batchMigrateResourcesMethodDescriptor =
          MethodDescriptor.<BatchMigrateResourcesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.MigrationService/BatchMigrateResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchMigrateResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<SearchMigratableResourcesRequest, SearchMigratableResourcesResponse>
      searchMigratableResourcesCallable;
  private final UnaryCallable<
          SearchMigratableResourcesRequest, SearchMigratableResourcesPagedResponse>
      searchMigratableResourcesPagedCallable;
  private final UnaryCallable<BatchMigrateResourcesRequest, Operation>
      batchMigrateResourcesCallable;
  private final OperationCallable<
          BatchMigrateResourcesRequest,
          BatchMigrateResourcesResponse,
          BatchMigrateResourcesOperationMetadata>
      batchMigrateResourcesOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMigrationServiceStub create(MigrationServiceStubSettings settings)
      throws IOException {
    return new GrpcMigrationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMigrationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMigrationServiceStub(
        MigrationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMigrationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMigrationServiceStub(
        MigrationServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMigrationServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMigrationServiceStub(
      MigrationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcMigrationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMigrationServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMigrationServiceStub(
      MigrationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SearchMigratableResourcesRequest, SearchMigratableResourcesResponse>
        searchMigratableResourcesTransportSettings =
            GrpcCallSettings
                .<SearchMigratableResourcesRequest, SearchMigratableResourcesResponse>newBuilder()
                .setMethodDescriptor(searchMigratableResourcesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<SearchMigratableResourcesRequest>() {
                      @Override
                      public Map<String, String> extract(SearchMigratableResourcesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<BatchMigrateResourcesRequest, Operation>
        batchMigrateResourcesTransportSettings =
            GrpcCallSettings.<BatchMigrateResourcesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchMigrateResourcesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchMigrateResourcesRequest>() {
                      @Override
                      public Map<String, String> extract(BatchMigrateResourcesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.searchMigratableResourcesCallable =
        callableFactory.createUnaryCallable(
            searchMigratableResourcesTransportSettings,
            settings.searchMigratableResourcesSettings(),
            clientContext);
    this.searchMigratableResourcesPagedCallable =
        callableFactory.createPagedCallable(
            searchMigratableResourcesTransportSettings,
            settings.searchMigratableResourcesSettings(),
            clientContext);
    this.batchMigrateResourcesCallable =
        callableFactory.createUnaryCallable(
            batchMigrateResourcesTransportSettings,
            settings.batchMigrateResourcesSettings(),
            clientContext);
    this.batchMigrateResourcesOperationCallable =
        callableFactory.createOperationCallable(
            batchMigrateResourcesTransportSettings,
            settings.batchMigrateResourcesOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<SearchMigratableResourcesRequest, SearchMigratableResourcesResponse>
      searchMigratableResourcesCallable() {
    return searchMigratableResourcesCallable;
  }

  public UnaryCallable<SearchMigratableResourcesRequest, SearchMigratableResourcesPagedResponse>
      searchMigratableResourcesPagedCallable() {
    return searchMigratableResourcesPagedCallable;
  }

  public UnaryCallable<BatchMigrateResourcesRequest, Operation> batchMigrateResourcesCallable() {
    return batchMigrateResourcesCallable;
  }

  public OperationCallable<
          BatchMigrateResourcesRequest,
          BatchMigrateResourcesResponse,
          BatchMigrateResourcesOperationMetadata>
      batchMigrateResourcesOperationCallable() {
    return batchMigrateResourcesOperationCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
