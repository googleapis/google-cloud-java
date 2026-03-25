/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery.telemetry;

import static com.google.cloud.bigquery.telemetry.HttpTracingRequestInitializer.HTTP_RESPONSE_BODY_SIZE;

import com.google.api.client.http.LowLevelHttpResponse;
import com.google.common.io.CountingInputStream;
import io.opentelemetry.api.trace.Span;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class that wraps LowLevelHttpResponse to be able to inject an InputStream wrapper that allows us
 * to track response size in trace spans.
 */
class HttpTracingLowLevelHttpResponse extends LowLevelHttpResponse {
  private final LowLevelHttpResponse delegate;
  private InputStream countingInputStream;
  private final Span span;

  public HttpTracingLowLevelHttpResponse(LowLevelHttpResponse delegate, Span span) {
    this.delegate = delegate;
    this.span = span;
  }

  @Override
  public InputStream getContent() throws IOException {
    if (countingInputStream == null) {
      if (span != null && span.getSpanContext().isValid()) {
        countingInputStream = getWrappedInputStream(span, delegate.getContent());
      }
    }
    return countingInputStream;
  }

  @Override
  public String getContentEncoding() throws IOException {
    return delegate.getContentEncoding();
  }

  @Override
  public long getContentLength() throws IOException {
    return delegate.getContentLength();
  }

  @Override
  public String getContentType() throws IOException {
    return delegate.getContentType();
  }

  @Override
  public String getStatusLine() throws IOException {
    return delegate.getStatusLine();
  }

  @Override
  public int getStatusCode() throws IOException {
    return delegate.getStatusCode();
  }

  @Override
  public String getReasonPhrase() throws IOException {
    return delegate.getReasonPhrase();
  }

  @Override
  public int getHeaderCount() throws IOException {
    return delegate.getHeaderCount();
  }

  @Override
  public String getHeaderName(int index) throws IOException {
    return delegate.getHeaderName(index);
  }

  @Override
  public String getHeaderValue(int index) throws IOException {
    return delegate.getHeaderValue(index);
  }

  @Override
  public void disconnect() throws IOException {
    delegate.disconnect();
  }

  private InputStream getWrappedInputStream(Span span, InputStream content) {
    CountingInputStream counter = new CountingInputStream(content);
    return new FilterInputStream(counter) {
      @Override
      public void close() throws IOException {
        super.close();
        span.setAttribute(HTTP_RESPONSE_BODY_SIZE, counter.getCount());
      }
    };
  }
}
