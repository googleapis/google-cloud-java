/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.pubsub.v1.OpenCensusUtil.MESSAGE_RECEIVER_SPAN_NAME;
import static com.google.cloud.pubsub.v1.OpenCensusUtil.OPEN_CENSUS_MESSAGE_TRANSFORM;
import static com.google.cloud.pubsub.v1.OpenCensusUtil.TAG_CONTEXT_KEY;
import static com.google.cloud.pubsub.v1.OpenCensusUtil.TRACE_CONTEXT_KEY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import com.google.common.base.Stopwatch;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import io.opencensus.common.Scope;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import io.opencensus.tags.Tags;
import io.opencensus.trace.Link;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import io.opencensus.trace.export.RunningSpanStore;
import io.opencensus.trace.export.RunningSpanStore.Filter;
import io.opencensus.trace.export.SpanData;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/** Tests for {@link OpenCensusUtil}. */
public class OpenCensusUtilTest {
  private static final Tagger tagger = Tags.getTagger();
  private static final Tracer tracer = Tracing.getTracer();
  private static final TagKey TEST_TAG_KEY = TagKey.create("TEST_TAG_KEY");
  private static final TagValue TEST_TAG_VAL = TagValue.create("TEST_TAG_VAL");
  private static final String TEST_PARENT_LINK_NAME = "TEST_PARENT_LINK";

  // Verifies that trace contexts propagated as an attribute are set as the parent link in the
  // message receiver and that the tag context is not change (for now).
  @Test
  public void testOpenCensusMessageReceiver() {
    PubsubMessage message;
    SpanContext publisherContext;
    try (Scope traceScope = OpenCensusUtil.createScopedSpan(TEST_PARENT_LINK_NAME);
        Scope tagScope = createScopeTags()) {
      message = OPEN_CENSUS_MESSAGE_TRANSFORM.apply(generatePubsubMessage(500));
      publisherContext = tracer.getCurrentSpan().getContext();
    }
    MessageReceiver receiver =
        new OpenCensusUtil.OpenCensusMessageReceiver(
            new TestMessageReceiver(publisherContext, tagger.getCurrentTagContext()));
    receiver.receiveMessage(message, new NoOpAckReplyConsumer());
  }

  // Verifies that the current span context is added as an attribute and that (for now) the tag
  // context is not added as an attribute.
  @Test
  public void testOpenCensusMessageTransformer() {
    try (Scope traceScope = OpenCensusUtil.createScopedSpan("PublisherTestRoot");
        Scope tagScope = createScopeTags()) {
      PubsubMessage originalMessage = generatePubsubMessage(500);
      assertEquals("", originalMessage.getAttributesOrDefault(TRACE_CONTEXT_KEY, ""));
      assertEquals("", originalMessage.getAttributesOrDefault(TAG_CONTEXT_KEY, ""));

      PubsubMessage attributedMessage = OPEN_CENSUS_MESSAGE_TRANSFORM.apply(originalMessage);
      String encodedSpanContext =
          OpenCensusUtil.encodeSpanContext(tracer.getCurrentSpan().getContext());
      assertNotEquals("", encodedSpanContext);
      assertEquals(
          encodedSpanContext, attributedMessage.getAttributesOrDefault(TRACE_CONTEXT_KEY, ""));
      assertEquals("", attributedMessage.getAttributesOrDefault(TAG_CONTEXT_KEY, ""));
    }
  }

  private static PubsubMessage generatePubsubMessage(int size) {
    byte[] bytes = new byte[size];
    for (int i = 0; i < size; i++) {
      bytes[i] = (byte) (120 + i % 20);
    }
    return PubsubMessage.newBuilder().setData(ByteString.copyFrom(bytes)).build();
  }

  private static Scope createScopeTags() {
    return tagger.currentBuilder().put(TEST_TAG_KEY, TEST_TAG_VAL).buildScoped();
  }

  private static final class NoOpAckReplyConsumer implements AckReplyConsumer {
    @Override
    public void ack() {}

    @Override
    public void nack() {}
  }

  private static final class TestMessageReceiver implements MessageReceiver {
    private static final RunningSpanStore runningSpanStore =
        Tracing.getExportComponent().getRunningSpanStore();
    private static final Filter RECEIVER_FILTER = Filter.create(MESSAGE_RECEIVER_SPAN_NAME, 0);

    SpanContext parentLinkedSpan;
    TagContext originalTagContext;

    private TestMessageReceiver(SpanContext parentLinkedSpan, TagContext originalTagContext) {
      this.parentLinkedSpan = parentLinkedSpan;
      this.originalTagContext = originalTagContext;
    }

    @Override
    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
      assertEquals(originalTagContext, tagger.getCurrentTagContext());
      assertSpanCount(1);
      Collection<SpanData> spanDatas = runningSpanStore.getRunningSpans(RECEIVER_FILTER);
      for (SpanData spanData : spanDatas) {
        List<Link> links = spanData.getLinks().getLinks();
        assertEquals(links.size(), 1);
        Link link = links.get(0);
        assertEquals(Link.Type.PARENT_LINKED_SPAN, link.getType());
        assertEquals(parentLinkedSpan.getTraceId(), link.getTraceId());
        assertEquals(parentLinkedSpan.getSpanId(), link.getSpanId());
      }
      consumer.ack();
    }

    private void assertSpanCount(int expected) {
      Stopwatch watch = Stopwatch.createStarted();
      while (true) {
        Collection<SpanData> spanDatas = runningSpanStore.getRunningSpans(RECEIVER_FILTER);
        if (spanDatas.size() == expected) {
          break;
        }
        Thread.yield();
        if (watch.elapsed(TimeUnit.SECONDS) >= 5) {
          fail();
        }
      }
    }
  }
}
