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

  private static final MethodDescriptor<RomanizeTextRequest, RomanizeTextResponse>
      romanizeTextMethodDescriptor =
          MethodDescriptor.<RomanizeTextRequest, RomanizeTextResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/RomanizeText")
              .setRequestMarshaller(ProtoUtils.marshaller(RomanizeTextRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RomanizeTextResponse.getDefaultInstance()))
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

  private static final MethodDescriptor<UpdateGlossaryRequest, Operation>
      updateGlossaryMethodDescriptor =
          MethodDescriptor.<UpdateGlossaryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/UpdateGlossary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGlossaryRequest.getDefaultInstance()))
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

  private static final MethodDescriptor<GetGlossaryEntryRequest, GlossaryEntry>
      getGlossaryEntryMethodDescriptor =
          MethodDescriptor.<GetGlossaryEntryRequest, GlossaryEntry>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/GetGlossaryEntry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGlossaryEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GlossaryEntry.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>
      listGlossaryEntriesMethodDescriptor =
          MethodDescriptor.<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/ListGlossaryEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGlossaryEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGlossaryEntriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGlossaryEntryRequest, GlossaryEntry>
      createGlossaryEntryMethodDescriptor =
          MethodDescriptor.<CreateGlossaryEntryRequest, GlossaryEntry>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/CreateGlossaryEntry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGlossaryEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GlossaryEntry.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateGlossaryEntryRequest, GlossaryEntry>
      updateGlossaryEntryMethodDescriptor =
          MethodDescriptor.<UpdateGlossaryEntryRequest, GlossaryEntry>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/UpdateGlossaryEntry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGlossaryEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GlossaryEntry.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGlossaryEntryRequest, Empty>
      deleteGlossaryEntryMethodDescriptor =
          MethodDescriptor.<DeleteGlossaryEntryRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.translation.v3.TranslationService/DeleteGlossaryEntry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGlossaryEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDatasetRequest, Operation>
      createDatasetMethodDescriptor =
          MethodDescriptor.<CreateDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/CreateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      MethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.translation.v3.TranslationService/GetDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          MethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/ListDatasets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDatasetRequest, Operation>
      deleteDatasetMethodDescriptor =
          MethodDescriptor.<DeleteDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/DeleteDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatasetRequest.getDefaultInstance()))
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

  private static final MethodDescriptor<ImportDataRequest, Operation> importDataMethodDescriptor =
      MethodDescriptor.<ImportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.translation.v3.TranslationService/ImportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ImportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ExportDataRequest, Operation> exportDataMethodDescriptor =
      MethodDescriptor.<ExportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.translation.v3.TranslationService/ExportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListExamplesRequest, ListExamplesResponse>
      listExamplesMethodDescriptor =
          MethodDescriptor.<ListExamplesRequest, ListExamplesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/ListExamples")
              .setRequestMarshaller(ProtoUtils.marshaller(ListExamplesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExamplesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateModelRequest, Operation> createModelMethodDescriptor =
      MethodDescriptor.<CreateModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.translation.v3.TranslationService/CreateModel")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          MethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.translation.v3.TranslationService/ListModels")
              .setRequestMarshaller(ProtoUtils.marshaller(ListModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListModelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetModelRequest, Model> getModelMethodDescriptor =
      MethodDescriptor.<GetModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.translation.v3.TranslationService/GetModel")
          .setRequestMarshaller(ProtoUtils.marshaller(GetModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteModelRequest, Operation> deleteModelMethodDescriptor =
      MethodDescriptor.<DeleteModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.translation.v3.TranslationService/DeleteModel")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
    GrpcCallSettings<RomanizeTextRequest, RomanizeTextResponse> romanizeTextTransportSettings =
        GrpcCallSettings.<RomanizeTextRequest, RomanizeTextResponse>newBuilder()
            .setMethodDescriptor(romanizeTextMethodDescriptor)
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
    GrpcCallSettings<UpdateGlossaryRequest, Operation> updateGlossaryTransportSettings =
        GrpcCallSettings.<UpdateGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGlossaryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("glossary.name", String.valueOf(request.getGlossary().getName()));
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
    GrpcCallSettings<GetGlossaryEntryRequest, GlossaryEntry> getGlossaryEntryTransportSettings =
        GrpcCallSettings.<GetGlossaryEntryRequest, GlossaryEntry>newBuilder()
            .setMethodDescriptor(getGlossaryEntryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>
        listGlossaryEntriesTransportSettings =
            GrpcCallSettings.<ListGlossaryEntriesRequest, ListGlossaryEntriesResponse>newBuilder()
                .setMethodDescriptor(listGlossaryEntriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateGlossaryEntryRequest, GlossaryEntry>
        createGlossaryEntryTransportSettings =
            GrpcCallSettings.<CreateGlossaryEntryRequest, GlossaryEntry>newBuilder()
                .setMethodDescriptor(createGlossaryEntryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateGlossaryEntryRequest, GlossaryEntry>
        updateGlossaryEntryTransportSettings =
            GrpcCallSettings.<UpdateGlossaryEntryRequest, GlossaryEntry>newBuilder()
                .setMethodDescriptor(updateGlossaryEntryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "glossary_entry.name",
                          String.valueOf(request.getGlossaryEntry().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteGlossaryEntryRequest, Empty> deleteGlossaryEntryTransportSettings =
        GrpcCallSettings.<DeleteGlossaryEntryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGlossaryEntryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDatasetRequest, Operation> createDatasetTransportSettings =
        GrpcCallSettings.<CreateDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        GrpcCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        GrpcCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDatasetRequest, Operation> deleteDatasetTransportSettings =
        GrpcCallSettings.<DeleteDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
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
    GrpcCallSettings<ImportDataRequest, Operation> importDataTransportSettings =
        GrpcCallSettings.<ImportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset", String.valueOf(request.getDataset()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportDataRequest, Operation> exportDataTransportSettings =
        GrpcCallSettings.<ExportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset", String.valueOf(request.getDataset()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListExamplesRequest, ListExamplesResponse> listExamplesTransportSettings =
        GrpcCallSettings.<ListExamplesRequest, ListExamplesResponse>newBuilder()
            .setMethodDescriptor(listExamplesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateModelRequest, Operation> createModelTransportSettings =
        GrpcCallSettings.<CreateModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        GrpcCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetModelRequest, Model> getModelTransportSettings =
        GrpcCallSettings.<GetModelRequest, Model>newBuilder()
            .setMethodDescriptor(getModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteModelRequest, Operation> deleteModelTransportSettings =
        GrpcCallSettings.<DeleteModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteModelMethodDescriptor)
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
    this.updateGlossaryCallable =
        callableFactory.createUnaryCallable(
            updateGlossaryTransportSettings, settings.updateGlossarySettings(), clientContext);
    this.updateGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            updateGlossaryTransportSettings,
            settings.updateGlossaryOperationSettings(),
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
            operationsStub);
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
    this.importDataCallable =
        callableFactory.createUnaryCallable(
            importDataTransportSettings, settings.importDataSettings(), clientContext);
    this.importDataOperationCallable =
        callableFactory.createOperationCallable(
            importDataTransportSettings,
            settings.importDataOperationSettings(),
            clientContext,
            operationsStub);
    this.exportDataCallable =
        callableFactory.createUnaryCallable(
            exportDataTransportSettings, settings.exportDataSettings(), clientContext);
    this.exportDataOperationCallable =
        callableFactory.createOperationCallable(
            exportDataTransportSettings,
            settings.exportDataOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);

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
