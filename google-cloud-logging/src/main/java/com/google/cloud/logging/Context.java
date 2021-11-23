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
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import java.util.Objects;

/** Class to hold context attributes including information about {@see HttpRequest} and tracing. */
public class Context {
  private final HttpRequest request;
  private final String traceId;
  private final String spanId;

  /** A builder for {@see Context} objects. */
  public static final class Builder {
    private HttpRequest.Builder requestBuilder = HttpRequest.newBuilder();
    private String traceId;
    private String spanId;

    Builder() {}

    Builder(Context context) {
      this.requestBuilder = context.request.toBuilder();
      this.traceId = context.traceId;
      this.spanId = context.spanId;
    }

    /** Sets the HTTP request. */
    public Builder setRequest(HttpRequest request) {
      this.requestBuilder = request.toBuilder();
      return this;
    }

    public Builder setRequestUrl(String url) {
      this.requestBuilder.setRequestUrl(url);
      return this;
    }

    /** Sets the HTTP request method. */
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
    public Builder setReferer(String referer) {
      this.requestBuilder.setReferer(referer);
      return this;
    }

    /**
     * Sets the IP address (IPv4 or IPv6) of the client that issued the HTTP request. Examples:
     * {@code 192.168.1.1}, {@code FE80::0202:B3FF:FE1E:8329}.
     */
    public Builder setRemoteIp(String remoteIp) {
      this.requestBuilder.setRemoteIp(remoteIp);
      return this;
    }

    /**
     * Sets the IP address (IPv4 or IPv6) of the origin server that the request was sent to.
     * Examples: {@code 192.168.1.1}, {@code FE80::0202:B3FF:FE1E:8329}.
     */
    public Builder setServerIp(String serverIp) {
      this.requestBuilder.setServerIp(serverIp);
      return this;
    }

    /** Sets the string as a trace id value. */
    public Builder setTraceId(String traceId) {
      this.traceId = traceId;
      return this;
    }

    /** Sets the string as a span id value. */
    public Builder setSpanId(String spanId) {
      this.spanId = spanId;
      return this;
    }

    /**
     * Sets the trace id and span id values by parsing the string which represents xCloud Trace
     * Context. The Cloud Trace Context is passed as {@code x-cloud-trace-context} header (can be in
     * Pascal case format). The string format is <code>TRACE_ID/SPAN_ID;o=TRACE_TRUE</code>.
     *
     * @see <a href="https://cloud.google.com/trace/docs/setup#force-trace">Cloud Trace header
     *     format.</a>
     */
    public Builder loadCloudTraceContext(String cloudTrace) {
      if (cloudTrace != null) {
        cloudTrace = cloudTrace.split(";")[0];
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
     * Sets the trace id and span id values by parsing the string which represents the standard W3C
     * trace context propagation header. The context propagation header is passed as {@code
     * traceparent} header. The method currently supports ONLY version {@code "00"}. The string
     * format is <code>00-TRACE_ID-SPAN_ID-FLAGS</code>. field of the {@code version-format} value.
     *
     * @see <a href=
     *     "https://www.w3.org/TR/trace-context/#traceparent-header-field-values">traceparent header
     *     value format</a>
     * @throws IllegalArgumentException if passed argument does not follow the @W3C trace format or
     *     the format version is not supported.
     */
    public Builder loadW3CTraceParentContext(String traceParent) throws IllegalArgumentException {
      if (traceParent != null) {
        String[] fields = traceParent.split("-");
        if (fields.length > 3) {
          String versionFormat = fields[0];
          if (!versionFormat.equals("00")) {
            throw new IllegalArgumentException("Not supporting versionFormat other than \"00\"");
          }
        } else {
          throw new IllegalArgumentException(
              "Invalid format of the header value. Expected \"00-traceid-spanid-arguments\"");
        }
        String traceId = fields[1];
        if (!traceId.isEmpty()) {
          setTraceId(traceId);
        }
        if (!Strings.isNullOrEmpty(traceId)) {
          String spanId = fields[2];
          if (!spanId.isEmpty()) {
            setSpanId(spanId);
          }
        }
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
        && Objects.equals(spanId, other.spanId);
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
