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

package com.google.cloud.translate.v3.stub;

import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtDatasetsPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtFilesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtSentencesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListDatasetsPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListExamplesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListGlossariesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListGlossaryEntriesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListModelsPagedResponse;

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
import com.google.cloud.translate.v3.CreateDatasetMetadata;
import com.google.cloud.translate.v3.CreateDatasetRequest;
import com.google.cloud.translate.v3.CreateGlossaryEntryRequest;
import com.google.cloud.translate.v3.CreateGlossaryMetadata;
import com.google.cloud.translate.v3.CreateGlossaryRequest;
import com.google.cloud.translate.v3.CreateModelMetadata;
import com.google.cloud.translate.v3.CreateModelRequest;
import com.google.cloud.translate.v3.Dataset;
import com.google.cloud.translate.v3.DeleteAdaptiveMtDatasetRequest;
import com.google.cloud.translate.v3.DeleteAdaptiveMtFileRequest;
import com.google.cloud.translate.v3.DeleteDatasetMetadata;
import com.google.cloud.translate.v3.DeleteDatasetRequest;
import com.google.cloud.translate.v3.DeleteGlossaryEntryRequest;
import com.google.cloud.translate.v3.DeleteGlossaryMetadata;
import com.google.cloud.translate.v3.DeleteGlossaryRequest;
import com.google.cloud.translate.v3.DeleteGlossaryResponse;
import com.google.cloud.translate.v3.DeleteModelMetadata;
import com.google.cloud.translate.v3.DeleteModelRequest;
import com.google.cloud.translate.v3.DetectLanguageRequest;
import com.google.cloud.translate.v3.DetectLanguageResponse;
import com.google.cloud.translate.v3.ExportDataMetadata;
import com.google.cloud.translate.v3.ExportDataRequest;
import com.google.cloud.translate.v3.GetAdaptiveMtDatasetRequest;
import com.google.cloud.translate.v3.GetAdaptiveMtFileRequest;
import com.google.cloud.translate.v3.GetDatasetRequest;
import com.google.cloud.translate.v3.GetGlossaryEntryRequest;
import com.google.cloud.translate.v3.GetGlossaryRequest;
import com.google.cloud.translate.v3.GetModelRequest;
import com.google.cloud.translate.v3.GetSupportedLanguagesRequest;
import com.google.cloud.translate.v3.Glossary;
import com.google.cloud.translate.v3.GlossaryEntry;
import com.google.cloud.translate.v3.ImportAdaptiveMtFileRequest;
import com.google.cloud.translate.v3.ImportAdaptiveMtFileResponse;
import com.google.cloud.translate.v3.ImportDataMetadata;
import com.google.cloud.translate.v3.ImportDataRequest;
import com.google.cloud.translate.v3.ListAdaptiveMtDatasetsRequest;
import com.google.cloud.translate.v3.ListAdaptiveMtDatasetsResponse;
import com.google.cloud.translate.v3.ListAdaptiveMtFilesRequest;
import com.google.cloud.translate.v3.ListAdaptiveMtFilesResponse;
import com.google.cloud.translate.v3.ListAdaptiveMtSentencesRequest;
import com.google.cloud.translate.v3.ListAdaptiveMtSentencesResponse;
import com.google.cloud.translate.v3.ListDatasetsRequest;
import com.google.cloud.translate.v3.ListDatasetsResponse;
import com.google.cloud.translate.v3.ListExamplesRequest;
import com.google.cloud.translate.v3.ListExamplesResponse;
import com.google.cloud.translate.v3.ListGlossariesRequest;
import com.google.cloud.translate.v3.ListGlossariesResponse;
import com.google.cloud.translate.v3.ListGlossaryEntriesRequest;
import com.google.cloud.translate.v3.ListGlossaryEntriesResponse;
import com.google.cloud.translate.v3.ListModelsRequest;
import com.google.cloud.translate.v3.ListModelsResponse;
import com.google.cloud.translate.v3.Model;
import com.google.cloud.translate.v3.RomanizeTextRequest;
import com.google.cloud.translate.v3.RomanizeTextResponse;
import com.google.cloud.translate.v3.SupportedLanguages;
import com.google.cloud.translate.v3.TranslateDocumentRequest;
import com.google.cloud.translate.v3.TranslateDocumentResponse;
import com.google.cloud.translate.v3.TranslateTextRequest;
import com.google.cloud.translate.v3.TranslateTextResponse;
import com.google.cloud.translate.v3.UpdateGlossaryEntryRequest;
import com.google.cloud.translate.v3.UpdateGlossaryMetadata;
import com.google.cloud.translate.v3.UpdateGlossaryRequest;
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
          .add(ImportDataMetadata.getDescriptor())
          .add(DeleteModelMetadata.getDescriptor())
          .add(UpdateGlossaryMetadata.getDescriptor())
          .add(CreateModelMetadata.getDescriptor())
          .add(Dataset.getDescriptor())
          .add(CreateGlossaryMetadata.getDescriptor())
          .add(BatchTranslateDocumentResponse.getDescriptor())
          .add(DeleteGlossaryResponse.getDescriptor())
          .add(BatchTranslateDocumentMetadata.getDescriptor())
          .add(ExportDataMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(BatchTranslateResponse.getDescriptor())
          .add(BatchTranslateMetadata.getDescriptor())
          .add(Glossary.getDescriptor())
          .add(DeleteDatasetMetadata.getDescriptor())
          .add(Model.getDescriptor())
          .add(CreateDatasetMetadata.getDescriptor())
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

  private static final ApiMethodDescriptor<RomanizeTextRequest, RomanizeTextResponse>
      romanizeTextMethodDescriptor =
          ApiMethodDescriptor.<RomanizeTextRequest, RomanizeTextResponse>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/RomanizeText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RomanizeTextRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}:romanizeText",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RomanizeTextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v3/{parent=projects/*}:romanizeText")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RomanizeTextRequest> serializer =
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
                  ProtoMessageResponseParser.<RomanizeTextResponse>newBuilder()
                      .setDefaultInstance(RomanizeTextResponse.getDefaultInstance())
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

  private static final ApiMethodDescriptor<UpdateGlossaryRequest, Operation>
      updateGlossaryMethodDescriptor =
          ApiMethodDescriptor.<UpdateGlossaryRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/UpdateGlossary")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGlossaryRequest>newBuilder()
                      .setPath(
                          "/v3/{glossary.name=projects/*/locations/*/glossaries/*}",
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

  private static final ApiMethodDescriptor<GetGlossaryEntryRequest, GlossaryEntry>
      getGlossaryEntryMethodDescriptor =
          ApiMethodDescriptor.<GetGlossaryEntryRequest, GlossaryEntry>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/GetGlossaryEntry")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlossaryEntryRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/glossaries/*/glossaryEntries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlossaryEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGlossaryEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlossaryEntry>newBuilder()
                      .setDefaultInstance(GlossaryEntry.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>
      listGlossaryEntriesMethodDescriptor =
          ApiMethodDescriptor.<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/ListGlossaryEntries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlossaryEntriesRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/glossaries/*}/glossaryEntries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlossaryEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGlossaryEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGlossaryEntriesResponse>newBuilder()
                      .setDefaultInstance(ListGlossaryEntriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateGlossaryEntryRequest, GlossaryEntry>
      createGlossaryEntryMethodDescriptor =
          ApiMethodDescriptor.<CreateGlossaryEntryRequest, GlossaryEntry>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/CreateGlossaryEntry")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGlossaryEntryRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/glossaries/*}/glossaryEntries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGlossaryEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateGlossaryEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("glossaryEntry", request.getGlossaryEntry(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlossaryEntry>newBuilder()
                      .setDefaultInstance(GlossaryEntry.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateGlossaryEntryRequest, GlossaryEntry>
      updateGlossaryEntryMethodDescriptor =
          ApiMethodDescriptor.<UpdateGlossaryEntryRequest, GlossaryEntry>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/UpdateGlossaryEntry")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGlossaryEntryRequest>newBuilder()
                      .setPath(
                          "/v3/{glossaryEntry.name=projects/*/locations/*/glossaries/*/glossaryEntries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGlossaryEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "glossaryEntry.name", request.getGlossaryEntry().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGlossaryEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("glossaryEntry", request.getGlossaryEntry(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GlossaryEntry>newBuilder()
                      .setDefaultInstance(GlossaryEntry.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteGlossaryEntryRequest, Empty>
      deleteGlossaryEntryMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlossaryEntryRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/DeleteGlossaryEntry")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlossaryEntryRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/glossaries/*/glossaryEntries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlossaryEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteGlossaryEntryRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateDatasetRequest, Operation>
      createDatasetMethodDescriptor =
          ApiMethodDescriptor.<CreateDatasetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/CreateDataset")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDatasetRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/datasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataset", request.getDataset(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDatasetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      ApiMethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setFullMethodName("google.cloud.translation.v3.TranslationService/GetDataset")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetDatasetRequest>newBuilder()
                  .setPath(
                      "/v3/{name=projects/*/locations/*/datasets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetDatasetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetDatasetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Dataset>newBuilder()
                  .setDefaultInstance(Dataset.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          ApiMethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/ListDatasets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDatasetsRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/datasets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDatasetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDatasetsResponse>newBuilder()
                      .setDefaultInstance(ListDatasetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDatasetRequest, Operation>
      deleteDatasetMethodDescriptor =
          ApiMethodDescriptor.<DeleteDatasetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/DeleteDataset")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDatasetRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/datasets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatasetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDatasetRequest> serializer =
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
                  (DeleteDatasetRequest request, Operation response) ->
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

  private static final ApiMethodDescriptor<ImportDataRequest, Operation>
      importDataMethodDescriptor =
          ApiMethodDescriptor.<ImportDataRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/ImportData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportDataRequest>newBuilder()
                      .setPath(
                          "/v3/{dataset=projects/*/locations/*/datasets/*}:importData",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "dataset", request.getDataset());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearDataset().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportDataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportDataRequest, Operation>
      exportDataMethodDescriptor =
          ApiMethodDescriptor.<ExportDataRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/ExportData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportDataRequest>newBuilder()
                      .setPath(
                          "/v3/{dataset=projects/*/locations/*/datasets/*}:exportData",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "dataset", request.getDataset());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearDataset().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportDataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListExamplesRequest, ListExamplesResponse>
      listExamplesMethodDescriptor =
          ApiMethodDescriptor.<ListExamplesRequest, ListExamplesResponse>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/ListExamples")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExamplesRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/datasets/*}/examples",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExamplesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExamplesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListExamplesResponse>newBuilder()
                      .setDefaultInstance(ListExamplesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateModelRequest, Operation>
      createModelMethodDescriptor =
          ApiMethodDescriptor.<CreateModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/CreateModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateModelRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/models",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("model", request.getModel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          ApiMethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/ListModels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListModelsRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*}/models",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListModelsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListModelsResponse>newBuilder()
                      .setDefaultInstance(ListModelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetModelRequest, Model> getModelMethodDescriptor =
      ApiMethodDescriptor.<GetModelRequest, Model>newBuilder()
          .setFullMethodName("google.cloud.translation.v3.TranslationService/GetModel")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetModelRequest>newBuilder()
                  .setPath(
                      "/v3/{name=projects/*/locations/*/models/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Model>newBuilder()
                  .setDefaultInstance(Model.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteModelRequest, Operation>
      deleteModelMethodDescriptor =
          ApiMethodDescriptor.<DeleteModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.translation.v3.TranslationService/DeleteModel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteModelRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/models/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteModelRequest> serializer =
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
                  (DeleteModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<TranslateTextRequest, TranslateTextResponse> translateTextCallable;
  private final UnaryCallable<RomanizeTextRequest, RomanizeTextResponse> romanizeTextCallable;
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
  private final UnaryCallable<UpdateGlossaryRequest, Operation> updateGlossaryCallable;
  private final OperationCallable<UpdateGlossaryRequest, Glossary, UpdateGlossaryMetadata>
      updateGlossaryOperationCallable;
  private final UnaryCallable<ListGlossariesRequest, ListGlossariesResponse> listGlossariesCallable;
  private final UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable;
  private final UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable;
  private final UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable;
  private final OperationCallable<
          DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
      deleteGlossaryOperationCallable;
  private final UnaryCallable<GetGlossaryEntryRequest, GlossaryEntry> getGlossaryEntryCallable;
  private final UnaryCallable<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>
      listGlossaryEntriesCallable;
  private final UnaryCallable<ListGlossaryEntriesRequest, ListGlossaryEntriesPagedResponse>
      listGlossaryEntriesPagedCallable;
  private final UnaryCallable<CreateGlossaryEntryRequest, GlossaryEntry>
      createGlossaryEntryCallable;
  private final UnaryCallable<UpdateGlossaryEntryRequest, GlossaryEntry>
      updateGlossaryEntryCallable;
  private final UnaryCallable<DeleteGlossaryEntryRequest, Empty> deleteGlossaryEntryCallable;
  private final UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable;
  private final OperationCallable<CreateDatasetRequest, Dataset, CreateDatasetMetadata>
      createDatasetOperationCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable;
  private final OperationCallable<DeleteDatasetRequest, Empty, DeleteDatasetMetadata>
      deleteDatasetOperationCallable;
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
  private final UnaryCallable<ImportDataRequest, Operation> importDataCallable;
  private final OperationCallable<ImportDataRequest, Empty, ImportDataMetadata>
      importDataOperationCallable;
  private final UnaryCallable<ExportDataRequest, Operation> exportDataCallable;
  private final OperationCallable<ExportDataRequest, Empty, ExportDataMetadata>
      exportDataOperationCallable;
  private final UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable;
  private final UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse>
      listExamplesPagedCallable;
  private final UnaryCallable<CreateModelRequest, Operation> createModelCallable;
  private final OperationCallable<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable;
  private final UnaryCallable<GetModelRequest, Model> getModelCallable;
  private final UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable;
  private final OperationCallable<DeleteModelRequest, Empty, DeleteModelMetadata>
      deleteModelOperationCallable;

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
    HttpJsonCallSettings<RomanizeTextRequest, RomanizeTextResponse> romanizeTextTransportSettings =
        HttpJsonCallSettings.<RomanizeTextRequest, RomanizeTextResponse>newBuilder()
            .setMethodDescriptor(romanizeTextMethodDescriptor)
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
    HttpJsonCallSettings<GetGlossaryEntryRequest, GlossaryEntry> getGlossaryEntryTransportSettings =
        HttpJsonCallSettings.<GetGlossaryEntryRequest, GlossaryEntry>newBuilder()
            .setMethodDescriptor(getGlossaryEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>
        listGlossaryEntriesTransportSettings =
            HttpJsonCallSettings
                .<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>newBuilder()
                .setMethodDescriptor(listGlossaryEntriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateGlossaryEntryRequest, GlossaryEntry>
        createGlossaryEntryTransportSettings =
            HttpJsonCallSettings.<CreateGlossaryEntryRequest, GlossaryEntry>newBuilder()
                .setMethodDescriptor(createGlossaryEntryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateGlossaryEntryRequest, GlossaryEntry>
        updateGlossaryEntryTransportSettings =
            HttpJsonCallSettings.<UpdateGlossaryEntryRequest, GlossaryEntry>newBuilder()
                .setMethodDescriptor(updateGlossaryEntryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "glossary_entry.name",
                          String.valueOf(request.getGlossaryEntry().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteGlossaryEntryRequest, Empty> deleteGlossaryEntryTransportSettings =
        HttpJsonCallSettings.<DeleteGlossaryEntryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGlossaryEntryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateDatasetRequest, Operation> createDatasetTransportSettings =
        HttpJsonCallSettings.<CreateDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        HttpJsonCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        HttpJsonCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteDatasetRequest, Operation> deleteDatasetTransportSettings =
        HttpJsonCallSettings.<DeleteDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
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
    HttpJsonCallSettings<ImportDataRequest, Operation> importDataTransportSettings =
        HttpJsonCallSettings.<ImportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset", String.valueOf(request.getDataset()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportDataRequest, Operation> exportDataTransportSettings =
        HttpJsonCallSettings.<ExportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset", String.valueOf(request.getDataset()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListExamplesRequest, ListExamplesResponse> listExamplesTransportSettings =
        HttpJsonCallSettings.<ListExamplesRequest, ListExamplesResponse>newBuilder()
            .setMethodDescriptor(listExamplesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateModelRequest, Operation> createModelTransportSettings =
        HttpJsonCallSettings.<CreateModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        HttpJsonCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetModelRequest, Model> getModelTransportSettings =
        HttpJsonCallSettings.<GetModelRequest, Model>newBuilder()
            .setMethodDescriptor(getModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteModelRequest, Operation> deleteModelTransportSettings =
        HttpJsonCallSettings.<DeleteModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.translateTextCallable =
        callableFactory.createUnaryCallable(
            translateTextTransportSettings, settings.translateTextSettings(), clientContext);
    this.romanizeTextCallable =
        callableFactory.createUnaryCallable(
            romanizeTextTransportSettings, settings.romanizeTextSettings(), clientContext);
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
    this.updateGlossaryCallable =
        callableFactory.createUnaryCallable(
            updateGlossaryTransportSettings, settings.updateGlossarySettings(), clientContext);
    this.updateGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            updateGlossaryTransportSettings,
            settings.updateGlossaryOperationSettings(),
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
    this.getGlossaryEntryCallable =
        callableFactory.createUnaryCallable(
            getGlossaryEntryTransportSettings, settings.getGlossaryEntrySettings(), clientContext);
    this.listGlossaryEntriesCallable =
        callableFactory.createUnaryCallable(
            listGlossaryEntriesTransportSettings,
            settings.listGlossaryEntriesSettings(),
            clientContext);
    this.listGlossaryEntriesPagedCallable =
        callableFactory.createPagedCallable(
            listGlossaryEntriesTransportSettings,
            settings.listGlossaryEntriesSettings(),
            clientContext);
    this.createGlossaryEntryCallable =
        callableFactory.createUnaryCallable(
            createGlossaryEntryTransportSettings,
            settings.createGlossaryEntrySettings(),
            clientContext);
    this.updateGlossaryEntryCallable =
        callableFactory.createUnaryCallable(
            updateGlossaryEntryTransportSettings,
            settings.updateGlossaryEntrySettings(),
            clientContext);
    this.deleteGlossaryEntryCallable =
        callableFactory.createUnaryCallable(
            deleteGlossaryEntryTransportSettings,
            settings.deleteGlossaryEntrySettings(),
            clientContext);
    this.createDatasetCallable =
        callableFactory.createUnaryCallable(
            createDatasetTransportSettings, settings.createDatasetSettings(), clientContext);
    this.createDatasetOperationCallable =
        callableFactory.createOperationCallable(
            createDatasetTransportSettings,
            settings.createDatasetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.deleteDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetTransportSettings, settings.deleteDatasetSettings(), clientContext);
    this.deleteDatasetOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatasetTransportSettings,
            settings.deleteDatasetOperationSettings(),
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
    this.importDataCallable =
        callableFactory.createUnaryCallable(
            importDataTransportSettings, settings.importDataSettings(), clientContext);
    this.importDataOperationCallable =
        callableFactory.createOperationCallable(
            importDataTransportSettings,
            settings.importDataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportDataCallable =
        callableFactory.createUnaryCallable(
            exportDataTransportSettings, settings.exportDataSettings(), clientContext);
    this.exportDataOperationCallable =
        callableFactory.createOperationCallable(
            exportDataTransportSettings,
            settings.exportDataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listExamplesCallable =
        callableFactory.createUnaryCallable(
            listExamplesTransportSettings, settings.listExamplesSettings(), clientContext);
    this.listExamplesPagedCallable =
        callableFactory.createPagedCallable(
            listExamplesTransportSettings, settings.listExamplesSettings(), clientContext);
    this.createModelCallable =
        callableFactory.createUnaryCallable(
            createModelTransportSettings, settings.createModelSettings(), clientContext);
    this.createModelOperationCallable =
        callableFactory.createOperationCallable(
            createModelTransportSettings,
            settings.createModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listModelsCallable =
        callableFactory.createUnaryCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.listModelsPagedCallable =
        callableFactory.createPagedCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.getModelCallable =
        callableFactory.createUnaryCallable(
            getModelTransportSettings, settings.getModelSettings(), clientContext);
    this.deleteModelCallable =
        callableFactory.createUnaryCallable(
            deleteModelTransportSettings, settings.deleteModelSettings(), clientContext);
    this.deleteModelOperationCallable =
        callableFactory.createOperationCallable(
            deleteModelTransportSettings,
            settings.deleteModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(translateTextMethodDescriptor);
    methodDescriptors.add(romanizeTextMethodDescriptor);
    methodDescriptors.add(detectLanguageMethodDescriptor);
    methodDescriptors.add(getSupportedLanguagesMethodDescriptor);
    methodDescriptors.add(translateDocumentMethodDescriptor);
    methodDescriptors.add(batchTranslateTextMethodDescriptor);
    methodDescriptors.add(batchTranslateDocumentMethodDescriptor);
    methodDescriptors.add(createGlossaryMethodDescriptor);
    methodDescriptors.add(updateGlossaryMethodDescriptor);
    methodDescriptors.add(listGlossariesMethodDescriptor);
    methodDescriptors.add(getGlossaryMethodDescriptor);
    methodDescriptors.add(deleteGlossaryMethodDescriptor);
    methodDescriptors.add(getGlossaryEntryMethodDescriptor);
    methodDescriptors.add(listGlossaryEntriesMethodDescriptor);
    methodDescriptors.add(createGlossaryEntryMethodDescriptor);
    methodDescriptors.add(updateGlossaryEntryMethodDescriptor);
    methodDescriptors.add(deleteGlossaryEntryMethodDescriptor);
    methodDescriptors.add(createDatasetMethodDescriptor);
    methodDescriptors.add(getDatasetMethodDescriptor);
    methodDescriptors.add(listDatasetsMethodDescriptor);
    methodDescriptors.add(deleteDatasetMethodDescriptor);
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
    methodDescriptors.add(importDataMethodDescriptor);
    methodDescriptors.add(exportDataMethodDescriptor);
    methodDescriptors.add(listExamplesMethodDescriptor);
    methodDescriptors.add(createModelMethodDescriptor);
    methodDescriptors.add(listModelsMethodDescriptor);
    methodDescriptors.add(getModelMethodDescriptor);
    methodDescriptors.add(deleteModelMethodDescriptor);
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
  public UnaryCallable<RomanizeTextRequest, RomanizeTextResponse> romanizeTextCallable() {
    return romanizeTextCallable;
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
  public UnaryCallable<UpdateGlossaryRequest, Operation> updateGlossaryCallable() {
    return updateGlossaryCallable;
  }

  @Override
  public OperationCallable<UpdateGlossaryRequest, Glossary, UpdateGlossaryMetadata>
      updateGlossaryOperationCallable() {
    return updateGlossaryOperationCallable;
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
  public UnaryCallable<GetGlossaryEntryRequest, GlossaryEntry> getGlossaryEntryCallable() {
    return getGlossaryEntryCallable;
  }

  @Override
  public UnaryCallable<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>
      listGlossaryEntriesCallable() {
    return listGlossaryEntriesCallable;
  }

  @Override
  public UnaryCallable<ListGlossaryEntriesRequest, ListGlossaryEntriesPagedResponse>
      listGlossaryEntriesPagedCallable() {
    return listGlossaryEntriesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateGlossaryEntryRequest, GlossaryEntry> createGlossaryEntryCallable() {
    return createGlossaryEntryCallable;
  }

  @Override
  public UnaryCallable<UpdateGlossaryEntryRequest, GlossaryEntry> updateGlossaryEntryCallable() {
    return updateGlossaryEntryCallable;
  }

  @Override
  public UnaryCallable<DeleteGlossaryEntryRequest, Empty> deleteGlossaryEntryCallable() {
    return deleteGlossaryEntryCallable;
  }

  @Override
  public UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable() {
    return createDatasetCallable;
  }

  @Override
  public OperationCallable<CreateDatasetRequest, Dataset, CreateDatasetMetadata>
      createDatasetOperationCallable() {
    return createDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return listDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    return listDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    return deleteDatasetCallable;
  }

  @Override
  public OperationCallable<DeleteDatasetRequest, Empty, DeleteDatasetMetadata>
      deleteDatasetOperationCallable() {
    return deleteDatasetOperationCallable;
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
  public UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return importDataCallable;
  }

  @Override
  public OperationCallable<ImportDataRequest, Empty, ImportDataMetadata>
      importDataOperationCallable() {
    return importDataOperationCallable;
  }

  @Override
  public UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return exportDataCallable;
  }

  @Override
  public OperationCallable<ExportDataRequest, Empty, ExportDataMetadata>
      exportDataOperationCallable() {
    return exportDataOperationCallable;
  }

  @Override
  public UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable() {
    return listExamplesCallable;
  }

  @Override
  public UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse> listExamplesPagedCallable() {
    return listExamplesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateModelRequest, Operation> createModelCallable() {
    return createModelCallable;
  }

  @Override
  public OperationCallable<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationCallable() {
    return createModelOperationCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return listModelsCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return listModelsPagedCallable;
  }

  @Override
  public UnaryCallable<GetModelRequest, Model> getModelCallable() {
    return getModelCallable;
  }

  @Override
  public UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable() {
    return deleteModelCallable;
  }

  @Override
  public OperationCallable<DeleteModelRequest, Empty, DeleteModelMetadata>
      deleteModelOperationCallable() {
    return deleteModelOperationCallable;
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
