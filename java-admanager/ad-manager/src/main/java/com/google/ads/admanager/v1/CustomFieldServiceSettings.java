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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.CustomFieldServiceClient.ListCustomFieldsPagedResponse;

import com.google.ads.admanager.v1.stub.CustomFieldServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CustomFieldServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getCustomField:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CustomFieldServiceSettings.Builder customFieldServiceSettingsBuilder =
 *     CustomFieldServiceSettings.newBuilder();
 * customFieldServiceSettingsBuilder
 *     .getCustomFieldSettings()
 *     .setRetrySettings(
 *         customFieldServiceSettingsBuilder
 *             .getCustomFieldSettings()
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
 * CustomFieldServiceSettings customFieldServiceSettings =
 *     customFieldServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class CustomFieldServiceSettings extends ClientSettings<CustomFieldServiceSettings> {

  /** Returns the object with the settings used for calls to getCustomField. */
  public UnaryCallSettings<GetCustomFieldRequest, CustomField> getCustomFieldSettings() {
    return ((CustomFieldServiceStubSettings) getStubSettings()).getCustomFieldSettings();
  }

  /** Returns the object with the settings used for calls to listCustomFields. */
  public PagedCallSettings<
          ListCustomFieldsRequest, ListCustomFieldsResponse, ListCustomFieldsPagedResponse>
      listCustomFieldsSettings() {
    return ((CustomFieldServiceStubSettings) getStubSettings()).listCustomFieldsSettings();
  }

  /** Returns the object with the settings used for calls to createCustomField. */
  public UnaryCallSettings<CreateCustomFieldRequest, CustomField> createCustomFieldSettings() {
    return ((CustomFieldServiceStubSettings) getStubSettings()).createCustomFieldSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateCustomFields. */
  public UnaryCallSettings<BatchCreateCustomFieldsRequest, BatchCreateCustomFieldsResponse>
      batchCreateCustomFieldsSettings() {
    return ((CustomFieldServiceStubSettings) getStubSettings()).batchCreateCustomFieldsSettings();
  }

  /** Returns the object with the settings used for calls to updateCustomField. */
  public UnaryCallSettings<UpdateCustomFieldRequest, CustomField> updateCustomFieldSettings() {
    return ((CustomFieldServiceStubSettings) getStubSettings()).updateCustomFieldSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateCustomFields. */
  public UnaryCallSettings<BatchUpdateCustomFieldsRequest, BatchUpdateCustomFieldsResponse>
      batchUpdateCustomFieldsSettings() {
    return ((CustomFieldServiceStubSettings) getStubSettings()).batchUpdateCustomFieldsSettings();
  }

  /** Returns the object with the settings used for calls to batchActivateCustomFields. */
  public UnaryCallSettings<BatchActivateCustomFieldsRequest, BatchActivateCustomFieldsResponse>
      batchActivateCustomFieldsSettings() {
    return ((CustomFieldServiceStubSettings) getStubSettings()).batchActivateCustomFieldsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeactivateCustomFields. */
  public UnaryCallSettings<BatchDeactivateCustomFieldsRequest, BatchDeactivateCustomFieldsResponse>
      batchDeactivateCustomFieldsSettings() {
    return ((CustomFieldServiceStubSettings) getStubSettings())
        .batchDeactivateCustomFieldsSettings();
  }

  public static final CustomFieldServiceSettings create(CustomFieldServiceStubSettings stub)
      throws IOException {
    return new CustomFieldServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CustomFieldServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CustomFieldServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CustomFieldServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CustomFieldServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CustomFieldServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CustomFieldServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CustomFieldServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CustomFieldServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CustomFieldServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CustomFieldServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CustomFieldServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CustomFieldServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CustomFieldServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CustomFieldServiceStubSettings.newBuilder());
    }

    public CustomFieldServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CustomFieldServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getCustomField. */
    public UnaryCallSettings.Builder<GetCustomFieldRequest, CustomField> getCustomFieldSettings() {
      return getStubSettingsBuilder().getCustomFieldSettings();
    }

    /** Returns the builder for the settings used for calls to listCustomFields. */
    public PagedCallSettings.Builder<
            ListCustomFieldsRequest, ListCustomFieldsResponse, ListCustomFieldsPagedResponse>
        listCustomFieldsSettings() {
      return getStubSettingsBuilder().listCustomFieldsSettings();
    }

    /** Returns the builder for the settings used for calls to createCustomField. */
    public UnaryCallSettings.Builder<CreateCustomFieldRequest, CustomField>
        createCustomFieldSettings() {
      return getStubSettingsBuilder().createCustomFieldSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateCustomFields. */
    public UnaryCallSettings.Builder<
            BatchCreateCustomFieldsRequest, BatchCreateCustomFieldsResponse>
        batchCreateCustomFieldsSettings() {
      return getStubSettingsBuilder().batchCreateCustomFieldsSettings();
    }

    /** Returns the builder for the settings used for calls to updateCustomField. */
    public UnaryCallSettings.Builder<UpdateCustomFieldRequest, CustomField>
        updateCustomFieldSettings() {
      return getStubSettingsBuilder().updateCustomFieldSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateCustomFields. */
    public UnaryCallSettings.Builder<
            BatchUpdateCustomFieldsRequest, BatchUpdateCustomFieldsResponse>
        batchUpdateCustomFieldsSettings() {
      return getStubSettingsBuilder().batchUpdateCustomFieldsSettings();
    }

    /** Returns the builder for the settings used for calls to batchActivateCustomFields. */
    public UnaryCallSettings.Builder<
            BatchActivateCustomFieldsRequest, BatchActivateCustomFieldsResponse>
        batchActivateCustomFieldsSettings() {
      return getStubSettingsBuilder().batchActivateCustomFieldsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeactivateCustomFields. */
    public UnaryCallSettings.Builder<
            BatchDeactivateCustomFieldsRequest, BatchDeactivateCustomFieldsResponse>
        batchDeactivateCustomFieldsSettings() {
      return getStubSettingsBuilder().batchDeactivateCustomFieldsSettings();
    }

    @Override
    public CustomFieldServiceSettings build() throws IOException {
      return new CustomFieldServiceSettings(this);
    }
  }
}
