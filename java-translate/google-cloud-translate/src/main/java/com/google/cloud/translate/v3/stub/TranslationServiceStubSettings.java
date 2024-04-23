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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.translate.v3.AdaptiveMtDataset;
import com.google.cloud.translate.v3.AdaptiveMtFile;
import com.google.cloud.translate.v3.AdaptiveMtSentence;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TranslationServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (translate.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of translateText to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TranslationServiceStubSettings.Builder translationServiceSettingsBuilder =
 *     TranslationServiceStubSettings.newBuilder();
 * translationServiceSettingsBuilder
 *     .translateTextSettings()
 *     .setRetrySettings(
 *         translationServiceSettingsBuilder
 *             .translateTextSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TranslationServiceStubSettings translationServiceSettings =
 *     translationServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TranslationServiceStubSettings extends StubSettings<TranslationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-translation")
          .build();

  private final UnaryCallSettings<TranslateTextRequest, TranslateTextResponse>
      translateTextSettings;
  private final UnaryCallSettings<DetectLanguageRequest, DetectLanguageResponse>
      detectLanguageSettings;
  private final UnaryCallSettings<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesSettings;
  private final UnaryCallSettings<TranslateDocumentRequest, TranslateDocumentResponse>
      translateDocumentSettings;
  private final UnaryCallSettings<BatchTranslateTextRequest, Operation> batchTranslateTextSettings;
  private final OperationCallSettings<
          BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextOperationSettings;
  private final UnaryCallSettings<BatchTranslateDocumentRequest, Operation>
      batchTranslateDocumentSettings;
  private final OperationCallSettings<
          BatchTranslateDocumentRequest,
          BatchTranslateDocumentResponse,
          BatchTranslateDocumentMetadata>
      batchTranslateDocumentOperationSettings;
  private final UnaryCallSettings<CreateGlossaryRequest, Operation> createGlossarySettings;
  private final OperationCallSettings<CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
      createGlossaryOperationSettings;
  private final PagedCallSettings<
          ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
      listGlossariesSettings;
  private final UnaryCallSettings<GetGlossaryRequest, Glossary> getGlossarySettings;
  private final UnaryCallSettings<DeleteGlossaryRequest, Operation> deleteGlossarySettings;
  private final OperationCallSettings<
          DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
      deleteGlossaryOperationSettings;
  private final UnaryCallSettings<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      createAdaptiveMtDatasetSettings;
  private final UnaryCallSettings<DeleteAdaptiveMtDatasetRequest, Empty>
      deleteAdaptiveMtDatasetSettings;
  private final UnaryCallSettings<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      getAdaptiveMtDatasetSettings;
  private final PagedCallSettings<
          ListAdaptiveMtDatasetsRequest,
          ListAdaptiveMtDatasetsResponse,
          ListAdaptiveMtDatasetsPagedResponse>
      listAdaptiveMtDatasetsSettings;
  private final UnaryCallSettings<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
      adaptiveMtTranslateSettings;
  private final UnaryCallSettings<GetAdaptiveMtFileRequest, AdaptiveMtFile>
      getAdaptiveMtFileSettings;
  private final UnaryCallSettings<DeleteAdaptiveMtFileRequest, Empty> deleteAdaptiveMtFileSettings;
  private final UnaryCallSettings<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
      importAdaptiveMtFileSettings;
  private final PagedCallSettings<
          ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, ListAdaptiveMtFilesPagedResponse>
      listAdaptiveMtFilesSettings;
  private final PagedCallSettings<
          ListAdaptiveMtSentencesRequest,
          ListAdaptiveMtSentencesResponse,
          ListAdaptiveMtSentencesPagedResponse>
      listAdaptiveMtSentencesSettings;

  private static final PagedListDescriptor<ListGlossariesRequest, ListGlossariesResponse, Glossary>
      LIST_GLOSSARIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListGlossariesRequest, ListGlossariesResponse, Glossary>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGlossariesRequest injectToken(ListGlossariesRequest payload, String token) {
              return ListGlossariesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGlossariesRequest injectPageSize(
                ListGlossariesRequest payload, int pageSize) {
              return ListGlossariesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGlossariesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGlossariesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Glossary> extractResources(ListGlossariesResponse payload) {
              return payload.getGlossariesList() == null
                  ? ImmutableList.<Glossary>of()
                  : payload.getGlossariesList();
            }
          };

  private static final PagedListDescriptor<
          ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse, AdaptiveMtDataset>
      LIST_ADAPTIVE_MT_DATASETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse, AdaptiveMtDataset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAdaptiveMtDatasetsRequest injectToken(
                ListAdaptiveMtDatasetsRequest payload, String token) {
              return ListAdaptiveMtDatasetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAdaptiveMtDatasetsRequest injectPageSize(
                ListAdaptiveMtDatasetsRequest payload, int pageSize) {
              return ListAdaptiveMtDatasetsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAdaptiveMtDatasetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAdaptiveMtDatasetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AdaptiveMtDataset> extractResources(
                ListAdaptiveMtDatasetsResponse payload) {
              return payload.getAdaptiveMtDatasetsList() == null
                  ? ImmutableList.<AdaptiveMtDataset>of()
                  : payload.getAdaptiveMtDatasetsList();
            }
          };

  private static final PagedListDescriptor<
          ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, AdaptiveMtFile>
      LIST_ADAPTIVE_MT_FILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, AdaptiveMtFile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAdaptiveMtFilesRequest injectToken(
                ListAdaptiveMtFilesRequest payload, String token) {
              return ListAdaptiveMtFilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAdaptiveMtFilesRequest injectPageSize(
                ListAdaptiveMtFilesRequest payload, int pageSize) {
              return ListAdaptiveMtFilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAdaptiveMtFilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAdaptiveMtFilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AdaptiveMtFile> extractResources(ListAdaptiveMtFilesResponse payload) {
              return payload.getAdaptiveMtFilesList() == null
                  ? ImmutableList.<AdaptiveMtFile>of()
                  : payload.getAdaptiveMtFilesList();
            }
          };

  private static final PagedListDescriptor<
          ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse, AdaptiveMtSentence>
      LIST_ADAPTIVE_MT_SENTENCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAdaptiveMtSentencesRequest,
              ListAdaptiveMtSentencesResponse,
              AdaptiveMtSentence>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAdaptiveMtSentencesRequest injectToken(
                ListAdaptiveMtSentencesRequest payload, String token) {
              return ListAdaptiveMtSentencesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAdaptiveMtSentencesRequest injectPageSize(
                ListAdaptiveMtSentencesRequest payload, int pageSize) {
              return ListAdaptiveMtSentencesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAdaptiveMtSentencesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAdaptiveMtSentencesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AdaptiveMtSentence> extractResources(
                ListAdaptiveMtSentencesResponse payload) {
              return payload.getAdaptiveMtSentencesList() == null
                  ? ImmutableList.<AdaptiveMtSentence>of()
                  : payload.getAdaptiveMtSentencesList();
            }
          };

  private static final PagedListResponseFactory<
          ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
      LIST_GLOSSARIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>() {
            @Override
            public ApiFuture<ListGlossariesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGlossariesRequest, ListGlossariesResponse> callable,
                ListGlossariesRequest request,
                ApiCallContext context,
                ApiFuture<ListGlossariesResponse> futureResponse) {
              PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> pageContext =
                  PageContext.create(callable, LIST_GLOSSARIES_PAGE_STR_DESC, request, context);
              return ListGlossariesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAdaptiveMtDatasetsRequest,
          ListAdaptiveMtDatasetsResponse,
          ListAdaptiveMtDatasetsPagedResponse>
      LIST_ADAPTIVE_MT_DATASETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAdaptiveMtDatasetsRequest,
              ListAdaptiveMtDatasetsResponse,
              ListAdaptiveMtDatasetsPagedResponse>() {
            @Override
            public ApiFuture<ListAdaptiveMtDatasetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAdaptiveMtDatasetsRequest, ListAdaptiveMtDatasetsResponse>
                    callable,
                ListAdaptiveMtDatasetsRequest request,
                ApiCallContext context,
                ApiFuture<ListAdaptiveMtDatasetsResponse> futureResponse) {
              PageContext<
                      ListAdaptiveMtDatasetsRequest,
                      ListAdaptiveMtDatasetsResponse,
                      AdaptiveMtDataset>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ADAPTIVE_MT_DATASETS_PAGE_STR_DESC, request, context);
              return ListAdaptiveMtDatasetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, ListAdaptiveMtFilesPagedResponse>
      LIST_ADAPTIVE_MT_FILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAdaptiveMtFilesRequest,
              ListAdaptiveMtFilesResponse,
              ListAdaptiveMtFilesPagedResponse>() {
            @Override
            public ApiFuture<ListAdaptiveMtFilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse> callable,
                ListAdaptiveMtFilesRequest request,
                ApiCallContext context,
                ApiFuture<ListAdaptiveMtFilesResponse> futureResponse) {
              PageContext<ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, AdaptiveMtFile>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ADAPTIVE_MT_FILES_PAGE_STR_DESC, request, context);
              return ListAdaptiveMtFilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAdaptiveMtSentencesRequest,
          ListAdaptiveMtSentencesResponse,
          ListAdaptiveMtSentencesPagedResponse>
      LIST_ADAPTIVE_MT_SENTENCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAdaptiveMtSentencesRequest,
              ListAdaptiveMtSentencesResponse,
              ListAdaptiveMtSentencesPagedResponse>() {
            @Override
            public ApiFuture<ListAdaptiveMtSentencesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAdaptiveMtSentencesRequest, ListAdaptiveMtSentencesResponse>
                    callable,
                ListAdaptiveMtSentencesRequest request,
                ApiCallContext context,
                ApiFuture<ListAdaptiveMtSentencesResponse> futureResponse) {
              PageContext<
                      ListAdaptiveMtSentencesRequest,
                      ListAdaptiveMtSentencesResponse,
                      AdaptiveMtSentence>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ADAPTIVE_MT_SENTENCES_PAGE_STR_DESC, request, context);
              return ListAdaptiveMtSentencesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to translateText. */
  public UnaryCallSettings<TranslateTextRequest, TranslateTextResponse> translateTextSettings() {
    return translateTextSettings;
  }

  /** Returns the object with the settings used for calls to detectLanguage. */
  public UnaryCallSettings<DetectLanguageRequest, DetectLanguageResponse> detectLanguageSettings() {
    return detectLanguageSettings;
  }

  /** Returns the object with the settings used for calls to getSupportedLanguages. */
  public UnaryCallSettings<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesSettings() {
    return getSupportedLanguagesSettings;
  }

  /** Returns the object with the settings used for calls to translateDocument. */
  public UnaryCallSettings<TranslateDocumentRequest, TranslateDocumentResponse>
      translateDocumentSettings() {
    return translateDocumentSettings;
  }

  /** Returns the object with the settings used for calls to batchTranslateText. */
  public UnaryCallSettings<BatchTranslateTextRequest, Operation> batchTranslateTextSettings() {
    return batchTranslateTextSettings;
  }

  /** Returns the object with the settings used for calls to batchTranslateText. */
  public OperationCallSettings<
          BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextOperationSettings() {
    return batchTranslateTextOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchTranslateDocument. */
  public UnaryCallSettings<BatchTranslateDocumentRequest, Operation>
      batchTranslateDocumentSettings() {
    return batchTranslateDocumentSettings;
  }

  /** Returns the object with the settings used for calls to batchTranslateDocument. */
  public OperationCallSettings<
          BatchTranslateDocumentRequest,
          BatchTranslateDocumentResponse,
          BatchTranslateDocumentMetadata>
      batchTranslateDocumentOperationSettings() {
    return batchTranslateDocumentOperationSettings;
  }

  /** Returns the object with the settings used for calls to createGlossary. */
  public UnaryCallSettings<CreateGlossaryRequest, Operation> createGlossarySettings() {
    return createGlossarySettings;
  }

  /** Returns the object with the settings used for calls to createGlossary. */
  public OperationCallSettings<CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
      createGlossaryOperationSettings() {
    return createGlossaryOperationSettings;
  }

  /** Returns the object with the settings used for calls to listGlossaries. */
  public PagedCallSettings<
          ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
      listGlossariesSettings() {
    return listGlossariesSettings;
  }

  /** Returns the object with the settings used for calls to getGlossary. */
  public UnaryCallSettings<GetGlossaryRequest, Glossary> getGlossarySettings() {
    return getGlossarySettings;
  }

  /** Returns the object with the settings used for calls to deleteGlossary. */
  public UnaryCallSettings<DeleteGlossaryRequest, Operation> deleteGlossarySettings() {
    return deleteGlossarySettings;
  }

  /** Returns the object with the settings used for calls to deleteGlossary. */
  public OperationCallSettings<
          DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
      deleteGlossaryOperationSettings() {
    return deleteGlossaryOperationSettings;
  }

  /** Returns the object with the settings used for calls to createAdaptiveMtDataset. */
  public UnaryCallSettings<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      createAdaptiveMtDatasetSettings() {
    return createAdaptiveMtDatasetSettings;
  }

  /** Returns the object with the settings used for calls to deleteAdaptiveMtDataset. */
  public UnaryCallSettings<DeleteAdaptiveMtDatasetRequest, Empty>
      deleteAdaptiveMtDatasetSettings() {
    return deleteAdaptiveMtDatasetSettings;
  }

  /** Returns the object with the settings used for calls to getAdaptiveMtDataset. */
  public UnaryCallSettings<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      getAdaptiveMtDatasetSettings() {
    return getAdaptiveMtDatasetSettings;
  }

  /** Returns the object with the settings used for calls to listAdaptiveMtDatasets. */
  public PagedCallSettings<
          ListAdaptiveMtDatasetsRequest,
          ListAdaptiveMtDatasetsResponse,
          ListAdaptiveMtDatasetsPagedResponse>
      listAdaptiveMtDatasetsSettings() {
    return listAdaptiveMtDatasetsSettings;
  }

  /** Returns the object with the settings used for calls to adaptiveMtTranslate. */
  public UnaryCallSettings<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
      adaptiveMtTranslateSettings() {
    return adaptiveMtTranslateSettings;
  }

  /** Returns the object with the settings used for calls to getAdaptiveMtFile. */
  public UnaryCallSettings<GetAdaptiveMtFileRequest, AdaptiveMtFile> getAdaptiveMtFileSettings() {
    return getAdaptiveMtFileSettings;
  }

  /** Returns the object with the settings used for calls to deleteAdaptiveMtFile. */
  public UnaryCallSettings<DeleteAdaptiveMtFileRequest, Empty> deleteAdaptiveMtFileSettings() {
    return deleteAdaptiveMtFileSettings;
  }

  /** Returns the object with the settings used for calls to importAdaptiveMtFile. */
  public UnaryCallSettings<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
      importAdaptiveMtFileSettings() {
    return importAdaptiveMtFileSettings;
  }

  /** Returns the object with the settings used for calls to listAdaptiveMtFiles. */
  public PagedCallSettings<
          ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, ListAdaptiveMtFilesPagedResponse>
      listAdaptiveMtFilesSettings() {
    return listAdaptiveMtFilesSettings;
  }

  /** Returns the object with the settings used for calls to listAdaptiveMtSentences. */
  public PagedCallSettings<
          ListAdaptiveMtSentencesRequest,
          ListAdaptiveMtSentencesResponse,
          ListAdaptiveMtSentencesPagedResponse>
      listAdaptiveMtSentencesSettings() {
    return listAdaptiveMtSentencesSettings;
  }

  public TranslationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTranslationServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTranslationServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "translate";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "translate.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "translate.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TranslationServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TranslationServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TranslationServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected TranslationServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    translateTextSettings = settingsBuilder.translateTextSettings().build();
    detectLanguageSettings = settingsBuilder.detectLanguageSettings().build();
    getSupportedLanguagesSettings = settingsBuilder.getSupportedLanguagesSettings().build();
    translateDocumentSettings = settingsBuilder.translateDocumentSettings().build();
    batchTranslateTextSettings = settingsBuilder.batchTranslateTextSettings().build();
    batchTranslateTextOperationSettings =
        settingsBuilder.batchTranslateTextOperationSettings().build();
    batchTranslateDocumentSettings = settingsBuilder.batchTranslateDocumentSettings().build();
    batchTranslateDocumentOperationSettings =
        settingsBuilder.batchTranslateDocumentOperationSettings().build();
    createGlossarySettings = settingsBuilder.createGlossarySettings().build();
    createGlossaryOperationSettings = settingsBuilder.createGlossaryOperationSettings().build();
    listGlossariesSettings = settingsBuilder.listGlossariesSettings().build();
    getGlossarySettings = settingsBuilder.getGlossarySettings().build();
    deleteGlossarySettings = settingsBuilder.deleteGlossarySettings().build();
    deleteGlossaryOperationSettings = settingsBuilder.deleteGlossaryOperationSettings().build();
    createAdaptiveMtDatasetSettings = settingsBuilder.createAdaptiveMtDatasetSettings().build();
    deleteAdaptiveMtDatasetSettings = settingsBuilder.deleteAdaptiveMtDatasetSettings().build();
    getAdaptiveMtDatasetSettings = settingsBuilder.getAdaptiveMtDatasetSettings().build();
    listAdaptiveMtDatasetsSettings = settingsBuilder.listAdaptiveMtDatasetsSettings().build();
    adaptiveMtTranslateSettings = settingsBuilder.adaptiveMtTranslateSettings().build();
    getAdaptiveMtFileSettings = settingsBuilder.getAdaptiveMtFileSettings().build();
    deleteAdaptiveMtFileSettings = settingsBuilder.deleteAdaptiveMtFileSettings().build();
    importAdaptiveMtFileSettings = settingsBuilder.importAdaptiveMtFileSettings().build();
    listAdaptiveMtFilesSettings = settingsBuilder.listAdaptiveMtFilesSettings().build();
    listAdaptiveMtSentencesSettings = settingsBuilder.listAdaptiveMtSentencesSettings().build();
  }

  /** Builder for TranslationServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<TranslationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<TranslateTextRequest, TranslateTextResponse>
        translateTextSettings;
    private final UnaryCallSettings.Builder<DetectLanguageRequest, DetectLanguageResponse>
        detectLanguageSettings;
    private final UnaryCallSettings.Builder<GetSupportedLanguagesRequest, SupportedLanguages>
        getSupportedLanguagesSettings;
    private final UnaryCallSettings.Builder<TranslateDocumentRequest, TranslateDocumentResponse>
        translateDocumentSettings;
    private final UnaryCallSettings.Builder<BatchTranslateTextRequest, Operation>
        batchTranslateTextSettings;
    private final OperationCallSettings.Builder<
            BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
        batchTranslateTextOperationSettings;
    private final UnaryCallSettings.Builder<BatchTranslateDocumentRequest, Operation>
        batchTranslateDocumentSettings;
    private final OperationCallSettings.Builder<
            BatchTranslateDocumentRequest,
            BatchTranslateDocumentResponse,
            BatchTranslateDocumentMetadata>
        batchTranslateDocumentOperationSettings;
    private final UnaryCallSettings.Builder<CreateGlossaryRequest, Operation>
        createGlossarySettings;
    private final OperationCallSettings.Builder<
            CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
        createGlossaryOperationSettings;
    private final PagedCallSettings.Builder<
            ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
        listGlossariesSettings;
    private final UnaryCallSettings.Builder<GetGlossaryRequest, Glossary> getGlossarySettings;
    private final UnaryCallSettings.Builder<DeleteGlossaryRequest, Operation>
        deleteGlossarySettings;
    private final OperationCallSettings.Builder<
            DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
        deleteGlossaryOperationSettings;
    private final UnaryCallSettings.Builder<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
        createAdaptiveMtDatasetSettings;
    private final UnaryCallSettings.Builder<DeleteAdaptiveMtDatasetRequest, Empty>
        deleteAdaptiveMtDatasetSettings;
    private final UnaryCallSettings.Builder<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
        getAdaptiveMtDatasetSettings;
    private final PagedCallSettings.Builder<
            ListAdaptiveMtDatasetsRequest,
            ListAdaptiveMtDatasetsResponse,
            ListAdaptiveMtDatasetsPagedResponse>
        listAdaptiveMtDatasetsSettings;
    private final UnaryCallSettings.Builder<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
        adaptiveMtTranslateSettings;
    private final UnaryCallSettings.Builder<GetAdaptiveMtFileRequest, AdaptiveMtFile>
        getAdaptiveMtFileSettings;
    private final UnaryCallSettings.Builder<DeleteAdaptiveMtFileRequest, Empty>
        deleteAdaptiveMtFileSettings;
    private final UnaryCallSettings.Builder<
            ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
        importAdaptiveMtFileSettings;
    private final PagedCallSettings.Builder<
            ListAdaptiveMtFilesRequest,
            ListAdaptiveMtFilesResponse,
            ListAdaptiveMtFilesPagedResponse>
        listAdaptiveMtFilesSettings;
    private final PagedCallSettings.Builder<
            ListAdaptiveMtSentencesRequest,
            ListAdaptiveMtSentencesResponse,
            ListAdaptiveMtSentencesPagedResponse>
        listAdaptiveMtSentencesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      translateTextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      detectLanguageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSupportedLanguagesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      translateDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchTranslateTextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchTranslateTextOperationSettings = OperationCallSettings.newBuilder();
      batchTranslateDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchTranslateDocumentOperationSettings = OperationCallSettings.newBuilder();
      createGlossarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGlossaryOperationSettings = OperationCallSettings.newBuilder();
      listGlossariesSettings = PagedCallSettings.newBuilder(LIST_GLOSSARIES_PAGE_STR_FACT);
      getGlossarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGlossarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGlossaryOperationSettings = OperationCallSettings.newBuilder();
      createAdaptiveMtDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAdaptiveMtDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAdaptiveMtDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAdaptiveMtDatasetsSettings =
          PagedCallSettings.newBuilder(LIST_ADAPTIVE_MT_DATASETS_PAGE_STR_FACT);
      adaptiveMtTranslateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAdaptiveMtFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAdaptiveMtFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importAdaptiveMtFileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAdaptiveMtFilesSettings =
          PagedCallSettings.newBuilder(LIST_ADAPTIVE_MT_FILES_PAGE_STR_FACT);
      listAdaptiveMtSentencesSettings =
          PagedCallSettings.newBuilder(LIST_ADAPTIVE_MT_SENTENCES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              translateTextSettings,
              detectLanguageSettings,
              getSupportedLanguagesSettings,
              translateDocumentSettings,
              batchTranslateTextSettings,
              batchTranslateDocumentSettings,
              createGlossarySettings,
              listGlossariesSettings,
              getGlossarySettings,
              deleteGlossarySettings,
              createAdaptiveMtDatasetSettings,
              deleteAdaptiveMtDatasetSettings,
              getAdaptiveMtDatasetSettings,
              listAdaptiveMtDatasetsSettings,
              adaptiveMtTranslateSettings,
              getAdaptiveMtFileSettings,
              deleteAdaptiveMtFileSettings,
              importAdaptiveMtFileSettings,
              listAdaptiveMtFilesSettings,
              listAdaptiveMtSentencesSettings);
      initDefaults(this);
    }

    protected Builder(TranslationServiceStubSettings settings) {
      super(settings);

      translateTextSettings = settings.translateTextSettings.toBuilder();
      detectLanguageSettings = settings.detectLanguageSettings.toBuilder();
      getSupportedLanguagesSettings = settings.getSupportedLanguagesSettings.toBuilder();
      translateDocumentSettings = settings.translateDocumentSettings.toBuilder();
      batchTranslateTextSettings = settings.batchTranslateTextSettings.toBuilder();
      batchTranslateTextOperationSettings =
          settings.batchTranslateTextOperationSettings.toBuilder();
      batchTranslateDocumentSettings = settings.batchTranslateDocumentSettings.toBuilder();
      batchTranslateDocumentOperationSettings =
          settings.batchTranslateDocumentOperationSettings.toBuilder();
      createGlossarySettings = settings.createGlossarySettings.toBuilder();
      createGlossaryOperationSettings = settings.createGlossaryOperationSettings.toBuilder();
      listGlossariesSettings = settings.listGlossariesSettings.toBuilder();
      getGlossarySettings = settings.getGlossarySettings.toBuilder();
      deleteGlossarySettings = settings.deleteGlossarySettings.toBuilder();
      deleteGlossaryOperationSettings = settings.deleteGlossaryOperationSettings.toBuilder();
      createAdaptiveMtDatasetSettings = settings.createAdaptiveMtDatasetSettings.toBuilder();
      deleteAdaptiveMtDatasetSettings = settings.deleteAdaptiveMtDatasetSettings.toBuilder();
      getAdaptiveMtDatasetSettings = settings.getAdaptiveMtDatasetSettings.toBuilder();
      listAdaptiveMtDatasetsSettings = settings.listAdaptiveMtDatasetsSettings.toBuilder();
      adaptiveMtTranslateSettings = settings.adaptiveMtTranslateSettings.toBuilder();
      getAdaptiveMtFileSettings = settings.getAdaptiveMtFileSettings.toBuilder();
      deleteAdaptiveMtFileSettings = settings.deleteAdaptiveMtFileSettings.toBuilder();
      importAdaptiveMtFileSettings = settings.importAdaptiveMtFileSettings.toBuilder();
      listAdaptiveMtFilesSettings = settings.listAdaptiveMtFilesSettings.toBuilder();
      listAdaptiveMtSentencesSettings = settings.listAdaptiveMtSentencesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              translateTextSettings,
              detectLanguageSettings,
              getSupportedLanguagesSettings,
              translateDocumentSettings,
              batchTranslateTextSettings,
              batchTranslateDocumentSettings,
              createGlossarySettings,
              listGlossariesSettings,
              getGlossarySettings,
              deleteGlossarySettings,
              createAdaptiveMtDatasetSettings,
              deleteAdaptiveMtDatasetSettings,
              getAdaptiveMtDatasetSettings,
              listAdaptiveMtDatasetsSettings,
              adaptiveMtTranslateSettings,
              getAdaptiveMtFileSettings,
              deleteAdaptiveMtFileSettings,
              importAdaptiveMtFileSettings,
              listAdaptiveMtFilesSettings,
              listAdaptiveMtSentencesSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .translateTextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .detectLanguageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSupportedLanguagesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .translateDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .batchTranslateTextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .batchTranslateDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createGlossarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listGlossariesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getGlossarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteGlossarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAdaptiveMtDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteAdaptiveMtDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getAdaptiveMtDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAdaptiveMtDatasetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .adaptiveMtTranslateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getAdaptiveMtFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteAdaptiveMtFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .importAdaptiveMtFileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAdaptiveMtFilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAdaptiveMtSentencesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchTranslateTextOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchTranslateTextRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BatchTranslateResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BatchTranslateMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .batchTranslateDocumentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchTranslateDocumentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchTranslateDocumentResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchTranslateDocumentMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createGlossaryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGlossaryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Glossary.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateGlossaryMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteGlossaryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGlossaryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DeleteGlossaryResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteGlossaryMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to translateText. */
    public UnaryCallSettings.Builder<TranslateTextRequest, TranslateTextResponse>
        translateTextSettings() {
      return translateTextSettings;
    }

    /** Returns the builder for the settings used for calls to detectLanguage. */
    public UnaryCallSettings.Builder<DetectLanguageRequest, DetectLanguageResponse>
        detectLanguageSettings() {
      return detectLanguageSettings;
    }

    /** Returns the builder for the settings used for calls to getSupportedLanguages. */
    public UnaryCallSettings.Builder<GetSupportedLanguagesRequest, SupportedLanguages>
        getSupportedLanguagesSettings() {
      return getSupportedLanguagesSettings;
    }

    /** Returns the builder for the settings used for calls to translateDocument. */
    public UnaryCallSettings.Builder<TranslateDocumentRequest, TranslateDocumentResponse>
        translateDocumentSettings() {
      return translateDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to batchTranslateText. */
    public UnaryCallSettings.Builder<BatchTranslateTextRequest, Operation>
        batchTranslateTextSettings() {
      return batchTranslateTextSettings;
    }

    /** Returns the builder for the settings used for calls to batchTranslateText. */
    public OperationCallSettings.Builder<
            BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
        batchTranslateTextOperationSettings() {
      return batchTranslateTextOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchTranslateDocument. */
    public UnaryCallSettings.Builder<BatchTranslateDocumentRequest, Operation>
        batchTranslateDocumentSettings() {
      return batchTranslateDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to batchTranslateDocument. */
    public OperationCallSettings.Builder<
            BatchTranslateDocumentRequest,
            BatchTranslateDocumentResponse,
            BatchTranslateDocumentMetadata>
        batchTranslateDocumentOperationSettings() {
      return batchTranslateDocumentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createGlossary. */
    public UnaryCallSettings.Builder<CreateGlossaryRequest, Operation> createGlossarySettings() {
      return createGlossarySettings;
    }

    /** Returns the builder for the settings used for calls to createGlossary. */
    public OperationCallSettings.Builder<CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
        createGlossaryOperationSettings() {
      return createGlossaryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listGlossaries. */
    public PagedCallSettings.Builder<
            ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
        listGlossariesSettings() {
      return listGlossariesSettings;
    }

    /** Returns the builder for the settings used for calls to getGlossary. */
    public UnaryCallSettings.Builder<GetGlossaryRequest, Glossary> getGlossarySettings() {
      return getGlossarySettings;
    }

    /** Returns the builder for the settings used for calls to deleteGlossary. */
    public UnaryCallSettings.Builder<DeleteGlossaryRequest, Operation> deleteGlossarySettings() {
      return deleteGlossarySettings;
    }

    /** Returns the builder for the settings used for calls to deleteGlossary. */
    public OperationCallSettings.Builder<
            DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
        deleteGlossaryOperationSettings() {
      return deleteGlossaryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createAdaptiveMtDataset. */
    public UnaryCallSettings.Builder<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
        createAdaptiveMtDatasetSettings() {
      return createAdaptiveMtDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAdaptiveMtDataset. */
    public UnaryCallSettings.Builder<DeleteAdaptiveMtDatasetRequest, Empty>
        deleteAdaptiveMtDatasetSettings() {
      return deleteAdaptiveMtDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to getAdaptiveMtDataset. */
    public UnaryCallSettings.Builder<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
        getAdaptiveMtDatasetSettings() {
      return getAdaptiveMtDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to listAdaptiveMtDatasets. */
    public PagedCallSettings.Builder<
            ListAdaptiveMtDatasetsRequest,
            ListAdaptiveMtDatasetsResponse,
            ListAdaptiveMtDatasetsPagedResponse>
        listAdaptiveMtDatasetsSettings() {
      return listAdaptiveMtDatasetsSettings;
    }

    /** Returns the builder for the settings used for calls to adaptiveMtTranslate. */
    public UnaryCallSettings.Builder<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
        adaptiveMtTranslateSettings() {
      return adaptiveMtTranslateSettings;
    }

    /** Returns the builder for the settings used for calls to getAdaptiveMtFile. */
    public UnaryCallSettings.Builder<GetAdaptiveMtFileRequest, AdaptiveMtFile>
        getAdaptiveMtFileSettings() {
      return getAdaptiveMtFileSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAdaptiveMtFile. */
    public UnaryCallSettings.Builder<DeleteAdaptiveMtFileRequest, Empty>
        deleteAdaptiveMtFileSettings() {
      return deleteAdaptiveMtFileSettings;
    }

    /** Returns the builder for the settings used for calls to importAdaptiveMtFile. */
    public UnaryCallSettings.Builder<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
        importAdaptiveMtFileSettings() {
      return importAdaptiveMtFileSettings;
    }

    /** Returns the builder for the settings used for calls to listAdaptiveMtFiles. */
    public PagedCallSettings.Builder<
            ListAdaptiveMtFilesRequest,
            ListAdaptiveMtFilesResponse,
            ListAdaptiveMtFilesPagedResponse>
        listAdaptiveMtFilesSettings() {
      return listAdaptiveMtFilesSettings;
    }

    /** Returns the builder for the settings used for calls to listAdaptiveMtSentences. */
    public PagedCallSettings.Builder<
            ListAdaptiveMtSentencesRequest,
            ListAdaptiveMtSentencesResponse,
            ListAdaptiveMtSentencesPagedResponse>
        listAdaptiveMtSentencesSettings() {
      return listAdaptiveMtSentencesSettings;
    }

    @Override
    public TranslationServiceStubSettings build() throws IOException {
      return new TranslationServiceStubSettings(this);
    }
  }
}
