/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient.ListRuntimeProjectAttachmentsPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest;
import com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse;
import com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse;
import com.google.cloud.apihub.v1.RuntimeProjectAttachment;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the RuntimeProjectAttachmentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonRuntimeProjectAttachmentServiceStub
    extends RuntimeProjectAttachmentServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      createRuntimeProjectAttachmentMethodDescriptor =
          ApiMethodDescriptor
              .<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.RuntimeProjectAttachmentService/CreateRuntimeProjectAttachment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRuntimeProjectAttachmentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/runtimeProjectAttachments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRuntimeProjectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRuntimeProjectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "runtimeProjectAttachmentId",
                                request.getRuntimeProjectAttachmentId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "runtimeProjectAttachment",
                                      request.getRuntimeProjectAttachment(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RuntimeProjectAttachment>newBuilder()
                      .setDefaultInstance(RuntimeProjectAttachment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      getRuntimeProjectAttachmentMethodDescriptor =
          ApiMethodDescriptor
              .<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.RuntimeProjectAttachmentService/GetRuntimeProjectAttachment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRuntimeProjectAttachmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/runtimeProjectAttachments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuntimeProjectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuntimeProjectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RuntimeProjectAttachment>newBuilder()
                      .setDefaultInstance(RuntimeProjectAttachment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
      listRuntimeProjectAttachmentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.RuntimeProjectAttachmentService/ListRuntimeProjectAttachments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRuntimeProjectAttachmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/runtimeProjectAttachments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuntimeProjectAttachmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuntimeProjectAttachmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRuntimeProjectAttachmentsResponse>newBuilder()
                      .setDefaultInstance(
                          ListRuntimeProjectAttachmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRuntimeProjectAttachmentRequest, Empty>
      deleteRuntimeProjectAttachmentMethodDescriptor =
          ApiMethodDescriptor.<DeleteRuntimeProjectAttachmentRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.RuntimeProjectAttachmentService/DeleteRuntimeProjectAttachment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRuntimeProjectAttachmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/runtimeProjectAttachments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRuntimeProjectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRuntimeProjectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<
          LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
      lookupRuntimeProjectAttachmentMethodDescriptor =
          ApiMethodDescriptor
              .<LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.apihub.v1.RuntimeProjectAttachmentService/LookupRuntimeProjectAttachment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LookupRuntimeProjectAttachmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}:lookupRuntimeProjectAttachment",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LookupRuntimeProjectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LookupRuntimeProjectAttachmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LookupRuntimeProjectAttachmentResponse>newBuilder()
                      .setDefaultInstance(
                          LookupRuntimeProjectAttachmentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      createRuntimeProjectAttachmentCallable;
  private final UnaryCallable<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      getRuntimeProjectAttachmentCallable;
  private final UnaryCallable<
          ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
      listRuntimeProjectAttachmentsCallable;
  private final UnaryCallable<
          ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsPagedResponse>
      listRuntimeProjectAttachmentsPagedCallable;
  private final UnaryCallable<DeleteRuntimeProjectAttachmentRequest, Empty>
      deleteRuntimeProjectAttachmentCallable;
  private final UnaryCallable<
          LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
      lookupRuntimeProjectAttachmentCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRuntimeProjectAttachmentServiceStub create(
      RuntimeProjectAttachmentServiceStubSettings settings) throws IOException {
    return new HttpJsonRuntimeProjectAttachmentServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonRuntimeProjectAttachmentServiceStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonRuntimeProjectAttachmentServiceStub(
        RuntimeProjectAttachmentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRuntimeProjectAttachmentServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRuntimeProjectAttachmentServiceStub(
        RuntimeProjectAttachmentServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRuntimeProjectAttachmentServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonRuntimeProjectAttachmentServiceStub(
      RuntimeProjectAttachmentServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRuntimeProjectAttachmentServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRuntimeProjectAttachmentServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonRuntimeProjectAttachmentServiceStub(
      RuntimeProjectAttachmentServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
        createRuntimeProjectAttachmentTransportSettings =
            HttpJsonCallSettings
                .<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>newBuilder()
                .setMethodDescriptor(createRuntimeProjectAttachmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
        getRuntimeProjectAttachmentTransportSettings =
            HttpJsonCallSettings
                .<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>newBuilder()
                .setMethodDescriptor(getRuntimeProjectAttachmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
        listRuntimeProjectAttachmentsTransportSettings =
            HttpJsonCallSettings
                .<ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
                    newBuilder()
                .setMethodDescriptor(listRuntimeProjectAttachmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteRuntimeProjectAttachmentRequest, Empty>
        deleteRuntimeProjectAttachmentTransportSettings =
            HttpJsonCallSettings.<DeleteRuntimeProjectAttachmentRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteRuntimeProjectAttachmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
        lookupRuntimeProjectAttachmentTransportSettings =
            HttpJsonCallSettings
                .<LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
                    newBuilder()
                .setMethodDescriptor(lookupRuntimeProjectAttachmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createRuntimeProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            createRuntimeProjectAttachmentTransportSettings,
            settings.createRuntimeProjectAttachmentSettings(),
            clientContext);
    this.getRuntimeProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            getRuntimeProjectAttachmentTransportSettings,
            settings.getRuntimeProjectAttachmentSettings(),
            clientContext);
    this.listRuntimeProjectAttachmentsCallable =
        callableFactory.createUnaryCallable(
            listRuntimeProjectAttachmentsTransportSettings,
            settings.listRuntimeProjectAttachmentsSettings(),
            clientContext);
    this.listRuntimeProjectAttachmentsPagedCallable =
        callableFactory.createPagedCallable(
            listRuntimeProjectAttachmentsTransportSettings,
            settings.listRuntimeProjectAttachmentsSettings(),
            clientContext);
    this.deleteRuntimeProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            deleteRuntimeProjectAttachmentTransportSettings,
            settings.deleteRuntimeProjectAttachmentSettings(),
            clientContext);
    this.lookupRuntimeProjectAttachmentCallable =
        callableFactory.createUnaryCallable(
            lookupRuntimeProjectAttachmentTransportSettings,
            settings.lookupRuntimeProjectAttachmentSettings(),
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createRuntimeProjectAttachmentMethodDescriptor);
    methodDescriptors.add(getRuntimeProjectAttachmentMethodDescriptor);
    methodDescriptors.add(listRuntimeProjectAttachmentsMethodDescriptor);
    methodDescriptors.add(deleteRuntimeProjectAttachmentMethodDescriptor);
    methodDescriptors.add(lookupRuntimeProjectAttachmentMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      createRuntimeProjectAttachmentCallable() {
    return createRuntimeProjectAttachmentCallable;
  }

  @Override
  public UnaryCallable<GetRuntimeProjectAttachmentRequest, RuntimeProjectAttachment>
      getRuntimeProjectAttachmentCallable() {
    return getRuntimeProjectAttachmentCallable;
  }

  @Override
  public UnaryCallable<ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsResponse>
      listRuntimeProjectAttachmentsCallable() {
    return listRuntimeProjectAttachmentsCallable;
  }

  @Override
  public UnaryCallable<
          ListRuntimeProjectAttachmentsRequest, ListRuntimeProjectAttachmentsPagedResponse>
      listRuntimeProjectAttachmentsPagedCallable() {
    return listRuntimeProjectAttachmentsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRuntimeProjectAttachmentRequest, Empty>
      deleteRuntimeProjectAttachmentCallable() {
    return deleteRuntimeProjectAttachmentCallable;
  }

  @Override
  public UnaryCallable<
          LookupRuntimeProjectAttachmentRequest, LookupRuntimeProjectAttachmentResponse>
      lookupRuntimeProjectAttachmentCallable() {
    return lookupRuntimeProjectAttachmentCallable;
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
