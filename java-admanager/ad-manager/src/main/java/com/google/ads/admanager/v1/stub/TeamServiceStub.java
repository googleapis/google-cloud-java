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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.TeamServiceClient.ListTeamsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateTeamsRequest;
import com.google.ads.admanager.v1.BatchActivateTeamsResponse;
import com.google.ads.admanager.v1.BatchCreateTeamsRequest;
import com.google.ads.admanager.v1.BatchCreateTeamsResponse;
import com.google.ads.admanager.v1.BatchDeactivateTeamsRequest;
import com.google.ads.admanager.v1.BatchDeactivateTeamsResponse;
import com.google.ads.admanager.v1.BatchUpdateTeamsRequest;
import com.google.ads.admanager.v1.BatchUpdateTeamsResponse;
import com.google.ads.admanager.v1.CreateTeamRequest;
import com.google.ads.admanager.v1.GetTeamRequest;
import com.google.ads.admanager.v1.ListTeamsRequest;
import com.google.ads.admanager.v1.ListTeamsResponse;
import com.google.ads.admanager.v1.Team;
import com.google.ads.admanager.v1.UpdateTeamRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TeamService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TeamServiceStub implements BackgroundResource {

  public UnaryCallable<GetTeamRequest, Team> getTeamCallable() {
    throw new UnsupportedOperationException("Not implemented: getTeamCallable()");
  }

  public UnaryCallable<ListTeamsRequest, ListTeamsPagedResponse> listTeamsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTeamsPagedCallable()");
  }

  public UnaryCallable<ListTeamsRequest, ListTeamsResponse> listTeamsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTeamsCallable()");
  }

  public UnaryCallable<CreateTeamRequest, Team> createTeamCallable() {
    throw new UnsupportedOperationException("Not implemented: createTeamCallable()");
  }

  public UnaryCallable<BatchCreateTeamsRequest, BatchCreateTeamsResponse>
      batchCreateTeamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateTeamsCallable()");
  }

  public UnaryCallable<UpdateTeamRequest, Team> updateTeamCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTeamCallable()");
  }

  public UnaryCallable<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>
      batchUpdateTeamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateTeamsCallable()");
  }

  public UnaryCallable<BatchActivateTeamsRequest, BatchActivateTeamsResponse>
      batchActivateTeamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateTeamsCallable()");
  }

  public UnaryCallable<BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>
      batchDeactivateTeamsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeactivateTeamsCallable()");
  }

  @Override
  public abstract void close();
}
