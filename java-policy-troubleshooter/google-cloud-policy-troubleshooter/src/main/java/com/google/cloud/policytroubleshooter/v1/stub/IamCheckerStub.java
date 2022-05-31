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

package com.google.cloud.policytroubleshooter.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyRequest;
import com.google.cloud.policytroubleshooter.v1.TroubleshootIamPolicyResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IamChecker service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class IamCheckerStub implements BackgroundResource {

  public UnaryCallable<TroubleshootIamPolicyRequest, TroubleshootIamPolicyResponse>
      troubleshootIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: troubleshootIamPolicyCallable()");
  }

  @Override
  public abstract void close();
}
