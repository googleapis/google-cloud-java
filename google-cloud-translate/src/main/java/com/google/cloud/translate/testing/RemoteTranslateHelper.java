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
 * via the {@link #getOptions()} method. Returned options have custom
 * {@link TranslateOptions#retryParams()}: {@link RetryParams#retryMaxAttempts()} is {@code 10},
 * {@link RetryParams#retryMinAttempts()} is {@code 6}, {@link RetryParams#maxRetryDelayMillis()}
 * is {@code 30000}, {@link RetryParams#totalRetryPeriodMillis()} is {@code 120000} and
 * {@link RetryParams#initialRetryDelayMillis()} is {@code 250}.
 * {@link TranslateOptions#connectTimeout()} and {@link TranslateOptions#readTimeout()} are both set
 * to {@code 60000}.
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
    TranslateOptions translateOptions = TranslateOptions.builder()
        .apiKey(apiKey)
        .retryParams(retryParams())
        .connectTimeout(60000)
        .readTimeout(60000)
        .build();
    return new RemoteTranslateHelper(translateOptions);
  }

  /**
   * Creates a {@code RemoteStorageHelper} object.
   */
  public static RemoteTranslateHelper create() {
    TranslateOptions translateOption = TranslateOptions.builder()
        .retryParams(retryParams())
        .connectTimeout(60000)
        .readTimeout(60000)
        .build();
    return new RemoteTranslateHelper(translateOption);
  }

  private static RetryParams retryParams() {
    return RetryParams.builder()
        .retryMaxAttempts(10)
        .retryMinAttempts(6)
        .maxRetryDelayMillis(30000)
        .totalRetryPeriodMillis(120000)
        .initialRetryDelayMillis(250)
        .build();
  }
}
