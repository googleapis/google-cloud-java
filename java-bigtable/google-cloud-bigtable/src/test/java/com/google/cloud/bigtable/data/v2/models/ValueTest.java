/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ValueTest {
  @Test
  public void rawValue() {
    Value value = Value.rawValue(ByteString.copyFromUtf8("test"));
    assertThat(Value.fromProto(value.toProto())).isEqualTo(value);
  }

  @Test
  public void rawTimestamp() {
    Value value = Value.rawTimestamp(1234);
    assertThat(Value.fromProto(value.toProto())).isEqualTo(value);
  }

  @Test
  public void int64() {
    Value value = Value.intValue(1234);
    assertThat(Value.fromProto(value.toProto())).isEqualTo(value);
  }
}
