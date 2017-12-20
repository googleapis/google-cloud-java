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

package com.google.cloud.firestore;

import static org.junit.Assert.assertEquals;

import com.google.firestore.v1beta1.ArrayValue;
import com.google.firestore.v1beta1.MapValue;
import com.google.firestore.v1beta1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.NullValue;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import java.util.Arrays;
import org.junit.Test;

public class OrderTest {

  @Test
  public void verifyOrder() {
    Value[][] groups = new Value[64][];

    groups[0] = new Value[] {nullValue()};

    groups[1] = new Value[] {booleanValue(false)};
    groups[2] = new Value[] {booleanValue(true)};

    // numbers
    groups[3] = new Value[] {doubleValue(Double.NaN), doubleValue(Double.NaN)};
    groups[4] = new Value[] {doubleValue(Double.NEGATIVE_INFINITY)};
    groups[5] = new Value[] {intValue((long) Integer.MIN_VALUE - 1)};
    groups[6] = new Value[] {intValue(Integer.MIN_VALUE)};
    groups[7] = new Value[] {doubleValue(-1.1)};
    // Integers and Doubles order the same.
    groups[8] = new Value[] {intValue(-1), doubleValue(-1.0)};
    groups[9] = new Value[] {doubleValue(-Double.MIN_VALUE)};
    // zeros all compare the same.
    groups[10] = new Value[] {intValue(0), doubleValue(-0.0), doubleValue(0.0), doubleValue(+0.0)};
    groups[11] = new Value[] {doubleValue(Double.MIN_VALUE)};
    groups[12] = new Value[] {intValue(1), doubleValue(1.0)};
    groups[13] = new Value[] {doubleValue(1.1)};
    groups[14] = new Value[] {intValue(Integer.MAX_VALUE)};
    groups[15] = new Value[] {intValue((long) Integer.MAX_VALUE + 1)};
    groups[16] = new Value[] {doubleValue(Double.POSITIVE_INFINITY)};

    groups[17] = new Value[] {timestampValue(123, 0)};
    groups[18] = new Value[] {timestampValue(123, 123)};
    groups[19] = new Value[] {timestampValue(345, 0)};

    // strings
    groups[20] = new Value[] {stringValue("")};
    groups[21] = new Value[] {stringValue("\u0000\ud7ff\ue000\uffff")};
    groups[22] = new Value[] {stringValue("(╯°□°）╯︵ ┻━┻")};
    groups[23] = new Value[] {stringValue("a")};
    groups[24] = new Value[] {stringValue("abc def")};
    // latin small letter e + combining acute accent + latin small letter b
    groups[25] = new Value[] {stringValue("e\u0301b")};
    groups[26] = new Value[] {stringValue("æ")};
    // latin small letter e with acute accent + latin small letter a
    groups[27] = new Value[] {stringValue("\u00e9a")};

    // blobs
    groups[28] = new Value[] {blobValue(new byte[] {})};
    groups[29] = new Value[] {blobValue(new byte[] {0})};
    groups[30] = new Value[] {blobValue(new byte[] {0, 1, 2, 3, 4})};
    groups[31] = new Value[] {blobValue(new byte[] {0, 1, 2, 4, 3})};
    groups[32] = new Value[] {blobValue(new byte[] {127})};

    // resource names
    groups[33] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c1/doc1")};
    groups[34] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c1/doc2")};
    groups[35] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c1/doc2/c2/doc1")};
    groups[36] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c1/doc2/c2/doc2")};
    groups[37] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c10/doc1")};
    groups[38] =
        new Value[] {referenceValue("projects/p1/databases/dkkkkklkjnjkkk1/documents/c2/doc1")};
    groups[39] = new Value[] {referenceValue("projects/p2/databases/d2/documents/c1/doc1")};
    groups[40] = new Value[] {referenceValue("projects/p2/databases/d2/documents/cl1-/doc1")};

    // geo points
    groups[41] = new Value[] {geoPointValue(-90, -180)};
    groups[42] = new Value[] {geoPointValue(-90, 0)};
    groups[43] = new Value[] {geoPointValue(-90, 180)};
    groups[44] = new Value[] {geoPointValue(0, -180)};
    groups[45] = new Value[] {geoPointValue(0, 0)};
    groups[46] = new Value[] {geoPointValue(0, 180)};
    groups[47] = new Value[] {geoPointValue(1, -180)};
    groups[48] = new Value[] {geoPointValue(1, 0)};
    groups[49] = new Value[] {geoPointValue(1, 180)};
    groups[50] = new Value[] {geoPointValue(90, -180)};
    groups[51] = new Value[] {geoPointValue(90, 0)};
    groups[52] = new Value[] {geoPointValue(90, 180)};

    // arrays
    groups[53] = new Value[] {arrayValue()};
    groups[54] = new Value[] {arrayValue(stringValue("bar"))};
    groups[55] = new Value[] {arrayValue(stringValue("foo"))};
    groups[56] = new Value[] {arrayValue(stringValue("foo"), intValue(0))};
    groups[57] = new Value[] {arrayValue(stringValue("foo"), intValue(1))};
    groups[58] = new Value[] {arrayValue(stringValue("foo"), stringValue("0"))};

    // objects
    groups[59] = new Value[] {objectValue("bar", intValue(0))};
    groups[60] = new Value[] {objectValue("bar", intValue(0), "foo", intValue(1))};
    groups[61] = new Value[] {objectValue("bar", intValue(1))};
    groups[62] = new Value[] {objectValue("bar", intValue(2))};
    groups[63] = new Value[] {objectValue("bar", stringValue("0"))};

    for (int left = 0; left < groups.length; left++) {
      for (int right = 0; right < groups.length; right++) {
        for (int i = 0; i < groups[left].length; i++) {
          for (int j = 0; j < groups[right].length; j++) {
            assertEquals(
                String.format(
                    "Order does not match for: groups[%d][%d] and groups[%d][%d]",
                    left, i, right, j),
                Integer.compare(left, right),
                Integer.compare(Order.INSTANCE.compare(groups[left][i], groups[right][j]), 0));
          }
        }
      }
    }
  }

  private Value booleanValue(boolean b) {
    return Value.newBuilder().setBooleanValue(b).build();
  }

  private Value doubleValue(double d) {
    return Value.newBuilder().setDoubleValue(d).build();
  }

  private Value intValue(long l) {
    return Value.newBuilder().setIntegerValue(l).build();
  }

  private Value stringValue(String s) {
    return Value.newBuilder().setStringValue(s).build();
  }

  private Value referenceValue(String r) {
    return Value.newBuilder().setReferenceValue(r).build();
  }

  private Value blobValue(byte[] b) {
    return Value.newBuilder().setBytesValue(ByteString.copyFrom(b)).build();
  }

  private Value nullValue() {
    return Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
  }

  private Value timestampValue(long seconds, int nanos) {
    return Value.newBuilder()
        .setTimestampValue(Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos).build())
        .build();
  }

  private Value geoPointValue(double latitude, double longitude) {
    return Value.newBuilder()
        .setGeoPointValue(LatLng.newBuilder().setLatitude(latitude).setLongitude(longitude).build())
        .build();
  }

  private Value arrayValue(Value... values) {
    return Value.newBuilder()
        .setArrayValue(ArrayValue.newBuilder().addAllValues(Arrays.asList(values)).build())
        .build();
  }

  private Value objectValue(String key, Value value, Object... keysAndValues) {
    MapValue.Builder mapBuilder = MapValue.newBuilder();
    mapBuilder.putFields(key, value);

    for (int i = 0; i < keysAndValues.length; i += 2) {
      mapBuilder.putFields((String) keysAndValues[i], (Value) keysAndValues[i + 1]);
    }

    return Value.newBuilder().setMapValue(mapBuilder.build()).build();
  }
}
