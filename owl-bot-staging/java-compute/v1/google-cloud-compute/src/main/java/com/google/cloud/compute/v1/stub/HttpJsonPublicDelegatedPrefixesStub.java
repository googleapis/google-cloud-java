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

import static com.google.cloud.compute.v1.PublicDelegatedPrefixesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.PublicDelegatedPrefixesClient.ListPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListPublicDelegatedPrefixesRequest;
import com.google.cloud.compute.v1.DeletePublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.GetPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.InsertPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.ListPublicDelegatedPrefixesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.PublicDelegatedPrefix;
import com.google.cloud.compute.v1.PublicDelegatedPrefixAggregatedList;
import com.google.cloud.compute.v1.PublicDelegatedPrefixList;
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
 * REST stub implementation for the PublicDelegatedPrefixes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonPublicDelegatedPrefixesStub extends PublicDelegatedPrefixesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AggregatedListPublicDelegatedPrefixesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/publicDelegatedPrefixes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListPublicDelegatedPrefixesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListPublicDelegatedPrefixesRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasIncludeAllScopes()) {
                              serializer.putQueryParam(
                                  fields, "includeAllScopes", request.getIncludeAllScopes());
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
                  ProtoMessageResponseParser.<PublicDelegatedPrefixAggregatedList>newBuilder()
                      .setDefaultInstance(PublicDelegatedPrefixAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePublicDelegatedPrefixeRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeletePublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePublicDelegatedPrefixeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields,
                                "publicDelegatedPrefix",
                                request.getPublicDelegatedPrefix());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePublicDelegatedPrefixeRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
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
                  (DeletePublicDelegatedPrefixeRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPublicDelegatedPrefixeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields,
                                "publicDelegatedPrefix",
                                request.getPublicDelegatedPrefix());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPublicDelegatedPrefixeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PublicDelegatedPrefix>newBuilder()
                      .setDefaultInstance(PublicDelegatedPrefix.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertPublicDelegatedPrefixeRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertPublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/publicDelegatedPrefixes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertPublicDelegatedPrefixeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertPublicDelegatedPrefixeRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "publicDelegatedPrefixResource",
                                      request.getPublicDelegatedPrefixResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertPublicDelegatedPrefixeRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<
          ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPublicDelegatedPrefixesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/publicDelegatedPrefixes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPublicDelegatedPrefixesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPublicDelegatedPrefixesRequest> serializer =
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
                  ProtoMessageResponseParser.<PublicDelegatedPrefixList>newBuilder()
                      .setDefaultInstance(PublicDelegatedPrefixList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchPublicDelegatedPrefixeRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchPublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.PublicDelegatedPrefixes/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchPublicDelegatedPrefixeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields,
                                "publicDelegatedPrefix",
                                request.getPublicDelegatedPrefix());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchPublicDelegatedPrefixeRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "publicDelegatedPrefixResource",
                                      request.getPublicDelegatedPrefixResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchPublicDelegatedPrefixeRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<
          AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<
          AggregatedListPublicDelegatedPrefixesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeletePublicDelegatedPrefixeRequest, Operation> deleteCallable;
  private final OperationCallable<DeletePublicDelegatedPrefixeRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix> getCallable;
  private final UnaryCallable<InsertPublicDelegatedPrefixeRequest, Operation> insertCallable;
  private final OperationCallable<InsertPublicDelegatedPrefixeRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listCallable;
  private final UnaryCallable<ListPublicDelegatedPrefixesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchPublicDelegatedPrefixeRequest, Operation> patchCallable;
  private final OperationCallable<PatchPublicDelegatedPrefixeRequest, Operation, Operation>
      patchOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPublicDelegatedPrefixesStub create(
      PublicDelegatedPrefixesStubSettings settings) throws IOException {
    return new HttpJsonPublicDelegatedPrefixesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPublicDelegatedPrefixesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPublicDelegatedPrefixesStub(
        PublicDelegatedPrefixesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonPublicDelegatedPrefixesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPublicDelegatedPrefixesStub(
        PublicDelegatedPrefixesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPublicDelegatedPrefixesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPublicDelegatedPrefixesStub(
      PublicDelegatedPrefixesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonPublicDelegatedPrefixesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPublicDelegatedPrefixesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPublicDelegatedPrefixesStub(
      PublicDelegatedPrefixesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<
            AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeletePublicDelegatedPrefixeRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeletePublicDelegatedPrefixeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertPublicDelegatedPrefixeRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertPublicDelegatedPrefixeRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchPublicDelegatedPrefixeRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchPublicDelegatedPrefixeRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.insertOperationCallable =
        callableFactory.createOperationCallable(
            insertTransportSettings,
            settings.insertOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          AggregatedListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListPublicDelegatedPrefixesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePublicDelegatedPrefixeRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeletePublicDelegatedPrefixeRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertPublicDelegatedPrefixeRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertPublicDelegatedPrefixeRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListPublicDelegatedPrefixesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchPublicDelegatedPrefixeRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchPublicDelegatedPrefixeRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
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
