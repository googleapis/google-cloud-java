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
package com.google.cloud.bigtable.data.v2.internal.csm.tracers;

import com.google.api.core.InternalApi;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.Util;
import com.google.cloud.bigtable.data.v2.internal.dp.DirectAccessInvestigator;

/** Interface for recording DirectPath/DirectAccess eligibility metrics. */
@InternalApi
public interface DirectPathCompatibleTracer {

  /**
   * Records that the environment is eligible and successfully connected via DirectPath.
   *
   * @param ipProtocol The IP protocol used (e.g., "ipv6").
   */
  void recordSuccess(Util.IpProtocol ipProtocol);

  /**
   * Records that the environment is not eligible or failed to connect via DirectPath.
   *
   * @param reason The reason for the failure (e.g., "routing_check_failed").
   */
  // TODO: Make this an enum
  void recordFailure(DirectAccessInvestigator.FailureReason reason);
}
