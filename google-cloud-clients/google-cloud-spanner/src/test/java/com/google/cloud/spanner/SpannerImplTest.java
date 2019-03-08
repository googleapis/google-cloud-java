/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLHandshakeException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/** Unit tests for {@link SpannerImpl}. */
@RunWith(JUnit4.class)
public class SpannerImplTest {
  @Mock private SpannerRpc rpc;
  @Mock private SpannerOptions spannerOptions;
  private SpannerImpl impl;

  @Captor ArgumentCaptor<Map<SpannerRpc.Option, Object>> options;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    impl = new SpannerImpl(rpc, 1, spannerOptions);
  }

  @Test
  public void createAndCloseSession() {
    Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    Mockito.when(spannerOptions.getSessionLabels()).thenReturn(labels);
    String dbName = "projects/p1/instances/i1/databases/d1";
    String sessionName = dbName + "/sessions/s1";
    DatabaseId db = DatabaseId.of(dbName);

    com.google.spanner.v1.Session sessionProto =
        com.google.spanner.v1.Session.newBuilder()
            .setName(sessionName)
            .putAllLabels(labels)
            .build();
    Mockito.when(rpc.createSession(Mockito.eq(dbName), Mockito.eq(labels), options.capture()))
        .thenReturn(sessionProto);
    Session session = impl.createSession(db);
    assertThat(session.getName()).isEqualTo(sessionName);

    session.close();
    // The same channelHint is passed for deleteSession (contained in "options").
    Mockito.verify(rpc).deleteSession(sessionName, options.getValue());
  }

  @Test
  public void getDbclientAgainGivesSame() {
    Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    Mockito.when(spannerOptions.getSessionLabels()).thenReturn(labels);
    String dbName = "projects/p1/instances/i1/databases/d1";
    DatabaseId db = DatabaseId.of(dbName);

    Mockito.when(spannerOptions.getTransportOptions())
        .thenReturn(GrpcTransportOptions.newBuilder().build());
    Mockito.when(spannerOptions.getSessionPoolOptions())
        .thenReturn(SessionPoolOptions.newBuilder().build());

    DatabaseClient databaseClient = impl.getDatabaseClient(db);

    // Get db client again
    DatabaseClient databaseClient1 = impl.getDatabaseClient(db);

    assertThat(databaseClient1).isSameAs(databaseClient);
  }

  @Test
  public void getDbclientAfterCloseThrows() {
    SpannerImpl imp = new SpannerImpl(rpc, 1, spannerOptions);
    Map<String, String> labels = new HashMap<>();
    labels.put("env", "dev");
    Mockito.when(spannerOptions.getSessionLabels()).thenReturn(labels);
    String dbName = "projects/p1/instances/i1/databases/d1";
    DatabaseId db = DatabaseId.of(dbName);

    Mockito.when(spannerOptions.getTransportOptions())
        .thenReturn(GrpcTransportOptions.newBuilder().build());
    Mockito.when(spannerOptions.getSessionPoolOptions())
        .thenReturn(SessionPoolOptions.newBuilder().build());

    imp.close();

    try {
      imp.getDatabaseClient(db);
      fail("Expected exception");
    } catch (IllegalStateException e) {
      assertThat(e.getMessage()).contains("Cloud Spanner client has been closed");
    }
  }

  @Test
  public void exceptionIsTranslated() {
    try {
      SpannerImpl.runWithRetries(
          new Callable<Object>() {
            @Override
            public Void call() throws Exception {
              throw new Exception("Should be translated to SpannerException");
            }
          });
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INTERNAL);
      assertThat(e.getMessage().contains("Unexpected exception thrown"));
    }
  }

  @Test
  public void sslHandshakeExceptionIsNotRetryable() {
    // Verify that a SpannerException with code UNAVAILABLE and cause SSLHandshakeException is not
    // retryable.
    boolean gotExpectedException = false;
    try {
      SpannerImpl.runWithRetries(
          new Callable<Object>() {
            @Override
            public Void call() throws Exception {
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.UNAVAILABLE,
                  "This exception should not be retryable",
                  new SSLHandshakeException("some SSL handshake exception"));
            }
          });
    } catch (SpannerException e) {
      gotExpectedException = true;
      assertThat(e.isRetryable(), is(false));
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNAVAILABLE);
      assertThat(e.getMessage().contains("This exception should not be retryable"));
    }
    assertThat(gotExpectedException, is(true));

    // Verify that any other SpannerException with code UNAVAILABLE is retryable.
    SpannerImpl.runWithRetries(
        new Callable<Object>() {
          private boolean firstTime = true;

          @Override
          public Void call() throws Exception {
            // Keep track of whethr this is the first call or a subsequent call to avoid an infinite
            // loop.
            if (firstTime) {
              firstTime = false;
              throw SpannerExceptionFactory.newSpannerException(
                  ErrorCode.UNAVAILABLE,
                  "This exception should be retryable",
                  new Exception("some other exception"));
            }
            return null;
          }
        });
  }
}
