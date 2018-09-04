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
package com.google.cloud.bigtable.admin.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.TableName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConsistencyTokenTest {
  private static final InstanceName INSTANCE_NAME = InstanceName.of("my-project", "my-instance");
  private static final TableName TABLE_NAME = TableName.of(INSTANCE_NAME.getProject(), INSTANCE_NAME.getInstance(), "my-table");
  private static final String TOKEN_VALUE = "87282hgwd8yg";

  @Test
  public void testToProto() {
    ConsistencyToken token = ConsistencyToken.of(TABLE_NAME, TOKEN_VALUE);

    assertThat(token.toProto(INSTANCE_NAME)).isEqualTo(
        CheckConsistencyRequest.newBuilder()
          .setName(TABLE_NAME.toString())
          .setConsistencyToken(TOKEN_VALUE)
          .build()
    );
  }

  @Test
  public void testInstanceMismatch() {
    ConsistencyToken token = ConsistencyToken.of(TABLE_NAME, TOKEN_VALUE);

    InstanceName otherInstanceName = InstanceName.of("my-project", "other-instance");

    Exception actualError = null;

    try {
      token.toProto(otherInstanceName);
    } catch (Exception e) {
      actualError = e;
    }

    assertThat(actualError).isInstanceOf(IllegalArgumentException.class);
  }
}
