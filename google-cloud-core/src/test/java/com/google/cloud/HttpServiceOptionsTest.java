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
import com.google.cloud.HttpServiceOptions.DefaultHttpTransportFactory;
import com.google.cloud.spi.ServiceRpcFactory;

import org.easymock.EasyMock;
import org.junit.Test;

import java.util.Set;

public class HttpServiceOptionsTest {

  private static final HttpTransportFactory MOCK_HTTP_TRANSPORT_FACTORY =
      EasyMock.createMock(HttpTransportFactory.class);
  private static final TestHttpServiceOptions OPTIONS = TestHttpServiceOptions.newBuilder()
      .setProjectId("project-id")
      .setConnectTimeout(1234)
      .setHttpTransportFactory(MOCK_HTTP_TRANSPORT_FACTORY)
      .setReadTimeout(5678)
      .build();
  private static final TestHttpServiceOptions DEPRECATED_OPTIONS =
      TestHttpServiceOptions.newBuilder()
          .projectId("project-id")
          .connectTimeout(1234)
          .httpTransportFactory(MOCK_HTTP_TRANSPORT_FACTORY)
          .readTimeout(5678)
          .build();
  private static final TestHttpServiceOptions DEFAULT_OPTIONS =
      TestHttpServiceOptions.newBuilder().setProjectId("project-id").build();
  private static final TestHttpServiceOptions DEPRECATED_DEFAULT_OPTIONS =
      TestHttpServiceOptions.newBuilder().projectId("project-id").build();
  private static final TestHttpServiceOptions OPTIONS_COPY = OPTIONS.toBuilder().build();

  private interface TestService extends Service<TestHttpServiceOptions> {}

  private static class TestServiceImpl
      extends BaseService<TestHttpServiceOptions> implements TestService {
    private TestServiceImpl(TestHttpServiceOptions options) {
      super(options);
    }
  }

  private interface TestServiceFactory extends ServiceFactory<TestService, TestHttpServiceOptions> {
  }

  private static class DefaultTestServiceFactory implements TestServiceFactory {
    private static final TestServiceFactory INSTANCE = new DefaultTestServiceFactory();

    @Override
    public TestService create(TestHttpServiceOptions options) {
      return new TestServiceImpl(options);
    }
  }

  private interface TestServiceRpcFactory
      extends ServiceRpcFactory<TestServiceRpc, TestHttpServiceOptions> {}

  private static class DefaultTestServiceRpcFactory implements TestServiceRpcFactory {
    private static final TestServiceRpcFactory INSTANCE = new DefaultTestServiceRpcFactory();

    @Override
    public TestServiceRpc create(TestHttpServiceOptions options) {
      return new DefaultTestServiceRpc(options);
    }
  }

  private interface TestServiceRpc {}

  private static class DefaultTestServiceRpc implements TestServiceRpc {
    DefaultTestServiceRpc(TestHttpServiceOptions options) {}
  }

  private static class TestHttpServiceOptions
      extends HttpServiceOptions<TestService, TestServiceRpc, TestHttpServiceOptions> {
    private static class Builder
        extends HttpServiceOptions.Builder<TestService, TestServiceRpc, TestHttpServiceOptions,
            Builder> {
      private Builder() {}

      private Builder(TestHttpServiceOptions options) {
        super(options);
      }

      @Override
      protected TestHttpServiceOptions build() {
        return new TestHttpServiceOptions(this);
      }
    }

    private TestHttpServiceOptions(Builder builder) {
      super(TestServiceFactory.class, TestServiceRpcFactory.class, builder);
    }

    @Override
    protected TestServiceFactory getDefaultServiceFactory() {
      return DefaultTestServiceFactory.INSTANCE;
    }

    @Override
    protected TestServiceRpcFactory getDefaultRpcFactory() {
      return DefaultTestServiceRpcFactory.INSTANCE;
    }

    @Override
    protected Set<String> getScopes() {
      return null;
    }

    @Override
    public Builder toBuilder() {
      return new Builder(this);
    }

    private static Builder newBuilder() {
      return new Builder();
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof TestHttpServiceOptions && baseEquals((TestHttpServiceOptions) obj);
    }

    @Override
    public int hashCode() {
      return baseHashCode();
    }
  }

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
  public void testBuilderDeprecated() {
    assertEquals(1234, DEPRECATED_OPTIONS.connectTimeout());
    assertSame(MOCK_HTTP_TRANSPORT_FACTORY, DEPRECATED_OPTIONS.httpTransportFactory());
    assertEquals(5678, DEPRECATED_OPTIONS.readTimeout());
    assertEquals(-1, DEPRECATED_DEFAULT_OPTIONS.connectTimeout());
    assertTrue(
        DEPRECATED_DEFAULT_OPTIONS.httpTransportFactory() instanceof DefaultHttpTransportFactory);
    assertEquals(-1, DEPRECATED_DEFAULT_OPTIONS.readTimeout());
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
}
