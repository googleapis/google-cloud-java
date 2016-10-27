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

import com.google.cloud.RetryParams;
import com.google.cloud.translate.TranslateOptions;

/**
 * Utility to create a remote translate configuration for testing. Translate options can be obtained
 * via the {@link #getOptions()} ()} method. Returned options have custom
 * {@link TranslateOptions#getRetryParams()}: {@link RetryParams#getRetryMaxAttempts()} is
 * {@code 10}, {@link RetryParams#getRetryMinAttempts()} is {@code 6},
 * {@link RetryParams#getMaxRetryDelayMillis()} is {@code 30000},
 * {@link RetryParams#getTotalRetryPeriodMillis()} is {@code 120000} and
 * {@link RetryParams#getInitialRetryDelayMillis()} is {@code 250}.
 * {@link TranslateOptions#getConnectTimeout()} and {@link TranslateOptions#getReadTimeout()} are
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
  @Deprecated
  public TranslateOptions options() {
    return getOptions();
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
    TranslateOptions translateOptions = TranslateOptions.newBuilder()
        .setApiKey(apiKey)
        .setRetryParams(retryParams())
        .setConnectTimeout(60000)
        .setReadTimeout(60000)
        .build();
    return new RemoteTranslateHelper(translateOptions);
  }

  /**
   * Creates a {@code RemoteStorageHelper} object.
   */
  public static RemoteTranslateHelper create() {
    TranslateOptions translateOption = TranslateOptions.newBuilder()
        .setRetryParams(retryParams())
        .setConnectTimeout(60000)
        .setReadTimeout(60000)
        .build();
    return new RemoteTranslateHelper(translateOption);
  }

  private static RetryParams retryParams() {
    return RetryParams.newBuilder()
        .setRetryMaxAttempts(10)
        .setRetryMinAttempts(6)
        .setMaxRetryDelayMillis(30000)
        .setTotalRetryPeriodMillis(120000)
        .setInitialRetryDelayMillis(250)
        .build();
  }
}
