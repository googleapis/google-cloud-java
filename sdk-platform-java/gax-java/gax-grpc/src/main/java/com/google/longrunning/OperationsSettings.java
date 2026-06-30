/*
 * Copyright 2018 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.longrunning;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.longrunning.OperationsClient.ListOperationsPagedResponse;
import com.google.longrunning.stub.OperationsStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;

/** Settings class to configure an instance of {@link OperationsClient}. */
public class OperationsSettings extends ClientSettings<OperationsSettings> {
  /** Returns the object with the settings used for calls to getOperation. */
  public UnaryCallSettings<GetOperationRequest, Operation> getOperationSettings() {
    return ((OperationsStubSettings) getStubSettings()).getOperationSettings();
  }

  /** Returns the object with the settings used for calls to listOperations. */
  public PagedCallSettings<
          ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
      listOperationsSettings() {
    return ((OperationsStubSettings) getStubSettings()).listOperationsSettings();
  }

  /** Returns the object with the settings used for calls to cancelOperation. */
  public UnaryCallSettings<CancelOperationRequest, Empty> cancelOperationSettings() {
    return ((OperationsStubSettings) getStubSettings()).cancelOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteOperation. */
  public UnaryCallSettings<DeleteOperationRequest, Empty> deleteOperationSettings() {
    return ((OperationsStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to waitOperation. */
  public UnaryCallSettings<WaitOperationRequest, Operation> waitOperationSettings() {
    return ((OperationsStubSettings) getStubSettings()).waitOperationSettings();
  }

  public static final OperationsSettings create(OperationsStubSettings stub) throws IOException {
    return new OperationsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OperationsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OperationsStubSettings.defaultCredentialsProviderBuilder();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OperationsStubSettings.defaultApiClientHeaderProviderBuilder();
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
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected OperationsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OperationsSettings. */
  public static class Builder extends ClientSettings.Builder<OperationsSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(OperationsStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(OperationsStubSettings.newBuilder());
    }

    protected Builder(OperationsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OperationsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public OperationsStubSettings.Builder getStubSettingsBuilder() {
      return ((OperationsStubSettings.Builder) getStubSettings());
    }

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

    /** Returns the builder for the settings used for calls to getOperation. */
    public UnaryCallSettings.Builder<GetOperationRequest, Operation> getOperationSettings() {
      return getStubSettingsBuilder().getOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listOperations. */
    public PagedCallSettings.Builder<
            ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
        listOperationsSettings() {
      return getStubSettingsBuilder().listOperationsSettings();
    }

    /** Returns the builder for the settings used for calls to cancelOperation. */
    public UnaryCallSettings.Builder<CancelOperationRequest, Empty> cancelOperationSettings() {
      return getStubSettingsBuilder().cancelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOperation. */
    public UnaryCallSettings.Builder<DeleteOperationRequest, Empty> deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOperation. */
    public UnaryCallSettings.Builder<WaitOperationRequest, Operation> waitOperationSettings() {
      return getStubSettingsBuilder().waitOperationSettings();
    }

    @Override
    public OperationsSettings build() throws IOException {
      return new OperationsSettings(this);
    }
  }
}
