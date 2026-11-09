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

package com.google.cloud.discoveryengine.v1.stub;

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
import com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest;
import com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest;
import com.google.cloud.discoveryengine.v1.WidgetConfig;
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
 * REST stub implementation for the WidgetConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonWidgetConfigServiceStub extends WidgetConfigServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetWidgetConfigRequest, WidgetConfig>
      getWidgetConfigMethodDescriptor =
          ApiMethodDescriptor.<GetWidgetConfigRequest, WidgetConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.WidgetConfigService/GetWidgetConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWidgetConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataStores/*/widgetConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWidgetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/widgetConfigs/*}",
                          "/v1/{name=projects/*/locations/*/collections/*/engines/*/widgetConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWidgetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "acceptCache", request.getAcceptCache());
                            serializer.putQueryParam(
                                fields,
                                "getWidgetConfigRequestOption",
                                request.getGetWidgetConfigRequestOption());
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(
                                fields, "modelInfoView", request.getModelInfoViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WidgetConfig>newBuilder()
                      .setDefaultInstance(WidgetConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateWidgetConfigRequest, WidgetConfig>
      updateWidgetConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateWidgetConfigRequest, WidgetConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.WidgetConfigService/UpdateWidgetConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWidgetConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{widgetConfig.name=projects/*/locations/*/dataStores/*/widgetConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWidgetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "widgetConfig.name", request.getWidgetConfig().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{widgetConfig.name=projects/*/locations/*/collections/*/dataStores/*/widgetConfigs/*}",
                          "/v1/{widgetConfig.name=projects/*/locations/*/collections/*/engines/*/widgetConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWidgetConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("widgetConfig", request.getWidgetConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<WidgetConfig>newBuilder()
                      .setDefaultInstance(WidgetConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetWidgetConfigRequest, WidgetConfig> getWidgetConfigCallable;
  private final UnaryCallable<UpdateWidgetConfigRequest, WidgetConfig> updateWidgetConfigCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWidgetConfigServiceStub create(
      WidgetConfigServiceStubSettings settings) throws IOException {
    return new HttpJsonWidgetConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWidgetConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonWidgetConfigServiceStub(
        WidgetConfigServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWidgetConfigServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWidgetConfigServiceStub(
        WidgetConfigServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWidgetConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWidgetConfigServiceStub(
      WidgetConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonWidgetConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWidgetConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWidgetConfigServiceStub(
      WidgetConfigServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetWidgetConfigRequest, WidgetConfig> getWidgetConfigTransportSettings =
        HttpJsonCallSettings.<GetWidgetConfigRequest, WidgetConfig>newBuilder()
            .setMethodDescriptor(getWidgetConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<UpdateWidgetConfigRequest, WidgetConfig>
        updateWidgetConfigTransportSettings =
            HttpJsonCallSettings.<UpdateWidgetConfigRequest, WidgetConfig>newBuilder()
                .setMethodDescriptor(updateWidgetConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "widget_config.name",
                          String.valueOf(request.getWidgetConfig().getName()));
                      return builder.build();
                    })
                .build();

    this.getWidgetConfigCallable =
        callableFactory.createUnaryCallable(
            getWidgetConfigTransportSettings, settings.getWidgetConfigSettings(), clientContext);
    this.updateWidgetConfigCallable =
        callableFactory.createUnaryCallable(
            updateWidgetConfigTransportSettings,
            settings.updateWidgetConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getWidgetConfigMethodDescriptor);
    methodDescriptors.add(updateWidgetConfigMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetWidgetConfigRequest, WidgetConfig> getWidgetConfigCallable() {
    return getWidgetConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateWidgetConfigRequest, WidgetConfig> updateWidgetConfigCallable() {
    return updateWidgetConfigCallable;
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
