/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.accounts.v1.stub;

import static com.google.shopping.merchant.accounts.v1.OmnichannelSettingsServiceClient.ListOmnichannelSettingsPagedResponse;

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
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.accounts.v1.CreateOmnichannelSettingRequest;
import com.google.shopping.merchant.accounts.v1.GetOmnichannelSettingRequest;
import com.google.shopping.merchant.accounts.v1.ListOmnichannelSettingsRequest;
import com.google.shopping.merchant.accounts.v1.ListOmnichannelSettingsResponse;
import com.google.shopping.merchant.accounts.v1.OmnichannelSetting;
import com.google.shopping.merchant.accounts.v1.RequestInventoryVerificationRequest;
import com.google.shopping.merchant.accounts.v1.RequestInventoryVerificationResponse;
import com.google.shopping.merchant.accounts.v1.UpdateOmnichannelSettingRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the OmnichannelSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonOmnichannelSettingsServiceStub extends OmnichannelSettingsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetOmnichannelSettingRequest, OmnichannelSetting>
      getOmnichannelSettingMethodDescriptor =
          ApiMethodDescriptor.<GetOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OmnichannelSettingsService/GetOmnichannelSetting")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOmnichannelSettingRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/omnichannelSettings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOmnichannelSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOmnichannelSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OmnichannelSetting>newBuilder()
                      .setDefaultInstance(OmnichannelSetting.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
      listOmnichannelSettingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OmnichannelSettingsService/ListOmnichannelSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOmnichannelSettingsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{parent=accounts/*}/omnichannelSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOmnichannelSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOmnichannelSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOmnichannelSettingsResponse>newBuilder()
                      .setDefaultInstance(ListOmnichannelSettingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateOmnichannelSettingRequest, OmnichannelSetting>
      createOmnichannelSettingMethodDescriptor =
          ApiMethodDescriptor.<CreateOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OmnichannelSettingsService/CreateOmnichannelSetting")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOmnichannelSettingRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{parent=accounts/*}/omnichannelSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOmnichannelSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOmnichannelSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "omnichannelSetting", request.getOmnichannelSetting(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OmnichannelSetting>newBuilder()
                      .setDefaultInstance(OmnichannelSetting.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateOmnichannelSettingRequest, OmnichannelSetting>
      updateOmnichannelSettingMethodDescriptor =
          ApiMethodDescriptor.<UpdateOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OmnichannelSettingsService/UpdateOmnichannelSetting")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateOmnichannelSettingRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{omnichannelSetting.name=accounts/*/omnichannelSettings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOmnichannelSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "omnichannelSetting.name",
                                request.getOmnichannelSetting().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOmnichannelSettingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "omnichannelSetting", request.getOmnichannelSetting(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<OmnichannelSetting>newBuilder()
                      .setDefaultInstance(OmnichannelSetting.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
      requestInventoryVerificationMethodDescriptor =
          ApiMethodDescriptor
              .<RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OmnichannelSettingsService/RequestInventoryVerification")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RequestInventoryVerificationRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/omnichannelSettings/*}:requestInventoryVerification",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RequestInventoryVerificationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RequestInventoryVerificationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RequestInventoryVerificationResponse>newBuilder()
                      .setDefaultInstance(RequestInventoryVerificationResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetOmnichannelSettingRequest, OmnichannelSetting>
      getOmnichannelSettingCallable;
  private final UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
      listOmnichannelSettingsCallable;
  private final UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsPagedResponse>
      listOmnichannelSettingsPagedCallable;
  private final UnaryCallable<CreateOmnichannelSettingRequest, OmnichannelSetting>
      createOmnichannelSettingCallable;
  private final UnaryCallable<UpdateOmnichannelSettingRequest, OmnichannelSetting>
      updateOmnichannelSettingCallable;
  private final UnaryCallable<
          RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
      requestInventoryVerificationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOmnichannelSettingsServiceStub create(
      OmnichannelSettingsServiceStubSettings settings) throws IOException {
    return new HttpJsonOmnichannelSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonOmnichannelSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonOmnichannelSettingsServiceStub(
        OmnichannelSettingsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonOmnichannelSettingsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOmnichannelSettingsServiceStub(
        OmnichannelSettingsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOmnichannelSettingsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonOmnichannelSettingsServiceStub(
      OmnichannelSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonOmnichannelSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOmnichannelSettingsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonOmnichannelSettingsServiceStub(
      OmnichannelSettingsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetOmnichannelSettingRequest, OmnichannelSetting>
        getOmnichannelSettingTransportSettings =
            HttpJsonCallSettings.<GetOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
                .setMethodDescriptor(getOmnichannelSettingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
        listOmnichannelSettingsTransportSettings =
            HttpJsonCallSettings
                .<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>newBuilder()
                .setMethodDescriptor(listOmnichannelSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateOmnichannelSettingRequest, OmnichannelSetting>
        createOmnichannelSettingTransportSettings =
            HttpJsonCallSettings.<CreateOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
                .setMethodDescriptor(createOmnichannelSettingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateOmnichannelSettingRequest, OmnichannelSetting>
        updateOmnichannelSettingTransportSettings =
            HttpJsonCallSettings.<UpdateOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
                .setMethodDescriptor(updateOmnichannelSettingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "omnichannel_setting.name",
                          String.valueOf(request.getOmnichannelSetting().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
        requestInventoryVerificationTransportSettings =
            HttpJsonCallSettings
                .<RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
                    newBuilder()
                .setMethodDescriptor(requestInventoryVerificationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getOmnichannelSettingCallable =
        callableFactory.createUnaryCallable(
            getOmnichannelSettingTransportSettings,
            settings.getOmnichannelSettingSettings(),
            clientContext);
    this.listOmnichannelSettingsCallable =
        callableFactory.createUnaryCallable(
            listOmnichannelSettingsTransportSettings,
            settings.listOmnichannelSettingsSettings(),
            clientContext);
    this.listOmnichannelSettingsPagedCallable =
        callableFactory.createPagedCallable(
            listOmnichannelSettingsTransportSettings,
            settings.listOmnichannelSettingsSettings(),
            clientContext);
    this.createOmnichannelSettingCallable =
        callableFactory.createUnaryCallable(
            createOmnichannelSettingTransportSettings,
            settings.createOmnichannelSettingSettings(),
            clientContext);
    this.updateOmnichannelSettingCallable =
        callableFactory.createUnaryCallable(
            updateOmnichannelSettingTransportSettings,
            settings.updateOmnichannelSettingSettings(),
            clientContext);
    this.requestInventoryVerificationCallable =
        callableFactory.createUnaryCallable(
            requestInventoryVerificationTransportSettings,
            settings.requestInventoryVerificationSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getOmnichannelSettingMethodDescriptor);
    methodDescriptors.add(listOmnichannelSettingsMethodDescriptor);
    methodDescriptors.add(createOmnichannelSettingMethodDescriptor);
    methodDescriptors.add(updateOmnichannelSettingMethodDescriptor);
    methodDescriptors.add(requestInventoryVerificationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetOmnichannelSettingRequest, OmnichannelSetting>
      getOmnichannelSettingCallable() {
    return getOmnichannelSettingCallable;
  }

  @Override
  public UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
      listOmnichannelSettingsCallable() {
    return listOmnichannelSettingsCallable;
  }

  @Override
  public UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsPagedResponse>
      listOmnichannelSettingsPagedCallable() {
    return listOmnichannelSettingsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateOmnichannelSettingRequest, OmnichannelSetting>
      createOmnichannelSettingCallable() {
    return createOmnichannelSettingCallable;
  }

  @Override
  public UnaryCallable<UpdateOmnichannelSettingRequest, OmnichannelSetting>
      updateOmnichannelSettingCallable() {
    return updateOmnichannelSettingCallable;
  }

  @Override
  public UnaryCallable<RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
      requestInventoryVerificationCallable() {
    return requestInventoryVerificationCallable;
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
