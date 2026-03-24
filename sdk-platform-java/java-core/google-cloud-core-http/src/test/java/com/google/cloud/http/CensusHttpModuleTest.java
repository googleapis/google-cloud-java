/*
 * Copyright 2018 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createMockBuilder;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import io.opencensus.common.Scope;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.TraceId;
import io.opencensus.trace.TraceOptions;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracestate;
import io.opencensus.trace.Tracing;
import io.opencensus.trace.propagation.TextFormat;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests for {@link CensusHttpModule}. */
class CensusHttpModuleTest {

  private final Tracer tracer = Tracing.getTracer();
  private final CensusHttpModule censusHttpModule = new CensusHttpModule(tracer, false);
  private HttpRequest httpRequest;

  @BeforeEach
  void setUp() throws IOException {
    httpRequest =
        new NetHttpTransport()
            .createRequestFactory()
            .buildRequest("GET", new GenericUrl("https://www.google.com"), null);
  }

  @Test
  void tracerShouldNotBeNull() {
    assertThat(censusHttpModule.getTracer()).isNotNull();
  }

  @Test
  void isRecordEventsShouldBeSet() {
    assertThat(censusHttpModule.isRecordEvents()).isEqualTo(false);
  }

  @Test
  void getHttpRequestInitializerShouldReturnCorrectClass() {
    HttpRequestInitializer initializer = censusHttpModule.getHttpRequestInitializer(null);
    assertThat(initializer).isInstanceOf(CensusHttpModule.CensusHttpRequestInitializer.class);
  }

  @Test
  void implementationOfDefaultTextFormatSetter() {
    String testKey = "testKey";
    String testValue = "testValue";
    TextFormat.Setter<HttpHeaders> setter =
        CensusHttpModule.DefaultPropagationTextFormatSetter.INSTANCE;
    setter.put(httpRequest.getHeaders(), testKey, testValue);
    assertThat(httpRequest.getHeaders().get(testKey)).isEqualTo(testValue);
  }

  @Test
  void censusHttpExecuteInterceptorDisallowNullRequest() {
    HttpExecuteInterceptor interceptor = censusHttpModule.new CensusHttpExecuteInterceptor(null);
    assertThrows(NullPointerException.class, () -> interceptor.intercept(null));
  }

  @Test
  void censusHttpExecuteInterceptorShouldExecuteOriginal() throws IOException {
    HttpExecuteInterceptor mockInterceptor = createMock(HttpExecuteInterceptor.class);
    HttpExecuteInterceptor censusInterceptor =
        censusHttpModule.new CensusHttpExecuteInterceptor(mockInterceptor);
    mockInterceptor.intercept(httpRequest);
    replay(mockInterceptor);
    censusInterceptor.intercept(httpRequest);
    verify(mockInterceptor);
  }

  @Test
  void censusHttpExecuteInterceptorShouldInjectHeader() throws IOException {
    Random random = new Random();
    SpanContext spanContext =
        SpanContext.create(
            TraceId.generateRandomId(random),
            SpanId.generateRandomId(random),
            TraceOptions.DEFAULT,
            Tracestate.builder().build());
    Span mockSpan =
        createMockBuilder(Span.class)
            .withConstructor(SpanContext.class, EnumSet.class)
            .withArgs(spanContext, null)
            .createMock();
    Scope scope = tracer.withSpan(mockSpan);
    try {
      HttpExecuteInterceptor interceptor = censusHttpModule.new CensusHttpExecuteInterceptor(null);
      interceptor.intercept(httpRequest);
      assertThat(httpRequest.getHeaders().get("X-Cloud-Trace-Context")).isNotNull();
    } finally {
      scope.close();
    }
  }

  @Test
  void censusHttpRequestInitializerDisallowNullRequest() {
    HttpRequestInitializer initializer = censusHttpModule.getHttpRequestInitializer(null);
    assertThrows(NullPointerException.class, () -> initializer.initialize(null));
  }

  @Test
  void censusHttpRequestInitializerShouldExecuteOriginal() throws IOException {
    HttpRequestInitializer mockOriginalInitializer = createMock(HttpRequestInitializer.class);
    HttpRequestInitializer censusInitializer =
        censusHttpModule.getHttpRequestInitializer(mockOriginalInitializer);
    mockOriginalInitializer.initialize(httpRequest);
    replay(mockOriginalInitializer);
    censusInitializer.initialize(httpRequest);
    verify(mockOriginalInitializer);
  }

  @Test
  void censusHttpRequestInitializerShouldSetInterceptor() throws IOException {
    censusHttpModule.getHttpRequestInitializer(null).initialize(httpRequest);
    assertThat(httpRequest.getInterceptor())
        .isInstanceOf(CensusHttpModule.CensusHttpExecuteInterceptor.class);
  }
}
