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

package com.google.cloud.commerce.consumer.procurement.v1.stub;

import static com.google.cloud.commerce.consumer.procurement.v1.LicenseManagementServiceClient.EnumerateLicensedUsersPagedResponse;

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
import com.google.cloud.commerce.consumer.procurement.v1.AssignRequest;
import com.google.cloud.commerce.consumer.procurement.v1.AssignResponse;
import com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest;
import com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse;
import com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest;
import com.google.cloud.commerce.consumer.procurement.v1.LicensePool;
import com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest;
import com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse;
import com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest;
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
 * REST stub implementation for the LicenseManagementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonLicenseManagementServiceStub extends LicenseManagementServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetLicensePoolRequest, LicensePool>
      getLicensePoolMethodDescriptor =
          ApiMethodDescriptor.<GetLicensePoolRequest, LicensePool>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService/GetLicensePool")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLicensePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=billingAccounts/*/orders/*/licensePool}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLicensePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLicensePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LicensePool>newBuilder()
                      .setDefaultInstance(LicensePool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateLicensePoolRequest, LicensePool>
      updateLicensePoolMethodDescriptor =
          ApiMethodDescriptor.<UpdateLicensePoolRequest, LicensePool>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService/UpdateLicensePool")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateLicensePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{licensePool.name=billingAccounts/*/orders/*/licensePool}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLicensePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "licensePool.name", request.getLicensePool().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLicensePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("licensePool", request.getLicensePool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LicensePool>newBuilder()
                      .setDefaultInstance(LicensePool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AssignRequest, AssignResponse> assignMethodDescriptor =
      ApiMethodDescriptor.<AssignRequest, AssignResponse>newBuilder()
          .setFullMethodName(
              "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService/Assign")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<AssignRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=billingAccounts/*/orders/*/licensePool}:assign",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<AssignRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<AssignRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearParent().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<AssignResponse>newBuilder()
                  .setDefaultInstance(AssignResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UnassignRequest, UnassignResponse>
      unassignMethodDescriptor =
          ApiMethodDescriptor.<UnassignRequest, UnassignResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService/Unassign")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UnassignRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=billingAccounts/*/orders/*/licensePool}:unassign",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UnassignRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UnassignRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UnassignResponse>newBuilder()
                      .setDefaultInstance(UnassignResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
      enumerateLicensedUsersMethodDescriptor =
          ApiMethodDescriptor
              .<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService/EnumerateLicensedUsers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnumerateLicensedUsersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=billingAccounts/*/orders/*/licensePool}:enumerateLicensedUsers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnumerateLicensedUsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnumerateLicensedUsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EnumerateLicensedUsersResponse>newBuilder()
                      .setDefaultInstance(EnumerateLicensedUsersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLicensePoolRequest, LicensePool> getLicensePoolCallable;
  private final UnaryCallable<UpdateLicensePoolRequest, LicensePool> updateLicensePoolCallable;
  private final UnaryCallable<AssignRequest, AssignResponse> assignCallable;
  private final UnaryCallable<UnassignRequest, UnassignResponse> unassignCallable;
  private final UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
      enumerateLicensedUsersCallable;
  private final UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersPagedResponse>
      enumerateLicensedUsersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLicenseManagementServiceStub create(
      LicenseManagementServiceStubSettings settings) throws IOException {
    return new HttpJsonLicenseManagementServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLicenseManagementServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLicenseManagementServiceStub(
        LicenseManagementServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLicenseManagementServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLicenseManagementServiceStub(
        LicenseManagementServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLicenseManagementServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLicenseManagementServiceStub(
      LicenseManagementServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLicenseManagementServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLicenseManagementServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLicenseManagementServiceStub(
      LicenseManagementServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLicensePoolRequest, LicensePool> getLicensePoolTransportSettings =
        HttpJsonCallSettings.<GetLicensePoolRequest, LicensePool>newBuilder()
            .setMethodDescriptor(getLicensePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateLicensePoolRequest, LicensePool> updateLicensePoolTransportSettings =
        HttpJsonCallSettings.<UpdateLicensePoolRequest, LicensePool>newBuilder()
            .setMethodDescriptor(updateLicensePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "license_pool.name", String.valueOf(request.getLicensePool().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<AssignRequest, AssignResponse> assignTransportSettings =
        HttpJsonCallSettings.<AssignRequest, AssignResponse>newBuilder()
            .setMethodDescriptor(assignMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UnassignRequest, UnassignResponse> unassignTransportSettings =
        HttpJsonCallSettings.<UnassignRequest, UnassignResponse>newBuilder()
            .setMethodDescriptor(unassignMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
        enumerateLicensedUsersTransportSettings =
            HttpJsonCallSettings
                .<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>newBuilder()
                .setMethodDescriptor(enumerateLicensedUsersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getLicensePoolCallable =
        callableFactory.createUnaryCallable(
            getLicensePoolTransportSettings, settings.getLicensePoolSettings(), clientContext);
    this.updateLicensePoolCallable =
        callableFactory.createUnaryCallable(
            updateLicensePoolTransportSettings,
            settings.updateLicensePoolSettings(),
            clientContext);
    this.assignCallable =
        callableFactory.createUnaryCallable(
            assignTransportSettings, settings.assignSettings(), clientContext);
    this.unassignCallable =
        callableFactory.createUnaryCallable(
            unassignTransportSettings, settings.unassignSettings(), clientContext);
    this.enumerateLicensedUsersCallable =
        callableFactory.createUnaryCallable(
            enumerateLicensedUsersTransportSettings,
            settings.enumerateLicensedUsersSettings(),
            clientContext);
    this.enumerateLicensedUsersPagedCallable =
        callableFactory.createPagedCallable(
            enumerateLicensedUsersTransportSettings,
            settings.enumerateLicensedUsersSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLicensePoolMethodDescriptor);
    methodDescriptors.add(updateLicensePoolMethodDescriptor);
    methodDescriptors.add(assignMethodDescriptor);
    methodDescriptors.add(unassignMethodDescriptor);
    methodDescriptors.add(enumerateLicensedUsersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLicensePoolRequest, LicensePool> getLicensePoolCallable() {
    return getLicensePoolCallable;
  }

  @Override
  public UnaryCallable<UpdateLicensePoolRequest, LicensePool> updateLicensePoolCallable() {
    return updateLicensePoolCallable;
  }

  @Override
  public UnaryCallable<AssignRequest, AssignResponse> assignCallable() {
    return assignCallable;
  }

  @Override
  public UnaryCallable<UnassignRequest, UnassignResponse> unassignCallable() {
    return unassignCallable;
  }

  @Override
  public UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
      enumerateLicensedUsersCallable() {
    return enumerateLicensedUsersCallable;
  }

  @Override
  public UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersPagedResponse>
      enumerateLicensedUsersPagedCallable() {
    return enumerateLicensedUsersPagedCallable;
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
