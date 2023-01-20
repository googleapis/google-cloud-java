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

package com.google.cloud.run.v2.stub;

import static com.google.cloud.run.v2.RevisionsClient.ListRevisionsPagedResponse;

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
import com.google.cloud.run.v2.DeleteRevisionRequest;
import com.google.cloud.run.v2.GetRevisionRequest;
import com.google.cloud.run.v2.ListRevisionsRequest;
import com.google.cloud.run.v2.ListRevisionsResponse;
import com.google.cloud.run.v2.Revision;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the Revisions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRevisionsStub extends RevisionsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Revision.getDescriptor()).build();

  private static final ApiMethodDescriptor<GetRevisionRequest, Revision>
      getRevisionMethodDescriptor =
          ApiMethodDescriptor.<GetRevisionRequest, Revision>newBuilder()
              .setFullMethodName("google.cloud.run.v2.Revisions/GetRevision")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRevisionRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/services/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Revision>newBuilder()
                      .setDefaultInstance(Revision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRevisionsRequest, ListRevisionsResponse>
      listRevisionsMethodDescriptor =
          ApiMethodDescriptor.<ListRevisionsRequest, ListRevisionsResponse>newBuilder()
              .setFullMethodName("google.cloud.run.v2.Revisions/ListRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRevisionsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/services/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRevisionRequest, Operation>
      deleteRevisionMethodDescriptor =
          ApiMethodDescriptor.<DeleteRevisionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.run.v2.Revisions/DeleteRevision")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRevisionRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/services/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                  (DeleteRevisionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable;
  private final UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable;
  private final UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable;
  private final UnaryCallable<DeleteRevisionRequest, Operation> deleteRevisionCallable;
  private final OperationCallable<DeleteRevisionRequest, Revision, Revision>
      deleteRevisionOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRevisionsStub create(RevisionsStubSettings settings)
      throws IOException {
    return new HttpJsonRevisionsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRevisionsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonRevisionsStub(
        RevisionsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRevisionsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRevisionsStub(
        RevisionsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRevisionsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRevisionsStub(RevisionsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRevisionsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRevisionsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRevisionsStub(
      RevisionsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetRevisionRequest, Revision> getRevisionTransportSettings =
        HttpJsonCallSettings.<GetRevisionRequest, Revision>newBuilder()
            .setMethodDescriptor(getRevisionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRevisionsRequest, ListRevisionsResponse>
        listRevisionsTransportSettings =
            HttpJsonCallSettings.<ListRevisionsRequest, ListRevisionsResponse>newBuilder()
                .setMethodDescriptor(listRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteRevisionRequest, Operation> deleteRevisionTransportSettings =
        HttpJsonCallSettings.<DeleteRevisionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRevisionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.getRevisionCallable =
        callableFactory.createUnaryCallable(
            getRevisionTransportSettings, settings.getRevisionSettings(), clientContext);
    this.listRevisionsCallable =
        callableFactory.createUnaryCallable(
            listRevisionsTransportSettings, settings.listRevisionsSettings(), clientContext);
    this.listRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listRevisionsTransportSettings, settings.listRevisionsSettings(), clientContext);
    this.deleteRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteRevisionTransportSettings, settings.deleteRevisionSettings(), clientContext);
    this.deleteRevisionOperationCallable =
        callableFactory.createOperationCallable(
            deleteRevisionTransportSettings,
            settings.deleteRevisionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getRevisionMethodDescriptor);
    methodDescriptors.add(listRevisionsMethodDescriptor);
    methodDescriptors.add(deleteRevisionMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable() {
    return getRevisionCallable;
  }

  @Override
  public UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable() {
    return listRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable() {
    return listRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRevisionRequest, Operation> deleteRevisionCallable() {
    return deleteRevisionCallable;
  }

  @Override
  public OperationCallable<DeleteRevisionRequest, Revision, Revision>
      deleteRevisionOperationCallable() {
    return deleteRevisionOperationCallable;
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
