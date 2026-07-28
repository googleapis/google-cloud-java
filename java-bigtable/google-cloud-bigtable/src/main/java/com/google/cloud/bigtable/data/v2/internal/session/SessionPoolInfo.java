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

package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.SessionType;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor.SessionDescriptor;
import com.google.common.base.Ascii;

@AutoValue
public abstract class SessionPoolInfo {
  public abstract ClientInfo getClientInfo();

  public abstract SessionType getType();

  public abstract String getTypeLabel();

  public abstract String getName();

  public abstract String getLogName();

  public static SessionPoolInfo create(
      ClientInfo clientInfo, SessionDescriptor<?> descriptor, String name) {
    SessionType type = descriptor.getType();
    String typeStr = Ascii.toLowerCase(type.name().replace("SESSION_TYPE_", ""));
    String logName = String.format("%s(%s)", typeStr, name);

    return new AutoValue_SessionPoolInfo(clientInfo, type, typeStr, name, logName);
  }
}
