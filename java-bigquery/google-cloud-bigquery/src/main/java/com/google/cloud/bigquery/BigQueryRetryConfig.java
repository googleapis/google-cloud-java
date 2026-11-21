/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;

/**
 * Configures additional error-message and regular-expression retry rules for query job status
 * polling (see {@link Job#waitFor(BigQueryRetryConfig, com.google.cloud.RetryOption...)} and {@link
 * BigQuery.JobOption#bigQueryRetryConfig(BigQueryRetryConfig)}).
 *
 * <p>BigQuery surfaces several transient errors (such as rate-limit failures) with non-5xx HTTP
 * status codes (such as 403 or 400) or inside job error payloads that are not retried automatically
 * by default HTTP status retries (see {@link BigQueryException#isRetryable()} and <a
 * href="https://docs.cloud.google.com/bigquery/docs/errors">BigQuery API HTTP status and error
 * codes</a>). This class lets callers opt into retrying query job status checks when an error
 * message matches configured substrings or patterns, such as the constants in {@link
 * BigQueryErrorMessages}.
 *
 * <p>Rules match case-insensitively against the exception or response error message text rather
 * than structured {@link BigQueryError#getReason()} codes directly. This configuration applies to
 * query job status checks and is not used for non-query jobs.
 *
 * @see BigQueryErrorMessages
 * @see <a href="https://docs.cloud.google.com/bigquery/docs/errors">BigQuery API HTTP status and
 *     error codes</a>
 */
public class BigQueryRetryConfig {
  private final ImmutableSet<String> retriableErrorMessages;
  private final ImmutableSet<String> retriableRegExes;

  private BigQueryRetryConfig(Builder builder) {
    retriableErrorMessages = builder.retriableErrorMessages.build();
    retriableRegExes = builder.retriableRegExes.build();
  }

  /** Returns the configured error message substrings that trigger a retry. */
  public ImmutableSet<String> getRetriableErrorMessages() {
    return retriableErrorMessages;
  }

  /** Returns the configured full-string regular expression patterns that trigger a retry. */
  public ImmutableSet<String> getRetriableRegExes() {
    return retriableRegExes;
  }

  // BigQueryRetryConfig builder
  public static class Builder {
    private final ImmutableSet.Builder<String> retriableErrorMessages = ImmutableSet.builder();
    private final ImmutableSet.Builder<String> retriableRegExes = ImmutableSet.builder();

    private Builder() {}

    /**
     * Adds error message substrings to retry on using a case-insensitive substring match against
     * the exception or response error message text.
     */
    public final Builder retryOnMessage(String... errorMessages) {
      for (String errorMessage : errorMessages) {
        retriableErrorMessages.add(checkNotNull(errorMessage));
      }
      return this;
    }

    /**
     * Adds regular expression patterns to retry on. Matching is case-insensitive and requires a
     * full-string match via {@link java.util.regex.Pattern#matches(String, CharSequence)}, so
     * patterns must match the entire error message rather than only a substring (for example,
     * {@code ".*rate limit.*"} rather than {@code "rate limit"}).
     */
    public final Builder retryOnRegEx(String... regExPatterns) {
      for (String regExPattern : regExPatterns) {
        retriableRegExes.add(checkNotNull(regExPattern));
      }
      return this;
    }

    public BigQueryRetryConfig build() {
      return new BigQueryRetryConfig(this);
    }
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
