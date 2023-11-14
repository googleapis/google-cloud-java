/*
 * Copyright 2023 Google LLC
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

package com.google.maps.fleetengine.delivery.v1.stub;

import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListDeliveryVehiclesPagedResponse;
import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.ListTasksPagedResponse;
import static google.maps.fleetengine.delivery.v1.DeliveryServiceClient.SearchTasksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import google.maps.fleetengine.delivery.v1.BatchCreateTasksRequest;
import google.maps.fleetengine.delivery.v1.BatchCreateTasksResponse;
import google.maps.fleetengine.delivery.v1.CreateDeliveryVehicleRequest;
import google.maps.fleetengine.delivery.v1.CreateTaskRequest;
import google.maps.fleetengine.delivery.v1.DeliveryVehicle;
import google.maps.fleetengine.delivery.v1.GetDeliveryVehicleRequest;
import google.maps.fleetengine.delivery.v1.GetTaskRequest;
import google.maps.fleetengine.delivery.v1.GetTaskTrackingInfoRequest;
import google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest;
import google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesResponse;
import google.maps.fleetengine.delivery.v1.ListTasksRequest;
import google.maps.fleetengine.delivery.v1.ListTasksResponse;
import google.maps.fleetengine.delivery.v1.SearchTasksRequest;
import google.maps.fleetengine.delivery.v1.SearchTasksResponse;
import google.maps.fleetengine.delivery.v1.Task;
import google.maps.fleetengine.delivery.v1.TaskTrackingInfo;
import google.maps.fleetengine.delivery.v1.UpdateDeliveryVehicleRequest;
import google.maps.fleetengine.delivery.v1.UpdateTaskRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DeliveryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DeliveryServiceStub implements BackgroundResource {

  public UnaryCallable<CreateDeliveryVehicleRequest, DeliveryVehicle>
      createDeliveryVehicleCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeliveryVehicleCallable()");
  }

  public UnaryCallable<GetDeliveryVehicleRequest, DeliveryVehicle> getDeliveryVehicleCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeliveryVehicleCallable()");
  }

  public UnaryCallable<UpdateDeliveryVehicleRequest, DeliveryVehicle>
      updateDeliveryVehicleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeliveryVehicleCallable()");
  }

  public UnaryCallable<BatchCreateTasksRequest, BatchCreateTasksResponse>
      batchCreateTasksCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateTasksCallable()");
  }

  public UnaryCallable<CreateTaskRequest, Task> createTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: createTaskCallable()");
  }

  public UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: getTaskCallable()");
  }

  @Deprecated
  public UnaryCallable<SearchTasksRequest, SearchTasksPagedResponse> searchTasksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchTasksPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<SearchTasksRequest, SearchTasksResponse> searchTasksCallable() {
    throw new UnsupportedOperationException("Not implemented: searchTasksCallable()");
  }

  public UnaryCallable<UpdateTaskRequest, Task> updateTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTaskCallable()");
  }

  public UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTasksPagedCallable()");
  }

  public UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable() {
    throw new UnsupportedOperationException("Not implemented: listTasksCallable()");
  }

  public UnaryCallable<GetTaskTrackingInfoRequest, TaskTrackingInfo> getTaskTrackingInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: getTaskTrackingInfoCallable()");
  }

  public UnaryCallable<ListDeliveryVehiclesRequest, ListDeliveryVehiclesPagedResponse>
      listDeliveryVehiclesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeliveryVehiclesPagedCallable()");
  }

  public UnaryCallable<ListDeliveryVehiclesRequest, ListDeliveryVehiclesResponse>
      listDeliveryVehiclesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeliveryVehiclesCallable()");
  }

  @Override
  public abstract void close();
}
