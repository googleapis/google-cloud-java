/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import com.google.cloud.logging.HttpRequest.RequestMethod;
import com.google.common.base.Ascii;
import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Class to hold context attributes including information about {@see HttpRequest} and tracing. */
public class Context {
  // validate W3C trace context value on load according to the existing version format.
  // see https://www.w3.org/TR/trace-context/#traceparent-header-field-values for details.
  private static final Pattern W3C_TRACE_CONTEXT_FORMAT =
      Pattern.compile(
          "^00-(?!00000000000000000000000000000000)[0-9a-f]{32}-(?!0000000000000000)[0-9a-f]{16}-[0-9a-f]{2}$");
  // Trace sampled flag for bit masking
  // see https://www.w3.org/TR/trace-context/#trace-flags for details
  private static final byte FLAG_SAMPLED = 1; // 00000001
  private final HttpRequest request;
  private final String traceId;
  private final String spanId;
  private final boolean traceSampled;
  /** A builder for {@see Context} objects. */
  public static final class Builder {
    private HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();
    private String traceId;
    private String spanId;
    private boolean traceSampled;

    Builder() {}

    Builder(Context context) {
      this.requestBuilder = context.request.toBuilder();
      this.traceId = context.traceId;
      this.spanId = context.spanId;
      this.traceSampled = context.traceSampled;
    }

    /** Sets the HTTP request. */
    @CanIgnoreReturnValue
    public Builder setRequest(HttpRequest request) {
      this.requestBuilder = request != null ? request.toBuilder() : HttpRequest.newBuilder();
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setRequestUrl(String url) {
      this.requestBuilder.setRequestUrl(url);
      return this;
    }

    /** Sets the HTTP request method. */
    @CanIgnoreReturnValue
    public Builder setRequestMethod(RequestMethod method) {
      this.requestBuilder.setRequestMethod(method);
      return this;
    }

    /**
     * Sets the referer URL of the request, as defined in HTTP/1.1 Header Field Definitions.
     *
     * @see <a href= "http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html">HTTP/1.1 Header Field
     *     Definitions</a>
     */
    @CanIgnoreReturnValue
    public Builder setReferer(String referer) {
      this.requestBuilder.setReferer(referer);
      return this;
    }

    /**
     * Sets the IP address (IPv4 or IPv6) of the client that issued the HTTP request. Examples:
     * {@code 192.168.1.1}, {@code FE80::0202:B3FF:FE1E:8329}.
     */
    @CanIgnoreReturnValue
    public Builder setRemoteIp(String remoteIp) {
      this.requestBuilder.setRemoteIp(remoteIp);
      return this;
    }

    /**
     * Sets the IP address (IPv4 or IPv6) of the origin server that the request was sent to.
     * Examples: {@code 192.168.1.1}, {@code FE80::0202:B3FF:FE1E:8329}.
     */
    @CanIgnoreReturnValue
    public Builder setServerIp(String serverIp) {
      this.requestBuilder.setServerIp(serverIp);
      return this;
    }

    /** Sets the string as a trace id value. */
    @CanIgnoreReturnValue
    public Builder setTraceId(String traceId) {
      this.traceId = traceId;
      return this;
    }

    /** Sets the string as a span id value. */
    @CanIgnoreReturnValue
    public Builder setSpanId(String spanId) {
      this.spanId = spanId;
      return this;
    }

    /** Sets the boolean as trace sampled flag. */
    @CanIgnoreReturnValue
    public Builder setTraceSampled(boolean traceSampled) {
      this.traceSampled = traceSampled;
      return this;
    }

    /**
     * Sets the trace id, span id and trace sampled flag values by parsing the string which
     * represents xCloud Trace Context. The Cloud Trace Context is passed as {@code
     * x-cloud-trace-context} header (can be in Pascal case format). The string format is <code>
     * TRACE_ID/SPAN_ID;o=TRACE_TRUE</code>.
     *
     * @see <a href="https://cloud.google.com/trace/docs/setup#force-trace">Cloud Trace header
     *     format.</a>
     */
    @CanIgnoreReturnValue
    public Builder loadCloudTraceContext(String cloudTrace) {
      if (cloudTrace != null) {
        if (cloudTrace.indexOf("o=") >= 0) {
          setTraceSampled(Iterables.get(Splitter.on("o=").split(cloudTrace), 1).equals("1"));
        }
        cloudTrace = Iterables.get(Splitter.on(';').split(cloudTrace), 0);
        int split = cloudTrace.indexOf('/');
        if (split >= 0) {
          String traceId = cloudTrace.substring(0, split);
          String spanId = cloudTrace.substring(split + 1);
          if (!traceId.isEmpty()) {
            setTraceId(traceId);
            // do not set span Id without trace Id
            if (!spanId.isEmpty()) {
              setSpanId(spanId);
            }
          }
        } else if (!cloudTrace.isEmpty()) {
          setTraceId(cloudTrace);
        }
      }
      return this;
    }

    /**
     * Sets the trace id, span id and trace sampled flag values by parsing the string which
     * represents the standard W3C trace context propagation header. The context propagation header
     * is passed as {@code traceparent} header. The method currently supports ONLY version {@code
     * "00"}. The string format is <code>00-TRACE_ID-SPAN_ID-FLAGS</code>. field of the {@code
     * version-format} value.
     *
     * @see <a href=
     *     "https://www.w3.org/TR/trace-context/#traceparent-header-field-values">traceparent header
     *     value format</a>
     * @throws IllegalArgumentException if passed argument does not follow the @W3C trace format or
     *     the format version is not supported.
     */
    @CanIgnoreReturnValue
    public Builder loadW3CTraceParentContext(String traceParent) {
      if (traceParent != null) {
        Matcher validator = W3C_TRACE_CONTEXT_FORMAT.matcher(Ascii.toLowerCase(traceParent));
        if (!validator.matches()) {
          throw new IllegalArgumentException(
              "Invalid format of the header value. The value does not match W3C Trace Context version \"00\"");
        }
        List<String> fields = Splitter.on('-').splitToList(traceParent);
        setTraceId(fields.get(1));
        setSpanId(fields.get(2));
        boolean sampled = (Integer.parseInt(fields.get(3), 16) & FLAG_SAMPLED) == FLAG_SAMPLED;
        setTraceSampled(sampled);
      }
      return this;
    }

    /**
     * Sets the trace id, span id and trace sampled flag values by parsing detected OpenTelemetry
     * span context.
     *
     * @see <a href="https://opentelemetry.io/docs/specs/otel/trace/api/#spancontext">OpenTelemetry
     *     SpanContext.</a>
     */
    @CanIgnoreReturnValue
    public Builder loadOpenTelemetryContext() {
      io.opentelemetry.context.Context currentContext = io.opentelemetry.context.Context.current();
      SpanContext spanContext = Span.fromContext(currentContext).getSpanContext();
      if (spanContext != null && spanContext.isValid()) {
        setTraceId(spanContext.getTraceId());
        setSpanId(spanContext.getSpanId());
        setTraceSampled(spanContext.isSampled());
      }
      return this;
    }

    /** Creates a {@see Context} object for this builder. */
    public Context build() {
      return new Context(this);
    }
  }

  Context(Builder builder) {
    HttpRequest request = builder.requestBuilder.build();
    if (!HttpRequest.EMPTY.equals(request)) {
      this.request = request;
    } else {
      this.request = null;
    }
    this.traceId = builder.traceId;
    this.spanId = builder.spanId;
    this.traceSampled = builder.traceSampled;
  }

  public HttpRequest getHttpRequest() {
    return this.request;
  }

  public String getTraceId() {
    return this.traceId;
  }

  public String getSpanId() {
    return this.spanId;
  }

  public boolean getTraceSampled() {
    return this.traceSampled;
  }

  @Override
  public int hashCode() {
    return Objects.hash(request, traceId, spanId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("request", request)
        .add("traceId", traceId)
        .add("spanId", spanId)
        .add("traceSampled", traceSampled)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Context)) {
      return false;
    }
    Context other = (Context) obj;
    return Objects.equals(request, other.request)
        && Objects.equals(traceId, other.traceId)
        && Objects.equals(spanId, other.spanId)
        && Objects.equals(traceSampled, other.traceSampled);
  }

  /** Returns a builder for this object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Returns a builder for {@code HttpRequest} objects. */
  public static Builder newBuilder() {
    return new Builder();
  }
}
