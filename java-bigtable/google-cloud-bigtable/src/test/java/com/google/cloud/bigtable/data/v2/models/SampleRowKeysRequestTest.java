/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SampleRowKeysRequestTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "fake-table";
  private static final String AUTHORIZED_VIEW_ID = "fake-authorized-view";
  private static final String APP_PROFILE_ID = "fake-profile";
  private static final RequestContext REQUEST_CONTEXT =
      RequestContext.create(PROJECT_ID, INSTANCE_ID, APP_PROFILE_ID);
  @Rule public ExpectedException expect = ExpectedException.none();

  @Test
  public void toProtoTest() {
    // Test SampleRowKeysRequest on a table.
    SampleRowKeysRequest sampleRowKeysRequest = SampleRowKeysRequest.create(TableId.of(TABLE_ID));
    com.google.bigtable.v2.SampleRowKeysRequest actualRequest =
        sampleRowKeysRequest.toProto(REQUEST_CONTEXT);
    assertThat(actualRequest.getTableName())
        .isEqualTo(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID));
    assertThat(actualRequest.getAuthorizedViewName()).isEmpty();
    assertThat(actualRequest.getAppProfileId()).isEqualTo(APP_PROFILE_ID);

    // Test SampleRowKeysRequest on an authorized view.
    sampleRowKeysRequest =
        SampleRowKeysRequest.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID));
    actualRequest = sampleRowKeysRequest.toProto(REQUEST_CONTEXT);
    assertThat(actualRequest.getTableName()).isEmpty();
    assertThat(actualRequest.getAuthorizedViewName())
        .isEqualTo(
            NameUtil.formatAuthorizedViewName(
                PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID));
    assertThat(actualRequest.getAppProfileId()).isEqualTo(APP_PROFILE_ID);
  }

  @Test
  public void fromProtoTest() {
    // Test SampleRowKeysRequest on a table.
    SampleRowKeysRequest sampleRowKeysRequest = SampleRowKeysRequest.create(TableId.of(TABLE_ID));

    com.google.bigtable.v2.SampleRowKeysRequest protoRequest =
        sampleRowKeysRequest.toProto(REQUEST_CONTEXT);
    SampleRowKeysRequest actualRequest = SampleRowKeysRequest.fromProto(protoRequest);

    assertThat(actualRequest.toProto(REQUEST_CONTEXT)).isEqualTo(protoRequest);

    String projectId = "fresh-project";
    String instanceId = "fresh-instance";
    String appProfile = "fresh-app-profile";
    com.google.bigtable.v2.SampleRowKeysRequest overriddenRequest =
        actualRequest.toProto(RequestContext.create(projectId, instanceId, appProfile));

    assertThat(overriddenRequest).isNotEqualTo(protoRequest);
    assertThat(overriddenRequest.getTableName())
        .matches(NameUtil.formatTableName(projectId, instanceId, TABLE_ID));
    assertThat(overriddenRequest.getAuthorizedViewName()).isEmpty();
    assertThat(overriddenRequest.getAppProfileId()).matches(appProfile);

    // Test SampleRowKeysRequest on an authorized view.
    sampleRowKeysRequest =
        SampleRowKeysRequest.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID));

    protoRequest = sampleRowKeysRequest.toProto(REQUEST_CONTEXT);
    actualRequest = SampleRowKeysRequest.fromProto(protoRequest);

    assertThat(actualRequest.toProto(REQUEST_CONTEXT)).isEqualTo(protoRequest);

    overriddenRequest =
        actualRequest.toProto(RequestContext.create(projectId, instanceId, appProfile));

    assertThat(overriddenRequest).isNotEqualTo(protoRequest);
    assertThat(overriddenRequest.getTableName()).isEmpty();
    assertThat(overriddenRequest.getAuthorizedViewName())
        .matches(
            NameUtil.formatAuthorizedViewName(projectId, instanceId, TABLE_ID, AUTHORIZED_VIEW_ID));
    assertThat(overriddenRequest.getAppProfileId()).matches(appProfile);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromProtoWithInvalidTableId() {
    SampleRowKeysRequest.fromProto(
        com.google.bigtable.v2.SampleRowKeysRequest.getDefaultInstance()
            .toBuilder()
            .setTableName("invalid-name")
            .build());

    expect.expect(IllegalArgumentException.class);
    expect.expectMessage("Invalid table name:");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromProtoWithInvalidAuthorizedViewId() {
    SampleRowKeysRequest.fromProto(
        com.google.bigtable.v2.SampleRowKeysRequest.getDefaultInstance()
            .toBuilder()
            .setAuthorizedViewName("invalid-name")
            .build());

    expect.expect(IllegalArgumentException.class);
    expect.expectMessage("Invalid authorized view name:");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromProtoWithEmptyTableAndAuthorizedViewId() {
    SampleRowKeysRequest.fromProto(
        com.google.bigtable.v2.SampleRowKeysRequest.getDefaultInstance());

    expect.expect(IllegalArgumentException.class);
    expect.expectMessage("Either table name or authorized view name must be specified");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromProtoWithBothTableAndAuthorizedViewId() {
    SampleRowKeysRequest.fromProto(
        com.google.bigtable.v2.SampleRowKeysRequest.getDefaultInstance()
            .toBuilder()
            .setTableName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
            .setAuthorizedViewName(
                NameUtil.formatAuthorizedViewName(
                    PROJECT_ID, INSTANCE_ID, TABLE_ID, AUTHORIZED_VIEW_ID))
            .build());

    expect.expect(IllegalArgumentException.class);
    expect.expectMessage(
        "Table name and authorized view name cannot be specified at the same time");
  }

  @Test
  public void testEquality() {
    // Test SampleRowKeysRequest on a table.
    assertThat(SampleRowKeysRequest.create(TableId.of(TABLE_ID)))
        .isEqualTo(SampleRowKeysRequest.create(TableId.of(TABLE_ID)));
    assertThat(SampleRowKeysRequest.create(TableId.of("another-table")))
        .isNotEqualTo(SampleRowKeysRequest.create(TableId.of(TABLE_ID)));

    // Test SampleRowKeysRequest on an authorized view.
    assertThat(SampleRowKeysRequest.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID)))
        .isEqualTo(SampleRowKeysRequest.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID)));
    assertThat(
            SampleRowKeysRequest.create(AuthorizedViewId.of("another-table", AUTHORIZED_VIEW_ID)))
        .isNotEqualTo(
            SampleRowKeysRequest.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID)));
    assertThat(
            SampleRowKeysRequest.create(AuthorizedViewId.of(TABLE_ID, "another-authorized-view")))
        .isNotEqualTo(
            SampleRowKeysRequest.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID)));

    assertThat(SampleRowKeysRequest.create(AuthorizedViewId.of(TABLE_ID, AUTHORIZED_VIEW_ID)))
        .isNotEqualTo(SampleRowKeysRequest.create(TableId.of(TABLE_ID)));
  }
}
