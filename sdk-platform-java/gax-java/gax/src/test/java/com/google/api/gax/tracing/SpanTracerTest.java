/*
 * Copyright 2026 Google LLC
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
package com.google.api.gax.tracing;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Any;
import com.google.rpc.ErrorInfo;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SpanTracerTest {
  @Mock private Tracer tracer;
  @Mock private SpanBuilder spanBuilder;
  @Mock private Span span;
  private SpanTracer spanTracer;
  private static final String ATTEMPT_SPAN_NAME = "Service/Method/attempt";

  @BeforeEach
  void setUp() {
    when(tracer.spanBuilder(anyString())).thenReturn(spanBuilder);
    when(spanBuilder.setSpanKind(any(SpanKind.class))).thenReturn(spanBuilder);
    when(spanBuilder.setAllAttributes(any(Attributes.class))).thenReturn(spanBuilder);
    when(spanBuilder.startSpan()).thenReturn(span);
    spanTracer = new SpanTracer(tracer, ApiTracerContext.empty(), ATTEMPT_SPAN_NAME);
  }

  @Test
  void testAttemptLifecycle_startsAndEndsAttemptSpan() {
    spanTracer.attemptStarted(new Object(), 1);
    spanTracer.attemptSucceeded();

    verify(tracer).spanBuilder(ATTEMPT_SPAN_NAME);
    verify(spanBuilder).setSpanKind(SpanKind.CLIENT);
    verify(span).end();
  }

  @Test
  void testAttemptSucceeded_grpc() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(com.google.api.gax.rpc.LibraryMetadata.empty())
            .setTransport(ApiTracerContext.Transport.GRPC)
            .build();
    spanTracer = new SpanTracer(tracer, context, ATTEMPT_SPAN_NAME);

    spanTracer.attemptStarted(new Object(), 1);
    spanTracer.attemptSucceeded();

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    verify(span).end();

    assertThat(attrsCaptor.getValue().asMap())
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE), "OK");
  }

  @Test
  void testAttemptSucceeded_http() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(com.google.api.gax.rpc.LibraryMetadata.empty())
            .setTransport(ApiTracerContext.Transport.HTTP)
            .build();
    spanTracer = new SpanTracer(tracer, context, ATTEMPT_SPAN_NAME);

    spanTracer.attemptStarted(new Object(), 1);
    spanTracer.attemptSucceeded();

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    verify(span).end();

    assertThat(attrsCaptor.getValue().asMap())
        .containsEntry(
            AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE), 200L);
  }

  @Test
  void testResponseHeadersReceived_setsContentLengthAttribute() {
    spanTracer.attemptStarted(new Object(), 1);

    Map<String, Object> headers = new java.util.HashMap<>();
    headers.put("Content-Length", 12345L);
    spanTracer.responseHeadersReceived(headers);

    verify(span).setAttribute(ObservabilityAttributes.HTTP_RESPONSE_BODY_SIZE, 12345L);
  }

  @Test
  void testResponseHeadersReceived_variousContentLengthStringFormats() {
    spanTracer.attemptStarted(new Object(), 1);

    Map<String, Object> headers = new java.util.HashMap<>();
    headers.put("content-length", "6789");
    spanTracer.responseHeadersReceived(headers);

    verify(span).setAttribute(ObservabilityAttributes.HTTP_RESPONSE_BODY_SIZE, 6789L);
  }

  @Test
  void testResponseHeadersReceived_missingContentLength() {
    spanTracer.attemptStarted(new Object(), 1);

    Map<String, Object> headers = new java.util.HashMap<>();
    headers.put("Other-Header", "123");
    spanTracer.responseHeadersReceived(headers);

    verify(span, org.mockito.Mockito.never())
        .setAttribute(
            org.mockito.ArgumentMatchers.eq(ObservabilityAttributes.HTTP_RESPONSE_BODY_SIZE),
            org.mockito.ArgumentMatchers.anyLong());
  }

  @Test
  void testResponseHeadersReceived_badFormat() {
    spanTracer.attemptStarted(new Object(), 1);

    Map<String, Object> headers = new java.util.HashMap<>();
    headers.put("Content-Length", "12X3");
    spanTracer.responseHeadersReceived(headers);

    verify(span, org.mockito.Mockito.never())
        .setAttribute(
            org.mockito.ArgumentMatchers.eq(ObservabilityAttributes.HTTP_RESPONSE_BODY_SIZE),
            org.mockito.ArgumentMatchers.anyLong());
  }

  @Test
  void testResponseHeadersReceived_listContentLength() {
    spanTracer.attemptStarted(new Object(), 1);

    Map<String, Object> headers = new java.util.HashMap<>();
    headers.put("Content-Length", java.util.Arrays.asList(98765L));
    spanTracer.responseHeadersReceived(headers);

    verify(span).setAttribute(ObservabilityAttributes.HTTP_RESPONSE_BODY_SIZE, 98765L);
  }

  void testAttemptStarted_noRetryAttributes_grpc() {
    ApiTracerContext grpcContext =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(com.google.api.gax.rpc.LibraryMetadata.empty())
            .setTransport(ApiTracerContext.Transport.GRPC)
            .build();
    SpanTracer grpcTracer = new SpanTracer(tracer, grpcContext, ATTEMPT_SPAN_NAME);

    // Initial attempt, attemptNumber is 0
    grpcTracer.attemptStarted(new Object(), 0);
    ArgumentCaptor<Attributes> attributesCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(spanBuilder).setAllAttributes(attributesCaptor.capture());
    assertThat(attributesCaptor.getValue().asMap())
        .doesNotContainKey(
            AttributeKey.longKey(ObservabilityAttributes.GRPC_RESEND_COUNT_ATTRIBUTE));
    assertThat(attributesCaptor.getValue().asMap())
        .doesNotContainKey(
            AttributeKey.longKey(ObservabilityAttributes.HTTP_RESEND_COUNT_ATTRIBUTE));
  }

  @Test
  void testAttemptFailed_grpc() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(com.google.api.gax.rpc.LibraryMetadata.empty())
            .setTransport(ApiTracerContext.Transport.GRPC)
            .build();
    spanTracer = new SpanTracer(tracer, context, ATTEMPT_SPAN_NAME);

    com.google.api.gax.rpc.ApiException exception =
        new com.google.api.gax.rpc.ApiException(
            "error",
            null,
            new com.google.api.gax.rpc.StatusCode() {
              @Override
              public Code getCode() {
                return Code.NOT_FOUND;
              }

              @Override
              public Object getTransportCode() {
                return null;
              }
            },
            false);

    spanTracer.attemptStarted(new Object(), 1);
    spanTracer.attemptFailedRetriesExhausted(exception);

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    verify(span).end();

    assertThat(attrsCaptor.getValue().asMap())
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE),
            "NOT_FOUND");
  }

  @Test
  void testAttemptStarted_retryAttributes_grpc() {
    ApiTracerContext grpcContext =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(com.google.api.gax.rpc.LibraryMetadata.empty())
            .setTransport(ApiTracerContext.Transport.GRPC)
            .build();
    SpanTracer grpcTracer = new SpanTracer(tracer, grpcContext, ATTEMPT_SPAN_NAME);

    // N-th retry, attemptNumber is 5
    grpcTracer.attemptStarted(new Object(), 5);
    ArgumentCaptor<Attributes> attributesCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(spanBuilder).setAllAttributes(attributesCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attributesCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.longKey(ObservabilityAttributes.GRPC_RESEND_COUNT_ATTRIBUTE), 5L);
    assertThat(capturedAttributes)
        .doesNotContainKey(
            AttributeKey.longKey(ObservabilityAttributes.HTTP_RESEND_COUNT_ATTRIBUTE));
  }

  @Test
  void testAttemptFailed_http() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(com.google.api.gax.rpc.LibraryMetadata.empty())
            .setTransport(ApiTracerContext.Transport.HTTP)
            .build();
    spanTracer = new SpanTracer(tracer, context, ATTEMPT_SPAN_NAME);

    com.google.api.gax.rpc.ApiException exception =
        new com.google.api.gax.rpc.ApiException(
            "error",
            null,
            new com.google.api.gax.rpc.StatusCode() {
              @Override
              public Code getCode() {
                return Code.NOT_FOUND;
              }

              @Override
              public Object getTransportCode() {
                return 404;
              }
            },
            false);

    spanTracer.attemptStarted(new Object(), 1);
    spanTracer.attemptFailedRetriesExhausted(exception);

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    verify(span).end();

    assertThat(attrsCaptor.getValue().asMap())
        .containsEntry(
            AttributeKey.longKey(ObservabilityAttributes.HTTP_RESPONSE_STATUS_ATTRIBUTE), 404L);
  }

  @Test
  void testAttemptStarted_noRetryAttributes_http() {
    ApiTracerContext httpContext =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(com.google.api.gax.rpc.LibraryMetadata.empty())
            .setTransport(ApiTracerContext.Transport.HTTP)
            .build();
    SpanTracer httpTracer = new SpanTracer(tracer, httpContext, ATTEMPT_SPAN_NAME);

    // Initial attempt, attemptNumber is 0
    httpTracer.attemptStarted(new Object(), 0);
    ArgumentCaptor<Attributes> attributesCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(spanBuilder).setAllAttributes(attributesCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attributesCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .doesNotContainKey(
            AttributeKey.longKey(ObservabilityAttributes.GRPC_RESEND_COUNT_ATTRIBUTE));
    assertThat(capturedAttributes)
        .doesNotContainKey(
            AttributeKey.longKey(ObservabilityAttributes.HTTP_RESEND_COUNT_ATTRIBUTE));
  }

  @Test
  void testAttemptStarted_retryAttributes_http() {
    ApiTracerContext httpContext =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(com.google.api.gax.rpc.LibraryMetadata.empty())
            .setTransport(ApiTracerContext.Transport.HTTP)
            .build();
    SpanTracer httpTracer = new SpanTracer(tracer, httpContext, ATTEMPT_SPAN_NAME);

    // N-th retry, attemptNumber is 5
    httpTracer.attemptStarted(new Object(), 5);
    ArgumentCaptor<Attributes> attributesCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(spanBuilder).setAllAttributes(attributesCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attributesCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .doesNotContainKey(
            AttributeKey.longKey(ObservabilityAttributes.GRPC_RESEND_COUNT_ATTRIBUTE));
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.longKey(ObservabilityAttributes.HTTP_RESEND_COUNT_ATTRIBUTE), 5L);
  }

  @Test
  void testAttemptFailed_errorInfoReason() {
    spanTracer.attemptStarted(new Object(), 1);

    ErrorInfo errorInfo = ErrorInfo.newBuilder().setReason("RATE_LIMIT_EXCEEDED").build();
    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(ImmutableList.of(Any.pack(errorInfo))).build();
    Throwable cause = new Throwable("message");

    ApiException apiException =
        new ApiException(
            cause,
            new StatusCode() {
              @Override
              public Code getCode() {
                return Code.UNAVAILABLE;
              }

              @Override
              public Object getTransportCode() {
                return null;
              }
            },
            true,
            errorDetails);

    spanTracer.attemptFailedRetriesExhausted(apiException);

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE),
            "RATE_LIMIT_EXCEEDED");

    verify(span).end();
  }

  @Test
  void testAttemptFailed_specificServerErrorCodeGrpc() {
    spanTracer.attemptStarted(new Object(), 1);

    ApiException apiException =
        new ApiException(
            "message",
            null,
            new StatusCode() {
              @Override
              public Code getCode() {
                return Code.PERMISSION_DENIED;
              }

              @Override
              public Object getTransportCode() {
                return "PERMISSION_DENIED";
              }
            },
            true);

    spanTracer.attemptFailedRetriesExhausted(apiException);

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE),
            "PERMISSION_DENIED");

    verify(span).end();
  }

  @Test
  void testAttemptFailed_specificServerErrorCodeHttp() {
    ApiTracerContext context =
        ApiTracerContext.newBuilder()
            .setLibraryMetadata(com.google.api.gax.rpc.LibraryMetadata.empty())
            .setTransport(ApiTracerContext.Transport.HTTP)
            .build();
    spanTracer = new SpanTracer(tracer, context, ATTEMPT_SPAN_NAME);

    spanTracer.attemptStarted(new Object(), 1);

    ApiException apiException =
        new ApiException(
            "message",
            null,
            new StatusCode() {
              @Override
              public Code getCode() {
                return Code.PERMISSION_DENIED;
              }

              @Override
              public Object getTransportCode() {
                return 403;
              }
            },
            true);

    spanTracer.attemptFailedRetriesExhausted(apiException);

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE), "403");

    verify(span).end();
  }

  @Test
  void testAttemptFailed_clientTimeout() {
    spanTracer.attemptStarted(new Object(), 1);

    spanTracer.attemptFailedRetriesExhausted(new SocketTimeoutException());

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE),
            ErrorTypeUtil.ErrorType.CLIENT_TIMEOUT.toString());

    verify(span).end();
  }

  @Test
  void testAttemptFailed_clientConnectionError() {
    spanTracer.attemptStarted(new Object(), 1);

    spanTracer.attemptFailedRetriesExhausted(new ConnectException("connection failed"));

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE),
            ErrorTypeUtil.ErrorType.CLIENT_CONNECTION_ERROR.toString());

    verify(span).end();
  }

  @Test
  void testAttemptFailed_clientRedirectError() {
    spanTracer.attemptStarted(new Object(), 1);

    spanTracer.attemptFailedRetriesExhausted(new RedirectException("redirect failed"));

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE),
            "RedirectException");
    verify(span).end();
  }

  @Test
  void testAttemptFailed_clientRequestError() {
    spanTracer.attemptStarted(new Object(), 1);

    spanTracer.attemptFailedRetriesExhausted(new IllegalArgumentException());

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE),
            ErrorTypeUtil.ErrorType.CLIENT_REQUEST_ERROR.toString());
    verify(span).end();
  }

  @Test
  void testAttemptFailed_clientUnknownError() {
    spanTracer.attemptStarted(new Object(), 1);

    spanTracer.attemptFailedRetriesExhausted(new UnknownClientException());

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE),
            "UnknownClientException");
    verify(span).end();
  }

  @Test
  void testAttemptFailed_languageSpecificFallback() {
    spanTracer.attemptStarted(new Object(), 1);

    spanTracer.attemptFailedRetriesExhausted(new IllegalStateException("illegal state"));

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE),
            "IllegalStateException");
    verify(span).end();
  }

  @Test
  void testAttemptFailed_internalFallback() {
    spanTracer.attemptStarted(new Object(), 1);

    spanTracer.attemptFailedRetriesExhausted(new Throwable() {});

    // For an anonymous inner class Throwable, getSimpleName() is empty string,
    // which triggers the
    // fallback
    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE),
            ErrorTypeUtil.ErrorType.INTERNAL.toString());
    verify(span).end();
  }

  @Test
  void testAttemptFailed_internalFallback_nullError() {
    spanTracer.attemptStarted(new Object(), 1);

    spanTracer.attemptFailedRetriesExhausted(null);

    // For an anonymous inner class Throwable, getSimpleName() is empty string,
    // which triggers the
    // fallback
    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .doesNotContainKey(AttributeKey.stringKey(ObservabilityAttributes.ERROR_TYPE_ATTRIBUTE));
    verify(span).end();
  }

  @Test
  void testAttemptFailed_populatesExceptionTypeAndMessage() {
    spanTracer.attemptStarted(new Object(), 1);

    spanTracer.attemptFailedRetriesExhausted(new IllegalStateException("custom error message"));

    ArgumentCaptor<Attributes> attrsCaptor = ArgumentCaptor.forClass(Attributes.class);
    verify(span).setAllAttributes(attrsCaptor.capture());
    Map<AttributeKey<?>, Object> capturedAttributes = attrsCaptor.getValue().asMap();
    assertThat(capturedAttributes)
        .containsEntry(
            AttributeKey.stringKey(ObservabilityAttributes.EXCEPTION_TYPE_ATTRIBUTE),
            "java.lang.IllegalStateException");
    verify(span)
        .setAttribute(ObservabilityAttributes.STATUS_MESSAGE_ATTRIBUTE, "custom error message");
    verify(span).end();
  }

  @Test
  void testRequestUrlResolved_setsAttribute() {
    spanTracer.attemptStarted(new Object(), 1);

    String rawUrl = "https://example.com?api_key=secret";
    spanTracer.requestUrlResolved(rawUrl);

    verify(span)
        .setAttribute(
            ObservabilityAttributes.HTTP_URL_FULL_ATTRIBUTE,
            "https://example.com?api_key=REDACTED");
  }

  @Test
  void testRequestUrlResolved_badUrl_notSet() {
    spanTracer.attemptStarted(new Object(), 1);

    String rawUrl = "htps:::://the-example";
    spanTracer.requestUrlResolved(rawUrl);

    verify(span, never())
        .setAttribute(eq(ObservabilityAttributes.HTTP_URL_FULL_ATTRIBUTE), anyString());
  }

  private static class RedirectException extends RuntimeException {
    public RedirectException(String message) {
      super(message);
    }
  }

  private static class UnknownClientException extends RuntimeException {}

  @Test
  void testInjectTraceContext_addsHeaders() {
    io.opentelemetry.api.trace.SpanContext mockSpanContext =
        io.opentelemetry.api.trace.SpanContext.create(
            "00000000000000000000000000000001",
            "0000000000000002",
            io.opentelemetry.api.trace.TraceFlags.getSampled(),
            io.opentelemetry.api.trace.TraceState.getDefault());
    io.opentelemetry.api.trace.Span realSpan =
        io.opentelemetry.api.trace.Span.wrap(mockSpanContext);
    when(spanBuilder.startSpan()).thenReturn(realSpan);

    spanTracer = new SpanTracer(tracer, ApiTracerContext.empty(), ATTEMPT_SPAN_NAME);
    spanTracer.attemptStarted(new Object(), 1);

    Map<String, String> carrier = new java.util.HashMap<>();
    spanTracer.injectTraceContext(carrier);

    assertThat(carrier).containsKey("traceparent");
    assertThat(carrier.get("traceparent")).contains("00000000000000000000000000000001");
    assertThat(carrier.get("traceparent")).contains("0000000000000002");
  }
}
