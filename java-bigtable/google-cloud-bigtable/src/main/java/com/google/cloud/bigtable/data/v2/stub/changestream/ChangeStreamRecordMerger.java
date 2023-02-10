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

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecordAdapter;
import com.google.cloud.bigtable.gaxx.reframing.Reframer;
import com.google.cloud.bigtable.gaxx.reframing.ReframingResponseObserver;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * An implementation of a {@link Reframer} that feeds the change stream record merging {@link
 * ChangeStreamStateMachine}.
 *
 * <p>{@link ReframingResponseObserver} pushes {@link ReadChangeStreamResponse}s into this class and
 * pops a change stream record containing one of the following: 1) Heartbeat. 2) CloseStream. 3)
 * ChangeStreamMutation(a representation of a fully merged logical mutation).
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * ChangeStreamRecordMerger<ChangeStreamRecord> changeStreamRecordMerger =
 *     new ChangeStreamRecordMerger<>(myChangeStreamRecordAdaptor);
 *
 * while(responseIterator.hasNext()) {
 *   ReadChangeStreamResponse response = responseIterator.next();
 *
 *   if (changeStreamRecordMerger.hasFullFrame()) {
 *     ChangeStreamRecord changeStreamRecord = changeStreamRecordMerger.pop();
 *     // Do something with change stream record.
 *   } else {
 *     changeStreamRecordMerger.push(response);
 *   }
 * }
 *
 * if (changeStreamRecordMerger.hasPartialFrame()) {
 *   throw new RuntimeException("Incomplete stream");
 * }
 *
 * }</pre>
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 *
 * <p>Package-private for internal use.
 *
 * @see ReframingResponseObserver for more details
 */
@InternalApi
public class ChangeStreamRecordMerger<ChangeStreamRecordT>
    implements Reframer<ChangeStreamRecordT, ReadChangeStreamResponse> {
  private final ChangeStreamStateMachine<ChangeStreamRecordT> changeStreamStateMachine;
  private final Queue<ChangeStreamRecordT> changeStreamRecord;

  public ChangeStreamRecordMerger(
      ChangeStreamRecordAdapter.ChangeStreamRecordBuilder<ChangeStreamRecordT>
          changeStreamRecordBuilder) {
    changeStreamStateMachine = new ChangeStreamStateMachine<>(changeStreamRecordBuilder);
    changeStreamRecord = new ArrayDeque<>();
  }

  @Override
  public void push(ReadChangeStreamResponse response) {
    switch (response.getStreamRecordCase()) {
      case HEARTBEAT:
        changeStreamStateMachine.handleHeartbeat(response.getHeartbeat());
        break;
      case CLOSE_STREAM:
        changeStreamStateMachine.handleCloseStream(response.getCloseStream());
        break;
      case DATA_CHANGE:
        changeStreamStateMachine.handleDataChange(response.getDataChange());
        break;
      case STREAMRECORD_NOT_SET:
        throw new IllegalStateException("Illegal stream record.");
    }
    if (changeStreamStateMachine.hasCompleteChangeStreamRecord()) {
      changeStreamRecord.add(changeStreamStateMachine.consumeChangeStreamRecord());
    }
  }

  @Override
  public boolean hasFullFrame() {
    return !changeStreamRecord.isEmpty();
  }

  @Override
  public boolean hasPartialFrame() {
    // Check if buffer in this class contains data. If an assembled is still not available, then
    // that means `buffer` has been fully consumed. The last place to check is the
    // ChangeStreamStateMachine buffer, to see if it's holding on to an incomplete change
    // stream record.
    return hasFullFrame() || changeStreamStateMachine.isChangeStreamRecordInProgress();
  }

  @Override
  public ChangeStreamRecordT pop() {
    return Preconditions.checkNotNull(
        changeStreamRecord.poll(),
        "ChangeStreamRecordMerger.pop() called when there are no change stream records.");
  }
}
