/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.compute.v1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.HttpJsonLroErrorParser;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.cloud.compute.v1.Errors;
import com.google.cloud.compute.v1.Operation;
import com.google.protobuf.Any;
import com.google.rpc.ErrorInfo;
import java.util.ArrayList;
import java.util.List;

@BetaApi("The surface for custom LRO error parsing is not stable yet and may change.")
class ComputeLroErrorParser implements HttpJsonLroErrorParser {

  @Override
  public ErrorDetails parse(Object response) {
    if (!(response instanceof Operation)) {
      return null;
    }
    Operation operation = ((Operation) response);
    if (!operation.hasError()) {
      return null;
    }
    List<Any> rawErrorMessages = new ArrayList<>();
    for (Errors error : operation.getError().getErrorsList()) {
      ErrorInfo errorInfo =
          ErrorInfo.newBuilder()
              .setReason(error.getCode())
              .setDomain("googleapis.com")
              .putMetadata("message", error.getMessage())
              .putMetadata("location", error.getLocation())
              .build();
      rawErrorMessages.add(Any.pack(errorInfo));
    }
    return ErrorDetails.builder().setRawErrorMessages(rawErrorMessages).build();
  }

  @Override
  public String parseErrorMessage(Object response) {
    if (!(response instanceof Operation)) {
      return null;
    }
    Operation operation = ((Operation) response);
    if (!operation.hasError() || operation.getError().getErrorsCount() == 0) {
      return null;
    }
    StringBuilder sb = new StringBuilder();
    for (Errors error : operation.getError().getErrorsList()) {
      if (sb.length() > 0) {
        sb.append("; ");
      }
      sb.append(error.getCode()).append(": ").append(error.getMessage());
    }
    return sb.toString();
  }
}
