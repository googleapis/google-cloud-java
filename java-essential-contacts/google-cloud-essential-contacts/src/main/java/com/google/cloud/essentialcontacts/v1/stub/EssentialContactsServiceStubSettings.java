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

package com.google.cloud.essentialcontacts.v1.stub;

import static com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient.ComputeContactsPagedResponse;
import static com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient.ListContactsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
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
import com.google.cloud.essentialcontacts.v1.ComputeContactsRequest;
import com.google.cloud.essentialcontacts.v1.ComputeContactsResponse;
import com.google.cloud.essentialcontacts.v1.Contact;
import com.google.cloud.essentialcontacts.v1.CreateContactRequest;
import com.google.cloud.essentialcontacts.v1.DeleteContactRequest;
import com.google.cloud.essentialcontacts.v1.GetContactRequest;
import com.google.cloud.essentialcontacts.v1.ListContactsRequest;
import com.google.cloud.essentialcontacts.v1.ListContactsResponse;
import com.google.cloud.essentialcontacts.v1.SendTestMessageRequest;
import com.google.cloud.essentialcontacts.v1.UpdateContactRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EssentialContactsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (essentialcontacts.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createContact to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EssentialContactsServiceStubSettings.Builder essentialContactsServiceSettingsBuilder =
 *     EssentialContactsServiceStubSettings.newBuilder();
 * essentialContactsServiceSettingsBuilder
 *     .createContactSettings()
 *     .setRetrySettings(
 *         essentialContactsServiceSettingsBuilder
 *             .createContactSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EssentialContactsServiceStubSettings essentialContactsServiceSettings =
 *     essentialContactsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EssentialContactsServiceStubSettings
    extends StubSettings<EssentialContactsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateContactRequest, Contact> createContactSettings;
  private final UnaryCallSettings<UpdateContactRequest, Contact> updateContactSettings;
  private final PagedCallSettings<
          ListContactsRequest, ListContactsResponse, ListContactsPagedResponse>
      listContactsSettings;
  private final UnaryCallSettings<GetContactRequest, Contact> getContactSettings;
  private final UnaryCallSettings<DeleteContactRequest, Empty> deleteContactSettings;
  private final PagedCallSettings<
          ComputeContactsRequest, ComputeContactsResponse, ComputeContactsPagedResponse>
      computeContactsSettings;
  private final UnaryCallSettings<SendTestMessageRequest, Empty> sendTestMessageSettings;

  private static final PagedListDescriptor<ListContactsRequest, ListContactsResponse, Contact>
      LIST_CONTACTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListContactsRequest, ListContactsResponse, Contact>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListContactsRequest injectToken(ListContactsRequest payload, String token) {
              return ListContactsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListContactsRequest injectPageSize(ListContactsRequest payload, int pageSize) {
              return ListContactsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListContactsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListContactsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Contact> extractResources(ListContactsResponse payload) {
              return payload.getContactsList() == null
                  ? ImmutableList.<Contact>of()
                  : payload.getContactsList();
            }
          };

  private static final PagedListDescriptor<ComputeContactsRequest, ComputeContactsResponse, Contact>
      COMPUTE_CONTACTS_PAGE_STR_DESC =
          new PagedListDescriptor<ComputeContactsRequest, ComputeContactsResponse, Contact>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ComputeContactsRequest injectToken(
                ComputeContactsRequest payload, String token) {
              return ComputeContactsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ComputeContactsRequest injectPageSize(
                ComputeContactsRequest payload, int pageSize) {
              return ComputeContactsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ComputeContactsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ComputeContactsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Contact> extractResources(ComputeContactsResponse payload) {
              return payload.getContactsList() == null
                  ? ImmutableList.<Contact>of()
                  : payload.getContactsList();
            }
          };

  private static final PagedListResponseFactory<
          ListContactsRequest, ListContactsResponse, ListContactsPagedResponse>
      LIST_CONTACTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListContactsRequest, ListContactsResponse, ListContactsPagedResponse>() {
            @Override
            public ApiFuture<ListContactsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListContactsRequest, ListContactsResponse> callable,
                ListContactsRequest request,
                ApiCallContext context,
                ApiFuture<ListContactsResponse> futureResponse) {
              PageContext<ListContactsRequest, ListContactsResponse, Contact> pageContext =
                  PageContext.create(callable, LIST_CONTACTS_PAGE_STR_DESC, request, context);
              return ListContactsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ComputeContactsRequest, ComputeContactsResponse, ComputeContactsPagedResponse>
      COMPUTE_CONTACTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ComputeContactsRequest, ComputeContactsResponse, ComputeContactsPagedResponse>() {
            @Override
            public ApiFuture<ComputeContactsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ComputeContactsRequest, ComputeContactsResponse> callable,
                ComputeContactsRequest request,
                ApiCallContext context,
                ApiFuture<ComputeContactsResponse> futureResponse) {
              PageContext<ComputeContactsRequest, ComputeContactsResponse, Contact> pageContext =
                  PageContext.create(callable, COMPUTE_CONTACTS_PAGE_STR_DESC, request, context);
              return ComputeContactsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createContact. */
  public UnaryCallSettings<CreateContactRequest, Contact> createContactSettings() {
    return createContactSettings;
  }

  /** Returns the object with the settings used for calls to updateContact. */
  public UnaryCallSettings<UpdateContactRequest, Contact> updateContactSettings() {
    return updateContactSettings;
  }

  /** Returns the object with the settings used for calls to listContacts. */
  public PagedCallSettings<ListContactsRequest, ListContactsResponse, ListContactsPagedResponse>
      listContactsSettings() {
    return listContactsSettings;
  }

  /** Returns the object with the settings used for calls to getContact. */
  public UnaryCallSettings<GetContactRequest, Contact> getContactSettings() {
    return getContactSettings;
  }

  /** Returns the object with the settings used for calls to deleteContact. */
  public UnaryCallSettings<DeleteContactRequest, Empty> deleteContactSettings() {
    return deleteContactSettings;
  }

  /** Returns the object with the settings used for calls to computeContacts. */
  public PagedCallSettings<
          ComputeContactsRequest, ComputeContactsResponse, ComputeContactsPagedResponse>
      computeContactsSettings() {
    return computeContactsSettings;
  }

  /** Returns the object with the settings used for calls to sendTestMessage. */
  public UnaryCallSettings<SendTestMessageRequest, Empty> sendTestMessageSettings() {
    return sendTestMessageSettings;
  }

  public EssentialContactsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEssentialContactsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEssentialContactsServiceStub.create(this);
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
    return "essentialcontacts.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "essentialcontacts.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(EssentialContactsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EssentialContactsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EssentialContactsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EssentialContactsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createContactSettings = settingsBuilder.createContactSettings().build();
    updateContactSettings = settingsBuilder.updateContactSettings().build();
    listContactsSettings = settingsBuilder.listContactsSettings().build();
    getContactSettings = settingsBuilder.getContactSettings().build();
    deleteContactSettings = settingsBuilder.deleteContactSettings().build();
    computeContactsSettings = settingsBuilder.computeContactsSettings().build();
    sendTestMessageSettings = settingsBuilder.sendTestMessageSettings().build();
  }

  /** Builder for EssentialContactsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<EssentialContactsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateContactRequest, Contact> createContactSettings;
    private final UnaryCallSettings.Builder<UpdateContactRequest, Contact> updateContactSettings;
    private final PagedCallSettings.Builder<
            ListContactsRequest, ListContactsResponse, ListContactsPagedResponse>
        listContactsSettings;
    private final UnaryCallSettings.Builder<GetContactRequest, Contact> getContactSettings;
    private final UnaryCallSettings.Builder<DeleteContactRequest, Empty> deleteContactSettings;
    private final PagedCallSettings.Builder<
            ComputeContactsRequest, ComputeContactsResponse, ComputeContactsPagedResponse>
        computeContactsSettings;
    private final UnaryCallSettings.Builder<SendTestMessageRequest, Empty> sendTestMessageSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createContactSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateContactSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listContactsSettings = PagedCallSettings.newBuilder(LIST_CONTACTS_PAGE_STR_FACT);
      getContactSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteContactSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      computeContactsSettings = PagedCallSettings.newBuilder(COMPUTE_CONTACTS_PAGE_STR_FACT);
      sendTestMessageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createContactSettings,
              updateContactSettings,
              listContactsSettings,
              getContactSettings,
              deleteContactSettings,
              computeContactsSettings,
              sendTestMessageSettings);
      initDefaults(this);
    }

    protected Builder(EssentialContactsServiceStubSettings settings) {
      super(settings);

      createContactSettings = settings.createContactSettings.toBuilder();
      updateContactSettings = settings.updateContactSettings.toBuilder();
      listContactsSettings = settings.listContactsSettings.toBuilder();
      getContactSettings = settings.getContactSettings.toBuilder();
      deleteContactSettings = settings.deleteContactSettings.toBuilder();
      computeContactsSettings = settings.computeContactsSettings.toBuilder();
      sendTestMessageSettings = settings.sendTestMessageSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createContactSettings,
              updateContactSettings,
              listContactsSettings,
              getContactSettings,
              deleteContactSettings,
              computeContactsSettings,
              sendTestMessageSettings);
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
          .createContactSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateContactSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listContactsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getContactSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteContactSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .computeContactsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .sendTestMessageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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

    /** Returns the builder for the settings used for calls to createContact. */
    public UnaryCallSettings.Builder<CreateContactRequest, Contact> createContactSettings() {
      return createContactSettings;
    }

    /** Returns the builder for the settings used for calls to updateContact. */
    public UnaryCallSettings.Builder<UpdateContactRequest, Contact> updateContactSettings() {
      return updateContactSettings;
    }

    /** Returns the builder for the settings used for calls to listContacts. */
    public PagedCallSettings.Builder<
            ListContactsRequest, ListContactsResponse, ListContactsPagedResponse>
        listContactsSettings() {
      return listContactsSettings;
    }

    /** Returns the builder for the settings used for calls to getContact. */
    public UnaryCallSettings.Builder<GetContactRequest, Contact> getContactSettings() {
      return getContactSettings;
    }

    /** Returns the builder for the settings used for calls to deleteContact. */
    public UnaryCallSettings.Builder<DeleteContactRequest, Empty> deleteContactSettings() {
      return deleteContactSettings;
    }

    /** Returns the builder for the settings used for calls to computeContacts. */
    public PagedCallSettings.Builder<
            ComputeContactsRequest, ComputeContactsResponse, ComputeContactsPagedResponse>
        computeContactsSettings() {
      return computeContactsSettings;
    }

    /** Returns the builder for the settings used for calls to sendTestMessage. */
    public UnaryCallSettings.Builder<SendTestMessageRequest, Empty> sendTestMessageSettings() {
      return sendTestMessageSettings;
    }

    @Override
    public EssentialContactsServiceStubSettings build() throws IOException {
      return new EssentialContactsServiceStubSettings(this);
    }
  }
}
