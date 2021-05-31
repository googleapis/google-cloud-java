/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.grpc.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ErrorsTest {

  @Test
  public void testRetryableInternalForRstErrors() {
    assertTrue(
        Errors.isRetryableInternalStatus(
            Status.INTERNAL.withDescription(
                "HTTP/2 error code: INTERNAL_ERROR\nReceived Rst stream")));
    assertTrue(
        Errors.isRetryableInternalStatus(
            Status.INTERNAL.withDescription(
                "RST_STREAM closed stream. HTTP/2 error code: INTERNAL_ERROR")));
  }

  @Test
  public void testNonRetryableInternalError() {
    assertFalse(Errors.isRetryableInternalStatus(Status.INTERNAL));
    assertFalse(Errors.isRetryableInternalStatus(Status.INTERNAL.withDescription("Server error.")));
  }

  @Test
  public void testNonRetryableOtherError() {
    assertFalse(
        Errors.isRetryableInternalStatus(
            Status.DATA_LOSS.withDescription(
                "RST_STREAM closed stream. HTTP/2 error code: INTERNAL_ERROR")));
  }
}
