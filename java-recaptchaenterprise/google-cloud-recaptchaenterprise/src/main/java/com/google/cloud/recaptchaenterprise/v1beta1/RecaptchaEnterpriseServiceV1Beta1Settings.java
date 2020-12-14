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

package com.google.cloud.recaptchaenterprise.v1beta1;

import static com.google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1Client.ListKeysPagedResponse;

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
import com.google.cloud.recaptchaenterprise.v1beta1.stub.RecaptchaEnterpriseServiceV1Beta1StubSettings;
import com.google.protobuf.Empty;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1beta1.Assessment;
import com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1beta1.GetKeyRequest;
import com.google.recaptchaenterprise.v1beta1.Key;
import com.google.recaptchaenterprise.v1beta1.ListKeysRequest;
import com.google.recaptchaenterprise.v1beta1.ListKeysResponse;
import com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RecaptchaEnterpriseServiceV1Beta1Client}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (recaptchaenterprise.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createAssessment to 30 seconds:
 *
 * <pre>{@code
 * RecaptchaEnterpriseServiceV1Beta1Settings.Builder
 *     recaptchaEnterpriseServiceV1Beta1SettingsBuilder =
 *         RecaptchaEnterpriseServiceV1Beta1Settings.newBuilder();
 * recaptchaEnterpriseServiceV1Beta1SettingsBuilder
 *     .createAssessmentSettings()
 *     .setRetrySettings(
 *         recaptchaEnterpriseServiceV1Beta1SettingsBuilder
 *             .createAssessmentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RecaptchaEnterpriseServiceV1Beta1Settings recaptchaEnterpriseServiceV1Beta1Settings =
 *     recaptchaEnterpriseServiceV1Beta1SettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RecaptchaEnterpriseServiceV1Beta1Settings
    extends ClientSettings<RecaptchaEnterpriseServiceV1Beta1Settings> {

  /** Returns the object with the settings used for calls to createAssessment. */
  public UnaryCallSettings<CreateAssessmentRequest, Assessment> createAssessmentSettings() {
    return ((RecaptchaEnterpriseServiceV1Beta1StubSettings) getStubSettings())
        .createAssessmentSettings();
  }

  /** Returns the object with the settings used for calls to annotateAssessment. */
  public UnaryCallSettings<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentSettings() {
    return ((RecaptchaEnterpriseServiceV1Beta1StubSettings) getStubSettings())
        .annotateAssessmentSettings();
  }

  /** Returns the object with the settings used for calls to createKey. */
  public UnaryCallSettings<CreateKeyRequest, Key> createKeySettings() {
    return ((RecaptchaEnterpriseServiceV1Beta1StubSettings) getStubSettings()).createKeySettings();
  }

  /** Returns the object with the settings used for calls to listKeys. */
  public PagedCallSettings<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
      listKeysSettings() {
    return ((RecaptchaEnterpriseServiceV1Beta1StubSettings) getStubSettings()).listKeysSettings();
  }

  /** Returns the object with the settings used for calls to getKey. */
  public UnaryCallSettings<GetKeyRequest, Key> getKeySettings() {
    return ((RecaptchaEnterpriseServiceV1Beta1StubSettings) getStubSettings()).getKeySettings();
  }

  /** Returns the object with the settings used for calls to updateKey. */
  public UnaryCallSettings<UpdateKeyRequest, Key> updateKeySettings() {
    return ((RecaptchaEnterpriseServiceV1Beta1StubSettings) getStubSettings()).updateKeySettings();
  }

  /** Returns the object with the settings used for calls to deleteKey. */
  public UnaryCallSettings<DeleteKeyRequest, Empty> deleteKeySettings() {
    return ((RecaptchaEnterpriseServiceV1Beta1StubSettings) getStubSettings()).deleteKeySettings();
  }

  public static final RecaptchaEnterpriseServiceV1Beta1Settings create(
      RecaptchaEnterpriseServiceV1Beta1StubSettings stub) throws IOException {
    return new RecaptchaEnterpriseServiceV1Beta1Settings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RecaptchaEnterpriseServiceV1Beta1StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RecaptchaEnterpriseServiceV1Beta1StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RecaptchaEnterpriseServiceV1Beta1StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RecaptchaEnterpriseServiceV1Beta1StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return RecaptchaEnterpriseServiceV1Beta1StubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RecaptchaEnterpriseServiceV1Beta1StubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RecaptchaEnterpriseServiceV1Beta1StubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RecaptchaEnterpriseServiceV1Beta1Settings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RecaptchaEnterpriseServiceV1Beta1Settings. */
  public static class Builder
      extends ClientSettings.Builder<RecaptchaEnterpriseServiceV1Beta1Settings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RecaptchaEnterpriseServiceV1Beta1StubSettings.newBuilder(clientContext));
    }

    protected Builder(RecaptchaEnterpriseServiceV1Beta1Settings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RecaptchaEnterpriseServiceV1Beta1StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RecaptchaEnterpriseServiceV1Beta1StubSettings.newBuilder());
    }

    public RecaptchaEnterpriseServiceV1Beta1StubSettings.Builder getStubSettingsBuilder() {
      return ((RecaptchaEnterpriseServiceV1Beta1StubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to createAssessment. */
    public UnaryCallSettings.Builder<CreateAssessmentRequest, Assessment>
        createAssessmentSettings() {
      return getStubSettingsBuilder().createAssessmentSettings();
    }

    /** Returns the builder for the settings used for calls to annotateAssessment. */
    public UnaryCallSettings.Builder<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
        annotateAssessmentSettings() {
      return getStubSettingsBuilder().annotateAssessmentSettings();
    }

    /** Returns the builder for the settings used for calls to createKey. */
    public UnaryCallSettings.Builder<CreateKeyRequest, Key> createKeySettings() {
      return getStubSettingsBuilder().createKeySettings();
    }

    /** Returns the builder for the settings used for calls to listKeys. */
    public PagedCallSettings.Builder<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
        listKeysSettings() {
      return getStubSettingsBuilder().listKeysSettings();
    }

    /** Returns the builder for the settings used for calls to getKey. */
    public UnaryCallSettings.Builder<GetKeyRequest, Key> getKeySettings() {
      return getStubSettingsBuilder().getKeySettings();
    }

    /** Returns the builder for the settings used for calls to updateKey. */
    public UnaryCallSettings.Builder<UpdateKeyRequest, Key> updateKeySettings() {
      return getStubSettingsBuilder().updateKeySettings();
    }

    /** Returns the builder for the settings used for calls to deleteKey. */
    public UnaryCallSettings.Builder<DeleteKeyRequest, Empty> deleteKeySettings() {
      return getStubSettingsBuilder().deleteKeySettings();
    }

    @Override
    public RecaptchaEnterpriseServiceV1Beta1Settings build() throws IOException {
      return new RecaptchaEnterpriseServiceV1Beta1Settings(this);
    }
  }
}
