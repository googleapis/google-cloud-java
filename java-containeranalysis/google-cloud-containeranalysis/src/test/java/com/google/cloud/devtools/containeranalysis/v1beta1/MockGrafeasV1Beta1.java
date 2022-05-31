/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.protobuf.AbstractMessage;
import io.grpc.ServerServiceDefinition;
import java.util.List;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockGrafeasV1Beta1 implements MockGrpcService {
  private final MockGrafeasV1Beta1Impl serviceImpl;

  public MockGrafeasV1Beta1() {
    serviceImpl = new MockGrafeasV1Beta1Impl();
  }

  @Override
  public List<AbstractMessage> getRequests() {
    return serviceImpl.getRequests();
  }

  @Override
  public void addResponse(AbstractMessage response) {
    serviceImpl.addResponse(response);
  }

  @Override
  public void addException(Exception exception) {
    serviceImpl.addException(exception);
  }

  @Override
  public ServerServiceDefinition getServiceDefinition() {
    return serviceImpl.bindService();
  }

  @Override
  public void reset() {
    serviceImpl.reset();
  }
}
