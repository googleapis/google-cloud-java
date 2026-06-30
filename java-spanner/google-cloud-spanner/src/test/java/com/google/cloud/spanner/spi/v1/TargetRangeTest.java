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

package com.google.cloud.spanner.spi.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link TargetRange}. */
@RunWith(JUnit4.class)
public class TargetRangeTest {

  private static ByteString bs(String s) {
    return ByteString.copyFromUtf8(s);
  }

  // ==================== isPoint Tests ====================

  @Test
  public void isPoint_emptyLimit_returnsTrue() {
    TargetRange range = new TargetRange(bs("a"), ByteString.EMPTY, false);
    assertTrue(range.isPoint());
  }

  @Test
  public void isPoint_nonEmptyLimit_returnsFalse() {
    TargetRange range = new TargetRange(bs("a"), bs("b"), false);
    assertFalse(range.isPoint());
  }

  // ==================== mergeFrom Start Key Tests ====================

  @Test
  public void mergeFrom_otherStartSmaller_updatesStart() {
    TargetRange target = new TargetRange(bs("c"), bs("f"), false);
    TargetRange other = new TargetRange(bs("a"), bs("d"), false);

    target.mergeFrom(other);

    assertEquals(bs("a"), target.start);
  }

  @Test
  public void mergeFrom_otherStartEqual_keepsOriginalStart() {
    TargetRange target = new TargetRange(bs("c"), bs("f"), false);
    TargetRange other = new TargetRange(bs("c"), bs("e"), false);

    target.mergeFrom(other);

    assertEquals(bs("c"), target.start);
  }

  @Test
  public void mergeFrom_otherStartLarger_keepsOriginalStart() {
    TargetRange target = new TargetRange(bs("a"), bs("f"), false);
    TargetRange other = new TargetRange(bs("c"), bs("e"), false);

    target.mergeFrom(other);

    assertEquals(bs("a"), target.start);
  }

  // ==================== mergeFrom Limit Key Tests (Range into Range) ====================

  @Test
  public void mergeFrom_otherLimitLarger_updatesLimit() {
    TargetRange target = new TargetRange(bs("a"), bs("c"), false);
    TargetRange other = new TargetRange(bs("b"), bs("e"), false);

    target.mergeFrom(other);

    assertEquals(bs("e"), target.limit);
  }

  @Test
  public void mergeFrom_otherLimitEqual_keepsOriginalLimit() {
    TargetRange target = new TargetRange(bs("a"), bs("e"), false);
    TargetRange other = new TargetRange(bs("b"), bs("e"), false);

    target.mergeFrom(other);

    assertEquals(bs("e"), target.limit);
  }

  @Test
  public void mergeFrom_otherLimitSmaller_keepsOriginalLimit() {
    TargetRange target = new TargetRange(bs("a"), bs("f"), false);
    TargetRange other = new TargetRange(bs("b"), bs("d"), false);

    target.mergeFrom(other);

    assertEquals(bs("f"), target.limit);
  }

  // ==================== mergeFrom Point into Range Tests ====================

  @Test
  public void mergeFrom_pointBeyondLimit_extendsLimitWithPrefixSuccessor() {
    TargetRange target = new TargetRange(bs("a"), bs("c"), false);
    // Point at "d" which is beyond the limit "c"
    TargetRange point = new TargetRange(bs("d"), ByteString.EMPTY, false);

    target.mergeFrom(point);

    // Limit should be makePrefixSuccessor("d")
    assertEquals(SsFormat.makePrefixSuccessor(bs("d")), target.limit);
  }

  @Test
  public void mergeFrom_pointAtLimit_extendsLimitWithPrefixSuccessor() {
    TargetRange target = new TargetRange(bs("a"), bs("c"), false);
    // Point at "c" which equals the limit
    TargetRange point = new TargetRange(bs("c"), ByteString.EMPTY, false);

    target.mergeFrom(point);

    // Limit should be makePrefixSuccessor("c")
    assertEquals(SsFormat.makePrefixSuccessor(bs("c")), target.limit);
  }

  @Test
  public void mergeFrom_pointWithinRange_keepsOriginalLimit() {
    TargetRange target = new TargetRange(bs("a"), bs("e"), false);
    // Point at "c" which is within the range [a, e)
    TargetRange point = new TargetRange(bs("c"), ByteString.EMPTY, false);

    target.mergeFrom(point);

    // Limit should remain unchanged since point is within range
    assertEquals(bs("e"), target.limit);
  }

  @Test
  public void mergeFrom_pointBeforeStart_updatesStartKeepsLimit() {
    TargetRange target = new TargetRange(bs("c"), bs("e"), false);
    // Point at "a" which is before the start
    TargetRange point = new TargetRange(bs("a"), ByteString.EMPTY, false);

    target.mergeFrom(point);

    assertEquals(bs("a"), target.start);
    // Limit unchanged since point is before the range
    assertEquals(bs("e"), target.limit);
  }

  // ==================== mergeFrom Point into Point Tests ====================

  @Test
  public void mergeFrom_pointIntoPoint_smallerStart_extendsToIncludeBoth() {
    TargetRange target = new TargetRange(bs("c"), ByteString.EMPTY, false);
    TargetRange other = new TargetRange(bs("a"), ByteString.EMPTY, false);

    target.mergeFrom(other);

    assertEquals(bs("a"), target.start);
    // Since target was a point (limit empty), and other.start < target.limit (empty),
    // limit stays empty? Let's verify the logic...
    // Actually: other.isPoint() && other.start >= this.limit
    // If this.limit is empty, then other.start >= empty is always true (lexicographically)
    // So limit becomes makePrefixSuccessor(other.start)
    assertEquals(SsFormat.makePrefixSuccessor(bs("a")), target.limit);
  }

  @Test
  public void mergeFrom_pointIntoPoint_largerStart() {
    TargetRange target = new TargetRange(bs("a"), ByteString.EMPTY, false);
    TargetRange other = new TargetRange(bs("c"), ByteString.EMPTY, false);

    target.mergeFrom(other);

    assertEquals(bs("a"), target.start);
    // other.isPoint() && other.start("c") >= target.limit(empty) is true
    assertEquals(SsFormat.makePrefixSuccessor(bs("c")), target.limit);
  }

  // ==================== mergeFrom Approximate Flag Tests ====================

  @Test
  public void mergeFrom_bothNotApproximate_resultNotApproximate() {
    TargetRange target = new TargetRange(bs("a"), bs("c"), false);
    TargetRange other = new TargetRange(bs("b"), bs("d"), false);

    target.mergeFrom(other);

    assertFalse(target.approximate);
  }

  @Test
  public void mergeFrom_targetApproximate_resultApproximate() {
    TargetRange target = new TargetRange(bs("a"), bs("c"), true);
    TargetRange other = new TargetRange(bs("b"), bs("d"), false);

    target.mergeFrom(other);

    assertTrue(target.approximate);
  }

  @Test
  public void mergeFrom_otherApproximate_resultApproximate() {
    TargetRange target = new TargetRange(bs("a"), bs("c"), false);
    TargetRange other = new TargetRange(bs("b"), bs("d"), true);

    target.mergeFrom(other);

    assertTrue(target.approximate);
  }

  @Test
  public void mergeFrom_bothApproximate_resultApproximate() {
    TargetRange target = new TargetRange(bs("a"), bs("c"), true);
    TargetRange other = new TargetRange(bs("b"), bs("d"), true);

    target.mergeFrom(other);

    assertTrue(target.approximate);
  }

  // ==================== mergeFrom Combined Scenarios ====================

  @Test
  public void mergeFrom_disjointRanges_createsUnion() {
    // [a, c) merged with [e, g) should give [a, g)
    TargetRange target = new TargetRange(bs("a"), bs("c"), false);
    TargetRange other = new TargetRange(bs("e"), bs("g"), false);

    target.mergeFrom(other);

    assertEquals(bs("a"), target.start);
    assertEquals(bs("g"), target.limit);
  }

  @Test
  public void mergeFrom_overlappingRanges_createsUnion() {
    // [a, d) merged with [c, f) should give [a, f)
    TargetRange target = new TargetRange(bs("a"), bs("d"), false);
    TargetRange other = new TargetRange(bs("c"), bs("f"), false);

    target.mergeFrom(other);

    assertEquals(bs("a"), target.start);
    assertEquals(bs("f"), target.limit);
  }

  @Test
  public void mergeFrom_containedRange_keepsOuter() {
    // [a, f) merged with [b, d) should give [a, f)
    TargetRange target = new TargetRange(bs("a"), bs("f"), false);
    TargetRange other = new TargetRange(bs("b"), bs("d"), false);

    target.mergeFrom(other);

    assertEquals(bs("a"), target.start);
    assertEquals(bs("f"), target.limit);
  }

  @Test
  public void mergeFrom_multiplePoints_createsSpanningRange() {
    // Start with point at "c", merge point at "a", then point at "e"
    TargetRange target = new TargetRange(bs("c"), ByteString.EMPTY, false);

    target.mergeFrom(new TargetRange(bs("a"), ByteString.EMPTY, false));
    target.mergeFrom(new TargetRange(bs("e"), ByteString.EMPTY, false));

    assertEquals(bs("a"), target.start);
    assertEquals(SsFormat.makePrefixSuccessor(bs("e")), target.limit);
  }
}
