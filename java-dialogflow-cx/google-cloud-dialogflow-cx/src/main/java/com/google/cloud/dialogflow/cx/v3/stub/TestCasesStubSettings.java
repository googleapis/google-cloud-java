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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.TestCasesClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.TestCasesClient.ListTestCaseResultsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.TestCasesClient.ListTestCasesPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3.BatchDeleteTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.BatchRunTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3.BatchRunTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.BatchRunTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.CalculateCoverageRequest;
import com.google.cloud.dialogflow.cx.v3.CalculateCoverageResponse;
import com.google.cloud.dialogflow.cx.v3.CreateTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3.ExportTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3.ExportTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.ExportTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.GetTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3.GetTestCaseResultRequest;
import com.google.cloud.dialogflow.cx.v3.ImportTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3.ImportTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.ImportTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.ListTestCaseResultsRequest;
import com.google.cloud.dialogflow.cx.v3.ListTestCaseResultsResponse;
import com.google.cloud.dialogflow.cx.v3.ListTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3.ListTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3.RunTestCaseMetadata;
import com.google.cloud.dialogflow.cx.v3.RunTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3.RunTestCaseResponse;
import com.google.cloud.dialogflow.cx.v3.TestCase;
import com.google.cloud.dialogflow.cx.v3.TestCaseResult;
import com.google.cloud.dialogflow.cx.v3.UpdateTestCaseRequest;
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
 * Settings class to configure an instance of {@link TestCasesStub}.
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
 * <p>For example, to set the total timeout of batchDeleteTestCases to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TestCasesStubSettings.Builder testCasesSettingsBuilder = TestCasesStubSettings.newBuilder();
 * testCasesSettingsBuilder
 *     .batchDeleteTestCasesSettings()
 *     .setRetrySettings(
 *         testCasesSettingsBuilder.batchDeleteTestCasesSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TestCasesStubSettings testCasesSettings = testCasesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TestCasesStubSettings extends StubSettings<TestCasesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<
          ListTestCasesRequest, ListTestCasesResponse, ListTestCasesPagedResponse>
      listTestCasesSettings;
  private final UnaryCallSettings<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesSettings;
  private final UnaryCallSettings<GetTestCaseRequest, TestCase> getTestCaseSettings;
  private final UnaryCallSettings<CreateTestCaseRequest, TestCase> createTestCaseSettings;
  private final UnaryCallSettings<UpdateTestCaseRequest, TestCase> updateTestCaseSettings;
  private final UnaryCallSettings<RunTestCaseRequest, Operation> runTestCaseSettings;
  private final OperationCallSettings<RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
      runTestCaseOperationSettings;
  private final UnaryCallSettings<BatchRunTestCasesRequest, Operation> batchRunTestCasesSettings;
  private final OperationCallSettings<
          BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
      batchRunTestCasesOperationSettings;
  private final UnaryCallSettings<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageSettings;
  private final UnaryCallSettings<ImportTestCasesRequest, Operation> importTestCasesSettings;
  private final OperationCallSettings<
          ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
      importTestCasesOperationSettings;
  private final UnaryCallSettings<ExportTestCasesRequest, Operation> exportTestCasesSettings;
  private final OperationCallSettings<
          ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
      exportTestCasesOperationSettings;
  private final PagedCallSettings<
          ListTestCaseResultsRequest, ListTestCaseResultsResponse, ListTestCaseResultsPagedResponse>
      listTestCaseResultsSettings;
  private final UnaryCallSettings<GetTestCaseResultRequest, TestCaseResult>
      getTestCaseResultSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListTestCasesRequest, ListTestCasesResponse, TestCase>
      LIST_TEST_CASES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTestCasesRequest, ListTestCasesResponse, TestCase>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTestCasesRequest injectToken(ListTestCasesRequest payload, String token) {
              return ListTestCasesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTestCasesRequest injectPageSize(ListTestCasesRequest payload, int pageSize) {
              return ListTestCasesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTestCasesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTestCasesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TestCase> extractResources(ListTestCasesResponse payload) {
              return payload.getTestCasesList() == null
                  ? ImmutableList.<TestCase>of()
                  : payload.getTestCasesList();
            }
          };

  private static final PagedListDescriptor<
          ListTestCaseResultsRequest, ListTestCaseResultsResponse, TestCaseResult>
      LIST_TEST_CASE_RESULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTestCaseResultsRequest, ListTestCaseResultsResponse, TestCaseResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTestCaseResultsRequest injectToken(
                ListTestCaseResultsRequest payload, String token) {
              return ListTestCaseResultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTestCaseResultsRequest injectPageSize(
                ListTestCaseResultsRequest payload, int pageSize) {
              return ListTestCaseResultsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTestCaseResultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTestCaseResultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TestCaseResult> extractResources(ListTestCaseResultsResponse payload) {
              return payload.getTestCaseResultsList() == null
                  ? ImmutableList.<TestCaseResult>of()
                  : payload.getTestCaseResultsList();
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
          ListTestCasesRequest, ListTestCasesResponse, ListTestCasesPagedResponse>
      LIST_TEST_CASES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTestCasesRequest, ListTestCasesResponse, ListTestCasesPagedResponse>() {
            @Override
            public ApiFuture<ListTestCasesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTestCasesRequest, ListTestCasesResponse> callable,
                ListTestCasesRequest request,
                ApiCallContext context,
                ApiFuture<ListTestCasesResponse> futureResponse) {
              PageContext<ListTestCasesRequest, ListTestCasesResponse, TestCase> pageContext =
                  PageContext.create(callable, LIST_TEST_CASES_PAGE_STR_DESC, request, context);
              return ListTestCasesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTestCaseResultsRequest, ListTestCaseResultsResponse, ListTestCaseResultsPagedResponse>
      LIST_TEST_CASE_RESULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTestCaseResultsRequest,
              ListTestCaseResultsResponse,
              ListTestCaseResultsPagedResponse>() {
            @Override
            public ApiFuture<ListTestCaseResultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsResponse> callable,
                ListTestCaseResultsRequest request,
                ApiCallContext context,
                ApiFuture<ListTestCaseResultsResponse> futureResponse) {
              PageContext<ListTestCaseResultsRequest, ListTestCaseResultsResponse, TestCaseResult>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TEST_CASE_RESULTS_PAGE_STR_DESC, request, context);
              return ListTestCaseResultsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listTestCases. */
  public PagedCallSettings<ListTestCasesRequest, ListTestCasesResponse, ListTestCasesPagedResponse>
      listTestCasesSettings() {
    return listTestCasesSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteTestCases. */
  public UnaryCallSettings<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesSettings() {
    return batchDeleteTestCasesSettings;
  }

  /** Returns the object with the settings used for calls to getTestCase. */
  public UnaryCallSettings<GetTestCaseRequest, TestCase> getTestCaseSettings() {
    return getTestCaseSettings;
  }

  /** Returns the object with the settings used for calls to createTestCase. */
  public UnaryCallSettings<CreateTestCaseRequest, TestCase> createTestCaseSettings() {
    return createTestCaseSettings;
  }

  /** Returns the object with the settings used for calls to updateTestCase. */
  public UnaryCallSettings<UpdateTestCaseRequest, TestCase> updateTestCaseSettings() {
    return updateTestCaseSettings;
  }

  /** Returns the object with the settings used for calls to runTestCase. */
  public UnaryCallSettings<RunTestCaseRequest, Operation> runTestCaseSettings() {
    return runTestCaseSettings;
  }

  /** Returns the object with the settings used for calls to runTestCase. */
  public OperationCallSettings<RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
      runTestCaseOperationSettings() {
    return runTestCaseOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchRunTestCases. */
  public UnaryCallSettings<BatchRunTestCasesRequest, Operation> batchRunTestCasesSettings() {
    return batchRunTestCasesSettings;
  }

  /** Returns the object with the settings used for calls to batchRunTestCases. */
  public OperationCallSettings<
          BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
      batchRunTestCasesOperationSettings() {
    return batchRunTestCasesOperationSettings;
  }

  /** Returns the object with the settings used for calls to calculateCoverage. */
  public UnaryCallSettings<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageSettings() {
    return calculateCoverageSettings;
  }

  /** Returns the object with the settings used for calls to importTestCases. */
  public UnaryCallSettings<ImportTestCasesRequest, Operation> importTestCasesSettings() {
    return importTestCasesSettings;
  }

  /** Returns the object with the settings used for calls to importTestCases. */
  public OperationCallSettings<
          ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
      importTestCasesOperationSettings() {
    return importTestCasesOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportTestCases. */
  public UnaryCallSettings<ExportTestCasesRequest, Operation> exportTestCasesSettings() {
    return exportTestCasesSettings;
  }

  /** Returns the object with the settings used for calls to exportTestCases. */
  public OperationCallSettings<
          ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
      exportTestCasesOperationSettings() {
    return exportTestCasesOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTestCaseResults. */
  public PagedCallSettings<
          ListTestCaseResultsRequest, ListTestCaseResultsResponse, ListTestCaseResultsPagedResponse>
      listTestCaseResultsSettings() {
    return listTestCaseResultsSettings;
  }

  /** Returns the object with the settings used for calls to getTestCaseResult. */
  public UnaryCallSettings<GetTestCaseResultRequest, TestCaseResult> getTestCaseResultSettings() {
    return getTestCaseResultSettings;
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

  public TestCasesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTestCasesStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTestCasesStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(TestCasesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(TestCasesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TestCasesStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected TestCasesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listTestCasesSettings = settingsBuilder.listTestCasesSettings().build();
    batchDeleteTestCasesSettings = settingsBuilder.batchDeleteTestCasesSettings().build();
    getTestCaseSettings = settingsBuilder.getTestCaseSettings().build();
    createTestCaseSettings = settingsBuilder.createTestCaseSettings().build();
    updateTestCaseSettings = settingsBuilder.updateTestCaseSettings().build();
    runTestCaseSettings = settingsBuilder.runTestCaseSettings().build();
    runTestCaseOperationSettings = settingsBuilder.runTestCaseOperationSettings().build();
    batchRunTestCasesSettings = settingsBuilder.batchRunTestCasesSettings().build();
    batchRunTestCasesOperationSettings =
        settingsBuilder.batchRunTestCasesOperationSettings().build();
    calculateCoverageSettings = settingsBuilder.calculateCoverageSettings().build();
    importTestCasesSettings = settingsBuilder.importTestCasesSettings().build();
    importTestCasesOperationSettings = settingsBuilder.importTestCasesOperationSettings().build();
    exportTestCasesSettings = settingsBuilder.exportTestCasesSettings().build();
    exportTestCasesOperationSettings = settingsBuilder.exportTestCasesOperationSettings().build();
    listTestCaseResultsSettings = settingsBuilder.listTestCaseResultsSettings().build();
    getTestCaseResultSettings = settingsBuilder.getTestCaseResultSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for TestCasesStubSettings. */
  public static class Builder extends StubSettings.Builder<TestCasesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListTestCasesRequest, ListTestCasesResponse, ListTestCasesPagedResponse>
        listTestCasesSettings;
    private final UnaryCallSettings.Builder<BatchDeleteTestCasesRequest, Empty>
        batchDeleteTestCasesSettings;
    private final UnaryCallSettings.Builder<GetTestCaseRequest, TestCase> getTestCaseSettings;
    private final UnaryCallSettings.Builder<CreateTestCaseRequest, TestCase> createTestCaseSettings;
    private final UnaryCallSettings.Builder<UpdateTestCaseRequest, TestCase> updateTestCaseSettings;
    private final UnaryCallSettings.Builder<RunTestCaseRequest, Operation> runTestCaseSettings;
    private final OperationCallSettings.Builder<
            RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
        runTestCaseOperationSettings;
    private final UnaryCallSettings.Builder<BatchRunTestCasesRequest, Operation>
        batchRunTestCasesSettings;
    private final OperationCallSettings.Builder<
            BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
        batchRunTestCasesOperationSettings;
    private final UnaryCallSettings.Builder<CalculateCoverageRequest, CalculateCoverageResponse>
        calculateCoverageSettings;
    private final UnaryCallSettings.Builder<ImportTestCasesRequest, Operation>
        importTestCasesSettings;
    private final OperationCallSettings.Builder<
            ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
        importTestCasesOperationSettings;
    private final UnaryCallSettings.Builder<ExportTestCasesRequest, Operation>
        exportTestCasesSettings;
    private final OperationCallSettings.Builder<
            ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
        exportTestCasesOperationSettings;
    private final PagedCallSettings.Builder<
            ListTestCaseResultsRequest,
            ListTestCaseResultsResponse,
            ListTestCaseResultsPagedResponse>
        listTestCaseResultsSettings;
    private final UnaryCallSettings.Builder<GetTestCaseResultRequest, TestCaseResult>
        getTestCaseResultSettings;
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

      listTestCasesSettings = PagedCallSettings.newBuilder(LIST_TEST_CASES_PAGE_STR_FACT);
      batchDeleteTestCasesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTestCaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTestCaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTestCaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runTestCaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runTestCaseOperationSettings = OperationCallSettings.newBuilder();
      batchRunTestCasesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRunTestCasesOperationSettings = OperationCallSettings.newBuilder();
      calculateCoverageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importTestCasesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importTestCasesOperationSettings = OperationCallSettings.newBuilder();
      exportTestCasesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportTestCasesOperationSettings = OperationCallSettings.newBuilder();
      listTestCaseResultsSettings =
          PagedCallSettings.newBuilder(LIST_TEST_CASE_RESULTS_PAGE_STR_FACT);
      getTestCaseResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTestCasesSettings,
              batchDeleteTestCasesSettings,
              getTestCaseSettings,
              createTestCaseSettings,
              updateTestCaseSettings,
              runTestCaseSettings,
              batchRunTestCasesSettings,
              calculateCoverageSettings,
              importTestCasesSettings,
              exportTestCasesSettings,
              listTestCaseResultsSettings,
              getTestCaseResultSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(TestCasesStubSettings settings) {
      super(settings);

      listTestCasesSettings = settings.listTestCasesSettings.toBuilder();
      batchDeleteTestCasesSettings = settings.batchDeleteTestCasesSettings.toBuilder();
      getTestCaseSettings = settings.getTestCaseSettings.toBuilder();
      createTestCaseSettings = settings.createTestCaseSettings.toBuilder();
      updateTestCaseSettings = settings.updateTestCaseSettings.toBuilder();
      runTestCaseSettings = settings.runTestCaseSettings.toBuilder();
      runTestCaseOperationSettings = settings.runTestCaseOperationSettings.toBuilder();
      batchRunTestCasesSettings = settings.batchRunTestCasesSettings.toBuilder();
      batchRunTestCasesOperationSettings = settings.batchRunTestCasesOperationSettings.toBuilder();
      calculateCoverageSettings = settings.calculateCoverageSettings.toBuilder();
      importTestCasesSettings = settings.importTestCasesSettings.toBuilder();
      importTestCasesOperationSettings = settings.importTestCasesOperationSettings.toBuilder();
      exportTestCasesSettings = settings.exportTestCasesSettings.toBuilder();
      exportTestCasesOperationSettings = settings.exportTestCasesOperationSettings.toBuilder();
      listTestCaseResultsSettings = settings.listTestCaseResultsSettings.toBuilder();
      getTestCaseResultSettings = settings.getTestCaseResultSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listTestCasesSettings,
              batchDeleteTestCasesSettings,
              getTestCaseSettings,
              createTestCaseSettings,
              updateTestCaseSettings,
              runTestCaseSettings,
              batchRunTestCasesSettings,
              calculateCoverageSettings,
              importTestCasesSettings,
              exportTestCasesSettings,
              listTestCaseResultsSettings,
              getTestCaseResultSettings,
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
          .listTestCasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchDeleteTestCasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTestCaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTestCaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateTestCaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .runTestCaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchRunTestCasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .calculateCoverageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importTestCasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportTestCasesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTestCaseResultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getTestCaseResultSettings()
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
          .runTestCaseOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<RunTestCaseRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RunTestCaseResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(RunTestCaseMetadata.class))
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
          .batchRunTestCasesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchRunTestCasesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchRunTestCasesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchRunTestCasesMetadata.class))
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
          .importTestCasesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportTestCasesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportTestCasesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ImportTestCasesMetadata.class))
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
          .exportTestCasesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportTestCasesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExportTestCasesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ExportTestCasesMetadata.class))
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

    /** Returns the builder for the settings used for calls to listTestCases. */
    public PagedCallSettings.Builder<
            ListTestCasesRequest, ListTestCasesResponse, ListTestCasesPagedResponse>
        listTestCasesSettings() {
      return listTestCasesSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteTestCases. */
    public UnaryCallSettings.Builder<BatchDeleteTestCasesRequest, Empty>
        batchDeleteTestCasesSettings() {
      return batchDeleteTestCasesSettings;
    }

    /** Returns the builder for the settings used for calls to getTestCase. */
    public UnaryCallSettings.Builder<GetTestCaseRequest, TestCase> getTestCaseSettings() {
      return getTestCaseSettings;
    }

    /** Returns the builder for the settings used for calls to createTestCase. */
    public UnaryCallSettings.Builder<CreateTestCaseRequest, TestCase> createTestCaseSettings() {
      return createTestCaseSettings;
    }

    /** Returns the builder for the settings used for calls to updateTestCase. */
    public UnaryCallSettings.Builder<UpdateTestCaseRequest, TestCase> updateTestCaseSettings() {
      return updateTestCaseSettings;
    }

    /** Returns the builder for the settings used for calls to runTestCase. */
    public UnaryCallSettings.Builder<RunTestCaseRequest, Operation> runTestCaseSettings() {
      return runTestCaseSettings;
    }

    /** Returns the builder for the settings used for calls to runTestCase. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
        runTestCaseOperationSettings() {
      return runTestCaseOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchRunTestCases. */
    public UnaryCallSettings.Builder<BatchRunTestCasesRequest, Operation>
        batchRunTestCasesSettings() {
      return batchRunTestCasesSettings;
    }

    /** Returns the builder for the settings used for calls to batchRunTestCases. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
        batchRunTestCasesOperationSettings() {
      return batchRunTestCasesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to calculateCoverage. */
    public UnaryCallSettings.Builder<CalculateCoverageRequest, CalculateCoverageResponse>
        calculateCoverageSettings() {
      return calculateCoverageSettings;
    }

    /** Returns the builder for the settings used for calls to importTestCases. */
    public UnaryCallSettings.Builder<ImportTestCasesRequest, Operation> importTestCasesSettings() {
      return importTestCasesSettings;
    }

    /** Returns the builder for the settings used for calls to importTestCases. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
        importTestCasesOperationSettings() {
      return importTestCasesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportTestCases. */
    public UnaryCallSettings.Builder<ExportTestCasesRequest, Operation> exportTestCasesSettings() {
      return exportTestCasesSettings;
    }

    /** Returns the builder for the settings used for calls to exportTestCases. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
        exportTestCasesOperationSettings() {
      return exportTestCasesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTestCaseResults. */
    public PagedCallSettings.Builder<
            ListTestCaseResultsRequest,
            ListTestCaseResultsResponse,
            ListTestCaseResultsPagedResponse>
        listTestCaseResultsSettings() {
      return listTestCaseResultsSettings;
    }

    /** Returns the builder for the settings used for calls to getTestCaseResult. */
    public UnaryCallSettings.Builder<GetTestCaseResultRequest, TestCaseResult>
        getTestCaseResultSettings() {
      return getTestCaseResultSettings;
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
    public TestCasesStubSettings build() throws IOException {
      return new TestCasesStubSettings(this);
    }
  }
}
