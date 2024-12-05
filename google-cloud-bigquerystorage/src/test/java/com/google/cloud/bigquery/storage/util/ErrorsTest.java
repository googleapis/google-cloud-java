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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.Duration;
import com.google.protobuf.Parser;
import com.google.rpc.RetryInfo;
import io.grpc.Metadata;
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
    assertTrue(Errors.isRetryableInternalStatus(Status.INTERNAL.withDescription("Rst Stream")));
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

  @Test
  public void testIsRetryableStatus() {
    Errors.IsRetryableStatusResult result =
        Errors.isRetryableStatus(
            Status.INTERNAL.withDescription(
                "HTTP/2 error code: INTERNAL_ERROR\nReceived Rst stream"),
            null);
    assertTrue(result.isRetryable);
    assertNull(result.retryDelay);

    result =
        Errors.isRetryableStatus(
            Status.INTERNAL.withDescription(
                "RST_STREAM closed stream. HTTP/2 error code: INTERNAL_ERROR"),
            null);
    assertTrue(result.isRetryable);
    assertNull(result.retryDelay);

    Metadata metadata = new Metadata();
    metadata.put(
        Metadata.Key.of(
            "some-key-bin",
            new Metadata.BinaryMarshaller<Integer>() {
              @Override
              public byte[] toBytes(Integer value) {
                return new byte[] {};
              }

              @Override
              public Integer parseBytes(byte[] serialized) {
                return new Integer(1);
              }
            }),
        new Integer(2));
    result =
        Errors.isRetryableStatus(
            Status.RESOURCE_EXHAUSTED.withDescription("You have run out of X quota"), metadata);
    assertFalse(result.isRetryable);
    assertNull(result.retryDelay);

    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(Duration.newBuilder().setSeconds(123).setNanos(456).build())
            .build();

    metadata = new Metadata();
    metadata.put(
        Metadata.Key.of(
            "google.rpc.retryinfo-bin",
            new Metadata.BinaryMarshaller<RetryInfo>() {
              @Override
              public byte[] toBytes(RetryInfo value) {
                return value.toByteArray();
              }

              @Override
              public RetryInfo parseBytes(byte[] serialized) {
                try {
                  Parser<RetryInfo> parser = (RetryInfo.newBuilder().build()).getParserForType();
                  return parser.parseFrom(serialized);
                } catch (Exception e) {
                  return null;
                }
              }
            }),
        retryInfo);

    result =
        Errors.isRetryableStatus(
            Status.RESOURCE_EXHAUSTED.withDescription("Stop for a while"), metadata);
    assertTrue(result.isRetryable);
    assertEquals(result.retryDelay, java.time.Duration.ofSeconds(123, 456));
  }
}
