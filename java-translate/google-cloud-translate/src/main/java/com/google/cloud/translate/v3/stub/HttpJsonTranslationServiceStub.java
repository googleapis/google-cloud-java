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

package com.google.cloud.translate.v3.stub;

import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtDatasetsPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtFilesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtSentencesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListGlossariesPagedResponse;

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
import com.google.cloud.translate.v3.AdaptiveMtDataset;
import com.google.cloud.translate.v3.AdaptiveMtFile;
import com.google.cloud.translate.v3.AdaptiveMtTranslateRequest;
import com.google.cloud.translate.v3.AdaptiveMtTranslateResponse;
import com.google.cloud.translate.v3.BatchTranslateDocumentMetadata;
import com.google.cloud.translate.v3.BatchTranslateDocumentRequest;
import com.google.cloud.translate.v3.BatchTranslateDocumentResponse;
import com.google.cloud.translate.v3.BatchTranslateMetadata;
import com.google.cloud.translate.v3.BatchTranslateResponse;
import com.google.cloud.translate.v3.BatchTranslateTextRequest;
import com.google.cloud.translate.v3.CreateAdaptiveMtDatasetRequest;
import com.google.cloud.translate.v3.CreateGlossaryMetadata;
import com.google.cloud.translate.v3.CreateGlossaryRequest;
import com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest;
import com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest;
import com.google.cloud.translate.v3.DeleteGlossaryMetadata;
import com.google.cloud.translate.v3.DeleteGlossaryRequest;
import com.google.cloud.translate.v3.DeleteGlossaryResponse;
import com.google.cloud.translate.v3.DetectLanguageRequest;
import com.google.cloud.translate.v3.DetectLanguageResponse;
import com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest;
import com.google.cloud.translate.v3.GetAdaptiveMtFileRequest;
import com.google.cloud.translate.v3.GetGlossaryRequest;
import com.google.cloud.translate.v3.GetSupportedLanguagesRequest;
import com.google.cloud.translate.v3.Glossary;
import com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest;
import com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse;
import com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest;
import com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse;
import com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest;
import com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse;
import com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest;
import com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse;
import com.google.cloud.translate.v3.ListGlossariesRequest;
import com.google.cloud.translate.v3.ListGlossariesResponse;
import com.google.cloud.translate.v3.SupportedLanguages;
import com.google.cloud.translate.v3.TranslateDocumentRequest;
import com.google.cloud.translate.v3.TranslateDocumentResponse;
import com.google.cloud.translate.v3.TranslateTextRequest;
import com.google.cloud.translate.v3.TranslateTextResponse;
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
 * REST stub implementation for the TranslationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonTranslationServiceStub extends TranslationServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(DeleteGlossaryMetadata.getDescriptor())
          .add(BatchTranslateResponse.getDescriptor())
          .add(BatchTranslateMetadata.getDescriptor())
          .add(Glossary.getDescriptor())
          .add(CreateGlossaryMetadata.getDescriptor())
          .add(BatchTranslateDocumentResponse.getDescriptor())
          .add(DeleteGlossaryResponse.getDescriptor())
          .add(BatchTranslateDocumentMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<TranslateTextRequest, TranslateTextResponse>
      translateTextMethodDescriptor =
          ApiMethodDescriptor.<TranslateTextRequest, TranslateTextResponse>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/TranslateText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TranslateTextRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}:translateText",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TranslateTextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v3/{parent=projects/*}:translateText")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TranslateTextRequest> serializer =
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
                  ProtoMessageResponseParser.<TranslateTextResponse>newBuilder()
                      .setDefaultInstance(TranslateTextResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DetectLanguageRequest, DetectLanguageResponse>
      detectLanguageMethodDescriptor =
          ApiMethodDescriptor.<DetectLanguageRequest, DetectLanguageResponse>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/DetectLanguage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DetectLanguageRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}:detectLanguage",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DetectLanguageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v3/{parent=projects/*}:detectLanguage")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DetectLanguageRequest> serializer =
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
                  ProtoMessageResponseParser.<DetectLanguageResponse>newBuilder()
                      .setDefaultInstance(DetectLanguageResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesMethodDescriptor =
          ApiMethodDescriptor.<GetSupportedLanguagesRequest, SupportedLanguages>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/GetSupportedLanguages")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSupportedLanguagesRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/supportedLanguages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSupportedLanguagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v3/{parent=projects/*}/supportedLanguages")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSupportedLanguagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "displayLanguageCode", request.getDisplayLanguageCode());
                            serializer.putQueryParam(fields, "model", request.getModel());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SupportedLanguages>newBuilder()
                      .setDefaultInstance(SupportedLanguages.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TranslateDocumentRequest, TranslateDocumentResponse>
      translateDocumentMethodDescriptor =
          ApiMethodDescriptor.<TranslateDocumentRequest, TranslateDocumentResponse>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/TranslateDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TranslateDocumentRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}:translateDocument",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TranslateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TranslateDocumentRequest> serializer =
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
                  ProtoMessageResponseParser.<TranslateDocumentResponse>newBuilder()
                      .setDefaultInstance(TranslateDocumentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchTranslateTextRequest, Operation>
      batchTranslateTextMethodDescriptor =
          ApiMethodDescriptor.<BatchTranslateTextRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/BatchTranslateText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchTranslateTextRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}:batchTranslateText",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchTranslateTextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchTranslateTextRequest> serializer =
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
                  (BatchTranslateTextRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchTranslateDocumentRequest, Operation>
      batchTranslateDocumentMethodDescriptor =
          ApiMethodDescriptor.<BatchTranslateDocumentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/BatchTranslateDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchTranslateDocumentRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}:batchTranslateDocument",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchTranslateDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchTranslateDocumentRequest> serializer =
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
                  (BatchTranslateDocumentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateGlossaryRequest, Operation>
      createGlossaryMethodDescriptor =
          ApiMethodDescriptor.<CreateGlossaryRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/CreateGlossary")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGlossaryRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/glossaries",
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

  private static final ApiMethodDescriptor<ListGlossariesRequest, ListGlossariesResponse>
      listGlossariesMethodDescriptor =
          ApiMethodDescriptor.<ListGlossariesRequest, ListGlossariesResponse>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/ListGlossaries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlossariesRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/glossaries",
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

  private static final ApiMethodDescriptor<GetGlossaryRequest, Glossary>
      getGlossaryMethodDescriptor =
          ApiMethodDescriptor.<GetGlossaryRequest, Glossary>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/GetGlossary")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlossaryRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/glossaries/*}",
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

  private static final ApiMethodDescriptor<DeleteGlossaryRequest, Operation>
      deleteGlossaryMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlossaryRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/DeleteGlossary")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlossaryRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/glossaries/*}",
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

  private static final ApiMethodDescriptor<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      createAdaptiveMtDatasetMethodDescriptor =
          ApiMethodDescriptor.<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/CreateAdaptiveMtDataset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAdaptiveMtDatasetRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/adaptiveMtDatasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdaptiveMtDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdaptiveMtDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "adaptiveMtDataset", request.getAdaptiveMtDataset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdaptiveMtDataset>newBuilder()
                      .setDefaultInstance(AdaptiveMtDataset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAdaptiveMtDatasetRequest, Empty>
      deleteAdaptiveMtDatasetMethodDescriptor =
          ApiMethodDescriptor.<DeleteAdaptiveMtDatasetRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/DeleteAdaptiveMtDataset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAdaptiveMtDatasetRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/adaptiveMtDatasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAdaptiveMtDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAdaptiveMtDatasetRequest> serializer =
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

  private static final ApiMethodDescriptor<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      getAdaptiveMtDatasetMethodDescriptor =
          ApiMethodDescriptor.<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/GetAdaptiveMtDataset")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAdaptiveMtDatasetRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/adaptiveMtDatasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAdaptiveMtDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAdaptiveMtDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdaptiveMtDataset>newBuilder()
                      .setDefaultInstance(AdaptiveMtDataset.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>
      listAdaptiveMtDatasetsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/ListAdaptiveMtDatasets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdaptiveMtDatasetsRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/adaptiveMtDatasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdaptiveMtDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdaptiveMtDatasetsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAdaptiveMtDatasetsResponse>newBuilder()
                      .setDefaultInstance(ListAdaptiveMtDatasetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
      adaptiveMtTranslateMethodDescriptor =
          ApiMethodDescriptor.<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/AdaptiveMtTranslate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AdaptiveMtTranslateRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}:adaptiveMtTranslate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AdaptiveMtTranslateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AdaptiveMtTranslateRequest> serializer =
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
                  ProtoMessageResponseParser.<AdaptiveMtTranslateResponse>newBuilder()
                      .setDefaultInstance(AdaptiveMtTranslateResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAdaptiveMtFileRequest, AdaptiveMtFile>
      getAdaptiveMtFileMethodDescriptor =
          ApiMethodDescriptor.<GetAdaptiveMtFileRequest, AdaptiveMtFile>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/GetAdaptiveMtFile")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAdaptiveMtFileRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/adaptiveMtDatasets/*/adaptiveMtFiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAdaptiveMtFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAdaptiveMtFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdaptiveMtFile>newBuilder()
                      .setDefaultInstance(AdaptiveMtFile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAdaptiveMtFileRequest, Empty>
      deleteAdaptiveMtFileMethodDescriptor =
          ApiMethodDescriptor.<DeleteAdaptiveMtFileRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/DeleteAdaptiveMtFile")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAdaptiveMtFileRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/adaptiveMtDatasets/*/adaptiveMtFiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAdaptiveMtFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAdaptiveMtFileRequest> serializer =
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
          ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
      importAdaptiveMtFileMethodDescriptor =
          ApiMethodDescriptor
              .<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/ImportAdaptiveMtFile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportAdaptiveMtFileRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/adaptiveMtDatasets/*}:importAdaptiveMtFile",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportAdaptiveMtFileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportAdaptiveMtFileRequest> serializer =
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
                  ProtoMessageResponseParser.<ImportAdaptiveMtFileResponse>newBuilder()
                      .setDefaultInstance(ImportAdaptiveMtFileResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>
      listAdaptiveMtFilesMethodDescriptor =
          ApiMethodDescriptor.<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/ListAdaptiveMtFiles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdaptiveMtFilesRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/adaptiveMtDatasets/*}/adaptiveMtFiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdaptiveMtFilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdaptiveMtFilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAdaptiveMtFilesResponse>newBuilder()
                      .setDefaultInstance(ListAdaptiveMtFilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>
      listAdaptiveMtSentencesMethodDescriptor =
          ApiMethodDescriptor
              .<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/ListAdaptiveMtSentences")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdaptiveMtSentencesRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/adaptiveMtDatasets/*/adaptiveMtFiles/*}/adaptiveMtSentences",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdaptiveMtSentencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v3/{parent=projects/*/locations/*/adaptiveMtDatasets/*}/adaptiveMtSentences")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdaptiveMtSentencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAdaptiveMtSentencesResponse>newBuilder()
                      .setDefaultInstance(ListAdaptiveMtSentencesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<TranslateTextRequest, TranslateTextResponse> translateTextCallable;
  private final UnaryCallable<DetectLanguageRequest, DetectLanguageResponse> detectLanguageCallable;
  private final UnaryCallable<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesCallable;
  private final UnaryCallable<TranslateDocumentRequest, TranslateDocumentResponse>
      translateDocumentCallable;
  private final UnaryCallable<BatchTranslateTextRequest, Operation> batchTranslateTextCallable;
  private final OperationCallable<
          BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextOperationCallable;
  private final UnaryCallable<BatchTranslateDocumentRequest, Operation>
      batchTranslateDocumentCallable;
  private final OperationCallable<
          BatchTranslateDocumentRequest,
          BatchTranslateDocumentResponse,
          BatchTranslateDocumentMetadata>
      batchTranslateDocumentOperationCallable;
  private final UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable;
  private final OperationCallable<CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
      createGlossaryOperationCallable;
  private final UnaryCallable<ListGlossariesRequest, ListGlossariesResponse> listGlossariesCallable;
  private final UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable;
  private final UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable;
  private final UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable;
  private final OperationCallable<
          DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
      deleteGlossaryOperationCallable;
  private final UnaryCallable<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      createAdaptiveMtDatasetCallable;
  private final UnaryCallable<DeleteAdaptiveMtDatasetRequest, Empty>
      deleteAdaptiveMtDatasetCallable;
  private final UnaryCallable<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      getAdaptiveMtDatasetCallable;
  private final UnaryCallable<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>
      listAdaptiveMtDatasetsCallable;
  private final UnaryCallable<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsPagedResponse>
      listAdaptiveMtDatasetsPagedCallable;
  private final UnaryCallable<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
      adaptiveMtTranslateCallable;
  private final UnaryCallable<GetAdaptiveMtFileRequest, AdaptiveMtFile> getAdaptiveMtFileCallable;
  private final UnaryCallable<DeleteAdaptiveMtFileRequest, Empty> deleteAdaptiveMtFileCallable;
  private final UnaryCallable<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
      importAdaptiveMtFileCallable;
  private final UnaryCallable<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>
      listAdaptiveMtFilesCallable;
  private final UnaryCallable<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesPagedResponse>
      listAdaptiveMtFilesPagedCallable;
  private final UnaryCallable<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>
      listAdaptiveMtSentencesCallable;
  private final UnaryCallable<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesPagedResponse>
      listAdaptiveMtSentencesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTranslationServiceStub create(TranslationServiceStubSettings settings)
      throws IOException {
    return new HttpJsonTranslationServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTranslationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTranslationServiceStub(
        TranslationServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTranslationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTranslationServiceStub(
        TranslationServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTranslationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTranslationServiceStub(
      TranslationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTranslationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTranslationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTranslationServiceStub(
      TranslationServiceStubSettings settings,
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
                        .setPost("/v3/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v3/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v3/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v3/{name=projects/*/locations/*}/operations")
                        .build())
                .put(
                    "google.longrunning.Operations.WaitOperation",
                    HttpRule.newBuilder()
                        .setPost("/v3/{name=projects/*/locations/*/operations/*}:wait")
                        .build())
                .build());

    HttpJsonCallSettings<TranslateTextRequest, TranslateTextResponse>
        translateTextTransportSettings =
            HttpJsonCallSettings.<TranslateTextRequest, TranslateTextResponse>newBuilder()
                .setMethodDescriptor(translateTextMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DetectLanguageRequest, DetectLanguageResponse>
        detectLanguageTransportSettings =
            HttpJsonCallSettings.<DetectLanguageRequest, DetectLanguageResponse>newBuilder()
                .setMethodDescriptor(detectLanguageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSupportedLanguagesRequest, SupportedLanguages>
        getSupportedLanguagesTransportSettings =
            HttpJsonCallSettings.<GetSupportedLanguagesRequest, SupportedLanguages>newBuilder()
                .setMethodDescriptor(getSupportedLanguagesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<TranslateDocumentRequest, TranslateDocumentResponse>
        translateDocumentTransportSettings =
            HttpJsonCallSettings.<TranslateDocumentRequest, TranslateDocumentResponse>newBuilder()
                .setMethodDescriptor(translateDocumentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchTranslateTextRequest, Operation> batchTranslateTextTransportSettings =
        HttpJsonCallSettings.<BatchTranslateTextRequest, Operation>newBuilder()
            .setMethodDescriptor(batchTranslateTextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchTranslateDocumentRequest, Operation>
        batchTranslateDocumentTransportSettings =
            HttpJsonCallSettings.<BatchTranslateDocumentRequest, Operation>newBuilder()
                .setMethodDescriptor(batchTranslateDocumentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
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
    HttpJsonCallSettings<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
        createAdaptiveMtDatasetTransportSettings =
            HttpJsonCallSettings.<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>newBuilder()
                .setMethodDescriptor(createAdaptiveMtDatasetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteAdaptiveMtDatasetRequest, Empty>
        deleteAdaptiveMtDatasetTransportSettings =
            HttpJsonCallSettings.<DeleteAdaptiveMtDatasetRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAdaptiveMtDatasetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
        getAdaptiveMtDatasetTransportSettings =
            HttpJsonCallSettings.<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>newBuilder()
                .setMethodDescriptor(getAdaptiveMtDatasetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>
        listAdaptiveMtDatasetsTransportSettings =
            HttpJsonCallSettings
                .<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>newBuilder()
                .setMethodDescriptor(listAdaptiveMtDatasetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
        adaptiveMtTranslateTransportSettings =
            HttpJsonCallSettings
                .<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>newBuilder()
                .setMethodDescriptor(adaptiveMtTranslateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAdaptiveMtFileRequest, AdaptiveMtFile>
        getAdaptiveMtFileTransportSettings =
            HttpJsonCallSettings.<GetAdaptiveMtFileRequest, AdaptiveMtFile>newBuilder()
                .setMethodDescriptor(getAdaptiveMtFileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteAdaptiveMtFileRequest, Empty> deleteAdaptiveMtFileTransportSettings =
        HttpJsonCallSettings.<DeleteAdaptiveMtFileRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAdaptiveMtFileMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
        importAdaptiveMtFileTransportSettings =
            HttpJsonCallSettings
                .<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>newBuilder()
                .setMethodDescriptor(importAdaptiveMtFileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>
        listAdaptiveMtFilesTransportSettings =
            HttpJsonCallSettings
                .<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>newBuilder()
                .setMethodDescriptor(listAdaptiveMtFilesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>
        listAdaptiveMtSentencesTransportSettings =
            HttpJsonCallSettings
                .<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>newBuilder()
                .setMethodDescriptor(listAdaptiveMtSentencesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.translateTextCallable =
        callableFactory.createUnaryCallable(
            translateTextTransportSettings, settings.translateTextSettings(), clientContext);
    this.detectLanguageCallable =
        callableFactory.createUnaryCallable(
            detectLanguageTransportSettings, settings.detectLanguageSettings(), clientContext);
    this.getSupportedLanguagesCallable =
        callableFactory.createUnaryCallable(
            getSupportedLanguagesTransportSettings,
            settings.getSupportedLanguagesSettings(),
            clientContext);
    this.translateDocumentCallable =
        callableFactory.createUnaryCallable(
            translateDocumentTransportSettings,
            settings.translateDocumentSettings(),
            clientContext);
    this.batchTranslateTextCallable =
        callableFactory.createUnaryCallable(
            batchTranslateTextTransportSettings,
            settings.batchTranslateTextSettings(),
            clientContext);
    this.batchTranslateTextOperationCallable =
        callableFactory.createOperationCallable(
            batchTranslateTextTransportSettings,
            settings.batchTranslateTextOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchTranslateDocumentCallable =
        callableFactory.createUnaryCallable(
            batchTranslateDocumentTransportSettings,
            settings.batchTranslateDocumentSettings(),
            clientContext);
    this.batchTranslateDocumentOperationCallable =
        callableFactory.createOperationCallable(
            batchTranslateDocumentTransportSettings,
            settings.batchTranslateDocumentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createGlossaryCallable =
        callableFactory.createUnaryCallable(
            createGlossaryTransportSettings, settings.createGlossarySettings(), clientContext);
    this.createGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            createGlossaryTransportSettings,
            settings.createGlossaryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listGlossariesCallable =
        callableFactory.createUnaryCallable(
            listGlossariesTransportSettings, settings.listGlossariesSettings(), clientContext);
    this.listGlossariesPagedCallable =
        callableFactory.createPagedCallable(
            listGlossariesTransportSettings, settings.listGlossariesSettings(), clientContext);
    this.getGlossaryCallable =
        callableFactory.createUnaryCallable(
            getGlossaryTransportSettings, settings.getGlossarySettings(), clientContext);
    this.deleteGlossaryCallable =
        callableFactory.createUnaryCallable(
            deleteGlossaryTransportSettings, settings.deleteGlossarySettings(), clientContext);
    this.deleteGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            deleteGlossaryTransportSettings,
            settings.deleteGlossaryOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createAdaptiveMtDatasetCallable =
        callableFactory.createUnaryCallable(
            createAdaptiveMtDatasetTransportSettings,
            settings.createAdaptiveMtDatasetSettings(),
            clientContext);
    this.deleteAdaptiveMtDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteAdaptiveMtDatasetTransportSettings,
            settings.deleteAdaptiveMtDatasetSettings(),
            clientContext);
    this.getAdaptiveMtDatasetCallable =
        callableFactory.createUnaryCallable(
            getAdaptiveMtDatasetTransportSettings,
            settings.getAdaptiveMtDatasetSettings(),
            clientContext);
    this.listAdaptiveMtDatasetsCallable =
        callableFactory.createUnaryCallable(
            listAdaptiveMtDatasetsTransportSettings,
            settings.listAdaptiveMtDatasetsSettings(),
            clientContext);
    this.listAdaptiveMtDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listAdaptiveMtDatasetsTransportSettings,
            settings.listAdaptiveMtDatasetsSettings(),
            clientContext);
    this.adaptiveMtTranslateCallable =
        callableFactory.createUnaryCallable(
            adaptiveMtTranslateTransportSettings,
            settings.adaptiveMtTranslateSettings(),
            clientContext);
    this.getAdaptiveMtFileCallable =
        callableFactory.createUnaryCallable(
            getAdaptiveMtFileTransportSettings,
            settings.getAdaptiveMtFileSettings(),
            clientContext);
    this.deleteAdaptiveMtFileCallable =
        callableFactory.createUnaryCallable(
            deleteAdaptiveMtFileTransportSettings,
            settings.deleteAdaptiveMtFileSettings(),
            clientContext);
    this.importAdaptiveMtFileCallable =
        callableFactory.createUnaryCallable(
            importAdaptiveMtFileTransportSettings,
            settings.importAdaptiveMtFileSettings(),
            clientContext);
    this.listAdaptiveMtFilesCallable =
        callableFactory.createUnaryCallable(
            listAdaptiveMtFilesTransportSettings,
            settings.listAdaptiveMtFilesSettings(),
            clientContext);
    this.listAdaptiveMtFilesPagedCallable =
        callableFactory.createPagedCallable(
            listAdaptiveMtFilesTransportSettings,
            settings.listAdaptiveMtFilesSettings(),
            clientContext);
    this.listAdaptiveMtSentencesCallable =
        callableFactory.createUnaryCallable(
            listAdaptiveMtSentencesTransportSettings,
            settings.listAdaptiveMtSentencesSettings(),
            clientContext);
    this.listAdaptiveMtSentencesPagedCallable =
        callableFactory.createPagedCallable(
            listAdaptiveMtSentencesTransportSettings,
            settings.listAdaptiveMtSentencesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(translateTextMethodDescriptor);
    methodDescriptors.add(detectLanguageMethodDescriptor);
    methodDescriptors.add(getSupportedLanguagesMethodDescriptor);
    methodDescriptors.add(translateDocumentMethodDescriptor);
    methodDescriptors.add(batchTranslateTextMethodDescriptor);
    methodDescriptors.add(batchTranslateDocumentMethodDescriptor);
    methodDescriptors.add(createGlossaryMethodDescriptor);
    methodDescriptors.add(listGlossariesMethodDescriptor);
    methodDescriptors.add(getGlossaryMethodDescriptor);
    methodDescriptors.add(deleteGlossaryMethodDescriptor);
    methodDescriptors.add(createAdaptiveMtDatasetMethodDescriptor);
    methodDescriptors.add(deleteAdaptiveMtDatasetMethodDescriptor);
    methodDescriptors.add(getAdaptiveMtDatasetMethodDescriptor);
    methodDescriptors.add(listAdaptiveMtDatasetsMethodDescriptor);
    methodDescriptors.add(adaptiveMtTranslateMethodDescriptor);
    methodDescriptors.add(getAdaptiveMtFileMethodDescriptor);
    methodDescriptors.add(deleteAdaptiveMtFileMethodDescriptor);
    methodDescriptors.add(importAdaptiveMtFileMethodDescriptor);
    methodDescriptors.add(listAdaptiveMtFilesMethodDescriptor);
    methodDescriptors.add(listAdaptiveMtSentencesMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<TranslateTextRequest, TranslateTextResponse> translateTextCallable() {
    return translateTextCallable;
  }

  @Override
  public UnaryCallable<DetectLanguageRequest, DetectLanguageResponse> detectLanguageCallable() {
    return detectLanguageCallable;
  }

  @Override
  public UnaryCallable<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesCallable() {
    return getSupportedLanguagesCallable;
  }

  @Override
  public UnaryCallable<TranslateDocumentRequest, TranslateDocumentResponse>
      translateDocumentCallable() {
    return translateDocumentCallable;
  }

  @Override
  public UnaryCallable<BatchTranslateTextRequest, Operation> batchTranslateTextCallable() {
    return batchTranslateTextCallable;
  }

  @Override
  public OperationCallable<
          BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextOperationCallable() {
    return batchTranslateTextOperationCallable;
  }

  @Override
  public UnaryCallable<BatchTranslateDocumentRequest, Operation> batchTranslateDocumentCallable() {
    return batchTranslateDocumentCallable;
  }

  @Override
  public OperationCallable<
          BatchTranslateDocumentRequest,
          BatchTranslateDocumentResponse,
          BatchTranslateDocumentMetadata>
      batchTranslateDocumentOperationCallable() {
    return batchTranslateDocumentOperationCallable;
  }

  @Override
  public UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable() {
    return createGlossaryCallable;
  }

  @Override
  public OperationCallable<CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
      createGlossaryOperationCallable() {
    return createGlossaryOperationCallable;
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
  public UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable() {
    return getGlossaryCallable;
  }

  @Override
  public UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable() {
    return deleteGlossaryCallable;
  }

  @Override
  public OperationCallable<DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
      deleteGlossaryOperationCallable() {
    return deleteGlossaryOperationCallable;
  }

  @Override
  public UnaryCallable<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      createAdaptiveMtDatasetCallable() {
    return createAdaptiveMtDatasetCallable;
  }

  @Override
  public UnaryCallable<DeleteAdaptiveMtDatasetRequest, Empty> deleteAdaptiveMtDatasetCallable() {
    return deleteAdaptiveMtDatasetCallable;
  }

  @Override
  public UnaryCallable<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      getAdaptiveMtDatasetCallable() {
    return getAdaptiveMtDatasetCallable;
  }

  @Override
  public UnaryCallable<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>
      listAdaptiveMtDatasetsCallable() {
    return listAdaptiveMtDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsPagedResponse>
      listAdaptiveMtDatasetsPagedCallable() {
    return listAdaptiveMtDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
      adaptiveMtTranslateCallable() {
    return adaptiveMtTranslateCallable;
  }

  @Override
  public UnaryCallable<GetAdaptiveMtFileRequest, AdaptiveMtFile> getAdaptiveMtFileCallable() {
    return getAdaptiveMtFileCallable;
  }

  @Override
  public UnaryCallable<DeleteAdaptiveMtFileRequest, Empty> deleteAdaptiveMtFileCallable() {
    return deleteAdaptiveMtFileCallable;
  }

  @Override
  public UnaryCallable<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
      importAdaptiveMtFileCallable() {
    return importAdaptiveMtFileCallable;
  }

  @Override
  public UnaryCallable<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>
      listAdaptiveMtFilesCallable() {
    return listAdaptiveMtFilesCallable;
  }

  @Override
  public UnaryCallable<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesPagedResponse>
      listAdaptiveMtFilesPagedCallable() {
    return listAdaptiveMtFilesPagedCallable;
  }

  @Override
  public UnaryCallable<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>
      listAdaptiveMtSentencesCallable() {
    return listAdaptiveMtSentencesCallable;
  }

  @Override
  public UnaryCallable<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesPagedResponse>
      listAdaptiveMtSentencesPagedCallable() {
    return listAdaptiveMtSentencesPagedCallable;
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
