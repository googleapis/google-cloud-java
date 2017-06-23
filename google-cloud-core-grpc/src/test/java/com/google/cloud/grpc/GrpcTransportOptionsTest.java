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

package com.google.cloud.grpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.cloud.grpc.GrpcTransportOptions.DefaultExecutorFactory;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;
import org.easymock.EasyMock;
import org.junit.Test;

public class GrpcTransportOptionsTest {

  private static final ExecutorFactory MOCK_EXECUTOR_FACTORY =
      EasyMock.createMock(ExecutorFactory.class);
  private static final GrpcTransportOptions OPTIONS = GrpcTransportOptions.newBuilder()
      .setExecutorFactory(MOCK_EXECUTOR_FACTORY)
      .build();
  private static final GrpcTransportOptions DEFAULT_OPTIONS =
      GrpcTransportOptions.newBuilder().build();
  private static final GrpcTransportOptions OPTIONS_COPY = OPTIONS.toBuilder().build();

  @Test
  public void testBuilder() {
    assertSame(MOCK_EXECUTOR_FACTORY, OPTIONS.getExecutorFactory());
    assertTrue(DEFAULT_OPTIONS.getExecutorFactory() instanceof DefaultExecutorFactory);
  }

  @Test
  public void testBaseEquals() {
    assertEquals(OPTIONS, OPTIONS_COPY);
    assertNotEquals(DEFAULT_OPTIONS, OPTIONS);
    GrpcTransportOptions options = OPTIONS.toBuilder()
        .setExecutorFactory(new DefaultExecutorFactory())
        .build();
    assertNotEquals(OPTIONS, options);
  }

  @Test
  public void testBaseHashCode() {
    assertEquals(OPTIONS.hashCode(), OPTIONS_COPY.hashCode());
    assertNotEquals(DEFAULT_OPTIONS.hashCode(), OPTIONS.hashCode());
    GrpcTransportOptions options = OPTIONS.toBuilder()
        .setExecutorFactory(new DefaultExecutorFactory())
        .build();
    assertNotEquals(OPTIONS.hashCode(), options.hashCode());
  }

  @Test
  public void testDefaultExecutorFactory() {
    ExecutorFactory<ScheduledExecutorService> executorFactory = new DefaultExecutorFactory();
    ScheduledExecutorService executorService = executorFactory.get();
    assertSame(executorService, executorFactory.get());
  }

  @Test
  public void testHeader() {
    String expectedHeaderPattern = "^gl-java/.+ gccl/0.0.0+ gax/.+ grpc/.+";
    assertTrue(Pattern.compile(expectedHeaderPattern)
        .matcher(OPTIONS.getXGoogApiClientHeader("0.0.0"))
        .find());
  }
}
