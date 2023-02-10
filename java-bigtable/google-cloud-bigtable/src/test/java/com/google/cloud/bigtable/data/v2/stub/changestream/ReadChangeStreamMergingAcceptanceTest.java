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
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.client.util.Lists;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.bigtable.v2.ReadChangeStreamResponse.DataChange.Type;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.StreamContinuationToken;
import com.google.bigtable.v2.StreamPartition;
import com.google.bigtable.v2.TimestampRange;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamContinuationToken;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamMutation;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecord;
import com.google.cloud.bigtable.data.v2.models.CloseStream;
import com.google.cloud.bigtable.data.v2.models.DefaultChangeStreamRecordAdapter;
import com.google.cloud.bigtable.data.v2.models.DeleteCells;
import com.google.cloud.bigtable.data.v2.models.DeleteFamily;
import com.google.cloud.bigtable.data.v2.models.Entry;
import com.google.cloud.bigtable.data.v2.models.Heartbeat;
import com.google.cloud.bigtable.data.v2.models.SetCell;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi;
import com.google.cloud.conformance.bigtable.v2.ChangeStreamTestDefinition.ChangeStreamTestFile;
import com.google.cloud.conformance.bigtable.v2.ChangeStreamTestDefinition.ReadChangeStreamTest;
import com.google.common.base.CaseFormat;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.Timestamps;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Parses and runs the acceptance tests for read change stream. Currently, this test is only used by
 * the JAVA library. If in the future we need cross-language support, we should move the test proto
 * to <a
 * href="https://github.com/googleapis/conformance-tests/tree/main/bigtable/v2/proto/google/cloud/conformance/bigtable/v2">https://github.com/googleapis/conformance-tests/tree/main/bigtable/v2/proto/google/cloud/conformance/bigtable/v2</a>
 * and the test data to <a
 * href="https://github.com/googleapis/conformance-tests/blob/main/bigtable/v2/changestream.json">https://github.com/googleapis/conformance-tests/blob/main/bigtable/v2/changestream.json</a>
 */
@RunWith(Parameterized.class)
public class ReadChangeStreamMergingAcceptanceTest {
  // Location: `google-cloud-bigtable/src/test/resources/changestream.json`
  private static final String TEST_DATA_JSON_RESOURCE = "changestream.json";

  private final ReadChangeStreamTest testCase;

  /**
   * @param testData The serialized test data representing the test case.
   * @param junitName Not used by the test, but used by the parameterized test runner as the name of
   *     the test.
   */
  public ReadChangeStreamMergingAcceptanceTest(
      ReadChangeStreamTest testData, @SuppressWarnings("unused") String junitName) {
    this.testCase = testData;
  }

  // Each tuple consists of [testData: ReadChangeStreamTest, junitName: String]
  @Parameterized.Parameters(name = "{1}")
  public static Collection<Object[]> data() throws IOException {
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    InputStream dataJson = cl.getResourceAsStream(TEST_DATA_JSON_RESOURCE);
    assertWithMessage("Unable to load test definition: %s", TEST_DATA_JSON_RESOURCE)
        .that(dataJson)
        .isNotNull();

    InputStreamReader reader = new InputStreamReader(dataJson);
    ChangeStreamTestFile.Builder testBuilder = ChangeStreamTestFile.newBuilder();
    JsonFormat.parser().merge(reader, testBuilder);
    ChangeStreamTestFile testDefinition = testBuilder.build();

    List<ReadChangeStreamTest> tests = testDefinition.getReadChangeStreamTestsList();
    ArrayList<Object[]> data = new ArrayList<>(tests.size());
    for (ReadChangeStreamTest test : tests) {
      String junitName =
          CaseFormat.LOWER_HYPHEN.to(
              CaseFormat.LOWER_CAMEL, test.getDescription().replace(" ", "-"));
      data.add(new Object[] {test, junitName});
    }
    return data;
  }

  @Test
  public void test() throws Exception {
    List<ReadChangeStreamResponse> responses = testCase.getApiResponsesList();

    // Wrap the responses in a callable.
    ServerStreamingCallable<ReadChangeStreamRequest, ReadChangeStreamResponse> source =
        new FakeStreamingApi.ServerStreamingStashCallable<>(responses);
    ChangeStreamRecordMergingCallable<ChangeStreamRecord> mergingCallable =
        new ChangeStreamRecordMergingCallable<>(source, new DefaultChangeStreamRecordAdapter());

    // Invoke the callable to get the change stream records.
    ServerStream<ChangeStreamRecord> stream =
        mergingCallable.call(ReadChangeStreamRequest.getDefaultInstance());

    // Transform the change stream records into ReadChangeStreamTest.Result's.
    List<ReadChangeStreamTest.Result> actualResults = Lists.newArrayList();
    Exception error = null;
    try {
      for (ChangeStreamRecord record : stream) {
        if (record instanceof Heartbeat) {
          Heartbeat heartbeat = (Heartbeat) record;
          ChangeStreamContinuationToken token = heartbeat.getChangeStreamContinuationToken();
          ReadChangeStreamResponse.Heartbeat heartbeatProto =
              ReadChangeStreamResponse.Heartbeat.newBuilder()
                  .setContinuationToken(
                      StreamContinuationToken.newBuilder()
                          .setPartition(
                              StreamPartition.newBuilder()
                                  .setRowRange(
                                      RowRange.newBuilder()
                                          .setStartKeyClosed(token.getPartition().getStart())
                                          .setEndKeyOpen(token.getPartition().getEnd())
                                          .build())
                                  .build())
                          .setToken(heartbeat.getChangeStreamContinuationToken().getToken())
                          .build())
                  .setEstimatedLowWatermark(heartbeat.getEstimatedLowWatermark())
                  .build();
          actualResults.add(
              ReadChangeStreamTest.Result.newBuilder()
                  .setRecord(
                      ReadChangeStreamTest.TestChangeStreamRecord.newBuilder()
                          .setHeartbeat(heartbeatProto)
                          .build())
                  .build());
        } else if (record instanceof CloseStream) {
          CloseStream closeStream = (CloseStream) record;
          ReadChangeStreamResponse.CloseStream.Builder builder =
              ReadChangeStreamResponse.CloseStream.newBuilder().setStatus(closeStream.getStatus());
          for (ChangeStreamContinuationToken token :
              closeStream.getChangeStreamContinuationTokens()) {
            builder.addContinuationTokens(
                StreamContinuationToken.newBuilder()
                    .setPartition(
                        StreamPartition.newBuilder()
                            .setRowRange(
                                RowRange.newBuilder()
                                    .setStartKeyClosed(token.getPartition().getStart())
                                    .setEndKeyOpen(token.getPartition().getEnd())
                                    .build()))
                    .setToken(token.getToken())
                    .build());
          }
          ReadChangeStreamResponse.CloseStream closeStreamProto = builder.build();
          actualResults.add(
              ReadChangeStreamTest.Result.newBuilder()
                  .setRecord(
                      ReadChangeStreamTest.TestChangeStreamRecord.newBuilder()
                          .setCloseStream(closeStreamProto)
                          .build())
                  .build());
        } else if (record instanceof ChangeStreamMutation) {
          ChangeStreamMutation changeStreamMutation = (ChangeStreamMutation) record;
          ReadChangeStreamTest.TestChangeStreamMutation.Builder builder =
              ReadChangeStreamTest.TestChangeStreamMutation.newBuilder();
          builder.setRowKey(changeStreamMutation.getRowKey());
          Type type = Type.UNRECOGNIZED;
          if (changeStreamMutation.getType() == ChangeStreamMutation.MutationType.USER) {
            type = Type.USER;
          } else if (changeStreamMutation.getType()
              == ChangeStreamMutation.MutationType.GARBAGE_COLLECTION) {
            type = Type.GARBAGE_COLLECTION;
          }
          builder.setType(type);
          if (changeStreamMutation.getSourceClusterId() != null) {
            builder.setSourceClusterId(changeStreamMutation.getSourceClusterId());
          }
          builder.setCommitTimestamp(
              Timestamps.fromNanos(changeStreamMutation.getCommitTimestamp()));
          builder.setTiebreaker(changeStreamMutation.getTieBreaker());
          builder.setToken(changeStreamMutation.getToken());
          builder.setEstimatedLowWatermark(
              Timestamps.fromNanos(changeStreamMutation.getEstimatedLowWatermark()));
          for (Entry entry : changeStreamMutation.getEntries()) {
            if (entry instanceof DeleteFamily) {
              DeleteFamily deleteFamily = (DeleteFamily) entry;
              builder.addMutations(
                  Mutation.newBuilder()
                      .setDeleteFromFamily(
                          Mutation.DeleteFromFamily.newBuilder()
                              .setFamilyName(deleteFamily.getFamilyName())
                              .build()));
            } else if (entry instanceof DeleteCells) {
              DeleteCells deleteCells = (DeleteCells) entry;
              builder.addMutations(
                  Mutation.newBuilder()
                      .setDeleteFromColumn(
                          Mutation.DeleteFromColumn.newBuilder()
                              .setFamilyName(deleteCells.getFamilyName())
                              .setColumnQualifier(deleteCells.getQualifier())
                              .setTimeRange(
                                  TimestampRange.newBuilder()
                                      .setStartTimestampMicros(
                                          deleteCells.getTimestampRange().getStart())
                                      .setEndTimestampMicros(
                                          deleteCells.getTimestampRange().getEnd())
                                      .build())
                              .build()));
            } else if (entry instanceof SetCell) {
              SetCell setCell = (SetCell) entry;
              builder.addMutations(
                  Mutation.newBuilder()
                      .setSetCell(
                          Mutation.SetCell.newBuilder()
                              .setFamilyName(setCell.getFamilyName())
                              .setColumnQualifier(setCell.getQualifier())
                              .setTimestampMicros(setCell.getTimestamp())
                              .setValue(setCell.getValue())));
            } else {
              throw new IllegalStateException("Unexpected Entry type");
            }
          }
          actualResults.add(
              ReadChangeStreamTest.Result.newBuilder()
                  .setRecord(
                      ReadChangeStreamTest.TestChangeStreamRecord.newBuilder()
                          .setChangeStreamMutation(builder))
                  .build());
        } else {
          throw new IllegalStateException("Unexpected ChangeStreamRecord type");
        }
      }
    } catch (Exception e) {
      error = e;
    }

    // Verify the results.
    if (expectsError(testCase)) {
      assertThat(error).isNotNull();
    } else {
      if (error != null) {
        throw error;
      }
    }

    assertThat(getNonExceptionResults(testCase)).isEqualTo(actualResults);
  }

  private static boolean expectsError(ReadChangeStreamTest testCase) {
    List<ReadChangeStreamTest.Result> results = testCase.getResultsList();
    return results != null && !results.isEmpty() && results.get(results.size() - 1).getError();
  }

  private static List<ReadChangeStreamTest.Result> getNonExceptionResults(
      ReadChangeStreamTest testCase) {
    List<ReadChangeStreamTest.Result> results = testCase.getResultsList();
    List<ReadChangeStreamTest.Result> response = new ArrayList<>();
    if (results != null) {
      for (ReadChangeStreamTest.Result result : results) {
        if (!result.getError()) {
          response.add(result);
        }
      }
    }
    return response;
  }
}
