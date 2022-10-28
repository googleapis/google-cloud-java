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

package com.google.cloud.resourcesettings.v1.stub;

import static com.google.cloud.resourcesettings.v1.ResourceSettingsServiceClient.ListSettingsPagedResponse;

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
import com.google.cloud.resourcesettings.v1.GetSettingRequest;
import com.google.cloud.resourcesettings.v1.ListSettingsRequest;
import com.google.cloud.resourcesettings.v1.ListSettingsResponse;
import com.google.cloud.resourcesettings.v1.Setting;
import com.google.cloud.resourcesettings.v1.UpdateSettingRequest;
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
 * REST stub implementation for the ResourceSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonResourceSettingsServiceStub extends ResourceSettingsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListSettingsRequest, ListSettingsResponse>
      listSettingsMethodDescriptor =
          ApiMethodDescriptor.<ListSettingsRequest, ListSettingsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.resourcesettings.v1.ResourceSettingsService/ListSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*}/settings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*}/settings", "/v1/{parent=projects/*}/settings")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSettingsResponse>newBuilder()
                      .setDefaultInstance(ListSettingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSettingRequest, Setting> getSettingMethodDescriptor =
      ApiMethodDescriptor.<GetSettingRequest, Setting>newBuilder()
          .setFullMethodName("google.cloud.resourcesettings.v1.ResourceSettingsService/GetSetting")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSettingRequest>newBuilder()
                  .setPath(
                      "/v1/{name=organizations/*/settings/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSettingRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1/{name=folders/*/settings/*}", "/v1/{name=projects/*/settings/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSettingRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Setting>newBuilder()
                  .setDefaultInstance(Setting.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateSettingRequest, Setting>
      updateSettingMethodDescriptor =
          ApiMethodDescriptor.<UpdateSettingRequest, Setting>newBuilder()
              .setFullMethodName(
                  "google.cloud.resourcesettings.v1.ResourceSettingsService/UpdateSetting")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSettingRequest>newBuilder()
                      .setPath(
                          "/v1/{setting.name=organizations/*/settings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "setting.name", request.getSetting().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{setting.name=folders/*/settings/*}",
                          "/v1/{setting.name=projects/*/settings/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("setting", request.getSetting(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Setting>newBuilder()
                      .setDefaultInstance(Setting.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListSettingsRequest, ListSettingsResponse> listSettingsCallable;
  private final UnaryCallable<ListSettingsRequest, ListSettingsPagedResponse>
      listSettingsPagedCallable;
  private final UnaryCallable<GetSettingRequest, Setting> getSettingCallable;
  private final UnaryCallable<UpdateSettingRequest, Setting> updateSettingCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonResourceSettingsServiceStub create(
      ResourceSettingsServiceStubSettings settings) throws IOException {
    return new HttpJsonResourceSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonResourceSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonResourceSettingsServiceStub(
        ResourceSettingsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonResourceSettingsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonResourceSettingsServiceStub(
        ResourceSettingsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonResourceSettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonResourceSettingsServiceStub(
      ResourceSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonResourceSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonResourceSettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonResourceSettingsServiceStub(
      ResourceSettingsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListSettingsRequest, ListSettingsResponse> listSettingsTransportSettings =
        HttpJsonCallSettings.<ListSettingsRequest, ListSettingsResponse>newBuilder()
            .setMethodDescriptor(listSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSettingRequest, Setting> getSettingTransportSettings =
        HttpJsonCallSettings.<GetSettingRequest, Setting>newBuilder()
            .setMethodDescriptor(getSettingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateSettingRequest, Setting> updateSettingTransportSettings =
        HttpJsonCallSettings.<UpdateSettingRequest, Setting>newBuilder()
            .setMethodDescriptor(updateSettingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listSettingsCallable =
        callableFactory.createUnaryCallable(
            listSettingsTransportSettings, settings.listSettingsSettings(), clientContext);
    this.listSettingsPagedCallable =
        callableFactory.createPagedCallable(
            listSettingsTransportSettings, settings.listSettingsSettings(), clientContext);
    this.getSettingCallable =
        callableFactory.createUnaryCallable(
            getSettingTransportSettings, settings.getSettingSettings(), clientContext);
    this.updateSettingCallable =
        callableFactory.createUnaryCallable(
            updateSettingTransportSettings, settings.updateSettingSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listSettingsMethodDescriptor);
    methodDescriptors.add(getSettingMethodDescriptor);
    methodDescriptors.add(updateSettingMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListSettingsRequest, ListSettingsResponse> listSettingsCallable() {
    return listSettingsCallable;
  }

  @Override
  public UnaryCallable<ListSettingsRequest, ListSettingsPagedResponse> listSettingsPagedCallable() {
    return listSettingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetSettingRequest, Setting> getSettingCallable() {
    return getSettingCallable;
  }

  @Override
  public UnaryCallable<UpdateSettingRequest, Setting> updateSettingCallable() {
    return updateSettingCallable;
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
