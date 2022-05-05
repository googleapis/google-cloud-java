/*
 * Copyright 2022 Google LLC
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

package com.google.api.servicecontrol.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.servicecontrol.v2.CheckRequest;
import com.google.api.servicecontrol.v2.CheckResponse;
import com.google.api.servicecontrol.v2.ReportRequest;
import com.google.api.servicecontrol.v2.ReportResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ServiceController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ServiceControllerStub implements BackgroundResource {

  public UnaryCallable<CheckRequest, CheckResponse> checkCallable() {
    throw new UnsupportedOperationException("Not implemented: checkCallable()");
  }

  public UnaryCallable<ReportRequest, ReportResponse> reportCallable() {
    throw new UnsupportedOperationException("Not implemented: reportCallable()");
  }

  @Override
  public abstract void close();
}
