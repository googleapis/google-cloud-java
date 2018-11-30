/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.AddressClient.AggregatedListAddressesPagedResponse;
import static com.google.cloud.compute.v1.AddressClient.ListAddressesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.AddressStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link AddressClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteAddress to 30 seconds:
 *
 * <pre>
 * <code>
 * AddressSettings.Builder addressSettingsBuilder =
 *     AddressSettings.newBuilder();
 * addressSettingsBuilder.deleteAddressSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * AddressSettings addressSettings = addressSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AddressSettings extends ClientSettings<AddressSettings> {
  /** Returns the object with the settings used for calls to aggregatedListAddresses. */
  public PagedCallSettings<
          AggregatedListAddressesHttpRequest,
          AddressAggregatedList,
          AggregatedListAddressesPagedResponse>
      aggregatedListAddressesSettings() {
    return ((AddressStubSettings) getStubSettings()).aggregatedListAddressesSettings();
  }

  /** Returns the object with the settings used for calls to deleteAddress. */
  public UnaryCallSettings<DeleteAddressHttpRequest, Operation> deleteAddressSettings() {
    return ((AddressStubSettings) getStubSettings()).deleteAddressSettings();
  }

  /** Returns the object with the settings used for calls to getAddress. */
  public UnaryCallSettings<GetAddressHttpRequest, Address> getAddressSettings() {
    return ((AddressStubSettings) getStubSettings()).getAddressSettings();
  }

  /** Returns the object with the settings used for calls to insertAddress. */
  public UnaryCallSettings<InsertAddressHttpRequest, Operation> insertAddressSettings() {
    return ((AddressStubSettings) getStubSettings()).insertAddressSettings();
  }

  /** Returns the object with the settings used for calls to listAddresses. */
  public PagedCallSettings<ListAddressesHttpRequest, AddressList, ListAddressesPagedResponse>
      listAddressesSettings() {
    return ((AddressStubSettings) getStubSettings()).listAddressesSettings();
  }

  public static final AddressSettings create(AddressStubSettings stub) throws IOException {
    return new AddressSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AddressStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AddressStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return AddressStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AddressStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AddressStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AddressStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AddressStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AddressStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AddressSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AddressSettings. */
  public static class Builder extends ClientSettings.Builder<AddressSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(AddressStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(AddressStubSettings.newBuilder());
    }

    protected Builder(AddressSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AddressStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public AddressStubSettings.Builder getStubSettingsBuilder() {
      return ((AddressStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to aggregatedListAddresses. */
    public PagedCallSettings.Builder<
            AggregatedListAddressesHttpRequest,
            AddressAggregatedList,
            AggregatedListAddressesPagedResponse>
        aggregatedListAddressesSettings() {
      return getStubSettingsBuilder().aggregatedListAddressesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAddress. */
    public UnaryCallSettings.Builder<DeleteAddressHttpRequest, Operation> deleteAddressSettings() {
      return getStubSettingsBuilder().deleteAddressSettings();
    }

    /** Returns the builder for the settings used for calls to getAddress. */
    public UnaryCallSettings.Builder<GetAddressHttpRequest, Address> getAddressSettings() {
      return getStubSettingsBuilder().getAddressSettings();
    }

    /** Returns the builder for the settings used for calls to insertAddress. */
    public UnaryCallSettings.Builder<InsertAddressHttpRequest, Operation> insertAddressSettings() {
      return getStubSettingsBuilder().insertAddressSettings();
    }

    /** Returns the builder for the settings used for calls to listAddresses. */
    public PagedCallSettings.Builder<
            ListAddressesHttpRequest, AddressList, ListAddressesPagedResponse>
        listAddressesSettings() {
      return getStubSettingsBuilder().listAddressesSettings();
    }

    @Override
    public AddressSettings build() throws IOException {
      return new AddressSettings(this);
    }
  }
}
