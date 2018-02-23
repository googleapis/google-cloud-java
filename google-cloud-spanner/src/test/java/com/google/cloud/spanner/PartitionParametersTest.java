/*
 * Copyright 2017 Google LLC
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

import static com.google.common.truth.Truth.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.PartitionParameters}. */
@RunWith(JUnit4.class)
public class PartitionParametersTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Test
  public void builder() {
    int desiredBytesPerBatch = 1 << 30;
    int maxPartitionCount = 100;
    PartitionParameters parameters = 
        PartitionParameters.newBuilder()
            .setDesiredBytesPerBatch(desiredBytesPerBatch)
            .setMaxPartitionCount(maxPartitionCount)
            .build();
    assertThat(parameters.getDesiredBytesPerBatch()).isEqualTo(desiredBytesPerBatch);
    assertThat(parameters.getMaxPartitionCount()).isEqualTo(maxPartitionCount);
  }
  
  @Test
  public void emptyBuilder() {
    PartitionParameters parameters = PartitionParameters.newBuilder().build();
    assertThat(parameters.getDesiredBytesPerBatch()).isEqualTo(null);
    assertThat(parameters.getMaxPartitionCount()).isEqualTo(null);
  }
  
  @Test
  public void defaultBuilder() {
    PartitionParameters parameters = PartitionParameters.getDefaultInstance();
    assertThat(parameters.getDesiredBytesPerBatch()).isEqualTo(null);
    assertThat(parameters.getMaxPartitionCount()).isEqualTo(null);
  }
  
  @Test
  public void invalidDesiredBytesPerBatch() {
    expectedException.expect(IllegalArgumentException.class);
    PartitionParameters.newBuilder().setDesiredBytesPerBatch(-1).build();
  }
  
  @Test
  public void invalidMaxPartitionCount() {
    expectedException.expect(IllegalArgumentException.class);
    PartitionParameters.newBuilder().setMaxPartitionCount(-1).build();
  }
}
