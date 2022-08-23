/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1beta1;

import static com.google.cloud.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1Client.ListScanConfigsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.devtools.containeranalysis.v1beta1.stub.ContainerAnalysisV1Beta1StubSettings;
import com.google.containeranalysis.v1beta1.GetScanConfigRequest;
import com.google.containeranalysis.v1beta1.ListScanConfigsRequest;
import com.google.containeranalysis.v1beta1.ListScanConfigsResponse;
import com.google.containeranalysis.v1beta1.ScanConfig;
import com.google.containeranalysis.v1beta1.UpdateScanConfigRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ContainerAnalysisV1Beta1Client}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (containeranalysis.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of setIamPolicy to 30 seconds:
 *
 * <pre>
 * <code>
 * ContainerAnalysisV1Beta1Settings.Builder containerAnalysisV1Beta1SettingsBuilder =
 *     ContainerAnalysisV1Beta1Settings.newBuilder();
 * containerAnalysisV1Beta1SettingsBuilder
 *     .setIamPolicySettings()
 *     .setRetrySettings(
 *         containerAnalysisV1Beta1SettingsBuilder.setIamPolicySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ContainerAnalysisV1Beta1Settings containerAnalysisV1Beta1Settings = containerAnalysisV1Beta1SettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ContainerAnalysisV1Beta1Settings
    extends ClientSettings<ContainerAnalysisV1Beta1Settings> {
  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ContainerAnalysisV1Beta1StubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ContainerAnalysisV1Beta1StubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ContainerAnalysisV1Beta1StubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to getScanConfig. */
  public UnaryCallSettings<GetScanConfigRequest, ScanConfig> getScanConfigSettings() {
    return ((ContainerAnalysisV1Beta1StubSettings) getStubSettings()).getScanConfigSettings();
  }

  /** Returns the object with the settings used for calls to listScanConfigs. */
  public PagedCallSettings<
          ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
      listScanConfigsSettings() {
    return ((ContainerAnalysisV1Beta1StubSettings) getStubSettings()).listScanConfigsSettings();
  }

  /** Returns the object with the settings used for calls to updateScanConfig. */
  public UnaryCallSettings<UpdateScanConfigRequest, ScanConfig> updateScanConfigSettings() {
    return ((ContainerAnalysisV1Beta1StubSettings) getStubSettings()).updateScanConfigSettings();
  }

  public static final ContainerAnalysisV1Beta1Settings create(
      ContainerAnalysisV1Beta1StubSettings stub) throws IOException {
    return new ContainerAnalysisV1Beta1Settings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ContainerAnalysisV1Beta1StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ContainerAnalysisV1Beta1StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ContainerAnalysisV1Beta1StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ContainerAnalysisV1Beta1StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ContainerAnalysisV1Beta1StubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ContainerAnalysisV1Beta1StubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ContainerAnalysisV1Beta1StubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ContainerAnalysisV1Beta1Settings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ContainerAnalysisV1Beta1Settings. */
  public static class Builder
      extends ClientSettings.Builder<ContainerAnalysisV1Beta1Settings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(ContainerAnalysisV1Beta1StubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(ContainerAnalysisV1Beta1StubSettings.newBuilder());
    }

    protected Builder(ContainerAnalysisV1Beta1Settings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ContainerAnalysisV1Beta1StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public ContainerAnalysisV1Beta1StubSettings.Builder getStubSettingsBuilder() {
      return ((ContainerAnalysisV1Beta1StubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to getScanConfig. */
    public UnaryCallSettings.Builder<GetScanConfigRequest, ScanConfig> getScanConfigSettings() {
      return getStubSettingsBuilder().getScanConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listScanConfigs. */
    public PagedCallSettings.Builder<
            ListScanConfigsRequest, ListScanConfigsResponse, ListScanConfigsPagedResponse>
        listScanConfigsSettings() {
      return getStubSettingsBuilder().listScanConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to updateScanConfig. */
    public UnaryCallSettings.Builder<UpdateScanConfigRequest, ScanConfig>
        updateScanConfigSettings() {
      return getStubSettingsBuilder().updateScanConfigSettings();
    }

    @Override
    public ContainerAnalysisV1Beta1Settings build() throws IOException {
      return new ContainerAnalysisV1Beta1Settings(this);
    }
  }
}
