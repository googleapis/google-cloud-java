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

package com.google.ads.marketingplatform.admin.v1alpha.stub;

import static com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminServiceClient.ListAnalyticsAccountLinksPagedResponse;

import com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink;
import com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest;
import com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest;
import com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse;
import com.google.ads.marketingplatform.admin.v1alpha.Organization;
import com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest;
import com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse;
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
 * REST stub implementation for the MarketingplatformAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonMarketingplatformAdminServiceStub extends MarketingplatformAdminServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetOrganizationRequest, Organization>
      getOrganizationMethodDescriptor =
          ApiMethodDescriptor.<GetOrganizationRequest, Organization>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/GetOrganization")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOrganizationRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=organizations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Organization>newBuilder()
                      .setDefaultInstance(Organization.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksMethodDescriptor =
          ApiMethodDescriptor
              .<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/ListAnalyticsAccountLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAnalyticsAccountLinksRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=organizations/*}/analyticsAccountLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnalyticsAccountLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnalyticsAccountLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAnalyticsAccountLinksResponse>newBuilder()
                      .setDefaultInstance(ListAnalyticsAccountLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/CreateAnalyticsAccountLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAnalyticsAccountLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=organizations/*}/analyticsAccountLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnalyticsAccountLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnalyticsAccountLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "analyticsAccountLink",
                                      request.getAnalyticsAccountLink(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalyticsAccountLink>newBuilder()
                      .setDefaultInstance(AnalyticsAccountLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteAnalyticsAccountLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/DeleteAnalyticsAccountLink")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAnalyticsAccountLinkRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=organizations/*/analyticsAccountLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnalyticsAccountLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnalyticsAccountLinkRequest> serializer =
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
          SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelMethodDescriptor =
          ApiMethodDescriptor
              .<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>newBuilder()
              .setFullMethodName(
                  "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService/SetPropertyServiceLevel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetPropertyServiceLevelRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{analyticsAccountLink=organizations/*/analyticsAccountLinks/*}:setPropertyServiceLevel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetPropertyServiceLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "analyticsAccountLink", request.getAnalyticsAccountLink());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetPropertyServiceLevelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearAnalyticsAccountLink().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SetPropertyServiceLevelResponse>newBuilder()
                      .setDefaultInstance(SetPropertyServiceLevelResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable;
  private final UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksCallable;
  private final UnaryCallable<
          ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksPagedCallable;
  private final UnaryCallable<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkCallable;
  private final UnaryCallable<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkCallable;
  private final UnaryCallable<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMarketingplatformAdminServiceStub create(
      MarketingplatformAdminServiceStubSettings settings) throws IOException {
    return new HttpJsonMarketingplatformAdminServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMarketingplatformAdminServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMarketingplatformAdminServiceStub(
        MarketingplatformAdminServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMarketingplatformAdminServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMarketingplatformAdminServiceStub(
        MarketingplatformAdminServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMarketingplatformAdminServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonMarketingplatformAdminServiceStub(
      MarketingplatformAdminServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonMarketingplatformAdminServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMarketingplatformAdminServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonMarketingplatformAdminServiceStub(
      MarketingplatformAdminServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetOrganizationRequest, Organization> getOrganizationTransportSettings =
        HttpJsonCallSettings.<GetOrganizationRequest, Organization>newBuilder()
            .setMethodDescriptor(getOrganizationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
        listAnalyticsAccountLinksTransportSettings =
            HttpJsonCallSettings
                .<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>newBuilder()
                .setMethodDescriptor(listAnalyticsAccountLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
        createAnalyticsAccountLinkTransportSettings =
            HttpJsonCallSettings
                .<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>newBuilder()
                .setMethodDescriptor(createAnalyticsAccountLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteAnalyticsAccountLinkRequest, Empty>
        deleteAnalyticsAccountLinkTransportSettings =
            HttpJsonCallSettings.<DeleteAnalyticsAccountLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAnalyticsAccountLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
        setPropertyServiceLevelTransportSettings =
            HttpJsonCallSettings
                .<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>newBuilder()
                .setMethodDescriptor(setPropertyServiceLevelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "analytics_account_link",
                          String.valueOf(request.getAnalyticsAccountLink()));
                      return builder.build();
                    })
                .build();

    this.getOrganizationCallable =
        callableFactory.createUnaryCallable(
            getOrganizationTransportSettings, settings.getOrganizationSettings(), clientContext);
    this.listAnalyticsAccountLinksCallable =
        callableFactory.createUnaryCallable(
            listAnalyticsAccountLinksTransportSettings,
            settings.listAnalyticsAccountLinksSettings(),
            clientContext);
    this.listAnalyticsAccountLinksPagedCallable =
        callableFactory.createPagedCallable(
            listAnalyticsAccountLinksTransportSettings,
            settings.listAnalyticsAccountLinksSettings(),
            clientContext);
    this.createAnalyticsAccountLinkCallable =
        callableFactory.createUnaryCallable(
            createAnalyticsAccountLinkTransportSettings,
            settings.createAnalyticsAccountLinkSettings(),
            clientContext);
    this.deleteAnalyticsAccountLinkCallable =
        callableFactory.createUnaryCallable(
            deleteAnalyticsAccountLinkTransportSettings,
            settings.deleteAnalyticsAccountLinkSettings(),
            clientContext);
    this.setPropertyServiceLevelCallable =
        callableFactory.createUnaryCallable(
            setPropertyServiceLevelTransportSettings,
            settings.setPropertyServiceLevelSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getOrganizationMethodDescriptor);
    methodDescriptors.add(listAnalyticsAccountLinksMethodDescriptor);
    methodDescriptors.add(createAnalyticsAccountLinkMethodDescriptor);
    methodDescriptors.add(deleteAnalyticsAccountLinkMethodDescriptor);
    methodDescriptors.add(setPropertyServiceLevelMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetOrganizationRequest, Organization> getOrganizationCallable() {
    return getOrganizationCallable;
  }

  @Override
  public UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksResponse>
      listAnalyticsAccountLinksCallable() {
    return listAnalyticsAccountLinksCallable;
  }

  @Override
  public UnaryCallable<ListAnalyticsAccountLinksRequest, ListAnalyticsAccountLinksPagedResponse>
      listAnalyticsAccountLinksPagedCallable() {
    return listAnalyticsAccountLinksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAnalyticsAccountLinkRequest, AnalyticsAccountLink>
      createAnalyticsAccountLinkCallable() {
    return createAnalyticsAccountLinkCallable;
  }

  @Override
  public UnaryCallable<DeleteAnalyticsAccountLinkRequest, Empty>
      deleteAnalyticsAccountLinkCallable() {
    return deleteAnalyticsAccountLinkCallable;
  }

  @Override
  public UnaryCallable<SetPropertyServiceLevelRequest, SetPropertyServiceLevelResponse>
      setPropertyServiceLevelCallable() {
    return setPropertyServiceLevelCallable;
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
