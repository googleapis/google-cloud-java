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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.LicenseConfigServiceClient.ListLicenseConfigsPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse;
import com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.LicenseConfig;
import com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest;
import com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse;
import com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse;
import com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest;
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
 * REST stub implementation for the LicenseConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonLicenseConfigServiceStub extends LicenseConfigServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateLicenseConfigRequest, LicenseConfig>
      createLicenseConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateLicenseConfigRequest, LicenseConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/CreateLicenseConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateLicenseConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/licenseConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLicenseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLicenseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "licenseConfigId", request.getLicenseConfigId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("licenseConfig", request.getLicenseConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LicenseConfig>newBuilder()
                      .setDefaultInstance(LicenseConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateLicenseConfigRequest, LicenseConfig>
      updateLicenseConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateLicenseConfigRequest, LicenseConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/UpdateLicenseConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateLicenseConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{licenseConfig.name=projects/*/locations/*/licenseConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLicenseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "licenseConfig.name", request.getLicenseConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLicenseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("licenseConfig", request.getLicenseConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LicenseConfig>newBuilder()
                      .setDefaultInstance(LicenseConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLicenseConfigRequest, LicenseConfig>
      getLicenseConfigMethodDescriptor =
          ApiMethodDescriptor.<GetLicenseConfigRequest, LicenseConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/GetLicenseConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLicenseConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/licenseConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLicenseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLicenseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LicenseConfig>newBuilder()
                      .setDefaultInstance(LicenseConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLicenseConfigsRequest, ListLicenseConfigsResponse>
      listLicenseConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListLicenseConfigsRequest, ListLicenseConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/ListLicenseConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLicenseConfigsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/licenseConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLicenseConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLicenseConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListLicenseConfigsResponse>newBuilder()
                      .setDefaultInstance(ListLicenseConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
      distributeLicenseConfigMethodDescriptor =
          ApiMethodDescriptor
              .<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/DistributeLicenseConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DistributeLicenseConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{billingAccountLicenseConfig=billingAccounts/*/billingAccountLicenseConfigs/*}:distributeLicenseConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DistributeLicenseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "billingAccountLicenseConfig",
                                request.getBillingAccountLicenseConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DistributeLicenseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder()
                                          .clearBillingAccountLicenseConfig()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DistributeLicenseConfigResponse>newBuilder()
                      .setDefaultInstance(DistributeLicenseConfigResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RetractLicenseConfigRequest, RetractLicenseConfigResponse>
      retractLicenseConfigMethodDescriptor =
          ApiMethodDescriptor
              .<RetractLicenseConfigRequest, RetractLicenseConfigResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/RetractLicenseConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RetractLicenseConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{billingAccountLicenseConfig=billingAccounts/*/billingAccountLicenseConfigs/*}:retractLicenseConfig",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetractLicenseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "billingAccountLicenseConfig",
                                request.getBillingAccountLicenseConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetractLicenseConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder()
                                          .clearBillingAccountLicenseConfig()
                                          .build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RetractLicenseConfigResponse>newBuilder()
                      .setDefaultInstance(RetractLicenseConfigResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateLicenseConfigRequest, LicenseConfig>
      createLicenseConfigCallable;
  private final UnaryCallable<UpdateLicenseConfigRequest, LicenseConfig>
      updateLicenseConfigCallable;
  private final UnaryCallable<GetLicenseConfigRequest, LicenseConfig> getLicenseConfigCallable;
  private final UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsResponse>
      listLicenseConfigsCallable;
  private final UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsPagedResponse>
      listLicenseConfigsPagedCallable;
  private final UnaryCallable<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
      distributeLicenseConfigCallable;
  private final UnaryCallable<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
      retractLicenseConfigCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLicenseConfigServiceStub create(
      LicenseConfigServiceStubSettings settings) throws IOException {
    return new HttpJsonLicenseConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLicenseConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLicenseConfigServiceStub(
        LicenseConfigServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLicenseConfigServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLicenseConfigServiceStub(
        LicenseConfigServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLicenseConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLicenseConfigServiceStub(
      LicenseConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLicenseConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLicenseConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLicenseConfigServiceStub(
      LicenseConfigServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateLicenseConfigRequest, LicenseConfig>
        createLicenseConfigTransportSettings =
            HttpJsonCallSettings.<CreateLicenseConfigRequest, LicenseConfig>newBuilder()
                .setMethodDescriptor(createLicenseConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateLicenseConfigRequest, LicenseConfig>
        updateLicenseConfigTransportSettings =
            HttpJsonCallSettings.<UpdateLicenseConfigRequest, LicenseConfig>newBuilder()
                .setMethodDescriptor(updateLicenseConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "license_config.name",
                          String.valueOf(request.getLicenseConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLicenseConfigRequest, LicenseConfig> getLicenseConfigTransportSettings =
        HttpJsonCallSettings.<GetLicenseConfigRequest, LicenseConfig>newBuilder()
            .setMethodDescriptor(getLicenseConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListLicenseConfigsRequest, ListLicenseConfigsResponse>
        listLicenseConfigsTransportSettings =
            HttpJsonCallSettings.<ListLicenseConfigsRequest, ListLicenseConfigsResponse>newBuilder()
                .setMethodDescriptor(listLicenseConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
        distributeLicenseConfigTransportSettings =
            HttpJsonCallSettings
                .<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>newBuilder()
                .setMethodDescriptor(distributeLicenseConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "billing_account_license_config",
                          String.valueOf(request.getBillingAccountLicenseConfig()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getBillingAccountLicenseConfig())
                .build();
    HttpJsonCallSettings<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
        retractLicenseConfigTransportSettings =
            HttpJsonCallSettings
                .<RetractLicenseConfigRequest, RetractLicenseConfigResponse>newBuilder()
                .setMethodDescriptor(retractLicenseConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "billing_account_license_config",
                          String.valueOf(request.getBillingAccountLicenseConfig()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getBillingAccountLicenseConfig())
                .build();

    this.createLicenseConfigCallable =
        callableFactory.createUnaryCallable(
            createLicenseConfigTransportSettings,
            settings.createLicenseConfigSettings(),
            clientContext);
    this.updateLicenseConfigCallable =
        callableFactory.createUnaryCallable(
            updateLicenseConfigTransportSettings,
            settings.updateLicenseConfigSettings(),
            clientContext);
    this.getLicenseConfigCallable =
        callableFactory.createUnaryCallable(
            getLicenseConfigTransportSettings, settings.getLicenseConfigSettings(), clientContext);
    this.listLicenseConfigsCallable =
        callableFactory.createUnaryCallable(
            listLicenseConfigsTransportSettings,
            settings.listLicenseConfigsSettings(),
            clientContext);
    this.listLicenseConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listLicenseConfigsTransportSettings,
            settings.listLicenseConfigsSettings(),
            clientContext);
    this.distributeLicenseConfigCallable =
        callableFactory.createUnaryCallable(
            distributeLicenseConfigTransportSettings,
            settings.distributeLicenseConfigSettings(),
            clientContext);
    this.retractLicenseConfigCallable =
        callableFactory.createUnaryCallable(
            retractLicenseConfigTransportSettings,
            settings.retractLicenseConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createLicenseConfigMethodDescriptor);
    methodDescriptors.add(updateLicenseConfigMethodDescriptor);
    methodDescriptors.add(getLicenseConfigMethodDescriptor);
    methodDescriptors.add(listLicenseConfigsMethodDescriptor);
    methodDescriptors.add(distributeLicenseConfigMethodDescriptor);
    methodDescriptors.add(retractLicenseConfigMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateLicenseConfigRequest, LicenseConfig> createLicenseConfigCallable() {
    return createLicenseConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateLicenseConfigRequest, LicenseConfig> updateLicenseConfigCallable() {
    return updateLicenseConfigCallable;
  }

  @Override
  public UnaryCallable<GetLicenseConfigRequest, LicenseConfig> getLicenseConfigCallable() {
    return getLicenseConfigCallable;
  }

  @Override
  public UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsResponse>
      listLicenseConfigsCallable() {
    return listLicenseConfigsCallable;
  }

  @Override
  public UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsPagedResponse>
      listLicenseConfigsPagedCallable() {
    return listLicenseConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
      distributeLicenseConfigCallable() {
    return distributeLicenseConfigCallable;
  }

  @Override
  public UnaryCallable<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
      retractLicenseConfigCallable() {
    return retractLicenseConfigCallable;
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
