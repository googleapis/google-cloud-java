/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.compute.v1.ReservationClient.AggregatedListReservationsPagedResponse;
import static com.google.cloud.compute.v1.ReservationClient.ListReservationsPagedResponse;

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
import com.google.cloud.compute.v1.stub.ReservationStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ReservationClient}.
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
 * example, to set the total timeout of deleteReservation to 30 seconds:
 *
 * <pre>
 * <code>
 * ReservationSettings.Builder reservationSettingsBuilder =
 *     ReservationSettings.newBuilder();
 * reservationSettingsBuilder.deleteReservationSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ReservationSettings reservationSettings = reservationSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ReservationSettings extends ClientSettings<ReservationSettings> {
  /** Returns the object with the settings used for calls to aggregatedListReservations. */
  public PagedCallSettings<
          AggregatedListReservationsHttpRequest,
          ReservationAggregatedList,
          AggregatedListReservationsPagedResponse>
      aggregatedListReservationsSettings() {
    return ((ReservationStubSettings) getStubSettings()).aggregatedListReservationsSettings();
  }

  /** Returns the object with the settings used for calls to deleteReservation. */
  public UnaryCallSettings<DeleteReservationHttpRequest, Operation> deleteReservationSettings() {
    return ((ReservationStubSettings) getStubSettings()).deleteReservationSettings();
  }

  /** Returns the object with the settings used for calls to getReservation. */
  public UnaryCallSettings<GetReservationHttpRequest, Reservation> getReservationSettings() {
    return ((ReservationStubSettings) getStubSettings()).getReservationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicyReservation. */
  public UnaryCallSettings<GetIamPolicyReservationHttpRequest, Policy>
      getIamPolicyReservationSettings() {
    return ((ReservationStubSettings) getStubSettings()).getIamPolicyReservationSettings();
  }

  /** Returns the object with the settings used for calls to insertReservation. */
  public UnaryCallSettings<InsertReservationHttpRequest, Operation> insertReservationSettings() {
    return ((ReservationStubSettings) getStubSettings()).insertReservationSettings();
  }

  /** Returns the object with the settings used for calls to listReservations. */
  public PagedCallSettings<
          ListReservationsHttpRequest, ReservationList, ListReservationsPagedResponse>
      listReservationsSettings() {
    return ((ReservationStubSettings) getStubSettings()).listReservationsSettings();
  }

  /** Returns the object with the settings used for calls to resizeReservation. */
  public UnaryCallSettings<ResizeReservationHttpRequest, Operation> resizeReservationSettings() {
    return ((ReservationStubSettings) getStubSettings()).resizeReservationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicyReservation. */
  public UnaryCallSettings<SetIamPolicyReservationHttpRequest, Policy>
      setIamPolicyReservationSettings() {
    return ((ReservationStubSettings) getStubSettings()).setIamPolicyReservationSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissionsReservation. */
  public UnaryCallSettings<TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
      testIamPermissionsReservationSettings() {
    return ((ReservationStubSettings) getStubSettings()).testIamPermissionsReservationSettings();
  }

  public static final ReservationSettings create(ReservationStubSettings stub) throws IOException {
    return new ReservationSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ReservationStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ReservationStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return ReservationStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ReservationStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ReservationStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ReservationStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ReservationStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ReservationStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ReservationSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ReservationSettings. */
  public static class Builder extends ClientSettings.Builder<ReservationSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(ReservationStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(ReservationStubSettings.newBuilder());
    }

    protected Builder(ReservationSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ReservationStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public ReservationStubSettings.Builder getStubSettingsBuilder() {
      return ((ReservationStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListReservations. */
    public PagedCallSettings.Builder<
            AggregatedListReservationsHttpRequest,
            ReservationAggregatedList,
            AggregatedListReservationsPagedResponse>
        aggregatedListReservationsSettings() {
      return getStubSettingsBuilder().aggregatedListReservationsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReservation. */
    public UnaryCallSettings.Builder<DeleteReservationHttpRequest, Operation>
        deleteReservationSettings() {
      return getStubSettingsBuilder().deleteReservationSettings();
    }

    /** Returns the builder for the settings used for calls to getReservation. */
    public UnaryCallSettings.Builder<GetReservationHttpRequest, Reservation>
        getReservationSettings() {
      return getStubSettingsBuilder().getReservationSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicyReservation. */
    public UnaryCallSettings.Builder<GetIamPolicyReservationHttpRequest, Policy>
        getIamPolicyReservationSettings() {
      return getStubSettingsBuilder().getIamPolicyReservationSettings();
    }

    /** Returns the builder for the settings used for calls to insertReservation. */
    public UnaryCallSettings.Builder<InsertReservationHttpRequest, Operation>
        insertReservationSettings() {
      return getStubSettingsBuilder().insertReservationSettings();
    }

    /** Returns the builder for the settings used for calls to listReservations. */
    public PagedCallSettings.Builder<
            ListReservationsHttpRequest, ReservationList, ListReservationsPagedResponse>
        listReservationsSettings() {
      return getStubSettingsBuilder().listReservationsSettings();
    }

    /** Returns the builder for the settings used for calls to resizeReservation. */
    public UnaryCallSettings.Builder<ResizeReservationHttpRequest, Operation>
        resizeReservationSettings() {
      return getStubSettingsBuilder().resizeReservationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicyReservation. */
    public UnaryCallSettings.Builder<SetIamPolicyReservationHttpRequest, Policy>
        setIamPolicyReservationSettings() {
      return getStubSettingsBuilder().setIamPolicyReservationSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsReservation. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
        testIamPermissionsReservationSettings() {
      return getStubSettingsBuilder().testIamPermissionsReservationSettings();
    }

    @Override
    public ReservationSettings build() throws IOException {
      return new ReservationSettings(this);
    }
  }
}
