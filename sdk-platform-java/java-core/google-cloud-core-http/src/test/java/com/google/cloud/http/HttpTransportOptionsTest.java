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

package com.google.cloud.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.HttpTesting;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.UnauthenticatedException;
import com.google.auth.Credentials;
import com.google.auth.http.HttpTransportFactory;
import com.google.cloud.BaseService;
import com.google.cloud.NoCredentials;
import com.google.cloud.Service;
import com.google.cloud.ServiceDefaults;
import com.google.cloud.ServiceFactory;
import com.google.cloud.ServiceOptions;
import com.google.cloud.ServiceRpc;
import com.google.cloud.TransportOptions;
import com.google.cloud.http.HttpTransportOptions.DefaultHttpTransportFactory;
import com.google.cloud.spi.ServiceRpcFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HttpTransportOptionsTest {
  private static final HttpTransport MOCK_HTTP_TRANSPORT =
      new MockHttpTransport() {
        @Override
        public LowLevelHttpRequest buildRequest(String method, String url) {
          return new MockLowLevelHttpRequest() {
            @Override
            public LowLevelHttpResponse execute() {
              return new MockLowLevelHttpResponse();
            }
          };
        }
      };

  private static final HttpTransportFactory MOCK_HTTP_TRANSPORT_FACTORY =
      EasyMock.createMock(HttpTransportFactory.class);
  private static final HttpTransportOptions OPTIONS =
      HttpTransportOptions.newBuilder()
          .setConnectTimeout(1234)
          .setHttpTransportFactory(MOCK_HTTP_TRANSPORT_FACTORY)
          .setReadTimeout(5678)
          .build();
  private static final HttpTransportOptions DEFAULT_OPTIONS =
      HttpTransportOptions.newBuilder().build();
  private static final HttpTransportOptions OPTIONS_COPY = OPTIONS.toBuilder().build();
  private static final String DEFAULT_PROJECT_ID = "testing";
  private static final String CUSTOM_UNIVERSE_DOMAIN = "random.com";

  private HeaderProvider defaultHeaderProvider;
  // Credentials' getUniverseDomain() returns GDU
  private Credentials defaultCredentials;
  // Credentials' getUniverseDomain() returns `random.com`
  private Credentials customCredentials;
  private HttpRequest defaultHttpRequest;

  @BeforeEach
  void setup() throws IOException {
    defaultHeaderProvider = EasyMock.createMock(HeaderProvider.class);
    EasyMock.expect(defaultHeaderProvider.getHeaders()).andReturn(new HashMap<>());

    defaultCredentials = EasyMock.createMock(Credentials.class);
    EasyMock.expect(defaultCredentials.getUniverseDomain())
        .andReturn(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    EasyMock.expect(defaultCredentials.hasRequestMetadata()).andReturn(false);

    customCredentials = EasyMock.createMock(Credentials.class);
    EasyMock.expect(customCredentials.getUniverseDomain()).andReturn(CUSTOM_UNIVERSE_DOMAIN);
    EasyMock.expect(customCredentials.hasRequestMetadata()).andReturn(false);

    EasyMock.replay(defaultHeaderProvider, defaultCredentials, customCredentials);

    defaultHttpRequest =
        MOCK_HTTP_TRANSPORT.createRequestFactory().buildGetRequest(HttpTesting.SIMPLE_GENERIC_URL);
  }

  @Test
  void testBuilder() {
    assertEquals(1234, OPTIONS.getConnectTimeout());
    assertSame(MOCK_HTTP_TRANSPORT_FACTORY, OPTIONS.getHttpTransportFactory());
    assertEquals(5678, OPTIONS.getReadTimeout());
    assertEquals(-1, DEFAULT_OPTIONS.getConnectTimeout());
    assertTrue(DEFAULT_OPTIONS.getHttpTransportFactory() instanceof DefaultHttpTransportFactory);
    assertEquals(-1, DEFAULT_OPTIONS.getReadTimeout());
  }

  @Test
  void testBaseEquals() {
    assertEquals(OPTIONS, OPTIONS_COPY);
    assertNotEquals(DEFAULT_OPTIONS, OPTIONS);
  }

  @Test
  void testBaseHashCode() {
    assertEquals(OPTIONS.hashCode(), OPTIONS_COPY.hashCode());
    assertNotEquals(DEFAULT_OPTIONS.hashCode(), OPTIONS.hashCode());
  }

  @Test
  void testHeader() {
    String expectedHeaderPattern = "^gl-java/.+ gccl/.* gax/.+";
    ServiceOptions<?, ?> serviceOptions = EasyMock.createMock(ServiceOptions.class);
    HeaderProvider headerProvider =
        OPTIONS.getInternalHeaderProviderBuilder(serviceOptions).build();

    assertEquals(1, headerProvider.getHeaders().size());
    assertTrue(
        Pattern.compile(expectedHeaderPattern)
            .matcher(headerProvider.getHeaders().values().iterator().next())
            .find());
  }

  @Test
  void testHttpRequestInitializer_defaultUniverseDomainSettings_defaultCredentials()
      throws IOException {
    TestServiceOptions testServiceOptions =
        generateTestServiceOptions(Credentials.GOOGLE_DEFAULT_UNIVERSE, defaultCredentials);
    HttpRequestInitializer httpRequestInitializer =
        DEFAULT_OPTIONS.getHttpRequestInitializer(testServiceOptions);
    // Does not throw a validation exception
    httpRequestInitializer.initialize(defaultHttpRequest);
  }

  @Test
  void testHttpRequestInitializer_defaultUniverseDomainSettings_customCredentials() {
    TestServiceOptions testServiceOptions =
        generateTestServiceOptions(Credentials.GOOGLE_DEFAULT_UNIVERSE, customCredentials);
    HttpRequestInitializer httpRequestInitializer =
        DEFAULT_OPTIONS.getHttpRequestInitializer(testServiceOptions);
    UnauthenticatedException exception =
        assertThrows(
            UnauthenticatedException.class,
            () -> httpRequestInitializer.initialize(defaultHttpRequest));
    assertEquals(
        "The configured universe domain (googleapis.com) does not match the universe domain found in the credentials (random.com). If you haven't configured the universe domain explicitly, `googleapis.com` is the default.",
        exception.getCause().getMessage());
  }

  @Test
  void testHttpRequestInitializer_customUniverseDomainSettings_defaultCredentials() {
    TestServiceOptions testServiceOptions =
        generateTestServiceOptions(CUSTOM_UNIVERSE_DOMAIN, defaultCredentials);
    HttpRequestInitializer httpRequestInitializer =
        DEFAULT_OPTIONS.getHttpRequestInitializer(testServiceOptions);
    UnauthenticatedException exception =
        assertThrows(
            UnauthenticatedException.class,
            () -> httpRequestInitializer.initialize(defaultHttpRequest));
    assertEquals(
        "The configured universe domain (random.com) does not match the universe domain found in the credentials (googleapis.com). If you haven't configured the universe domain explicitly, `googleapis.com` is the default.",
        exception.getCause().getMessage());
  }

  @Test
  void testHttpRequestInitializer_customUniverseDomainSettings_customCredentials()
      throws IOException {
    TestServiceOptions testServiceOptions =
        generateTestServiceOptions(CUSTOM_UNIVERSE_DOMAIN, customCredentials);
    HttpRequestInitializer httpRequestInitializer =
        DEFAULT_OPTIONS.getHttpRequestInitializer(testServiceOptions);
    // Does not throw a validation exception
    httpRequestInitializer.initialize(defaultHttpRequest);
  }

  @Test
  void testHttpRequestInitializer_defaultUniverseDomainSettings_noCredentials() throws IOException {
    NoCredentials noCredentials = NoCredentials.getInstance();
    TestServiceOptions testServiceOptions =
        generateTestServiceOptions(Credentials.GOOGLE_DEFAULT_UNIVERSE, noCredentials);
    HttpRequestInitializer httpRequestInitializer =
        DEFAULT_OPTIONS.getHttpRequestInitializer(testServiceOptions);
    // Does not throw a validation exception
    httpRequestInitializer.initialize(defaultHttpRequest);
  }

  @Test
  void testHttpRequestInitializer_customUniverseDomainSettings_noCredentials() {
    NoCredentials noCredentials = NoCredentials.getInstance();
    TestServiceOptions testServiceOptions =
        generateTestServiceOptions(CUSTOM_UNIVERSE_DOMAIN, noCredentials);
    HttpRequestInitializer httpRequestInitializer =
        DEFAULT_OPTIONS.getHttpRequestInitializer(testServiceOptions);
    UnauthenticatedException exception =
        assertThrows(
            UnauthenticatedException.class,
            () -> httpRequestInitializer.initialize(defaultHttpRequest));
    assertEquals(
        "The configured universe domain (random.com) does not match the universe domain found in the credentials (googleapis.com). If you haven't configured the universe domain explicitly, `googleapis.com` is the default.",
        exception.getCause().getMessage());
  }

  private TestServiceOptions generateTestServiceOptions(
      String universeDomain, Credentials credentials) {
    return TestServiceOptions.newBuilder()
        .setCredentials(credentials)
        .setHeaderProvider(defaultHeaderProvider)
        .setQuotaProjectId(DEFAULT_PROJECT_ID)
        .setProjectId(DEFAULT_PROJECT_ID)
        .setUniverseDomain(universeDomain)
        .build();
  }

  /**
   * The following interfaces and classes are from ServiceOptionsTest. Copied over here as
   * ServiceOptions resides inside google-cloud-core test folder and is not accessible from
   * google-cloud-core-http.
   */
  interface TestService extends Service<TestServiceOptions> {}

  private static class TestServiceImpl extends BaseService<TestServiceOptions>
      implements TestService {
    private TestServiceImpl(TestServiceOptions options) {
      super(options);
    }
  }

  public interface TestServiceFactory extends ServiceFactory<TestService, TestServiceOptions> {}

  private static class DefaultTestServiceFactory implements TestServiceFactory {
    private static final TestServiceFactory INSTANCE = new DefaultTestServiceFactory();

    @Override
    public TestService create(TestServiceOptions options) {
      return new TestServiceImpl(options);
    }
  }

  public interface TestServiceRpcFactory extends ServiceRpcFactory<TestServiceOptions> {}

  private static class DefaultTestServiceRpcFactory implements TestServiceRpcFactory {
    private static final TestServiceRpcFactory INSTANCE = new DefaultTestServiceRpcFactory();

    @Override
    public TestServiceRpc create(TestServiceOptions options) {
      return new DefaultTestServiceRpc(options);
    }
  }

  private interface TestServiceRpc extends ServiceRpc {}

  private static class DefaultTestServiceRpc implements TestServiceRpc {
    DefaultTestServiceRpc(TestServiceOptions options) {}
  }

  static class TestServiceOptions extends ServiceOptions<TestService, TestServiceOptions> {
    private static class Builder
        extends ServiceOptions.Builder<TestService, TestServiceOptions, Builder> {
      private Builder() {}

      private Builder(TestServiceOptions options) {
        super(options);
      }

      @Override
      protected TestServiceOptions build() {
        return new TestServiceOptions(this);
      }
    }

    private TestServiceOptions(Builder builder) {
      super(
          TestServiceFactory.class,
          TestServiceRpcFactory.class,
          builder,
          new TestServiceDefaults());
    }

    private static class TestServiceDefaults
        implements ServiceDefaults<TestService, TestServiceOptions> {

      @Override
      public TestServiceFactory getDefaultServiceFactory() {
        return DefaultTestServiceFactory.INSTANCE;
      }

      @Override
      public TestServiceRpcFactory getDefaultRpcFactory() {
        return DefaultTestServiceRpcFactory.INSTANCE;
      }

      @Override
      public TransportOptions getDefaultTransportOptions() {
        return new TransportOptions() {};
      }
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
      return obj instanceof TestServiceOptions && baseEquals((TestServiceOptions) obj);
    }

    @Override
    public int hashCode() {
      return baseHashCode();
    }
  }
}
