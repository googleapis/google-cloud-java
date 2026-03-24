/*
 * Copyright 2018 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.httpjson.testing;

import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.ApiMethodDescriptor.MethodType;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Mocks an HTTPTransport. Expected responses and exceptions can be added to a queue from which this
 * mock HttpTransport polls when it relays a response.
 *
 * <p>As required by {@link MockHttpTransport} this implementation is thread-safe, but it is not
 * idempotent (as a typical service would be) and must be used with extra caution. Mocked responses
 * are returned in FIFO order and if multiple threads read from the same MockHttpService
 * simultaneously, they may be getting responses intended for other consumers.
 */
public final class MockHttpService extends MockHttpTransport {
  private final Multimap<String, String> requestHeaders = LinkedListMultimap.create();
  private final List<String> requestPaths = new LinkedList<>();
  private final Queue<HttpResponseFactory> responseHandlers = new LinkedList<>();
  private final List<ApiMethodDescriptor> serviceMethodDescriptors;
  private final String endpoint;

  /**
   * Create a MockHttpService.
   *
   * @param serviceMethodDescriptors - list of method descriptors for the methods that this mock
   *     server supports
   * @param pathPrefix - the fixed portion of the endpoint URL that prefixes the methods' path
   *     template substring.
   */
  public MockHttpService(List<ApiMethodDescriptor> serviceMethodDescriptors, String pathPrefix) {
    this.serviceMethodDescriptors = ImmutableList.copyOf(serviceMethodDescriptors);
    this.endpoint = pathPrefix;
  }

  @Override
  public synchronized LowLevelHttpRequest buildRequest(String method, String url) {
    requestPaths.add(url);
    return new MockHttpRequest(this, method, url);
  }

  /** Add an ApiMessage to the response queue. */
  public synchronized void addResponse(Object response) {
    responseHandlers.add(new MessageResponseFactory(endpoint, serviceMethodDescriptors, response));
  }

  public synchronized void addResponse(Object response, java.time.Duration delay) {
    responseHandlers.add(
        new MessageResponseFactory(endpoint, serviceMethodDescriptors, response, delay));
  }

  /** Add an expected null response (empty HTTP response body) with a custom status code. */
  public synchronized void addNullResponse(int statusCode) {
    responseHandlers.add(
        (httpMethod, targetUrl) -> new MockLowLevelHttpResponse().setStatusCode(statusCode));
  }

  /** Add an expected null response (empty HTTP response body). */
  public synchronized void addNullResponse() {
    addNullResponse(200);
  }

  /** Add an Exception to the response queue. */
  public synchronized void addException(Exception exception) {
    addException(400, exception);
  }

  public synchronized void addException(int statusCode, Exception exception) {
    responseHandlers.add(new ExceptionResponseFactory(statusCode, exception));
  }

  /** Get the FIFO list of URL paths to which requests were sent. */
  public synchronized List<String> getRequestPaths() {
    return requestPaths;
  }

  /** Get the FIFO list of request headers sent. */
  public synchronized Multimap<String, String> getRequestHeaders() {
    return ImmutableListMultimap.copyOf(requestHeaders);
  }

  private synchronized void putRequestHeader(String name, String value) {
    requestHeaders.put(name, value);
  }

  private synchronized MockLowLevelHttpResponse getHttpResponse(String method, String url) {
    Preconditions.checkArgument(!responseHandlers.isEmpty());
    return responseHandlers.poll().getHttpResponse(method, url);
  }

  /* Reset the expected response queue, the method descriptor, and the logged request paths list. */
  public synchronized void reset() {
    responseHandlers.clear();
    requestPaths.clear();
    requestHeaders.clear();
  }

  private interface HttpResponseFactory {
    MockLowLevelHttpResponse getHttpResponse(String httpMethod, String targetUrl);
  }

  private static class MockHttpRequest extends MockLowLevelHttpRequest {
    private final MockHttpService service;
    private final String method;
    private final String url;

    public MockHttpRequest(MockHttpService service, String method, String url) {
      this.service = service;
      this.method = method;
      this.url = url;
    }

    @Override
    public void addHeader(String name, String value) {
      service.putRequestHeader(name, value);
    }

    @Override
    public LowLevelHttpResponse execute() {
      return service.getHttpResponse(method, url);
    }
  }

  private static class ExceptionResponseFactory implements HttpResponseFactory {
    private final int statusCode;
    private final Exception exception;

    public ExceptionResponseFactory(int statusCode, Exception exception) {
      this.statusCode = statusCode;
      this.exception = exception;
    }

    @Override
    public MockLowLevelHttpResponse getHttpResponse(String httpMethod, String targetUrl) {
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();
      httpResponse.setStatusCode(statusCode);
      httpResponse.setContent(exception.toString().getBytes());
      httpResponse.setContentEncoding("text/plain");
      return httpResponse;
    }
  }

  private static class MessageResponseFactory implements HttpResponseFactory {
    private final List<ApiMethodDescriptor> serviceMethodDescriptors;
    private final Object response;
    private final String endpoint;
    private final java.time.Duration delay;

    public MessageResponseFactory(
        String endpoint, List<ApiMethodDescriptor> serviceMethodDescriptors, Object response) {
      this(endpoint, serviceMethodDescriptors, response, java.time.Duration.ofNanos(0));
    }

    public MessageResponseFactory(
        String endpoint,
        List<ApiMethodDescriptor> serviceMethodDescriptors,
        Object response,
        java.time.Duration delay) {
      this.endpoint = endpoint;
      this.serviceMethodDescriptors = ImmutableList.copyOf(serviceMethodDescriptors);
      this.response = response;
      this.delay = delay;
    }

    @Override
    public MockLowLevelHttpResponse getHttpResponse(String httpMethod, String fullTargetUrl) {
      // We use Thread.sleep to mimic a long server response. Most tests should not
      // require a sleep and can return a response immediately.
      try {
        long delayMs = delay.toMillis();
        if (delayMs > 0) {
          Thread.sleep(delayMs);
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      MockLowLevelHttpResponse httpResponse = new MockLowLevelHttpResponse();

      String relativePath = getRelativePath(fullTargetUrl);

      for (ApiMethodDescriptor methodDescriptor : serviceMethodDescriptors) {
        // Check the comment in com.google.api.gax.httpjson.HttpRequestRunnable.buildRequest()
        // method for details why it is needed.
        String descriptorHttpMethod = methodDescriptor.getHttpMethod();
        if (!httpMethod.equals(descriptorHttpMethod)) {
          if (!(HttpMethods.PATCH.equals(descriptorHttpMethod)
              && HttpMethods.POST.equals(httpMethod))) {
            continue;
          }
        }

        PathTemplate pathTemplate = methodDescriptor.getRequestFormatter().getPathTemplate();
        List<PathTemplate> additionalPathTemplates =
            methodDescriptor.getRequestFormatter().getAdditionalPathTemplates();
        // Server figures out which RPC method is called based on the endpoint path pattern(s).
        if (!pathTemplate.matches(relativePath)
            && additionalPathTemplates.stream().noneMatch(pt -> pt.matches(relativePath))) {
          continue;
        }

        // Emulate the server's creation of an HttpResponse from the response message
        // instance.
        String httpContent;
        if (methodDescriptor.getType() == MethodType.SERVER_STREAMING) {
          // Quick and dirty json array construction. Good enough for
          Object[] responseArray = (Object[]) response;
          StringBuilder sb = new StringBuilder();
          sb.append('[');
          for (Object responseElement : responseArray) {
            if (sb.length() > 1) {
              sb.append(',');
            }
            sb.append(methodDescriptor.getResponseParser().serialize(responseElement));
          }
          sb.append(']');
          httpContent = sb.toString();
        } else {
          httpContent = methodDescriptor.getResponseParser().serialize(response);
        }

        httpResponse.setContent(httpContent.getBytes());
        httpResponse.setStatusCode(200);
        return httpResponse;
      }

      // Return 404 when none of this server's endpoint templates match the given URL.
      httpResponse.setContent(
          String.format("Method not found for path '%s'", relativePath).getBytes());
      httpResponse.setStatusCode(404);
      return httpResponse;
    }

    private String getRelativePath(String fullTargetUrl) {
      // relativePath will be repeatedly truncated until it contains only
      // the path template substring of the endpoint URL.
      String relativePath = fullTargetUrl.replaceFirst(endpoint, "");
      int queryParamIndex = relativePath.indexOf("?");
      queryParamIndex = queryParamIndex < 0 ? relativePath.length() : queryParamIndex;
      relativePath = relativePath.substring(0, queryParamIndex);

      return relativePath;
    }
  }
}
