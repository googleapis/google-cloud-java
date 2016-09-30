/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.trace.spi.v1;

import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.PageStreamingCallSettings;
import com.google.api.gax.grpc.PageStreamingDescriptor;
import com.google.api.gax.grpc.ServiceApiSettings;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.TraceServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TraceServiceApi}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 * <li>The default service address (cloudtrace.googleapis.com) and default port (443)
 * are used.
 * <li>Credentials are acquired automatically through Application Default Credentials.
 * <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders.
 * When build() is called, the tree of builders is called to create the complete settings
 * object. For example, to set the total timeout of patchTraces to 30 seconds:
 *
 * <pre>
 * <code>
 * TraceServiceSettings.Builder traceServiceSettingsBuilder =
 *     TraceServiceSettings.defaultBuilder();
 * traceServiceSettingsBuilder.patchTracesSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * TraceServiceSettings traceServiceSettings = traceServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class TraceServiceSettings extends ServiceApiSettings {
  /**
   * The default address of the service.
   */
  private static final String DEFAULT_SERVICE_ADDRESS = "cloudtrace.googleapis.com";

  /**
   * The default port of the service.
   */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/trace.append")
          .add("https://www.googleapis.com/auth/trace.readonly")
          .build();

  /**
   * The default connection settings of the service.
   */
  public static final ConnectionSettings DEFAULT_CONNECTION_SETTINGS =
      ConnectionSettings.newBuilder()
          .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
          .setPort(DEFAULT_SERVICE_PORT)
          .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
          .build();

  private final SimpleCallSettings<PatchTracesRequest, Empty> patchTracesSettings;
  private final SimpleCallSettings<GetTraceRequest, Trace> getTraceSettings;
  private final PageStreamingCallSettings<ListTracesRequest, ListTracesResponse, Trace>
      listTracesSettings;

  /**
   * Returns the object with the settings used for calls to patchTraces.
   */
  public SimpleCallSettings<PatchTracesRequest, Empty> patchTracesSettings() {
    return patchTracesSettings;
  }

  /**
   * Returns the object with the settings used for calls to getTrace.
   */
  public SimpleCallSettings<GetTraceRequest, Trace> getTraceSettings() {
    return getTraceSettings;
  }

  /**
   * Returns the object with the settings used for calls to listTraces.
   */
  public PageStreamingCallSettings<ListTracesRequest, ListTracesResponse, Trace>
      listTracesSettings() {
    return listTracesSettings;
  }

  /**
   * Returns the default service address.
   */
  public static String getDefaultServiceAddress() {
    return DEFAULT_SERVICE_ADDRESS;
  }

  /**
   * Returns the default service port.
   */
  public static int getDefaultServicePort() {
    return DEFAULT_SERVICE_PORT;
  }

  /**
   * Returns the default service scopes.
   */
  public static ImmutableList<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /**
   * Returns a builder for this class with recommended defaults.
   */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /**
   * Returns a new builder for this class.
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Returns a builder containing all the values of this settings class.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private TraceServiceSettings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getChannelProvider(),
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getGeneratorName(),
        settingsBuilder.getGeneratorVersion(),
        settingsBuilder.getClientLibName(),
        settingsBuilder.getClientLibVersion());

    patchTracesSettings = settingsBuilder.patchTracesSettings().build();
    getTraceSettings = settingsBuilder.getTraceSettings().build();
    listTracesSettings = settingsBuilder.listTracesSettings().build();
  }

  private static final PageStreamingDescriptor<ListTracesRequest, ListTracesResponse, Trace>
      LIST_TRACES_PAGE_STR_DESC =
          new PageStreamingDescriptor<ListTracesRequest, ListTracesResponse, Trace>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListTracesRequest injectToken(ListTracesRequest payload, Object token) {
              return ListTracesRequest.newBuilder(payload).setPageToken((String) token).build();
            }

            @Override
            public ListTracesRequest injectPageSize(ListTracesRequest payload, int pageSize) {
              throw new UnsupportedOperationException(
                  "page size is not supported by this API method");
            }

            @Override
            public Integer extractPageSize(ListTracesRequest payload) {
              throw new UnsupportedOperationException(
                  "page size is not supported by this API method");
            }

            @Override
            public Object extractNextToken(ListTracesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Trace> extractResources(ListTracesResponse payload) {
              return payload.getTracesList();
            }
          };

  /**
   * Builder for TraceServiceSettings.
   */
  public static class Builder extends ServiceApiSettings.Builder {
    private final ImmutableList<ApiCallSettings.Builder> methodSettingsBuilders;

    private final SimpleCallSettings.Builder<PatchTracesRequest, Empty> patchTracesSettings;
    private final SimpleCallSettings.Builder<GetTraceRequest, Trace> getTraceSettings;
    private final PageStreamingCallSettings.Builder<ListTracesRequest, ListTracesResponse, Trace>
        listTracesSettings;

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", Sets.immutableEnumSet(Lists.<Status.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings.Builder> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings.Builder> definitions = ImmutableMap.builder();
      RetrySettings.Builder settingsBuilder = null;
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.2)
              .setMaxRetryDelay(Duration.millis(1000L))
              .setInitialRpcTimeout(Duration.millis(20000L))
              .setRpcTimeoutMultiplier(1.5)
              .setMaxRpcTimeout(Duration.millis(30000L))
              .setTotalTimeout(Duration.millis(45000L));
      definitions.put("default", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(DEFAULT_CONNECTION_SETTINGS);

      patchTracesSettings = SimpleCallSettings.newBuilder(TraceServiceGrpc.METHOD_PATCH_TRACES);

      getTraceSettings = SimpleCallSettings.newBuilder(TraceServiceGrpc.METHOD_GET_TRACE);

      listTracesSettings =
          PageStreamingCallSettings.newBuilder(
              TraceServiceGrpc.METHOD_LIST_TRACES, LIST_TRACES_PAGE_STR_DESC);

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              patchTracesSettings, getTraceSettings, listTracesSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .patchTracesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getTraceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTracesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(TraceServiceSettings settings) {
      super(settings);

      patchTracesSettings = settings.patchTracesSettings.toBuilder();
      getTraceSettings = settings.getTraceSettings.toBuilder();
      listTracesSettings = settings.listTracesSettings.toBuilder();

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              patchTracesSettings, getTraceSettings, listTracesSettings);
    }

    @Override
    protected ConnectionSettings getDefaultConnectionSettings() {
      return DEFAULT_CONNECTION_SETTINGS;
    }

    @Override
    public Builder provideExecutorWith(ScheduledExecutorService executor, boolean shouldAutoClose) {
      super.provideExecutorWith(executor, shouldAutoClose);
      return this;
    }

    @Override
    public Builder provideChannelWith(ManagedChannel channel, boolean shouldAutoClose) {
      super.provideChannelWith(channel, shouldAutoClose);
      return this;
    }

    @Override
    public Builder provideChannelWith(ConnectionSettings settings) {
      super.provideChannelWith(settings);
      return this;
    }

    @Override
    public Builder provideChannelWith(Credentials credentials) {
      super.provideChannelWith(credentials);
      return this;
    }

    @Override
    public Builder provideChannelWith(List<String> scopes) {
      super.provideChannelWith(scopes);
      return this;
    }

    @Override
    public Builder setGeneratorHeader(String name, String version) {
      super.setGeneratorHeader(name, version);
      return this;
    }

    @Override
    public Builder setClientLibHeader(String name, String version) {
      super.setClientLibHeader(name, version);
      return this;
    }

    /**
     * Applies the given settings to all of the API methods in this service. Only
     * values that are non-null will be applied, so this method is not capable
     * of un-setting any values.
     */
    public Builder applyToAllApiMethods(ApiCallSettings.Builder apiCallSettings) throws Exception {
      super.applyToAllApiMethods(methodSettingsBuilders, apiCallSettings);
      return this;
    }

    /**
     * Returns the builder for the settings used for calls to patchTraces.
     */
    public SimpleCallSettings.Builder<PatchTracesRequest, Empty> patchTracesSettings() {
      return patchTracesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getTrace.
     */
    public SimpleCallSettings.Builder<GetTraceRequest, Trace> getTraceSettings() {
      return getTraceSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listTraces.
     */
    public PageStreamingCallSettings.Builder<ListTracesRequest, ListTracesResponse, Trace>
        listTracesSettings() {
      return listTracesSettings;
    }

    @Override
    public TraceServiceSettings build() throws IOException {
      return new TraceServiceSettings(this);
    }
  }
}
