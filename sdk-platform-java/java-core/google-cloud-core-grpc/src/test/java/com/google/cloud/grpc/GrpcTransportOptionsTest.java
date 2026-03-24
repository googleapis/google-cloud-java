/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.grpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.grpc.GrpcTransportOptions.DefaultExecutorFactory;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import java.util.concurrent.ScheduledExecutorService;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

class GrpcTransportOptionsTest {

  private static final ExecutorFactory MOCK_EXECUTOR_FACTORY =
      EasyMock.createMock(ExecutorFactory.class);
  private static final GrpcTransportOptions OPTIONS =
      GrpcTransportOptions.newBuilder().setExecutorFactory(MOCK_EXECUTOR_FACTORY).build();
  private static final GrpcTransportOptions DEFAULT_OPTIONS =
      GrpcTransportOptions.newBuilder().build();
  private static final GrpcTransportOptions OPTIONS_COPY = OPTIONS.toBuilder().build();

  @Test
  void testBuilder() {
    assertSame(MOCK_EXECUTOR_FACTORY, OPTIONS.getExecutorFactory());
    assertTrue(DEFAULT_OPTIONS.getExecutorFactory() instanceof DefaultExecutorFactory);
  }

  @Test
  void testBaseEquals() {
    assertEquals(OPTIONS, OPTIONS_COPY);
    assertNotEquals(DEFAULT_OPTIONS, OPTIONS);
    GrpcTransportOptions options =
        OPTIONS.toBuilder().setExecutorFactory(new DefaultExecutorFactory()).build();
    assertNotEquals(OPTIONS, options);
  }

  @Test
  void testBaseHashCode() {
    assertEquals(OPTIONS.hashCode(), OPTIONS_COPY.hashCode());
    assertNotEquals(DEFAULT_OPTIONS.hashCode(), OPTIONS.hashCode());
    GrpcTransportOptions options =
        OPTIONS.toBuilder().setExecutorFactory(new DefaultExecutorFactory()).build();
    assertNotEquals(OPTIONS.hashCode(), options.hashCode());
  }

  @Test
  void testDefaultExecutorFactory() {
    ExecutorFactory<ScheduledExecutorService> executorFactory = new DefaultExecutorFactory();
    ScheduledExecutorService executorService = executorFactory.get();
    assertSame(executorService, executorFactory.get());
  }
}
