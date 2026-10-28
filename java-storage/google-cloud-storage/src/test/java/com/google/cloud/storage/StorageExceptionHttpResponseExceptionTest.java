/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.cloud.BaseServiceException;
import java.io.IOException;
import java.io.UncheckedIOException;
import org.junit.Test;

public final class StorageExceptionHttpResponseExceptionTest {

  private static final int[] RETRYABLE_CODES = {408, 429, 500, 502, 503, 504};
  private static final int[] NON_RETRYABLE_CODES = {400, 401, 403, 404, 409, 412};

  @Test
  public void coalesce_http503_preservesStatusMessageAndCause() throws Exception {
    String body = "<Error><Code>ServiceUnavailable</Code></Error>";
    HttpResponseException hre =
        new HttpResponseException.Builder(503, "Service Unavailable", new HttpHeaders())
            .setContent(body)
            // a manually constructed Builder does not compute a message, set one mirroring what
            // HttpResponseException.Builder(HttpResponse) produces: status line + body
            .setMessage("503 Service Unavailable\n" + body)
            .build();

    BaseServiceException actual = StorageException.coalesce(hre);

    assertAll(
        () -> assertThat(actual).isInstanceOf(StorageException.class),
        () -> assertThat(actual.getCode()).isEqualTo(503),
        () -> assertThat(actual.getReason()).isNull(),
        () -> assertThat(actual.isRetryable()).isTrue(),
        () -> assertThat(actual.getCause()).isSameInstanceAs(hre),
        () -> assertThat(actual.getMessage()).isEqualTo(hre.getMessage()),
        () -> assertThat(actual.getMessage()).contains("ServiceUnavailable"));
  }

  @Test
  public void coalesce_retryableStatusCodes() throws Exception {
    for (int code : RETRYABLE_CODES) {
      BaseServiceException actual = StorageException.coalesce(hre(code));
      assertAll(
          () -> assertThat(actual.getCode()).isEqualTo(code),
          () -> assertThat(actual.isRetryable()).isTrue());
    }
  }

  @Test
  public void coalesce_nonRetryableStatusCodes() throws Exception {
    for (int code : NON_RETRYABLE_CODES) {
      BaseServiceException actual = StorageException.coalesce(hre(code));
      assertAll(
          () -> assertThat(actual.getCode()).isEqualTo(code),
          () -> assertThat(actual.isRetryable()).isFalse());
    }
  }

  @Test
  public void coalesce_unwrapsHttpResponseExceptionCause() throws Exception {
    HttpResponseException hre = hre(503);
    BaseServiceException actual = StorageException.coalesce(new UncheckedIOException(hre));

    assertAll(
        () -> assertThat(actual.getCode()).isEqualTo(503),
        () -> assertThat(actual.isRetryable()).isTrue(),
        () -> assertThat(actual.getCause()).isSameInstanceAs(hre));
  }

  @Test
  public void coalesce_plainIOException_stillUnknownCode() throws Exception {
    IOException ioe = new IOException("boom");
    BaseServiceException actual = StorageException.coalesce(ioe);

    assertAll(
        () -> assertThat(actual.getCode()).isEqualTo(BaseServiceException.UNKNOWN_CODE),
        () -> assertThat(actual.getCause()).isSameInstanceAs(ioe));
  }

  @Test
  public void coalesce_existingStorageException_identity() {
    StorageException se = new StorageException(503, "unavailable");
    assertThat(StorageException.coalesce(se)).isSameInstanceAs(se);
  }

  private static HttpResponseException hre(int code) {
    return new HttpResponseException.Builder(code, "status " + code, new HttpHeaders()).build();
  }
}
