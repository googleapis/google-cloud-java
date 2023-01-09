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

package com.google.cloud.billing.budgets.v1;

import static com.google.cloud.billing.budgets.v1.BudgetServiceClient.ListBudgetsPagedResponse;

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
import com.google.cloud.billing.budgets.v1.stub.BudgetServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BudgetServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (billingbudgets.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createBudget to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BudgetServiceSettings.Builder budgetServiceSettingsBuilder = BudgetServiceSettings.newBuilder();
 * budgetServiceSettingsBuilder
 *     .createBudgetSettings()
 *     .setRetrySettings(
 *         budgetServiceSettingsBuilder
 *             .createBudgetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BudgetServiceSettings budgetServiceSettings = budgetServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BudgetServiceSettings extends ClientSettings<BudgetServiceSettings> {

  /** Returns the object with the settings used for calls to createBudget. */
  public UnaryCallSettings<CreateBudgetRequest, Budget> createBudgetSettings() {
    return ((BudgetServiceStubSettings) getStubSettings()).createBudgetSettings();
  }

  /** Returns the object with the settings used for calls to updateBudget. */
  public UnaryCallSettings<UpdateBudgetRequest, Budget> updateBudgetSettings() {
    return ((BudgetServiceStubSettings) getStubSettings()).updateBudgetSettings();
  }

  /** Returns the object with the settings used for calls to getBudget. */
  public UnaryCallSettings<GetBudgetRequest, Budget> getBudgetSettings() {
    return ((BudgetServiceStubSettings) getStubSettings()).getBudgetSettings();
  }

  /** Returns the object with the settings used for calls to listBudgets. */
  public PagedCallSettings<ListBudgetsRequest, ListBudgetsResponse, ListBudgetsPagedResponse>
      listBudgetsSettings() {
    return ((BudgetServiceStubSettings) getStubSettings()).listBudgetsSettings();
  }

  /** Returns the object with the settings used for calls to deleteBudget. */
  public UnaryCallSettings<DeleteBudgetRequest, Empty> deleteBudgetSettings() {
    return ((BudgetServiceStubSettings) getStubSettings()).deleteBudgetSettings();
  }

  public static final BudgetServiceSettings create(BudgetServiceStubSettings stub)
      throws IOException {
    return new BudgetServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BudgetServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BudgetServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BudgetServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BudgetServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BudgetServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BudgetServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BudgetServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BudgetServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BudgetServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BudgetServiceSettings. */
  public static class Builder extends ClientSettings.Builder<BudgetServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BudgetServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(BudgetServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BudgetServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BudgetServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(BudgetServiceStubSettings.newHttpJsonBuilder());
    }

    public BudgetServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((BudgetServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createBudget. */
    public UnaryCallSettings.Builder<CreateBudgetRequest, Budget> createBudgetSettings() {
      return getStubSettingsBuilder().createBudgetSettings();
    }

    /** Returns the builder for the settings used for calls to updateBudget. */
    public UnaryCallSettings.Builder<UpdateBudgetRequest, Budget> updateBudgetSettings() {
      return getStubSettingsBuilder().updateBudgetSettings();
    }

    /** Returns the builder for the settings used for calls to getBudget. */
    public UnaryCallSettings.Builder<GetBudgetRequest, Budget> getBudgetSettings() {
      return getStubSettingsBuilder().getBudgetSettings();
    }

    /** Returns the builder for the settings used for calls to listBudgets. */
    public PagedCallSettings.Builder<
            ListBudgetsRequest, ListBudgetsResponse, ListBudgetsPagedResponse>
        listBudgetsSettings() {
      return getStubSettingsBuilder().listBudgetsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBudget. */
    public UnaryCallSettings.Builder<DeleteBudgetRequest, Empty> deleteBudgetSettings() {
      return getStubSettingsBuilder().deleteBudgetSettings();
    }

    @Override
    public BudgetServiceSettings build() throws IOException {
      return new BudgetServiceSettings(this);
    }
  }
}
