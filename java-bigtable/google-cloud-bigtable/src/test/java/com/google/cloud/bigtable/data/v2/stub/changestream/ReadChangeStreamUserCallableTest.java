/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.changestream;

import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecord;
import com.google.cloud.bigtable.data.v2.models.ReadChangeStreamQuery;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.common.truth.Truth;
import java.time.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadChangeStreamUserCallableTest {
  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create("fake-project", "fake-instance", "fake-profile");

  @Test
  public void testRequestIsConverted() {
    ServerStreamingStashCallable<ReadChangeStreamRequest, ChangeStreamRecord> innerCallable =
        new ServerStreamingStashCallable<>();
    ReadChangeStreamUserCallable<ChangeStreamRecord> callable =
        new ReadChangeStreamUserCallable<>(innerCallable, REQUEST_CONTEXT);
    ReadChangeStreamQuery query =
        ReadChangeStreamQuery.create("fake-table")
            .streamPartition("begin", "end")
            .startTime(1000L)
            .endTime(2000L)
            .heartbeatDuration(Duration.ofSeconds(1));
    callable.call(query);
    Truth.assertThat(innerCallable.getActualRequest()).isEqualTo(query.toProto(REQUEST_CONTEXT));
  }
}
