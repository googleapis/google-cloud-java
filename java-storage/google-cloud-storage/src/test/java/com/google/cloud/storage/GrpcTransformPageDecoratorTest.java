/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.storage.GrpcStorageImpl.TransformingPageDecorator;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Streams;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.Test;
import org.mockito.Mockito;

public class GrpcTransformPageDecoratorTest {

  // define some common data used across our tests
  private final ApiCallContext apiCallContext = Mockito.mock(ApiCallContext.class);

  // Initial values for the first page
  private final ImmutableList<String> page1 = ImmutableList.of("string1", "string2", "string3");
  // Request which will be appended to the second page
  private final ImmutableList<String> page2 = ImmutableList.of("string4");
  // Request which will be appended to the second page
  private final ImmutableList<String> page3 = ImmutableList.of("string5");

  // Expected values after the translation
  private final List<String> expectedValues =
      Streams.concat(page1.stream(), page2.stream(), page3.stream())
          .map(String::toUpperCase)
          .collect(ImmutableList.toImmutableList());

  private final Req req1 = new Req("req1");
  private final Resp resp1 = new Resp("req2", page1);
  private final Req req2 = new Req("req2");
  private final Resp resp2 = new Resp("req3", page2);
  private final Req req3 = new Req("req3");
  private final Resp resp3 = new Resp(null, page3);
  private final ImmutableMap<Req, Resp> data =
      ImmutableMap.of(
          req1, resp1,
          req2, resp2,
          req3, resp3);

  @Test
  public void valueTranslationTest() {
    UnaryCallable<Req, Resp> callable = new DataDrivenCallable(data);
    ReqRespDescriptor descriptor = new ReqRespDescriptor();
    PageContext<Req, Resp, String> context =
        PageContext.create(callable, descriptor, req1, apiCallContext);
    ReqRespPage page = new ReqRespPage(context, resp1);
    TransformingPageDecorator<Req, Resp, String, ReqRespPage, String> decorator =
        new TransformingPageDecorator<>(
            page,
            String::toUpperCase,
            TestUtils.defaultRetrier(),
            StorageRetryStrategy.getUniformStorageRetryStrategy().getIdempotentHandler());

    assertThat(ImmutableList.copyOf(decorator.getValues().iterator()))
        .containsExactlyElementsIn(
            page1.stream().map(String::toUpperCase).collect(Collectors.toList()));
    assertThat(ImmutableList.copyOf(decorator.iterateAll().iterator()))
        .containsExactlyElementsIn(expectedValues);
  }

  @Test
  public void retryWorks() {
    FailureInducingCallable callable = new FailureInducingCallable(new DataDrivenCallable(data));

    ShouldRetryExceptionAlgorithm alg = new ShouldRetryExceptionAlgorithm();

    ReqRespDescriptor descriptor = new ReqRespDescriptor();
    PageContext<Req, Resp, String> context =
        PageContext.create(callable, descriptor, req1, apiCallContext);
    ReqRespPage page = new ReqRespPage(context, resp1);
    TransformingPageDecorator<Req, Resp, String, ReqRespPage, String> decorator =
        new TransformingPageDecorator<>(page, String::toUpperCase, TestUtils.defaultRetrier(), alg);

    ImmutableList<String> actual = ImmutableList.copyOf(decorator.iterateAll().iterator());
    assertThat(actual).containsExactlyElementsIn(expectedValues);
    // sometimes shouldRetry is called multiple times, not totally sure why
    assertThat(alg.shouldRetryCallCount.get()).isAtLeast(1);
    // we expect to attempt the RPC twice, first attempt fails, latter calls succeed
    assertThat(callable.callableCallCount.get()).isEqualTo(3);
  }

  private static class ReqRespPage extends AbstractPage<Req, Resp, String, ReqRespPage> {

    private final Resp response;

    public ReqRespPage(PageContext<Req, Resp, String> context, Resp response) {
      super(context, response);
      this.response = response;
    }

    @Override
    public ReqRespPage createPage(PageContext<Req, Resp, String> context, Resp response) {
      return new ReqRespPage(context, response);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("response", response).toString();
    }
  }

  private static class ReqRespDescriptor implements PagedListDescriptor<Req, Resp, String> {

    @Override
    public String emptyToken() {
      return "";
    }

    @Override
    public Req injectToken(Req payload, String token) {
      return payload.withToken(token);
    }

    @Override
    public Req injectPageSize(Req payload, int pageSize) {
      return payload.withPageSize(pageSize);
    }

    @Override
    public Integer extractPageSize(Req payload) {
      return payload.pageSize;
    }

    @Override
    public String extractNextToken(Resp payload) {
      return payload.nextToken != null ? payload.nextToken : emptyToken();
    }

    @Override
    public Iterable<String> extractResources(Resp payload) {
      return payload.resources;
    }
  }

  /**
   * Provide an immutable map of {@link Req} to {@link Resp}, when {@link #futureCall(Req,
   * ApiCallContext)} is invoked attempt to retrieve the Resp from the provided map, if it's present
   * return it, if not return an exception.
   */
  private static class DataDrivenCallable extends UnaryCallable<Req, Resp> {
    private final ImmutableMap<Req, Resp> data;

    private DataDrivenCallable(ImmutableMap<Req, Resp> data) {
      this.data = data;
    }

    @Override
    public ApiFuture<Resp> futureCall(Req request, ApiCallContext context) {
      if (data.containsKey(request)) {
        return ApiFutures.immediateFuture(data.get(request));
      }
      return ApiFutures.immediateFailedFuture(
          new IllegalStateException("No matching response for request: " + request));
    }
  }

  private static final class Req {
    private final String token;
    private final int pageSize;

    Req(String token) {
      this(token, 5);
    }

    Req(String token, int pageSize) {
      this.token = token;
      this.pageSize = pageSize;
    }

    Req withToken(String t) {
      return new Req(t, pageSize);
    }

    Req withPageSize(int i) {
      return new Req(token, i);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Req)) {
        return false;
      }
      Req req = (Req) o;
      return pageSize == req.pageSize && Objects.equals(token, req.token);
    }

    @Override
    public int hashCode() {
      return Objects.hash(token, pageSize);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("token", token)
          .add("pageSize", pageSize)
          .toString();
    }
  }

  private static final class Resp {
    private final String nextToken;
    private final ImmutableList<String> resources;

    public Resp(String nextToken, ImmutableList<String> resources) {
      this.resources = resources;
      this.nextToken = nextToken;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("nextToken", nextToken)
          .add("resources", resources)
          .toString();
    }
  }

  private static final class ShouldRetryException extends RuntimeException {}

  private static final class ShouldRetryExceptionAlgorithm implements ResultRetryAlgorithm<Object> {
    private final AtomicInteger shouldRetryCallCount;

    public ShouldRetryExceptionAlgorithm() {
      shouldRetryCallCount = new AtomicInteger(0);
    }

    @Override
    public TimedAttemptSettings createNextAttempt(
        Throwable prevThrowable, Object prevResponse, TimedAttemptSettings prevSettings) {
      return null;
    }

    @Override
    public boolean shouldRetry(Throwable prevThrowable, Object prevResponse)
        throws CancellationException {
      shouldRetryCallCount.incrementAndGet();
      return TestUtils.findThrowable(ShouldRetryException.class, prevThrowable) != null;
    }
  }

  private static final class FailureInducingCallable extends UnaryCallable<Req, Resp> {

    private final AtomicInteger callableCallCount;
    private final UnaryCallable<Req, Resp> delegate;

    FailureInducingCallable(UnaryCallable<Req, Resp> delegate) {
      this.delegate = delegate;
      this.callableCallCount = new AtomicInteger(0);
    }

    @Override
    public ApiFuture<Resp> futureCall(Req request, ApiCallContext context) {
      int callCount = callableCallCount.getAndIncrement();
      if (callCount == 0) {
        throw new ShouldRetryException();
      }
      return delegate.futureCall(request, context);
    }
  }
}
