/*
 * Copyright 2018 Google LLC
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

import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRule;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadModifyWriteRowTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "fake-table";
  private static final String APP_PROFILE_ID = "fake-profile";
  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create(PROJECT_ID, INSTANCE_ID, APP_PROFILE_ID);

  @Test
  public void testAppend() {
    ReadModifyWriteRow mutation =
        ReadModifyWriteRow.create(TABLE_ID, "fake-key")
            .append(
                "fake-family",
                ByteString.copyFromUtf8("fake-qualifier"),
                ByteString.copyFromUtf8("fake-value"))
            .append("fake-family", "fake-qualifier-str", "fake-value-str");

    ReadModifyWriteRowRequest actualProto = mutation.toProto(REQUEST_CONTEXT);

    ReadModifyWriteRowRequest expected =
        ReadModifyWriteRowRequest.newBuilder()
            .setTableName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
            .setAppProfileId(APP_PROFILE_ID)
            .setRowKey(ByteString.copyFromUtf8("fake-key"))
            .addRules(
                ReadModifyWriteRule.newBuilder()
                    .setFamilyName("fake-family")
                    .setColumnQualifier(ByteString.copyFromUtf8("fake-qualifier"))
                    .setAppendValue(ByteString.copyFromUtf8("fake-value")))
            .addRules(
                ReadModifyWriteRule.newBuilder()
                    .setFamilyName("fake-family")
                    .setColumnQualifier(ByteString.copyFromUtf8("fake-qualifier-str"))
                    .setAppendValue(ByteString.copyFromUtf8("fake-value-str")))
            .build();
    assertThat(actualProto).isEqualTo(expected);
  }

  @Test
  public void testIncrement() {
    ReadModifyWriteRow mutation =
        ReadModifyWriteRow.create(TABLE_ID, "fake-key")
            .increment("fake-family", ByteString.copyFromUtf8("fake-qualifier"), 1)
            .increment("fake-family", "fake-qualifier-str", 2);

    ReadModifyWriteRowRequest actualProto = mutation.toProto(REQUEST_CONTEXT);

    assertThat(actualProto)
        .isEqualTo(
            ReadModifyWriteRowRequest.newBuilder()
                .setTableName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
                .setAppProfileId(APP_PROFILE_ID)
                .setRowKey(ByteString.copyFromUtf8("fake-key"))
                .addRules(
                    ReadModifyWriteRule.newBuilder()
                        .setFamilyName("fake-family")
                        .setColumnQualifier(ByteString.copyFromUtf8("fake-qualifier"))
                        .setIncrementAmount(1))
                .addRules(
                    ReadModifyWriteRule.newBuilder()
                        .setFamilyName("fake-family")
                        .setColumnQualifier(ByteString.copyFromUtf8("fake-qualifier-str"))
                        .setIncrementAmount(2))
                .build());
  }

  @Test
  public void serializationTest() throws IOException, ClassNotFoundException {
    ReadModifyWriteRow expected =
        ReadModifyWriteRow.create(TABLE_ID, "fake-key")
            .increment("fake-family", ByteString.copyFromUtf8("fake-qualifier"), 1)
            .append("fake-family", "a", "b");

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(expected);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

    ReadModifyWriteRow actual = (ReadModifyWriteRow) ois.readObject();
    assertThat(actual.toProto(REQUEST_CONTEXT)).isEqualTo(expected.toProto(REQUEST_CONTEXT));
  }

  @Test
  public void fromProtoTest() {
    ReadModifyWriteRow expected =
        ReadModifyWriteRow.create(TABLE_ID, "row-key")
            .increment("fake-family", ByteString.copyFromUtf8("fake-qualifier"), 1)
            .append("fake-family", "fake-qualifier", "fake-value");

    ReadModifyWriteRowRequest protoRequest = expected.toProto(REQUEST_CONTEXT);
    ReadModifyWriteRow actualRequest = ReadModifyWriteRow.fromProto(protoRequest);

    assertThat(actualRequest.toProto(REQUEST_CONTEXT)).isEqualTo(protoRequest);

    String projectId = "fresh-project";
    String instanceId = "fresh-instance";
    String appProfile = "fresh-app-profile";
    ReadModifyWriteRowRequest overriddenRequest =
        actualRequest.toProto(RequestContext.create(projectId, instanceId, appProfile));

    assertThat(overriddenRequest).isNotEqualTo(protoRequest);
    assertThat(overriddenRequest.getTableName())
        .matches(NameUtil.formatTableName(projectId, instanceId, TABLE_ID));
    assertThat(overriddenRequest.getAppProfileId()).matches(appProfile);
  }
}
