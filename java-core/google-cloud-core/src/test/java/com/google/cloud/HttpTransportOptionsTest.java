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

package com.google.cloud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.auth.http.HttpTransportFactory;
import com.google.cloud.HttpTransportOptions.DefaultHttpTransportFactory;
import java.util.regex.Pattern;
import org.easymock.EasyMock;
import org.junit.Test;

public class HttpTransportOptionsTest {

  private static final HttpTransportFactory MOCK_HTTP_TRANSPORT_FACTORY =
      EasyMock.createMock(HttpTransportFactory.class);
  private static final HttpTransportOptions OPTIONS = HttpTransportOptions.newBuilder()
      .setConnectTimeout(1234)
      .setHttpTransportFactory(MOCK_HTTP_TRANSPORT_FACTORY)
      .setReadTimeout(5678)
      .build();
  private static final HttpTransportOptions DEFAULT_OPTIONS =
      HttpTransportOptions.newBuilder().build();
  private static final HttpTransportOptions OPTIONS_COPY = OPTIONS.toBuilder().build();

  @Test
  public void testBuilder() {
    assertEquals(1234, OPTIONS.getConnectTimeout());
    assertSame(MOCK_HTTP_TRANSPORT_FACTORY, OPTIONS.getHttpTransportFactory());
    assertEquals(5678, OPTIONS.getReadTimeout());
    assertEquals(-1, DEFAULT_OPTIONS.getConnectTimeout());
    assertTrue(DEFAULT_OPTIONS.getHttpTransportFactory() instanceof DefaultHttpTransportFactory);
    assertEquals(-1, DEFAULT_OPTIONS.getReadTimeout());
  }

  @Test
  public void testBaseEquals() {
    assertEquals(OPTIONS, OPTIONS_COPY);
    assertNotEquals(DEFAULT_OPTIONS, OPTIONS);
  }

  @Test
  public void testBaseHashCode() {
    assertEquals(OPTIONS.hashCode(), OPTIONS_COPY.hashCode());
    assertNotEquals(DEFAULT_OPTIONS.hashCode(), OPTIONS.hashCode());
  }

  @Test
  public void testHeader() {
    String expectedHeaderPattern = "^gl-java/.* gccl/.*";
    assertTrue(Pattern.compile(expectedHeaderPattern)
        .matcher(DEFAULT_OPTIONS.getXGoogApiClientHeader())
        .find());
  }
}
