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

package com.google.cloud.translate.v3beta1.stub;

import static com.google.cloud.translate.v3beta1.TranslationServiceClient.ListGlossariesPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.translate.v3beta1.BatchTranslateDocumentMetadata;
import com.google.cloud.translate.v3beta1.BatchTranslateDocumentRequest;
import com.google.cloud.translate.v3beta1.BatchTranslateDocumentResponse;
import com.google.cloud.translate.v3beta1.BatchTranslateMetadata;
import com.google.cloud.translate.v3beta1.BatchTranslateResponse;
import com.google.cloud.translate.v3beta1.BatchTranslateTextRequest;
import com.google.cloud.translate.v3beta1.CreateGlossaryMetadata;
import com.google.cloud.translate.v3beta1.CreateGlossaryRequest;
import com.google.cloud.translate.v3beta1.DeleteGlossaryMetadata;
import com.google.cloud.translate.v3beta1.DeleteGlossaryRequest;
import com.google.cloud.translate.v3beta1.DeleteGlossaryResponse;
import com.google.cloud.translate.v3beta1.DetectLanguageRequest;
import com.google.cloud.translate.v3beta1.DetectLanguageResponse;
import com.google.cloud.translate.v3beta1.GetGlossaryRequest;
import com.google.cloud.translate.v3beta1.GetSupportedLanguagesRequest;
import com.google.cloud.translate.v3beta1.Glossary;
import com.google.cloud.translate.v3beta1.ListGlossariesRequest;
import com.google.cloud.translate.v3beta1.ListGlossariesResponse;
import com.google.cloud.translate.v3beta1.SupportedLanguages;
import com.google.cloud.translate.v3beta1.TranslateDocumentRequest;
import com.google.cloud.translate.v3beta1.TranslateDocumentResponse;
import com.google.cloud.translate.v3beta1.TranslateTextRequest;
import com.google.cloud.translate.v3beta1.TranslateTextResponse;
import com.google.longrunning.Operation;
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
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonTranslationServiceStub extends TranslationServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(BatchTranslateDocumentResponse.getDescriptor())
          .add(Glossary.getDescriptor())
          .add(DeleteGlossaryMetadata.getDescriptor())
          .add(CreateGlossaryMetadata.getDescriptor())
          .add(BatchTranslateMetadata.getDescriptor())
          .add(BatchTranslateDocumentMetadata.getDescriptor())
          .add(DeleteGlossaryResponse.getDescriptor())
          .add(BatchTranslateResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<TranslateTextRequest, TranslateTextResponse>
      translateTextMethodDescriptor =
          ApiMethodDescriptor.<TranslateTextRequest, TranslateTextResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.translation.v3beta1.TranslationService/TranslateText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TranslateTextRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}:translateText",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TranslateTextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v3beta1/{parent=projects/*}:translateText")
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
              .setFullMethodName(
                  "google.cloud.translation.v3beta1.TranslationService/DetectLanguage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DetectLanguageRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}:detectLanguage",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DetectLanguageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v3beta1/{parent=projects/*}:detectLanguage")
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
                  "google.cloud.translation.v3beta1.TranslationService/GetSupportedLanguages")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSupportedLanguagesRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}/supportedLanguages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSupportedLanguagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v3beta1/{parent=projects/*}/supportedLanguages")
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
              .setFullMethodName(
                  "google.cloud.translation.v3beta1.TranslationService/TranslateDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TranslateDocumentRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}:translateDocument",
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
                  "google.cloud.translation.v3beta1.TranslationService/BatchTranslateText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchTranslateTextRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}:batchTranslateText",
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
                  "google.cloud.translation.v3beta1.TranslationService/BatchTranslateDocument")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchTranslateDocumentRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}:batchTranslateDocument",
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
              .setFullMethodName(
                  "google.cloud.translation.v3beta1.TranslationService/CreateGlossary")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateGlossaryRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}/glossaries",
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
              .setFullMethodName(
                  "google.cloud.translation.v3beta1.TranslationService/ListGlossaries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGlossariesRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}/glossaries",
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
              .setFullMethodName("google.cloud.translation.v3beta1.TranslationService/GetGlossary")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetGlossaryRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/glossaries/*}",
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
              .setFullMethodName(
                  "google.cloud.translation.v3beta1.TranslationService/DeleteGlossary")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteGlossaryRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/glossaries/*}",
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
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<TranslateTextRequest, TranslateTextResponse>
        translateTextTransportSettings =
            HttpJsonCallSettings.<TranslateTextRequest, TranslateTextResponse>newBuilder()
                .setMethodDescriptor(translateTextMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DetectLanguageRequest, DetectLanguageResponse>
        detectLanguageTransportSettings =
            HttpJsonCallSettings.<DetectLanguageRequest, DetectLanguageResponse>newBuilder()
                .setMethodDescriptor(detectLanguageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetSupportedLanguagesRequest, SupportedLanguages>
        getSupportedLanguagesTransportSettings =
            HttpJsonCallSettings.<GetSupportedLanguagesRequest, SupportedLanguages>newBuilder()
                .setMethodDescriptor(getSupportedLanguagesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TranslateDocumentRequest, TranslateDocumentResponse>
        translateDocumentTransportSettings =
            HttpJsonCallSettings.<TranslateDocumentRequest, TranslateDocumentResponse>newBuilder()
                .setMethodDescriptor(translateDocumentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<BatchTranslateTextRequest, Operation> batchTranslateTextTransportSettings =
        HttpJsonCallSettings.<BatchTranslateTextRequest, Operation>newBuilder()
            .setMethodDescriptor(batchTranslateTextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchTranslateDocumentRequest, Operation>
        batchTranslateDocumentTransportSettings =
            HttpJsonCallSettings.<BatchTranslateDocumentRequest, Operation>newBuilder()
                .setMethodDescriptor(batchTranslateDocumentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateGlossaryRequest, Operation> createGlossaryTransportSettings =
        HttpJsonCallSettings.<CreateGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(createGlossaryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListGlossariesRequest, ListGlossariesResponse>
        listGlossariesTransportSettings =
            HttpJsonCallSettings.<ListGlossariesRequest, ListGlossariesResponse>newBuilder()
                .setMethodDescriptor(listGlossariesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetGlossaryRequest, Glossary> getGlossaryTransportSettings =
        HttpJsonCallSettings.<GetGlossaryRequest, Glossary>newBuilder()
            .setMethodDescriptor(getGlossaryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteGlossaryRequest, Operation> deleteGlossaryTransportSettings =
        HttpJsonCallSettings.<DeleteGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGlossaryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
