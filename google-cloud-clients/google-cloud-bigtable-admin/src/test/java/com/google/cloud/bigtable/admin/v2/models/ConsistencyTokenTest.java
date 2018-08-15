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

import static org.junit.Assert.assertEquals;

import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConsistencyTokenTest {
  @Test
  public void fromJsonTest() {
    ConsistencyToken tokenResponse =
        ConsistencyToken.fromProto(
            GenerateConsistencyTokenResponse.newBuilder()
                .setConsistencyToken("87282hgwd8yg")
                .build());

    assertEquals("87282hgwd8yg", tokenResponse.getToken());
  }
}
