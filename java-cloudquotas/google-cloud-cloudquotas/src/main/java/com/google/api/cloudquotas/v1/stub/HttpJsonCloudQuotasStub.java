/*
 * Copyright 2023 Google LLC
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

package com.google.api.cloudquotas.v1.stub;

import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaInfosPagedResponse;
import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaPreferencesPagedResponse;

import com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest;
import com.google.api.cloudquotas.v1.GetQuotaInfoRequest;
import com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest;
import com.google.api.cloudquotas.v1.ListQuotaInfosRequest;
import com.google.api.cloudquotas.v1.ListQuotaInfosResponse;
import com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest;
import com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse;
import com.google.api.cloudquotas.v1.QuotaInfo;
import com.google.api.cloudquotas.v1.QuotaPreference;
import com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest;
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
 * REST stub implementation for the CloudQuotas service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCloudQuotasStub extends CloudQuotasStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListQuotaInfosRequest, ListQuotaInfosResponse>
      listQuotaInfosMethodDescriptor =
          ApiMethodDescriptor.<ListQuotaInfosRequest, ListQuotaInfosResponse>newBuilder()
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/ListQuotaInfos")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListQuotaInfosRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/services/*}/quotaInfos",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListQuotaInfosRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=organizations/*/locations/*/services/*}/quotaInfos",
                          "/v1/{parent=folders/*/locations/*/services/*}/quotaInfos")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListQuotaInfosRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListQuotaInfosResponse>newBuilder()
                      .setDefaultInstance(ListQuotaInfosResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetQuotaInfoRequest, QuotaInfo>
      getQuotaInfoMethodDescriptor =
          ApiMethodDescriptor.<GetQuotaInfoRequest, QuotaInfo>newBuilder()
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/GetQuotaInfo")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetQuotaInfoRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/services/*/quotaInfos/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetQuotaInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=organizations/*/locations/*/services/*/quotaInfos/*}",
                          "/v1/{name=folders/*/locations/*/services/*/quotaInfos/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetQuotaInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QuotaInfo>newBuilder()
                      .setDefaultInstance(QuotaInfo.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>
      listQuotaPreferencesMethodDescriptor =
          ApiMethodDescriptor
              .<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>newBuilder()
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/ListQuotaPreferences")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListQuotaPreferencesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/quotaPreferences",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListQuotaPreferencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/quotaPreferences",
                          "/v1/{parent=organizations/*/locations/*}/quotaPreferences")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListQuotaPreferencesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListQuotaPreferencesResponse>newBuilder()
                      .setDefaultInstance(ListQuotaPreferencesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetQuotaPreferenceRequest, QuotaPreference>
      getQuotaPreferenceMethodDescriptor =
          ApiMethodDescriptor.<GetQuotaPreferenceRequest, QuotaPreference>newBuilder()
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/GetQuotaPreference")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetQuotaPreferenceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/quotaPreferences/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetQuotaPreferenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=organizations/*/locations/*/quotaPreferences/*}",
                          "/v1/{name=folders/*/locations/*/quotaPreferences/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetQuotaPreferenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QuotaPreference>newBuilder()
                      .setDefaultInstance(QuotaPreference.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceMethodDescriptor =
          ApiMethodDescriptor.<CreateQuotaPreferenceRequest, QuotaPreference>newBuilder()
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/CreateQuotaPreference")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateQuotaPreferenceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/quotaPreferences",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateQuotaPreferenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/quotaPreferences",
                          "/v1/{parent=organizations/*/locations/*}/quotaPreferences")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateQuotaPreferenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "ignoreSafetyChecks", request.getIgnoreSafetyChecksList());
                            serializer.putQueryParam(
                                fields, "quotaPreferenceId", request.getQuotaPreferenceId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("quotaPreference", request.getQuotaPreference(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QuotaPreference>newBuilder()
                      .setDefaultInstance(QuotaPreference.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceMethodDescriptor =
          ApiMethodDescriptor.<UpdateQuotaPreferenceRequest, QuotaPreference>newBuilder()
              .setFullMethodName("google.api.cloudquotas.v1.CloudQuotas/UpdateQuotaPreference")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateQuotaPreferenceRequest>newBuilder()
                      .setPath(
                          "/v1/{quotaPreference.name=projects/*/locations/*/quotaPreferences/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateQuotaPreferenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "quotaPreference.name",
                                request.getQuotaPreference().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{quotaPreference.name=folders/*/locations/*/quotaPreferences/*}",
                          "/v1/{quotaPreference.name=organizations/*/locations/*/quotaPreferences/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateQuotaPreferenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(
                                fields, "ignoreSafetyChecks", request.getIgnoreSafetyChecksList());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("quotaPreference", request.getQuotaPreference(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QuotaPreference>newBuilder()
                      .setDefaultInstance(QuotaPreference.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosResponse> listQuotaInfosCallable;
  private final UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosPagedResponse>
      listQuotaInfosPagedCallable;
  private final UnaryCallable<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoCallable;
  private final UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>
      listQuotaPreferencesCallable;
  private final UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesPagedResponse>
      listQuotaPreferencesPagedCallable;
  private final UnaryCallable<GetQuotaPreferenceRequest, QuotaPreference>
      getQuotaPreferenceCallable;
  private final UnaryCallable<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceCallable;
  private final UnaryCallable<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudQuotasStub create(CloudQuotasStubSettings settings)
      throws IOException {
    return new HttpJsonCloudQuotasStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudQuotasStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudQuotasStub(
        CloudQuotasStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudQuotasStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudQuotasStub(
        CloudQuotasStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudQuotasStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudQuotasStub(CloudQuotasStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCloudQuotasCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudQuotasStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudQuotasStub(
      CloudQuotasStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListQuotaInfosRequest, ListQuotaInfosResponse>
        listQuotaInfosTransportSettings =
            HttpJsonCallSettings.<ListQuotaInfosRequest, ListQuotaInfosResponse>newBuilder()
                .setMethodDescriptor(listQuotaInfosMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoTransportSettings =
        HttpJsonCallSettings.<GetQuotaInfoRequest, QuotaInfo>newBuilder()
            .setMethodDescriptor(getQuotaInfoMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>
        listQuotaPreferencesTransportSettings =
            HttpJsonCallSettings
                .<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>newBuilder()
                .setMethodDescriptor(listQuotaPreferencesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetQuotaPreferenceRequest, QuotaPreference>
        getQuotaPreferenceTransportSettings =
            HttpJsonCallSettings.<GetQuotaPreferenceRequest, QuotaPreference>newBuilder()
                .setMethodDescriptor(getQuotaPreferenceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateQuotaPreferenceRequest, QuotaPreference>
        createQuotaPreferenceTransportSettings =
            HttpJsonCallSettings.<CreateQuotaPreferenceRequest, QuotaPreference>newBuilder()
                .setMethodDescriptor(createQuotaPreferenceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateQuotaPreferenceRequest, QuotaPreference>
        updateQuotaPreferenceTransportSettings =
            HttpJsonCallSettings.<UpdateQuotaPreferenceRequest, QuotaPreference>newBuilder()
                .setMethodDescriptor(updateQuotaPreferenceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "quota_preference.name",
                          String.valueOf(request.getQuotaPreference().getName()));
                      return builder.build();
                    })
                .build();

    this.listQuotaInfosCallable =
        callableFactory.createUnaryCallable(
            listQuotaInfosTransportSettings, settings.listQuotaInfosSettings(), clientContext);
    this.listQuotaInfosPagedCallable =
        callableFactory.createPagedCallable(
            listQuotaInfosTransportSettings, settings.listQuotaInfosSettings(), clientContext);
    this.getQuotaInfoCallable =
        callableFactory.createUnaryCallable(
            getQuotaInfoTransportSettings, settings.getQuotaInfoSettings(), clientContext);
    this.listQuotaPreferencesCallable =
        callableFactory.createUnaryCallable(
            listQuotaPreferencesTransportSettings,
            settings.listQuotaPreferencesSettings(),
            clientContext);
    this.listQuotaPreferencesPagedCallable =
        callableFactory.createPagedCallable(
            listQuotaPreferencesTransportSettings,
            settings.listQuotaPreferencesSettings(),
            clientContext);
    this.getQuotaPreferenceCallable =
        callableFactory.createUnaryCallable(
            getQuotaPreferenceTransportSettings,
            settings.getQuotaPreferenceSettings(),
            clientContext);
    this.createQuotaPreferenceCallable =
        callableFactory.createUnaryCallable(
            createQuotaPreferenceTransportSettings,
            settings.createQuotaPreferenceSettings(),
            clientContext);
    this.updateQuotaPreferenceCallable =
        callableFactory.createUnaryCallable(
            updateQuotaPreferenceTransportSettings,
            settings.updateQuotaPreferenceSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listQuotaInfosMethodDescriptor);
    methodDescriptors.add(getQuotaInfoMethodDescriptor);
    methodDescriptors.add(listQuotaPreferencesMethodDescriptor);
    methodDescriptors.add(getQuotaPreferenceMethodDescriptor);
    methodDescriptors.add(createQuotaPreferenceMethodDescriptor);
    methodDescriptors.add(updateQuotaPreferenceMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosResponse> listQuotaInfosCallable() {
    return listQuotaInfosCallable;
  }

  @Override
  public UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosPagedResponse>
      listQuotaInfosPagedCallable() {
    return listQuotaInfosPagedCallable;
  }

  @Override
  public UnaryCallable<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoCallable() {
    return getQuotaInfoCallable;
  }

  @Override
  public UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>
      listQuotaPreferencesCallable() {
    return listQuotaPreferencesCallable;
  }

  @Override
  public UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesPagedResponse>
      listQuotaPreferencesPagedCallable() {
    return listQuotaPreferencesPagedCallable;
  }

  @Override
  public UnaryCallable<GetQuotaPreferenceRequest, QuotaPreference> getQuotaPreferenceCallable() {
    return getQuotaPreferenceCallable;
  }

  @Override
  public UnaryCallable<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceCallable() {
    return createQuotaPreferenceCallable;
  }

  @Override
  public UnaryCallable<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceCallable() {
    return updateQuotaPreferenceCallable;
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
