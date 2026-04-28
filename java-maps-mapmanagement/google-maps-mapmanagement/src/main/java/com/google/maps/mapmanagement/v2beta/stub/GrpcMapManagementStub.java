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

package com.google.maps.mapmanagement.v2beta.stub;

import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapContextConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListStyleConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse;
import com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse;
import com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse;
import com.google.maps.mapmanagement.v2beta.MapConfig;
import com.google.maps.mapmanagement.v2beta.MapContextConfig;
import com.google.maps.mapmanagement.v2beta.StyleConfig;
import com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MapManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMapManagementStub extends MapManagementStub {
  private static final MethodDescriptor<CreateMapConfigRequest, MapConfig>
      createMapConfigMethodDescriptor =
          MethodDescriptor.<CreateMapConfigRequest, MapConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/CreateMapConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMapConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MapConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMapConfigRequest, MapConfig>
      getMapConfigMethodDescriptor =
          MethodDescriptor.<GetMapConfigRequest, MapConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/GetMapConfig")
              .setRequestMarshaller(ProtoUtils.marshaller(GetMapConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MapConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListMapConfigsRequest, ListMapConfigsResponse>
      listMapConfigsMethodDescriptor =
          MethodDescriptor.<ListMapConfigsRequest, ListMapConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/ListMapConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMapConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMapConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMapConfigRequest, MapConfig>
      updateMapConfigMethodDescriptor =
          MethodDescriptor.<UpdateMapConfigRequest, MapConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/UpdateMapConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMapConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MapConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMapConfigRequest, Empty>
      deleteMapConfigMethodDescriptor =
          MethodDescriptor.<DeleteMapConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/DeleteMapConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMapConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateStyleConfigRequest, StyleConfig>
      createStyleConfigMethodDescriptor =
          MethodDescriptor.<CreateStyleConfigRequest, StyleConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/CreateStyleConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateStyleConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StyleConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetStyleConfigRequest, StyleConfig>
      getStyleConfigMethodDescriptor =
          MethodDescriptor.<GetStyleConfigRequest, StyleConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/GetStyleConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetStyleConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StyleConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListStyleConfigsRequest, ListStyleConfigsResponse>
      listStyleConfigsMethodDescriptor =
          MethodDescriptor.<ListStyleConfigsRequest, ListStyleConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/ListStyleConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListStyleConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListStyleConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateStyleConfigRequest, StyleConfig>
      updateStyleConfigMethodDescriptor =
          MethodDescriptor.<UpdateStyleConfigRequest, StyleConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/UpdateStyleConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateStyleConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StyleConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteStyleConfigRequest, Empty>
      deleteStyleConfigMethodDescriptor =
          MethodDescriptor.<DeleteStyleConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.mapmanagement.v2beta.MapManagement/DeleteStyleConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteStyleConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigMethodDescriptor =
          MethodDescriptor.<CreateMapContextConfigRequest, MapContextConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.mapmanagement.v2beta.MapManagement/CreateMapContextConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMapContextConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MapContextConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetMapContextConfigRequest, MapContextConfig>
      getMapContextConfigMethodDescriptor =
          MethodDescriptor.<GetMapContextConfigRequest, MapContextConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.mapmanagement.v2beta.MapManagement/GetMapContextConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMapContextConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MapContextConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListMapContextConfigsRequest, ListMapContextConfigsResponse>
      listMapContextConfigsMethodDescriptor =
          MethodDescriptor.<ListMapContextConfigsRequest, ListMapContextConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.mapmanagement.v2beta.MapManagement/ListMapContextConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMapContextConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMapContextConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigMethodDescriptor =
          MethodDescriptor.<UpdateMapContextConfigRequest, MapContextConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.mapmanagement.v2beta.MapManagement/UpdateMapContextConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMapContextConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MapContextConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMapContextConfigRequest, Empty>
      deleteMapContextConfigMethodDescriptor =
          MethodDescriptor.<DeleteMapContextConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.mapmanagement.v2beta.MapManagement/DeleteMapContextConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMapContextConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateMapConfigRequest, MapConfig> createMapConfigCallable;
  private final UnaryCallable<GetMapConfigRequest, MapConfig> getMapConfigCallable;
  private final UnaryCallable<ListMapConfigsRequest, ListMapConfigsResponse> listMapConfigsCallable;
  private final UnaryCallable<ListMapConfigsRequest, ListMapConfigsPagedResponse>
      listMapConfigsPagedCallable;
  private final UnaryCallable<UpdateMapConfigRequest, MapConfig> updateMapConfigCallable;
  private final UnaryCallable<DeleteMapConfigRequest, Empty> deleteMapConfigCallable;
  private final UnaryCallable<CreateStyleConfigRequest, StyleConfig> createStyleConfigCallable;
  private final UnaryCallable<GetStyleConfigRequest, StyleConfig> getStyleConfigCallable;
  private final UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsResponse>
      listStyleConfigsCallable;
  private final UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsPagedResponse>
      listStyleConfigsPagedCallable;
  private final UnaryCallable<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigCallable;
  private final UnaryCallable<DeleteStyleConfigRequest, Empty> deleteStyleConfigCallable;
  private final UnaryCallable<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigCallable;
  private final UnaryCallable<GetMapContextConfigRequest, MapContextConfig>
      getMapContextConfigCallable;
  private final UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsResponse>
      listMapContextConfigsCallable;
  private final UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsPagedResponse>
      listMapContextConfigsPagedCallable;
  private final UnaryCallable<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigCallable;
  private final UnaryCallable<DeleteMapContextConfigRequest, Empty> deleteMapContextConfigCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMapManagementStub create(MapManagementStubSettings settings)
      throws IOException {
    return new GrpcMapManagementStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMapManagementStub create(ClientContext clientContext) throws IOException {
    return new GrpcMapManagementStub(MapManagementStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMapManagementStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMapManagementStub(
        MapManagementStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMapManagementStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMapManagementStub(MapManagementStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMapManagementCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMapManagementStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcMapManagementStub(
      MapManagementStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateMapConfigRequest, MapConfig> createMapConfigTransportSettings =
        GrpcCallSettings.<CreateMapConfigRequest, MapConfig>newBuilder()
            .setMethodDescriptor(createMapConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetMapConfigRequest, MapConfig> getMapConfigTransportSettings =
        GrpcCallSettings.<GetMapConfigRequest, MapConfig>newBuilder()
            .setMethodDescriptor(getMapConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListMapConfigsRequest, ListMapConfigsResponse>
        listMapConfigsTransportSettings =
            GrpcCallSettings.<ListMapConfigsRequest, ListMapConfigsResponse>newBuilder()
                .setMethodDescriptor(listMapConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateMapConfigRequest, MapConfig> updateMapConfigTransportSettings =
        GrpcCallSettings.<UpdateMapConfigRequest, MapConfig>newBuilder()
            .setMethodDescriptor(updateMapConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("map_config.name", String.valueOf(request.getMapConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMapConfigRequest, Empty> deleteMapConfigTransportSettings =
        GrpcCallSettings.<DeleteMapConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMapConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateStyleConfigRequest, StyleConfig> createStyleConfigTransportSettings =
        GrpcCallSettings.<CreateStyleConfigRequest, StyleConfig>newBuilder()
            .setMethodDescriptor(createStyleConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetStyleConfigRequest, StyleConfig> getStyleConfigTransportSettings =
        GrpcCallSettings.<GetStyleConfigRequest, StyleConfig>newBuilder()
            .setMethodDescriptor(getStyleConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListStyleConfigsRequest, ListStyleConfigsResponse>
        listStyleConfigsTransportSettings =
            GrpcCallSettings.<ListStyleConfigsRequest, ListStyleConfigsResponse>newBuilder()
                .setMethodDescriptor(listStyleConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigTransportSettings =
        GrpcCallSettings.<UpdateStyleConfigRequest, StyleConfig>newBuilder()
            .setMethodDescriptor(updateStyleConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "style_config.name", String.valueOf(request.getStyleConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteStyleConfigRequest, Empty> deleteStyleConfigTransportSettings =
        GrpcCallSettings.<DeleteStyleConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteStyleConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateMapContextConfigRequest, MapContextConfig>
        createMapContextConfigTransportSettings =
            GrpcCallSettings.<CreateMapContextConfigRequest, MapContextConfig>newBuilder()
                .setMethodDescriptor(createMapContextConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetMapContextConfigRequest, MapContextConfig>
        getMapContextConfigTransportSettings =
            GrpcCallSettings.<GetMapContextConfigRequest, MapContextConfig>newBuilder()
                .setMethodDescriptor(getMapContextConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListMapContextConfigsRequest, ListMapContextConfigsResponse>
        listMapContextConfigsTransportSettings =
            GrpcCallSettings
                .<ListMapContextConfigsRequest, ListMapContextConfigsResponse>newBuilder()
                .setMethodDescriptor(listMapContextConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateMapContextConfigRequest, MapContextConfig>
        updateMapContextConfigTransportSettings =
            GrpcCallSettings.<UpdateMapContextConfigRequest, MapContextConfig>newBuilder()
                .setMethodDescriptor(updateMapContextConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "map_context_config.name",
                          String.valueOf(request.getMapContextConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMapContextConfigRequest, Empty> deleteMapContextConfigTransportSettings =
        GrpcCallSettings.<DeleteMapContextConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMapContextConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();

    this.createMapConfigCallable =
        callableFactory.createUnaryCallable(
            createMapConfigTransportSettings, settings.createMapConfigSettings(), clientContext);
    this.getMapConfigCallable =
        callableFactory.createUnaryCallable(
            getMapConfigTransportSettings, settings.getMapConfigSettings(), clientContext);
    this.listMapConfigsCallable =
        callableFactory.createUnaryCallable(
            listMapConfigsTransportSettings, settings.listMapConfigsSettings(), clientContext);
    this.listMapConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listMapConfigsTransportSettings, settings.listMapConfigsSettings(), clientContext);
    this.updateMapConfigCallable =
        callableFactory.createUnaryCallable(
            updateMapConfigTransportSettings, settings.updateMapConfigSettings(), clientContext);
    this.deleteMapConfigCallable =
        callableFactory.createUnaryCallable(
            deleteMapConfigTransportSettings, settings.deleteMapConfigSettings(), clientContext);
    this.createStyleConfigCallable =
        callableFactory.createUnaryCallable(
            createStyleConfigTransportSettings,
            settings.createStyleConfigSettings(),
            clientContext);
    this.getStyleConfigCallable =
        callableFactory.createUnaryCallable(
            getStyleConfigTransportSettings, settings.getStyleConfigSettings(), clientContext);
    this.listStyleConfigsCallable =
        callableFactory.createUnaryCallable(
            listStyleConfigsTransportSettings, settings.listStyleConfigsSettings(), clientContext);
    this.listStyleConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listStyleConfigsTransportSettings, settings.listStyleConfigsSettings(), clientContext);
    this.updateStyleConfigCallable =
        callableFactory.createUnaryCallable(
            updateStyleConfigTransportSettings,
            settings.updateStyleConfigSettings(),
            clientContext);
    this.deleteStyleConfigCallable =
        callableFactory.createUnaryCallable(
            deleteStyleConfigTransportSettings,
            settings.deleteStyleConfigSettings(),
            clientContext);
    this.createMapContextConfigCallable =
        callableFactory.createUnaryCallable(
            createMapContextConfigTransportSettings,
            settings.createMapContextConfigSettings(),
            clientContext);
    this.getMapContextConfigCallable =
        callableFactory.createUnaryCallable(
            getMapContextConfigTransportSettings,
            settings.getMapContextConfigSettings(),
            clientContext);
    this.listMapContextConfigsCallable =
        callableFactory.createUnaryCallable(
            listMapContextConfigsTransportSettings,
            settings.listMapContextConfigsSettings(),
            clientContext);
    this.listMapContextConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listMapContextConfigsTransportSettings,
            settings.listMapContextConfigsSettings(),
            clientContext);
    this.updateMapContextConfigCallable =
        callableFactory.createUnaryCallable(
            updateMapContextConfigTransportSettings,
            settings.updateMapContextConfigSettings(),
            clientContext);
    this.deleteMapContextConfigCallable =
        callableFactory.createUnaryCallable(
            deleteMapContextConfigTransportSettings,
            settings.deleteMapContextConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateMapConfigRequest, MapConfig> createMapConfigCallable() {
    return createMapConfigCallable;
  }

  @Override
  public UnaryCallable<GetMapConfigRequest, MapConfig> getMapConfigCallable() {
    return getMapConfigCallable;
  }

  @Override
  public UnaryCallable<ListMapConfigsRequest, ListMapConfigsResponse> listMapConfigsCallable() {
    return listMapConfigsCallable;
  }

  @Override
  public UnaryCallable<ListMapConfigsRequest, ListMapConfigsPagedResponse>
      listMapConfigsPagedCallable() {
    return listMapConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateMapConfigRequest, MapConfig> updateMapConfigCallable() {
    return updateMapConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteMapConfigRequest, Empty> deleteMapConfigCallable() {
    return deleteMapConfigCallable;
  }

  @Override
  public UnaryCallable<CreateStyleConfigRequest, StyleConfig> createStyleConfigCallable() {
    return createStyleConfigCallable;
  }

  @Override
  public UnaryCallable<GetStyleConfigRequest, StyleConfig> getStyleConfigCallable() {
    return getStyleConfigCallable;
  }

  @Override
  public UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsResponse>
      listStyleConfigsCallable() {
    return listStyleConfigsCallable;
  }

  @Override
  public UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsPagedResponse>
      listStyleConfigsPagedCallable() {
    return listStyleConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigCallable() {
    return updateStyleConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteStyleConfigRequest, Empty> deleteStyleConfigCallable() {
    return deleteStyleConfigCallable;
  }

  @Override
  public UnaryCallable<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigCallable() {
    return createMapContextConfigCallable;
  }

  @Override
  public UnaryCallable<GetMapContextConfigRequest, MapContextConfig> getMapContextConfigCallable() {
    return getMapContextConfigCallable;
  }

  @Override
  public UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsResponse>
      listMapContextConfigsCallable() {
    return listMapContextConfigsCallable;
  }

  @Override
  public UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsPagedResponse>
      listMapContextConfigsPagedCallable() {
    return listMapContextConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigCallable() {
    return updateMapContextConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteMapContextConfigRequest, Empty> deleteMapContextConfigCallable() {
    return deleteMapContextConfigCallable;
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
