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

import static com.google.cloud.compute.v1.LicenseClient.ListLicensesPagedResponse;

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
import com.google.cloud.compute.v1.stub.LicenseStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link LicenseClient}.
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
 * example, to set the total timeout of deleteLicense to 30 seconds:
 *
 * <pre>
 * <code>
 * LicenseSettings.Builder licenseSettingsBuilder =
 *     LicenseSettings.newBuilder();
 * licenseSettingsBuilder.deleteLicenseSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * LicenseSettings licenseSettings = licenseSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class LicenseSettings extends ClientSettings<LicenseSettings> {
  /** Returns the object with the settings used for calls to deleteLicense. */
  public UnaryCallSettings<DeleteLicenseHttpRequest, Operation> deleteLicenseSettings() {
    return ((LicenseStubSettings) getStubSettings()).deleteLicenseSettings();
  }

  /** Returns the object with the settings used for calls to getLicense. */
  public UnaryCallSettings<GetLicenseHttpRequest, License> getLicenseSettings() {
    return ((LicenseStubSettings) getStubSettings()).getLicenseSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicyLicense. */
  public UnaryCallSettings<GetIamPolicyLicenseHttpRequest, Policy> getIamPolicyLicenseSettings() {
    return ((LicenseStubSettings) getStubSettings()).getIamPolicyLicenseSettings();
  }

  /** Returns the object with the settings used for calls to insertLicense. */
  public UnaryCallSettings<InsertLicenseHttpRequest, Operation> insertLicenseSettings() {
    return ((LicenseStubSettings) getStubSettings()).insertLicenseSettings();
  }

  /** Returns the object with the settings used for calls to listLicenses. */
  public PagedCallSettings<ListLicensesHttpRequest, LicensesListResponse, ListLicensesPagedResponse>
      listLicensesSettings() {
    return ((LicenseStubSettings) getStubSettings()).listLicensesSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicyLicense. */
  public UnaryCallSettings<SetIamPolicyLicenseHttpRequest, Policy> setIamPolicyLicenseSettings() {
    return ((LicenseStubSettings) getStubSettings()).setIamPolicyLicenseSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissionsLicense. */
  public UnaryCallSettings<TestIamPermissionsLicenseHttpRequest, TestPermissionsResponse>
      testIamPermissionsLicenseSettings() {
    return ((LicenseStubSettings) getStubSettings()).testIamPermissionsLicenseSettings();
  }

  public static final LicenseSettings create(LicenseStubSettings stub) throws IOException {
    return new LicenseSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LicenseStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LicenseStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return LicenseStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LicenseStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LicenseStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LicenseStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LicenseStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LicenseStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected LicenseSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LicenseSettings. */
  public static class Builder extends ClientSettings.Builder<LicenseSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(LicenseStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(LicenseStubSettings.newBuilder());
    }

    protected Builder(LicenseSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LicenseStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public LicenseStubSettings.Builder getStubSettingsBuilder() {
      return ((LicenseStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteLicense. */
    public UnaryCallSettings.Builder<DeleteLicenseHttpRequest, Operation> deleteLicenseSettings() {
      return getStubSettingsBuilder().deleteLicenseSettings();
    }

    /** Returns the builder for the settings used for calls to getLicense. */
    public UnaryCallSettings.Builder<GetLicenseHttpRequest, License> getLicenseSettings() {
      return getStubSettingsBuilder().getLicenseSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicyLicense. */
    public UnaryCallSettings.Builder<GetIamPolicyLicenseHttpRequest, Policy>
        getIamPolicyLicenseSettings() {
      return getStubSettingsBuilder().getIamPolicyLicenseSettings();
    }

    /** Returns the builder for the settings used for calls to insertLicense. */
    public UnaryCallSettings.Builder<InsertLicenseHttpRequest, Operation> insertLicenseSettings() {
      return getStubSettingsBuilder().insertLicenseSettings();
    }

    /** Returns the builder for the settings used for calls to listLicenses. */
    public PagedCallSettings.Builder<
            ListLicensesHttpRequest, LicensesListResponse, ListLicensesPagedResponse>
        listLicensesSettings() {
      return getStubSettingsBuilder().listLicensesSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicyLicense. */
    public UnaryCallSettings.Builder<SetIamPolicyLicenseHttpRequest, Policy>
        setIamPolicyLicenseSettings() {
      return getStubSettingsBuilder().setIamPolicyLicenseSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsLicense. */
    public UnaryCallSettings.Builder<TestIamPermissionsLicenseHttpRequest, TestPermissionsResponse>
        testIamPermissionsLicenseSettings() {
      return getStubSettingsBuilder().testIamPermissionsLicenseSettings();
    }

    @Override
    public LicenseSettings build() throws IOException {
      return new LicenseSettings(this);
    }
  }
}
