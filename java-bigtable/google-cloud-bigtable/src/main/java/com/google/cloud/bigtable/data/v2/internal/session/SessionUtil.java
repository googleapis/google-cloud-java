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

import com.google.bigtable.v2.SessionProto;
import com.google.bigtable.v2.SessionType;
import com.google.common.base.Preconditions;
import com.google.protobuf.Message;
import com.google.protobuf.util.Durations;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoMethodDescriptorSupplier;
import java.time.Duration;

final class SessionUtil {
  private SessionUtil() {}

  static SessionType extractSessionTypeFromMethod(MethodDescriptor<?, ?> desc) {
    ProtoMethodDescriptorSupplier schemaDescriptor =
        (ProtoMethodDescriptorSupplier) desc.getSchemaDescriptor();

    SessionType sessionType =
        schemaDescriptor
            .getMethodDescriptor()
            .getOptions()
            .getExtension(SessionProto.rpcSessionType);

    Preconditions.checkNotNull(sessionType, "%s missing rpc_session_type annotation", desc);
    Preconditions.checkState(
        sessionType != SessionType.SESSION_TYPE_UNSET,
        "%s missing rpc_session_type annotation",
        desc);

    return sessionType;
  }

  static SessionType extractOpenSessionTypeFromOpenMsg(Message openReq) {
    SessionType sessionType =
        openReq.getDescriptorForType().getOptions().getExtension(SessionProto.openSessionType);
    Preconditions.checkNotNull(
        sessionType, "%s missing open_session_type annotation", openReq.getDescriptorForType());
    Preconditions.checkState(
        sessionType != SessionType.SESSION_TYPE_UNSET,
        "%s missing rpc_session_type annotation",
        openReq.getDescriptorForType());
    return sessionType;
  }

  static Duration toJavaDuration(com.google.protobuf.Duration duration) {
    return Duration.ofMillis(Durations.toMillis(duration));
  }
}
