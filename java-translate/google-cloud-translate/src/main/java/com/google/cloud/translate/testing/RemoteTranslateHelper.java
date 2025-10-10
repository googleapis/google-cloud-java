/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.translate.testing;

import com.google.api.core.ObsoleteApi;
import com.google.api.gax.retrying.RetrySettings;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.translate.TranslateOptions;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.threeten.bp.Duration;

/**
 * Utility to create a remote translate configuration for testing. Translate options can be obtained
 * via the {@link #getOptions()} ()} method. Returned options have custom {@link
 * TranslateOptions#getRetrySettings()}: {@link RetrySettings#getMaxAttempts()} is {@code 10},
 * {@link RetrySettings#getMaxRetryDelay()} is {@code 30000}, {@link
 * RetrySettings#getTotalTimeout()} is {@code 120000} and {@link
 * RetrySettings#getInitialRetryDelay()} is {@code 250}. {@link
 * HttpTransportOptions#getConnectTimeout()} and {@link HttpTransportOptions#getReadTimeout()} are
 * both both set to {@code 60000}.
 */
public class RemoteTranslateHelper {
  private static final Logger logger = Logger.getLogger(RemoteTranslateHelper.class.getName());

  private final TranslateOptions options;

  private RemoteTranslateHelper(TranslateOptions options) {
    this.options = options;
  }

  /** Returns a {@link TranslateOptions} object to be used for testing. */
  public TranslateOptions getOptions() {
    return options;
  }

  /**
   * This method is obsolete because of a potential security risk. Use the {@link #create(String,
   * GoogleCredentials)} method instead.
   *
   * <p>If you know that you will be loading credential configurations of a specific type, it is
   * recommended to use a credential-type-specific `fromStream()` method. This will ensure that an
   * unexpected credential type with potential for malicious intent is not loaded unintentionally.
   * You might still have to do validation for certain credential types. Please follow the
   * recommendation for that method.
   *
   * <p>If you are loading your credential configuration from an untrusted source and have not
   * mitigated the risks (e.g. by validating the configuration yourself), make these changes as soon
   * as possible to prevent security risks to your environment.
   *
   * <p>Regardless of the method used, it is always your responsibility to validate configurations
   * received from external sources.
   *
   * <p>See the {@link <a
   * href="https://cloud.google.com/docs/authentication/external/externally-sourced-credentials">documentation</a>}
   * for more details.
   *
   * <p>Creates a {@code RemoteTranslateHelper} object for the given project id and JSON key input
   * stream.
   *
   * @param projectId id of the project to be used for running the tests
   * @param keyStream input stream for a JSON key
   * @return A {@code RemoteTranslateHelper} object for the provided options
   * @throws com.google.cloud.translate.testing.RemoteTranslateHelper.TranslateHelperException if
   *     {@code keyStream} is not a valid JSON key stream
   */
  @ObsoleteApi(
      "This method is obsolete because of a potential security risk. Use the create() variant with"
          + " Credential parameter instead")
  public static RemoteTranslateHelper create(String projectId, InputStream keyStream)
      throws TranslateHelperException {
    try {
      return create(projectId, GoogleCredentials.fromStream(keyStream));
    } catch (IOException ex) {
      if (logger.isLoggable(Level.WARNING)) {
        logger.log(Level.WARNING, ex.getMessage());
      }
      throw TranslateHelperException.translate(ex);
    }
  }

  /**
   * Creates a {@code RemoteTranslateHelper} object for the given project id and JSON key input
   * stream.
   *
   * @param projectId id of the project to be used for running the tests
   * @param credentials GoogleCredential to set to TranslateOptions
   * @return A {@code RemoteTranslateHelper} object for the provided options
   */
  public static RemoteTranslateHelper create(String projectId, GoogleCredentials credentials) {
    HttpTransportOptions transportOptions = TranslateOptions.getDefaultHttpTransportOptions();
    transportOptions =
        transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000).build();
    TranslateOptions translateOptions =
        TranslateOptions.newBuilder()
            .setCredentials(credentials)
            .setProjectId(projectId)
            .setRetrySettings(retryParams())
            .setTransportOptions(transportOptions)
            .build();
    return new RemoteTranslateHelper(translateOptions);
  }

  /**
   * Creates a {@code RemoteTranslateHelper} object for the given API key.
   *
   * @param apiKey API key used to issue requests to Google Translation.
   */
  @Deprecated
  public static RemoteTranslateHelper create(String apiKey) {
    HttpTransportOptions transportOptions = TranslateOptions.getDefaultHttpTransportOptions();
    transportOptions =
        transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000).build();
    TranslateOptions translateOptions =
        TranslateOptions.newBuilder()
            .setApiKey(apiKey)
            .setRetrySettings(retryParams())
            .setTransportOptions(transportOptions)
            .build();
    return new RemoteTranslateHelper(translateOptions);
  }

  /**
   * Creates a {@code RemoteTranslateHelper} object using default project id and authentication
   * credentials.
   */
  public static RemoteTranslateHelper create() {
    HttpTransportOptions transportOptions = TranslateOptions.getDefaultHttpTransportOptions();
    transportOptions =
        transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000).build();
    TranslateOptions translateOption =
        TranslateOptions.newBuilder()
            .setRetrySettings(retryParams())
            .setTransportOptions(transportOptions)
            .build();
    return new RemoteTranslateHelper(translateOption);
  }

  private static RetrySettings retryParams() {
    return RetrySettings.newBuilder()
        .setMaxAttempts(10)
        .setMaxRetryDelay(Duration.ofMillis(30000L))
        .setTotalTimeout(Duration.ofMillis(120000L))
        .setInitialRetryDelay(Duration.ofMillis(250L))
        .setRetryDelayMultiplier(1.0)
        .setInitialRpcTimeout(Duration.ofMillis(120000L))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeout(Duration.ofMillis(120000L))
        .build();
  }

  public static class TranslateHelperException extends RuntimeException {

    private static final long serialVersionUID = -1356870058436149798L;

    public TranslateHelperException(String message) {
      super(message);
    }

    public TranslateHelperException(String message, Throwable cause) {
      super(message, cause);
    }

    public static TranslateHelperException translate(Exception ex) {
      return new TranslateHelperException(ex.getMessage(), ex);
    }
  }
}
