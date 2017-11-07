/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import static com.google.common.testing.SerializableTester.reserializeAndAssert;

import com.google.cloud.Timestamp;
import com.google.common.testing.EqualsTester;
import com.google.protobuf.ByteString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.BatchTransactionId}. */
@RunWith(JUnit4.class)
public class BatchTransactionIdTest {

  @Test
  public void equalAndHashCode() {
    new EqualsTester()
        .addEqualityGroup(
            new BatchTransactionId(
                "testSession", ByteString.copyFromUtf8("testTxn"), Timestamp.MIN_VALUE),
            new BatchTransactionId(
                "testSession", ByteString.copyFromUtf8("testTxn"), Timestamp.MIN_VALUE))
        .addEqualityGroup(
            new BatchTransactionId(
                "testSession", ByteString.copyFromUtf8("testTxn"), Timestamp.MAX_VALUE),
            new BatchTransactionId(
                "testSession", ByteString.copyFromUtf8("testTxn"), Timestamp.MAX_VALUE))
        .testEquals();
  }

  @Test
  public void serialization() {
    reserializeAndAssert(
        new BatchTransactionId(
            "testSession", ByteString.copyFromUtf8("testTxn"), Timestamp.MIN_VALUE));
  }
}
