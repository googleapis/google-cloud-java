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

import static com.google.cloud.compute.v1.GlobalPublicDelegatedPrefixesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteGlobalPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.GetGlobalPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.InsertGlobalPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.ListGlobalPublicDelegatedPrefixesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchGlobalPublicDelegatedPrefixeRequest;
import com.google.cloud.compute.v1.PublicDelegatedPrefix;
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
 * REST stub implementation for the GlobalPublicDelegatedPrefixes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonGlobalPublicDelegatedPrefixesStub extends GlobalPublicDelegatedPrefixesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteGlobalPublicDelegatedPrefixeRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalPublicDelegatedPrefixes/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteGlobalPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalPublicDelegatedPrefixeRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields,
                                "publicDelegatedPrefix",
                                request.getPublicDelegatedPrefix());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlobalPublicDelegatedPrefixeRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (DeleteGlobalPublicDelegatedPrefixeRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
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
          GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalPublicDelegatedPrefixes/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlobalPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalPublicDelegatedPrefixeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields,
                                "publicDelegatedPrefix",
                                request.getPublicDelegatedPrefix());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlobalPublicDelegatedPrefixeRequest> serializer =
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

  private static final ApiMethodDescriptor<InsertGlobalPublicDelegatedPrefixeRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalPublicDelegatedPrefixes/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<InsertGlobalPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicDelegatedPrefixes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertGlobalPublicDelegatedPrefixeRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertGlobalPublicDelegatedPrefixeRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (InsertGlobalPublicDelegatedPrefixeRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
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
          ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalPublicDelegatedPrefixes/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListGlobalPublicDelegatedPrefixesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicDelegatedPrefixes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalPublicDelegatedPrefixesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlobalPublicDelegatedPrefixesRequest>
                                serializer = ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<PatchGlobalPublicDelegatedPrefixeRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.GlobalPublicDelegatedPrefixes/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchGlobalPublicDelegatedPrefixeRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchGlobalPublicDelegatedPrefixeRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields,
                                "publicDelegatedPrefix",
                                request.getPublicDelegatedPrefix());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchGlobalPublicDelegatedPrefixeRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (PatchGlobalPublicDelegatedPrefixeRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<DeleteGlobalPublicDelegatedPrefixeRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteGlobalPublicDelegatedPrefixeRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getCallable;
  private final UnaryCallable<InsertGlobalPublicDelegatedPrefixeRequest, Operation> insertCallable;
  private final OperationCallable<InsertGlobalPublicDelegatedPrefixeRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listCallable;
  private final UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchGlobalPublicDelegatedPrefixeRequest, Operation> patchCallable;
  private final OperationCallable<PatchGlobalPublicDelegatedPrefixeRequest, Operation, Operation>
      patchOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalPublicDelegatedPrefixesStub create(
      GlobalPublicDelegatedPrefixesStubSettings settings) throws IOException {
    return new HttpJsonGlobalPublicDelegatedPrefixesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalPublicDelegatedPrefixesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalPublicDelegatedPrefixesStub(
        GlobalPublicDelegatedPrefixesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalPublicDelegatedPrefixesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalPublicDelegatedPrefixesStub(
        GlobalPublicDelegatedPrefixesStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalPublicDelegatedPrefixesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalPublicDelegatedPrefixesStub(
      GlobalPublicDelegatedPrefixesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGlobalPublicDelegatedPrefixesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalPublicDelegatedPrefixesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalPublicDelegatedPrefixesStub(
      GlobalPublicDelegatedPrefixesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteGlobalPublicDelegatedPrefixeRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertGlobalPublicDelegatedPrefixeRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchGlobalPublicDelegatedPrefixeRequest, Operation>
        patchTransportSettings =
            HttpJsonCallSettings.<PatchGlobalPublicDelegatedPrefixeRequest, Operation>newBuilder()
                .setMethodDescriptor(patchMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

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
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteGlobalPublicDelegatedPrefixeRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteGlobalPublicDelegatedPrefixeRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetGlobalPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
      getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertGlobalPublicDelegatedPrefixeRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertGlobalPublicDelegatedPrefixeRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListGlobalPublicDelegatedPrefixesRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchGlobalPublicDelegatedPrefixeRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchGlobalPublicDelegatedPrefixeRequest, Operation, Operation>
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
