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

package com.google.cloud.retail.v2.stub;

import static com.google.cloud.retail.v2.ControlServiceClient.ListControlsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.Control;
import com.google.cloud.retail.v2.CreateControlRequest;
import com.google.cloud.retail.v2.DeleteControlRequest;
import com.google.cloud.retail.v2.GetControlRequest;
import com.google.cloud.retail.v2.ListControlsRequest;
import com.google.cloud.retail.v2.ListControlsResponse;
import com.google.cloud.retail.v2.UpdateControlRequest;
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
 * REST stub implementation for the ControlService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonControlServiceStub extends ControlServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateControlRequest, Control>
      createControlMethodDescriptor =
          ApiMethodDescriptor.<CreateControlRequest, Control>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.ControlService/CreateControl")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateControlRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/catalogs/*}/controls",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "controlId", request.getControlId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("control", request.getControl(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Control>newBuilder()
                      .setDefaultInstance(Control.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteControlRequest, Empty>
      deleteControlMethodDescriptor =
          ApiMethodDescriptor.<DeleteControlRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.ControlService/DeleteControl")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteControlRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/catalogs/*/controls/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteControlRequest> serializer =
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

  private static final ApiMethodDescriptor<UpdateControlRequest, Control>
      updateControlMethodDescriptor =
          ApiMethodDescriptor.<UpdateControlRequest, Control>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.ControlService/UpdateControl")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateControlRequest>newBuilder()
                      .setPath(
                          "/v2/{control.name=projects/*/locations/*/catalogs/*/controls/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "control.name", request.getControl().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("control", request.getControl(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Control>newBuilder()
                      .setDefaultInstance(Control.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetControlRequest, Control> getControlMethodDescriptor =
      ApiMethodDescriptor.<GetControlRequest, Control>newBuilder()
          .setFullMethodName("google.cloud.retail.v2.ControlService/GetControl")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetControlRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/catalogs/*/controls/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetControlRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetControlRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Control>newBuilder()
                  .setDefaultInstance(Control.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListControlsRequest, ListControlsResponse>
      listControlsMethodDescriptor =
          ApiMethodDescriptor.<ListControlsRequest, ListControlsResponse>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.ControlService/ListControls")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListControlsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/catalogs/*}/controls",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListControlsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListControlsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListControlsResponse>newBuilder()
                      .setDefaultInstance(ListControlsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateControlRequest, Control> createControlCallable;
  private final UnaryCallable<DeleteControlRequest, Empty> deleteControlCallable;
  private final UnaryCallable<UpdateControlRequest, Control> updateControlCallable;
  private final UnaryCallable<GetControlRequest, Control> getControlCallable;
  private final UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable;
  private final UnaryCallable<ListControlsRequest, ListControlsPagedResponse>
      listControlsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonControlServiceStub create(ControlServiceStubSettings settings)
      throws IOException {
    return new HttpJsonControlServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonControlServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonControlServiceStub(
        ControlServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonControlServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonControlServiceStub(
        ControlServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonControlServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonControlServiceStub(
      ControlServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonControlServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonControlServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonControlServiceStub(
      ControlServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateControlRequest, Control> createControlTransportSettings =
        HttpJsonCallSettings.<CreateControlRequest, Control>newBuilder()
            .setMethodDescriptor(createControlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteControlRequest, Empty> deleteControlTransportSettings =
        HttpJsonCallSettings.<DeleteControlRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteControlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateControlRequest, Control> updateControlTransportSettings =
        HttpJsonCallSettings.<UpdateControlRequest, Control>newBuilder()
            .setMethodDescriptor(updateControlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetControlRequest, Control> getControlTransportSettings =
        HttpJsonCallSettings.<GetControlRequest, Control>newBuilder()
            .setMethodDescriptor(getControlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListControlsRequest, ListControlsResponse> listControlsTransportSettings =
        HttpJsonCallSettings.<ListControlsRequest, ListControlsResponse>newBuilder()
            .setMethodDescriptor(listControlsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createControlCallable =
        callableFactory.createUnaryCallable(
            createControlTransportSettings, settings.createControlSettings(), clientContext);
    this.deleteControlCallable =
        callableFactory.createUnaryCallable(
            deleteControlTransportSettings, settings.deleteControlSettings(), clientContext);
    this.updateControlCallable =
        callableFactory.createUnaryCallable(
            updateControlTransportSettings, settings.updateControlSettings(), clientContext);
    this.getControlCallable =
        callableFactory.createUnaryCallable(
            getControlTransportSettings, settings.getControlSettings(), clientContext);
    this.listControlsCallable =
        callableFactory.createUnaryCallable(
            listControlsTransportSettings, settings.listControlsSettings(), clientContext);
    this.listControlsPagedCallable =
        callableFactory.createPagedCallable(
            listControlsTransportSettings, settings.listControlsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createControlMethodDescriptor);
    methodDescriptors.add(deleteControlMethodDescriptor);
    methodDescriptors.add(updateControlMethodDescriptor);
    methodDescriptors.add(getControlMethodDescriptor);
    methodDescriptors.add(listControlsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateControlRequest, Control> createControlCallable() {
    return createControlCallable;
  }

  @Override
  public UnaryCallable<DeleteControlRequest, Empty> deleteControlCallable() {
    return deleteControlCallable;
  }

  @Override
  public UnaryCallable<UpdateControlRequest, Control> updateControlCallable() {
    return updateControlCallable;
  }

  @Override
  public UnaryCallable<GetControlRequest, Control> getControlCallable() {
    return getControlCallable;
  }

  @Override
  public UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable() {
    return listControlsCallable;
  }

  @Override
  public UnaryCallable<ListControlsRequest, ListControlsPagedResponse> listControlsPagedCallable() {
    return listControlsPagedCallable;
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
