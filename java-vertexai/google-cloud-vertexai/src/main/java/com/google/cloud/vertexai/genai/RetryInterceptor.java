/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.vertexai.genai;

import com.google.common.collect.ImmutableList;
import com.google.genai.types.HttpRetryOptions;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/** Retry interceptor for the API requests. */
class RetryInterceptor implements Interceptor {

  // Default retry options.
  private static final int RETRY_MAX_ATTEMPTS = 5;
  private static final double RETRY_INITIAL_DELAY = 1.0; // in seconds
  private static final double RETRY_MAX_DELAY = 60.0; // in seconds
  private static final double RETRY_EXP_BASE = 2.0;
  private static final double RETRY_JITTER = 1.0;
  private static final ImmutableList<Integer> RETRY_HTTP_STATUS_CODES =
      ImmutableList.of(
          408, // Request timeout.
          429, // Too many requests.
          500, // Internal server error.
          502, // Bad gateway.
          503, // Service unavailable.
          504 // Gateway timeout
          );

  private final HttpRetryOptions retryOptions;
  private final Random random;

  /** Creates an interceptor with a retry strategy. */
  RetryInterceptor(HttpRetryOptions retryOptions) {
    this(retryOptions, new Random());
  }

  /** Constructor for testing. Allows injecting a mock Random. */
  RetryInterceptor(HttpRetryOptions retryOptions, Random random) {
    this.retryOptions = retryOptions;
    this.random = random;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();

    // Check if the request has a *per-request* retry options object attached as a tag.
    HttpRetryOptions perRequestOptions = request.tag(HttpRetryOptions.class);

    // Use per-request options if present, otherwise fall back to client-default options.
    HttpRetryOptions options = (perRequestOptions != null) ? perRequestOptions : this.retryOptions;

    if (options == null) {
      return chain.proceed(request);
    }

    Response response = null;
    int maxAttempts = options.attempts().orElse(RETRY_MAX_ATTEMPTS);
    maxAttempts = Math.max(maxAttempts, 1);
    List<Integer> httpStatusCodes = options.httpStatusCodes().orElse(RETRY_HTTP_STATUS_CODES);

    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
      try {
        response = chain.proceed(request);
        // If the response is successful or the response code is not in the retry list, exist the
        // attempt loop.
        if (response.isSuccessful() || !httpStatusCodes.contains(response.code())) {
          break;
        } else if (attempt < maxAttempts) {
          // Close the unsuccessful response so that the connection can be reused for the next
          // attempt.
          response.close();
        }
      } catch (IOException e) {
        if (attempt == maxAttempts) {
          throw e;
        }
      }

      try {
        // Blocking sleep before retrying.
        Thread.sleep(calculateDelay(options, attempt));
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new IOException("Retry was interrupted.", e);
      }
    }
    return response;
  }

  /** Calculates the delay (in milliseconds) using exponential backoff with jitter. */
  long calculateDelay(HttpRetryOptions options, int attempt) {
    double initialDelay = options.initialDelay().orElse(RETRY_INITIAL_DELAY);
    double maxDelay = options.maxDelay().orElse(RETRY_MAX_DELAY);
    double expBase = options.expBase().orElse(RETRY_EXP_BASE);
    double jitter = options.jitter().orElse(RETRY_JITTER);

    double factor =
        Math.pow(expBase, attempt - 1) * (1.0 + jitter * (random.nextDouble() * 2.0 - 1.0));

    double delay = Math.min(maxDelay, initialDelay * factor);

    return (long) (delay * 1000); // Convert to milliseconds.
  }

  /** Returns the client-level retry options. */
  HttpRetryOptions retryOptions() {
    return retryOptions;
  }
}
