/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.KeyRange.Endpoint.CLOSED;
import static com.google.cloud.spanner.KeyRange.Endpoint.OPEN;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.testing.EqualsTester;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.KeyRange}. */
@RunWith(JUnit4.class)
public class KeyRangeTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void basics() {
    checkKeyRange(KeyRange.closedOpen(Key.of(1), Key.of(2)), Key.of(1), CLOSED, Key.of(2), OPEN);
    checkKeyRange(
        KeyRange.closedClosed(Key.of(1), Key.of(2)), Key.of(1), CLOSED, Key.of(2), CLOSED);
    checkKeyRange(KeyRange.openOpen(Key.of(1), Key.of(2)), Key.of(1), OPEN, Key.of(2), OPEN);
    checkKeyRange(KeyRange.openClosed(Key.of(1), Key.of(2)), Key.of(1), OPEN, Key.of(2), CLOSED);
  }

  private static void checkKeyRange(
      KeyRange r, Key start, KeyRange.Endpoint startType, Key end, KeyRange.Endpoint endType) {
    assertThat(r.getStartType()).isEqualTo(startType);
    assertThat(r.geEndType()).isEqualTo(endType);
    assertThat(r.getStart()).isEqualTo(start);
    assertThat(r.getEnd()).isEqualTo(end);

    KeyRange fromBuilder =
        KeyRange.newBuilder()
            .setStart(start)
            .setStartType(startType)
            .setEnd(end)
            .setEndType(endType)
            .build();
    assertThat(fromBuilder.getStartType()).isEqualTo(startType);
    assertThat(fromBuilder.geEndType()).isEqualTo(endType);
    assertThat(fromBuilder.getStart()).isEqualTo(start);
    assertThat(fromBuilder.getEnd()).isEqualTo(end);

    assertThat(fromBuilder).isEqualTo(r);
    assertThat(fromBuilder.hashCode()).isEqualTo(fromBuilder.hashCode());
  }

  @Test
  public void equalsAndHashCode() {
    EqualsTester tester = new EqualsTester();

    // Test factory method vs builder with defaults vs builder with all parts explicit.
    tester.addEqualityGroup(
        KeyRange.closedOpen(Key.of(1), Key.of(2)),
        KeyRange.newBuilder().setStart(Key.of(1)).setEnd(Key.of(2)).build(),
        KeyRange.newBuilder()
            .setStart(Key.of(1))
            .setStartType(CLOSED)
            .setEnd(Key.of(2))
            .setEndType(OPEN)
            .build());

    // Differing endpoint types.
    tester.addEqualityGroup(KeyRange.closedClosed(Key.of(1), Key.of(2)));
    tester.addEqualityGroup(KeyRange.openOpen(Key.of(1), Key.of(2)));
    tester.addEqualityGroup(KeyRange.openClosed(Key.of(1), Key.of(2)));

    // Differing start/end keys.
    tester.addEqualityGroup(KeyRange.closedOpen(Key.of(2), Key.of(1)));
    tester.addEqualityGroup(KeyRange.closedClosed(Key.of(), Key.of()));

    // Prefix range.
    tester.addEqualityGroup(
        KeyRange.prefix(Key.of(1, 2)), KeyRange.closedClosed(Key.of(1, 2), Key.of(1, 2)));

    tester.testEquals();
  }

  @Test
  public void toBuilder() {
    KeyRange r = KeyRange.closedOpen(Key.of(1), Key.of(2));
    r.toBuilder().setEndType(CLOSED).build();
  }

  @Test
  public void builderRequiresStart() {
    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("start(Key)");
    KeyRange.newBuilder().setEnd(Key.of("z")).build();
  }

  @Test
  public void builderRequiresEnd() {
    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("end(Key)");
    KeyRange.newBuilder().setStart(Key.of("a")).build();
  }

  @Test
  public void testToString() {
    assertThat(KeyRange.closedOpen(Key.of("a"), Key.of("b")).toString()).isEqualTo("[[a],[b])");
    assertThat(KeyRange.closedClosed(Key.of("a"), Key.of("b")).toString()).isEqualTo("[[a],[b]]");
    assertThat(KeyRange.openOpen(Key.of("a"), Key.of("b")).toString()).isEqualTo("([a],[b])");
    assertThat(KeyRange.openClosed(Key.of("a"), Key.of("b")).toString()).isEqualTo("([a],[b]]");
    assertThat(KeyRange.closedClosed(Key.of(), Key.of()).toString()).isEqualTo("[[],[]]");
  }
}
