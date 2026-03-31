/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.storage.BidiUploadTestUtils.incremental;
import static com.google.cloud.storage.StorageV2ProtoUtils.fmtProto;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.fail;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.BidiUploadState.AppendableUploadState;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Message;
import com.google.storage.v2.AppendObjectSpec;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.Object;
import com.google.storage.v2.WriteObjectSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.Tuple;
import net.jqwik.api.providers.TypeUsage;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class BidiUploadStreamingStreamPropertyTest {

  @Example
  public void edgeCases() {
    JqwikTest.report(
        TypeUsage.of(ScenarioWithLastWrittenRequest.class),
        arbitrarySendViaScenarioWithLastWrittenRequest());
  }

  @Example
  public void sendViaShouldCompactWithLastWrittenRequest_s1() {

    ScenarioWithLastWrittenRequest scenario =
        makeScenario(
            /* lastSentRequest= */ 0,
            /* beginOffset= */ 0L,
            BidiUploadTest.appendRequestNew,
            ImmutableList.of(ChecksummedTestContent.gen(1).asChecksummedData()),
            BidiUploadTestUtils.finishAt(0));
    sendViaShouldCompactWithLastWrittenRequest(scenario);
  }

  @Example
  public void sendViaShouldCompactWithLastWrittenRequest_s2() {
    ScenarioWithLastWrittenRequest scenario =
        makeScenario(
            /* lastSentRequest= */ 2,
            /* beginOffset= */ 0L,
            BidiUploadTest.appendRequestNew,
            ImmutableList.of(
                ChecksummedTestContent.gen(1).asChecksummedData(),
                ChecksummedTestContent.gen(1).asChecksummedData()),
            BidiUploadTestUtils.finishAt(2));
    sendViaShouldCompactWithLastWrittenRequest(scenario);
  }

  @Example
  public void sendViaShouldCompactWithLastWrittenRequest_s3() {
    ScenarioWithLastWrittenRequest scenario =
        makeScenario(
            /* lastSentRequest= */ 0,
            /* beginOffset= */ 1L,
            BidiUploadTest.appendRequestNew,
            ImmutableList.of(
                ChecksummedTestContent.gen(1).asChecksummedData(),
                ChecksummedTestContent.gen(1).asChecksummedData(),
                ChecksummedTestContent.gen(1).asChecksummedData()),
            BidiUploadTestUtils.finishAt(4));
    sendViaShouldCompactWithLastWrittenRequest(scenario);
  }

  @Example
  public void sendViaShouldCompactWithLastWrittenRequest_s4() {
    ScenarioWithLastWrittenRequest scenario =
        new ScenarioWithLastWrittenRequest(
            /* lastSentRequest= */ -1,
            /* beginOffset= */ 10L,
            BidiUploadTest.appendRequestNew,
            ImmutableList.of(
                BidiWriteObjectRequest.newBuilder()
                    .setWriteOffset(10)
                    .setFlush(true)
                    .setStateLookup(true)
                    .build(),
                ChecksummedTestContent.gen(1).asBidiWrite().setWriteOffset(10).build(),
                ChecksummedTestContent.gen(1).asBidiWrite().setWriteOffset(11).build(),
                BidiUploadTestUtils.finishAt(12)));

    sendViaShouldCompactWithLastWrittenRequest(scenario);
  }

  @Example
  public void sendViaShouldCompactWithLastWrittenRequest_s5() {
    ScenarioWithLastWrittenRequest scenario =
        new ScenarioWithLastWrittenRequest(
            /* lastSentRequest= */ -1,
            /* beginOffset= */ 0,
            BidiUploadTest.appendRequestNew,
            ImmutableList.of(
                BidiUploadTest.appendRequestNew,
                ChecksummedTestContent.gen(1).asBidiWrite().setWriteOffset(0).build(),
                ChecksummedTestContent.gen(1).asBidiWrite().setWriteOffset(1).build(),
                ChecksummedTestContent.gen(1).asBidiWrite().setWriteOffset(2).build(),
                BidiUploadTestUtils.finishAt(3)));

    sendViaShouldCompactWithLastWrittenRequest(scenario);
  }

  @Example
  public void sendViaShouldCompactWithLastWrittenRequest_s6() {
    ScenarioWithLastWrittenRequest scenario =
        new ScenarioWithLastWrittenRequest(
            /* lastSentRequest= */ -1,
            /* beginOffset= */ 1,
            BidiUploadTest.appendRequestNew,
            ImmutableList.of(
                BidiUploadTest.appendRequestNew,
                ChecksummedTestContent.gen(1).asBidiWrite().setWriteOffset(1).build(),
                ChecksummedTestContent.gen(1).asBidiWrite().setWriteOffset(2).build(),
                ChecksummedTestContent.gen(1).asBidiWrite().setWriteOffset(3).build(),
                ChecksummedTestContent.gen(1).asBidiWrite().setWriteOffset(4).build(),
                ChecksummedTestContent.gen(1).asBidiWrite().setWriteOffset(5).build(),
                BidiUploadTestUtils.finishAt(6)));

    sendViaShouldCompactWithLastWrittenRequest(scenario);
  }

  @Example
  public void makeScenario_4() {

    ScenarioWithLastWrittenRequest scenario =
        makeScenario(
            /* lastSentRequest= */ 1,
            /* beginOffset= */ 0L,
            BidiUploadTest.appendRequestNew,
            ImmutableList.of(ChecksummedTestContent.gen(1).asChecksummedData()),
            BidiUploadTestUtils.finishAt(1));
    sendViaShouldCompactWithLastWrittenRequest(scenario);
  }

  @Example
  public void makeScenario_5() {

    ScenarioWithLastWrittenRequest scenario =
        makeScenario(
            /* lastSentRequest= */ 0,
            /* beginOffset= */ 0L,
            BidiUploadTest.appendRequestNew,
            ImmutableList.of(
                ChecksummedTestContent.gen(1).asChecksummedData(),
                ChecksummedTestContent.gen(1).asChecksummedData()),
            BidiUploadTestUtils.finishAt(2));
    sendViaShouldCompactWithLastWrittenRequest(scenario);
  }

  @Example
  public void sendViaWithOnlyAFirstMessage_shouldSendCleanly() {
    AppendableUploadState state =
        BidiUploadState.appendableNew(
            BidiUploadTest.appendRequestNew,
            GrpcCallContext::createDefault,
            37,
            SettableApiFuture.create(),
            Crc32cValue.zero());
    state.updateStateFromResponse(incremental(0));
    assertThat(state.offer(BidiUploadTest.appendRequestNew)).isTrue();

    List<BidiWriteObjectRequest> expected = ImmutableList.of(BidiUploadTest.appendRequestNew);

    List<BidiWriteObjectRequest> actual = sinkToList(state);

    String actualS = fmt(actual);
    String expectedS = fmt(expected);

    assertThat(actualS).isEqualTo(expectedS);
  }

  @Property(tries = 1_000)
  public void sendViaShouldCompactWithLastWrittenRequest(
      @ForAll("sendViaScenarioWithLastWrittenRequest") ScenarioWithLastWrittenRequest s) {
    AppendableUploadState state = s.makeBidiUploadState();
    assertThat(state.onResponse(incremental(s.beginFromOffset))).isNull();
    for (BidiWriteObjectRequest m : s.messages) {
      assertThat(state.offer(m)).isTrue();
    }
    state.lastSentRequestIndex = s.lastSentRequestIndex;

    List<BidiWriteObjectRequest> actual = sinkToList(state);
    assertThat(state.lastSentRequestIndex).isEqualTo(s.messages.size() - 1);

    if (actual.isEmpty()) {
      assertThat(s.lastSentRequestIndex).isEqualTo(s.messages.size() - 1);
    }

    long writeOffset = getExpectedBeginOffset(s);
    assertSaneMessageSequence(actual, s.lastSentRequestIndex, writeOffset);
  }

  static List<BidiWriteObjectRequest> sinkToList(BidiUploadState state) {
    ImmutableList.Builder<BidiWriteObjectRequest> b = ImmutableList.builder();
    state.sendVia(b::add);
    return b.build();
  }

  private static long getExpectedBeginOffset(ScenarioWithLastWrittenRequest s) {
    long writeOffset = s.beginFromOffset;
    if (!s.messages.isEmpty()) {
      for (int i = s.messages.size() - 1; i > s.lastSentRequestIndex; i--) {
        BidiWriteObjectRequest msg = s.messages.get(i);
        if (msg.hasOneof(BidiUploadState.FIRST_MESSAGE_DESCRIPTOR)) {
          writeOffset = s.beginFromOffset;
        } else {
          writeOffset = msg.getWriteOffset();
        }
      }
    }
    return writeOffset;
  }

  private static void assertSaneMessageSequence(
      List<BidiWriteObjectRequest> actual, int lastWrittenRequest, long beginFromOffset) {
    String msg = "Actual message sequence: " + fmt(actual);
    if (!actual.isEmpty() && actual.get(0).hasOneof(BidiUploadState.FIRST_MESSAGE_DESCRIPTOR)) {
      assertWithMessage("Received an unexpected first_message " + msg)
          .that(lastWrittenRequest)
          .isEqualTo(-1);
    }

    long startOffset = beginFromOffset;
    for (int i = 0, actualSize = actual.size(), lastIdx = actualSize - 1; i < actualSize; i++) {
      BidiWriteObjectRequest req = actual.get(i);
      assertWithMessage("Non-contiguous message " + msg)
          .that(req.getWriteOffset())
          .isEqualTo(startOffset);
      if (req.getFinishWrite()) {
        assertWithMessage("finish_write: true not last " + msg).that(i).isEqualTo(lastIdx);
      }
      startOffset = req.getWriteOffset() + req.getChecksummedData().getContent().size();
    }
  }

  @Provide("sendViaScenarioWithLastWrittenRequest")
  Arbitrary<ScenarioWithLastWrittenRequest> arbitrarySendViaScenarioWithLastWrittenRequest() {
    return beginOffset()
        .flatMap(
            beginOffset ->
                Combinators.combine(
                        Arbitraries.just(beginOffset),
                        firstMessage(),
                        dataMessage(),
                        finishMessage())
                    .as(Tuple::of))
        .flatMap(
            t -> {
              Long beginOffset = t.get1();
              BidiWriteObjectRequest first = t.get2();
              List<@NonNull ChecksummedData> data = t.get3();
              BidiWriteObjectRequest finish = t.get4();

              int messageCount = data.size();
              if (first != null) {
                messageCount++;
              }
              if (finish != null) {
                messageCount++;
              }
              // maybe select one of our existing messages as the lastWrittenRequest
              return Arbitraries.integers()
                  .between(-1, messageCount - 1)
                  .map(lwr -> makeScenario(lwr, beginOffset, first, data, finish));
            });
  }

  private static @NonNull ScenarioWithLastWrittenRequest makeScenario(
      int lastSentRequest,
      Long beginOffset,
      BidiWriteObjectRequest first,
      List<ChecksummedData> cds,
      BidiWriteObjectRequest last) {
    long offset = beginOffset;
    List<BidiWriteObjectRequest> data = new ArrayList<>();
    data.add(first);
    for (ChecksummedData cd : cds) {
      data.add(
          BidiWriteObjectRequest.newBuilder()
              .setWriteOffset(offset)
              .setChecksummedData(cd)
              .build());
      offset += cd.getContent().size();
    }

    if (last != null) {
      BidiWriteObjectRequest lastWithOffset = last.toBuilder().setWriteOffset(offset).build();
      data.add(lastWithOffset);
    }

    return new ScenarioWithLastWrittenRequest(
        /* lastWrittenRequest= */ lastSentRequest, /* beginFromOffset= */ beginOffset, first, data);
  }

  Arbitrary<Long> beginOffset() {
    return Arbitraries.longs().between(0, 256 * 1024);
  }

  Arbitrary<@NonNull BidiWriteObjectRequest> firstMessage() {
    return Arbitraries.of(
        BidiWriteObjectRequest.newBuilder()
            .setWriteObjectSpec(
                WriteObjectSpec.newBuilder()
                    .setResource(
                        Object.newBuilder().setBucket("projects/_/buckets/b").setName("o").build())
                    .build())
            .build(),
        BidiWriteObjectRequest.newBuilder()
            .setAppendObjectSpec(
                AppendObjectSpec.newBuilder()
                    .setBucket("projects/_/buckets/b")
                    .setObject("o")
                    .build())
            .build() /*,
                     BidiWriteObjectRequest.newBuilder()
                         .setUploadId("upload-id")
                         .build(),*/);
  }

  Arbitrary<@NonNull List<ChecksummedData>> dataMessage() {
    // keep data fairly small, we are mainly testing message handling not data handling
    return Arbitraries.integers()
        .between(1, 17)
        .map(
            numBytes -> {
              ChecksummedTestContent content =
                  ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(numBytes));
              return content.asChecksummedData();
            })
        .list()
        .ofMinSize(1)
        .ofMaxSize(5);
  }

  Arbitrary<@Nullable BidiWriteObjectRequest> finishMessage() {
    return Arbitraries.of(
        BidiWriteObjectRequest.newBuilder().setFinishWrite(true).build(),
        BidiWriteObjectRequest.newBuilder().setFlush(true).setStateLookup(true).build());
  }

  private static String fmt(List<? extends Message> l) {
    return l.stream().map(StorageV2ProtoUtils::fmtProto).collect(BidiUploadTest.joiner);
  }

  private static String fmt(Message msg) {
    if (msg == null) {
      return "null";
    }
    return fmtProto(msg);
  }

  static final class ScenarioWithLastWrittenRequest {
    private static final long MAX_BYTES = 50_000;
    private final int lastSentRequestIndex;
    private final long beginFromOffset;
    private final BidiWriteObjectRequest firstMessage;
    private final List<BidiWriteObjectRequest> messages;

    private ScenarioWithLastWrittenRequest(
        int lastWrittenRequest,
        long beginFromOffset,
        BidiWriteObjectRequest firstMessage,
        List<BidiWriteObjectRequest> messages) {
      this.lastSentRequestIndex = lastWrittenRequest;
      this.beginFromOffset = beginFromOffset;
      this.firstMessage = firstMessage;
      this.messages = messages;
    }

    public @NonNull AppendableUploadState makeBidiUploadState() {
      if (firstMessage.hasWriteObjectSpec()) {
        AppendableUploadState state =
            BidiUploadState.appendableNew(
                firstMessage,
                GrpcCallContext::createDefault,
                MAX_BYTES,
                SettableApiFuture.create(),
                Crc32cValue.zero());
        state.totalSentBytes = beginFromOffset;
        return state;
      } else if (firstMessage.hasAppendObjectSpec()) {
        AppendableUploadState state =
            BidiUploadState.appendableTakeover(
                firstMessage,
                GrpcCallContext::createDefault,
                MAX_BYTES,
                SettableApiFuture.create(),
                Crc32cValue.zero());
        state.awaitTakeoverStateReconciliation(
            () -> {
              state.retrying();
              assertThat(
                      state.onResponse(BidiUploadTest.resourceFor(firstMessage, beginFromOffset)))
                  .isNull();
            });
        return state;
      } else {
        //noinspection JUnit5AssertionsConverter
        fail("Unhandled firstMessage type: " + fmtProto(firstMessage));
        return null;
      }
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("\n  lastWrittenRequest", lastSentRequestIndex)
          .add("\n  beginFromOffset", beginFromOffset)
          .add("\n  maxBytes", MAX_BYTES)
          .add("\n  firstMessage", BidiUploadStreamingStreamPropertyTest.fmt(firstMessage))
          .add("\n  messages", fmt(messages))
          .addValue("\n")
          .toString();
    }

    private static String fmt(List<BidiWriteObjectRequest> msgs) {
      return msgs.stream()
          .map(BidiUploadStreamingStreamPropertyTest::fmt)
          .collect(Collectors.joining(",\n    ", "[\n    ", "\n  ]"));
    }
  }
}
