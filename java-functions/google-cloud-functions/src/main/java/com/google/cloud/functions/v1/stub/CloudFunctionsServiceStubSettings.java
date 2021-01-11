/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.functions.v1.stub;

import static com.google.cloud.functions.v1.CloudFunctionsServiceClient.ListFunctionsPagedResponse;

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
import com.google.cloud.functions.v1.CallFunctionRequest;
import com.google.cloud.functions.v1.CallFunctionResponse;
import com.google.cloud.functions.v1.CloudFunction;
import com.google.cloud.functions.v1.CreateFunctionRequest;
import com.google.cloud.functions.v1.DeleteFunctionRequest;
import com.google.cloud.functions.v1.GenerateDownloadUrlRequest;
import com.google.cloud.functions.v1.GenerateDownloadUrlResponse;
import com.google.cloud.functions.v1.GenerateUploadUrlRequest;
import com.google.cloud.functions.v1.GenerateUploadUrlResponse;
import com.google.cloud.functions.v1.GetFunctionRequest;
import com.google.cloud.functions.v1.ListFunctionsRequest;
import com.google.cloud.functions.v1.ListFunctionsResponse;
import com.google.cloud.functions.v1.OperationMetadataV1;
import com.google.cloud.functions.v1.UpdateFunctionRequest;
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
 * Settings class to configure an instance of {@link CloudFunctionsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudfunctions.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFunction to 30 seconds:
 *
 * <pre>{@code
 * CloudFunctionsServiceStubSettings.Builder cloudFunctionsServiceSettingsBuilder =
 *     CloudFunctionsServiceStubSettings.newBuilder();
 * cloudFunctionsServiceSettingsBuilder
 *     .getFunctionSettings()
 *     .setRetrySettings(
 *         cloudFunctionsServiceSettingsBuilder
 *             .getFunctionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudFunctionsServiceStubSettings cloudFunctionsServiceSettings =
 *     cloudFunctionsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudFunctionsServiceStubSettings
    extends StubSettings<CloudFunctionsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
      listFunctionsSettings;
  private final UnaryCallSettings<GetFunctionRequest, CloudFunction> getFunctionSettings;
  private final UnaryCallSettings<CreateFunctionRequest, Operation> createFunctionSettings;
  private final OperationCallSettings<CreateFunctionRequest, CloudFunction, OperationMetadataV1>
      createFunctionOperationSettings;
  private final UnaryCallSettings<UpdateFunctionRequest, Operation> updateFunctionSettings;
  private final OperationCallSettings<UpdateFunctionRequest, CloudFunction, OperationMetadataV1>
      updateFunctionOperationSettings;
  private final UnaryCallSettings<DeleteFunctionRequest, Operation> deleteFunctionSettings;
  private final OperationCallSettings<DeleteFunctionRequest, Empty, OperationMetadataV1>
      deleteFunctionOperationSettings;
  private final UnaryCallSettings<CallFunctionRequest, CallFunctionResponse> callFunctionSettings;
  private final UnaryCallSettings<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlSettings;
  private final UnaryCallSettings<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListFunctionsRequest, ListFunctionsResponse, CloudFunction>
      LIST_FUNCTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFunctionsRequest, ListFunctionsResponse, CloudFunction>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFunctionsRequest injectToken(ListFunctionsRequest payload, String token) {
              return ListFunctionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFunctionsRequest injectPageSize(ListFunctionsRequest payload, int pageSize) {
              return ListFunctionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFunctionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFunctionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CloudFunction> extractResources(ListFunctionsResponse payload) {
              return payload.getFunctionsList() == null
                  ? ImmutableList.<CloudFunction>of()
                  : payload.getFunctionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
      LIST_FUNCTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>() {
            @Override
            public ApiFuture<ListFunctionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFunctionsRequest, ListFunctionsResponse> callable,
                ListFunctionsRequest request,
                ApiCallContext context,
                ApiFuture<ListFunctionsResponse> futureResponse) {
              PageContext<ListFunctionsRequest, ListFunctionsResponse, CloudFunction> pageContext =
                  PageContext.create(callable, LIST_FUNCTIONS_PAGE_STR_DESC, request, context);
              return ListFunctionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listFunctions. */
  public PagedCallSettings<ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
      listFunctionsSettings() {
    return listFunctionsSettings;
  }

  /** Returns the object with the settings used for calls to getFunction. */
  public UnaryCallSettings<GetFunctionRequest, CloudFunction> getFunctionSettings() {
    return getFunctionSettings;
  }

  /** Returns the object with the settings used for calls to createFunction. */
  public UnaryCallSettings<CreateFunctionRequest, Operation> createFunctionSettings() {
    return createFunctionSettings;
  }

  /** Returns the object with the settings used for calls to createFunction. */
  public OperationCallSettings<CreateFunctionRequest, CloudFunction, OperationMetadataV1>
      createFunctionOperationSettings() {
    return createFunctionOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateFunction. */
  public UnaryCallSettings<UpdateFunctionRequest, Operation> updateFunctionSettings() {
    return updateFunctionSettings;
  }

  /** Returns the object with the settings used for calls to updateFunction. */
  public OperationCallSettings<UpdateFunctionRequest, CloudFunction, OperationMetadataV1>
      updateFunctionOperationSettings() {
    return updateFunctionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFunction. */
  public UnaryCallSettings<DeleteFunctionRequest, Operation> deleteFunctionSettings() {
    return deleteFunctionSettings;
  }

  /** Returns the object with the settings used for calls to deleteFunction. */
  public OperationCallSettings<DeleteFunctionRequest, Empty, OperationMetadataV1>
      deleteFunctionOperationSettings() {
    return deleteFunctionOperationSettings;
  }

  /** Returns the object with the settings used for calls to callFunction. */
  public UnaryCallSettings<CallFunctionRequest, CallFunctionResponse> callFunctionSettings() {
    return callFunctionSettings;
  }

  /** Returns the object with the settings used for calls to generateUploadUrl. */
  public UnaryCallSettings<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
      generateUploadUrlSettings() {
    return generateUploadUrlSettings;
  }

  /** Returns the object with the settings used for calls to generateDownloadUrl. */
  public UnaryCallSettings<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
      generateDownloadUrlSettings() {
    return generateDownloadUrlSettings;
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

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CloudFunctionsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudFunctionsServiceStub.create(this);
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
    return "cloudfunctions.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
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
            "gapic", GaxProperties.getLibraryVersion(CloudFunctionsServiceStubSettings.class))
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

  protected CloudFunctionsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listFunctionsSettings = settingsBuilder.listFunctionsSettings().build();
    getFunctionSettings = settingsBuilder.getFunctionSettings().build();
    createFunctionSettings = settingsBuilder.createFunctionSettings().build();
    createFunctionOperationSettings = settingsBuilder.createFunctionOperationSettings().build();
    updateFunctionSettings = settingsBuilder.updateFunctionSettings().build();
    updateFunctionOperationSettings = settingsBuilder.updateFunctionOperationSettings().build();
    deleteFunctionSettings = settingsBuilder.deleteFunctionSettings().build();
    deleteFunctionOperationSettings = settingsBuilder.deleteFunctionOperationSettings().build();
    callFunctionSettings = settingsBuilder.callFunctionSettings().build();
    generateUploadUrlSettings = settingsBuilder.generateUploadUrlSettings().build();
    generateDownloadUrlSettings = settingsBuilder.generateDownloadUrlSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for CloudFunctionsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CloudFunctionsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
        listFunctionsSettings;
    private final UnaryCallSettings.Builder<GetFunctionRequest, CloudFunction> getFunctionSettings;
    private final UnaryCallSettings.Builder<CreateFunctionRequest, Operation>
        createFunctionSettings;
    private final OperationCallSettings.Builder<
            CreateFunctionRequest, CloudFunction, OperationMetadataV1>
        createFunctionOperationSettings;
    private final UnaryCallSettings.Builder<UpdateFunctionRequest, Operation>
        updateFunctionSettings;
    private final OperationCallSettings.Builder<
            UpdateFunctionRequest, CloudFunction, OperationMetadataV1>
        updateFunctionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFunctionRequest, Operation>
        deleteFunctionSettings;
    private final OperationCallSettings.Builder<DeleteFunctionRequest, Empty, OperationMetadataV1>
        deleteFunctionOperationSettings;
    private final UnaryCallSettings.Builder<CallFunctionRequest, CallFunctionResponse>
        callFunctionSettings;
    private final UnaryCallSettings.Builder<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
        generateUploadUrlSettings;
    private final UnaryCallSettings.Builder<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
        generateDownloadUrlSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listFunctionsSettings = PagedCallSettings.newBuilder(LIST_FUNCTIONS_PAGE_STR_FACT);
      getFunctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFunctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFunctionOperationSettings = OperationCallSettings.newBuilder();
      updateFunctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFunctionOperationSettings = OperationCallSettings.newBuilder();
      deleteFunctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFunctionOperationSettings = OperationCallSettings.newBuilder();
      callFunctionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateUploadUrlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateDownloadUrlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFunctionsSettings,
              getFunctionSettings,
              createFunctionSettings,
              updateFunctionSettings,
              deleteFunctionSettings,
              callFunctionSettings,
              generateUploadUrlSettings,
              generateDownloadUrlSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(CloudFunctionsServiceStubSettings settings) {
      super(settings);

      listFunctionsSettings = settings.listFunctionsSettings.toBuilder();
      getFunctionSettings = settings.getFunctionSettings.toBuilder();
      createFunctionSettings = settings.createFunctionSettings.toBuilder();
      createFunctionOperationSettings = settings.createFunctionOperationSettings.toBuilder();
      updateFunctionSettings = settings.updateFunctionSettings.toBuilder();
      updateFunctionOperationSettings = settings.updateFunctionOperationSettings.toBuilder();
      deleteFunctionSettings = settings.deleteFunctionSettings.toBuilder();
      deleteFunctionOperationSettings = settings.deleteFunctionOperationSettings.toBuilder();
      callFunctionSettings = settings.callFunctionSettings.toBuilder();
      generateUploadUrlSettings = settings.generateUploadUrlSettings.toBuilder();
      generateDownloadUrlSettings = settings.generateDownloadUrlSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFunctionsSettings,
              getFunctionSettings,
              createFunctionSettings,
              updateFunctionSettings,
              deleteFunctionSettings,
              callFunctionSettings,
              generateUploadUrlSettings,
              generateDownloadUrlSettings,
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

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listFunctionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getFunctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFunctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateFunctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteFunctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .callFunctionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .generateUploadUrlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .generateDownloadUrlSettings()
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
          .createFunctionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFunctionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CloudFunction.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadataV1.class))
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
          .updateFunctionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFunctionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CloudFunction.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadataV1.class))
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
          .deleteFunctionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFunctionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadataV1.class))
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

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listFunctions. */
    public PagedCallSettings.Builder<
            ListFunctionsRequest, ListFunctionsResponse, ListFunctionsPagedResponse>
        listFunctionsSettings() {
      return listFunctionsSettings;
    }

    /** Returns the builder for the settings used for calls to getFunction. */
    public UnaryCallSettings.Builder<GetFunctionRequest, CloudFunction> getFunctionSettings() {
      return getFunctionSettings;
    }

    /** Returns the builder for the settings used for calls to createFunction. */
    public UnaryCallSettings.Builder<CreateFunctionRequest, Operation> createFunctionSettings() {
      return createFunctionSettings;
    }

    /** Returns the builder for the settings used for calls to createFunction. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateFunctionRequest, CloudFunction, OperationMetadataV1>
        createFunctionOperationSettings() {
      return createFunctionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFunction. */
    public UnaryCallSettings.Builder<UpdateFunctionRequest, Operation> updateFunctionSettings() {
      return updateFunctionSettings;
    }

    /** Returns the builder for the settings used for calls to updateFunction. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateFunctionRequest, CloudFunction, OperationMetadataV1>
        updateFunctionOperationSettings() {
      return updateFunctionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFunction. */
    public UnaryCallSettings.Builder<DeleteFunctionRequest, Operation> deleteFunctionSettings() {
      return deleteFunctionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFunction. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteFunctionRequest, Empty, OperationMetadataV1>
        deleteFunctionOperationSettings() {
      return deleteFunctionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to callFunction. */
    public UnaryCallSettings.Builder<CallFunctionRequest, CallFunctionResponse>
        callFunctionSettings() {
      return callFunctionSettings;
    }

    /** Returns the builder for the settings used for calls to generateUploadUrl. */
    public UnaryCallSettings.Builder<GenerateUploadUrlRequest, GenerateUploadUrlResponse>
        generateUploadUrlSettings() {
      return generateUploadUrlSettings;
    }

    /** Returns the builder for the settings used for calls to generateDownloadUrl. */
    public UnaryCallSettings.Builder<GenerateDownloadUrlRequest, GenerateDownloadUrlResponse>
        generateDownloadUrlSettings() {
      return generateDownloadUrlSettings;
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
    public CloudFunctionsServiceStubSettings build() throws IOException {
      return new CloudFunctionsServiceStubSettings(this);
    }
  }
}
