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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.SiteSearchEngineServiceClient.FetchDomainVerificationStatusPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.SiteSearchEngineServiceClient.ListTargetSitesPagedResponse;

import com.google.api.HttpRule;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest;
import com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesResponse;
import com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesMetadata;
import com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest;
import com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesResponse;
import com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest;
import com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest;
import com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse;
import com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest;
import com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest;
import com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest;
import com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse;
import com.google.cloud.discoveryengine.v1alpha.RecrawlUrisMetadata;
import com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest;
import com.google.cloud.discoveryengine.v1alpha.RecrawlUrisResponse;
import com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine;
import com.google.cloud.discoveryengine.v1alpha.TargetSite;
import com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the SiteSearchEngineService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSiteSearchEngineServiceStub extends SiteSearchEngineServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(TargetSite.getDescriptor())
          .add(EnableAdvancedSiteSearchMetadata.getDescriptor())
          .add(CreateTargetSiteMetadata.getDescriptor())
          .add(UpdateTargetSiteMetadata.getDescriptor())
          .add(BatchVerifyTargetSitesResponse.getDescriptor())
          .add(DeleteTargetSiteMetadata.getDescriptor())
          .add(EnableAdvancedSiteSearchResponse.getDescriptor())
          .add(RecrawlUrisResponse.getDescriptor())
          .add(RecrawlUrisMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(BatchVerifyTargetSitesMetadata.getDescriptor())
          .add(BatchCreateTargetSitesResponse.getDescriptor())
          .add(DisableAdvancedSiteSearchResponse.getDescriptor())
          .add(DisableAdvancedSiteSearchMetadata.getDescriptor())
          .add(BatchCreateTargetSiteMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetSiteSearchEngineRequest, SiteSearchEngine>
      getSiteSearchEngineMethodDescriptor =
          ApiMethodDescriptor.<GetSiteSearchEngineRequest, SiteSearchEngine>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/GetSiteSearchEngine")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSiteSearchEngineRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/dataStores/*/siteSearchEngine}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSiteSearchEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSiteSearchEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SiteSearchEngine>newBuilder()
                      .setDefaultInstance(SiteSearchEngine.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTargetSiteRequest, Operation>
      createTargetSiteMethodDescriptor =
          ApiMethodDescriptor.<CreateTargetSiteRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/CreateTargetSite")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTargetSiteRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/*/siteSearchEngine}/targetSites",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTargetSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/targetSites")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTargetSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("targetSite", request.getTargetSite(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateTargetSiteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchCreateTargetSitesRequest, Operation>
      batchCreateTargetSitesMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateTargetSitesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/BatchCreateTargetSites")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateTargetSitesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/*/siteSearchEngine}/targetSites:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateTargetSitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/targetSites:batchCreate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateTargetSitesRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchCreateTargetSitesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetTargetSiteRequest, TargetSite>
      getTargetSiteMethodDescriptor =
          ApiMethodDescriptor.<GetTargetSiteRequest, TargetSite>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/GetTargetSite")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTargetSiteRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/dataStores/*/siteSearchEngine/targetSites/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTargetSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTargetSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TargetSite>newBuilder()
                      .setDefaultInstance(TargetSite.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateTargetSiteRequest, Operation>
      updateTargetSiteMethodDescriptor =
          ApiMethodDescriptor.<UpdateTargetSiteRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/UpdateTargetSite")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTargetSiteRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{targetSite.name=projects/*/locations/*/dataStores/*/siteSearchEngine/targetSites/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTargetSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "targetSite.name", request.getTargetSite().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{targetSite.name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTargetSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("targetSite", request.getTargetSite(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateTargetSiteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteTargetSiteRequest, Operation>
      deleteTargetSiteMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetSiteRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/DeleteTargetSite")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTargetSiteRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/dataStores/*/siteSearchEngine/targetSites/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTargetSiteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteTargetSiteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListTargetSitesRequest, ListTargetSitesResponse>
      listTargetSitesMethodDescriptor =
          ApiMethodDescriptor.<ListTargetSitesRequest, ListTargetSitesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/ListTargetSites")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTargetSitesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/*/siteSearchEngine}/targetSites",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetSitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/targetSites")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTargetSitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTargetSitesResponse>newBuilder()
                      .setDefaultInstance(ListTargetSitesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchMethodDescriptor =
          ApiMethodDescriptor.<EnableAdvancedSiteSearchRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/EnableAdvancedSiteSearch")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableAdvancedSiteSearchRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{siteSearchEngine=projects/*/locations/*/dataStores/*/siteSearchEngine}:enableAdvancedSiteSearch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnableAdvancedSiteSearchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "siteSearchEngine", request.getSiteSearchEngine());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{siteSearchEngine=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}:enableAdvancedSiteSearch")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnableAdvancedSiteSearchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearSiteSearchEngine().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (EnableAdvancedSiteSearchRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchMethodDescriptor =
          ApiMethodDescriptor.<DisableAdvancedSiteSearchRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/DisableAdvancedSiteSearch")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableAdvancedSiteSearchRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{siteSearchEngine=projects/*/locations/*/dataStores/*/siteSearchEngine}:disableAdvancedSiteSearch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisableAdvancedSiteSearchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "siteSearchEngine", request.getSiteSearchEngine());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{siteSearchEngine=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}:disableAdvancedSiteSearch")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisableAdvancedSiteSearchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearSiteSearchEngine().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DisableAdvancedSiteSearchRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RecrawlUrisRequest, Operation>
      recrawlUrisMethodDescriptor =
          ApiMethodDescriptor.<RecrawlUrisRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/RecrawlUris")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RecrawlUrisRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{siteSearchEngine=projects/*/locations/*/dataStores/*/siteSearchEngine}:recrawlUris",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RecrawlUrisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "siteSearchEngine", request.getSiteSearchEngine());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{siteSearchEngine=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}:recrawlUris")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RecrawlUrisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearSiteSearchEngine().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RecrawlUrisRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchVerifyTargetSitesRequest, Operation>
      batchVerifyTargetSitesMethodDescriptor =
          ApiMethodDescriptor.<BatchVerifyTargetSitesRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/BatchVerifyTargetSites")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchVerifyTargetSitesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}:batchVerifyTargetSites",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchVerifyTargetSitesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchVerifyTargetSitesRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchVerifyTargetSitesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
      fetchDomainVerificationStatusMethodDescriptor =
          ApiMethodDescriptor
              .<FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService/FetchDomainVerificationStatus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchDomainVerificationStatusRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{siteSearchEngine=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}:fetchDomainVerificationStatus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchDomainVerificationStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "siteSearchEngine", request.getSiteSearchEngine());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchDomainVerificationStatusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchDomainVerificationStatusResponse>newBuilder()
                      .setDefaultInstance(
                          FetchDomainVerificationStatusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetSiteSearchEngineRequest, SiteSearchEngine>
      getSiteSearchEngineCallable;
  private final UnaryCallable<CreateTargetSiteRequest, Operation> createTargetSiteCallable;
  private final OperationCallable<CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
      createTargetSiteOperationCallable;
  private final UnaryCallable<BatchCreateTargetSitesRequest, Operation>
      batchCreateTargetSitesCallable;
  private final OperationCallable<
          BatchCreateTargetSitesRequest,
          BatchCreateTargetSitesResponse,
          BatchCreateTargetSiteMetadata>
      batchCreateTargetSitesOperationCallable;
  private final UnaryCallable<GetTargetSiteRequest, TargetSite> getTargetSiteCallable;
  private final UnaryCallable<UpdateTargetSiteRequest, Operation> updateTargetSiteCallable;
  private final OperationCallable<UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
      updateTargetSiteOperationCallable;
  private final UnaryCallable<DeleteTargetSiteRequest, Operation> deleteTargetSiteCallable;
  private final OperationCallable<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
      deleteTargetSiteOperationCallable;
  private final UnaryCallable<ListTargetSitesRequest, ListTargetSitesResponse>
      listTargetSitesCallable;
  private final UnaryCallable<ListTargetSitesRequest, ListTargetSitesPagedResponse>
      listTargetSitesPagedCallable;
  private final UnaryCallable<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchCallable;
  private final OperationCallable<
          EnableAdvancedSiteSearchRequest,
          EnableAdvancedSiteSearchResponse,
          EnableAdvancedSiteSearchMetadata>
      enableAdvancedSiteSearchOperationCallable;
  private final UnaryCallable<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchCallable;
  private final OperationCallable<
          DisableAdvancedSiteSearchRequest,
          DisableAdvancedSiteSearchResponse,
          DisableAdvancedSiteSearchMetadata>
      disableAdvancedSiteSearchOperationCallable;
  private final UnaryCallable<RecrawlUrisRequest, Operation> recrawlUrisCallable;
  private final OperationCallable<RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
      recrawlUrisOperationCallable;
  private final UnaryCallable<BatchVerifyTargetSitesRequest, Operation>
      batchVerifyTargetSitesCallable;
  private final OperationCallable<
          BatchVerifyTargetSitesRequest,
          BatchVerifyTargetSitesResponse,
          BatchVerifyTargetSitesMetadata>
      batchVerifyTargetSitesOperationCallable;
  private final UnaryCallable<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
      fetchDomainVerificationStatusCallable;
  private final UnaryCallable<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusPagedResponse>
      fetchDomainVerificationStatusPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSiteSearchEngineServiceStub create(
      SiteSearchEngineServiceStubSettings settings) throws IOException {
    return new HttpJsonSiteSearchEngineServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSiteSearchEngineServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSiteSearchEngineServiceStub(
        SiteSearchEngineServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSiteSearchEngineServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSiteSearchEngineServiceStub(
        SiteSearchEngineServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSiteSearchEngineServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSiteSearchEngineServiceStub(
      SiteSearchEngineServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSiteSearchEngineServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSiteSearchEngineServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSiteSearchEngineServiceStub(
      SiteSearchEngineServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataConnector/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/evaluations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataConnector}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<GetSiteSearchEngineRequest, SiteSearchEngine>
        getSiteSearchEngineTransportSettings =
            HttpJsonCallSettings.<GetSiteSearchEngineRequest, SiteSearchEngine>newBuilder()
                .setMethodDescriptor(getSiteSearchEngineMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateTargetSiteRequest, Operation> createTargetSiteTransportSettings =
        HttpJsonCallSettings.<CreateTargetSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(createTargetSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchCreateTargetSitesRequest, Operation>
        batchCreateTargetSitesTransportSettings =
            HttpJsonCallSettings.<BatchCreateTargetSitesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchCreateTargetSitesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetTargetSiteRequest, TargetSite> getTargetSiteTransportSettings =
        HttpJsonCallSettings.<GetTargetSiteRequest, TargetSite>newBuilder()
            .setMethodDescriptor(getTargetSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateTargetSiteRequest, Operation> updateTargetSiteTransportSettings =
        HttpJsonCallSettings.<UpdateTargetSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTargetSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "target_site.name", String.valueOf(request.getTargetSite().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteTargetSiteRequest, Operation> deleteTargetSiteTransportSettings =
        HttpJsonCallSettings.<DeleteTargetSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTargetSiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTargetSitesRequest, ListTargetSitesResponse>
        listTargetSitesTransportSettings =
            HttpJsonCallSettings.<ListTargetSitesRequest, ListTargetSitesResponse>newBuilder()
                .setMethodDescriptor(listTargetSitesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<EnableAdvancedSiteSearchRequest, Operation>
        enableAdvancedSiteSearchTransportSettings =
            HttpJsonCallSettings.<EnableAdvancedSiteSearchRequest, Operation>newBuilder()
                .setMethodDescriptor(enableAdvancedSiteSearchMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "site_search_engine", String.valueOf(request.getSiteSearchEngine()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DisableAdvancedSiteSearchRequest, Operation>
        disableAdvancedSiteSearchTransportSettings =
            HttpJsonCallSettings.<DisableAdvancedSiteSearchRequest, Operation>newBuilder()
                .setMethodDescriptor(disableAdvancedSiteSearchMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "site_search_engine", String.valueOf(request.getSiteSearchEngine()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RecrawlUrisRequest, Operation> recrawlUrisTransportSettings =
        HttpJsonCallSettings.<RecrawlUrisRequest, Operation>newBuilder()
            .setMethodDescriptor(recrawlUrisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("site_search_engine", String.valueOf(request.getSiteSearchEngine()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchVerifyTargetSitesRequest, Operation>
        batchVerifyTargetSitesTransportSettings =
            HttpJsonCallSettings.<BatchVerifyTargetSitesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchVerifyTargetSitesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
        fetchDomainVerificationStatusTransportSettings =
            HttpJsonCallSettings
                .<FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
                    newBuilder()
                .setMethodDescriptor(fetchDomainVerificationStatusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "site_search_engine", String.valueOf(request.getSiteSearchEngine()));
                      return builder.build();
                    })
                .build();

    this.getSiteSearchEngineCallable =
        callableFactory.createUnaryCallable(
            getSiteSearchEngineTransportSettings,
            settings.getSiteSearchEngineSettings(),
            clientContext);
    this.createTargetSiteCallable =
        callableFactory.createUnaryCallable(
            createTargetSiteTransportSettings, settings.createTargetSiteSettings(), clientContext);
    this.createTargetSiteOperationCallable =
        callableFactory.createOperationCallable(
            createTargetSiteTransportSettings,
            settings.createTargetSiteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchCreateTargetSitesCallable =
        callableFactory.createUnaryCallable(
            batchCreateTargetSitesTransportSettings,
            settings.batchCreateTargetSitesSettings(),
            clientContext);
    this.batchCreateTargetSitesOperationCallable =
        callableFactory.createOperationCallable(
            batchCreateTargetSitesTransportSettings,
            settings.batchCreateTargetSitesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getTargetSiteCallable =
        callableFactory.createUnaryCallable(
            getTargetSiteTransportSettings, settings.getTargetSiteSettings(), clientContext);
    this.updateTargetSiteCallable =
        callableFactory.createUnaryCallable(
            updateTargetSiteTransportSettings, settings.updateTargetSiteSettings(), clientContext);
    this.updateTargetSiteOperationCallable =
        callableFactory.createOperationCallable(
            updateTargetSiteTransportSettings,
            settings.updateTargetSiteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteTargetSiteCallable =
        callableFactory.createUnaryCallable(
            deleteTargetSiteTransportSettings, settings.deleteTargetSiteSettings(), clientContext);
    this.deleteTargetSiteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTargetSiteTransportSettings,
            settings.deleteTargetSiteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listTargetSitesCallable =
        callableFactory.createUnaryCallable(
            listTargetSitesTransportSettings, settings.listTargetSitesSettings(), clientContext);
    this.listTargetSitesPagedCallable =
        callableFactory.createPagedCallable(
            listTargetSitesTransportSettings, settings.listTargetSitesSettings(), clientContext);
    this.enableAdvancedSiteSearchCallable =
        callableFactory.createUnaryCallable(
            enableAdvancedSiteSearchTransportSettings,
            settings.enableAdvancedSiteSearchSettings(),
            clientContext);
    this.enableAdvancedSiteSearchOperationCallable =
        callableFactory.createOperationCallable(
            enableAdvancedSiteSearchTransportSettings,
            settings.enableAdvancedSiteSearchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.disableAdvancedSiteSearchCallable =
        callableFactory.createUnaryCallable(
            disableAdvancedSiteSearchTransportSettings,
            settings.disableAdvancedSiteSearchSettings(),
            clientContext);
    this.disableAdvancedSiteSearchOperationCallable =
        callableFactory.createOperationCallable(
            disableAdvancedSiteSearchTransportSettings,
            settings.disableAdvancedSiteSearchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.recrawlUrisCallable =
        callableFactory.createUnaryCallable(
            recrawlUrisTransportSettings, settings.recrawlUrisSettings(), clientContext);
    this.recrawlUrisOperationCallable =
        callableFactory.createOperationCallable(
            recrawlUrisTransportSettings,
            settings.recrawlUrisOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchVerifyTargetSitesCallable =
        callableFactory.createUnaryCallable(
            batchVerifyTargetSitesTransportSettings,
            settings.batchVerifyTargetSitesSettings(),
            clientContext);
    this.batchVerifyTargetSitesOperationCallable =
        callableFactory.createOperationCallable(
            batchVerifyTargetSitesTransportSettings,
            settings.batchVerifyTargetSitesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.fetchDomainVerificationStatusCallable =
        callableFactory.createUnaryCallable(
            fetchDomainVerificationStatusTransportSettings,
            settings.fetchDomainVerificationStatusSettings(),
            clientContext);
    this.fetchDomainVerificationStatusPagedCallable =
        callableFactory.createPagedCallable(
            fetchDomainVerificationStatusTransportSettings,
            settings.fetchDomainVerificationStatusSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getSiteSearchEngineMethodDescriptor);
    methodDescriptors.add(createTargetSiteMethodDescriptor);
    methodDescriptors.add(batchCreateTargetSitesMethodDescriptor);
    methodDescriptors.add(getTargetSiteMethodDescriptor);
    methodDescriptors.add(updateTargetSiteMethodDescriptor);
    methodDescriptors.add(deleteTargetSiteMethodDescriptor);
    methodDescriptors.add(listTargetSitesMethodDescriptor);
    methodDescriptors.add(enableAdvancedSiteSearchMethodDescriptor);
    methodDescriptors.add(disableAdvancedSiteSearchMethodDescriptor);
    methodDescriptors.add(recrawlUrisMethodDescriptor);
    methodDescriptors.add(batchVerifyTargetSitesMethodDescriptor);
    methodDescriptors.add(fetchDomainVerificationStatusMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetSiteSearchEngineRequest, SiteSearchEngine> getSiteSearchEngineCallable() {
    return getSiteSearchEngineCallable;
  }

  @Override
  public UnaryCallable<CreateTargetSiteRequest, Operation> createTargetSiteCallable() {
    return createTargetSiteCallable;
  }

  @Override
  public OperationCallable<CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
      createTargetSiteOperationCallable() {
    return createTargetSiteOperationCallable;
  }

  @Override
  public UnaryCallable<BatchCreateTargetSitesRequest, Operation> batchCreateTargetSitesCallable() {
    return batchCreateTargetSitesCallable;
  }

  @Override
  public OperationCallable<
          BatchCreateTargetSitesRequest,
          BatchCreateTargetSitesResponse,
          BatchCreateTargetSiteMetadata>
      batchCreateTargetSitesOperationCallable() {
    return batchCreateTargetSitesOperationCallable;
  }

  @Override
  public UnaryCallable<GetTargetSiteRequest, TargetSite> getTargetSiteCallable() {
    return getTargetSiteCallable;
  }

  @Override
  public UnaryCallable<UpdateTargetSiteRequest, Operation> updateTargetSiteCallable() {
    return updateTargetSiteCallable;
  }

  @Override
  public OperationCallable<UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
      updateTargetSiteOperationCallable() {
    return updateTargetSiteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTargetSiteRequest, Operation> deleteTargetSiteCallable() {
    return deleteTargetSiteCallable;
  }

  @Override
  public OperationCallable<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
      deleteTargetSiteOperationCallable() {
    return deleteTargetSiteOperationCallable;
  }

  @Override
  public UnaryCallable<ListTargetSitesRequest, ListTargetSitesResponse> listTargetSitesCallable() {
    return listTargetSitesCallable;
  }

  @Override
  public UnaryCallable<ListTargetSitesRequest, ListTargetSitesPagedResponse>
      listTargetSitesPagedCallable() {
    return listTargetSitesPagedCallable;
  }

  @Override
  public UnaryCallable<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchCallable() {
    return enableAdvancedSiteSearchCallable;
  }

  @Override
  public OperationCallable<
          EnableAdvancedSiteSearchRequest,
          EnableAdvancedSiteSearchResponse,
          EnableAdvancedSiteSearchMetadata>
      enableAdvancedSiteSearchOperationCallable() {
    return enableAdvancedSiteSearchOperationCallable;
  }

  @Override
  public UnaryCallable<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchCallable() {
    return disableAdvancedSiteSearchCallable;
  }

  @Override
  public OperationCallable<
          DisableAdvancedSiteSearchRequest,
          DisableAdvancedSiteSearchResponse,
          DisableAdvancedSiteSearchMetadata>
      disableAdvancedSiteSearchOperationCallable() {
    return disableAdvancedSiteSearchOperationCallable;
  }

  @Override
  public UnaryCallable<RecrawlUrisRequest, Operation> recrawlUrisCallable() {
    return recrawlUrisCallable;
  }

  @Override
  public OperationCallable<RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
      recrawlUrisOperationCallable() {
    return recrawlUrisOperationCallable;
  }

  @Override
  public UnaryCallable<BatchVerifyTargetSitesRequest, Operation> batchVerifyTargetSitesCallable() {
    return batchVerifyTargetSitesCallable;
  }

  @Override
  public OperationCallable<
          BatchVerifyTargetSitesRequest,
          BatchVerifyTargetSitesResponse,
          BatchVerifyTargetSitesMetadata>
      batchVerifyTargetSitesOperationCallable() {
    return batchVerifyTargetSitesOperationCallable;
  }

  @Override
  public UnaryCallable<FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
      fetchDomainVerificationStatusCallable() {
    return fetchDomainVerificationStatusCallable;
  }

  @Override
  public UnaryCallable<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusPagedResponse>
      fetchDomainVerificationStatusPagedCallable() {
    return fetchDomainVerificationStatusPagedCallable;
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
