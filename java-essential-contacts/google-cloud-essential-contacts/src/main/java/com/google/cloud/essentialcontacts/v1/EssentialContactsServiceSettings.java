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

package com.google.cloud.essentialcontacts.v1;

import static com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient.ComputeContactsPagedResponse;
import static com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient.ListContactsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.essentialcontacts.v1.stub.EssentialContactsServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EssentialContactsServiceClient}.
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
 * EssentialContactsServiceSettings.Builder essentialContactsServiceSettingsBuilder =
 *     EssentialContactsServiceSettings.newBuilder();
 * essentialContactsServiceSettingsBuilder
 *     .createContactSettings()
 *     .setRetrySettings(
 *         essentialContactsServiceSettingsBuilder
 *             .createContactSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EssentialContactsServiceSettings essentialContactsServiceSettings =
 *     essentialContactsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EssentialContactsServiceSettings
    extends ClientSettings<EssentialContactsServiceSettings> {

  /** Returns the object with the settings used for calls to createContact. */
  public UnaryCallSettings<CreateContactRequest, Contact> createContactSettings() {
    return ((EssentialContactsServiceStubSettings) getStubSettings()).createContactSettings();
  }

  /** Returns the object with the settings used for calls to updateContact. */
  public UnaryCallSettings<UpdateContactRequest, Contact> updateContactSettings() {
    return ((EssentialContactsServiceStubSettings) getStubSettings()).updateContactSettings();
  }

  /** Returns the object with the settings used for calls to listContacts. */
  public PagedCallSettings<ListContactsRequest, ListContactsResponse, ListContactsPagedResponse>
      listContactsSettings() {
    return ((EssentialContactsServiceStubSettings) getStubSettings()).listContactsSettings();
  }

  /** Returns the object with the settings used for calls to getContact. */
  public UnaryCallSettings<GetContactRequest, Contact> getContactSettings() {
    return ((EssentialContactsServiceStubSettings) getStubSettings()).getContactSettings();
  }

  /** Returns the object with the settings used for calls to deleteContact. */
  public UnaryCallSettings<DeleteContactRequest, Empty> deleteContactSettings() {
    return ((EssentialContactsServiceStubSettings) getStubSettings()).deleteContactSettings();
  }

  /** Returns the object with the settings used for calls to computeContacts. */
  public PagedCallSettings<
          ComputeContactsRequest, ComputeContactsResponse, ComputeContactsPagedResponse>
      computeContactsSettings() {
    return ((EssentialContactsServiceStubSettings) getStubSettings()).computeContactsSettings();
  }

  /** Returns the object with the settings used for calls to sendTestMessage. */
  public UnaryCallSettings<SendTestMessageRequest, Empty> sendTestMessageSettings() {
    return ((EssentialContactsServiceStubSettings) getStubSettings()).sendTestMessageSettings();
  }

  public static final EssentialContactsServiceSettings create(
      EssentialContactsServiceStubSettings stub) throws IOException {
    return new EssentialContactsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EssentialContactsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EssentialContactsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EssentialContactsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EssentialContactsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EssentialContactsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return EssentialContactsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EssentialContactsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EssentialContactsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected EssentialContactsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for EssentialContactsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<EssentialContactsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(EssentialContactsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(EssentialContactsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EssentialContactsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(EssentialContactsServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(EssentialContactsServiceStubSettings.newHttpJsonBuilder());
    }

    public EssentialContactsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((EssentialContactsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createContact. */
    public UnaryCallSettings.Builder<CreateContactRequest, Contact> createContactSettings() {
      return getStubSettingsBuilder().createContactSettings();
    }

    /** Returns the builder for the settings used for calls to updateContact. */
    public UnaryCallSettings.Builder<UpdateContactRequest, Contact> updateContactSettings() {
      return getStubSettingsBuilder().updateContactSettings();
    }

    /** Returns the builder for the settings used for calls to listContacts. */
    public PagedCallSettings.Builder<
            ListContactsRequest, ListContactsResponse, ListContactsPagedResponse>
        listContactsSettings() {
      return getStubSettingsBuilder().listContactsSettings();
    }

    /** Returns the builder for the settings used for calls to getContact. */
    public UnaryCallSettings.Builder<GetContactRequest, Contact> getContactSettings() {
      return getStubSettingsBuilder().getContactSettings();
    }

    /** Returns the builder for the settings used for calls to deleteContact. */
    public UnaryCallSettings.Builder<DeleteContactRequest, Empty> deleteContactSettings() {
      return getStubSettingsBuilder().deleteContactSettings();
    }

    /** Returns the builder for the settings used for calls to computeContacts. */
    public PagedCallSettings.Builder<
            ComputeContactsRequest, ComputeContactsResponse, ComputeContactsPagedResponse>
        computeContactsSettings() {
      return getStubSettingsBuilder().computeContactsSettings();
    }

    /** Returns the builder for the settings used for calls to sendTestMessage. */
    public UnaryCallSettings.Builder<SendTestMessageRequest, Empty> sendTestMessageSettings() {
      return getStubSettingsBuilder().sendTestMessageSettings();
    }

    @Override
    public EssentialContactsServiceSettings build() throws IOException {
      return new EssentialContactsServiceSettings(this);
    }
  }
}
