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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossariesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryCategoriesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryTermsPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListLocationsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.CreateGlossaryRequest;
import com.google.cloud.dataplex.v1.CreateGlossaryTermRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest;
import com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.GetGlossaryRequest;
import com.google.cloud.dataplex.v1.GetGlossaryTermRequest;
import com.google.cloud.dataplex.v1.Glossary;
import com.google.cloud.dataplex.v1.GlossaryCategory;
import com.google.cloud.dataplex.v1.GlossaryTerm;
import com.google.cloud.dataplex.v1.ListGlossariesRequest;
import com.google.cloud.dataplex.v1.ListGlossariesResponse;
import com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest;
import com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse;
import com.google.cloud.dataplex.v1.ListGlossaryTermsRequest;
import com.google.cloud.dataplex.v1.ListGlossaryTermsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.UpdateGlossaryRequest;
import com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the BusinessGlossaryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonBusinessGlossaryServiceStub extends BusinessGlossaryServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Glossary.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateGlossaryRequest, Operation>
      createGlossaryMethodDescriptor =
          ApiMethodDescriptor.<CreateGlossaryRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/CreateGlossary")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGlossaryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/glossaries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGlossaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGlossaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "glossaryId", request.getGlossaryId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("glossary", request.getGlossary(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateGlossaryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateGlossaryRequest, Operation>
      updateGlossaryMethodDescriptor =
          ApiMethodDescriptor.<UpdateGlossaryRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/UpdateGlossary")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGlossaryRequest>newBuilder()
                      .setPath(
                          "/v1/{glossary.name=projects/*/locations/*/glossaries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGlossaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "glossary.name", request.getGlossary().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGlossaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("glossary", request.getGlossary(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateGlossaryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteGlossaryRequest, Operation>
      deleteGlossaryMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlossaryRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/DeleteGlossary")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlossaryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/glossaries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlossaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlossaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeleteGlossaryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetGlossaryRequest, Glossary>
      getGlossaryMethodDescriptor =
          ApiMethodDescriptor.<GetGlossaryRequest, Glossary>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/GetGlossary")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlossaryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/glossaries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlossaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlossaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Glossary>newBuilder()
                      .setDefaultInstance(Glossary.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListGlossariesRequest, ListGlossariesResponse>
      listGlossariesMethodDescriptor =
          ApiMethodDescriptor.<ListGlossariesRequest, ListGlossariesResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/ListGlossaries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlossariesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/glossaries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlossariesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlossariesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGlossariesResponse>newBuilder()
                      .setDefaultInstance(ListGlossariesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategoryMethodDescriptor =
          ApiMethodDescriptor.<CreateGlossaryCategoryRequest, GlossaryCategory>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/CreateGlossaryCategory")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGlossaryCategoryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/glossaries/*}/categories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGlossaryCategoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGlossaryCategoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "categoryId", request.getCategoryId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("category", request.getCategory(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlossaryCategory>newBuilder()
                      .setDefaultInstance(GlossaryCategory.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategoryMethodDescriptor =
          ApiMethodDescriptor.<UpdateGlossaryCategoryRequest, GlossaryCategory>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/UpdateGlossaryCategory")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGlossaryCategoryRequest>newBuilder()
                      .setPath(
                          "/v1/{category.name=projects/*/locations/*/glossaries/*/categories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGlossaryCategoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "category.name", request.getCategory().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGlossaryCategoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("category", request.getCategory(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlossaryCategory>newBuilder()
                      .setDefaultInstance(GlossaryCategory.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteGlossaryCategoryRequest, Empty>
      deleteGlossaryCategoryMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlossaryCategoryRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/DeleteGlossaryCategory")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlossaryCategoryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/glossaries/*/categories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlossaryCategoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlossaryCategoryRequest> serializer =
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

  private static final ApiMethodDescriptor<GetGlossaryCategoryRequest, GlossaryCategory>
      getGlossaryCategoryMethodDescriptor =
          ApiMethodDescriptor.<GetGlossaryCategoryRequest, GlossaryCategory>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/GetGlossaryCategory")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlossaryCategoryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/glossaries/*/categories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlossaryCategoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlossaryCategoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlossaryCategory>newBuilder()
                      .setDefaultInstance(GlossaryCategory.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
      listGlossaryCategoriesMethodDescriptor =
          ApiMethodDescriptor
              .<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/ListGlossaryCategories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlossaryCategoriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/glossaries/*}/categories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlossaryCategoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlossaryCategoriesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGlossaryCategoriesResponse>newBuilder()
                      .setDefaultInstance(ListGlossaryCategoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGlossaryTermRequest, GlossaryTerm>
      createGlossaryTermMethodDescriptor =
          ApiMethodDescriptor.<CreateGlossaryTermRequest, GlossaryTerm>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/CreateGlossaryTerm")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGlossaryTermRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/glossaries/*}/terms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGlossaryTermRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGlossaryTermRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "termId", request.getTermId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("term", request.getTerm(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlossaryTerm>newBuilder()
                      .setDefaultInstance(GlossaryTerm.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateGlossaryTermRequest, GlossaryTerm>
      updateGlossaryTermMethodDescriptor =
          ApiMethodDescriptor.<UpdateGlossaryTermRequest, GlossaryTerm>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/UpdateGlossaryTerm")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGlossaryTermRequest>newBuilder()
                      .setPath(
                          "/v1/{term.name=projects/*/locations/*/glossaries/*/terms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGlossaryTermRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "term.name", request.getTerm().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGlossaryTermRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("term", request.getTerm(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlossaryTerm>newBuilder()
                      .setDefaultInstance(GlossaryTerm.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteGlossaryTermRequest, Empty>
      deleteGlossaryTermMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlossaryTermRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/DeleteGlossaryTerm")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlossaryTermRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/glossaries/*/terms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlossaryTermRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlossaryTermRequest> serializer =
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

  private static final ApiMethodDescriptor<GetGlossaryTermRequest, GlossaryTerm>
      getGlossaryTermMethodDescriptor =
          ApiMethodDescriptor.<GetGlossaryTermRequest, GlossaryTerm>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/GetGlossaryTerm")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlossaryTermRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/glossaries/*/terms/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlossaryTermRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlossaryTermRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlossaryTerm>newBuilder()
                      .setDefaultInstance(GlossaryTerm.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListGlossaryTermsRequest, ListGlossaryTermsResponse>
      listGlossaryTermsMethodDescriptor =
          ApiMethodDescriptor.<ListGlossaryTermsRequest, ListGlossaryTermsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/ListGlossaryTerms")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlossaryTermsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/glossaries/*}/terms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlossaryTermsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlossaryTermsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListGlossaryTermsResponse>newBuilder()
                      .setDefaultInstance(ListGlossaryTermsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable;
  private final OperationCallable<CreateGlossaryRequest, Glossary, OperationMetadata>
      createGlossaryOperationCallable;
  private final UnaryCallable<UpdateGlossaryRequest, Operation> updateGlossaryCallable;
  private final OperationCallable<UpdateGlossaryRequest, Glossary, OperationMetadata>
      updateGlossaryOperationCallable;
  private final UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable;
  private final OperationCallable<DeleteGlossaryRequest, Empty, OperationMetadata>
      deleteGlossaryOperationCallable;
  private final UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable;
  private final UnaryCallable<ListGlossariesRequest, ListGlossariesResponse> listGlossariesCallable;
  private final UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable;
  private final UnaryCallable<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategoryCallable;
  private final UnaryCallable<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategoryCallable;
  private final UnaryCallable<DeleteGlossaryCategoryRequest, Empty> deleteGlossaryCategoryCallable;
  private final UnaryCallable<GetGlossaryCategoryRequest, GlossaryCategory>
      getGlossaryCategoryCallable;
  private final UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
      listGlossaryCategoriesCallable;
  private final UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesPagedResponse>
      listGlossaryCategoriesPagedCallable;
  private final UnaryCallable<CreateGlossaryTermRequest, GlossaryTerm> createGlossaryTermCallable;
  private final UnaryCallable<UpdateGlossaryTermRequest, GlossaryTerm> updateGlossaryTermCallable;
  private final UnaryCallable<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermCallable;
  private final UnaryCallable<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermCallable;
  private final UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsResponse>
      listGlossaryTermsCallable;
  private final UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsPagedResponse>
      listGlossaryTermsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBusinessGlossaryServiceStub create(
      BusinessGlossaryServiceStubSettings settings) throws IOException {
    return new HttpJsonBusinessGlossaryServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBusinessGlossaryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBusinessGlossaryServiceStub(
        BusinessGlossaryServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBusinessGlossaryServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBusinessGlossaryServiceStub(
        BusinessGlossaryServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBusinessGlossaryServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBusinessGlossaryServiceStub(
      BusinessGlossaryServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonBusinessGlossaryServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBusinessGlossaryServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBusinessGlossaryServiceStub(
      BusinessGlossaryServiceStubSettings settings,
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
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=organizations/*/locations/*/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setDelete("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<CreateGlossaryRequest, Operation> createGlossaryTransportSettings =
        HttpJsonCallSettings.<CreateGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(createGlossaryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateGlossaryRequest, Operation> updateGlossaryTransportSettings =
        HttpJsonCallSettings.<UpdateGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGlossaryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("glossary.name", String.valueOf(request.getGlossary().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteGlossaryRequest, Operation> deleteGlossaryTransportSettings =
        HttpJsonCallSettings.<DeleteGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGlossaryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetGlossaryRequest, Glossary> getGlossaryTransportSettings =
        HttpJsonCallSettings.<GetGlossaryRequest, Glossary>newBuilder()
            .setMethodDescriptor(getGlossaryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListGlossariesRequest, ListGlossariesResponse>
        listGlossariesTransportSettings =
            HttpJsonCallSettings.<ListGlossariesRequest, ListGlossariesResponse>newBuilder()
                .setMethodDescriptor(listGlossariesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateGlossaryCategoryRequest, GlossaryCategory>
        createGlossaryCategoryTransportSettings =
            HttpJsonCallSettings.<CreateGlossaryCategoryRequest, GlossaryCategory>newBuilder()
                .setMethodDescriptor(createGlossaryCategoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateGlossaryCategoryRequest, GlossaryCategory>
        updateGlossaryCategoryTransportSettings =
            HttpJsonCallSettings.<UpdateGlossaryCategoryRequest, GlossaryCategory>newBuilder()
                .setMethodDescriptor(updateGlossaryCategoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("category.name", String.valueOf(request.getCategory().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteGlossaryCategoryRequest, Empty>
        deleteGlossaryCategoryTransportSettings =
            HttpJsonCallSettings.<DeleteGlossaryCategoryRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteGlossaryCategoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetGlossaryCategoryRequest, GlossaryCategory>
        getGlossaryCategoryTransportSettings =
            HttpJsonCallSettings.<GetGlossaryCategoryRequest, GlossaryCategory>newBuilder()
                .setMethodDescriptor(getGlossaryCategoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
        listGlossaryCategoriesTransportSettings =
            HttpJsonCallSettings
                .<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>newBuilder()
                .setMethodDescriptor(listGlossaryCategoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateGlossaryTermRequest, GlossaryTerm>
        createGlossaryTermTransportSettings =
            HttpJsonCallSettings.<CreateGlossaryTermRequest, GlossaryTerm>newBuilder()
                .setMethodDescriptor(createGlossaryTermMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateGlossaryTermRequest, GlossaryTerm>
        updateGlossaryTermTransportSettings =
            HttpJsonCallSettings.<UpdateGlossaryTermRequest, GlossaryTerm>newBuilder()
                .setMethodDescriptor(updateGlossaryTermMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("term.name", String.valueOf(request.getTerm().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermTransportSettings =
        HttpJsonCallSettings.<DeleteGlossaryTermRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGlossaryTermMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermTransportSettings =
        HttpJsonCallSettings.<GetGlossaryTermRequest, GlossaryTerm>newBuilder()
            .setMethodDescriptor(getGlossaryTermMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListGlossaryTermsRequest, ListGlossaryTermsResponse>
        listGlossaryTermsTransportSettings =
            HttpJsonCallSettings.<ListGlossaryTermsRequest, ListGlossaryTermsResponse>newBuilder()
                .setMethodDescriptor(listGlossaryTermsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createGlossaryCallable =
        callableFactory.createUnaryCallable(
            createGlossaryTransportSettings, settings.createGlossarySettings(), clientContext);
    this.createGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            createGlossaryTransportSettings,
            settings.createGlossaryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateGlossaryCallable =
        callableFactory.createUnaryCallable(
            updateGlossaryTransportSettings, settings.updateGlossarySettings(), clientContext);
    this.updateGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            updateGlossaryTransportSettings,
            settings.updateGlossaryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteGlossaryCallable =
        callableFactory.createUnaryCallable(
            deleteGlossaryTransportSettings, settings.deleteGlossarySettings(), clientContext);
    this.deleteGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            deleteGlossaryTransportSettings,
            settings.deleteGlossaryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getGlossaryCallable =
        callableFactory.createUnaryCallable(
            getGlossaryTransportSettings, settings.getGlossarySettings(), clientContext);
    this.listGlossariesCallable =
        callableFactory.createUnaryCallable(
            listGlossariesTransportSettings, settings.listGlossariesSettings(), clientContext);
    this.listGlossariesPagedCallable =
        callableFactory.createPagedCallable(
            listGlossariesTransportSettings, settings.listGlossariesSettings(), clientContext);
    this.createGlossaryCategoryCallable =
        callableFactory.createUnaryCallable(
            createGlossaryCategoryTransportSettings,
            settings.createGlossaryCategorySettings(),
            clientContext);
    this.updateGlossaryCategoryCallable =
        callableFactory.createUnaryCallable(
            updateGlossaryCategoryTransportSettings,
            settings.updateGlossaryCategorySettings(),
            clientContext);
    this.deleteGlossaryCategoryCallable =
        callableFactory.createUnaryCallable(
            deleteGlossaryCategoryTransportSettings,
            settings.deleteGlossaryCategorySettings(),
            clientContext);
    this.getGlossaryCategoryCallable =
        callableFactory.createUnaryCallable(
            getGlossaryCategoryTransportSettings,
            settings.getGlossaryCategorySettings(),
            clientContext);
    this.listGlossaryCategoriesCallable =
        callableFactory.createUnaryCallable(
            listGlossaryCategoriesTransportSettings,
            settings.listGlossaryCategoriesSettings(),
            clientContext);
    this.listGlossaryCategoriesPagedCallable =
        callableFactory.createPagedCallable(
            listGlossaryCategoriesTransportSettings,
            settings.listGlossaryCategoriesSettings(),
            clientContext);
    this.createGlossaryTermCallable =
        callableFactory.createUnaryCallable(
            createGlossaryTermTransportSettings,
            settings.createGlossaryTermSettings(),
            clientContext);
    this.updateGlossaryTermCallable =
        callableFactory.createUnaryCallable(
            updateGlossaryTermTransportSettings,
            settings.updateGlossaryTermSettings(),
            clientContext);
    this.deleteGlossaryTermCallable =
        callableFactory.createUnaryCallable(
            deleteGlossaryTermTransportSettings,
            settings.deleteGlossaryTermSettings(),
            clientContext);
    this.getGlossaryTermCallable =
        callableFactory.createUnaryCallable(
            getGlossaryTermTransportSettings, settings.getGlossaryTermSettings(), clientContext);
    this.listGlossaryTermsCallable =
        callableFactory.createUnaryCallable(
            listGlossaryTermsTransportSettings,
            settings.listGlossaryTermsSettings(),
            clientContext);
    this.listGlossaryTermsPagedCallable =
        callableFactory.createPagedCallable(
            listGlossaryTermsTransportSettings,
            settings.listGlossaryTermsSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createGlossaryMethodDescriptor);
    methodDescriptors.add(updateGlossaryMethodDescriptor);
    methodDescriptors.add(deleteGlossaryMethodDescriptor);
    methodDescriptors.add(getGlossaryMethodDescriptor);
    methodDescriptors.add(listGlossariesMethodDescriptor);
    methodDescriptors.add(createGlossaryCategoryMethodDescriptor);
    methodDescriptors.add(updateGlossaryCategoryMethodDescriptor);
    methodDescriptors.add(deleteGlossaryCategoryMethodDescriptor);
    methodDescriptors.add(getGlossaryCategoryMethodDescriptor);
    methodDescriptors.add(listGlossaryCategoriesMethodDescriptor);
    methodDescriptors.add(createGlossaryTermMethodDescriptor);
    methodDescriptors.add(updateGlossaryTermMethodDescriptor);
    methodDescriptors.add(deleteGlossaryTermMethodDescriptor);
    methodDescriptors.add(getGlossaryTermMethodDescriptor);
    methodDescriptors.add(listGlossaryTermsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable() {
    return createGlossaryCallable;
  }

  @Override
  public OperationCallable<CreateGlossaryRequest, Glossary, OperationMetadata>
      createGlossaryOperationCallable() {
    return createGlossaryOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGlossaryRequest, Operation> updateGlossaryCallable() {
    return updateGlossaryCallable;
  }

  @Override
  public OperationCallable<UpdateGlossaryRequest, Glossary, OperationMetadata>
      updateGlossaryOperationCallable() {
    return updateGlossaryOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable() {
    return deleteGlossaryCallable;
  }

  @Override
  public OperationCallable<DeleteGlossaryRequest, Empty, OperationMetadata>
      deleteGlossaryOperationCallable() {
    return deleteGlossaryOperationCallable;
  }

  @Override
  public UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable() {
    return getGlossaryCallable;
  }

  @Override
  public UnaryCallable<ListGlossariesRequest, ListGlossariesResponse> listGlossariesCallable() {
    return listGlossariesCallable;
  }

  @Override
  public UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable() {
    return listGlossariesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategoryCallable() {
    return createGlossaryCategoryCallable;
  }

  @Override
  public UnaryCallable<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategoryCallable() {
    return updateGlossaryCategoryCallable;
  }

  @Override
  public UnaryCallable<DeleteGlossaryCategoryRequest, Empty> deleteGlossaryCategoryCallable() {
    return deleteGlossaryCategoryCallable;
  }

  @Override
  public UnaryCallable<GetGlossaryCategoryRequest, GlossaryCategory> getGlossaryCategoryCallable() {
    return getGlossaryCategoryCallable;
  }

  @Override
  public UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
      listGlossaryCategoriesCallable() {
    return listGlossaryCategoriesCallable;
  }

  @Override
  public UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesPagedResponse>
      listGlossaryCategoriesPagedCallable() {
    return listGlossaryCategoriesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateGlossaryTermRequest, GlossaryTerm> createGlossaryTermCallable() {
    return createGlossaryTermCallable;
  }

  @Override
  public UnaryCallable<UpdateGlossaryTermRequest, GlossaryTerm> updateGlossaryTermCallable() {
    return updateGlossaryTermCallable;
  }

  @Override
  public UnaryCallable<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermCallable() {
    return deleteGlossaryTermCallable;
  }

  @Override
  public UnaryCallable<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermCallable() {
    return getGlossaryTermCallable;
  }

  @Override
  public UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsResponse>
      listGlossaryTermsCallable() {
    return listGlossaryTermsCallable;
  }

  @Override
  public UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsPagedResponse>
      listGlossaryTermsPagedCallable() {
    return listGlossaryTermsPagedCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
