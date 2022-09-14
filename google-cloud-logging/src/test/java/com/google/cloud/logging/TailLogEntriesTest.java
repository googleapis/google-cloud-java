/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;

import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.ServiceOptions;
import com.google.cloud.logging.Logging.TailOption;
import com.google.cloud.logging.spi.LoggingRpcFactory;
import com.google.cloud.logging.spi.v2.LoggingRpc;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import com.google.protobuf.Duration;
import com.google.protobuf.util.Durations;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TailLogEntriesTest {
  private static final String WINDOW = "20s";
  private static final Duration WINDOW_DURATION = Durations.fromSeconds(20);
  private static final String FILTER = "severity<INFO";
  private static final String PROJECT_ID = "test-project-id";
  private static final String DEFAULT_PROJECT_ID = "test-default-project-id";
  private static final String BILLING_ACCOUNT_ID = "test-billing-acc-number";
  private static final String FOLDER_ID = "test-folder-id";
  private static final String ORG_ID = "test-org-id";

  @Test
  public void testTailOptions() {
    TailLogEntriesRequest request =
        LoggingImpl.buildTailLogEntriesRequest(
            LoggingImpl.optionMap(
                TailOption.filter(FILTER),
                TailOption.bufferWindow(WINDOW),
                TailOption.project(PROJECT_ID),
                TailOption.billingAccount(BILLING_ACCOUNT_ID),
                TailOption.folder(FOLDER_ID),
                TailOption.organization(ORG_ID)),
            DEFAULT_PROJECT_ID);

    assertThat(request.getFilter()).isEqualTo(FILTER);
    assertThat(request.getBufferWindow()).isEqualTo(WINDOW_DURATION);
    assertThat(request.getResourceNamesList())
        .containsExactly(
            "projects/" + PROJECT_ID,
            "organizations/" + ORG_ID,
            "billingAccounts/" + BILLING_ACCOUNT_ID,
            "folders/" + FOLDER_ID);
  }

  @Test
  public void testEmptyTailOptions() {
    TailLogEntriesRequest request =
        LoggingImpl.buildTailLogEntriesRequest(LoggingImpl.optionMap(), DEFAULT_PROJECT_ID);
    assertThat(request.getFilter()).isEmpty();
    assertThat(request.getBufferWindow()).isEqualTo(Duration.getDefaultInstance());
    assertThat(request.getResourceNamesList()).containsExactly("projects/" + DEFAULT_PROJECT_ID);
  }

  @Test
  public void testBidiStreamSendIsCalled() {
    // setup
    LoggingRpcFactory rpcFactoryMock = EasyMock.createStrictMock(LoggingRpcFactory.class);
    LoggingRpc loggingRpcMock = EasyMock.createStrictMock(LoggingRpc.class);
    BidiStream<TailLogEntriesRequest, TailLogEntriesResponse> bidiStreamMock =
        EasyMock.createStrictMock(BidiStream.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(LoggingOptions.class)))
        .andReturn(loggingRpcMock);
    EasyMock.expect(loggingRpcMock.getTailLogEntriesStream()).andReturn(bidiStreamMock);
    bidiStreamMock.send(EasyMock.anyObject(TailLogEntriesRequest.class));
    EasyMock.expectLastCall().andAnswer(() -> null);
    EasyMock.replay(rpcFactoryMock, loggingRpcMock, bidiStreamMock);

    // execute
    LoggingOptions options =
        LoggingOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setServiceRpcFactory(rpcFactoryMock)
            .setRetrySettings(ServiceOptions.getNoRetrySettings())
            .build();
    Logging logging = options.getService();
    LogEntryServerStream stream = logging.tailLogEntries();

    // verify
    assertNotNull(stream);
    EasyMock.verify(bidiStreamMock);
  }
}
