/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.changestream;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecord;
import com.google.cloud.bigtable.data.v2.models.DefaultChangeStreamRecordAdapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ChangeStreamStateMachineTest {
  ChangeStreamStateMachine<ChangeStreamRecord> changeStreamStateMachine;

  @Before
  public void setUp() throws Exception {
    changeStreamStateMachine =
        new ChangeStreamStateMachine<>(
            new DefaultChangeStreamRecordAdapter().createChangeStreamRecordBuilder());
  }

  @Test
  public void testErrorHandlingStats() {
    ReadChangeStreamResponse.DataChange dataChange =
        ReadChangeStreamResponse.DataChange.newBuilder().build();

    ChangeStreamStateMachine.InvalidInputException actualError = null;
    try {
      changeStreamStateMachine.handleDataChange(dataChange);
    } catch (ChangeStreamStateMachine.InvalidInputException e) {
      actualError = e;
    }

    assertThat(actualError)
        .hasMessageThat()
        .containsMatch("AWAITING_NEW_STREAM_RECORD: First data change missing rowKey");
    assertThat(actualError).hasMessageThat().contains("numHeartbeats: 0");
    assertThat(actualError).hasMessageThat().contains("numCloseStreams: 0");
    assertThat(actualError).hasMessageThat().contains("numDataChanges: 1");
    assertThat(actualError).hasMessageThat().contains("numNonCellMods: 0");
    assertThat(actualError).hasMessageThat().contains("numCellChunks: 0");
    assertThat(actualError).hasMessageThat().contains("actualTotalSizeOfChunkedSetCell: 0");
  }
}
