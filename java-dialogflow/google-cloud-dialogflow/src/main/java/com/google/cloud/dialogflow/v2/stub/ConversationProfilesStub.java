/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ConversationProfilesClient.ListConversationProfilesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.ConversationProfile;
import com.google.cloud.dialogflow.v2.CreateConversationProfileRequest;
import com.google.cloud.dialogflow.v2.DeleteConversationProfileRequest;
import com.google.cloud.dialogflow.v2.GetConversationProfileRequest;
import com.google.cloud.dialogflow.v2.ListConversationProfilesRequest;
import com.google.cloud.dialogflow.v2.ListConversationProfilesResponse;
import com.google.cloud.dialogflow.v2.UpdateConversationProfileRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConversationProfiles service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ConversationProfilesStub implements BackgroundResource {

  public UnaryCallable<ListConversationProfilesRequest, ListConversationProfilesPagedResponse>
      listConversationProfilesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConversationProfilesPagedCallable()");
  }

  public UnaryCallable<ListConversationProfilesRequest, ListConversationProfilesResponse>
      listConversationProfilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationProfilesCallable()");
  }

  public UnaryCallable<GetConversationProfileRequest, ConversationProfile>
      getConversationProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getConversationProfileCallable()");
  }

  public UnaryCallable<CreateConversationProfileRequest, ConversationProfile>
      createConversationProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: createConversationProfileCallable()");
  }

  public UnaryCallable<UpdateConversationProfileRequest, ConversationProfile>
      updateConversationProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConversationProfileCallable()");
  }

  public UnaryCallable<DeleteConversationProfileRequest, Empty>
      deleteConversationProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConversationProfileCallable()");
  }

  @Override
  public abstract void close();
}
