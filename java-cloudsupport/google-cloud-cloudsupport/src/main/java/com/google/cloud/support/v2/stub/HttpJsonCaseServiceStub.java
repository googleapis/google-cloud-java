/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.support.v2.stub;

import static com.google.cloud.support.v2.CaseServiceClient.ListCasesPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCaseClassificationsPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCasesPagedResponse;

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
import com.google.cloud.support.v2.Case;
import com.google.cloud.support.v2.CloseCaseRequest;
import com.google.cloud.support.v2.CreateCaseRequest;
import com.google.cloud.support.v2.EscalateCaseRequest;
import com.google.cloud.support.v2.GetCaseRequest;
import com.google.cloud.support.v2.ListCasesRequest;
import com.google.cloud.support.v2.ListCasesResponse;
import com.google.cloud.support.v2.SearchCaseClassificationsRequest;
import com.google.cloud.support.v2.SearchCaseClassificationsResponse;
import com.google.cloud.support.v2.SearchCasesRequest;
import com.google.cloud.support.v2.SearchCasesResponse;
import com.google.cloud.support.v2.UpdateCaseRequest;
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
 * REST stub implementation for the CaseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCaseServiceStub extends CaseServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCaseRequest, Case> getCaseMethodDescriptor =
      ApiMethodDescriptor.<GetCaseRequest, Case>newBuilder()
          .setFullMethodName("google.cloud.support.v2.CaseService/GetCase")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetCaseRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/cases/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetCaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths("/v2/{name=organizations/*/cases/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetCaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Case>newBuilder()
                  .setDefaultInstance(Case.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListCasesRequest, ListCasesResponse>
      listCasesMethodDescriptor =
          ApiMethodDescriptor.<ListCasesRequest, ListCasesResponse>newBuilder()
              .setFullMethodName("google.cloud.support.v2.CaseService/ListCases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCasesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/cases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=organizations/*}/cases")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCasesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCasesResponse>newBuilder()
                      .setDefaultInstance(ListCasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchCasesRequest, SearchCasesResponse>
      searchCasesMethodDescriptor =
          ApiMethodDescriptor.<SearchCasesRequest, SearchCasesResponse>newBuilder()
              .setFullMethodName("google.cloud.support.v2.CaseService/SearchCases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchCasesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/cases:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=organizations/*}/cases:search")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchCasesResponse>newBuilder()
                      .setDefaultInstance(SearchCasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCaseRequest, Case> createCaseMethodDescriptor =
      ApiMethodDescriptor.<CreateCaseRequest, Case>newBuilder()
          .setFullMethodName("google.cloud.support.v2.CaseService/CreateCase")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateCaseRequest>newBuilder()
                  .setPath(
                      "/v2/{parent=projects/*}/cases",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateCaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setAdditionalPaths("/v2/{parent=organizations/*}/cases")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateCaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("case_", request.getCase(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Case>newBuilder()
                  .setDefaultInstance(Case.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateCaseRequest, Case> updateCaseMethodDescriptor =
      ApiMethodDescriptor.<UpdateCaseRequest, Case>newBuilder()
          .setFullMethodName("google.cloud.support.v2.CaseService/UpdateCase")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateCaseRequest>newBuilder()
                  .setPath(
                      "/v2/{case.name=projects/*/cases/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateCaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "case.name", request.getCase().getName());
                        return fields;
                      })
                  .setAdditionalPaths("/v2/{case.name=organizations/*/cases/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateCaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("case_", request.getCase(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Case>newBuilder()
                  .setDefaultInstance(Case.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<EscalateCaseRequest, Case> escalateCaseMethodDescriptor =
      ApiMethodDescriptor.<EscalateCaseRequest, Case>newBuilder()
          .setFullMethodName("google.cloud.support.v2.CaseService/EscalateCase")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<EscalateCaseRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/cases/*}:escalate",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<EscalateCaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths("/v2/{name=organizations/*/cases/*}:escalate")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<EscalateCaseRequest> serializer =
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
              ProtoMessageResponseParser.<Case>newBuilder()
                  .setDefaultInstance(Case.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CloseCaseRequest, Case> closeCaseMethodDescriptor =
      ApiMethodDescriptor.<CloseCaseRequest, Case>newBuilder()
          .setFullMethodName("google.cloud.support.v2.CaseService/CloseCase")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CloseCaseRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/cases/*}:close",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CloseCaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths("/v2/{name=organizations/*/cases/*}:close")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CloseCaseRequest> serializer =
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
              ProtoMessageResponseParser.<Case>newBuilder()
                  .setDefaultInstance(Case.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<
          SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
      searchCaseClassificationsMethodDescriptor =
          ApiMethodDescriptor
              .<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>newBuilder()
              .setFullMethodName("google.cloud.support.v2.CaseService/SearchCaseClassifications")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchCaseClassificationsRequest>newBuilder()
                      .setPath(
                          "/v2/caseClassifications:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchCaseClassificationsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchCaseClassificationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchCaseClassificationsResponse>newBuilder()
                      .setDefaultInstance(SearchCaseClassificationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCaseRequest, Case> getCaseCallable;
  private final UnaryCallable<ListCasesRequest, ListCasesResponse> listCasesCallable;
  private final UnaryCallable<ListCasesRequest, ListCasesPagedResponse> listCasesPagedCallable;
  private final UnaryCallable<SearchCasesRequest, SearchCasesResponse> searchCasesCallable;
  private final UnaryCallable<SearchCasesRequest, SearchCasesPagedResponse>
      searchCasesPagedCallable;
  private final UnaryCallable<CreateCaseRequest, Case> createCaseCallable;
  private final UnaryCallable<UpdateCaseRequest, Case> updateCaseCallable;
  private final UnaryCallable<EscalateCaseRequest, Case> escalateCaseCallable;
  private final UnaryCallable<CloseCaseRequest, Case> closeCaseCallable;
  private final UnaryCallable<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
      searchCaseClassificationsCallable;
  private final UnaryCallable<
          SearchCaseClassificationsRequest, SearchCaseClassificationsPagedResponse>
      searchCaseClassificationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCaseServiceStub create(CaseServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCaseServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCaseServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCaseServiceStub(
        CaseServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCaseServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCaseServiceStub(
        CaseServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCaseServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCaseServiceStub(CaseServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCaseServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCaseServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCaseServiceStub(
      CaseServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCaseRequest, Case> getCaseTransportSettings =
        HttpJsonCallSettings.<GetCaseRequest, Case>newBuilder()
            .setMethodDescriptor(getCaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCasesRequest, ListCasesResponse> listCasesTransportSettings =
        HttpJsonCallSettings.<ListCasesRequest, ListCasesResponse>newBuilder()
            .setMethodDescriptor(listCasesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SearchCasesRequest, SearchCasesResponse> searchCasesTransportSettings =
        HttpJsonCallSettings.<SearchCasesRequest, SearchCasesResponse>newBuilder()
            .setMethodDescriptor(searchCasesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateCaseRequest, Case> createCaseTransportSettings =
        HttpJsonCallSettings.<CreateCaseRequest, Case>newBuilder()
            .setMethodDescriptor(createCaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateCaseRequest, Case> updateCaseTransportSettings =
        HttpJsonCallSettings.<UpdateCaseRequest, Case>newBuilder()
            .setMethodDescriptor(updateCaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("case.name", String.valueOf(request.getCase().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EscalateCaseRequest, Case> escalateCaseTransportSettings =
        HttpJsonCallSettings.<EscalateCaseRequest, Case>newBuilder()
            .setMethodDescriptor(escalateCaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CloseCaseRequest, Case> closeCaseTransportSettings =
        HttpJsonCallSettings.<CloseCaseRequest, Case>newBuilder()
            .setMethodDescriptor(closeCaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
        searchCaseClassificationsTransportSettings =
            HttpJsonCallSettings
                .<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>newBuilder()
                .setMethodDescriptor(searchCaseClassificationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.getCaseCallable =
        callableFactory.createUnaryCallable(
            getCaseTransportSettings, settings.getCaseSettings(), clientContext);
    this.listCasesCallable =
        callableFactory.createUnaryCallable(
            listCasesTransportSettings, settings.listCasesSettings(), clientContext);
    this.listCasesPagedCallable =
        callableFactory.createPagedCallable(
            listCasesTransportSettings, settings.listCasesSettings(), clientContext);
    this.searchCasesCallable =
        callableFactory.createUnaryCallable(
            searchCasesTransportSettings, settings.searchCasesSettings(), clientContext);
    this.searchCasesPagedCallable =
        callableFactory.createPagedCallable(
            searchCasesTransportSettings, settings.searchCasesSettings(), clientContext);
    this.createCaseCallable =
        callableFactory.createUnaryCallable(
            createCaseTransportSettings, settings.createCaseSettings(), clientContext);
    this.updateCaseCallable =
        callableFactory.createUnaryCallable(
            updateCaseTransportSettings, settings.updateCaseSettings(), clientContext);
    this.escalateCaseCallable =
        callableFactory.createUnaryCallable(
            escalateCaseTransportSettings, settings.escalateCaseSettings(), clientContext);
    this.closeCaseCallable =
        callableFactory.createUnaryCallable(
            closeCaseTransportSettings, settings.closeCaseSettings(), clientContext);
    this.searchCaseClassificationsCallable =
        callableFactory.createUnaryCallable(
            searchCaseClassificationsTransportSettings,
            settings.searchCaseClassificationsSettings(),
            clientContext);
    this.searchCaseClassificationsPagedCallable =
        callableFactory.createPagedCallable(
            searchCaseClassificationsTransportSettings,
            settings.searchCaseClassificationsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCaseMethodDescriptor);
    methodDescriptors.add(listCasesMethodDescriptor);
    methodDescriptors.add(searchCasesMethodDescriptor);
    methodDescriptors.add(createCaseMethodDescriptor);
    methodDescriptors.add(updateCaseMethodDescriptor);
    methodDescriptors.add(escalateCaseMethodDescriptor);
    methodDescriptors.add(closeCaseMethodDescriptor);
    methodDescriptors.add(searchCaseClassificationsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCaseRequest, Case> getCaseCallable() {
    return getCaseCallable;
  }

  @Override
  public UnaryCallable<ListCasesRequest, ListCasesResponse> listCasesCallable() {
    return listCasesCallable;
  }

  @Override
  public UnaryCallable<ListCasesRequest, ListCasesPagedResponse> listCasesPagedCallable() {
    return listCasesPagedCallable;
  }

  @Override
  public UnaryCallable<SearchCasesRequest, SearchCasesResponse> searchCasesCallable() {
    return searchCasesCallable;
  }

  @Override
  public UnaryCallable<SearchCasesRequest, SearchCasesPagedResponse> searchCasesPagedCallable() {
    return searchCasesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCaseRequest, Case> createCaseCallable() {
    return createCaseCallable;
  }

  @Override
  public UnaryCallable<UpdateCaseRequest, Case> updateCaseCallable() {
    return updateCaseCallable;
  }

  @Override
  public UnaryCallable<EscalateCaseRequest, Case> escalateCaseCallable() {
    return escalateCaseCallable;
  }

  @Override
  public UnaryCallable<CloseCaseRequest, Case> closeCaseCallable() {
    return closeCaseCallable;
  }

  @Override
  public UnaryCallable<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
      searchCaseClassificationsCallable() {
    return searchCaseClassificationsCallable;
  }

  @Override
  public UnaryCallable<SearchCaseClassificationsRequest, SearchCaseClassificationsPagedResponse>
      searchCaseClassificationsPagedCallable() {
    return searchCaseClassificationsPagedCallable;
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
