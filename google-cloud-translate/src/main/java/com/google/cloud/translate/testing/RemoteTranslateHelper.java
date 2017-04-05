/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import com.google.cloud.HttpTransportOptions;
import com.google.api.gax.core.RetrySettings;
import com.google.cloud.translate.TranslateOptions;
import org.joda.time.Duration;

/**
 * Utility to create a remote translate configuration for testing. Translate options can be obtained
 * via the {@link #getOptions()} ()} method. Returned options have custom
 * {@link TranslateOptions#getRetrySettings()}: {@link RetrySettings#getMaxAttempts()} is
 * {@code 10},
 * {@link RetrySettings#getMaxRetryDelay()} is {@code 30000},
 * {@link RetrySettings#getTotalTimeout()} is {@code 120000} and
 * {@link RetrySettings#getInitialRetryDelay()} is {@code 250}.
 * {@link HttpTransportOptions#getConnectTimeout()} and
 * {@link HttpTransportOptions#getReadTimeout()} are both
 * both set to {@code 60000}.
 */
public class RemoteTranslateHelper {

  private final TranslateOptions options;

  private RemoteTranslateHelper(TranslateOptions options) {
    this.options = options;
  }


  /**
   * Returns a {@link TranslateOptions} object to be used for testing.
   */
  public TranslateOptions getOptions() {
    return options;
  }

  /**
   * Creates a {@code RemoteTranslateHelper} object for the given API key.
   *
   * @param apiKey API key used to issue requests to Google Translate.
   */
  public static RemoteTranslateHelper create(String apiKey) {
    HttpTransportOptions transportOptions = TranslateOptions.getDefaultHttpTransportOptions();
    transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000)
        .build();
    TranslateOptions translateOptions = TranslateOptions.newBuilder()
        .setApiKey(apiKey)
        .setRetrySettings(retryParams())
        .setTransportOptions(transportOptions)
        .build();
    return new RemoteTranslateHelper(translateOptions);
  }

  /**
   * Creates a {@code RemoteStorageHelper} object.
   */
  public static RemoteTranslateHelper create() {
    HttpTransportOptions transportOptions = TranslateOptions.getDefaultHttpTransportOptions();
    transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000)
        .build();
    TranslateOptions translateOption = TranslateOptions.newBuilder()
        .setRetrySettings(retryParams())
        .setTransportOptions(transportOptions)
        .build();
    return new RemoteTranslateHelper(translateOption);
  }

  private static RetrySettings retryParams() {
    return RetrySettings.newBuilder().setMaxAttempts(10)
        .setMaxRetryDelay(Duration.millis(30000L))
        .setTotalTimeout(Duration.millis(120000L))
        .setInitialRetryDelay(Duration.millis(250L))
        .setRetryDelayMultiplier(1.0)
        .setInitialRpcTimeout(Duration.millis(120000L))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeout(Duration.millis(120000L))
        .build();
  }
}
