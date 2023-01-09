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

package com.google.cloud.speech.v2.stub;

import static com.google.cloud.speech.v2.SpeechClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v2.SpeechClient.ListPhraseSetsPagedResponse;
import static com.google.cloud.speech.v2.SpeechClient.ListRecognizersPagedResponse;

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
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v2.BatchRecognizeRequest;
import com.google.cloud.speech.v2.BatchRecognizeResponse;
import com.google.cloud.speech.v2.Config;
import com.google.cloud.speech.v2.CreateCustomClassRequest;
import com.google.cloud.speech.v2.CreatePhraseSetRequest;
import com.google.cloud.speech.v2.CreateRecognizerRequest;
import com.google.cloud.speech.v2.CustomClass;
import com.google.cloud.speech.v2.DeleteCustomClassRequest;
import com.google.cloud.speech.v2.DeletePhraseSetRequest;
import com.google.cloud.speech.v2.DeleteRecognizerRequest;
import com.google.cloud.speech.v2.GetConfigRequest;
import com.google.cloud.speech.v2.GetCustomClassRequest;
import com.google.cloud.speech.v2.GetPhraseSetRequest;
import com.google.cloud.speech.v2.GetRecognizerRequest;
import com.google.cloud.speech.v2.ListCustomClassesRequest;
import com.google.cloud.speech.v2.ListCustomClassesResponse;
import com.google.cloud.speech.v2.ListPhraseSetsRequest;
import com.google.cloud.speech.v2.ListPhraseSetsResponse;
import com.google.cloud.speech.v2.ListRecognizersRequest;
import com.google.cloud.speech.v2.ListRecognizersResponse;
import com.google.cloud.speech.v2.OperationMetadata;
import com.google.cloud.speech.v2.PhraseSet;
import com.google.cloud.speech.v2.RecognizeRequest;
import com.google.cloud.speech.v2.RecognizeResponse;
import com.google.cloud.speech.v2.Recognizer;
import com.google.cloud.speech.v2.StreamingRecognizeRequest;
import com.google.cloud.speech.v2.StreamingRecognizeResponse;
import com.google.cloud.speech.v2.UndeleteCustomClassRequest;
import com.google.cloud.speech.v2.UndeletePhraseSetRequest;
import com.google.cloud.speech.v2.UndeleteRecognizerRequest;
import com.google.cloud.speech.v2.UpdateConfigRequest;
import com.google.cloud.speech.v2.UpdateCustomClassRequest;
import com.google.cloud.speech.v2.UpdatePhraseSetRequest;
import com.google.cloud.speech.v2.UpdateRecognizerRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SpeechStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (speech.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getRecognizer to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SpeechStubSettings.Builder speechSettingsBuilder = SpeechStubSettings.newBuilder();
 * speechSettingsBuilder
 *     .getRecognizerSettings()
 *     .setRetrySettings(
 *         speechSettingsBuilder
 *             .getRecognizerSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SpeechStubSettings speechSettings = speechSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SpeechStubSettings extends StubSettings<SpeechStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateRecognizerRequest, Operation> createRecognizerSettings;
  private final OperationCallSettings<CreateRecognizerRequest, Recognizer, OperationMetadata>
      createRecognizerOperationSettings;
  private final PagedCallSettings<
          ListRecognizersRequest, ListRecognizersResponse, ListRecognizersPagedResponse>
      listRecognizersSettings;
  private final UnaryCallSettings<GetRecognizerRequest, Recognizer> getRecognizerSettings;
  private final UnaryCallSettings<UpdateRecognizerRequest, Operation> updateRecognizerSettings;
  private final OperationCallSettings<UpdateRecognizerRequest, Recognizer, OperationMetadata>
      updateRecognizerOperationSettings;
  private final UnaryCallSettings<DeleteRecognizerRequest, Operation> deleteRecognizerSettings;
  private final OperationCallSettings<DeleteRecognizerRequest, Recognizer, OperationMetadata>
      deleteRecognizerOperationSettings;
  private final UnaryCallSettings<UndeleteRecognizerRequest, Operation> undeleteRecognizerSettings;
  private final OperationCallSettings<UndeleteRecognizerRequest, Recognizer, OperationMetadata>
      undeleteRecognizerOperationSettings;
  private final UnaryCallSettings<RecognizeRequest, RecognizeResponse> recognizeSettings;
  private final StreamingCallSettings<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeSettings;
  private final UnaryCallSettings<BatchRecognizeRequest, Operation> batchRecognizeSettings;
  private final OperationCallSettings<
          BatchRecognizeRequest, BatchRecognizeResponse, OperationMetadata>
      batchRecognizeOperationSettings;
  private final UnaryCallSettings<GetConfigRequest, Config> getConfigSettings;
  private final UnaryCallSettings<UpdateConfigRequest, Config> updateConfigSettings;
  private final UnaryCallSettings<CreateCustomClassRequest, Operation> createCustomClassSettings;
  private final OperationCallSettings<CreateCustomClassRequest, CustomClass, OperationMetadata>
      createCustomClassOperationSettings;
  private final PagedCallSettings<
          ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
      listCustomClassesSettings;
  private final UnaryCallSettings<GetCustomClassRequest, CustomClass> getCustomClassSettings;
  private final UnaryCallSettings<UpdateCustomClassRequest, Operation> updateCustomClassSettings;
  private final OperationCallSettings<UpdateCustomClassRequest, CustomClass, OperationMetadata>
      updateCustomClassOperationSettings;
  private final UnaryCallSettings<DeleteCustomClassRequest, Operation> deleteCustomClassSettings;
  private final OperationCallSettings<DeleteCustomClassRequest, CustomClass, OperationMetadata>
      deleteCustomClassOperationSettings;
  private final UnaryCallSettings<UndeleteCustomClassRequest, Operation>
      undeleteCustomClassSettings;
  private final OperationCallSettings<UndeleteCustomClassRequest, CustomClass, OperationMetadata>
      undeleteCustomClassOperationSettings;
  private final UnaryCallSettings<CreatePhraseSetRequest, Operation> createPhraseSetSettings;
  private final OperationCallSettings<CreatePhraseSetRequest, PhraseSet, OperationMetadata>
      createPhraseSetOperationSettings;
  private final PagedCallSettings<
          ListPhraseSetsRequest, ListPhraseSetsResponse, ListPhraseSetsPagedResponse>
      listPhraseSetsSettings;
  private final UnaryCallSettings<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings;
  private final UnaryCallSettings<UpdatePhraseSetRequest, Operation> updatePhraseSetSettings;
  private final OperationCallSettings<UpdatePhraseSetRequest, PhraseSet, OperationMetadata>
      updatePhraseSetOperationSettings;
  private final UnaryCallSettings<DeletePhraseSetRequest, Operation> deletePhraseSetSettings;
  private final OperationCallSettings<DeletePhraseSetRequest, PhraseSet, OperationMetadata>
      deletePhraseSetOperationSettings;
  private final UnaryCallSettings<UndeletePhraseSetRequest, Operation> undeletePhraseSetSettings;
  private final OperationCallSettings<UndeletePhraseSetRequest, PhraseSet, OperationMetadata>
      undeletePhraseSetOperationSettings;

  private static final PagedListDescriptor<
          ListRecognizersRequest, ListRecognizersResponse, Recognizer>
      LIST_RECOGNIZERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRecognizersRequest, ListRecognizersResponse, Recognizer>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRecognizersRequest injectToken(
                ListRecognizersRequest payload, String token) {
              return ListRecognizersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRecognizersRequest injectPageSize(
                ListRecognizersRequest payload, int pageSize) {
              return ListRecognizersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRecognizersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRecognizersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Recognizer> extractResources(ListRecognizersResponse payload) {
              return payload.getRecognizersList() == null
                  ? ImmutableList.<Recognizer>of()
                  : payload.getRecognizersList();
            }
          };

  private static final PagedListDescriptor<
          ListCustomClassesRequest, ListCustomClassesResponse, CustomClass>
      LIST_CUSTOM_CLASSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCustomClassesRequest, ListCustomClassesResponse, CustomClass>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCustomClassesRequest injectToken(
                ListCustomClassesRequest payload, String token) {
              return ListCustomClassesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCustomClassesRequest injectPageSize(
                ListCustomClassesRequest payload, int pageSize) {
              return ListCustomClassesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCustomClassesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCustomClassesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CustomClass> extractResources(ListCustomClassesResponse payload) {
              return payload.getCustomClassesList() == null
                  ? ImmutableList.<CustomClass>of()
                  : payload.getCustomClassesList();
            }
          };

  private static final PagedListDescriptor<ListPhraseSetsRequest, ListPhraseSetsResponse, PhraseSet>
      LIST_PHRASE_SETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListPhraseSetsRequest, ListPhraseSetsResponse, PhraseSet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPhraseSetsRequest injectToken(ListPhraseSetsRequest payload, String token) {
              return ListPhraseSetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPhraseSetsRequest injectPageSize(
                ListPhraseSetsRequest payload, int pageSize) {
              return ListPhraseSetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPhraseSetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPhraseSetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PhraseSet> extractResources(ListPhraseSetsResponse payload) {
              return payload.getPhraseSetsList() == null
                  ? ImmutableList.<PhraseSet>of()
                  : payload.getPhraseSetsList();
            }
          };

  private static final PagedListResponseFactory<
          ListRecognizersRequest, ListRecognizersResponse, ListRecognizersPagedResponse>
      LIST_RECOGNIZERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRecognizersRequest, ListRecognizersResponse, ListRecognizersPagedResponse>() {
            @Override
            public ApiFuture<ListRecognizersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRecognizersRequest, ListRecognizersResponse> callable,
                ListRecognizersRequest request,
                ApiCallContext context,
                ApiFuture<ListRecognizersResponse> futureResponse) {
              PageContext<ListRecognizersRequest, ListRecognizersResponse, Recognizer> pageContext =
                  PageContext.create(callable, LIST_RECOGNIZERS_PAGE_STR_DESC, request, context);
              return ListRecognizersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
      LIST_CUSTOM_CLASSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCustomClassesRequest,
              ListCustomClassesResponse,
              ListCustomClassesPagedResponse>() {
            @Override
            public ApiFuture<ListCustomClassesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCustomClassesRequest, ListCustomClassesResponse> callable,
                ListCustomClassesRequest request,
                ApiCallContext context,
                ApiFuture<ListCustomClassesResponse> futureResponse) {
              PageContext<ListCustomClassesRequest, ListCustomClassesResponse, CustomClass>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CUSTOM_CLASSES_PAGE_STR_DESC, request, context);
              return ListCustomClassesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPhraseSetsRequest, ListPhraseSetsResponse, ListPhraseSetsPagedResponse>
      LIST_PHRASE_SETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPhraseSetsRequest, ListPhraseSetsResponse, ListPhraseSetsPagedResponse>() {
            @Override
            public ApiFuture<ListPhraseSetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPhraseSetsRequest, ListPhraseSetsResponse> callable,
                ListPhraseSetsRequest request,
                ApiCallContext context,
                ApiFuture<ListPhraseSetsResponse> futureResponse) {
              PageContext<ListPhraseSetsRequest, ListPhraseSetsResponse, PhraseSet> pageContext =
                  PageContext.create(callable, LIST_PHRASE_SETS_PAGE_STR_DESC, request, context);
              return ListPhraseSetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createRecognizer. */
  public UnaryCallSettings<CreateRecognizerRequest, Operation> createRecognizerSettings() {
    return createRecognizerSettings;
  }

  /** Returns the object with the settings used for calls to createRecognizer. */
  public OperationCallSettings<CreateRecognizerRequest, Recognizer, OperationMetadata>
      createRecognizerOperationSettings() {
    return createRecognizerOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRecognizers. */
  public PagedCallSettings<
          ListRecognizersRequest, ListRecognizersResponse, ListRecognizersPagedResponse>
      listRecognizersSettings() {
    return listRecognizersSettings;
  }

  /** Returns the object with the settings used for calls to getRecognizer. */
  public UnaryCallSettings<GetRecognizerRequest, Recognizer> getRecognizerSettings() {
    return getRecognizerSettings;
  }

  /** Returns the object with the settings used for calls to updateRecognizer. */
  public UnaryCallSettings<UpdateRecognizerRequest, Operation> updateRecognizerSettings() {
    return updateRecognizerSettings;
  }

  /** Returns the object with the settings used for calls to updateRecognizer. */
  public OperationCallSettings<UpdateRecognizerRequest, Recognizer, OperationMetadata>
      updateRecognizerOperationSettings() {
    return updateRecognizerOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteRecognizer. */
  public UnaryCallSettings<DeleteRecognizerRequest, Operation> deleteRecognizerSettings() {
    return deleteRecognizerSettings;
  }

  /** Returns the object with the settings used for calls to deleteRecognizer. */
  public OperationCallSettings<DeleteRecognizerRequest, Recognizer, OperationMetadata>
      deleteRecognizerOperationSettings() {
    return deleteRecognizerOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeleteRecognizer. */
  public UnaryCallSettings<UndeleteRecognizerRequest, Operation> undeleteRecognizerSettings() {
    return undeleteRecognizerSettings;
  }

  /** Returns the object with the settings used for calls to undeleteRecognizer. */
  public OperationCallSettings<UndeleteRecognizerRequest, Recognizer, OperationMetadata>
      undeleteRecognizerOperationSettings() {
    return undeleteRecognizerOperationSettings;
  }

  /** Returns the object with the settings used for calls to recognize. */
  public UnaryCallSettings<RecognizeRequest, RecognizeResponse> recognizeSettings() {
    return recognizeSettings;
  }

  /** Returns the object with the settings used for calls to streamingRecognize. */
  public StreamingCallSettings<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeSettings() {
    return streamingRecognizeSettings;
  }

  /** Returns the object with the settings used for calls to batchRecognize. */
  public UnaryCallSettings<BatchRecognizeRequest, Operation> batchRecognizeSettings() {
    return batchRecognizeSettings;
  }

  /** Returns the object with the settings used for calls to batchRecognize. */
  public OperationCallSettings<BatchRecognizeRequest, BatchRecognizeResponse, OperationMetadata>
      batchRecognizeOperationSettings() {
    return batchRecognizeOperationSettings;
  }

  /** Returns the object with the settings used for calls to getConfig. */
  public UnaryCallSettings<GetConfigRequest, Config> getConfigSettings() {
    return getConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateConfig. */
  public UnaryCallSettings<UpdateConfigRequest, Config> updateConfigSettings() {
    return updateConfigSettings;
  }

  /** Returns the object with the settings used for calls to createCustomClass. */
  public UnaryCallSettings<CreateCustomClassRequest, Operation> createCustomClassSettings() {
    return createCustomClassSettings;
  }

  /** Returns the object with the settings used for calls to createCustomClass. */
  public OperationCallSettings<CreateCustomClassRequest, CustomClass, OperationMetadata>
      createCustomClassOperationSettings() {
    return createCustomClassOperationSettings;
  }

  /** Returns the object with the settings used for calls to listCustomClasses. */
  public PagedCallSettings<
          ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
      listCustomClassesSettings() {
    return listCustomClassesSettings;
  }

  /** Returns the object with the settings used for calls to getCustomClass. */
  public UnaryCallSettings<GetCustomClassRequest, CustomClass> getCustomClassSettings() {
    return getCustomClassSettings;
  }

  /** Returns the object with the settings used for calls to updateCustomClass. */
  public UnaryCallSettings<UpdateCustomClassRequest, Operation> updateCustomClassSettings() {
    return updateCustomClassSettings;
  }

  /** Returns the object with the settings used for calls to updateCustomClass. */
  public OperationCallSettings<UpdateCustomClassRequest, CustomClass, OperationMetadata>
      updateCustomClassOperationSettings() {
    return updateCustomClassOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCustomClass. */
  public UnaryCallSettings<DeleteCustomClassRequest, Operation> deleteCustomClassSettings() {
    return deleteCustomClassSettings;
  }

  /** Returns the object with the settings used for calls to deleteCustomClass. */
  public OperationCallSettings<DeleteCustomClassRequest, CustomClass, OperationMetadata>
      deleteCustomClassOperationSettings() {
    return deleteCustomClassOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeleteCustomClass. */
  public UnaryCallSettings<UndeleteCustomClassRequest, Operation> undeleteCustomClassSettings() {
    return undeleteCustomClassSettings;
  }

  /** Returns the object with the settings used for calls to undeleteCustomClass. */
  public OperationCallSettings<UndeleteCustomClassRequest, CustomClass, OperationMetadata>
      undeleteCustomClassOperationSettings() {
    return undeleteCustomClassOperationSettings;
  }

  /** Returns the object with the settings used for calls to createPhraseSet. */
  public UnaryCallSettings<CreatePhraseSetRequest, Operation> createPhraseSetSettings() {
    return createPhraseSetSettings;
  }

  /** Returns the object with the settings used for calls to createPhraseSet. */
  public OperationCallSettings<CreatePhraseSetRequest, PhraseSet, OperationMetadata>
      createPhraseSetOperationSettings() {
    return createPhraseSetOperationSettings;
  }

  /** Returns the object with the settings used for calls to listPhraseSets. */
  public PagedCallSettings<
          ListPhraseSetsRequest, ListPhraseSetsResponse, ListPhraseSetsPagedResponse>
      listPhraseSetsSettings() {
    return listPhraseSetsSettings;
  }

  /** Returns the object with the settings used for calls to getPhraseSet. */
  public UnaryCallSettings<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings() {
    return getPhraseSetSettings;
  }

  /** Returns the object with the settings used for calls to updatePhraseSet. */
  public UnaryCallSettings<UpdatePhraseSetRequest, Operation> updatePhraseSetSettings() {
    return updatePhraseSetSettings;
  }

  /** Returns the object with the settings used for calls to updatePhraseSet. */
  public OperationCallSettings<UpdatePhraseSetRequest, PhraseSet, OperationMetadata>
      updatePhraseSetOperationSettings() {
    return updatePhraseSetOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePhraseSet. */
  public UnaryCallSettings<DeletePhraseSetRequest, Operation> deletePhraseSetSettings() {
    return deletePhraseSetSettings;
  }

  /** Returns the object with the settings used for calls to deletePhraseSet. */
  public OperationCallSettings<DeletePhraseSetRequest, PhraseSet, OperationMetadata>
      deletePhraseSetOperationSettings() {
    return deletePhraseSetOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeletePhraseSet. */
  public UnaryCallSettings<UndeletePhraseSetRequest, Operation> undeletePhraseSetSettings() {
    return undeletePhraseSetSettings;
  }

  /** Returns the object with the settings used for calls to undeletePhraseSet. */
  public OperationCallSettings<UndeletePhraseSetRequest, PhraseSet, OperationMetadata>
      undeletePhraseSetOperationSettings() {
    return undeletePhraseSetOperationSettings;
  }

  public SpeechStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSpeechStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSpeechStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "speech.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "speech.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(SpeechStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(SpeechStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SpeechStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SpeechStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createRecognizerSettings = settingsBuilder.createRecognizerSettings().build();
    createRecognizerOperationSettings = settingsBuilder.createRecognizerOperationSettings().build();
    listRecognizersSettings = settingsBuilder.listRecognizersSettings().build();
    getRecognizerSettings = settingsBuilder.getRecognizerSettings().build();
    updateRecognizerSettings = settingsBuilder.updateRecognizerSettings().build();
    updateRecognizerOperationSettings = settingsBuilder.updateRecognizerOperationSettings().build();
    deleteRecognizerSettings = settingsBuilder.deleteRecognizerSettings().build();
    deleteRecognizerOperationSettings = settingsBuilder.deleteRecognizerOperationSettings().build();
    undeleteRecognizerSettings = settingsBuilder.undeleteRecognizerSettings().build();
    undeleteRecognizerOperationSettings =
        settingsBuilder.undeleteRecognizerOperationSettings().build();
    recognizeSettings = settingsBuilder.recognizeSettings().build();
    streamingRecognizeSettings = settingsBuilder.streamingRecognizeSettings().build();
    batchRecognizeSettings = settingsBuilder.batchRecognizeSettings().build();
    batchRecognizeOperationSettings = settingsBuilder.batchRecognizeOperationSettings().build();
    getConfigSettings = settingsBuilder.getConfigSettings().build();
    updateConfigSettings = settingsBuilder.updateConfigSettings().build();
    createCustomClassSettings = settingsBuilder.createCustomClassSettings().build();
    createCustomClassOperationSettings =
        settingsBuilder.createCustomClassOperationSettings().build();
    listCustomClassesSettings = settingsBuilder.listCustomClassesSettings().build();
    getCustomClassSettings = settingsBuilder.getCustomClassSettings().build();
    updateCustomClassSettings = settingsBuilder.updateCustomClassSettings().build();
    updateCustomClassOperationSettings =
        settingsBuilder.updateCustomClassOperationSettings().build();
    deleteCustomClassSettings = settingsBuilder.deleteCustomClassSettings().build();
    deleteCustomClassOperationSettings =
        settingsBuilder.deleteCustomClassOperationSettings().build();
    undeleteCustomClassSettings = settingsBuilder.undeleteCustomClassSettings().build();
    undeleteCustomClassOperationSettings =
        settingsBuilder.undeleteCustomClassOperationSettings().build();
    createPhraseSetSettings = settingsBuilder.createPhraseSetSettings().build();
    createPhraseSetOperationSettings = settingsBuilder.createPhraseSetOperationSettings().build();
    listPhraseSetsSettings = settingsBuilder.listPhraseSetsSettings().build();
    getPhraseSetSettings = settingsBuilder.getPhraseSetSettings().build();
    updatePhraseSetSettings = settingsBuilder.updatePhraseSetSettings().build();
    updatePhraseSetOperationSettings = settingsBuilder.updatePhraseSetOperationSettings().build();
    deletePhraseSetSettings = settingsBuilder.deletePhraseSetSettings().build();
    deletePhraseSetOperationSettings = settingsBuilder.deletePhraseSetOperationSettings().build();
    undeletePhraseSetSettings = settingsBuilder.undeletePhraseSetSettings().build();
    undeletePhraseSetOperationSettings =
        settingsBuilder.undeletePhraseSetOperationSettings().build();
  }

  /** Builder for SpeechStubSettings. */
  public static class Builder extends StubSettings.Builder<SpeechStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateRecognizerRequest, Operation>
        createRecognizerSettings;
    private final OperationCallSettings.Builder<
            CreateRecognizerRequest, Recognizer, OperationMetadata>
        createRecognizerOperationSettings;
    private final PagedCallSettings.Builder<
            ListRecognizersRequest, ListRecognizersResponse, ListRecognizersPagedResponse>
        listRecognizersSettings;
    private final UnaryCallSettings.Builder<GetRecognizerRequest, Recognizer> getRecognizerSettings;
    private final UnaryCallSettings.Builder<UpdateRecognizerRequest, Operation>
        updateRecognizerSettings;
    private final OperationCallSettings.Builder<
            UpdateRecognizerRequest, Recognizer, OperationMetadata>
        updateRecognizerOperationSettings;
    private final UnaryCallSettings.Builder<DeleteRecognizerRequest, Operation>
        deleteRecognizerSettings;
    private final OperationCallSettings.Builder<
            DeleteRecognizerRequest, Recognizer, OperationMetadata>
        deleteRecognizerOperationSettings;
    private final UnaryCallSettings.Builder<UndeleteRecognizerRequest, Operation>
        undeleteRecognizerSettings;
    private final OperationCallSettings.Builder<
            UndeleteRecognizerRequest, Recognizer, OperationMetadata>
        undeleteRecognizerOperationSettings;
    private final UnaryCallSettings.Builder<RecognizeRequest, RecognizeResponse> recognizeSettings;
    private final StreamingCallSettings.Builder<
            StreamingRecognizeRequest, StreamingRecognizeResponse>
        streamingRecognizeSettings;
    private final UnaryCallSettings.Builder<BatchRecognizeRequest, Operation>
        batchRecognizeSettings;
    private final OperationCallSettings.Builder<
            BatchRecognizeRequest, BatchRecognizeResponse, OperationMetadata>
        batchRecognizeOperationSettings;
    private final UnaryCallSettings.Builder<GetConfigRequest, Config> getConfigSettings;
    private final UnaryCallSettings.Builder<UpdateConfigRequest, Config> updateConfigSettings;
    private final UnaryCallSettings.Builder<CreateCustomClassRequest, Operation>
        createCustomClassSettings;
    private final OperationCallSettings.Builder<
            CreateCustomClassRequest, CustomClass, OperationMetadata>
        createCustomClassOperationSettings;
    private final PagedCallSettings.Builder<
            ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
        listCustomClassesSettings;
    private final UnaryCallSettings.Builder<GetCustomClassRequest, CustomClass>
        getCustomClassSettings;
    private final UnaryCallSettings.Builder<UpdateCustomClassRequest, Operation>
        updateCustomClassSettings;
    private final OperationCallSettings.Builder<
            UpdateCustomClassRequest, CustomClass, OperationMetadata>
        updateCustomClassOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCustomClassRequest, Operation>
        deleteCustomClassSettings;
    private final OperationCallSettings.Builder<
            DeleteCustomClassRequest, CustomClass, OperationMetadata>
        deleteCustomClassOperationSettings;
    private final UnaryCallSettings.Builder<UndeleteCustomClassRequest, Operation>
        undeleteCustomClassSettings;
    private final OperationCallSettings.Builder<
            UndeleteCustomClassRequest, CustomClass, OperationMetadata>
        undeleteCustomClassOperationSettings;
    private final UnaryCallSettings.Builder<CreatePhraseSetRequest, Operation>
        createPhraseSetSettings;
    private final OperationCallSettings.Builder<
            CreatePhraseSetRequest, PhraseSet, OperationMetadata>
        createPhraseSetOperationSettings;
    private final PagedCallSettings.Builder<
            ListPhraseSetsRequest, ListPhraseSetsResponse, ListPhraseSetsPagedResponse>
        listPhraseSetsSettings;
    private final UnaryCallSettings.Builder<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings;
    private final UnaryCallSettings.Builder<UpdatePhraseSetRequest, Operation>
        updatePhraseSetSettings;
    private final OperationCallSettings.Builder<
            UpdatePhraseSetRequest, PhraseSet, OperationMetadata>
        updatePhraseSetOperationSettings;
    private final UnaryCallSettings.Builder<DeletePhraseSetRequest, Operation>
        deletePhraseSetSettings;
    private final OperationCallSettings.Builder<
            DeletePhraseSetRequest, PhraseSet, OperationMetadata>
        deletePhraseSetOperationSettings;
    private final UnaryCallSettings.Builder<UndeletePhraseSetRequest, Operation>
        undeletePhraseSetSettings;
    private final OperationCallSettings.Builder<
            UndeletePhraseSetRequest, PhraseSet, OperationMetadata>
        undeletePhraseSetOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(5000000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(5000000L))
              .setTotalTimeout(Duration.ofMillis(5000000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createRecognizerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRecognizerOperationSettings = OperationCallSettings.newBuilder();
      listRecognizersSettings = PagedCallSettings.newBuilder(LIST_RECOGNIZERS_PAGE_STR_FACT);
      getRecognizerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRecognizerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRecognizerOperationSettings = OperationCallSettings.newBuilder();
      deleteRecognizerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRecognizerOperationSettings = OperationCallSettings.newBuilder();
      undeleteRecognizerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteRecognizerOperationSettings = OperationCallSettings.newBuilder();
      recognizeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      streamingRecognizeSettings = StreamingCallSettings.newBuilder();
      batchRecognizeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRecognizeOperationSettings = OperationCallSettings.newBuilder();
      getConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCustomClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCustomClassOperationSettings = OperationCallSettings.newBuilder();
      listCustomClassesSettings = PagedCallSettings.newBuilder(LIST_CUSTOM_CLASSES_PAGE_STR_FACT);
      getCustomClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCustomClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCustomClassOperationSettings = OperationCallSettings.newBuilder();
      deleteCustomClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCustomClassOperationSettings = OperationCallSettings.newBuilder();
      undeleteCustomClassSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteCustomClassOperationSettings = OperationCallSettings.newBuilder();
      createPhraseSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPhraseSetOperationSettings = OperationCallSettings.newBuilder();
      listPhraseSetsSettings = PagedCallSettings.newBuilder(LIST_PHRASE_SETS_PAGE_STR_FACT);
      getPhraseSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePhraseSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePhraseSetOperationSettings = OperationCallSettings.newBuilder();
      deletePhraseSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePhraseSetOperationSettings = OperationCallSettings.newBuilder();
      undeletePhraseSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeletePhraseSetOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRecognizerSettings,
              listRecognizersSettings,
              getRecognizerSettings,
              updateRecognizerSettings,
              deleteRecognizerSettings,
              undeleteRecognizerSettings,
              recognizeSettings,
              batchRecognizeSettings,
              getConfigSettings,
              updateConfigSettings,
              createCustomClassSettings,
              listCustomClassesSettings,
              getCustomClassSettings,
              updateCustomClassSettings,
              deleteCustomClassSettings,
              undeleteCustomClassSettings,
              createPhraseSetSettings,
              listPhraseSetsSettings,
              getPhraseSetSettings,
              updatePhraseSetSettings,
              deletePhraseSetSettings,
              undeletePhraseSetSettings);
      initDefaults(this);
    }

    protected Builder(SpeechStubSettings settings) {
      super(settings);

      createRecognizerSettings = settings.createRecognizerSettings.toBuilder();
      createRecognizerOperationSettings = settings.createRecognizerOperationSettings.toBuilder();
      listRecognizersSettings = settings.listRecognizersSettings.toBuilder();
      getRecognizerSettings = settings.getRecognizerSettings.toBuilder();
      updateRecognizerSettings = settings.updateRecognizerSettings.toBuilder();
      updateRecognizerOperationSettings = settings.updateRecognizerOperationSettings.toBuilder();
      deleteRecognizerSettings = settings.deleteRecognizerSettings.toBuilder();
      deleteRecognizerOperationSettings = settings.deleteRecognizerOperationSettings.toBuilder();
      undeleteRecognizerSettings = settings.undeleteRecognizerSettings.toBuilder();
      undeleteRecognizerOperationSettings =
          settings.undeleteRecognizerOperationSettings.toBuilder();
      recognizeSettings = settings.recognizeSettings.toBuilder();
      streamingRecognizeSettings = settings.streamingRecognizeSettings.toBuilder();
      batchRecognizeSettings = settings.batchRecognizeSettings.toBuilder();
      batchRecognizeOperationSettings = settings.batchRecognizeOperationSettings.toBuilder();
      getConfigSettings = settings.getConfigSettings.toBuilder();
      updateConfigSettings = settings.updateConfigSettings.toBuilder();
      createCustomClassSettings = settings.createCustomClassSettings.toBuilder();
      createCustomClassOperationSettings = settings.createCustomClassOperationSettings.toBuilder();
      listCustomClassesSettings = settings.listCustomClassesSettings.toBuilder();
      getCustomClassSettings = settings.getCustomClassSettings.toBuilder();
      updateCustomClassSettings = settings.updateCustomClassSettings.toBuilder();
      updateCustomClassOperationSettings = settings.updateCustomClassOperationSettings.toBuilder();
      deleteCustomClassSettings = settings.deleteCustomClassSettings.toBuilder();
      deleteCustomClassOperationSettings = settings.deleteCustomClassOperationSettings.toBuilder();
      undeleteCustomClassSettings = settings.undeleteCustomClassSettings.toBuilder();
      undeleteCustomClassOperationSettings =
          settings.undeleteCustomClassOperationSettings.toBuilder();
      createPhraseSetSettings = settings.createPhraseSetSettings.toBuilder();
      createPhraseSetOperationSettings = settings.createPhraseSetOperationSettings.toBuilder();
      listPhraseSetsSettings = settings.listPhraseSetsSettings.toBuilder();
      getPhraseSetSettings = settings.getPhraseSetSettings.toBuilder();
      updatePhraseSetSettings = settings.updatePhraseSetSettings.toBuilder();
      updatePhraseSetOperationSettings = settings.updatePhraseSetOperationSettings.toBuilder();
      deletePhraseSetSettings = settings.deletePhraseSetSettings.toBuilder();
      deletePhraseSetOperationSettings = settings.deletePhraseSetOperationSettings.toBuilder();
      undeletePhraseSetSettings = settings.undeletePhraseSetSettings.toBuilder();
      undeletePhraseSetOperationSettings = settings.undeletePhraseSetOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRecognizerSettings,
              listRecognizersSettings,
              getRecognizerSettings,
              updateRecognizerSettings,
              deleteRecognizerSettings,
              undeleteRecognizerSettings,
              recognizeSettings,
              batchRecognizeSettings,
              getConfigSettings,
              updateConfigSettings,
              createCustomClassSettings,
              listCustomClassesSettings,
              getCustomClassSettings,
              updateCustomClassSettings,
              deleteCustomClassSettings,
              undeleteCustomClassSettings,
              createPhraseSetSettings,
              listPhraseSetsSettings,
              getPhraseSetSettings,
              updatePhraseSetSettings,
              deletePhraseSetSettings,
              undeletePhraseSetSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createRecognizerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRecognizersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getRecognizerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateRecognizerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteRecognizerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeleteRecognizerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .recognizeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchRecognizeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCustomClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCustomClassesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCustomClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCustomClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCustomClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeleteCustomClassSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPhraseSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPhraseSetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPhraseSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePhraseSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePhraseSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeletePhraseSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createRecognizerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateRecognizerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Recognizer.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateRecognizerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateRecognizerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Recognizer.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteRecognizerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteRecognizerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Recognizer.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .undeleteRecognizerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeleteRecognizerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Recognizer.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .batchRecognizeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchRecognizeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BatchRecognizeResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createCustomClassOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCustomClassRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CustomClass.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateCustomClassOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCustomClassRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CustomClass.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteCustomClassOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCustomClassRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CustomClass.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .undeleteCustomClassOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeleteCustomClassRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CustomClass.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createPhraseSetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePhraseSetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PhraseSet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updatePhraseSetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePhraseSetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PhraseSet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deletePhraseSetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePhraseSetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PhraseSet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .undeletePhraseSetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeletePhraseSetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PhraseSet.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createRecognizer. */
    public UnaryCallSettings.Builder<CreateRecognizerRequest, Operation>
        createRecognizerSettings() {
      return createRecognizerSettings;
    }

    /** Returns the builder for the settings used for calls to createRecognizer. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateRecognizerRequest, Recognizer, OperationMetadata>
        createRecognizerOperationSettings() {
      return createRecognizerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRecognizers. */
    public PagedCallSettings.Builder<
            ListRecognizersRequest, ListRecognizersResponse, ListRecognizersPagedResponse>
        listRecognizersSettings() {
      return listRecognizersSettings;
    }

    /** Returns the builder for the settings used for calls to getRecognizer. */
    public UnaryCallSettings.Builder<GetRecognizerRequest, Recognizer> getRecognizerSettings() {
      return getRecognizerSettings;
    }

    /** Returns the builder for the settings used for calls to updateRecognizer. */
    public UnaryCallSettings.Builder<UpdateRecognizerRequest, Operation>
        updateRecognizerSettings() {
      return updateRecognizerSettings;
    }

    /** Returns the builder for the settings used for calls to updateRecognizer. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateRecognizerRequest, Recognizer, OperationMetadata>
        updateRecognizerOperationSettings() {
      return updateRecognizerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRecognizer. */
    public UnaryCallSettings.Builder<DeleteRecognizerRequest, Operation>
        deleteRecognizerSettings() {
      return deleteRecognizerSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRecognizer. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteRecognizerRequest, Recognizer, OperationMetadata>
        deleteRecognizerOperationSettings() {
      return deleteRecognizerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteRecognizer. */
    public UnaryCallSettings.Builder<UndeleteRecognizerRequest, Operation>
        undeleteRecognizerSettings() {
      return undeleteRecognizerSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteRecognizer. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UndeleteRecognizerRequest, Recognizer, OperationMetadata>
        undeleteRecognizerOperationSettings() {
      return undeleteRecognizerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to recognize. */
    public UnaryCallSettings.Builder<RecognizeRequest, RecognizeResponse> recognizeSettings() {
      return recognizeSettings;
    }

    /** Returns the builder for the settings used for calls to streamingRecognize. */
    public StreamingCallSettings.Builder<StreamingRecognizeRequest, StreamingRecognizeResponse>
        streamingRecognizeSettings() {
      return streamingRecognizeSettings;
    }

    /** Returns the builder for the settings used for calls to batchRecognize. */
    public UnaryCallSettings.Builder<BatchRecognizeRequest, Operation> batchRecognizeSettings() {
      return batchRecognizeSettings;
    }

    /** Returns the builder for the settings used for calls to batchRecognize. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchRecognizeRequest, BatchRecognizeResponse, OperationMetadata>
        batchRecognizeOperationSettings() {
      return batchRecognizeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getConfig. */
    public UnaryCallSettings.Builder<GetConfigRequest, Config> getConfigSettings() {
      return getConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateConfig. */
    public UnaryCallSettings.Builder<UpdateConfigRequest, Config> updateConfigSettings() {
      return updateConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createCustomClass. */
    public UnaryCallSettings.Builder<CreateCustomClassRequest, Operation>
        createCustomClassSettings() {
      return createCustomClassSettings;
    }

    /** Returns the builder for the settings used for calls to createCustomClass. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateCustomClassRequest, CustomClass, OperationMetadata>
        createCustomClassOperationSettings() {
      return createCustomClassOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listCustomClasses. */
    public PagedCallSettings.Builder<
            ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
        listCustomClassesSettings() {
      return listCustomClassesSettings;
    }

    /** Returns the builder for the settings used for calls to getCustomClass. */
    public UnaryCallSettings.Builder<GetCustomClassRequest, CustomClass> getCustomClassSettings() {
      return getCustomClassSettings;
    }

    /** Returns the builder for the settings used for calls to updateCustomClass. */
    public UnaryCallSettings.Builder<UpdateCustomClassRequest, Operation>
        updateCustomClassSettings() {
      return updateCustomClassSettings;
    }

    /** Returns the builder for the settings used for calls to updateCustomClass. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateCustomClassRequest, CustomClass, OperationMetadata>
        updateCustomClassOperationSettings() {
      return updateCustomClassOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCustomClass. */
    public UnaryCallSettings.Builder<DeleteCustomClassRequest, Operation>
        deleteCustomClassSettings() {
      return deleteCustomClassSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCustomClass. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteCustomClassRequest, CustomClass, OperationMetadata>
        deleteCustomClassOperationSettings() {
      return deleteCustomClassOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteCustomClass. */
    public UnaryCallSettings.Builder<UndeleteCustomClassRequest, Operation>
        undeleteCustomClassSettings() {
      return undeleteCustomClassSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteCustomClass. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UndeleteCustomClassRequest, CustomClass, OperationMetadata>
        undeleteCustomClassOperationSettings() {
      return undeleteCustomClassOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createPhraseSet. */
    public UnaryCallSettings.Builder<CreatePhraseSetRequest, Operation> createPhraseSetSettings() {
      return createPhraseSetSettings;
    }

    /** Returns the builder for the settings used for calls to createPhraseSet. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreatePhraseSetRequest, PhraseSet, OperationMetadata>
        createPhraseSetOperationSettings() {
      return createPhraseSetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listPhraseSets. */
    public PagedCallSettings.Builder<
            ListPhraseSetsRequest, ListPhraseSetsResponse, ListPhraseSetsPagedResponse>
        listPhraseSetsSettings() {
      return listPhraseSetsSettings;
    }

    /** Returns the builder for the settings used for calls to getPhraseSet. */
    public UnaryCallSettings.Builder<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings() {
      return getPhraseSetSettings;
    }

    /** Returns the builder for the settings used for calls to updatePhraseSet. */
    public UnaryCallSettings.Builder<UpdatePhraseSetRequest, Operation> updatePhraseSetSettings() {
      return updatePhraseSetSettings;
    }

    /** Returns the builder for the settings used for calls to updatePhraseSet. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdatePhraseSetRequest, PhraseSet, OperationMetadata>
        updatePhraseSetOperationSettings() {
      return updatePhraseSetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePhraseSet. */
    public UnaryCallSettings.Builder<DeletePhraseSetRequest, Operation> deletePhraseSetSettings() {
      return deletePhraseSetSettings;
    }

    /** Returns the builder for the settings used for calls to deletePhraseSet. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeletePhraseSetRequest, PhraseSet, OperationMetadata>
        deletePhraseSetOperationSettings() {
      return deletePhraseSetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeletePhraseSet. */
    public UnaryCallSettings.Builder<UndeletePhraseSetRequest, Operation>
        undeletePhraseSetSettings() {
      return undeletePhraseSetSettings;
    }

    /** Returns the builder for the settings used for calls to undeletePhraseSet. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UndeletePhraseSetRequest, PhraseSet, OperationMetadata>
        undeletePhraseSetOperationSettings() {
      return undeletePhraseSetOperationSettings;
    }

    @Override
    public SpeechStubSettings build() throws IOException {
      return new SpeechStubSettings(this);
    }
  }
}
