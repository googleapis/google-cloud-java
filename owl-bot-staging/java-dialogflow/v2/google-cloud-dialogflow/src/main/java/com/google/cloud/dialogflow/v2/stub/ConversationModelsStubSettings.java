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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2.ConversationModel;
import com.google.cloud.dialogflow.v2.ConversationModelEvaluation;
import com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest;
import com.google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationModelRequest;
import com.google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.DeleteConversationModelRequest;
import com.google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.DeployConversationModelRequest;
import com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest;
import com.google.cloud.dialogflow.v2.GetConversationModelRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse;
import com.google.cloud.dialogflow.v2.ListConversationModelsRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelsResponse;
import com.google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.UndeployConversationModelRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link ConversationModelsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getConversationModel to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationModelsStubSettings.Builder conversationModelsSettingsBuilder =
 *     ConversationModelsStubSettings.newBuilder();
 * conversationModelsSettingsBuilder
 *     .getConversationModelSettings()
 *     .setRetrySettings(
 *         conversationModelsSettingsBuilder
 *             .getConversationModelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConversationModelsStubSettings conversationModelsSettings =
 *     conversationModelsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConversationModelsStubSettings extends StubSettings<ConversationModelsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final UnaryCallSettings<CreateConversationModelRequest, Operation>
      createConversationModelSettings;
  private final OperationCallSettings<
          CreateConversationModelRequest,
          ConversationModel,
          CreateConversationModelOperationMetadata>
      createConversationModelOperationSettings;
  private final UnaryCallSettings<GetConversationModelRequest, ConversationModel>
      getConversationModelSettings;
  private final PagedCallSettings<
          ListConversationModelsRequest,
          ListConversationModelsResponse,
          ListConversationModelsPagedResponse>
      listConversationModelsSettings;
  private final UnaryCallSettings<DeleteConversationModelRequest, Operation>
      deleteConversationModelSettings;
  private final OperationCallSettings<
          DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelOperationSettings;
  private final UnaryCallSettings<DeployConversationModelRequest, Operation>
      deployConversationModelSettings;
  private final OperationCallSettings<
          DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
      deployConversationModelOperationSettings;
  private final UnaryCallSettings<UndeployConversationModelRequest, Operation>
      undeployConversationModelSettings;
  private final OperationCallSettings<
          UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
      undeployConversationModelOperationSettings;
  private final UnaryCallSettings<
          GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationSettings;
  private final PagedCallSettings<
          ListConversationModelEvaluationsRequest,
          ListConversationModelEvaluationsResponse,
          ListConversationModelEvaluationsPagedResponse>
      listConversationModelEvaluationsSettings;
  private final UnaryCallSettings<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationSettings;
  private final OperationCallSettings<
          CreateConversationModelEvaluationRequest,
          ConversationModelEvaluation,
          CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListConversationModelsRequest, ListConversationModelsResponse, ConversationModel>
      LIST_CONVERSATION_MODELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConversationModelsRequest, ListConversationModelsResponse, ConversationModel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConversationModelsRequest injectToken(
                ListConversationModelsRequest payload, String token) {
              return ListConversationModelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConversationModelsRequest injectPageSize(
                ListConversationModelsRequest payload, int pageSize) {
              return ListConversationModelsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListConversationModelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConversationModelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConversationModel> extractResources(
                ListConversationModelsResponse payload) {
              return payload.getConversationModelsList() == null
                  ? ImmutableList.<ConversationModel>of()
                  : payload.getConversationModelsList();
            }
          };

  private static final PagedListDescriptor<
          ListConversationModelEvaluationsRequest,
          ListConversationModelEvaluationsResponse,
          ConversationModelEvaluation>
      LIST_CONVERSATION_MODEL_EVALUATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConversationModelEvaluationsRequest,
              ListConversationModelEvaluationsResponse,
              ConversationModelEvaluation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConversationModelEvaluationsRequest injectToken(
                ListConversationModelEvaluationsRequest payload, String token) {
              return ListConversationModelEvaluationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListConversationModelEvaluationsRequest injectPageSize(
                ListConversationModelEvaluationsRequest payload, int pageSize) {
              return ListConversationModelEvaluationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListConversationModelEvaluationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConversationModelEvaluationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConversationModelEvaluation> extractResources(
                ListConversationModelEvaluationsResponse payload) {
              return payload.getConversationModelEvaluationsList() == null
                  ? ImmutableList.<ConversationModelEvaluation>of()
                  : payload.getConversationModelEvaluationsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListConversationModelsRequest,
          ListConversationModelsResponse,
          ListConversationModelsPagedResponse>
      LIST_CONVERSATION_MODELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConversationModelsRequest,
              ListConversationModelsResponse,
              ListConversationModelsPagedResponse>() {
            @Override
            public ApiFuture<ListConversationModelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConversationModelsRequest, ListConversationModelsResponse>
                    callable,
                ListConversationModelsRequest request,
                ApiCallContext context,
                ApiFuture<ListConversationModelsResponse> futureResponse) {
              PageContext<
                      ListConversationModelsRequest,
                      ListConversationModelsResponse,
                      ConversationModel>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONVERSATION_MODELS_PAGE_STR_DESC, request, context);
              return ListConversationModelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConversationModelEvaluationsRequest,
          ListConversationModelEvaluationsResponse,
          ListConversationModelEvaluationsPagedResponse>
      LIST_CONVERSATION_MODEL_EVALUATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConversationModelEvaluationsRequest,
              ListConversationModelEvaluationsResponse,
              ListConversationModelEvaluationsPagedResponse>() {
            @Override
            public ApiFuture<ListConversationModelEvaluationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListConversationModelEvaluationsRequest,
                        ListConversationModelEvaluationsResponse>
                    callable,
                ListConversationModelEvaluationsRequest request,
                ApiCallContext context,
                ApiFuture<ListConversationModelEvaluationsResponse> futureResponse) {
              PageContext<
                      ListConversationModelEvaluationsRequest,
                      ListConversationModelEvaluationsResponse,
                      ConversationModelEvaluation>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_CONVERSATION_MODEL_EVALUATIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListConversationModelEvaluationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createConversationModel. */
  public UnaryCallSettings<CreateConversationModelRequest, Operation>
      createConversationModelSettings() {
    return createConversationModelSettings;
  }

  /** Returns the object with the settings used for calls to createConversationModel. */
  public OperationCallSettings<
          CreateConversationModelRequest,
          ConversationModel,
          CreateConversationModelOperationMetadata>
      createConversationModelOperationSettings() {
    return createConversationModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to getConversationModel. */
  public UnaryCallSettings<GetConversationModelRequest, ConversationModel>
      getConversationModelSettings() {
    return getConversationModelSettings;
  }

  /** Returns the object with the settings used for calls to listConversationModels. */
  public PagedCallSettings<
          ListConversationModelsRequest,
          ListConversationModelsResponse,
          ListConversationModelsPagedResponse>
      listConversationModelsSettings() {
    return listConversationModelsSettings;
  }

  /** Returns the object with the settings used for calls to deleteConversationModel. */
  public UnaryCallSettings<DeleteConversationModelRequest, Operation>
      deleteConversationModelSettings() {
    return deleteConversationModelSettings;
  }

  /** Returns the object with the settings used for calls to deleteConversationModel. */
  public OperationCallSettings<
          DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelOperationSettings() {
    return deleteConversationModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to deployConversationModel. */
  public UnaryCallSettings<DeployConversationModelRequest, Operation>
      deployConversationModelSettings() {
    return deployConversationModelSettings;
  }

  /** Returns the object with the settings used for calls to deployConversationModel. */
  public OperationCallSettings<
          DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
      deployConversationModelOperationSettings() {
    return deployConversationModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeployConversationModel. */
  public UnaryCallSettings<UndeployConversationModelRequest, Operation>
      undeployConversationModelSettings() {
    return undeployConversationModelSettings;
  }

  /** Returns the object with the settings used for calls to undeployConversationModel. */
  public OperationCallSettings<
          UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
      undeployConversationModelOperationSettings() {
    return undeployConversationModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to getConversationModelEvaluation. */
  public UnaryCallSettings<GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationSettings() {
    return getConversationModelEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to listConversationModelEvaluations. */
  public PagedCallSettings<
          ListConversationModelEvaluationsRequest,
          ListConversationModelEvaluationsResponse,
          ListConversationModelEvaluationsPagedResponse>
      listConversationModelEvaluationsSettings() {
    return listConversationModelEvaluationsSettings;
  }

  /** Returns the object with the settings used for calls to createConversationModelEvaluation. */
  public UnaryCallSettings<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationSettings() {
    return createConversationModelEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to createConversationModelEvaluation. */
  public OperationCallSettings<
          CreateConversationModelEvaluationRequest,
          ConversationModelEvaluation,
          CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationOperationSettings() {
    return createConversationModelEvaluationOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public ConversationModelsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConversationModelsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonConversationModelsStub.create(this);
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
    return "dialogflow.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dialogflow.mtls.googleapis.com:443";
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ConversationModelsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ConversationModelsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConversationModelsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ConversationModelsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createConversationModelSettings = settingsBuilder.createConversationModelSettings().build();
    createConversationModelOperationSettings =
        settingsBuilder.createConversationModelOperationSettings().build();
    getConversationModelSettings = settingsBuilder.getConversationModelSettings().build();
    listConversationModelsSettings = settingsBuilder.listConversationModelsSettings().build();
    deleteConversationModelSettings = settingsBuilder.deleteConversationModelSettings().build();
    deleteConversationModelOperationSettings =
        settingsBuilder.deleteConversationModelOperationSettings().build();
    deployConversationModelSettings = settingsBuilder.deployConversationModelSettings().build();
    deployConversationModelOperationSettings =
        settingsBuilder.deployConversationModelOperationSettings().build();
    undeployConversationModelSettings = settingsBuilder.undeployConversationModelSettings().build();
    undeployConversationModelOperationSettings =
        settingsBuilder.undeployConversationModelOperationSettings().build();
    getConversationModelEvaluationSettings =
        settingsBuilder.getConversationModelEvaluationSettings().build();
    listConversationModelEvaluationsSettings =
        settingsBuilder.listConversationModelEvaluationsSettings().build();
    createConversationModelEvaluationSettings =
        settingsBuilder.createConversationModelEvaluationSettings().build();
    createConversationModelEvaluationOperationSettings =
        settingsBuilder.createConversationModelEvaluationOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ConversationModelsStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ConversationModelsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateConversationModelRequest, Operation>
        createConversationModelSettings;
    private final OperationCallSettings.Builder<
            CreateConversationModelRequest,
            ConversationModel,
            CreateConversationModelOperationMetadata>
        createConversationModelOperationSettings;
    private final UnaryCallSettings.Builder<GetConversationModelRequest, ConversationModel>
        getConversationModelSettings;
    private final PagedCallSettings.Builder<
            ListConversationModelsRequest,
            ListConversationModelsResponse,
            ListConversationModelsPagedResponse>
        listConversationModelsSettings;
    private final UnaryCallSettings.Builder<DeleteConversationModelRequest, Operation>
        deleteConversationModelSettings;
    private final OperationCallSettings.Builder<
            DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
        deleteConversationModelOperationSettings;
    private final UnaryCallSettings.Builder<DeployConversationModelRequest, Operation>
        deployConversationModelSettings;
    private final OperationCallSettings.Builder<
            DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
        deployConversationModelOperationSettings;
    private final UnaryCallSettings.Builder<UndeployConversationModelRequest, Operation>
        undeployConversationModelSettings;
    private final OperationCallSettings.Builder<
            UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
        undeployConversationModelOperationSettings;
    private final UnaryCallSettings.Builder<
            GetConversationModelEvaluationRequest, ConversationModelEvaluation>
        getConversationModelEvaluationSettings;
    private final PagedCallSettings.Builder<
            ListConversationModelEvaluationsRequest,
            ListConversationModelEvaluationsResponse,
            ListConversationModelEvaluationsPagedResponse>
        listConversationModelEvaluationsSettings;
    private final UnaryCallSettings.Builder<CreateConversationModelEvaluationRequest, Operation>
        createConversationModelEvaluationSettings;
    private final OperationCallSettings.Builder<
            CreateConversationModelEvaluationRequest,
            ConversationModelEvaluation,
            CreateConversationModelEvaluationOperationMetadata>
        createConversationModelEvaluationOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createConversationModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConversationModelOperationSettings = OperationCallSettings.newBuilder();
      getConversationModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConversationModelsSettings =
          PagedCallSettings.newBuilder(LIST_CONVERSATION_MODELS_PAGE_STR_FACT);
      deleteConversationModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConversationModelOperationSettings = OperationCallSettings.newBuilder();
      deployConversationModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deployConversationModelOperationSettings = OperationCallSettings.newBuilder();
      undeployConversationModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeployConversationModelOperationSettings = OperationCallSettings.newBuilder();
      getConversationModelEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConversationModelEvaluationsSettings =
          PagedCallSettings.newBuilder(LIST_CONVERSATION_MODEL_EVALUATIONS_PAGE_STR_FACT);
      createConversationModelEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConversationModelEvaluationOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConversationModelSettings,
              getConversationModelSettings,
              listConversationModelsSettings,
              deleteConversationModelSettings,
              deployConversationModelSettings,
              undeployConversationModelSettings,
              getConversationModelEvaluationSettings,
              listConversationModelEvaluationsSettings,
              createConversationModelEvaluationSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ConversationModelsStubSettings settings) {
      super(settings);

      createConversationModelSettings = settings.createConversationModelSettings.toBuilder();
      createConversationModelOperationSettings =
          settings.createConversationModelOperationSettings.toBuilder();
      getConversationModelSettings = settings.getConversationModelSettings.toBuilder();
      listConversationModelsSettings = settings.listConversationModelsSettings.toBuilder();
      deleteConversationModelSettings = settings.deleteConversationModelSettings.toBuilder();
      deleteConversationModelOperationSettings =
          settings.deleteConversationModelOperationSettings.toBuilder();
      deployConversationModelSettings = settings.deployConversationModelSettings.toBuilder();
      deployConversationModelOperationSettings =
          settings.deployConversationModelOperationSettings.toBuilder();
      undeployConversationModelSettings = settings.undeployConversationModelSettings.toBuilder();
      undeployConversationModelOperationSettings =
          settings.undeployConversationModelOperationSettings.toBuilder();
      getConversationModelEvaluationSettings =
          settings.getConversationModelEvaluationSettings.toBuilder();
      listConversationModelEvaluationsSettings =
          settings.listConversationModelEvaluationsSettings.toBuilder();
      createConversationModelEvaluationSettings =
          settings.createConversationModelEvaluationSettings.toBuilder();
      createConversationModelEvaluationOperationSettings =
          settings.createConversationModelEvaluationOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConversationModelSettings,
              getConversationModelSettings,
              listConversationModelsSettings,
              deleteConversationModelSettings,
              deployConversationModelSettings,
              undeployConversationModelSettings,
              getConversationModelEvaluationSettings,
              listConversationModelEvaluationsSettings,
              createConversationModelEvaluationSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .createConversationModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConversationModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConversationModelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteConversationModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deployConversationModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeployConversationModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConversationModelEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConversationModelEvaluationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createConversationModelEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createConversationModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConversationModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConversationModel.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateConversationModelOperationMetadata.class))
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
          .deleteConversationModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteConversationModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteConversationModelOperationMetadata.class))
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
          .deployConversationModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeployConversationModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeployConversationModelOperationMetadata.class))
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
          .undeployConversationModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeployConversationModelRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UndeployConversationModelOperationMetadata.class))
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
          .createConversationModelEvaluationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConversationModelEvaluationRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ConversationModelEvaluation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateConversationModelEvaluationOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createConversationModel. */
    public UnaryCallSettings.Builder<CreateConversationModelRequest, Operation>
        createConversationModelSettings() {
      return createConversationModelSettings;
    }

    /** Returns the builder for the settings used for calls to createConversationModel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateConversationModelRequest,
            ConversationModel,
            CreateConversationModelOperationMetadata>
        createConversationModelOperationSettings() {
      return createConversationModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getConversationModel. */
    public UnaryCallSettings.Builder<GetConversationModelRequest, ConversationModel>
        getConversationModelSettings() {
      return getConversationModelSettings;
    }

    /** Returns the builder for the settings used for calls to listConversationModels. */
    public PagedCallSettings.Builder<
            ListConversationModelsRequest,
            ListConversationModelsResponse,
            ListConversationModelsPagedResponse>
        listConversationModelsSettings() {
      return listConversationModelsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConversationModel. */
    public UnaryCallSettings.Builder<DeleteConversationModelRequest, Operation>
        deleteConversationModelSettings() {
      return deleteConversationModelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConversationModel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
        deleteConversationModelOperationSettings() {
      return deleteConversationModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deployConversationModel. */
    public UnaryCallSettings.Builder<DeployConversationModelRequest, Operation>
        deployConversationModelSettings() {
      return deployConversationModelSettings;
    }

    /** Returns the builder for the settings used for calls to deployConversationModel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
        deployConversationModelOperationSettings() {
      return deployConversationModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeployConversationModel. */
    public UnaryCallSettings.Builder<UndeployConversationModelRequest, Operation>
        undeployConversationModelSettings() {
      return undeployConversationModelSettings;
    }

    /** Returns the builder for the settings used for calls to undeployConversationModel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
        undeployConversationModelOperationSettings() {
      return undeployConversationModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getConversationModelEvaluation. */
    public UnaryCallSettings.Builder<
            GetConversationModelEvaluationRequest, ConversationModelEvaluation>
        getConversationModelEvaluationSettings() {
      return getConversationModelEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to listConversationModelEvaluations. */
    public PagedCallSettings.Builder<
            ListConversationModelEvaluationsRequest,
            ListConversationModelEvaluationsResponse,
            ListConversationModelEvaluationsPagedResponse>
        listConversationModelEvaluationsSettings() {
      return listConversationModelEvaluationsSettings;
    }

    /** Returns the builder for the settings used for calls to createConversationModelEvaluation. */
    public UnaryCallSettings.Builder<CreateConversationModelEvaluationRequest, Operation>
        createConversationModelEvaluationSettings() {
      return createConversationModelEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to createConversationModelEvaluation. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateConversationModelEvaluationRequest,
            ConversationModelEvaluation,
            CreateConversationModelEvaluationOperationMetadata>
        createConversationModelEvaluationOperationSettings() {
      return createConversationModelEvaluationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public ConversationModelsStubSettings build() throws IOException {
      return new ConversationModelsStubSettings(this);
    }
  }
}
