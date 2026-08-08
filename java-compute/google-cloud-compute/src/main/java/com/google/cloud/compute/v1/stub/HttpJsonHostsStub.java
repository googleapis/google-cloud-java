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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.HostsClient.ListPagedResponse;

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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.GetHostRequest;
import com.google.cloud.compute.v1.GetVersionHostRequest;
import com.google.cloud.compute.v1.Host;
import com.google.cloud.compute.v1.HostsListResponse;
import com.google.cloud.compute.v1.ListHostsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Hosts service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonHostsStub extends HostsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<GetHostRequest, Host> getMethodDescriptor =
      ApiMethodDescriptor.<GetHostRequest, Host>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.Hosts/Get")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetHostRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/zones/{zone}/{association}/hosts/{host}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetHostRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "association", request.getAssociation());
                        serializer.putPathParam(fields, "host", request.getHost());
                        serializer.putPathParam(fields, "project", request.getProject());
                        serializer.putPathParam(fields, "zone", request.getZone());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetHostRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Host>newBuilder()
                  .setDefaultInstance(Host.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetVersionHostRequest, Operation>
      getVersionMethodDescriptor =
          ApiMethodDescriptor.<GetVersionHostRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Hosts/GetVersion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetVersionHostRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/{association}/hosts/{host}/getVersion",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetVersionHostRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "association", request.getAssociation());
                            serializer.putPathParam(fields, "host", request.getHost());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetVersionHostRequest> serializer =
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
                                      "hostsGetVersionRequestResource",
                                      request.getHostsGetVersionRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (GetVersionHostRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListHostsRequest, HostsListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListHostsRequest, HostsListResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Hosts/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListHostsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/{association}/hosts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListHostsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "association", request.getAssociation());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListHostsRequest> serializer =
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
                  ProtoMessageResponseParser.<HostsListResponse>newBuilder()
                      .setDefaultInstance(HostsListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetHostRequest, Host> getCallable;
  private final UnaryCallable<GetVersionHostRequest, Operation> getVersionCallable;
  private final OperationCallable<GetVersionHostRequest, Operation, Operation>
      getVersionOperationCallable;
  private final UnaryCallable<ListHostsRequest, HostsListResponse> listCallable;
  private final UnaryCallable<ListHostsRequest, ListPagedResponse> listPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonZoneOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/zones/{zone}/{association}/hosts/{host}");
  private static final PathTemplate GET_VERSION_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/zones/{zone}/{association}/hosts/{host}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/zones/{zone}");

  public static final HttpJsonHostsStub create(HostsStubSettings settings) throws IOException {
    return new HttpJsonHostsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHostsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonHostsStub(HostsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonHostsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHostsStub(
        HostsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHostsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonHostsStub(HostsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonHostsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHostsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonHostsStub(
      HostsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub = HttpJsonZoneOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<GetHostRequest, Host> getTransportSettings =
        HttpJsonCallSettings.<GetHostRequest, Host>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("association", String.valueOf(request.getAssociation()));
                  builder.add("host", String.valueOf(request.getHost()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("association", String.valueOf(request.getAssociation()));
                  resourceNameSegments.put("host", String.valueOf(request.getHost()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put("zone", String.valueOf(request.getZone()));
                  return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<GetVersionHostRequest, Operation> getVersionTransportSettings =
        HttpJsonCallSettings.<GetVersionHostRequest, Operation>newBuilder()
            .setMethodDescriptor(getVersionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("association", String.valueOf(request.getAssociation()));
                  builder.add("host", String.valueOf(request.getHost()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("association", String.valueOf(request.getAssociation()));
                  resourceNameSegments.put("host", String.valueOf(request.getHost()));
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put("zone", String.valueOf(request.getZone()));
                  return GET_VERSION_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();
    HttpJsonCallSettings<ListHostsRequest, HostsListResponse> listTransportSettings =
        HttpJsonCallSettings.<ListHostsRequest, HostsListResponse>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("association", String.valueOf(request.getAssociation()));
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("zone", String.valueOf(request.getZone()));
                  return builder.build();
                })
            .setResourceNameExtractor(
                request -> {
                  Map<String, String> resourceNameSegments = new HashMap<String, String>();
                  resourceNameSegments.put("project", String.valueOf(request.getProject()));
                  resourceNameSegments.put("zone", String.valueOf(request.getZone()));
                  return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                })
            .build();

    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getVersionCallable =
        callableFactory.createUnaryCallable(
            getVersionTransportSettings, settings.getVersionSettings(), clientContext);
    this.getVersionOperationCallable =
        callableFactory.createOperationCallable(
            getVersionTransportSettings,
            settings.getVersionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getVersionMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetHostRequest, Host> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetVersionHostRequest, Operation> getVersionCallable() {
    return getVersionCallable;
  }

  @Override
  public OperationCallable<GetVersionHostRequest, Operation, Operation>
      getVersionOperationCallable() {
    return getVersionOperationCallable;
  }

  @Override
  public UnaryCallable<ListHostsRequest, HostsListResponse> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListHostsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
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
