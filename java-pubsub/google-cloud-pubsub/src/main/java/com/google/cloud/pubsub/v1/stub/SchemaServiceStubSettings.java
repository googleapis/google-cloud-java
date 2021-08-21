/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.pubsub.v1.stub;

import static com.google.cloud.pubsub.v1.SchemaServiceClient.ListSchemasPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.CreateSchemaRequest;
import com.google.pubsub.v1.DeleteSchemaRequest;
import com.google.pubsub.v1.GetSchemaRequest;
import com.google.pubsub.v1.ListSchemasRequest;
import com.google.pubsub.v1.ListSchemasResponse;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.ValidateMessageRequest;
import com.google.pubsub.v1.ValidateMessageResponse;
import com.google.pubsub.v1.ValidateSchemaRequest;
import com.google.pubsub.v1.ValidateSchemaResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SchemaServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (pubsub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createSchema to 30 seconds:
 *
 * <pre>{@code
 * SchemaServiceStubSettings.Builder schemaServiceSettingsBuilder =
 *     SchemaServiceStubSettings.newBuilder();
 * schemaServiceSettingsBuilder
 *     .createSchemaSettings()
 *     .setRetrySettings(
 *         schemaServiceSettingsBuilder
 *             .createSchemaSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SchemaServiceStubSettings schemaServiceSettings = schemaServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SchemaServiceStubSettings extends StubSettings<SchemaServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/pubsub")
          .build();

  private final UnaryCallSettings<CreateSchemaRequest, Schema> createSchemaSettings;
  private final UnaryCallSettings<GetSchemaRequest, Schema> getSchemaSettings;
  private final PagedCallSettings<ListSchemasRequest, ListSchemasResponse, ListSchemasPagedResponse>
      listSchemasSettings;
  private final UnaryCallSettings<DeleteSchemaRequest, Empty> deleteSchemaSettings;
  private final UnaryCallSettings<ValidateSchemaRequest, ValidateSchemaResponse>
      validateSchemaSettings;
  private final UnaryCallSettings<ValidateMessageRequest, ValidateMessageResponse>
      validateMessageSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListSchemasRequest, ListSchemasResponse, Schema>
      LIST_SCHEMAS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSchemasRequest, ListSchemasResponse, Schema>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSchemasRequest injectToken(ListSchemasRequest payload, String token) {
              return ListSchemasRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSchemasRequest injectPageSize(ListSchemasRequest payload, int pageSize) {
              return ListSchemasRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSchemasRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSchemasResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Schema> extractResources(ListSchemasResponse payload) {
              return payload.getSchemasList() == null
                  ? ImmutableList.<Schema>of()
                  : payload.getSchemasList();
            }
          };

  private static final PagedListResponseFactory<
          ListSchemasRequest, ListSchemasResponse, ListSchemasPagedResponse>
      LIST_SCHEMAS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSchemasRequest, ListSchemasResponse, ListSchemasPagedResponse>() {
            @Override
            public ApiFuture<ListSchemasPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSchemasRequest, ListSchemasResponse> callable,
                ListSchemasRequest request,
                ApiCallContext context,
                ApiFuture<ListSchemasResponse> futureResponse) {
              PageContext<ListSchemasRequest, ListSchemasResponse, Schema> pageContext =
                  PageContext.create(callable, LIST_SCHEMAS_PAGE_STR_DESC, request, context);
              return ListSchemasPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createSchema. */
  public UnaryCallSettings<CreateSchemaRequest, Schema> createSchemaSettings() {
    return createSchemaSettings;
  }

  /** Returns the object with the settings used for calls to getSchema. */
  public UnaryCallSettings<GetSchemaRequest, Schema> getSchemaSettings() {
    return getSchemaSettings;
  }

  /** Returns the object with the settings used for calls to listSchemas. */
  public PagedCallSettings<ListSchemasRequest, ListSchemasResponse, ListSchemasPagedResponse>
      listSchemasSettings() {
    return listSchemasSettings;
  }

  /** Returns the object with the settings used for calls to deleteSchema. */
  public UnaryCallSettings<DeleteSchemaRequest, Empty> deleteSchemaSettings() {
    return deleteSchemaSettings;
  }

  /** Returns the object with the settings used for calls to validateSchema. */
  public UnaryCallSettings<ValidateSchemaRequest, ValidateSchemaResponse> validateSchemaSettings() {
    return validateSchemaSettings;
  }

  /** Returns the object with the settings used for calls to validateMessage. */
  public UnaryCallSettings<ValidateMessageRequest, ValidateMessageResponse>
      validateMessageSettings() {
    return validateMessageSettings;
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
  public SchemaServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSchemaServiceStub.create(this);
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
    return "pubsub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "pubsub.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SchemaServiceStubSettings.class))
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

  protected SchemaServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSchemaSettings = settingsBuilder.createSchemaSettings().build();
    getSchemaSettings = settingsBuilder.getSchemaSettings().build();
    listSchemasSettings = settingsBuilder.listSchemasSettings().build();
    deleteSchemaSettings = settingsBuilder.deleteSchemaSettings().build();
    validateSchemaSettings = settingsBuilder.validateSchemaSettings().build();
    validateMessageSettings = settingsBuilder.validateMessageSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for SchemaServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<SchemaServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateSchemaRequest, Schema> createSchemaSettings;
    private final UnaryCallSettings.Builder<GetSchemaRequest, Schema> getSchemaSettings;
    private final PagedCallSettings.Builder<
            ListSchemasRequest, ListSchemasResponse, ListSchemasPagedResponse>
        listSchemasSettings;
    private final UnaryCallSettings.Builder<DeleteSchemaRequest, Empty> deleteSchemaSettings;
    private final UnaryCallSettings.Builder<ValidateSchemaRequest, ValidateSchemaResponse>
        validateSchemaSettings;
    private final UnaryCallSettings.Builder<ValidateMessageRequest, ValidateMessageResponse>
        validateMessageSettings;
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

      createSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSchemasSettings = PagedCallSettings.newBuilder(LIST_SCHEMAS_PAGE_STR_FACT);
      deleteSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      validateSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      validateMessageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSchemaSettings,
              getSchemaSettings,
              listSchemasSettings,
              deleteSchemaSettings,
              validateSchemaSettings,
              validateMessageSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(SchemaServiceStubSettings settings) {
      super(settings);

      createSchemaSettings = settings.createSchemaSettings.toBuilder();
      getSchemaSettings = settings.getSchemaSettings.toBuilder();
      listSchemasSettings = settings.listSchemasSettings.toBuilder();
      deleteSchemaSettings = settings.deleteSchemaSettings.toBuilder();
      validateSchemaSettings = settings.validateSchemaSettings.toBuilder();
      validateMessageSettings = settings.validateMessageSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSchemaSettings,
              getSchemaSettings,
              listSchemasSettings,
              deleteSchemaSettings,
              validateSchemaSettings,
              validateMessageSettings,
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
          .createSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSchemasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .validateSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .validateMessageSettings()
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

    /** Returns the builder for the settings used for calls to createSchema. */
    public UnaryCallSettings.Builder<CreateSchemaRequest, Schema> createSchemaSettings() {
      return createSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to getSchema. */
    public UnaryCallSettings.Builder<GetSchemaRequest, Schema> getSchemaSettings() {
      return getSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to listSchemas. */
    public PagedCallSettings.Builder<
            ListSchemasRequest, ListSchemasResponse, ListSchemasPagedResponse>
        listSchemasSettings() {
      return listSchemasSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSchema. */
    public UnaryCallSettings.Builder<DeleteSchemaRequest, Empty> deleteSchemaSettings() {
      return deleteSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to validateSchema. */
    public UnaryCallSettings.Builder<ValidateSchemaRequest, ValidateSchemaResponse>
        validateSchemaSettings() {
      return validateSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to validateMessage. */
    public UnaryCallSettings.Builder<ValidateMessageRequest, ValidateMessageResponse>
        validateMessageSettings() {
      return validateMessageSettings;
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
    public SchemaServiceStubSettings build() throws IOException {
      return new SchemaServiceStubSettings(this);
    }
  }
}
