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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.SiteServiceClient.ListSitesPagedResponse;

import com.google.ads.admanager.v1.BatchCreateSitesRequest;
import com.google.ads.admanager.v1.BatchCreateSitesResponse;
import com.google.ads.admanager.v1.BatchDeactivateSitesRequest;
import com.google.ads.admanager.v1.BatchDeactivateSitesResponse;
import com.google.ads.admanager.v1.BatchSubmitSitesForApprovalRequest;
import com.google.ads.admanager.v1.BatchSubmitSitesForApprovalResponse;
import com.google.ads.admanager.v1.BatchUpdateSitesRequest;
import com.google.ads.admanager.v1.BatchUpdateSitesResponse;
import com.google.ads.admanager.v1.CreateSiteRequest;
import com.google.ads.admanager.v1.GetSiteRequest;
import com.google.ads.admanager.v1.ListSitesRequest;
import com.google.ads.admanager.v1.ListSitesResponse;
import com.google.ads.admanager.v1.Site;
import com.google.ads.admanager.v1.UpdateSiteRequest;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the SiteService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonSiteServiceStub extends SiteServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetSiteRequest, Site> getSiteMethodDescriptor =
      ApiMethodDescriptor.<GetSiteRequest, Site>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.SiteService/GetSite")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetSiteRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/sites/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetSiteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetSiteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Site>newBuilder()
                  .setDefaultInstance(Site.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListSitesRequest, ListSitesResponse>
      listSitesMethodDescriptor =
          ApiMethodDescriptor.<ListSitesRequest, ListSitesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.SiteService/ListSites")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSitesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/sites",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSitesResponse>newBuilder()
                      .setDefaultInstance(ListSitesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSiteRequest, Site> createSiteMethodDescriptor =
      ApiMethodDescriptor.<CreateSiteRequest, Site>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.SiteService/CreateSite")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateSiteRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=networks/*}/sites",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSiteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateSiteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("site", request.getSite(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Site>newBuilder()
                  .setDefaultInstance(Site.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchCreateSitesRequest, BatchCreateSitesResponse>
      batchCreateSitesMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateSitesRequest, BatchCreateSitesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.SiteService/BatchCreateSites")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateSitesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/sites:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateSitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateSitesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateSitesResponse>newBuilder()
                      .setDefaultInstance(BatchCreateSitesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSiteRequest, Site> updateSiteMethodDescriptor =
      ApiMethodDescriptor.<UpdateSiteRequest, Site>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.SiteService/UpdateSite")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateSiteRequest>newBuilder()
                  .setPath(
                      "/v1/{site.name=networks/*/sites/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSiteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "site.name", request.getSite().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateSiteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("site", request.getSite(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Site>newBuilder()
                  .setDefaultInstance(Site.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchUpdateSitesRequest, BatchUpdateSitesResponse>
      batchUpdateSitesMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateSitesRequest, BatchUpdateSitesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.SiteService/BatchUpdateSites")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateSitesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/sites:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateSitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateSitesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateSitesResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateSitesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>
      batchDeactivateSitesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.SiteService/BatchDeactivateSites")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateSitesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/sites:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateSitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateSitesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateSitesResponse>newBuilder()
                      .setDefaultInstance(BatchDeactivateSitesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
      batchSubmitSitesForApprovalMethodDescriptor =
          ApiMethodDescriptor
              .<BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.SiteService/BatchSubmitSitesForApproval")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchSubmitSitesForApprovalRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/sites:batchSubmitForApproval",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchSubmitSitesForApprovalRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchSubmitSitesForApprovalRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchSubmitSitesForApprovalResponse>newBuilder()
                      .setDefaultInstance(BatchSubmitSitesForApprovalResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetSiteRequest, Site> getSiteCallable;
  private final UnaryCallable<ListSitesRequest, ListSitesResponse> listSitesCallable;
  private final UnaryCallable<ListSitesRequest, ListSitesPagedResponse> listSitesPagedCallable;
  private final UnaryCallable<CreateSiteRequest, Site> createSiteCallable;
  private final UnaryCallable<BatchCreateSitesRequest, BatchCreateSitesResponse>
      batchCreateSitesCallable;
  private final UnaryCallable<UpdateSiteRequest, Site> updateSiteCallable;
  private final UnaryCallable<BatchUpdateSitesRequest, BatchUpdateSitesResponse>
      batchUpdateSitesCallable;
  private final UnaryCallable<BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>
      batchDeactivateSitesCallable;
  private final UnaryCallable<
          BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
      batchSubmitSitesForApprovalCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSiteServiceStub create(SiteServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSiteServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSiteServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSiteServiceStub(SiteServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSiteServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSiteServiceStub(
        SiteServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSiteServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSiteServiceStub(SiteServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSiteServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSiteServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSiteServiceStub(
      SiteServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetSiteRequest, Site> getSiteTransportSettings =
        HttpJsonCallSettings.<GetSiteRequest, Site>newBuilder()
            .setMethodDescriptor(getSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSitesRequest, ListSitesResponse> listSitesTransportSettings =
        HttpJsonCallSettings.<ListSitesRequest, ListSitesResponse>newBuilder()
            .setMethodDescriptor(listSitesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSiteRequest, Site> createSiteTransportSettings =
        HttpJsonCallSettings.<CreateSiteRequest, Site>newBuilder()
            .setMethodDescriptor(createSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchCreateSitesRequest, BatchCreateSitesResponse>
        batchCreateSitesTransportSettings =
            HttpJsonCallSettings.<BatchCreateSitesRequest, BatchCreateSitesResponse>newBuilder()
                .setMethodDescriptor(batchCreateSitesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateSiteRequest, Site> updateSiteTransportSettings =
        HttpJsonCallSettings.<UpdateSiteRequest, Site>newBuilder()
            .setMethodDescriptor(updateSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("site.name", String.valueOf(request.getSite().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateSitesRequest, BatchUpdateSitesResponse>
        batchUpdateSitesTransportSettings =
            HttpJsonCallSettings.<BatchUpdateSitesRequest, BatchUpdateSitesResponse>newBuilder()
                .setMethodDescriptor(batchUpdateSitesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>
        batchDeactivateSitesTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>newBuilder()
                .setMethodDescriptor(batchDeactivateSitesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
        batchSubmitSitesForApprovalTransportSettings =
            HttpJsonCallSettings
                .<BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
                    newBuilder()
                .setMethodDescriptor(batchSubmitSitesForApprovalMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getSiteCallable =
        callableFactory.createUnaryCallable(
            getSiteTransportSettings, settings.getSiteSettings(), clientContext);
    this.listSitesCallable =
        callableFactory.createUnaryCallable(
            listSitesTransportSettings, settings.listSitesSettings(), clientContext);
    this.listSitesPagedCallable =
        callableFactory.createPagedCallable(
            listSitesTransportSettings, settings.listSitesSettings(), clientContext);
    this.createSiteCallable =
        callableFactory.createUnaryCallable(
            createSiteTransportSettings, settings.createSiteSettings(), clientContext);
    this.batchCreateSitesCallable =
        callableFactory.createUnaryCallable(
            batchCreateSitesTransportSettings, settings.batchCreateSitesSettings(), clientContext);
    this.updateSiteCallable =
        callableFactory.createUnaryCallable(
            updateSiteTransportSettings, settings.updateSiteSettings(), clientContext);
    this.batchUpdateSitesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateSitesTransportSettings, settings.batchUpdateSitesSettings(), clientContext);
    this.batchDeactivateSitesCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateSitesTransportSettings,
            settings.batchDeactivateSitesSettings(),
            clientContext);
    this.batchSubmitSitesForApprovalCallable =
        callableFactory.createUnaryCallable(
            batchSubmitSitesForApprovalTransportSettings,
            settings.batchSubmitSitesForApprovalSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getSiteMethodDescriptor);
    methodDescriptors.add(listSitesMethodDescriptor);
    methodDescriptors.add(createSiteMethodDescriptor);
    methodDescriptors.add(batchCreateSitesMethodDescriptor);
    methodDescriptors.add(updateSiteMethodDescriptor);
    methodDescriptors.add(batchUpdateSitesMethodDescriptor);
    methodDescriptors.add(batchDeactivateSitesMethodDescriptor);
    methodDescriptors.add(batchSubmitSitesForApprovalMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetSiteRequest, Site> getSiteCallable() {
    return getSiteCallable;
  }

  @Override
  public UnaryCallable<ListSitesRequest, ListSitesResponse> listSitesCallable() {
    return listSitesCallable;
  }

  @Override
  public UnaryCallable<ListSitesRequest, ListSitesPagedResponse> listSitesPagedCallable() {
    return listSitesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSiteRequest, Site> createSiteCallable() {
    return createSiteCallable;
  }

  @Override
  public UnaryCallable<BatchCreateSitesRequest, BatchCreateSitesResponse>
      batchCreateSitesCallable() {
    return batchCreateSitesCallable;
  }

  @Override
  public UnaryCallable<UpdateSiteRequest, Site> updateSiteCallable() {
    return updateSiteCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateSitesRequest, BatchUpdateSitesResponse>
      batchUpdateSitesCallable() {
    return batchUpdateSitesCallable;
  }

  @Override
  public UnaryCallable<BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>
      batchDeactivateSitesCallable() {
    return batchDeactivateSitesCallable;
  }

  @Override
  public UnaryCallable<BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
      batchSubmitSitesForApprovalCallable() {
    return batchSubmitSitesForApprovalCallable;
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
