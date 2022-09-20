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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListStudiesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListTrialsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.AddTrialMeasurementRequest;
import com.google.cloud.aiplatform.v1beta1.CheckTrialEarlyStoppingStateMetatdata;
import com.google.cloud.aiplatform.v1beta1.CheckTrialEarlyStoppingStateRequest;
import com.google.cloud.aiplatform.v1beta1.CheckTrialEarlyStoppingStateResponse;
import com.google.cloud.aiplatform.v1beta1.CompleteTrialRequest;
import com.google.cloud.aiplatform.v1beta1.CreateStudyRequest;
import com.google.cloud.aiplatform.v1beta1.CreateTrialRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteStudyRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteTrialRequest;
import com.google.cloud.aiplatform.v1beta1.GetStudyRequest;
import com.google.cloud.aiplatform.v1beta1.GetTrialRequest;
import com.google.cloud.aiplatform.v1beta1.ListOptimalTrialsRequest;
import com.google.cloud.aiplatform.v1beta1.ListOptimalTrialsResponse;
import com.google.cloud.aiplatform.v1beta1.ListStudiesRequest;
import com.google.cloud.aiplatform.v1beta1.ListStudiesResponse;
import com.google.cloud.aiplatform.v1beta1.ListTrialsRequest;
import com.google.cloud.aiplatform.v1beta1.ListTrialsResponse;
import com.google.cloud.aiplatform.v1beta1.LookupStudyRequest;
import com.google.cloud.aiplatform.v1beta1.StopTrialRequest;
import com.google.cloud.aiplatform.v1beta1.Study;
import com.google.cloud.aiplatform.v1beta1.SuggestTrialsMetadata;
import com.google.cloud.aiplatform.v1beta1.SuggestTrialsRequest;
import com.google.cloud.aiplatform.v1beta1.SuggestTrialsResponse;
import com.google.cloud.aiplatform.v1beta1.Trial;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VizierServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createStudy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VizierServiceStubSettings.Builder vizierServiceSettingsBuilder =
 *     VizierServiceStubSettings.newBuilder();
 * vizierServiceSettingsBuilder
 *     .createStudySettings()
 *     .setRetrySettings(
 *         vizierServiceSettingsBuilder.createStudySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VizierServiceStubSettings vizierServiceSettings = vizierServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VizierServiceStubSettings extends StubSettings<VizierServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateStudyRequest, Study> createStudySettings;
  private final UnaryCallSettings<GetStudyRequest, Study> getStudySettings;
  private final PagedCallSettings<ListStudiesRequest, ListStudiesResponse, ListStudiesPagedResponse>
      listStudiesSettings;
  private final UnaryCallSettings<DeleteStudyRequest, Empty> deleteStudySettings;
  private final UnaryCallSettings<LookupStudyRequest, Study> lookupStudySettings;
  private final UnaryCallSettings<SuggestTrialsRequest, Operation> suggestTrialsSettings;
  private final OperationCallSettings<
          SuggestTrialsRequest, SuggestTrialsResponse, SuggestTrialsMetadata>
      suggestTrialsOperationSettings;
  private final UnaryCallSettings<CreateTrialRequest, Trial> createTrialSettings;
  private final UnaryCallSettings<GetTrialRequest, Trial> getTrialSettings;
  private final PagedCallSettings<ListTrialsRequest, ListTrialsResponse, ListTrialsPagedResponse>
      listTrialsSettings;
  private final UnaryCallSettings<AddTrialMeasurementRequest, Trial> addTrialMeasurementSettings;
  private final UnaryCallSettings<CompleteTrialRequest, Trial> completeTrialSettings;
  private final UnaryCallSettings<DeleteTrialRequest, Empty> deleteTrialSettings;
  private final UnaryCallSettings<CheckTrialEarlyStoppingStateRequest, Operation>
      checkTrialEarlyStoppingStateSettings;
  private final OperationCallSettings<
          CheckTrialEarlyStoppingStateRequest,
          CheckTrialEarlyStoppingStateResponse,
          CheckTrialEarlyStoppingStateMetatdata>
      checkTrialEarlyStoppingStateOperationSettings;
  private final UnaryCallSettings<StopTrialRequest, Trial> stopTrialSettings;
  private final UnaryCallSettings<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
      listOptimalTrialsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListStudiesRequest, ListStudiesResponse, Study>
      LIST_STUDIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListStudiesRequest, ListStudiesResponse, Study>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListStudiesRequest injectToken(ListStudiesRequest payload, String token) {
              return ListStudiesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListStudiesRequest injectPageSize(ListStudiesRequest payload, int pageSize) {
              return ListStudiesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListStudiesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListStudiesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Study> extractResources(ListStudiesResponse payload) {
              return payload.getStudiesList() == null
                  ? ImmutableList.<Study>of()
                  : payload.getStudiesList();
            }
          };

  private static final PagedListDescriptor<ListTrialsRequest, ListTrialsResponse, Trial>
      LIST_TRIALS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTrialsRequest, ListTrialsResponse, Trial>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTrialsRequest injectToken(ListTrialsRequest payload, String token) {
              return ListTrialsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTrialsRequest injectPageSize(ListTrialsRequest payload, int pageSize) {
              return ListTrialsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTrialsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTrialsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Trial> extractResources(ListTrialsResponse payload) {
              return payload.getTrialsList() == null
                  ? ImmutableList.<Trial>of()
                  : payload.getTrialsList();
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
          ListStudiesRequest, ListStudiesResponse, ListStudiesPagedResponse>
      LIST_STUDIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListStudiesRequest, ListStudiesResponse, ListStudiesPagedResponse>() {
            @Override
            public ApiFuture<ListStudiesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListStudiesRequest, ListStudiesResponse> callable,
                ListStudiesRequest request,
                ApiCallContext context,
                ApiFuture<ListStudiesResponse> futureResponse) {
              PageContext<ListStudiesRequest, ListStudiesResponse, Study> pageContext =
                  PageContext.create(callable, LIST_STUDIES_PAGE_STR_DESC, request, context);
              return ListStudiesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTrialsRequest, ListTrialsResponse, ListTrialsPagedResponse>
      LIST_TRIALS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTrialsRequest, ListTrialsResponse, ListTrialsPagedResponse>() {
            @Override
            public ApiFuture<ListTrialsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTrialsRequest, ListTrialsResponse> callable,
                ListTrialsRequest request,
                ApiCallContext context,
                ApiFuture<ListTrialsResponse> futureResponse) {
              PageContext<ListTrialsRequest, ListTrialsResponse, Trial> pageContext =
                  PageContext.create(callable, LIST_TRIALS_PAGE_STR_DESC, request, context);
              return ListTrialsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createStudy. */
  public UnaryCallSettings<CreateStudyRequest, Study> createStudySettings() {
    return createStudySettings;
  }

  /** Returns the object with the settings used for calls to getStudy. */
  public UnaryCallSettings<GetStudyRequest, Study> getStudySettings() {
    return getStudySettings;
  }

  /** Returns the object with the settings used for calls to listStudies. */
  public PagedCallSettings<ListStudiesRequest, ListStudiesResponse, ListStudiesPagedResponse>
      listStudiesSettings() {
    return listStudiesSettings;
  }

  /** Returns the object with the settings used for calls to deleteStudy. */
  public UnaryCallSettings<DeleteStudyRequest, Empty> deleteStudySettings() {
    return deleteStudySettings;
  }

  /** Returns the object with the settings used for calls to lookupStudy. */
  public UnaryCallSettings<LookupStudyRequest, Study> lookupStudySettings() {
    return lookupStudySettings;
  }

  /** Returns the object with the settings used for calls to suggestTrials. */
  public UnaryCallSettings<SuggestTrialsRequest, Operation> suggestTrialsSettings() {
    return suggestTrialsSettings;
  }

  /** Returns the object with the settings used for calls to suggestTrials. */
  public OperationCallSettings<SuggestTrialsRequest, SuggestTrialsResponse, SuggestTrialsMetadata>
      suggestTrialsOperationSettings() {
    return suggestTrialsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createTrial. */
  public UnaryCallSettings<CreateTrialRequest, Trial> createTrialSettings() {
    return createTrialSettings;
  }

  /** Returns the object with the settings used for calls to getTrial. */
  public UnaryCallSettings<GetTrialRequest, Trial> getTrialSettings() {
    return getTrialSettings;
  }

  /** Returns the object with the settings used for calls to listTrials. */
  public PagedCallSettings<ListTrialsRequest, ListTrialsResponse, ListTrialsPagedResponse>
      listTrialsSettings() {
    return listTrialsSettings;
  }

  /** Returns the object with the settings used for calls to addTrialMeasurement. */
  public UnaryCallSettings<AddTrialMeasurementRequest, Trial> addTrialMeasurementSettings() {
    return addTrialMeasurementSettings;
  }

  /** Returns the object with the settings used for calls to completeTrial. */
  public UnaryCallSettings<CompleteTrialRequest, Trial> completeTrialSettings() {
    return completeTrialSettings;
  }

  /** Returns the object with the settings used for calls to deleteTrial. */
  public UnaryCallSettings<DeleteTrialRequest, Empty> deleteTrialSettings() {
    return deleteTrialSettings;
  }

  /** Returns the object with the settings used for calls to checkTrialEarlyStoppingState. */
  public UnaryCallSettings<CheckTrialEarlyStoppingStateRequest, Operation>
      checkTrialEarlyStoppingStateSettings() {
    return checkTrialEarlyStoppingStateSettings;
  }

  /** Returns the object with the settings used for calls to checkTrialEarlyStoppingState. */
  public OperationCallSettings<
          CheckTrialEarlyStoppingStateRequest,
          CheckTrialEarlyStoppingStateResponse,
          CheckTrialEarlyStoppingStateMetatdata>
      checkTrialEarlyStoppingStateOperationSettings() {
    return checkTrialEarlyStoppingStateOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopTrial. */
  public UnaryCallSettings<StopTrialRequest, Trial> stopTrialSettings() {
    return stopTrialSettings;
  }

  /** Returns the object with the settings used for calls to listOptimalTrials. */
  public UnaryCallSettings<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
      listOptimalTrialsSettings() {
    return listOptimalTrialsSettings;
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

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public VizierServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcVizierServiceStub.create(this);
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
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(VizierServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected VizierServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createStudySettings = settingsBuilder.createStudySettings().build();
    getStudySettings = settingsBuilder.getStudySettings().build();
    listStudiesSettings = settingsBuilder.listStudiesSettings().build();
    deleteStudySettings = settingsBuilder.deleteStudySettings().build();
    lookupStudySettings = settingsBuilder.lookupStudySettings().build();
    suggestTrialsSettings = settingsBuilder.suggestTrialsSettings().build();
    suggestTrialsOperationSettings = settingsBuilder.suggestTrialsOperationSettings().build();
    createTrialSettings = settingsBuilder.createTrialSettings().build();
    getTrialSettings = settingsBuilder.getTrialSettings().build();
    listTrialsSettings = settingsBuilder.listTrialsSettings().build();
    addTrialMeasurementSettings = settingsBuilder.addTrialMeasurementSettings().build();
    completeTrialSettings = settingsBuilder.completeTrialSettings().build();
    deleteTrialSettings = settingsBuilder.deleteTrialSettings().build();
    checkTrialEarlyStoppingStateSettings =
        settingsBuilder.checkTrialEarlyStoppingStateSettings().build();
    checkTrialEarlyStoppingStateOperationSettings =
        settingsBuilder.checkTrialEarlyStoppingStateOperationSettings().build();
    stopTrialSettings = settingsBuilder.stopTrialSettings().build();
    listOptimalTrialsSettings = settingsBuilder.listOptimalTrialsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for VizierServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<VizierServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateStudyRequest, Study> createStudySettings;
    private final UnaryCallSettings.Builder<GetStudyRequest, Study> getStudySettings;
    private final PagedCallSettings.Builder<
            ListStudiesRequest, ListStudiesResponse, ListStudiesPagedResponse>
        listStudiesSettings;
    private final UnaryCallSettings.Builder<DeleteStudyRequest, Empty> deleteStudySettings;
    private final UnaryCallSettings.Builder<LookupStudyRequest, Study> lookupStudySettings;
    private final UnaryCallSettings.Builder<SuggestTrialsRequest, Operation> suggestTrialsSettings;
    private final OperationCallSettings.Builder<
            SuggestTrialsRequest, SuggestTrialsResponse, SuggestTrialsMetadata>
        suggestTrialsOperationSettings;
    private final UnaryCallSettings.Builder<CreateTrialRequest, Trial> createTrialSettings;
    private final UnaryCallSettings.Builder<GetTrialRequest, Trial> getTrialSettings;
    private final PagedCallSettings.Builder<
            ListTrialsRequest, ListTrialsResponse, ListTrialsPagedResponse>
        listTrialsSettings;
    private final UnaryCallSettings.Builder<AddTrialMeasurementRequest, Trial>
        addTrialMeasurementSettings;
    private final UnaryCallSettings.Builder<CompleteTrialRequest, Trial> completeTrialSettings;
    private final UnaryCallSettings.Builder<DeleteTrialRequest, Empty> deleteTrialSettings;
    private final UnaryCallSettings.Builder<CheckTrialEarlyStoppingStateRequest, Operation>
        checkTrialEarlyStoppingStateSettings;
    private final OperationCallSettings.Builder<
            CheckTrialEarlyStoppingStateRequest,
            CheckTrialEarlyStoppingStateResponse,
            CheckTrialEarlyStoppingStateMetatdata>
        checkTrialEarlyStoppingStateOperationSettings;
    private final UnaryCallSettings.Builder<StopTrialRequest, Trial> stopTrialSettings;
    private final UnaryCallSettings.Builder<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
        listOptimalTrialsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_11_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(5000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(5000L))
              .setTotalTimeout(Duration.ofMillis(5000L))
              .build();
      definitions.put("no_retry_11_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createStudySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getStudySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listStudiesSettings = PagedCallSettings.newBuilder(LIST_STUDIES_PAGE_STR_FACT);
      deleteStudySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupStudySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      suggestTrialsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      suggestTrialsOperationSettings = OperationCallSettings.newBuilder();
      createTrialSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTrialSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTrialsSettings = PagedCallSettings.newBuilder(LIST_TRIALS_PAGE_STR_FACT);
      addTrialMeasurementSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      completeTrialSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTrialSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      checkTrialEarlyStoppingStateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      checkTrialEarlyStoppingStateOperationSettings = OperationCallSettings.newBuilder();
      stopTrialSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listOptimalTrialsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createStudySettings,
              getStudySettings,
              listStudiesSettings,
              deleteStudySettings,
              lookupStudySettings,
              suggestTrialsSettings,
              createTrialSettings,
              getTrialSettings,
              listTrialsSettings,
              addTrialMeasurementSettings,
              completeTrialSettings,
              deleteTrialSettings,
              checkTrialEarlyStoppingStateSettings,
              stopTrialSettings,
              listOptimalTrialsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(VizierServiceStubSettings settings) {
      super(settings);

      createStudySettings = settings.createStudySettings.toBuilder();
      getStudySettings = settings.getStudySettings.toBuilder();
      listStudiesSettings = settings.listStudiesSettings.toBuilder();
      deleteStudySettings = settings.deleteStudySettings.toBuilder();
      lookupStudySettings = settings.lookupStudySettings.toBuilder();
      suggestTrialsSettings = settings.suggestTrialsSettings.toBuilder();
      suggestTrialsOperationSettings = settings.suggestTrialsOperationSettings.toBuilder();
      createTrialSettings = settings.createTrialSettings.toBuilder();
      getTrialSettings = settings.getTrialSettings.toBuilder();
      listTrialsSettings = settings.listTrialsSettings.toBuilder();
      addTrialMeasurementSettings = settings.addTrialMeasurementSettings.toBuilder();
      completeTrialSettings = settings.completeTrialSettings.toBuilder();
      deleteTrialSettings = settings.deleteTrialSettings.toBuilder();
      checkTrialEarlyStoppingStateSettings =
          settings.checkTrialEarlyStoppingStateSettings.toBuilder();
      checkTrialEarlyStoppingStateOperationSettings =
          settings.checkTrialEarlyStoppingStateOperationSettings.toBuilder();
      stopTrialSettings = settings.stopTrialSettings.toBuilder();
      listOptimalTrialsSettings = settings.listOptimalTrialsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createStudySettings,
              getStudySettings,
              listStudiesSettings,
              deleteStudySettings,
              lookupStudySettings,
              suggestTrialsSettings,
              createTrialSettings,
              getTrialSettings,
              listTrialsSettings,
              addTrialMeasurementSettings,
              completeTrialSettings,
              deleteTrialSettings,
              checkTrialEarlyStoppingStateSettings,
              stopTrialSettings,
              listOptimalTrialsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createStudySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .getStudySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .listStudiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .deleteStudySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .lookupStudySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .suggestTrialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .createTrialSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .getTrialSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .listTrialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .addTrialMeasurementSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .completeTrialSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .deleteTrialSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .checkTrialEarlyStoppingStateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .stopTrialSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .listOptimalTrialsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .suggestTrialsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SuggestTrialsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(SuggestTrialsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(SuggestTrialsMetadata.class))
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
          .checkTrialEarlyStoppingStateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CheckTrialEarlyStoppingStateRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_11_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_11_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  CheckTrialEarlyStoppingStateResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CheckTrialEarlyStoppingStateMetatdata.class))
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

    /** Returns the builder for the settings used for calls to createStudy. */
    public UnaryCallSettings.Builder<CreateStudyRequest, Study> createStudySettings() {
      return createStudySettings;
    }

    /** Returns the builder for the settings used for calls to getStudy. */
    public UnaryCallSettings.Builder<GetStudyRequest, Study> getStudySettings() {
      return getStudySettings;
    }

    /** Returns the builder for the settings used for calls to listStudies. */
    public PagedCallSettings.Builder<
            ListStudiesRequest, ListStudiesResponse, ListStudiesPagedResponse>
        listStudiesSettings() {
      return listStudiesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteStudy. */
    public UnaryCallSettings.Builder<DeleteStudyRequest, Empty> deleteStudySettings() {
      return deleteStudySettings;
    }

    /** Returns the builder for the settings used for calls to lookupStudy. */
    public UnaryCallSettings.Builder<LookupStudyRequest, Study> lookupStudySettings() {
      return lookupStudySettings;
    }

    /** Returns the builder for the settings used for calls to suggestTrials. */
    public UnaryCallSettings.Builder<SuggestTrialsRequest, Operation> suggestTrialsSettings() {
      return suggestTrialsSettings;
    }

    /** Returns the builder for the settings used for calls to suggestTrials. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SuggestTrialsRequest, SuggestTrialsResponse, SuggestTrialsMetadata>
        suggestTrialsOperationSettings() {
      return suggestTrialsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createTrial. */
    public UnaryCallSettings.Builder<CreateTrialRequest, Trial> createTrialSettings() {
      return createTrialSettings;
    }

    /** Returns the builder for the settings used for calls to getTrial. */
    public UnaryCallSettings.Builder<GetTrialRequest, Trial> getTrialSettings() {
      return getTrialSettings;
    }

    /** Returns the builder for the settings used for calls to listTrials. */
    public PagedCallSettings.Builder<ListTrialsRequest, ListTrialsResponse, ListTrialsPagedResponse>
        listTrialsSettings() {
      return listTrialsSettings;
    }

    /** Returns the builder for the settings used for calls to addTrialMeasurement. */
    public UnaryCallSettings.Builder<AddTrialMeasurementRequest, Trial>
        addTrialMeasurementSettings() {
      return addTrialMeasurementSettings;
    }

    /** Returns the builder for the settings used for calls to completeTrial. */
    public UnaryCallSettings.Builder<CompleteTrialRequest, Trial> completeTrialSettings() {
      return completeTrialSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTrial. */
    public UnaryCallSettings.Builder<DeleteTrialRequest, Empty> deleteTrialSettings() {
      return deleteTrialSettings;
    }

    /** Returns the builder for the settings used for calls to checkTrialEarlyStoppingState. */
    public UnaryCallSettings.Builder<CheckTrialEarlyStoppingStateRequest, Operation>
        checkTrialEarlyStoppingStateSettings() {
      return checkTrialEarlyStoppingStateSettings;
    }

    /** Returns the builder for the settings used for calls to checkTrialEarlyStoppingState. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CheckTrialEarlyStoppingStateRequest,
            CheckTrialEarlyStoppingStateResponse,
            CheckTrialEarlyStoppingStateMetatdata>
        checkTrialEarlyStoppingStateOperationSettings() {
      return checkTrialEarlyStoppingStateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopTrial. */
    public UnaryCallSettings.Builder<StopTrialRequest, Trial> stopTrialSettings() {
      return stopTrialSettings;
    }

    /** Returns the builder for the settings used for calls to listOptimalTrials. */
    public UnaryCallSettings.Builder<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
        listOptimalTrialsSettings() {
      return listOptimalTrialsSettings;
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public VizierServiceStubSettings build() throws IOException {
      return new VizierServiceStubSettings(this);
    }
  }
}
