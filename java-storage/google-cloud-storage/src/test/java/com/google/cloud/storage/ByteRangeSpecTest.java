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

import static com.google.cloud.storage.ByteRangeSpec.EFFECTIVE_INFINITY;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static java.util.Objects.requireNonNull;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Streams;
import com.google.storage.v2.ReadObjectRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public final class ByteRangeSpecTest {

  public static final class Behavior {

    @Test
    public void negativeBeginOffset() throws Exception {
      ByteRangeSpec rel = ByteRangeSpec.relativeLength(-5L, null);
      ByteRangeSpec exO = ByteRangeSpec.explicit(-5L, null);
      ByteRangeSpec exC = ByteRangeSpec.explicitClosed(-5L, null);
      threeWayEqual(exO, exC, rel);
    }

    @Test
    public void negativeBeginOffset_fromNull() {
      ByteRangeSpec spec = ByteRangeSpec.nullRange().withNewBeginOffset(-5L);
      assertThat(spec.getHttpRangeHeader()).isEqualTo("bytes=-5");
    }

    @Test
    public void beginNonNullZero_endNonNullNonInfinity() throws Exception {
      ByteRangeSpec rel = ByteRangeSpec.relativeLength(0L, 52L);
      ByteRangeSpec exO = ByteRangeSpec.explicit(0L, 52L);
      ByteRangeSpec exC = ByteRangeSpec.explicitClosed(0L, 51L);

      threeWayEqual(exO, exC, rel);
    }

    @Test
    public void beginNonNullNonZero_endNonNullNonInfinity() throws Exception {
      ByteRangeSpec rel = ByteRangeSpec.relativeLength(10L, 10L);
      ByteRangeSpec exO = ByteRangeSpec.explicit(10L, 20L);
      ByteRangeSpec exC = ByteRangeSpec.explicitClosed(10L, 19L);

      threeWayEqual(exO, exC, rel);
    }

    @Test
    public void beginNull_endNonNullNonInfinity() throws Exception {
      ByteRangeSpec rel = ByteRangeSpec.relativeLength(null, 10L);
      ByteRangeSpec exO = ByteRangeSpec.explicit(null, 10L);
      ByteRangeSpec exC = ByteRangeSpec.explicitClosed(null, 9L);

      threeWayEqual(exO, exC, rel);
    }

    @Test
    public void beginNonNullNonZero_endNull() throws Exception {
      ByteRangeSpec rel = ByteRangeSpec.relativeLength(10L, null);
      ByteRangeSpec exO = ByteRangeSpec.explicit(10L, null);
      ByteRangeSpec exC = ByteRangeSpec.explicitClosed(10L, null);

      threeWayEqual(exO, exC, rel);
    }

    @Test
    public void bothNull_relative() {
      assertThat(ByteRangeSpec.relativeLength(null, null))
          .isSameInstanceAs(ByteRangeSpec.nullRange());
    }

    @Test
    public void bothNull_explicit() {
      assertThat(ByteRangeSpec.explicit(null, null)).isSameInstanceAs(ByteRangeSpec.nullRange());
    }

    @Test
    public void bothNull_explicitClosed() {
      assertThat(ByteRangeSpec.explicitClosed(null, null))
          .isSameInstanceAs(ByteRangeSpec.nullRange());
    }

    @Test
    public void httpRangeHeaderIsCached() {
      ByteRangeSpec relative = ByteRangeSpec.relativeLength(5L, null);

      String header1 = relative.getHttpRangeHeader();
      String header2 = relative.getHttpRangeHeader();

      assertThat(header1).isSameInstanceAs(header2);
    }

    @Test
    public void withNewBeginOffset_sameInstanceIfNotDifferent_relative() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, 10L);
      assertThat(spec.withNewBeginOffset(3L)).isSameInstanceAs(spec);
    }

    @Test
    public void withNewBeginOffset_sameInstanceIfNotDifferent_null() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(null, null);
      assertThat(spec.withNewBeginOffset(0)).isSameInstanceAs(spec);
    }

    @Test
    public void withNewBeginOffset_sameInstanceIfNotDifferent_leftClosed() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, null);
      assertThat(spec.withNewBeginOffset(3L)).isSameInstanceAs(spec);
    }

    @Test
    public void withNewBeginOffset_sameInstanceIfNotDifferent_leftClosedRightOpen() {
      ByteRangeSpec spec = ByteRangeSpec.explicit(3L, 10L);
      assertThat(spec.withNewBeginOffset(3L)).isSameInstanceAs(spec);
    }

    @Test
    public void withNewBeginOffset_sameInstanceIfNotDifferent_leftClosedRightClosed() {
      ByteRangeSpec spec = ByteRangeSpec.explicitClosed(3L, 10L);
      assertThat(spec.withNewBeginOffset(3L)).isSameInstanceAs(spec);
    }

    @Test
    public void withShiftBeginOffset_sameInstanceIfNotDifferent_relative() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, 10L);
      assertThat(spec.withShiftBeginOffset(0)).isSameInstanceAs(spec);
    }

    @Test
    public void withShiftBeginOffset_sameInstanceIfNotDifferent_null() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(null, null);
      assertThat(spec.withShiftBeginOffset(0)).isSameInstanceAs(spec);
    }

    @Test
    public void withShiftBeginOffset_sameInstanceIfNotDifferent_leftClosed() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, null);
      assertThat(spec.withShiftBeginOffset(0)).isSameInstanceAs(spec);
    }

    @Test
    public void withShiftBeginOffset_sameInstanceIfNotDifferent_leftClosedRightOpen() {
      ByteRangeSpec spec = ByteRangeSpec.explicit(3L, 10L);
      assertThat(spec.withShiftBeginOffset(0)).isSameInstanceAs(spec);
    }

    @Test
    public void withShiftBeginOffset_sameInstanceIfNotDifferent_leftClosedRightClosed() {
      ByteRangeSpec spec = ByteRangeSpec.explicitClosed(3L, 10L);
      assertThat(spec.withShiftBeginOffset(0)).isSameInstanceAs(spec);
    }

    @Test
    public void withRelativeLength_sameInstanceIfNotDifferent_relative() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, 10L);
      assertThat(spec.withNewRelativeLength(10L)).isSameInstanceAs(spec);
    }

    @Test
    public void withNewEndOffset_sameInstanceIfNotDifferent_null() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(null, null);
      assertThat(spec.withNewEndOffset(EFFECTIVE_INFINITY)).isSameInstanceAs(spec);
    }

    @Test
    public void withNewEndOffsetClosed_sameInstanceIfNotDifferent_null() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(null, null);
      assertThat(spec.withNewEndOffsetClosed(EFFECTIVE_INFINITY)).isSameInstanceAs(spec);
    }

    @Test
    public void withNewRelativeLength_sameInstanceIfNotDifferent_null() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(null, null);
      assertThat(spec.withNewRelativeLength(EFFECTIVE_INFINITY)).isSameInstanceAs(spec);
    }

    @Test
    public void withNewEndOffset_sameInstanceIfNotDifferent_leftClosedRightOpen() {
      ByteRangeSpec spec = ByteRangeSpec.explicit(3L, 41L);
      assertThat(spec.withNewEndOffset(41L)).isSameInstanceAs(spec);
    }

    @Test
    public void withNewEndOffsetClosed_sameInstanceIfNotDifferent_leftClosedRightClosed() {
      ByteRangeSpec spec = ByteRangeSpec.explicitClosed(3L, 41L);
      assertThat(spec.withNewEndOffsetClosed(41L)).isSameInstanceAs(spec);
    }

    @Test
    public void withNewBeginOffset_relative() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, 10L);
      ByteRangeSpec actual = spec.withNewBeginOffset(4L);
      assertThat(actual.beginOffset()).isEqualTo(4);
    }

    @Test
    public void withNewBeginOffset_null() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(null, null);
      ByteRangeSpec actual = spec.withNewBeginOffset(4L);
      assertThat(actual.beginOffset()).isEqualTo(4);
    }

    @Test
    public void withNewBeginOffset_leftClosed() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, null);
      ByteRangeSpec actual = spec.withNewBeginOffset(4L);
      assertThat(actual.beginOffset()).isEqualTo(4);
    }

    @Test
    public void withNewBeginOffset_leftClosedRightOpen() {
      ByteRangeSpec spec = ByteRangeSpec.explicit(3L, 10L);
      ByteRangeSpec actual = spec.withNewBeginOffset(4L);
      assertThat(actual.beginOffset()).isEqualTo(4);
    }

    @Test
    public void withNewBeginOffset_leftClosedRightClosed() {
      ByteRangeSpec spec = ByteRangeSpec.explicitClosed(3L, 10L);
      ByteRangeSpec actual = spec.withNewBeginOffset(4L);
      assertThat(actual.beginOffset()).isEqualTo(4);
    }

    @Test
    public void withShiftBeginOffset_relative() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, 10L);
      ByteRangeSpec actual = spec.withShiftBeginOffset(4L);
      assertThat(actual.beginOffset()).isEqualTo(7);
    }

    @Test
    public void withShiftBeginOffset_null() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(null, null);
      ByteRangeSpec actual = spec.withShiftBeginOffset(4L);
      assertThat(actual.beginOffset()).isEqualTo(4);
    }

    @Test
    public void withShiftBeginOffset_leftClosed() {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, null);
      ByteRangeSpec actual = spec.withShiftBeginOffset(4L);
      assertThat(actual.beginOffset()).isEqualTo(7);
    }

    @Test
    public void withShiftBeginOffset_leftClosedRightOpen() {
      ByteRangeSpec spec = ByteRangeSpec.explicit(3L, 10L);
      ByteRangeSpec actual = spec.withShiftBeginOffset(4L);
      assertThat(actual.beginOffset()).isEqualTo(7);
    }

    @Test
    public void withShiftBeginOffset_leftClosedRightClosed() {
      ByteRangeSpec spec = ByteRangeSpec.explicitClosed(3L, 10L);
      ByteRangeSpec actual = spec.withShiftBeginOffset(4L);
      assertThat(actual.beginOffset()).isEqualTo(7);
    }

    @Test
    public void withNewEndOffset_relative() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, 10L);
      ByteRangeSpec actual = spec.withNewEndOffset(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.endOffset()).isEqualTo(4));
    }

    @Test
    public void withNewEndOffset_null() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(null, null);
      ByteRangeSpec actual = spec.withNewEndOffset(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(0),
          () -> assertThat(actual.endOffset()).isEqualTo(4));
    }

    @Test
    public void withNewEndOffset_leftClosed() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, null);
      ByteRangeSpec actual = spec.withNewEndOffset(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.endOffset()).isEqualTo(4));
    }

    @Test
    public void withNewEndOffset_leftClosedRightOpen() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.explicit(3L, 10L);
      ByteRangeSpec actual = spec.withNewEndOffset(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.endOffset()).isEqualTo(4));
    }

    @Test
    public void withNewEndOffset_leftClosedRightClosed() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.explicitClosed(3L, 10L);
      ByteRangeSpec actual = spec.withNewEndOffset(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.endOffset()).isEqualTo(4));
    }

    @Test
    public void withNewEndOffsetClosed_relative() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, 10L);
      ByteRangeSpec actual = spec.withNewEndOffsetClosed(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.endOffsetInclusive()).isEqualTo(4));
    }

    @Test
    public void withNewEndOffsetClosed_null() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(null, null);
      ByteRangeSpec actual = spec.withNewEndOffsetClosed(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(0),
          () -> assertThat(actual.endOffsetInclusive()).isEqualTo(4));
    }

    @Test
    public void withNewEndOffsetClosed_leftClosed() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, null);
      ByteRangeSpec actual = spec.withNewEndOffsetClosed(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.endOffsetInclusive()).isEqualTo(4));
    }

    @Test
    public void withNewEndOffsetClosed_leftClosedRightOpen() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.explicit(3L, 10L);
      ByteRangeSpec actual = spec.withNewEndOffsetClosed(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.endOffsetInclusive()).isEqualTo(4));
    }

    @Test
    public void withNewEndOffsetClosed_leftClosedRightClosed() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.explicitClosed(3L, 10L);
      ByteRangeSpec actual = spec.withNewEndOffsetClosed(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.endOffsetInclusive()).isEqualTo(4));
    }

    @Test
    public void withNewRelativeLength_relative() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, 10L);
      ByteRangeSpec actual = spec.withNewRelativeLength(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.length()).isEqualTo(4));
    }

    @Test
    public void withNewRelativeLength_null() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(null, null);
      ByteRangeSpec actual = spec.withNewRelativeLength(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(0),
          () -> assertThat(actual.length()).isEqualTo(4));
    }

    @Test
    public void withNewRelativeLength_leftClosed() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.relativeLength(3L, null);
      ByteRangeSpec actual = spec.withNewRelativeLength(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.length()).isEqualTo(4));
    }

    @Test
    public void withNewRelativeLength_leftClosedRightOpen() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.explicit(3L, 10L);
      ByteRangeSpec actual = spec.withNewRelativeLength(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.length()).isEqualTo(4));
    }

    @Test
    public void withNewRelativeLength_leftClosedRightClosed() throws Exception {
      ByteRangeSpec spec = ByteRangeSpec.explicitClosed(3L, 10L);
      ByteRangeSpec actual = spec.withNewRelativeLength(4L);
      assertAll(
          () -> assertThat(actual.beginOffset()).isEqualTo(3),
          () -> assertThat(actual.length()).isEqualTo(4));
    }

    @SuppressWarnings("EqualsBetweenInconvertibleTypes")
    @Test
    public void negativeEquals() {
      assertThat(ByteRangeSpec.nullRange().equals("")).isFalse();
    }

    @Test
    public void nullRangeShouldBeASingletonAcrossJavaSerialization()
        throws IOException, ClassNotFoundException {
      ByteRangeSpec orig = ByteRangeSpec.nullRange();
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
        oos.writeObject(orig);
      }

      byte[] serializedBytes = baos.toByteArray();
      ByteRangeSpec deserialized;
      try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedBytes);
          ObjectInputStream ois = new ObjectInputStream(bais)) {
        deserialized = (ByteRangeSpec) ois.readObject();
      }
      assertThat(deserialized).isSameInstanceAs(orig);
    }
  }

  private static void threeWayEqual(
      ByteRangeSpec explicitO, ByteRangeSpec explicitC, ByteRangeSpec relative) throws Exception {

    assertAll(
        () -> assertThat(explicitO).isEqualTo(relative),
        () -> assertThat(explicitO).isEqualTo(explicitC),
        () -> assertThat(explicitC).isEqualTo(relative));
  }

  @RunWith(Parameterized.class)
  public static final class RangeScenarios {

    private final RangeScenario rs;
    private final RangeScenario.Expectations expect;

    public RangeScenarios(RangeScenario rs) {
      this.rs = rs;
      this.expect = rs.getExpectations();
    }

    @Test
    public void httpRangeHeader() {
      assertThat(rs.getSpec().getHttpRangeHeader()).isEqualTo(expect.getHttpRange());
    }

    @Test
    public void seekReadObjectRequest() {
      ByteRangeSpec spec = rs.getSpec();
      ReadObjectRequest actual = spec.seekReadObjectRequest(ReadObjectRequest.newBuilder()).build();
      assertThat(actual).isEqualTo(expect.getReadObjectRequest());
    }

    @Test
    public void beginOffset() {
      assertThat(rs.getSpec().beginOffset()).isEqualTo(expect.getBeginOffset());
    }

    @Test
    public void endOffset() {
      assertThat(rs.getSpec().endOffset()).isEqualTo(expect.getEndOffset());
    }

    @Test
    public void endOffsetInclusive() {
      assertThat(rs.getSpec().endOffsetInclusive()).isEqualTo(expect.getEndOffsetInclusive());
    }

    @Test
    public void length() {
      assertThat(rs.getSpec().length()).isEqualTo(expect.getLength());
    }

    @Parameters(name = "{0}")
    public static Iterable<Object[]> testCases() {
      // expect that by default, a range should be from zero to infinity
      Stream<RangeScenario> bothNullOrEmpty =
          RangeScenario.expectThat()
              .beginOffset(0L)
              .endOffset(EFFECTIVE_INFINITY)
              .endOffsetInclusive(EFFECTIVE_INFINITY)
              .length(EFFECTIVE_INFINITY)
              .httpRange(null)
              .readObjectRequest(reqId())
              .isApplicableTo(
                  ByteRangeSpec.relativeLength(null, null),
                  ByteRangeSpec.explicit(null, null),
                  ByteRangeSpec.explicitClosed(null, null),
                  ByteRangeSpec.relativeLength(0L, null),
                  ByteRangeSpec.explicit(0L, null),
                  ByteRangeSpec.explicitClosed(0L, null),
                  ByteRangeSpec.relativeLength(null, EFFECTIVE_INFINITY),
                  ByteRangeSpec.explicit(null, EFFECTIVE_INFINITY),
                  ByteRangeSpec.explicitClosed(null, EFFECTIVE_INFINITY),
                  ByteRangeSpec.relativeLength(0L, EFFECTIVE_INFINITY),
                  ByteRangeSpec.explicit(0L, EFFECTIVE_INFINITY),
                  ByteRangeSpec.explicitClosed(0L, EFFECTIVE_INFINITY));
      // expect that, if the range is effectively LeftClosed only, all upper bounds should
      // be EFFECTIVE_INFINITY and the requests should be open-ended
      Stream<RangeScenario> effectivelyOnlyBegin =
          RangeScenario.expectThat()
              .beginOffset(3L)
              .endOffset(EFFECTIVE_INFINITY)
              .endOffsetInclusive(EFFECTIVE_INFINITY)
              .length(EFFECTIVE_INFINITY)
              .httpRange(headerRangeOpen(3))
              .readObjectRequest(reqOpen(3))
              .isApplicableTo(
                  ByteRangeSpec.relativeLength(3L, null),
                  ByteRangeSpec.explicit(3L, null),
                  ByteRangeSpec.explicitClosed(3L, null),
                  // effective infinity means it should not impact things
                  ByteRangeSpec.relativeLength(3L, EFFECTIVE_INFINITY),
                  ByteRangeSpec.explicit(3L, EFFECTIVE_INFINITY),
                  ByteRangeSpec.explicitClosed(3L, EFFECTIVE_INFINITY));
      // expect that, if the range is effectively Right{Closed,Open} only, lower bounds should
      // be zero and the requests should be bounded from 0-N
      Stream<RangeScenario> effectivelyOnlyEnd =
          Stream.concat(
              RangeScenario.expectThat()
                  .beginOffset(0L)
                  .endOffset(131L)
                  .endOffsetInclusive(130L)
                  .length(131L)
                  .bounded()
                  .isApplicableTo(
                      ByteRangeSpec.relativeLength(null, 131L),
                      ByteRangeSpec.explicit(null, 131L),
                      ByteRangeSpec.explicitClosed(null, 130L)),
              RangeScenario.expectThat()
                  .beginOffset(0L)
                  .endOffset(251L)
                  .endOffsetInclusive(250L)
                  .length(251L)
                  .bounded()
                  .isApplicableTo(
                      ByteRangeSpec.relativeLength(0L, 251L),
                      ByteRangeSpec.explicit(0L, 251L),
                      ByteRangeSpec.explicitClosed(0L, 250L)));

      // expect that, when a range has both a lower and upper bound, all values match along with
      // requests being bounded
      Stream<RangeScenario> bothSpecified =
          RangeScenario.expectThat()
              .beginOffset(4L)
              .endOffset(10L)
              .endOffsetInclusive(9L)
              .length(6L)
              .bounded()
              .isApplicableTo(
                  ByteRangeSpec.relativeLength(4L, 6L),
                  ByteRangeSpec.explicit(4L, 10L),
                  ByteRangeSpec.explicitClosed(4L, 9L));

      // variable name should be read as "effective max minus zero"
      long effectiveMax_0 = EFFECTIVE_INFINITY - 1;
      // variable name should be read as "effective max minus one"
      long effectiveMax_1 = effectiveMax_0 - 1;
      // edge cases near default values
      Stream<RangeScenario> edgeCases =
          Streams.concat(
              // expect that, if the range is effectively LeftClosed only, all upper bounds should
              // be EFFECTIVE_INFINITY and the requests should be open-ended
              RangeScenario.expectThat()
                  .beginOffset(1L)
                  .endOffset(EFFECTIVE_INFINITY)
                  .endOffsetInclusive(EFFECTIVE_INFINITY)
                  .length(EFFECTIVE_INFINITY)
                  .httpRange(headerRangeOpen(1L))
                  .readObjectRequest(reqOpen(1L))
                  .isApplicableTo(
                      ByteRangeSpec.relativeLength(1L, null),
                      ByteRangeSpec.explicit(1L, null),
                      ByteRangeSpec.explicitClosed(1L, null)),
              // expect that, we can start reading from effective_infinity with not upper bound
              RangeScenario.expectThat()
                  .beginOffset(EFFECTIVE_INFINITY)
                  .endOffset(EFFECTIVE_INFINITY)
                  .endOffsetInclusive(EFFECTIVE_INFINITY)
                  .length(EFFECTIVE_INFINITY)
                  .httpRange(headerRangeOpen(EFFECTIVE_INFINITY))
                  .readObjectRequest(reqOpen(EFFECTIVE_INFINITY))
                  .isApplicableTo(
                      ByteRangeSpec.relativeLength(EFFECTIVE_INFINITY, null),
                      ByteRangeSpec.explicit(EFFECTIVE_INFINITY, null),
                      ByteRangeSpec.explicitClosed(EFFECTIVE_INFINITY, null)),
              // expect that, we can read up to Long.MAX_VALUE - 1
              RangeScenario.expectThat()
                  .beginOffset(0L)
                  .endOffset(effectiveMax_0)
                  .endOffsetInclusive(effectiveMax_1)
                  .length(effectiveMax_0)
                  .bounded()
                  .isApplicableTo(
                      ByteRangeSpec.relativeLength(null, effectiveMax_0),
                      ByteRangeSpec.explicit(null, effectiveMax_0),
                      ByteRangeSpec.explicitClosed(null, effectiveMax_1)),
              // expect that, we can read from 1 up to Long.MAX_VALUE - 1
              RangeScenario.expectThat()
                  .beginOffset(1L)
                  .endOffset(effectiveMax_0)
                  .endOffsetInclusive(effectiveMax_1)
                  .length(effectiveMax_1)
                  .bounded()
                  .isApplicableTo(
                      ByteRangeSpec.relativeLength(1L, effectiveMax_1),
                      ByteRangeSpec.explicit(1L, effectiveMax_0),
                      ByteRangeSpec.explicitClosed(1L, effectiveMax_1)));

      return Streams.concat(
              bothNullOrEmpty, effectivelyOnlyBegin, effectivelyOnlyEnd, bothSpecified, edgeCases)
          .map(rs -> new Object[] {rs})
          .collect(ImmutableList.toImmutableList());
    }
  }

  private static String headerRangeOpen(long min) {
    return String.format(Locale.US, "bytes=%d-", min);
  }

  private static String headerRangeClosed(long min, long max) {
    return String.format(Locale.US, "bytes=%d-%d", min, max);
  }

  private static ReadObjectRequest reqOpen(long offset) {
    return ReadObjectRequest.newBuilder().setReadOffset(offset).build();
  }

  private static ReadObjectRequest reqBounded(long offset, long length) {
    return ReadObjectRequest.newBuilder().setReadOffset(offset).setReadLimit(length).build();
  }

  private static ReadObjectRequest reqId() {
    return ReadObjectRequest.getDefaultInstance();
  }

  private static final class RangeScenario {
    private final ByteRangeSpec spec;
    private final Expectations expectations;

    private RangeScenario(ByteRangeSpec spec, Expectations expectations) {
      this.spec = spec;
      this.expectations = expectations;
    }

    public ByteRangeSpec getSpec() {
      return spec;
    }

    public Expectations getExpectations() {
      return expectations;
    }

    @Override
    public String toString() {
      return String.format(
          Locale.US, "Expect that %s is applicable to %s", expectations.testNameFormat(), spec);
    }

    static ExpectationsBuilder expectThat() {
      return new ExpectationsBuilder();
    }

    private static final class Expectations {
      private final long beginOffset;
      private final long endOffset;
      private final long endOffsetInclusive;
      private final long length;
      @Nullable private final String httpRange;
      @NonNull private final ReadObjectRequest readObjectRequest;

      private Expectations(
          long beginOffset,
          long endOffset,
          long endOffsetInclusive,
          long length,
          @Nullable String httpRange,
          @NonNull ReadObjectRequest readObjectRequest) {
        this.beginOffset = beginOffset;
        this.endOffset = endOffset;
        this.endOffsetInclusive = endOffsetInclusive;
        this.length = length;
        this.httpRange = httpRange;
        this.readObjectRequest = readObjectRequest;
      }

      public long getBeginOffset() {
        return beginOffset;
      }

      public long getEndOffset() {
        return endOffset;
      }

      public long getEndOffsetInclusive() {
        return endOffsetInclusive;
      }

      public long getLength() {
        return length;
      }

      public @Nullable String getHttpRange() {
        return httpRange;
      }

      public @NonNull ReadObjectRequest getReadObjectRequest() {
        return readObjectRequest;
      }

      String testNameFormat() {
        return MoreObjects.toStringHelper("")
            .add("bo", fmt(beginOffset))
            .add("eo", fmt(endOffset))
            .add("eoi", fmt(endOffsetInclusive))
            .add("l", fmt(length))
            .toString();
      }

      @Override
      public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("beginOffset", fmt(beginOffset))
            .add("endOffset", fmt(endOffset))
            .add("endOffsetInclusive", fmt(endOffsetInclusive))
            .add("length", fmt(length))
            .add("httpRange", httpRange)
            .add("readObjectRequest", StorageV2ProtoUtils.fmtProto(readObjectRequest))
            .toString();
      }

      private static String fmt(@Nullable Long l) {
        if (l == null) {
          return null;
        } else if (l == Long.MAX_VALUE) {
          return "Long.MAX_VALUE";
        } else {
          long diff = Long.MAX_VALUE - l;
          // When testing near the upperbound of Long it can be challenging to read how close we are
          // to the max value at a glance. In an effort to help this, for any value that is within
          // 20 of Long.MAX_VALUE format it as a difference.
          if (diff <= 20) {
            return String.format(Locale.US, "(Long.MAX_VALUE - %d)", diff);
          } else {
            return l.toString();
          }
        }
      }
    }

    private static final class ExpectationsBuilder {
      private Long beginOffset;
      private Long endOffset;
      private Long endOffsetInclusive;
      private Long length;
      @Nullable private String httpRange;
      @NonNull private ReadObjectRequest readObjectRequest;

      public ExpectationsBuilder beginOffset(Long beginOffset) {
        this.beginOffset = beginOffset;
        return this;
      }

      public ExpectationsBuilder endOffset(Long endOffset) {
        this.endOffset = endOffset;
        return this;
      }

      public ExpectationsBuilder endOffsetInclusive(Long endOffsetInclusive) {
        this.endOffsetInclusive = endOffsetInclusive;
        return this;
      }

      public ExpectationsBuilder length(Long length) {
        this.length = length;
        return this;
      }

      public ExpectationsBuilder httpRange(String httpRange) {
        this.httpRange = httpRange;
        return this;
      }

      public ExpectationsBuilder readObjectRequest(ReadObjectRequest readObjectRequest) {
        this.readObjectRequest = readObjectRequest;
        return this;
      }

      public ExpectationsBuilder bounded() {
        return this.httpRange(headerRangeClosed(beginOffset, endOffsetInclusive))
            .readObjectRequest(reqBounded(beginOffset, length));
      }

      public Stream<RangeScenario> isApplicableTo(ByteRangeSpec... brss) {
        Expectations expectations = this.build();
        return Arrays.stream(brss).map(brs -> new RangeScenario(brs, expectations));
      }

      private Expectations build() {
        return new Expectations(
            requireNonNull(beginOffset, "beginOffset must be non null"),
            requireNonNull(endOffset, "endOffset must be non null"),
            requireNonNull(endOffsetInclusive, "endOffsetInclusive must be non null"),
            requireNonNull(length, "length must be non null"),
            httpRange,
            requireNonNull(readObjectRequest, "readObjectRequest must be non null"));
      }
    }
  }
}
