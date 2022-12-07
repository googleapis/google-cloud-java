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

package com.google.cloud.websecurityscanner.v1alpha.stub;

import static com.google.cloud.websecurityscanner.v1alpha.WebSecurityScannerClient.ListCrawledUrlsPagedResponse;
import static com.google.cloud.websecurityscanner.v1alpha.WebSecurityScannerClient.ListFindingsPagedResponse;
import static com.google.cloud.websecurityscanner.v1alpha.WebSecurityScannerClient.ListScanConfigsPagedResponse;
import static com.google.cloud.websecurityscanner.v1alpha.WebSecurityScannerClient.ListScanRunsPagedResponse;

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
import com.google.cloud.websecurityscanner.v1alpha.CreateScanConfigRequest;
import com.google.cloud.websecurityscanner.v1alpha.DeleteScanConfigRequest;
import com.google.cloud.websecurityscanner.v1alpha.Finding;
import com.google.cloud.websecurityscanner.v1alpha.GetFindingRequest;
import com.google.cloud.websecurityscanner.v1alpha.GetScanConfigRequest;
import com.google.cloud.websecurityscanner.v1alpha.GetScanRunRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListCrawledUrlsResponse;
import com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListFindingTypeStatsResponse;
import com.google.cloud.websecurityscanner.v1alpha.ListFindingsRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListFindingsResponse;
import com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListScanConfigsResponse;
import com.google.cloud.websecurityscanner.v1alpha.ListScanRunsRequest;
import com.google.cloud.websecurityscanner.v1alpha.ListScanRunsResponse;
import com.google.cloud.websecurityscanner.v1alpha.ScanConfig;
import com.google.cloud.websecurityscanner.v1alpha.ScanRun;
import com.google.cloud.websecurityscanner.v1alpha.StartScanRunRequest;
import com.google.cloud.websecurityscanner.v1alpha.StopScanRunRequest;
import com.google.cloud.websecurityscanner.v1alpha.UpdateScanConfigRequest;
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
 * REST stub implementation for the WebSecurityScanner service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonWebSecurityScannerStub extends WebSecurityScannerStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateScanConfigRequest, ScanConfig>
      createScanConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateScanConfigRequest, ScanConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/CreateScanConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateScanConfigRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*}/scanConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateScanConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateScanConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("scanConfig", request.getScanConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ScanConfig>newBuilder()
                      .setDefaultInstance(ScanConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteScanConfigRequest, Empty>
      deleteScanConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteScanConfigRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/DeleteScanConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteScanConfigRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/scanConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteScanConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteScanConfigRequest> serializer =
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

  private static final ApiMethodDescriptor<GetScanConfigRequest, ScanConfig>
      getScanConfigMethodDescriptor =
          ApiMethodDescriptor.<GetScanConfigRequest, ScanConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/GetScanConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetScanConfigRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/scanConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetScanConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetScanConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ScanConfig>newBuilder()
                      .setDefaultInstance(ScanConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListScanConfigsRequest, ListScanConfigsResponse>
      listScanConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListScanConfigsRequest, ListScanConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/ListScanConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListScanConfigsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*}/scanConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListScanConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListScanConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListScanConfigsResponse>newBuilder()
                      .setDefaultInstance(ListScanConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateScanConfigRequest, ScanConfig>
      updateScanConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateScanConfigRequest, ScanConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/UpdateScanConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateScanConfigRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{scanConfig.name=projects/*/scanConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateScanConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "scanConfig.name", request.getScanConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateScanConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("scanConfig", request.getScanConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ScanConfig>newBuilder()
                      .setDefaultInstance(ScanConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StartScanRunRequest, ScanRun>
      startScanRunMethodDescriptor =
          ApiMethodDescriptor.<StartScanRunRequest, ScanRun>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/StartScanRun")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartScanRunRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/scanConfigs/*}:start",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartScanRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartScanRunRequest> serializer =
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
                  ProtoMessageResponseParser.<ScanRun>newBuilder()
                      .setDefaultInstance(ScanRun.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetScanRunRequest, ScanRun> getScanRunMethodDescriptor =
      ApiMethodDescriptor.<GetScanRunRequest, ScanRun>newBuilder()
          .setFullMethodName(
              "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/GetScanRun")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetScanRunRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/scanConfigs/*/scanRuns/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetScanRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetScanRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<ScanRun>newBuilder()
                  .setDefaultInstance(ScanRun.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListScanRunsRequest, ListScanRunsResponse>
      listScanRunsMethodDescriptor =
          ApiMethodDescriptor.<ListScanRunsRequest, ListScanRunsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/ListScanRuns")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListScanRunsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/scanConfigs/*}/scanRuns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListScanRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListScanRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListScanRunsResponse>newBuilder()
                      .setDefaultInstance(ListScanRunsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StopScanRunRequest, ScanRun>
      stopScanRunMethodDescriptor =
          ApiMethodDescriptor.<StopScanRunRequest, ScanRun>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/StopScanRun")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopScanRunRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/scanConfigs/*/scanRuns/*}:stop",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopScanRunRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopScanRunRequest> serializer =
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
                  ProtoMessageResponseParser.<ScanRun>newBuilder()
                      .setDefaultInstance(ScanRun.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCrawledUrlsRequest, ListCrawledUrlsResponse>
      listCrawledUrlsMethodDescriptor =
          ApiMethodDescriptor.<ListCrawledUrlsRequest, ListCrawledUrlsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/ListCrawledUrls")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCrawledUrlsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/scanConfigs/*/scanRuns/*}/crawledUrls",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCrawledUrlsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCrawledUrlsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCrawledUrlsResponse>newBuilder()
                      .setDefaultInstance(ListCrawledUrlsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFindingRequest, Finding> getFindingMethodDescriptor =
      ApiMethodDescriptor.<GetFindingRequest, Finding>newBuilder()
          .setFullMethodName(
              "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/GetFinding")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFindingRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/scanConfigs/*/scanRuns/*/findings/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFindingRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFindingRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Finding>newBuilder()
                  .setDefaultInstance(Finding.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListFindingsRequest, ListFindingsResponse>
      listFindingsMethodDescriptor =
          ApiMethodDescriptor.<ListFindingsRequest, ListFindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/ListFindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFindingsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/scanConfigs/*/scanRuns/*}/findings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListFindingsResponse>newBuilder()
                      .setDefaultInstance(ListFindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
      listFindingTypeStatsMethodDescriptor =
          ApiMethodDescriptor
              .<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.websecurityscanner.v1alpha.WebSecurityScanner/ListFindingTypeStats")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFindingTypeStatsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/scanConfigs/*/scanRuns/*}/findingTypeStats",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingTypeStatsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFindingTypeStatsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFindingTypeStatsResponse>newBuilder()
                      .setDefaultInstance(ListFindingTypeStatsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateScanConfigRequest, ScanConfig> createScanConfigCallable;
  private final UnaryCallable<DeleteScanConfigRequest, Empty> deleteScanConfigCallable;
  private final UnaryCallable<GetScanConfigRequest, ScanConfig> getScanConfigCallable;
  private final UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse>
      listScanConfigsCallable;
  private final UnaryCallable<ListScanConfigsRequest, ListScanConfigsPagedResponse>
      listScanConfigsPagedCallable;
  private final UnaryCallable<UpdateScanConfigRequest, ScanConfig> updateScanConfigCallable;
  private final UnaryCallable<StartScanRunRequest, ScanRun> startScanRunCallable;
  private final UnaryCallable<GetScanRunRequest, ScanRun> getScanRunCallable;
  private final UnaryCallable<ListScanRunsRequest, ListScanRunsResponse> listScanRunsCallable;
  private final UnaryCallable<ListScanRunsRequest, ListScanRunsPagedResponse>
      listScanRunsPagedCallable;
  private final UnaryCallable<StopScanRunRequest, ScanRun> stopScanRunCallable;
  private final UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsResponse>
      listCrawledUrlsCallable;
  private final UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsPagedResponse>
      listCrawledUrlsPagedCallable;
  private final UnaryCallable<GetFindingRequest, Finding> getFindingCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse>
      listFindingsPagedCallable;
  private final UnaryCallable<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
      listFindingTypeStatsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWebSecurityScannerStub create(WebSecurityScannerStubSettings settings)
      throws IOException {
    return new HttpJsonWebSecurityScannerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWebSecurityScannerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonWebSecurityScannerStub(
        WebSecurityScannerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWebSecurityScannerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWebSecurityScannerStub(
        WebSecurityScannerStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWebSecurityScannerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWebSecurityScannerStub(
      WebSecurityScannerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonWebSecurityScannerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWebSecurityScannerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWebSecurityScannerStub(
      WebSecurityScannerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateScanConfigRequest, ScanConfig> createScanConfigTransportSettings =
        HttpJsonCallSettings.<CreateScanConfigRequest, ScanConfig>newBuilder()
            .setMethodDescriptor(createScanConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteScanConfigRequest, Empty> deleteScanConfigTransportSettings =
        HttpJsonCallSettings.<DeleteScanConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteScanConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetScanConfigRequest, ScanConfig> getScanConfigTransportSettings =
        HttpJsonCallSettings.<GetScanConfigRequest, ScanConfig>newBuilder()
            .setMethodDescriptor(getScanConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListScanConfigsRequest, ListScanConfigsResponse>
        listScanConfigsTransportSettings =
            HttpJsonCallSettings.<ListScanConfigsRequest, ListScanConfigsResponse>newBuilder()
                .setMethodDescriptor(listScanConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateScanConfigRequest, ScanConfig> updateScanConfigTransportSettings =
        HttpJsonCallSettings.<UpdateScanConfigRequest, ScanConfig>newBuilder()
            .setMethodDescriptor(updateScanConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StartScanRunRequest, ScanRun> startScanRunTransportSettings =
        HttpJsonCallSettings.<StartScanRunRequest, ScanRun>newBuilder()
            .setMethodDescriptor(startScanRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetScanRunRequest, ScanRun> getScanRunTransportSettings =
        HttpJsonCallSettings.<GetScanRunRequest, ScanRun>newBuilder()
            .setMethodDescriptor(getScanRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListScanRunsRequest, ListScanRunsResponse> listScanRunsTransportSettings =
        HttpJsonCallSettings.<ListScanRunsRequest, ListScanRunsResponse>newBuilder()
            .setMethodDescriptor(listScanRunsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StopScanRunRequest, ScanRun> stopScanRunTransportSettings =
        HttpJsonCallSettings.<StopScanRunRequest, ScanRun>newBuilder()
            .setMethodDescriptor(stopScanRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListCrawledUrlsRequest, ListCrawledUrlsResponse>
        listCrawledUrlsTransportSettings =
            HttpJsonCallSettings.<ListCrawledUrlsRequest, ListCrawledUrlsResponse>newBuilder()
                .setMethodDescriptor(listCrawledUrlsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetFindingRequest, Finding> getFindingTransportSettings =
        HttpJsonCallSettings.<GetFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(getFindingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListFindingsRequest, ListFindingsResponse> listFindingsTransportSettings =
        HttpJsonCallSettings.<ListFindingsRequest, ListFindingsResponse>newBuilder()
            .setMethodDescriptor(listFindingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
        listFindingTypeStatsTransportSettings =
            HttpJsonCallSettings
                .<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>newBuilder()
                .setMethodDescriptor(listFindingTypeStatsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createScanConfigCallable =
        callableFactory.createUnaryCallable(
            createScanConfigTransportSettings, settings.createScanConfigSettings(), clientContext);
    this.deleteScanConfigCallable =
        callableFactory.createUnaryCallable(
            deleteScanConfigTransportSettings, settings.deleteScanConfigSettings(), clientContext);
    this.getScanConfigCallable =
        callableFactory.createUnaryCallable(
            getScanConfigTransportSettings, settings.getScanConfigSettings(), clientContext);
    this.listScanConfigsCallable =
        callableFactory.createUnaryCallable(
            listScanConfigsTransportSettings, settings.listScanConfigsSettings(), clientContext);
    this.listScanConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listScanConfigsTransportSettings, settings.listScanConfigsSettings(), clientContext);
    this.updateScanConfigCallable =
        callableFactory.createUnaryCallable(
            updateScanConfigTransportSettings, settings.updateScanConfigSettings(), clientContext);
    this.startScanRunCallable =
        callableFactory.createUnaryCallable(
            startScanRunTransportSettings, settings.startScanRunSettings(), clientContext);
    this.getScanRunCallable =
        callableFactory.createUnaryCallable(
            getScanRunTransportSettings, settings.getScanRunSettings(), clientContext);
    this.listScanRunsCallable =
        callableFactory.createUnaryCallable(
            listScanRunsTransportSettings, settings.listScanRunsSettings(), clientContext);
    this.listScanRunsPagedCallable =
        callableFactory.createPagedCallable(
            listScanRunsTransportSettings, settings.listScanRunsSettings(), clientContext);
    this.stopScanRunCallable =
        callableFactory.createUnaryCallable(
            stopScanRunTransportSettings, settings.stopScanRunSettings(), clientContext);
    this.listCrawledUrlsCallable =
        callableFactory.createUnaryCallable(
            listCrawledUrlsTransportSettings, settings.listCrawledUrlsSettings(), clientContext);
    this.listCrawledUrlsPagedCallable =
        callableFactory.createPagedCallable(
            listCrawledUrlsTransportSettings, settings.listCrawledUrlsSettings(), clientContext);
    this.getFindingCallable =
        callableFactory.createUnaryCallable(
            getFindingTransportSettings, settings.getFindingSettings(), clientContext);
    this.listFindingsCallable =
        callableFactory.createUnaryCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.listFindingsPagedCallable =
        callableFactory.createPagedCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.listFindingTypeStatsCallable =
        callableFactory.createUnaryCallable(
            listFindingTypeStatsTransportSettings,
            settings.listFindingTypeStatsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createScanConfigMethodDescriptor);
    methodDescriptors.add(deleteScanConfigMethodDescriptor);
    methodDescriptors.add(getScanConfigMethodDescriptor);
    methodDescriptors.add(listScanConfigsMethodDescriptor);
    methodDescriptors.add(updateScanConfigMethodDescriptor);
    methodDescriptors.add(startScanRunMethodDescriptor);
    methodDescriptors.add(getScanRunMethodDescriptor);
    methodDescriptors.add(listScanRunsMethodDescriptor);
    methodDescriptors.add(stopScanRunMethodDescriptor);
    methodDescriptors.add(listCrawledUrlsMethodDescriptor);
    methodDescriptors.add(getFindingMethodDescriptor);
    methodDescriptors.add(listFindingsMethodDescriptor);
    methodDescriptors.add(listFindingTypeStatsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateScanConfigRequest, ScanConfig> createScanConfigCallable() {
    return createScanConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteScanConfigRequest, Empty> deleteScanConfigCallable() {
    return deleteScanConfigCallable;
  }

  @Override
  public UnaryCallable<GetScanConfigRequest, ScanConfig> getScanConfigCallable() {
    return getScanConfigCallable;
  }

  @Override
  public UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse> listScanConfigsCallable() {
    return listScanConfigsCallable;
  }

  @Override
  public UnaryCallable<ListScanConfigsRequest, ListScanConfigsPagedResponse>
      listScanConfigsPagedCallable() {
    return listScanConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateScanConfigRequest, ScanConfig> updateScanConfigCallable() {
    return updateScanConfigCallable;
  }

  @Override
  public UnaryCallable<StartScanRunRequest, ScanRun> startScanRunCallable() {
    return startScanRunCallable;
  }

  @Override
  public UnaryCallable<GetScanRunRequest, ScanRun> getScanRunCallable() {
    return getScanRunCallable;
  }

  @Override
  public UnaryCallable<ListScanRunsRequest, ListScanRunsResponse> listScanRunsCallable() {
    return listScanRunsCallable;
  }

  @Override
  public UnaryCallable<ListScanRunsRequest, ListScanRunsPagedResponse> listScanRunsPagedCallable() {
    return listScanRunsPagedCallable;
  }

  @Override
  public UnaryCallable<StopScanRunRequest, ScanRun> stopScanRunCallable() {
    return stopScanRunCallable;
  }

  @Override
  public UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsResponse> listCrawledUrlsCallable() {
    return listCrawledUrlsCallable;
  }

  @Override
  public UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsPagedResponse>
      listCrawledUrlsPagedCallable() {
    return listCrawledUrlsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFindingRequest, Finding> getFindingCallable() {
    return getFindingCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    return listFindingsCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse> listFindingsPagedCallable() {
    return listFindingsPagedCallable;
  }

  @Override
  public UnaryCallable<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
      listFindingTypeStatsCallable() {
    return listFindingTypeStatsCallable;
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
