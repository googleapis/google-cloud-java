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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.InterconnectGroupsClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
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
import com.google.cloud.compute.v1.CreateMembersInterconnectGroupRequest;
import com.google.cloud.compute.v1.DeleteInterconnectGroupRequest;
import com.google.cloud.compute.v1.GetIamPolicyInterconnectGroupRequest;
import com.google.cloud.compute.v1.GetInterconnectGroupRequest;
import com.google.cloud.compute.v1.GetOperationalStatusInterconnectGroupRequest;
import com.google.cloud.compute.v1.InsertInterconnectGroupRequest;
import com.google.cloud.compute.v1.InterconnectGroup;
import com.google.cloud.compute.v1.InterconnectGroupsGetOperationalStatusResponse;
import com.google.cloud.compute.v1.InterconnectGroupsListResponse;
import com.google.cloud.compute.v1.ListInterconnectGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchInterconnectGroupRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyInterconnectGroupRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInterconnectGroupRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InterconnectGroupsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of get:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InterconnectGroupsStubSettings.Builder interconnectGroupsSettingsBuilder =
 *     InterconnectGroupsStubSettings.newBuilder();
 * interconnectGroupsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         interconnectGroupsSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * InterconnectGroupsStubSettings interconnectGroupsSettings =
 *     interconnectGroupsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createMembers:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InterconnectGroupsStubSettings.Builder interconnectGroupsSettingsBuilder =
 *     InterconnectGroupsStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * interconnectGroupsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InterconnectGroupsStubSettings extends StubSettings<InterconnectGroupsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<CreateMembersInterconnectGroupRequest, Operation>
      createMembersSettings;
  private final OperationCallSettings<CreateMembersInterconnectGroupRequest, Operation, Operation>
      createMembersOperationSettings;
  private final UnaryCallSettings<DeleteInterconnectGroupRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteInterconnectGroupRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetInterconnectGroupRequest, InterconnectGroup> getSettings;
  private final UnaryCallSettings<GetIamPolicyInterconnectGroupRequest, Policy>
      getIamPolicySettings;
  private final UnaryCallSettings<
          GetOperationalStatusInterconnectGroupRequest,
          InterconnectGroupsGetOperationalStatusResponse>
      getOperationalStatusSettings;
  private final UnaryCallSettings<InsertInterconnectGroupRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertInterconnectGroupRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<
          ListInterconnectGroupsRequest, InterconnectGroupsListResponse, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<PatchInterconnectGroupRequest, Operation> patchSettings;
  private final OperationCallSettings<PatchInterconnectGroupRequest, Operation, Operation>
      patchOperationSettings;
  private final UnaryCallSettings<SetIamPolicyInterconnectGroupRequest, Policy>
      setIamPolicySettings;
  private final UnaryCallSettings<
          TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListInterconnectGroupsRequest, InterconnectGroupsListResponse, InterconnectGroup>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInterconnectGroupsRequest, InterconnectGroupsListResponse, InterconnectGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInterconnectGroupsRequest injectToken(
                ListInterconnectGroupsRequest payload, String token) {
              return ListInterconnectGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInterconnectGroupsRequest injectPageSize(
                ListInterconnectGroupsRequest payload, int pageSize) {
              return ListInterconnectGroupsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInterconnectGroupsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InterconnectGroupsListResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InterconnectGroup> extractResources(
                InterconnectGroupsListResponse payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListInterconnectGroupsRequest, InterconnectGroupsListResponse, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInterconnectGroupsRequest, InterconnectGroupsListResponse, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInterconnectGroupsRequest, InterconnectGroupsListResponse>
                    callable,
                ListInterconnectGroupsRequest request,
                ApiCallContext context,
                ApiFuture<InterconnectGroupsListResponse> futureResponse) {
              PageContext<
                      ListInterconnectGroupsRequest,
                      InterconnectGroupsListResponse,
                      InterconnectGroup>
                  pageContext = PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createMembers. */
  public UnaryCallSettings<CreateMembersInterconnectGroupRequest, Operation>
      createMembersSettings() {
    return createMembersSettings;
  }

  /** Returns the object with the settings used for calls to createMembers. */
  public OperationCallSettings<CreateMembersInterconnectGroupRequest, Operation, Operation>
      createMembersOperationSettings() {
    return createMembersOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteInterconnectGroupRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteInterconnectGroupRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetInterconnectGroupRequest, InterconnectGroup> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyInterconnectGroupRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getOperationalStatus. */
  public UnaryCallSettings<
          GetOperationalStatusInterconnectGroupRequest,
          InterconnectGroupsGetOperationalStatusResponse>
      getOperationalStatusSettings() {
    return getOperationalStatusSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertInterconnectGroupRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertInterconnectGroupRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListInterconnectGroupsRequest, InterconnectGroupsListResponse, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchInterconnectGroupRequest, Operation> patchSettings() {
    return patchSettings;
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchInterconnectGroupRequest, Operation, Operation>
      patchOperationSettings() {
    return patchOperationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyInterconnectGroupRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public InterconnectGroupsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonInterconnectGroupsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "compute";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "compute.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "compute.mtls.googleapis.com:443";
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(InterconnectGroupsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected InterconnectGroupsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createMembersSettings = settingsBuilder.createMembersSettings().build();
    createMembersOperationSettings = settingsBuilder.createMembersOperationSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    getOperationalStatusSettings = settingsBuilder.getOperationalStatusSettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    patchSettings = settingsBuilder.patchSettings().build();
    patchOperationSettings = settingsBuilder.patchOperationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for InterconnectGroupsStubSettings. */
  public static class Builder
      extends StubSettings.Builder<InterconnectGroupsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateMembersInterconnectGroupRequest, Operation>
        createMembersSettings;
    private final OperationCallSettings.Builder<
            CreateMembersInterconnectGroupRequest, Operation, Operation>
        createMembersOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInterconnectGroupRequest, Operation>
        deleteSettings;
    private final OperationCallSettings.Builder<
            DeleteInterconnectGroupRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetInterconnectGroupRequest, InterconnectGroup>
        getSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyInterconnectGroupRequest, Policy>
        getIamPolicySettings;
    private final UnaryCallSettings.Builder<
            GetOperationalStatusInterconnectGroupRequest,
            InterconnectGroupsGetOperationalStatusResponse>
        getOperationalStatusSettings;
    private final UnaryCallSettings.Builder<InsertInterconnectGroupRequest, Operation>
        insertSettings;
    private final OperationCallSettings.Builder<
            InsertInterconnectGroupRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<
            ListInterconnectGroupsRequest, InterconnectGroupsListResponse, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<PatchInterconnectGroupRequest, Operation> patchSettings;
    private final OperationCallSettings.Builder<PatchInterconnectGroupRequest, Operation, Operation>
        patchOperationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyInterconnectGroupRequest, Policy>
        setIamPolicySettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>
        testIamPermissionsSettings;
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
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createMembersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMembersOperationSettings = OperationCallSettings.newBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getOperationalStatusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      patchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      patchOperationSettings = OperationCallSettings.newBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMembersSettings,
              deleteSettings,
              getSettings,
              getIamPolicySettings,
              getOperationalStatusSettings,
              insertSettings,
              listSettings,
              patchSettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(InterconnectGroupsStubSettings settings) {
      super(settings);

      createMembersSettings = settings.createMembersSettings.toBuilder();
      createMembersOperationSettings = settings.createMembersOperationSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      getOperationalStatusSettings = settings.getOperationalStatusSettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      patchSettings = settings.patchSettings.toBuilder();
      patchOperationSettings = settings.patchOperationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMembersSettings,
              deleteSettings,
              getSettings,
              getIamPolicySettings,
              getOperationalStatusSettings,
              insertSettings,
              listSettings,
              patchSettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createMembersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getOperationalStatusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .patchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createMembersOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMembersInterconnectGroupRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInterconnectGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertInterconnectGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .patchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PatchInterconnectGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to createMembers. */
    public UnaryCallSettings.Builder<CreateMembersInterconnectGroupRequest, Operation>
        createMembersSettings() {
      return createMembersSettings;
    }

    /** Returns the builder for the settings used for calls to createMembers. */
    public OperationCallSettings.Builder<
            CreateMembersInterconnectGroupRequest, Operation, Operation>
        createMembersOperationSettings() {
      return createMembersOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteInterconnectGroupRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteInterconnectGroupRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetInterconnectGroupRequest, InterconnectGroup> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyInterconnectGroupRequest, Policy>
        getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getOperationalStatus. */
    public UnaryCallSettings.Builder<
            GetOperationalStatusInterconnectGroupRequest,
            InterconnectGroupsGetOperationalStatusResponse>
        getOperationalStatusSettings() {
      return getOperationalStatusSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertInterconnectGroupRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertInterconnectGroupRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListInterconnectGroupsRequest, InterconnectGroupsListResponse, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchInterconnectGroupRequest, Operation> patchSettings() {
      return patchSettings;
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchInterconnectGroupRequest, Operation, Operation>
        patchOperationSettings() {
      return patchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyInterconnectGroupRequest, Policy>
        setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public InterconnectGroupsStubSettings build() throws IOException {
      return new InterconnectGroupsStubSettings(this);
    }
  }
}
