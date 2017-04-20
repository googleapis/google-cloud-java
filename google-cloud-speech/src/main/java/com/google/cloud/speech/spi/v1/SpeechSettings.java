/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.speech.spi.v1;

import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ClientSettings;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.OperationCallSettings;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.api.gax.grpc.StreamingCallSettings;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.cloud.speech.v1.LongRunningRecognizeRequest;
import com.google.cloud.speech.v1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1.RecognizeRequest;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1.StreamingRecognizeResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.longrunning.Operation;
import com.google.protobuf.ExperimentalApi;
import io.grpc.Status;
import java.io.IOException;
import javax.annotation.Generated;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SpeechClient}.
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of recognize to 30 seconds:
 *
 * <pre>
 * <code>
 * SpeechSettings.Builder speechSettingsBuilder =
 *     SpeechSettings.defaultBuilder();
 * speechSettingsBuilder.recognizeSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * SpeechSettings speechSettings = speechSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@ExperimentalApi
public class SpeechSettings extends ClientSettings {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/com/google/cloud/speech/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private static final io.grpc.MethodDescriptor<RecognizeRequest, RecognizeResponse>
      METHOD_RECOGNIZE =
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.cloud.speech.v1.Speech/Recognize",
              io.grpc.protobuf.ProtoUtils.marshaller(RecognizeRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(RecognizeResponse.getDefaultInstance()));
  private static final io.grpc.MethodDescriptor<LongRunningRecognizeRequest, Operation>
      METHOD_LONG_RUNNING_RECOGNIZE =
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.cloud.speech.v1.Speech/LongRunningRecognize",
              io.grpc.protobuf.ProtoUtils.marshaller(
                  LongRunningRecognizeRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Operation.getDefaultInstance()));
  private static final io.grpc.MethodDescriptor<
          StreamingRecognizeRequest, StreamingRecognizeResponse>
      METHOD_STREAMING_RECOGNIZE =
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
              "google.cloud.speech.v1.Speech/StreamingRecognize",
              io.grpc.protobuf.ProtoUtils.marshaller(
                  StreamingRecognizeRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(
                  StreamingRecognizeResponse.getDefaultInstance()));

  private final SimpleCallSettings<RecognizeRequest, RecognizeResponse> recognizeSettings;
  private final OperationCallSettings<LongRunningRecognizeRequest, LongRunningRecognizeResponse>
      longRunningRecognizeSettings;
  private final StreamingCallSettings<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeSettings;

  /** Returns the object with the settings used for calls to recognize. */
  public SimpleCallSettings<RecognizeRequest, RecognizeResponse> recognizeSettings() {
    return recognizeSettings;
  }

  /** Returns the object with the settings used for calls to longRunningRecognize. */
  public OperationCallSettings<LongRunningRecognizeRequest, LongRunningRecognizeResponse>
      longRunningRecognizeSettings() {
    return longRunningRecognizeSettings;
  }

  /** Returns the object with the settings used for calls to streamingRecognize. */
  public StreamingCallSettings<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeSettings() {
    return streamingRecognizeSettings;
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "speech.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static ImmutableList<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingChannelProvider.Builder defaultChannelProviderBuilder() {
    return InstantiatingChannelProvider.newBuilder()
        .setEndpoint(getDefaultEndpoint())
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion())
        .setCredentialsProvider(defaultCredentialsProviderBuilder().build());
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion =
          PropertiesProvider.loadProperty(SpeechSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
  }

  /** Returns a builder for this class with recommended defaults. */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private SpeechSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder.getExecutorProvider(), settingsBuilder.getChannelProvider());

    recognizeSettings = settingsBuilder.recognizeSettings().build();
    longRunningRecognizeSettings = settingsBuilder.longRunningRecognizeSettings().build();
    streamingRecognizeSettings = settingsBuilder.streamingRecognizeSettings().build();
  }

  /** Builder for SpeechSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder> unaryMethodSettingsBuilders;

    private final SimpleCallSettings.Builder<RecognizeRequest, RecognizeResponse> recognizeSettings;
    private final OperationCallSettings.Builder<
            LongRunningRecognizeRequest, LongRunningRecognizeResponse>
        longRunningRecognizeSettings;
    private final StreamingCallSettings.Builder<
            StreamingRecognizeRequest, StreamingRecognizeResponse>
        streamingRecognizeSettings;

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put(
          "non_idempotent",
          Sets.immutableEnumSet(Lists.<Status.Code>newArrayList(Status.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings.Builder> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings.Builder> definitions = ImmutableMap.builder();
      RetrySettings.Builder settingsBuilder = null;
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.millis(60000L))
              .setInitialRpcTimeout(Duration.millis(190000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.millis(190000L))
              .setTotalTimeout(Duration.millis(600000L));
      definitions.put("default", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(defaultChannelProviderBuilder().build());

      recognizeSettings = SimpleCallSettings.newBuilder(METHOD_RECOGNIZE);

      longRunningRecognizeSettings =
          OperationCallSettings.newBuilder(
              METHOD_LONG_RUNNING_RECOGNIZE, LongRunningRecognizeResponse.class);
      longRunningRecognizeSettings.setPollingInterval(Duration.millis(20000));

      streamingRecognizeSettings = StreamingCallSettings.newBuilder(METHOD_STREAMING_RECOGNIZE);

      unaryMethodSettingsBuilders = ImmutableList.<UnaryCallSettings.Builder>of(recognizeSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .recognizeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));
      builder
          .longRunningRecognizeSettings()
          .getInitialCallSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(SpeechSettings settings) {
      super(settings);

      recognizeSettings = settings.recognizeSettings.toBuilder();
      longRunningRecognizeSettings = settings.longRunningRecognizeSettings.toBuilder();
      streamingRecognizeSettings = settings.streamingRecognizeSettings.toBuilder();

      unaryMethodSettingsBuilders = ImmutableList.<UnaryCallSettings.Builder>of(recognizeSettings);
    }

    @Override
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setChannelProvider(ChannelProvider channelProvider) {
      super.setChannelProvider(channelProvider);
      return this;
    }

    /**
     * Applies the given settings to all of the unary API methods in this service. Only values that
     * are non-null will be applied, so this method is not capable of un-setting any values.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(UnaryCallSettings.Builder unaryCallSettings)
        throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, unaryCallSettings);
      return this;
    }

    /** Returns the builder for the settings used for calls to recognize. */
    public SimpleCallSettings.Builder<RecognizeRequest, RecognizeResponse> recognizeSettings() {
      return recognizeSettings;
    }

    /** Returns the builder for the settings used for calls to longRunningRecognize. */
    public OperationCallSettings.Builder<LongRunningRecognizeRequest, LongRunningRecognizeResponse>
        longRunningRecognizeSettings() {
      return longRunningRecognizeSettings;
    }

    /** Returns the builder for the settings used for calls to streamingRecognize. */
    public StreamingCallSettings.Builder<StreamingRecognizeRequest, StreamingRecognizeResponse>
        streamingRecognizeSettings() {
      return streamingRecognizeSettings;
    }

    @Override
    public SpeechSettings build() throws IOException {
      return new SpeechSettings(this);
    }
  }
}
