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

package com.google.ads.datamanager.v1.stub;

import com.google.ads.datamanager.v1.IngestAudienceMembersRequest;
import com.google.ads.datamanager.v1.IngestAudienceMembersResponse;
import com.google.ads.datamanager.v1.IngestEventsRequest;
import com.google.ads.datamanager.v1.IngestEventsResponse;
import com.google.ads.datamanager.v1.RemoveAudienceMembersRequest;
import com.google.ads.datamanager.v1.RemoveAudienceMembersResponse;
import com.google.ads.datamanager.v1.RetrieveRequestStatusRequest;
import com.google.ads.datamanager.v1.RetrieveRequestStatusResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IngestionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class IngestionServiceStub implements BackgroundResource {

  public UnaryCallable<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
      ingestAudienceMembersCallable() {
    throw new UnsupportedOperationException("Not implemented: ingestAudienceMembersCallable()");
  }

  public UnaryCallable<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
      removeAudienceMembersCallable() {
    throw new UnsupportedOperationException("Not implemented: removeAudienceMembersCallable()");
  }

  public UnaryCallable<IngestEventsRequest, IngestEventsResponse> ingestEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: ingestEventsCallable()");
  }

  public UnaryCallable<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
      retrieveRequestStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: retrieveRequestStatusCallable()");
  }

  @Override
  public abstract void close();
}
