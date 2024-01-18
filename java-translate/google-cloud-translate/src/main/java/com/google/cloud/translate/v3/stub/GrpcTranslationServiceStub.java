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

package com.google.cloud.translate.v3.stub;

import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtDatasetsPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtFilesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtSentencesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListGlossariesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TranslationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTranslationServiceStub extends TranslationServiceStub {
  private static final MethodDescriptor<TranslateTextRequest, TranslateTextResponse>
      translateTextMethodDescriptor =
          MethodDescriptor.<TranslateTextRequest, TranslateTextResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/TranslateText")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TranslateTextRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TranslateTextResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DetectLanguageRequest, DetectLanguageResponse>
      detectLanguageMethodDescriptor =
          MethodDescriptor.<DetectLanguageRequest, DetectLanguageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/DetectLanguage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DetectLanguageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DetectLanguageResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesMethodDescriptor =
          MethodDescriptor.<GetSupportedLanguagesRequest, SupportedLanguages>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/GetSupportedLanguages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSupportedLanguagesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SupportedLanguages.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TranslateDocumentRequest, TranslateDocumentResponse>
      translateDocumentMethodDescriptor =
          MethodDescriptor.<TranslateDocumentRequest, TranslateDocumentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/TranslateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TranslateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TranslateDocumentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchTranslateTextRequest, Operation>
      batchTranslateTextMethodDescriptor =
          MethodDescriptor.<BatchTranslateTextRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/BatchTranslateText")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchTranslateTextRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchTranslateDocumentRequest, Operation>
      batchTranslateDocumentMethodDescriptor =
          MethodDescriptor.<BatchTranslateDocumentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/BatchTranslateDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchTranslateDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGlossaryRequest, Operation>
      createGlossaryMethodDescriptor =
          MethodDescriptor.<CreateGlossaryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/CreateGlossary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGlossaryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListGlossariesRequest, ListGlossariesResponse>
      listGlossariesMethodDescriptor =
          MethodDescriptor.<ListGlossariesRequest, ListGlossariesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/ListGlossaries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGlossariesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGlossariesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGlossaryRequest, Glossary> getGlossaryMethodDescriptor =
      MethodDescriptor.<GetGlossaryRequest, Glossary>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.translation.v3.TranslationService/GetGlossary")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGlossaryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Glossary.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteGlossaryRequest, Operation>
      deleteGlossaryMethodDescriptor =
          MethodDescriptor.<DeleteGlossaryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/DeleteGlossary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGlossaryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      createAdaptiveMtDatasetMethodDescriptor =
          MethodDescriptor.<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/CreateAdaptiveMtDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAdaptiveMtDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AdaptiveMtDataset.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAdaptiveMtDatasetRequest, Empty>
      deleteAdaptiveMtDatasetMethodDescriptor =
          MethodDescriptor.<DeleteAdaptiveMtDatasetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/DeleteAdaptiveMtDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAdaptiveMtDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      getAdaptiveMtDatasetMethodDescriptor =
          MethodDescriptor.<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/GetAdaptiveMtDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAdaptiveMtDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AdaptiveMtDataset.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>
      listAdaptiveMtDatasetsMethodDescriptor =
          MethodDescriptor
              .<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/ListAdaptiveMtDatasets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAdaptiveMtDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAdaptiveMtDatasetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
      adaptiveMtTranslateMethodDescriptor =
          MethodDescriptor.<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/AdaptiveMtTranslate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AdaptiveMtTranslateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AdaptiveMtTranslateResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAdaptiveMtFileRequest, AdaptiveMtFile>
      getAdaptiveMtFileMethodDescriptor =
          MethodDescriptor.<GetAdaptiveMtFileRequest, AdaptiveMtFile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/GetAdaptiveMtFile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAdaptiveMtFileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AdaptiveMtFile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAdaptiveMtFileRequest, Empty>
      deleteAdaptiveMtFileMethodDescriptor =
          MethodDescriptor.<DeleteAdaptiveMtFileRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/DeleteAdaptiveMtFile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAdaptiveMtFileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
      importAdaptiveMtFileMethodDescriptor =
          MethodDescriptor.<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/ImportAdaptiveMtFile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportAdaptiveMtFileRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ImportAdaptiveMtFileResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>
      listAdaptiveMtFilesMethodDescriptor =
          MethodDescriptor.<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/ListAdaptiveMtFiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAdaptiveMtFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAdaptiveMtFilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>
      listAdaptiveMtSentencesMethodDescriptor =
          MethodDescriptor
              .<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/ListAdaptiveMtSentences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAdaptiveMtSentencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAdaptiveMtSentencesResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTranslationServiceStub create(TranslationServiceStubSettings settings)
      throws IOException {
    return new GrpcTranslationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTranslationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcTranslationServiceStub(
        TranslationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTranslationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTranslationServiceStub(
        TranslationServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTranslationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcTranslationServiceStub(
      TranslationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcTranslationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTranslationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcTranslationServiceStub(
      TranslationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<TranslateTextRequest, TranslateTextResponse> translateTextTransportSettings =
        GrpcCallSettings.<TranslateTextRequest, TranslateTextResponse>newBuilder()
            .setMethodDescriptor(translateTextMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DetectLanguageRequest, DetectLanguageResponse>
        detectLanguageTransportSettings =
            GrpcCallSettings.<DetectLanguageRequest, DetectLanguageResponse>newBuilder()
                .setMethodDescriptor(detectLanguageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetSupportedLanguagesRequest, SupportedLanguages>
        getSupportedLanguagesTransportSettings =
            GrpcCallSettings.<GetSupportedLanguagesRequest, SupportedLanguages>newBuilder()
                .setMethodDescriptor(getSupportedLanguagesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<TranslateDocumentRequest, TranslateDocumentResponse>
        translateDocumentTransportSettings =
            GrpcCallSettings.<TranslateDocumentRequest, TranslateDocumentResponse>newBuilder()
                .setMethodDescriptor(translateDocumentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchTranslateTextRequest, Operation> batchTranslateTextTransportSettings =
        GrpcCallSettings.<BatchTranslateTextRequest, Operation>newBuilder()
            .setMethodDescriptor(batchTranslateTextMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchTranslateDocumentRequest, Operation>
        batchTranslateDocumentTransportSettings =
            GrpcCallSettings.<BatchTranslateDocumentRequest, Operation>newBuilder()
                .setMethodDescriptor(batchTranslateDocumentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateGlossaryRequest, Operation> createGlossaryTransportSettings =
        GrpcCallSettings.<CreateGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(createGlossaryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGlossariesRequest, ListGlossariesResponse>
        listGlossariesTransportSettings =
            GrpcCallSettings.<ListGlossariesRequest, ListGlossariesResponse>newBuilder()
                .setMethodDescriptor(listGlossariesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGlossaryRequest, Glossary> getGlossaryTransportSettings =
        GrpcCallSettings.<GetGlossaryRequest, Glossary>newBuilder()
            .setMethodDescriptor(getGlossaryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteGlossaryRequest, Operation> deleteGlossaryTransportSettings =
        GrpcCallSettings.<DeleteGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGlossaryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
        createAdaptiveMtDatasetTransportSettings =
            GrpcCallSettings.<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>newBuilder()
                .setMethodDescriptor(createAdaptiveMtDatasetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteAdaptiveMtDatasetRequest, Empty>
        deleteAdaptiveMtDatasetTransportSettings =
            GrpcCallSettings.<DeleteAdaptiveMtDatasetRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAdaptiveMtDatasetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
        getAdaptiveMtDatasetTransportSettings =
            GrpcCallSettings.<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>newBuilder()
                .setMethodDescriptor(getAdaptiveMtDatasetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>
        listAdaptiveMtDatasetsTransportSettings =
            GrpcCallSettings
                .<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>newBuilder()
                .setMethodDescriptor(listAdaptiveMtDatasetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
        adaptiveMtTranslateTransportSettings =
            GrpcCallSettings.<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>newBuilder()
                .setMethodDescriptor(adaptiveMtTranslateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAdaptiveMtFileRequest, AdaptiveMtFile> getAdaptiveMtFileTransportSettings =
        GrpcCallSettings.<GetAdaptiveMtFileRequest, AdaptiveMtFile>newBuilder()
            .setMethodDescriptor(getAdaptiveMtFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAdaptiveMtFileRequest, Empty> deleteAdaptiveMtFileTransportSettings =
        GrpcCallSettings.<DeleteAdaptiveMtFileRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAdaptiveMtFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
        importAdaptiveMtFileTransportSettings =
            GrpcCallSettings.<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>newBuilder()
                .setMethodDescriptor(importAdaptiveMtFileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>
        listAdaptiveMtFilesTransportSettings =
            GrpcCallSettings.<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse>newBuilder()
                .setMethodDescriptor(listAdaptiveMtFilesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>
        listAdaptiveMtSentencesTransportSettings =
            GrpcCallSettings
                .<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>newBuilder()
                .setMethodDescriptor(listAdaptiveMtSentencesMethodDescriptor)
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
            operationsStub);
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
            operationsStub);
    this.createGlossaryCallable =
        callableFactory.createUnaryCallable(
            createGlossaryTransportSettings, settings.createGlossarySettings(), clientContext);
    this.createGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            createGlossaryTransportSettings,
            settings.createGlossaryOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
