/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.storage.Retrying.RetrierWithAlg;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.storage.v2.StartResumableWriteRequest;
import com.google.storage.v2.StartResumableWriteResponse;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * For our {@link GapicUploadSessionBuilder} a number of items must be provided to ultimately
 * construct an instance. This class enumerates some supported usage patterns whether using the
 * fluent api from beginning to build or if intermediate variables must be defined along the way.
 *
 * <p>These "tests" are primarily validated at compilation time - ensuring source compatibility of
 * the builders. Each builder is built which runs some minor validation - such as null checks - but
 * otherwise does not have any other logic.
 */
@RunWith(MockitoJUnitRunner.class)
public final class GapicUploadSessionBuilderSyntaxTest {

  private final WriteObjectRequest req = WriteObjectRequest.getDefaultInstance();

  // The following fields are "mocks" for simplicity’s sake.
  // We need them to be non-null, but otherwise they do not matter.
  // They have many dependencies which would need to be constructed in order to instantiate a
  // literal instance.
  @Mock private ClientStreamingCallable<WriteObjectRequest, WriteObjectResponse> write;

  @Mock
  private UnaryCallable<StartResumableWriteRequest, StartResumableWriteResponse>
      startResumableWrite;

  @Before
  public void setUp() throws Exception {
    when(startResumableWrite.call(any()))
        .thenReturn(StartResumableWriteResponse.getDefaultInstance());
  }

  @Test
  public void syntax_directUnbuffered_fluent() {
    UnbufferedWritableByteChannelSession<WriteObjectResponse> session =
        ResumableMedia.gapic()
            .write()
            .byteChannel(write)
            .setHasher(Hasher.noop())
            .setByteStringStrategy(ByteStringStrategy.noCopy())
            .direct()
            .unbuffered()
            .setRequest(req)
            .build();
  }

  @Test
  public void syntax_directBuffered_fluent() {
    BufferedWritableByteChannelSession<WriteObjectResponse> session =
        ResumableMedia.gapic()
            .write()
            .byteChannel(write)
            .setHasher(Hasher.noop())
            .setByteStringStrategy(ByteStringStrategy.noCopy())
            .direct()
            .buffered()
            .setRequest(req)
            .build();
  }

  @Test
  public void syntax_resumableUnbuffered_fluent() {
    ApiFuture<ResumableWrite> startAsync =
        ResumableMedia.gapic()
            .write()
            .resumableWrite(startResumableWrite, req, Opts.empty(), RetrierWithAlg.attemptOnce());
    UnbufferedWritableByteChannelSession<WriteObjectResponse> session =
        ResumableMedia.gapic()
            .write()
            .byteChannel(write)
            .setHasher(Hasher.noop())
            .setByteStringStrategy(ByteStringStrategy.noCopy())
            .resumable()
            .unbuffered()
            .setStartAsync(startAsync)
            .build();
  }

  @Test
  public void syntax_resumableBuffered_fluent() {
    ApiFuture<ResumableWrite> startAsync =
        ResumableMedia.gapic()
            .write()
            .resumableWrite(startResumableWrite, req, Opts.empty(), RetrierWithAlg.attemptOnce());
    BufferedWritableByteChannelSession<WriteObjectResponse> session =
        ResumableMedia.gapic()
            .write()
            .byteChannel(write)
            .setHasher(Hasher.noop())
            .setByteStringStrategy(ByteStringStrategy.noCopy())
            .resumable()
            .buffered()
            .setStartAsync(startAsync)
            .build();
  }

  @Test
  public void syntax_directUnbuffered_incremental() {
    GapicWritableByteChannelSessionBuilder b1 =
        ResumableMedia.gapic()
            .write()
            .byteChannel(write)
            .setHasher(Hasher.noop())
            .setByteStringStrategy(ByteStringStrategy.noCopy());
    UnbufferedWritableByteChannelSession<WriteObjectResponse> session =
        b1.direct().unbuffered().setRequest(req).build();
  }

  @Test
  public void syntax_directBuffered_incremental() {
    GapicWritableByteChannelSessionBuilder b1 =
        ResumableMedia.gapic()
            .write()
            .byteChannel(write)
            .setHasher(Hasher.noop())
            .setByteStringStrategy(ByteStringStrategy.noCopy());
    BufferedWritableByteChannelSession<WriteObjectResponse> session =
        b1.direct().buffered().setRequest(req).build();
  }

  @Test
  public void syntax_resumableUnbuffered_incremental() {
    ApiFuture<ResumableWrite> startAsync =
        ResumableMedia.gapic()
            .write()
            .resumableWrite(startResumableWrite, req, Opts.empty(), RetrierWithAlg.attemptOnce());
    GapicWritableByteChannelSessionBuilder b1 =
        ResumableMedia.gapic()
            .write()
            .byteChannel(write)
            .setHasher(Hasher.noop())
            .setByteStringStrategy(ByteStringStrategy.noCopy());
    UnbufferedWritableByteChannelSession<WriteObjectResponse> session =
        b1.resumable().unbuffered().setStartAsync(startAsync).build();
  }

  @Test
  public void syntax_resumableBuffered_incremental() {
    ApiFuture<ResumableWrite> startAsync =
        ResumableMedia.gapic()
            .write()
            .resumableWrite(startResumableWrite, req, Opts.empty(), RetrierWithAlg.attemptOnce());
    GapicWritableByteChannelSessionBuilder b1 =
        ResumableMedia.gapic()
            .write()
            .byteChannel(write)
            .setHasher(Hasher.noop())
            .setByteStringStrategy(ByteStringStrategy.noCopy());
    BufferedWritableByteChannelSession<WriteObjectResponse> session =
        b1.resumable().buffered().setStartAsync(startAsync).build();
  }
}
