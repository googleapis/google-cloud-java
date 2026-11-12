/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.common.collect.ImmutableList;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.MethodDescriptor;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GrpcInterceptorProviderTest extends AbstractMockServerTest {
  private static final AtomicBoolean INTERCEPTOR_CALLED = new AtomicBoolean(false);

  public static final class TestGrpcInterceptorProvider implements GrpcInterceptorProvider {
    @Override
    public List<ClientInterceptor> getInterceptors() {
      return ImmutableList.of(
          new ClientInterceptor() {
            @Override
            public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
              INTERCEPTOR_CALLED.set(true);
              return next.newCall(method, callOptions);
            }
          });
    }
  }

  public static final class InterceptorProviderWithoutNoArgConstructor
      implements GrpcInterceptorProvider {
    public InterceptorProviderWithoutNoArgConstructor(String ignored) {}

    @Override
    public List<ClientInterceptor> getInterceptors() {
      return ImmutableList.of();
    }
  }

  public static final class InterceptorProviderWithFailingConstructor
      implements GrpcInterceptorProvider {
    public InterceptorProviderWithFailingConstructor() {
      throw new IllegalArgumentException("Simulated interceptor failure");
    }

    @Override
    public List<ClientInterceptor> getInterceptors() {
      return ImmutableList.of();
    }
  }

  public static final class InterceptorProviderWithPrivateConstructor
      implements GrpcInterceptorProvider {
    private InterceptorProviderWithPrivateConstructor() {}

    @Override
    public List<ClientInterceptor> getInterceptors() {
      return ImmutableList.of();
    }
  }

  public abstract static class AbstractInterceptorProvider implements GrpcInterceptorProvider {
    public AbstractInterceptorProvider() {}
  }

  public static final class InterceptorProviderWithFailingStaticInitializer
      implements GrpcInterceptorProvider {
    static {
      if (true) {
        throw new RuntimeException("Simulated static init failure");
      }
    }

    @Override
    public List<ClientInterceptor> getInterceptors() {
      return ImmutableList.of();
    }
  }

  @Before
  public void clearInterceptorUsedFlag() {
    INTERCEPTOR_CALLED.set(false);
  }

  @Test
  public void testGrpcInterceptorProviderIsNotUsedByDefault() {
    assertFalse(INTERCEPTOR_CALLED.get());
    try (Connection connection = createConnection()) {
      try (ResultSet resultSet = connection.executeQuery(SELECT1_STATEMENT)) {
        while (resultSet.next()) {
          // ignore
        }
      }
    }
    assertFalse(INTERCEPTOR_CALLED.get());
  }

  @Test
  public void testGrpcInterceptorProviderIsUsedWhenConfigured() throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          assertFalse(INTERCEPTOR_CALLED.get());
          try (Connection connection =
              createConnection(
                  ";grpc_interceptor_provider=" + TestGrpcInterceptorProvider.class.getName())) {
            try (ResultSet resultSet = connection.executeQuery(SELECT1_STATEMENT)) {
              while (resultSet.next()) {
                // ignore
              }
            }
          }
          assertTrue(INTERCEPTOR_CALLED.get());
        });
  }

  @Test
  public void testGrpcInterceptorProviderRequiresSystemProperty() throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyDisabled(
        ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          assertFalse(INTERCEPTOR_CALLED.get());
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () ->
                      createConnection(
                          ";grpc_interceptor_provider="
                              + TestGrpcInterceptorProvider.class.getName()));
          assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception
                  .getMessage()
                  .contains(
                      "grpc_interceptor_provider can only be used if the system property"
                          + " ENABLE_GRPC_INTERCEPTOR_PROVIDER has been set to true. Start the"
                          + " application with the JVM command line option"
                          + " -DENABLE_GRPC_INTERCEPTOR_PROVIDER=true"));
          assertFalse(INTERCEPTOR_CALLED.get());
        });
  }

  @Test
  public void testGrpcInterceptorProviderConverter_DirectCallWithoutSystemProperty()
      throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyDisabled(
        ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () ->
                      ClientSideStatementValueConverters.GrpcInterceptorProviderConverter.INSTANCE
                          .convert(TestGrpcInterceptorProvider.class.getName()));
          assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
        });
  }

  @Test
  public void testGrpcInterceptorProvider_ClassDoesNotImplementInterface() throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () -> createConnection(";grpc_interceptor_provider=" + String.class.getName()));
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception
                  .getMessage()
                  .contains(
                      String.format(
                          "Class %s does not implement %s",
                          String.class.getName(), GrpcInterceptorProvider.class.getName())));
        });
  }

  @Test
  public void testGrpcInterceptorProvider_NonExistentClass() throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () ->
                      createConnection(
                          ";grpc_interceptor_provider=com.google.cloud.spanner.connection.NonExistentClass"));
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception
                  .getMessage()
                  .contains(
                      "Unknown or invalid GrpcInterceptorProvider class name: com.google.cloud.spanner.connection.NonExistentClass"));
        });
  }

  @Test
  public void testGrpcInterceptorProvider_NoPublicNoArgConstructor() throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () ->
                      createConnection(
                          ";grpc_interceptor_provider="
                              + InterceptorProviderWithoutNoArgConstructor.class.getName()));
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception
                  .getMessage()
                  .contains(
                      "GrpcInterceptorProvider "
                          + InterceptorProviderWithoutNoArgConstructor.class.getName()
                          + " does not have a public no-arg constructor."));
        });
  }

  @Test
  public void testGrpcInterceptorProvider_ConstructorThrowsException() throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () ->
                      createConnection(
                          ";grpc_interceptor_provider="
                              + InterceptorProviderWithFailingConstructor.class.getName()));
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception.getMessage().contains("Simulated interceptor failure"));
        });
  }

  @Test
  public void testGrpcInterceptorProvider_PrivateNoArgConstructor() throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () ->
                      createConnection(
                          ";grpc_interceptor_provider="
                              + InterceptorProviderWithPrivateConstructor.class.getName()));
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception.getMessage().contains("does not have a public no-arg constructor"));
        });
  }

  @Test
  public void testGrpcInterceptorProvider_AbstractClass() throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () ->
                      createConnection(
                          ";grpc_interceptor_provider="
                              + AbstractInterceptorProvider.class.getName()));
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception.getMessage().contains("is abstract and cannot be instantiated"));
        });
  }

  @Test
  public void testGrpcInterceptorProvider_StaticInitializerThrowsException() throws Throwable {
    ConnectionOptionsTest.runWithSystemPropertyEnabled(
        ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        () -> {
          SpannerException exception =
              assertThrows(
                  SpannerException.class,
                  () ->
                      createConnection(
                          ";grpc_interceptor_provider="
                              + InterceptorProviderWithFailingStaticInitializer.class.getName()));
          assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
          assertTrue(
              exception.getMessage(),
              exception
                      .getMessage()
                      .contains(
                          "Failed to create an instance of "
                              + InterceptorProviderWithFailingStaticInitializer.class.getName())
                  && (exception.getMessage().contains("Simulated static init failure")
                      || exception.getMessage().contains("Could not initialize class")));
        });
  }
}
