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

package com.google.monitoring.metricsscope.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest;
import com.google.monitoring.metricsscope.v1.DeleteMonitoredProjectRequest;
import com.google.monitoring.metricsscope.v1.GetMetricsScopeRequest;
import com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectRequest;
import com.google.monitoring.metricsscope.v1.ListMetricsScopesByMonitoredProjectResponse;
import com.google.monitoring.metricsscope.v1.MetricsScope;
import com.google.monitoring.metricsscope.v1.MonitoredProject;
import com.google.monitoring.metricsscope.v1.OperationMetadata;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MetricsScopes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MetricsScopesStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<GetMetricsScopeRequest, MetricsScope> getMetricsScopeCallable() {
    throw new UnsupportedOperationException("Not implemented: getMetricsScopeCallable()");
  }

  public UnaryCallable<
          ListMetricsScopesByMonitoredProjectRequest, ListMetricsScopesByMonitoredProjectResponse>
      listMetricsScopesByMonitoredProjectCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMetricsScopesByMonitoredProjectCallable()");
  }

  public OperationCallable<CreateMonitoredProjectRequest, MonitoredProject, OperationMetadata>
      createMonitoredProjectOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMonitoredProjectOperationCallable()");
  }

  public UnaryCallable<CreateMonitoredProjectRequest, Operation> createMonitoredProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: createMonitoredProjectCallable()");
  }

  public OperationCallable<DeleteMonitoredProjectRequest, Empty, OperationMetadata>
      deleteMonitoredProjectOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMonitoredProjectOperationCallable()");
  }

  public UnaryCallable<DeleteMonitoredProjectRequest, Operation> deleteMonitoredProjectCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMonitoredProjectCallable()");
  }

  @Override
  public abstract void close();
}
