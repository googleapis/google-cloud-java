/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.common.util.concurrent.Futures;
import io.grpc.Status;
import io.opencensus.tags.TagValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UtilTest {
  @Test
  public void testOk() {
    TagValue tagValue = TagValue.create(Util.extractStatus((Throwable) null));
    assertThat(tagValue.asString()).isEqualTo("OK");
  }

  @Test
  public void testOkFuture() {
    TagValue tagValue = Util.extractStatusFromFuture(Futures.immediateFuture(null));
    assertThat(tagValue.asString()).isEqualTo("OK");
  }

  @Test
  public void testError() {
    DeadlineExceededException error =
        new DeadlineExceededException(
            "Deadline exceeded", null, GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED), true);
    TagValue tagValue = TagValue.create(Util.extractStatus(error));
    assertThat(tagValue.asString()).isEqualTo("DEADLINE_EXCEEDED");
  }

  @Test
  public void testErrorFuture() {
    DeadlineExceededException error =
        new DeadlineExceededException(
            "Deadline exceeded", null, GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED), true);
    TagValue tagValue = Util.extractStatusFromFuture(Futures.immediateFailedFuture(error));
    assertThat(tagValue.asString()).isEqualTo("DEADLINE_EXCEEDED");
  }

  @Test
  public void testCancelledFuture() {
    TagValue tagValue = Util.extractStatusFromFuture(Futures.immediateCancelledFuture());
    assertThat(tagValue.asString()).isEqualTo("CANCELLED");
  }
}
