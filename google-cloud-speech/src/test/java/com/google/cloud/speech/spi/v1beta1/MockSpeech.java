/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.speech.spi.v1beta1;

import com.google.api.gax.testing.MockGrpcService;
import com.google.cloud.speech.v1beta1.SpeechGrpc;
import com.google.protobuf.GeneratedMessage;
import io.grpc.ServerServiceDefinition;
import java.util.List;

@javax.annotation.Generated("by GAPIC")
public class MockSpeech implements MockGrpcService {
  private MockSpeechImpl serviceImpl;

  public MockSpeech() {
    serviceImpl = new MockSpeechImpl();
  }

  @Override
  public List<GeneratedMessage> getRequests() {
    return serviceImpl.getRequests();
  }

  @Override
  public void setResponses(List<GeneratedMessage> responses) {
    serviceImpl.setResponses(responses);
  }

  @Override
  public ServerServiceDefinition getServiceDefinition() {
    return SpeechGrpc.bindService(serviceImpl);
  }

  @Override
  public void reset() {
    serviceImpl.reset();
  }
}
