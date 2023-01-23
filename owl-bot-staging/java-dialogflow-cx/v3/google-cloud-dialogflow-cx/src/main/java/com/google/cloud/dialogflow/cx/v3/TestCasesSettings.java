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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.TestCasesClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.TestCasesClient.ListTestCaseResultsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.TestCasesClient.ListTestCasesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.cx.v3.stub.TestCasesStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TestCasesClient}.
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
 * TestCasesSettings.Builder testCasesSettingsBuilder = TestCasesSettings.newBuilder();
 * testCasesSettingsBuilder
 *     .batchDeleteTestCasesSettings()
 *     .setRetrySettings(
 *         testCasesSettingsBuilder
 *             .batchDeleteTestCasesSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TestCasesSettings testCasesSettings = testCasesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TestCasesSettings extends ClientSettings<TestCasesSettings> {

  /** Returns the object with the settings used for calls to listTestCases. */
  public PagedCallSettings<ListTestCasesRequest, ListTestCasesResponse, ListTestCasesPagedResponse>
      listTestCasesSettings() {
    return ((TestCasesStubSettings) getStubSettings()).listTestCasesSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteTestCases. */
  public UnaryCallSettings<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesSettings() {
    return ((TestCasesStubSettings) getStubSettings()).batchDeleteTestCasesSettings();
  }

  /** Returns the object with the settings used for calls to getTestCase. */
  public UnaryCallSettings<GetTestCaseRequest, TestCase> getTestCaseSettings() {
    return ((TestCasesStubSettings) getStubSettings()).getTestCaseSettings();
  }

  /** Returns the object with the settings used for calls to createTestCase. */
  public UnaryCallSettings<CreateTestCaseRequest, TestCase> createTestCaseSettings() {
    return ((TestCasesStubSettings) getStubSettings()).createTestCaseSettings();
  }

  /** Returns the object with the settings used for calls to updateTestCase. */
  public UnaryCallSettings<UpdateTestCaseRequest, TestCase> updateTestCaseSettings() {
    return ((TestCasesStubSettings) getStubSettings()).updateTestCaseSettings();
  }

  /** Returns the object with the settings used for calls to runTestCase. */
  public UnaryCallSettings<RunTestCaseRequest, Operation> runTestCaseSettings() {
    return ((TestCasesStubSettings) getStubSettings()).runTestCaseSettings();
  }

  /** Returns the object with the settings used for calls to runTestCase. */
  public OperationCallSettings<RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
      runTestCaseOperationSettings() {
    return ((TestCasesStubSettings) getStubSettings()).runTestCaseOperationSettings();
  }

  /** Returns the object with the settings used for calls to batchRunTestCases. */
  public UnaryCallSettings<BatchRunTestCasesRequest, Operation> batchRunTestCasesSettings() {
    return ((TestCasesStubSettings) getStubSettings()).batchRunTestCasesSettings();
  }

  /** Returns the object with the settings used for calls to batchRunTestCases. */
  public OperationCallSettings<
          BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
      batchRunTestCasesOperationSettings() {
    return ((TestCasesStubSettings) getStubSettings()).batchRunTestCasesOperationSettings();
  }

  /** Returns the object with the settings used for calls to calculateCoverage. */
  public UnaryCallSettings<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageSettings() {
    return ((TestCasesStubSettings) getStubSettings()).calculateCoverageSettings();
  }

  /** Returns the object with the settings used for calls to importTestCases. */
  public UnaryCallSettings<ImportTestCasesRequest, Operation> importTestCasesSettings() {
    return ((TestCasesStubSettings) getStubSettings()).importTestCasesSettings();
  }

  /** Returns the object with the settings used for calls to importTestCases. */
  public OperationCallSettings<
          ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
      importTestCasesOperationSettings() {
    return ((TestCasesStubSettings) getStubSettings()).importTestCasesOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportTestCases. */
  public UnaryCallSettings<ExportTestCasesRequest, Operation> exportTestCasesSettings() {
    return ((TestCasesStubSettings) getStubSettings()).exportTestCasesSettings();
  }

  /** Returns the object with the settings used for calls to exportTestCases. */
  public OperationCallSettings<
          ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
      exportTestCasesOperationSettings() {
    return ((TestCasesStubSettings) getStubSettings()).exportTestCasesOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTestCaseResults. */
  public PagedCallSettings<
          ListTestCaseResultsRequest, ListTestCaseResultsResponse, ListTestCaseResultsPagedResponse>
      listTestCaseResultsSettings() {
    return ((TestCasesStubSettings) getStubSettings()).listTestCaseResultsSettings();
  }

  /** Returns the object with the settings used for calls to getTestCaseResult. */
  public UnaryCallSettings<GetTestCaseResultRequest, TestCaseResult> getTestCaseResultSettings() {
    return ((TestCasesStubSettings) getStubSettings()).getTestCaseResultSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((TestCasesStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((TestCasesStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final TestCasesSettings create(TestCasesStubSettings stub) throws IOException {
    return new TestCasesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TestCasesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TestCasesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TestCasesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TestCasesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TestCasesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TestCasesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TestCasesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TestCasesStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected TestCasesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TestCasesSettings. */
  public static class Builder extends ClientSettings.Builder<TestCasesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TestCasesStubSettings.newBuilder(clientContext));
    }

    protected Builder(TestCasesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TestCasesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TestCasesStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(TestCasesStubSettings.newHttpJsonBuilder());
    }

    public TestCasesStubSettings.Builder getStubSettingsBuilder() {
      return ((TestCasesStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listTestCases. */
    public PagedCallSettings.Builder<
            ListTestCasesRequest, ListTestCasesResponse, ListTestCasesPagedResponse>
        listTestCasesSettings() {
      return getStubSettingsBuilder().listTestCasesSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteTestCases. */
    public UnaryCallSettings.Builder<BatchDeleteTestCasesRequest, Empty>
        batchDeleteTestCasesSettings() {
      return getStubSettingsBuilder().batchDeleteTestCasesSettings();
    }

    /** Returns the builder for the settings used for calls to getTestCase. */
    public UnaryCallSettings.Builder<GetTestCaseRequest, TestCase> getTestCaseSettings() {
      return getStubSettingsBuilder().getTestCaseSettings();
    }

    /** Returns the builder for the settings used for calls to createTestCase. */
    public UnaryCallSettings.Builder<CreateTestCaseRequest, TestCase> createTestCaseSettings() {
      return getStubSettingsBuilder().createTestCaseSettings();
    }

    /** Returns the builder for the settings used for calls to updateTestCase. */
    public UnaryCallSettings.Builder<UpdateTestCaseRequest, TestCase> updateTestCaseSettings() {
      return getStubSettingsBuilder().updateTestCaseSettings();
    }

    /** Returns the builder for the settings used for calls to runTestCase. */
    public UnaryCallSettings.Builder<RunTestCaseRequest, Operation> runTestCaseSettings() {
      return getStubSettingsBuilder().runTestCaseSettings();
    }

    /** Returns the builder for the settings used for calls to runTestCase. */
    public OperationCallSettings.Builder<
            RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
        runTestCaseOperationSettings() {
      return getStubSettingsBuilder().runTestCaseOperationSettings();
    }

    /** Returns the builder for the settings used for calls to batchRunTestCases. */
    public UnaryCallSettings.Builder<BatchRunTestCasesRequest, Operation>
        batchRunTestCasesSettings() {
      return getStubSettingsBuilder().batchRunTestCasesSettings();
    }

    /** Returns the builder for the settings used for calls to batchRunTestCases. */
    public OperationCallSettings.Builder<
            BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
        batchRunTestCasesOperationSettings() {
      return getStubSettingsBuilder().batchRunTestCasesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to calculateCoverage. */
    public UnaryCallSettings.Builder<CalculateCoverageRequest, CalculateCoverageResponse>
        calculateCoverageSettings() {
      return getStubSettingsBuilder().calculateCoverageSettings();
    }

    /** Returns the builder for the settings used for calls to importTestCases. */
    public UnaryCallSettings.Builder<ImportTestCasesRequest, Operation> importTestCasesSettings() {
      return getStubSettingsBuilder().importTestCasesSettings();
    }

    /** Returns the builder for the settings used for calls to importTestCases. */
    public OperationCallSettings.Builder<
            ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
        importTestCasesOperationSettings() {
      return getStubSettingsBuilder().importTestCasesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportTestCases. */
    public UnaryCallSettings.Builder<ExportTestCasesRequest, Operation> exportTestCasesSettings() {
      return getStubSettingsBuilder().exportTestCasesSettings();
    }

    /** Returns the builder for the settings used for calls to exportTestCases. */
    public OperationCallSettings.Builder<
            ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
        exportTestCasesOperationSettings() {
      return getStubSettingsBuilder().exportTestCasesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTestCaseResults. */
    public PagedCallSettings.Builder<
            ListTestCaseResultsRequest,
            ListTestCaseResultsResponse,
            ListTestCaseResultsPagedResponse>
        listTestCaseResultsSettings() {
      return getStubSettingsBuilder().listTestCaseResultsSettings();
    }

    /** Returns the builder for the settings used for calls to getTestCaseResult. */
    public UnaryCallSettings.Builder<GetTestCaseResultRequest, TestCaseResult>
        getTestCaseResultSettings() {
      return getStubSettingsBuilder().getTestCaseResultSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public TestCasesSettings build() throws IOException {
      return new TestCasesSettings(this);
    }
  }
}
