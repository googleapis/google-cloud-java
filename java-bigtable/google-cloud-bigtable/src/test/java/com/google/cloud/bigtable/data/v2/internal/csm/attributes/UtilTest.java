/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.csm.attributes;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.bigtable.v2.PeerInfo.TransportType;
import io.grpc.Status;
import io.opencensus.tags.TagValue;
import org.junit.jupiter.api.Test;

class UtilTest {
  @Test
  void ensureAllTransportTypeHaveExpectedPrefix() {
    for (TransportType type : TransportType.values()) {
      assertWithMessage("%s should have a mapping", type)
          .that(Util.transportTypeToStringWithoutFallback(type))
          .isNotNull();
    }
  }

  @Test
  public void testOk() {
    TagValue tagValue =
        TagValue.create(
            com.google.cloud.bigtable.data.v2.internal.csm.attributes.Util.extractStatus(null)
                .name());
    assertThat(tagValue.asString()).isEqualTo("OK");
  }

  @Test
  public void testError() {
    DeadlineExceededException error =
        new DeadlineExceededException(
            "Deadline exceeded", null, GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED), true);
    TagValue tagValue = TagValue.create(Util.extractStatus(error).name());
    assertThat(tagValue.asString()).isEqualTo("DEADLINE_EXCEEDED");
  }
}
