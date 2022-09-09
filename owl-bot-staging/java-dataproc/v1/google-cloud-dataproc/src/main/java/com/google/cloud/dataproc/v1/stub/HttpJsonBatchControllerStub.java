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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.BatchControllerClient.ListBatchesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.Batch;
import com.google.cloud.dataproc.v1.BatchOperationMetadata;
import com.google.cloud.dataproc.v1.CreateBatchRequest;
import com.google.cloud.dataproc.v1.DeleteBatchRequest;
import com.google.cloud.dataproc.v1.GetBatchRequest;
import com.google.cloud.dataproc.v1.ListBatchesRequest;
import com.google.cloud.dataproc.v1.ListBatchesResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the BatchController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonBatchControllerStub extends BatchControllerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Batch.getDescriptor())
          .add(BatchOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateBatchRequest, Operation>
      createBatchMethodDescriptor =
          ApiMethodDescriptor.<CreateBatchRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.BatchController/CreateBatch")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBatchRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/batches",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBatchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBatchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "batchId", request.getBatchId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("batch", request.getBatch(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBatchRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetBatchRequest, Batch> getBatchMethodDescriptor =
      ApiMethodDescriptor.<GetBatchRequest, Batch>newBuilder()
          .setFullMethodName("google.cloud.dataproc.v1.BatchController/GetBatch")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBatchRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/batches/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetBatchRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetBatchRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Batch>newBuilder()
                  .setDefaultInstance(Batch.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListBatchesRequest, ListBatchesResponse>
      listBatchesMethodDescriptor =
          ApiMethodDescriptor.<ListBatchesRequest, ListBatchesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.BatchController/ListBatches")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBatchesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/batches",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBatchesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBatchesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBatchesResponse>newBuilder()
                      .setDefaultInstance(ListBatchesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBatchRequest, Empty> deleteBatchMethodDescriptor =
      ApiMethodDescriptor.<DeleteBatchRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.dataproc.v1.BatchController/DeleteBatch")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteBatchRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/batches/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteBatchRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteBatchRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private final UnaryCallable<CreateBatchRequest, Operation> createBatchCallable;
  private final OperationCallable<CreateBatchRequest, Batch, BatchOperationMetadata>
      createBatchOperationCallable;
  private final UnaryCallable<GetBatchRequest, Batch> getBatchCallable;
  private final UnaryCallable<ListBatchesRequest, ListBatchesResponse> listBatchesCallable;
  private final UnaryCallable<ListBatchesRequest, ListBatchesPagedResponse>
      listBatchesPagedCallable;
  private final UnaryCallable<DeleteBatchRequest, Empty> deleteBatchCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBatchControllerStub create(BatchControllerStubSettings settings)
      throws IOException {
    return new HttpJsonBatchControllerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBatchControllerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBatchControllerStub(
        BatchControllerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBatchControllerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBatchControllerStub(
        BatchControllerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBatchControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBatchControllerStub(
      BatchControllerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBatchControllerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBatchControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBatchControllerStub(
      BatchControllerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateBatchRequest, Operation> createBatchTransportSettings =
        HttpJsonCallSettings.<CreateBatchRequest, Operation>newBuilder()
            .setMethodDescriptor(createBatchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetBatchRequest, Batch> getBatchTransportSettings =
        HttpJsonCallSettings.<GetBatchRequest, Batch>newBuilder()
            .setMethodDescriptor(getBatchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListBatchesRequest, ListBatchesResponse> listBatchesTransportSettings =
        HttpJsonCallSettings.<ListBatchesRequest, ListBatchesResponse>newBuilder()
            .setMethodDescriptor(listBatchesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteBatchRequest, Empty> deleteBatchTransportSettings =
        HttpJsonCallSettings.<DeleteBatchRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBatchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createBatchCallable =
        callableFactory.createUnaryCallable(
            createBatchTransportSettings, settings.createBatchSettings(), clientContext);
    this.createBatchOperationCallable =
        callableFactory.createOperationCallable(
            createBatchTransportSettings,
            settings.createBatchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getBatchCallable =
        callableFactory.createUnaryCallable(
            getBatchTransportSettings, settings.getBatchSettings(), clientContext);
    this.listBatchesCallable =
        callableFactory.createUnaryCallable(
            listBatchesTransportSettings, settings.listBatchesSettings(), clientContext);
    this.listBatchesPagedCallable =
        callableFactory.createPagedCallable(
            listBatchesTransportSettings, settings.listBatchesSettings(), clientContext);
    this.deleteBatchCallable =
        callableFactory.createUnaryCallable(
            deleteBatchTransportSettings, settings.deleteBatchSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createBatchMethodDescriptor);
    methodDescriptors.add(getBatchMethodDescriptor);
    methodDescriptors.add(listBatchesMethodDescriptor);
    methodDescriptors.add(deleteBatchMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateBatchRequest, Operation> createBatchCallable() {
    return createBatchCallable;
  }

  @Override
  public OperationCallable<CreateBatchRequest, Batch, BatchOperationMetadata>
      createBatchOperationCallable() {
    return createBatchOperationCallable;
  }

  @Override
  public UnaryCallable<GetBatchRequest, Batch> getBatchCallable() {
    return getBatchCallable;
  }

  @Override
  public UnaryCallable<ListBatchesRequest, ListBatchesResponse> listBatchesCallable() {
    return listBatchesCallable;
  }

  @Override
  public UnaryCallable<ListBatchesRequest, ListBatchesPagedResponse> listBatchesPagedCallable() {
    return listBatchesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBatchRequest, Empty> deleteBatchCallable() {
    return deleteBatchCallable;
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
