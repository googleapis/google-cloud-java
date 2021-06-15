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

package com.google.cloud.eventarc.v1;

import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.eventarc.v1.stub.EventarcStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EventarcClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (eventarc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getTrigger to 30 seconds:
 *
 * <pre>{@code
 * EventarcSettings.Builder eventarcSettingsBuilder = EventarcSettings.newBuilder();
 * eventarcSettingsBuilder
 *     .getTriggerSettings()
 *     .setRetrySettings(
 *         eventarcSettingsBuilder
 *             .getTriggerSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EventarcSettings eventarcSettings = eventarcSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EventarcSettings extends ClientSettings<EventarcSettings> {

  /** Returns the object with the settings used for calls to getTrigger. */
  public UnaryCallSettings<GetTriggerRequest, Trigger> getTriggerSettings() {
    return ((EventarcStubSettings) getStubSettings()).getTriggerSettings();
  }

  /** Returns the object with the settings used for calls to listTriggers. */
  public PagedCallSettings<ListTriggersRequest, ListTriggersResponse, ListTriggersPagedResponse>
      listTriggersSettings() {
    return ((EventarcStubSettings) getStubSettings()).listTriggersSettings();
  }

  /** Returns the object with the settings used for calls to createTrigger. */
  public UnaryCallSettings<CreateTriggerRequest, Operation> createTriggerSettings() {
    return ((EventarcStubSettings) getStubSettings()).createTriggerSettings();
  }

  /** Returns the object with the settings used for calls to createTrigger. */
  public OperationCallSettings<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).createTriggerOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTrigger. */
  public UnaryCallSettings<UpdateTriggerRequest, Operation> updateTriggerSettings() {
    return ((EventarcStubSettings) getStubSettings()).updateTriggerSettings();
  }

  /** Returns the object with the settings used for calls to updateTrigger. */
  public OperationCallSettings<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).updateTriggerOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTrigger. */
  public UnaryCallSettings<DeleteTriggerRequest, Operation> deleteTriggerSettings() {
    return ((EventarcStubSettings) getStubSettings()).deleteTriggerSettings();
  }

  /** Returns the object with the settings used for calls to deleteTrigger. */
  public OperationCallSettings<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationSettings() {
    return ((EventarcStubSettings) getStubSettings()).deleteTriggerOperationSettings();
  }

  public static final EventarcSettings create(EventarcStubSettings stub) throws IOException {
    return new EventarcSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EventarcStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EventarcStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EventarcStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EventarcStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EventarcStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EventarcStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EventarcStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected EventarcSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for EventarcSettings. */
  public static class Builder extends ClientSettings.Builder<EventarcSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(EventarcStubSettings.newBuilder(clientContext));
    }

    protected Builder(EventarcSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EventarcStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(EventarcStubSettings.newBuilder());
    }

    public EventarcStubSettings.Builder getStubSettingsBuilder() {
      return ((EventarcStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getTrigger. */
    public UnaryCallSettings.Builder<GetTriggerRequest, Trigger> getTriggerSettings() {
      return getStubSettingsBuilder().getTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to listTriggers. */
    public PagedCallSettings.Builder<
            ListTriggersRequest, ListTriggersResponse, ListTriggersPagedResponse>
        listTriggersSettings() {
      return getStubSettingsBuilder().listTriggersSettings();
    }

    /** Returns the builder for the settings used for calls to createTrigger. */
    public UnaryCallSettings.Builder<CreateTriggerRequest, Operation> createTriggerSettings() {
      return getStubSettingsBuilder().createTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to createTrigger. */
    public OperationCallSettings.Builder<CreateTriggerRequest, Trigger, OperationMetadata>
        createTriggerOperationSettings() {
      return getStubSettingsBuilder().createTriggerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTrigger. */
    public UnaryCallSettings.Builder<UpdateTriggerRequest, Operation> updateTriggerSettings() {
      return getStubSettingsBuilder().updateTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to updateTrigger. */
    public OperationCallSettings.Builder<UpdateTriggerRequest, Trigger, OperationMetadata>
        updateTriggerOperationSettings() {
      return getStubSettingsBuilder().updateTriggerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTrigger. */
    public UnaryCallSettings.Builder<DeleteTriggerRequest, Operation> deleteTriggerSettings() {
      return getStubSettingsBuilder().deleteTriggerSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTrigger. */
    public OperationCallSettings.Builder<DeleteTriggerRequest, Trigger, OperationMetadata>
        deleteTriggerOperationSettings() {
      return getStubSettingsBuilder().deleteTriggerOperationSettings();
    }

    @Override
    public EventarcSettings build() throws IOException {
      return new EventarcSettings(this);
    }
  }
}
