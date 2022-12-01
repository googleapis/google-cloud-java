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

package com.google.cloud.speech.v1p1beta1;

import static com.google.cloud.speech.v1p1beta1.AdaptationClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v1p1beta1.AdaptationClient.ListPhraseSetPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.speech.v1p1beta1.stub.AdaptationStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AdaptationClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (speech.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createPhraseSet to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdaptationSettings.Builder adaptationSettingsBuilder = AdaptationSettings.newBuilder();
 * adaptationSettingsBuilder
 *     .createPhraseSetSettings()
 *     .setRetrySettings(
 *         adaptationSettingsBuilder.createPhraseSetSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AdaptationSettings adaptationSettings = adaptationSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AdaptationSettings extends ClientSettings<AdaptationSettings> {

  /** Returns the object with the settings used for calls to createPhraseSet. */
  public UnaryCallSettings<CreatePhraseSetRequest, PhraseSet> createPhraseSetSettings() {
    return ((AdaptationStubSettings) getStubSettings()).createPhraseSetSettings();
  }

  /** Returns the object with the settings used for calls to getPhraseSet. */
  public UnaryCallSettings<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings() {
    return ((AdaptationStubSettings) getStubSettings()).getPhraseSetSettings();
  }

  /** Returns the object with the settings used for calls to listPhraseSet. */
  public PagedCallSettings<ListPhraseSetRequest, ListPhraseSetResponse, ListPhraseSetPagedResponse>
      listPhraseSetSettings() {
    return ((AdaptationStubSettings) getStubSettings()).listPhraseSetSettings();
  }

  /** Returns the object with the settings used for calls to updatePhraseSet. */
  public UnaryCallSettings<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetSettings() {
    return ((AdaptationStubSettings) getStubSettings()).updatePhraseSetSettings();
  }

  /** Returns the object with the settings used for calls to deletePhraseSet. */
  public UnaryCallSettings<DeletePhraseSetRequest, Empty> deletePhraseSetSettings() {
    return ((AdaptationStubSettings) getStubSettings()).deletePhraseSetSettings();
  }

  /** Returns the object with the settings used for calls to createCustomClass. */
  public UnaryCallSettings<CreateCustomClassRequest, CustomClass> createCustomClassSettings() {
    return ((AdaptationStubSettings) getStubSettings()).createCustomClassSettings();
  }

  /** Returns the object with the settings used for calls to getCustomClass. */
  public UnaryCallSettings<GetCustomClassRequest, CustomClass> getCustomClassSettings() {
    return ((AdaptationStubSettings) getStubSettings()).getCustomClassSettings();
  }

  /** Returns the object with the settings used for calls to listCustomClasses. */
  public PagedCallSettings<
          ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
      listCustomClassesSettings() {
    return ((AdaptationStubSettings) getStubSettings()).listCustomClassesSettings();
  }

  /** Returns the object with the settings used for calls to updateCustomClass. */
  public UnaryCallSettings<UpdateCustomClassRequest, CustomClass> updateCustomClassSettings() {
    return ((AdaptationStubSettings) getStubSettings()).updateCustomClassSettings();
  }

  /** Returns the object with the settings used for calls to deleteCustomClass. */
  public UnaryCallSettings<DeleteCustomClassRequest, Empty> deleteCustomClassSettings() {
    return ((AdaptationStubSettings) getStubSettings()).deleteCustomClassSettings();
  }

  public static final AdaptationSettings create(AdaptationStubSettings stub) throws IOException {
    return new AdaptationSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AdaptationStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AdaptationStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AdaptationStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AdaptationStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AdaptationStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AdaptationStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AdaptationStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AdaptationStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AdaptationSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AdaptationSettings. */
  public static class Builder extends ClientSettings.Builder<AdaptationSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AdaptationStubSettings.newBuilder(clientContext));
    }

    protected Builder(AdaptationSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AdaptationStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AdaptationStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AdaptationStubSettings.newHttpJsonBuilder());
    }

    public AdaptationStubSettings.Builder getStubSettingsBuilder() {
      return ((AdaptationStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createPhraseSet. */
    public UnaryCallSettings.Builder<CreatePhraseSetRequest, PhraseSet> createPhraseSetSettings() {
      return getStubSettingsBuilder().createPhraseSetSettings();
    }

    /** Returns the builder for the settings used for calls to getPhraseSet. */
    public UnaryCallSettings.Builder<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings() {
      return getStubSettingsBuilder().getPhraseSetSettings();
    }

    /** Returns the builder for the settings used for calls to listPhraseSet. */
    public PagedCallSettings.Builder<
            ListPhraseSetRequest, ListPhraseSetResponse, ListPhraseSetPagedResponse>
        listPhraseSetSettings() {
      return getStubSettingsBuilder().listPhraseSetSettings();
    }

    /** Returns the builder for the settings used for calls to updatePhraseSet. */
    public UnaryCallSettings.Builder<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetSettings() {
      return getStubSettingsBuilder().updatePhraseSetSettings();
    }

    /** Returns the builder for the settings used for calls to deletePhraseSet. */
    public UnaryCallSettings.Builder<DeletePhraseSetRequest, Empty> deletePhraseSetSettings() {
      return getStubSettingsBuilder().deletePhraseSetSettings();
    }

    /** Returns the builder for the settings used for calls to createCustomClass. */
    public UnaryCallSettings.Builder<CreateCustomClassRequest, CustomClass>
        createCustomClassSettings() {
      return getStubSettingsBuilder().createCustomClassSettings();
    }

    /** Returns the builder for the settings used for calls to getCustomClass. */
    public UnaryCallSettings.Builder<GetCustomClassRequest, CustomClass> getCustomClassSettings() {
      return getStubSettingsBuilder().getCustomClassSettings();
    }

    /** Returns the builder for the settings used for calls to listCustomClasses. */
    public PagedCallSettings.Builder<
            ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
        listCustomClassesSettings() {
      return getStubSettingsBuilder().listCustomClassesSettings();
    }

    /** Returns the builder for the settings used for calls to updateCustomClass. */
    public UnaryCallSettings.Builder<UpdateCustomClassRequest, CustomClass>
        updateCustomClassSettings() {
      return getStubSettingsBuilder().updateCustomClassSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCustomClass. */
    public UnaryCallSettings.Builder<DeleteCustomClassRequest, Empty> deleteCustomClassSettings() {
      return getStubSettingsBuilder().deleteCustomClassSettings();
    }

    @Override
    public AdaptationSettings build() throws IOException {
      return new AdaptationSettings(this);
    }
  }
}
