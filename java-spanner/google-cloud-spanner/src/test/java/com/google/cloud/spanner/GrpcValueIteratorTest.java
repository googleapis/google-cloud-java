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

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.protobuf.Value;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GrpcValueIteratorTest {
  @SuppressWarnings("unchecked")
  private final CloseableIterator<PartialResultSet> stream = mock(CloseableIterator.class);

  private final AbstractResultSet.Listener listener = mock(AbstractResultSet.Listener.class);

  @Test
  public void testIsDataAvailableWhenCurrentIsNull() {
    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.isDataAvailable()).thenReturn(false);
    assertFalse(iterator.isDataAvailable());

    when(stream.isDataAvailable()).thenReturn(true);
    assertTrue(iterator.isDataAvailable());
  }

  @Test
  public void testIsDataAvailableWhenValuesRemainInCurrent() {
    PartialResultSet prs =
        PartialResultSet.newBuilder()
            .setMetadata(
                ResultSetMetadata.newBuilder()
                    .setRowType(
                        StructType.newBuilder()
                            .addFields(
                                Field.newBuilder()
                                    .setName("col")
                                    .setType(Type.newBuilder().setCode(TypeCode.STRING)))))
            .addValues(Value.newBuilder().setStringValue("val1"))
            .addValues(Value.newBuilder().setStringValue("val2"))
            .build();
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(prs);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.isDataAvailable()).thenReturn(false);

    // Initial state before reading: current is null, stream has no data available
    assertFalse(iterator.isDataAvailable());

    // Advance iterator: reads first value "val1", current is set, pos is now 1 (1 < 2 values)
    assertTrue(iterator.hasNext());
    assertEquals("val1", iterator.next().getStringValue());

    // Even though stream.isDataAvailable() is false, iterator has 1 value remaining in current
    // chunk
    assertFalse(stream.isDataAvailable());
    assertTrue(iterator.isDataAvailable());

    // Read second value "val2", pos is now 2 (all 2 values consumed from current chunk)
    assertTrue(iterator.hasNext());
    assertEquals("val2", iterator.next().getStringValue());

    // Now all values in current chunk are consumed, so isDataAvailable matches stream
    assertFalse(iterator.isDataAvailable());
    when(stream.isDataAvailable()).thenReturn(true);
    assertTrue(iterator.isDataAvailable());
  }
}
