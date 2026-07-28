/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.common;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.rpc.Code;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StatusTest {

  @Test
  public void testAllCodes() {
    for (Code protoValue : com.google.rpc.Code.values()) {
      Status.Code modelValue = Status.Code.fromProto(protoValue);

      assertWithMessage("proto enum value %s should be wrapped", protoValue.toString())
          .that(modelValue.toString())
          .isEqualTo(protoValue.toString());
    }

    com.google.rpc.Status randomProto =
        com.google.rpc.Status.newBuilder().setCode(49).setMessage("some message").build();
    assertWithMessage("Unrecognized proto value should be wrapped")
        .that(Status.Code.fromProto(com.google.rpc.Code.forNumber(randomProto.getCode())))
        .isEqualTo(Status.Code.UNRECOGNIZED);
  }

  @Test
  public void testAllCodeNumbers() {
    for (Code protoValue : com.google.rpc.Code.values()) {
      if (protoValue == com.google.rpc.Code.UNRECOGNIZED) {
        continue;
      }
      Status.Code modelValue = Status.Code.fromCodeNumber(protoValue.getNumber());

      assertWithMessage("proto enum value %s should be wrapped", protoValue.toString())
          .that(modelValue.toString())
          .isEqualTo(protoValue.toString());
    }

    assertWithMessage("Unrecognized proto enum value should be wrapped")
        .that(Status.Code.fromCodeNumber(-1))
        .isEqualTo(Status.Code.UNRECOGNIZED);
  }

  @Test
  public void testFromProto() {
    com.google.rpc.Status proto =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.UNAVAILABLE.getNumber())
            .setMessage("some message")
            .build();

    Status model = Status.fromProto(proto);
    assertThat(model.getCode()).isEqualTo(Status.Code.UNAVAILABLE);
    assertThat(model.getMessage()).isEqualTo("some message");
  }

  @Test
  public void testToProto() {
    com.google.rpc.Code code = Code.UNAVAILABLE;
    com.google.rpc.Status proto =
        com.google.rpc.Status.newBuilder()
            .setCode(code.getNumber())
            .setMessage("some message")
            .build();

    Status model = Status.fromProto(proto);
    assertThat(model.getCode().toProto()).isEqualTo(code);
    assertThat(model.toProto()).isEqualTo(proto);

    assertThat(model.toString()).isEqualTo(proto.toString());
  }

  @Test
  public void testSerialization() throws IOException, ClassNotFoundException {
    com.google.rpc.Status proto =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.UNAVAILABLE.getNumber())
            .setMessage("some message")
            .build();

    Status model = Status.fromProto(proto);

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(model);
    oos.close();
    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Status actual = (Status) ois.readObject();
    assertThat(actual).isEqualTo(model);
  }
}
