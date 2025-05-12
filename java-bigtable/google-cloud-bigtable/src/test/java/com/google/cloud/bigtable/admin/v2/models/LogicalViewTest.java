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

package com.google.cloud.bigtable.admin.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.LogicalViewName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LogicalViewTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String LOGICAL_VIEW_ID = "my-logical-view";

  @Test
  public void testFromProto() {
    LogicalViewName logicalViewName = LogicalViewName.of(PROJECT_ID, INSTANCE_ID, LOGICAL_VIEW_ID);

    com.google.bigtable.admin.v2.LogicalView logicalViewProto =
        com.google.bigtable.admin.v2.LogicalView.newBuilder()
            .setName(logicalViewName.toString())
            .setQuery("SELECT 1 from Table")
            .setDeletionProtection(true)
            .build();

    LogicalView result = LogicalView.fromProto(logicalViewProto);

    assertThat(result.getId()).isEqualTo(LOGICAL_VIEW_ID);
    assertThat(result.getQuery()).isEqualTo("SELECT 1 from Table");
    assertThat(result.isDeletionProtected()).isEqualTo(true);
  }

  @Test
  public void testRequiresName() {
    com.google.bigtable.admin.v2.LogicalView proto =
        com.google.bigtable.admin.v2.LogicalView.newBuilder()
            .setQuery("SELECT 1 FROM Table")
            .build();

    Exception actualException = null;

    try {
      LogicalView.fromProto(proto);
    } catch (Exception e) {
      actualException = e;
    }

    assertThat(actualException).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testEquality() {
    LogicalViewName logicalViewName = LogicalViewName.of(PROJECT_ID, INSTANCE_ID, LOGICAL_VIEW_ID);
    com.google.bigtable.admin.v2.LogicalView proto =
        com.google.bigtable.admin.v2.LogicalView.newBuilder()
            .setName(logicalViewName.toString())
            .setQuery("SELECT 1 FROM Table")
            .setDeletionProtection(true)
            .build();
    LogicalView logicalView = LogicalView.fromProto(proto);

    assertThat(logicalView).isEqualTo(LogicalView.fromProto(proto));

    assertThat(logicalView)
        .isNotEqualTo(
            com.google.bigtable.admin.v2.LogicalView.newBuilder()
                .setName(logicalViewName.toString())
                .setQuery("SELECT 2 FROM Table")
                .setDeletionProtection(true)
                .build());
  }

  @Test
  public void testHashCode() {
    LogicalViewName logicalViewName = LogicalViewName.of(PROJECT_ID, INSTANCE_ID, LOGICAL_VIEW_ID);
    com.google.bigtable.admin.v2.LogicalView proto =
        com.google.bigtable.admin.v2.LogicalView.newBuilder()
            .setName(logicalViewName.toString())
            .setQuery("SELECT 1 FROM Table")
            .setDeletionProtection(true)
            .build();
    LogicalView logicalView = LogicalView.fromProto(proto);

    assertThat(logicalView.hashCode()).isEqualTo(LogicalView.fromProto(proto).hashCode());

    assertThat(logicalView.hashCode())
        .isNotEqualTo(
            com.google.bigtable.admin.v2.LogicalView.newBuilder()
                .setName(logicalViewName.toString())
                .setQuery("SELECT 2 FROM Table")
                .setDeletionProtection(true)
                .build()
                .hashCode());
  }
}
