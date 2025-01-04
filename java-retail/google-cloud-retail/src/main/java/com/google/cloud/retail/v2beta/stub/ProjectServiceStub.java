/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.retail.v2beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.AlertConfig;
import com.google.cloud.retail.v2beta.GetAlertConfigRequest;
import com.google.cloud.retail.v2beta.UpdateAlertConfigRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ProjectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ProjectServiceStub implements BackgroundResource {

  public UnaryCallable<GetAlertConfigRequest, AlertConfig> getAlertConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getAlertConfigCallable()");
  }

  public UnaryCallable<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAlertConfigCallable()");
  }

  @Override
  public abstract void close();
}
