/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.api;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.Row;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.bigtable.v2.SessionReadRowsRequest;
import com.google.bigtable.v2.SessionReadRowsResponse;
import com.google.protobuf.ByteString;
import org.junit.jupiter.api.Test;

public class SessionReadRowsResumptionStrategyTest {

  @Test
  void emptyLastKey_returnsOriginalRequest() {
    SessionReadRowsResumptionStrategy strategy = new SessionReadRowsResumptionStrategy();
    SessionReadRowsRequest original = request(range("a", "z"), 10);

    // Nothing delivered yet, so the resume request is the original object unchanged.
    assertThat(strategy.getResumeRequest(original)).isSameInstanceAs(original);
    assertThat(strategy.getLastKey()).isEqualTo(ByteString.EMPTY);
    assertThat(strategy.getNumProcessed()).isEqualTo(0);
  }

  @Test
  void onResponse_tracksLastKeyAndCount() {
    SessionReadRowsResumptionStrategy strategy = new SessionReadRowsResumptionStrategy();

    strategy.onResponse(response("a", "b", "c"));
    assertThat(strategy.getLastKey()).isEqualTo(bs("c"));
    assertThat(strategy.getNumProcessed()).isEqualTo(3);

    strategy.onResponse(response("d"));
    assertThat(strategy.getLastKey()).isEqualTo(bs("d"));
    assertThat(strategy.getNumProcessed()).isEqualTo(4);
  }

  @Test
  void onResponse_emptyResponse_leavesStateUnchanged() {
    SessionReadRowsResumptionStrategy strategy = new SessionReadRowsResumptionStrategy();

    strategy.onResponse(SessionReadRowsResponse.getDefaultInstance());

    assertThat(strategy.getLastKey()).isEqualTo(ByteString.EMPTY);
    assertThat(strategy.getNumProcessed()).isEqualTo(0);
  }

  @Test
  void getResumeRequest_narrowsForwardRangeAndShrinksLimit() {
    SessionReadRowsResumptionStrategy strategy = new SessionReadRowsResumptionStrategy();
    SessionReadRowsRequest original = request(range("a", "z"), 10);

    strategy.onResponse(response("a", "b", "c"));

    SessionReadRowsRequest resume = strategy.getResumeRequest(original);

    // Everything at or before "c" is excluded; the remaining scan opens just past "c".
    RowSet expectedRows =
        RowSet.newBuilder()
            .addRowRanges(RowRange.newBuilder().setStartKeyOpen(bs("c")).setEndKeyOpen(bs("z")))
            .build();
    assertThat(resume.getRows()).isEqualTo(expectedRows);
    assertThat(resume.getRowsLimit()).isEqualTo(7);
  }

  @Test
  void getResumeRequest_shrinksLimitAcrossMultipleBatches() {
    SessionReadRowsResumptionStrategy strategy = new SessionReadRowsResumptionStrategy();
    SessionReadRowsRequest original = request(range("a", "z"), 10);

    strategy.onResponse(response("a", "b"));
    strategy.onResponse(response("c"));

    SessionReadRowsRequest resume = strategy.getResumeRequest(original);

    assertThat(resume.getRows().getRowRanges(0).getStartKeyOpen()).isEqualTo(bs("c"));
    assertThat(resume.getRowsLimit()).isEqualTo(7);
  }

  @Test
  void getResumeRequest_narrowsReversedRange() {
    SessionReadRowsResumptionStrategy strategy = new SessionReadRowsResumptionStrategy();
    SessionReadRowsRequest original =
        request(range("a", "z"), 0).toBuilder().setReversed(true).build();

    // Reversed scan walks from the end, so "x" is the last (lowest) key delivered so far.
    strategy.onResponse(response("y", "x"));

    SessionReadRowsRequest resume = strategy.getResumeRequest(original);

    // Everything at or after "x" is excluded; the remaining scan ends just below "x".
    RowSet expectedRows =
        RowSet.newBuilder()
            .addRowRanges(RowRange.newBuilder().setStartKeyClosed(bs("a")).setEndKeyOpen(bs("x")))
            .build();
    assertThat(resume.getRows()).isEqualTo(expectedRows);
    assertThat(resume.getReversed()).isTrue();
    // No limit was set, so none is imposed on resume.
    assertThat(resume.getRowsLimit()).isEqualTo(0);
  }

  @Test
  void getResumeRequest_returnsNullWhenRowLimitReached() {
    SessionReadRowsResumptionStrategy strategy = new SessionReadRowsResumptionStrategy();
    SessionReadRowsRequest original = request(range("a", "z"), 3);

    strategy.onResponse(response("a", "b", "c"));

    // The row limit has been fully satisfied, so the scan is complete.
    assertThat(strategy.getResumeRequest(original)).isNull();
  }

  @Test
  void getResumeRequest_returnsNullWhenAllRangesConsumed() {
    SessionReadRowsResumptionStrategy strategy = new SessionReadRowsResumptionStrategy();
    SessionReadRowsRequest original =
        SessionReadRowsRequest.newBuilder()
            .setRows(RowSet.newBuilder().addRowKeys(bs("a")))
            .build();

    strategy.onResponse(response("a"));

    // The only requested key was delivered, so erasing it leaves nothing to read.
    assertThat(strategy.getResumeRequest(original)).isNull();
  }

  private static ByteString bs(String s) {
    return ByteString.copyFromUtf8(s);
  }

  private static RowSet range(String startClosed, String endOpen) {
    return RowSet.newBuilder()
        .addRowRanges(
            RowRange.newBuilder().setStartKeyClosed(bs(startClosed)).setEndKeyOpen(bs(endOpen)))
        .build();
  }

  private static SessionReadRowsRequest request(RowSet rows, long rowsLimit) {
    SessionReadRowsRequest.Builder builder = SessionReadRowsRequest.newBuilder().setRows(rows);
    if (rowsLimit > 0) {
      builder.setRowsLimit(rowsLimit);
    }
    return builder.build();
  }

  private static SessionReadRowsResponse response(String... keys) {
    SessionReadRowsResponse.Builder builder = SessionReadRowsResponse.newBuilder();
    for (String key : keys) {
      builder.addRow(Row.newBuilder().setKey(bs(key)));
    }
    return builder.build();
  }
}
