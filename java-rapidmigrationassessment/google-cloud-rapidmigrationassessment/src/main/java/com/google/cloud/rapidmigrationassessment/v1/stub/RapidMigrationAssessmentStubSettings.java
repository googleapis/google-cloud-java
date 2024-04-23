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

package com.google.cloud.rapidmigrationassessment.v1.stub;

import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListCollectorsPagedResponse;
import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.rapidmigrationassessment.v1.Annotation;
import com.google.cloud.rapidmigrationassessment.v1.Collector;
import com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest;
import com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest;
import com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest;
import com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse;
import com.google.cloud.rapidmigrationassessment.v1.OperationMetadata;
import com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest;
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
 * Settings class to configure an instance of {@link RapidMigrationAssessmentStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (rapidmigrationassessment.googleapis.com) and default port
 *       (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAnnotation to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RapidMigrationAssessmentStubSettings.Builder rapidMigrationAssessmentSettingsBuilder =
 *     RapidMigrationAssessmentStubSettings.newBuilder();
 * rapidMigrationAssessmentSettingsBuilder
 *     .getAnnotationSettings()
 *     .setRetrySettings(
 *         rapidMigrationAssessmentSettingsBuilder
 *             .getAnnotationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RapidMigrationAssessmentStubSettings rapidMigrationAssessmentSettings =
 *     rapidMigrationAssessmentSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RapidMigrationAssessmentStubSettings
    extends StubSettings<RapidMigrationAssessmentStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateCollectorRequest, Operation> createCollectorSettings;
  private final OperationCallSettings<CreateCollectorRequest, Collector, OperationMetadata>
      createCollectorOperationSettings;
  private final UnaryCallSettings<CreateAnnotationRequest, Operation> createAnnotationSettings;
  private final OperationCallSettings<CreateAnnotationRequest, Annotation, OperationMetadata>
      createAnnotationOperationSettings;
  private final UnaryCallSettings<GetAnnotationRequest, Annotation> getAnnotationSettings;
  private final PagedCallSettings<
          ListCollectorsRequest, ListCollectorsResponse, ListCollectorsPagedResponse>
      listCollectorsSettings;
  private final UnaryCallSettings<GetCollectorRequest, Collector> getCollectorSettings;
  private final UnaryCallSettings<UpdateCollectorRequest, Operation> updateCollectorSettings;
  private final OperationCallSettings<UpdateCollectorRequest, Collector, OperationMetadata>
      updateCollectorOperationSettings;
  private final UnaryCallSettings<DeleteCollectorRequest, Operation> deleteCollectorSettings;
  private final OperationCallSettings<DeleteCollectorRequest, Collector, OperationMetadata>
      deleteCollectorOperationSettings;
  private final UnaryCallSettings<ResumeCollectorRequest, Operation> resumeCollectorSettings;
  private final OperationCallSettings<ResumeCollectorRequest, Collector, OperationMetadata>
      resumeCollectorOperationSettings;
  private final UnaryCallSettings<RegisterCollectorRequest, Operation> registerCollectorSettings;
  private final OperationCallSettings<RegisterCollectorRequest, Collector, OperationMetadata>
      registerCollectorOperationSettings;
  private final UnaryCallSettings<PauseCollectorRequest, Operation> pauseCollectorSettings;
  private final OperationCallSettings<PauseCollectorRequest, Collector, OperationMetadata>
      pauseCollectorOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListCollectorsRequest, ListCollectorsResponse, Collector>
      LIST_COLLECTORS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCollectorsRequest, ListCollectorsResponse, Collector>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCollectorsRequest injectToken(ListCollectorsRequest payload, String token) {
              return ListCollectorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCollectorsRequest injectPageSize(
                ListCollectorsRequest payload, int pageSize) {
              return ListCollectorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCollectorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCollectorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Collector> extractResources(ListCollectorsResponse payload) {
              return payload.getCollectorsList() == null
                  ? ImmutableList.<Collector>of()
                  : payload.getCollectorsList();
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
          ListCollectorsRequest, ListCollectorsResponse, ListCollectorsPagedResponse>
      LIST_COLLECTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCollectorsRequest, ListCollectorsResponse, ListCollectorsPagedResponse>() {
            @Override
            public ApiFuture<ListCollectorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCollectorsRequest, ListCollectorsResponse> callable,
                ListCollectorsRequest request,
                ApiCallContext context,
                ApiFuture<ListCollectorsResponse> futureResponse) {
              PageContext<ListCollectorsRequest, ListCollectorsResponse, Collector> pageContext =
                  PageContext.create(callable, LIST_COLLECTORS_PAGE_STR_DESC, request, context);
              return ListCollectorsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createCollector. */
  public UnaryCallSettings<CreateCollectorRequest, Operation> createCollectorSettings() {
    return createCollectorSettings;
  }

  /** Returns the object with the settings used for calls to createCollector. */
  public OperationCallSettings<CreateCollectorRequest, Collector, OperationMetadata>
      createCollectorOperationSettings() {
    return createCollectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to createAnnotation. */
  public UnaryCallSettings<CreateAnnotationRequest, Operation> createAnnotationSettings() {
    return createAnnotationSettings;
  }

  /** Returns the object with the settings used for calls to createAnnotation. */
  public OperationCallSettings<CreateAnnotationRequest, Annotation, OperationMetadata>
      createAnnotationOperationSettings() {
    return createAnnotationOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAnnotation. */
  public UnaryCallSettings<GetAnnotationRequest, Annotation> getAnnotationSettings() {
    return getAnnotationSettings;
  }

  /** Returns the object with the settings used for calls to listCollectors. */
  public PagedCallSettings<
          ListCollectorsRequest, ListCollectorsResponse, ListCollectorsPagedResponse>
      listCollectorsSettings() {
    return listCollectorsSettings;
  }

  /** Returns the object with the settings used for calls to getCollector. */
  public UnaryCallSettings<GetCollectorRequest, Collector> getCollectorSettings() {
    return getCollectorSettings;
  }

  /** Returns the object with the settings used for calls to updateCollector. */
  public UnaryCallSettings<UpdateCollectorRequest, Operation> updateCollectorSettings() {
    return updateCollectorSettings;
  }

  /** Returns the object with the settings used for calls to updateCollector. */
  public OperationCallSettings<UpdateCollectorRequest, Collector, OperationMetadata>
      updateCollectorOperationSettings() {
    return updateCollectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCollector. */
  public UnaryCallSettings<DeleteCollectorRequest, Operation> deleteCollectorSettings() {
    return deleteCollectorSettings;
  }

  /** Returns the object with the settings used for calls to deleteCollector. */
  public OperationCallSettings<DeleteCollectorRequest, Collector, OperationMetadata>
      deleteCollectorOperationSettings() {
    return deleteCollectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to resumeCollector. */
  public UnaryCallSettings<ResumeCollectorRequest, Operation> resumeCollectorSettings() {
    return resumeCollectorSettings;
  }

  /** Returns the object with the settings used for calls to resumeCollector. */
  public OperationCallSettings<ResumeCollectorRequest, Collector, OperationMetadata>
      resumeCollectorOperationSettings() {
    return resumeCollectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to registerCollector. */
  public UnaryCallSettings<RegisterCollectorRequest, Operation> registerCollectorSettings() {
    return registerCollectorSettings;
  }

  /** Returns the object with the settings used for calls to registerCollector. */
  public OperationCallSettings<RegisterCollectorRequest, Collector, OperationMetadata>
      registerCollectorOperationSettings() {
    return registerCollectorOperationSettings;
  }

  /** Returns the object with the settings used for calls to pauseCollector. */
  public UnaryCallSettings<PauseCollectorRequest, Operation> pauseCollectorSettings() {
    return pauseCollectorSettings;
  }

  /** Returns the object with the settings used for calls to pauseCollector. */
  public OperationCallSettings<PauseCollectorRequest, Collector, OperationMetadata>
      pauseCollectorOperationSettings() {
    return pauseCollectorOperationSettings;
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

  public RapidMigrationAssessmentStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcRapidMigrationAssessmentStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRapidMigrationAssessmentStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "rapidmigrationassessment";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "rapidmigrationassessment.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "rapidmigrationassessment.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(RapidMigrationAssessmentStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RapidMigrationAssessmentStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RapidMigrationAssessmentStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected RapidMigrationAssessmentStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createCollectorSettings = settingsBuilder.createCollectorSettings().build();
    createCollectorOperationSettings = settingsBuilder.createCollectorOperationSettings().build();
    createAnnotationSettings = settingsBuilder.createAnnotationSettings().build();
    createAnnotationOperationSettings = settingsBuilder.createAnnotationOperationSettings().build();
    getAnnotationSettings = settingsBuilder.getAnnotationSettings().build();
    listCollectorsSettings = settingsBuilder.listCollectorsSettings().build();
    getCollectorSettings = settingsBuilder.getCollectorSettings().build();
    updateCollectorSettings = settingsBuilder.updateCollectorSettings().build();
    updateCollectorOperationSettings = settingsBuilder.updateCollectorOperationSettings().build();
    deleteCollectorSettings = settingsBuilder.deleteCollectorSettings().build();
    deleteCollectorOperationSettings = settingsBuilder.deleteCollectorOperationSettings().build();
    resumeCollectorSettings = settingsBuilder.resumeCollectorSettings().build();
    resumeCollectorOperationSettings = settingsBuilder.resumeCollectorOperationSettings().build();
    registerCollectorSettings = settingsBuilder.registerCollectorSettings().build();
    registerCollectorOperationSettings =
        settingsBuilder.registerCollectorOperationSettings().build();
    pauseCollectorSettings = settingsBuilder.pauseCollectorSettings().build();
    pauseCollectorOperationSettings = settingsBuilder.pauseCollectorOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for RapidMigrationAssessmentStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RapidMigrationAssessmentStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateCollectorRequest, Operation>
        createCollectorSettings;
    private final OperationCallSettings.Builder<
            CreateCollectorRequest, Collector, OperationMetadata>
        createCollectorOperationSettings;
    private final UnaryCallSettings.Builder<CreateAnnotationRequest, Operation>
        createAnnotationSettings;
    private final OperationCallSettings.Builder<
            CreateAnnotationRequest, Annotation, OperationMetadata>
        createAnnotationOperationSettings;
    private final UnaryCallSettings.Builder<GetAnnotationRequest, Annotation> getAnnotationSettings;
    private final PagedCallSettings.Builder<
            ListCollectorsRequest, ListCollectorsResponse, ListCollectorsPagedResponse>
        listCollectorsSettings;
    private final UnaryCallSettings.Builder<GetCollectorRequest, Collector> getCollectorSettings;
    private final UnaryCallSettings.Builder<UpdateCollectorRequest, Operation>
        updateCollectorSettings;
    private final OperationCallSettings.Builder<
            UpdateCollectorRequest, Collector, OperationMetadata>
        updateCollectorOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCollectorRequest, Operation>
        deleteCollectorSettings;
    private final OperationCallSettings.Builder<
            DeleteCollectorRequest, Collector, OperationMetadata>
        deleteCollectorOperationSettings;
    private final UnaryCallSettings.Builder<ResumeCollectorRequest, Operation>
        resumeCollectorSettings;
    private final OperationCallSettings.Builder<
            ResumeCollectorRequest, Collector, OperationMetadata>
        resumeCollectorOperationSettings;
    private final UnaryCallSettings.Builder<RegisterCollectorRequest, Operation>
        registerCollectorSettings;
    private final OperationCallSettings.Builder<
            RegisterCollectorRequest, Collector, OperationMetadata>
        registerCollectorOperationSettings;
    private final UnaryCallSettings.Builder<PauseCollectorRequest, Operation>
        pauseCollectorSettings;
    private final OperationCallSettings.Builder<PauseCollectorRequest, Collector, OperationMetadata>
        pauseCollectorOperationSettings;
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
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
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

      createCollectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCollectorOperationSettings = OperationCallSettings.newBuilder();
      createAnnotationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAnnotationOperationSettings = OperationCallSettings.newBuilder();
      getAnnotationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCollectorsSettings = PagedCallSettings.newBuilder(LIST_COLLECTORS_PAGE_STR_FACT);
      getCollectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCollectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCollectorOperationSettings = OperationCallSettings.newBuilder();
      deleteCollectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCollectorOperationSettings = OperationCallSettings.newBuilder();
      resumeCollectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeCollectorOperationSettings = OperationCallSettings.newBuilder();
      registerCollectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      registerCollectorOperationSettings = OperationCallSettings.newBuilder();
      pauseCollectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pauseCollectorOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCollectorSettings,
              createAnnotationSettings,
              getAnnotationSettings,
              listCollectorsSettings,
              getCollectorSettings,
              updateCollectorSettings,
              deleteCollectorSettings,
              resumeCollectorSettings,
              registerCollectorSettings,
              pauseCollectorSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(RapidMigrationAssessmentStubSettings settings) {
      super(settings);

      createCollectorSettings = settings.createCollectorSettings.toBuilder();
      createCollectorOperationSettings = settings.createCollectorOperationSettings.toBuilder();
      createAnnotationSettings = settings.createAnnotationSettings.toBuilder();
      createAnnotationOperationSettings = settings.createAnnotationOperationSettings.toBuilder();
      getAnnotationSettings = settings.getAnnotationSettings.toBuilder();
      listCollectorsSettings = settings.listCollectorsSettings.toBuilder();
      getCollectorSettings = settings.getCollectorSettings.toBuilder();
      updateCollectorSettings = settings.updateCollectorSettings.toBuilder();
      updateCollectorOperationSettings = settings.updateCollectorOperationSettings.toBuilder();
      deleteCollectorSettings = settings.deleteCollectorSettings.toBuilder();
      deleteCollectorOperationSettings = settings.deleteCollectorOperationSettings.toBuilder();
      resumeCollectorSettings = settings.resumeCollectorSettings.toBuilder();
      resumeCollectorOperationSettings = settings.resumeCollectorOperationSettings.toBuilder();
      registerCollectorSettings = settings.registerCollectorSettings.toBuilder();
      registerCollectorOperationSettings = settings.registerCollectorOperationSettings.toBuilder();
      pauseCollectorSettings = settings.pauseCollectorSettings.toBuilder();
      pauseCollectorOperationSettings = settings.pauseCollectorOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCollectorSettings,
              createAnnotationSettings,
              getAnnotationSettings,
              listCollectorsSettings,
              getCollectorSettings,
              updateCollectorSettings,
              deleteCollectorSettings,
              resumeCollectorSettings,
              registerCollectorSettings,
              pauseCollectorSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .createCollectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createAnnotationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getAnnotationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCollectorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCollectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCollectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteCollectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resumeCollectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .registerCollectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .pauseCollectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createCollectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCollectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Collector.class))
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
          .createAnnotationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAnnotationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Annotation.class))
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
          .updateCollectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCollectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Collector.class))
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
          .deleteCollectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCollectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Collector.class))
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
          .resumeCollectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResumeCollectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Collector.class))
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
          .registerCollectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RegisterCollectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Collector.class))
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
          .pauseCollectorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PauseCollectorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Collector.class))
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

    /** Returns the builder for the settings used for calls to createCollector. */
    public UnaryCallSettings.Builder<CreateCollectorRequest, Operation> createCollectorSettings() {
      return createCollectorSettings;
    }

    /** Returns the builder for the settings used for calls to createCollector. */
    public OperationCallSettings.Builder<CreateCollectorRequest, Collector, OperationMetadata>
        createCollectorOperationSettings() {
      return createCollectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createAnnotation. */
    public UnaryCallSettings.Builder<CreateAnnotationRequest, Operation>
        createAnnotationSettings() {
      return createAnnotationSettings;
    }

    /** Returns the builder for the settings used for calls to createAnnotation. */
    public OperationCallSettings.Builder<CreateAnnotationRequest, Annotation, OperationMetadata>
        createAnnotationOperationSettings() {
      return createAnnotationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAnnotation. */
    public UnaryCallSettings.Builder<GetAnnotationRequest, Annotation> getAnnotationSettings() {
      return getAnnotationSettings;
    }

    /** Returns the builder for the settings used for calls to listCollectors. */
    public PagedCallSettings.Builder<
            ListCollectorsRequest, ListCollectorsResponse, ListCollectorsPagedResponse>
        listCollectorsSettings() {
      return listCollectorsSettings;
    }

    /** Returns the builder for the settings used for calls to getCollector. */
    public UnaryCallSettings.Builder<GetCollectorRequest, Collector> getCollectorSettings() {
      return getCollectorSettings;
    }

    /** Returns the builder for the settings used for calls to updateCollector. */
    public UnaryCallSettings.Builder<UpdateCollectorRequest, Operation> updateCollectorSettings() {
      return updateCollectorSettings;
    }

    /** Returns the builder for the settings used for calls to updateCollector. */
    public OperationCallSettings.Builder<UpdateCollectorRequest, Collector, OperationMetadata>
        updateCollectorOperationSettings() {
      return updateCollectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCollector. */
    public UnaryCallSettings.Builder<DeleteCollectorRequest, Operation> deleteCollectorSettings() {
      return deleteCollectorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCollector. */
    public OperationCallSettings.Builder<DeleteCollectorRequest, Collector, OperationMetadata>
        deleteCollectorOperationSettings() {
      return deleteCollectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resumeCollector. */
    public UnaryCallSettings.Builder<ResumeCollectorRequest, Operation> resumeCollectorSettings() {
      return resumeCollectorSettings;
    }

    /** Returns the builder for the settings used for calls to resumeCollector. */
    public OperationCallSettings.Builder<ResumeCollectorRequest, Collector, OperationMetadata>
        resumeCollectorOperationSettings() {
      return resumeCollectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to registerCollector. */
    public UnaryCallSettings.Builder<RegisterCollectorRequest, Operation>
        registerCollectorSettings() {
      return registerCollectorSettings;
    }

    /** Returns the builder for the settings used for calls to registerCollector. */
    public OperationCallSettings.Builder<RegisterCollectorRequest, Collector, OperationMetadata>
        registerCollectorOperationSettings() {
      return registerCollectorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to pauseCollector. */
    public UnaryCallSettings.Builder<PauseCollectorRequest, Operation> pauseCollectorSettings() {
      return pauseCollectorSettings;
    }

    /** Returns the builder for the settings used for calls to pauseCollector. */
    public OperationCallSettings.Builder<PauseCollectorRequest, Collector, OperationMetadata>
        pauseCollectorOperationSettings() {
      return pauseCollectorOperationSettings;
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
    public RapidMigrationAssessmentStubSettings build() throws IOException {
      return new RapidMigrationAssessmentStubSettings(this);
    }
  }
}
