/* Copyright 2019 Google Inc.
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

package com.google.cloud.pubsub.v1;

import com.google.api.core.ApiFunction;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.MustBeClosed;
import com.google.pubsub.v1.PubsubMessage;
import io.opencensus.common.Scope;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.Tagger;
import io.opencensus.tags.Tags;
import io.opencensus.tags.propagation.TagContextBinarySerializer;
import io.opencensus.trace.Link;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import io.opencensus.trace.propagation.SpanContextParseException;
import io.opencensus.trace.propagation.TextFormat;
import io.opencensus.trace.propagation.TextFormat.Getter;
import io.opencensus.trace.propagation.TextFormat.Setter;
import io.opencensus.trace.samplers.Samplers;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utilities for propagating OpenCensus {@link TagContext} and {@link SpanContext} from publishers
 * to subscribers.
 */
public class OpenCensusUtil {
  private static final Logger logger = Logger.getLogger(OpenCensusUtil.class.getName());

  public static final String TAG_CONTEXT_KEY = "googclient_OpenCensusTagContextKey";
  public static final String TRACE_CONTEXT_KEY = "googclient_OpenCensusTraceContextKey";
  @VisibleForTesting static final String MESSAGE_RECEIVER_SPAN_NAME = "OpenCensusMessageReceiver";
  private static final String TRACEPARENT_KEY = "traceparent";

  private static final Tagger tagger = Tags.getTagger();
  private static final TagContextBinarySerializer serializer =
      Tags.getTagPropagationComponent().getBinarySerializer();

  private static final Tracer tracer = Tracing.getTracer();
  private static final TextFormat traceContextTextFormat =
      Tracing.getPropagationComponent().getTraceContextFormat();

  /**
   * Propagates active OpenCensus trace and tag contexts from the Publisher by adding them as
   * attributes to the {@link PubsubMessage}.
   */
  public static final ApiFunction<PubsubMessage, PubsubMessage> OPEN_CENSUS_MESSAGE_TRANSFORM =
      new ApiFunction<PubsubMessage, PubsubMessage>() {
        @Override
        public PubsubMessage apply(PubsubMessage message) {
          PubsubMessage.Builder builder = PubsubMessage.newBuilder(message);
          String encodedSpanContext = encodeSpanContext(tracer.getCurrentSpan().getContext());
          String encodedTagContext = encodeTagContext(tagger.getCurrentTagContext());
          if (encodedSpanContext.isEmpty() && encodedTagContext.isEmpty()) {
            return message;
          }
          if (!encodedSpanContext.isEmpty()) {
            builder.putAttributes(TRACE_CONTEXT_KEY, encodedSpanContext);
          }
          if (!encodedTagContext.isEmpty()) {
            builder.putAttributes(TAG_CONTEXT_KEY, encodedTagContext);
          }
          return builder.build();
        }
      };

  private static final Setter<StringBuilder> setter =
      new Setter<StringBuilder>() {
        @Override
        public void put(StringBuilder carrier, String key, String value) {
          if (key.equals(TRACEPARENT_KEY)) {
            carrier.append(value);
          }
        }
      };

  private static final Getter<String> getter =
      new Getter<String>() {
        @Override
        public String get(String carrier, String key) {
          return key.equals(TRACEPARENT_KEY) ? carrier : null;
        }
      };

  @VisibleForTesting
  static String encodeSpanContext(SpanContext ctxt) {
    StringBuilder builder = new StringBuilder();
    traceContextTextFormat.inject(ctxt, builder, setter);
    return builder.toString();
  }

  // TODO: update this code once the text encoding of tags has been resolved
  // (https://github.com/census-instrumentation/opencensus-specs/issues/65).
  private static String encodeTagContext(TagContext tags) {
    return "";
  }

  // TODO: update this code once the text encoding of tags has been resolved
  // (https://github.com/census-instrumentation/opencensus-specs/issues/65).
  private static Scope createScopedTagContext(String encodedTags) {
    return tagger.withTagContext(tagger.getCurrentTagContext());
  }

  @VisibleForTesting
  @MustBeClosed
  static Scope createScopedSpan(String name) {
    return tracer
        .spanBuilderWithExplicitParent(name, tracer.getCurrentSpan())
        .setRecordEvents(true)
        // Note: we preserve the sampling decision from the publisher.
        .setSampler(Samplers.alwaysSample())
        .startScopedSpan();
  }

  private static void addParentLink(String encodedParentSpanContext) {
    try {
      SpanContext ctxt = traceContextTextFormat.extract(encodedParentSpanContext, getter);
      tracer.getCurrentSpan().addLink(Link.fromSpanContext(ctxt, Link.Type.PARENT_LINKED_SPAN));
    } catch (SpanContextParseException exn) {
      logger.log(Level.INFO, "OpenCensus: Trace Context Deserialization Exception: " + exn);
    }
  }

  /**
   * Wrapper class for {@link MessageReceiver} that decodes any received trace and tag contexts and
   * puts them in scope.
   */
  public static class OpenCensusMessageReceiver implements MessageReceiver {
    private final MessageReceiver receiver;

    public OpenCensusMessageReceiver(MessageReceiver receiver) {
      this.receiver = receiver;
    }

    @Override
    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
      String encodedTagContext = message.getAttributesOrDefault(TAG_CONTEXT_KEY, "");
      if (encodedTagContext.isEmpty()) {
        addTraceScope(message, consumer);
        return;
      }
      try (Scope statsScope = createScopedTagContext(encodedTagContext)) {
        addTraceScope(message, consumer);
      }
    }

    private void addTraceScope(PubsubMessage message, AckReplyConsumer consumer) {
      String encodedSpanContext = message.getAttributesOrDefault(TRACE_CONTEXT_KEY, "");
      if (encodedSpanContext.isEmpty()) {
        receiver.receiveMessage(message, consumer);
        return;
      }
      try (Scope spanScope = createScopedSpan(MESSAGE_RECEIVER_SPAN_NAME)) {
        addParentLink(encodedSpanContext);
        receiver.receiveMessage(message, consumer);
      }
    }
  }
}
