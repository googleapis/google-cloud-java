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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionOperationsClient.ListPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonLongRunningClient;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionOperationRequest;
import com.google.cloud.compute.v1.DeleteRegionOperationResponse;
import com.google.cloud.compute.v1.GetRegionOperationRequest;
import com.google.cloud.compute.v1.ListRegionOperationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.OperationList;
import com.google.cloud.compute.v1.WaitRegionOperationRequest;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the RegionOperations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRegionOperationsStub extends RegionOperationsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          DeleteRegionOperationRequest, DeleteRegionOperationResponse>
      deleteMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteRegionOperationRequest, DeleteRegionOperationResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionOperations/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/operations/{operation}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "operation", request.getOperation());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeleteRegionOperationResponse>newBuilder()
                      .setDefaultInstance(DeleteRegionOperationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRegionOperationRequest, Operation>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionOperations/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/operations/{operation}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "operation", request.getOperation());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (GetRegionOperationRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .setPollingRequestFactory(
                  compoundOperationId -> {
                    List<String> idComponents = Arrays.asList(compoundOperationId.split(":"));
                    return GetRegionOperationRequest.newBuilder()
                        .setOperation(idComponents.get(0))
                        .setProject(idComponents.get(1))
                        .setRegion(idComponents.get(2))
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListRegionOperationsRequest, OperationList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionOperationsRequest, OperationList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionOperations/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionOperationsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/operations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionOperationsRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OperationList>newBuilder()
                      .setDefaultInstance(OperationList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<WaitRegionOperationRequest, Operation>
      waitMethodDescriptor =
          ApiMethodDescriptor.<WaitRegionOperationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionOperations/Wait")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<WaitRegionOperationRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/operations/{operation}/wait",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<WaitRegionOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "operation", request.getOperation());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<WaitRegionOperationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<DeleteRegionOperationRequest, DeleteRegionOperationResponse>
      deleteCallable;
  private final UnaryCallable<GetRegionOperationRequest, Operation> getCallable;
  private final UnaryCallable<ListRegionOperationsRequest, OperationList> listCallable;
  private final UnaryCallable<ListRegionOperationsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<WaitRegionOperationRequest, Operation> waitCallable;

  private final BackgroundResource backgroundResources;
  private final LongRunningClient longRunningClient;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionOperationsStub create(RegionOperationsStubSettings settings)
      throws IOException {
    return new HttpJsonRegionOperationsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionOperationsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionOperationsStub(
        RegionOperationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionOperationsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionOperationsStub(
        RegionOperationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionOperationsStub(
      RegionOperationsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionOperationsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionOperationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionOperationsStub(
      RegionOperationsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionOperationRequest, DeleteRegionOperationResponse>
        deleteTransportSettings =
            HttpJsonCallSettings
                .<DeleteRegionOperationRequest, DeleteRegionOperationResponse>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRegionOperationRequest, Operation> getTransportSettings =
        HttpJsonCallSettings.<GetRegionOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRegionOperationsRequest, OperationList> listTransportSettings =
        HttpJsonCallSettings.<ListRegionOperationsRequest, OperationList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<WaitRegionOperationRequest, Operation> waitTransportSettings =
        HttpJsonCallSettings.<WaitRegionOperationRequest, Operation>newBuilder()
            .setMethodDescriptor(waitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.waitCallable =
        callableFactory.createUnaryCallable(
            waitTransportSettings, settings.waitSettings(), clientContext);

    this.longRunningClient =
        new HttpJsonLongRunningClient<GetRegionOperationRequest, Operation>(
            getCallable,
            getMethodDescriptor.getOperationSnapshotFactory(),
            getMethodDescriptor.getPollingRequestFactory());
    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(waitMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteRegionOperationRequest, DeleteRegionOperationResponse>
      deleteCallable() {
    return deleteCallable;
  }

  @Override
  public UnaryCallable<GetRegionOperationRequest, Operation> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<ListRegionOperationsRequest, OperationList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionOperationsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<WaitRegionOperationRequest, Operation> waitCallable() {
    return waitCallable;
  }

  @Override
  public LongRunningClient longRunningClient() {
    return longRunningClient;
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
