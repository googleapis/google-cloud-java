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

package com.google.cloud.bigquery.reservation.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.bigquery.reservation.v1.stub.ReservationServiceStub;
import com.google.cloud.bigquery.reservation.v1.stub.ReservationServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This API allows users to manage their BigQuery reservations.
 *
 * <p>A reservation provides computational resource guarantees, in the form of
 * [slots](https://cloud.google.com/bigquery/docs/slots), to users. A slot is a unit of
 * computational power in BigQuery, and serves as the basic unit of parallelism. In a scan of a
 * multi-partitioned table, a single slot operates on a single partition of the table. A reservation
 * resource exists as a child resource of the admin project and location, e.g.:
 * `projects/myproject/locations/US/reservations/reservationName`.
 *
 * <p>A capacity commitment is a way to purchase compute capacity for BigQuery jobs (in the form of
 * slots) with some committed period of usage. A capacity commitment resource exists as a child
 * resource of the admin project and location, e.g.:
 * `projects/myproject/locations/US/capacityCommitments/id`.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Reservation reservation = Reservation.newBuilder().build();
 *   String reservationId = "reservationId1116965383";
 *   Reservation response =
 *       reservationServiceClient.createReservation(parent, reservation, reservationId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReservationServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateReservation</td>
 *      <td><p> Creates a new reservation resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReservation(CreateReservationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createReservation(LocationName parent, Reservation reservation, String reservationId)
 *           <li><p> createReservation(String parent, Reservation reservation, String reservationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReservationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReservations</td>
 *      <td><p> Lists all the reservations for the project in the specified location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReservations(ListReservationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReservations(LocationName parent)
 *           <li><p> listReservations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReservationsPagedCallable()
 *           <li><p> listReservationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetReservation</td>
 *      <td><p> Returns information about the reservation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getReservation(GetReservationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getReservation(ReservationName name)
 *           <li><p> getReservation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReservationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteReservation</td>
 *      <td><p> Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has assignments.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteReservation(DeleteReservationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteReservation(ReservationName name)
 *           <li><p> deleteReservation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteReservationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateReservation</td>
 *      <td><p> Updates an existing reservation resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateReservation(UpdateReservationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateReservation(Reservation reservation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateReservationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FailoverReservation</td>
 *      <td><p> Fail over a reservation to the secondary location. The operation should be done in the current secondary location, which will be promoted to the new primary location for the reservation. Attempting to failover a reservation in the current primary location will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> failoverReservation(FailoverReservationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> failoverReservationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCapacityCommitment</td>
 *      <td><p> Creates a new capacity commitment resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCapacityCommitment(CreateCapacityCommitmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCapacityCommitment(LocationName parent, CapacityCommitment capacityCommitment)
 *           <li><p> createCapacityCommitment(String parent, CapacityCommitment capacityCommitment)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCapacityCommitmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCapacityCommitments</td>
 *      <td><p> Lists all the capacity commitments for the admin project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCapacityCommitments(ListCapacityCommitmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCapacityCommitments(LocationName parent)
 *           <li><p> listCapacityCommitments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCapacityCommitmentsPagedCallable()
 *           <li><p> listCapacityCommitmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCapacityCommitment</td>
 *      <td><p> Returns information about the capacity commitment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCapacityCommitment(GetCapacityCommitmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCapacityCommitment(CapacityCommitmentName name)
 *           <li><p> getCapacityCommitment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCapacityCommitmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCapacityCommitment</td>
 *      <td><p> Deletes a capacity commitment. Attempting to delete capacity commitment before its commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCapacityCommitment(DeleteCapacityCommitmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCapacityCommitment(CapacityCommitmentName name)
 *           <li><p> deleteCapacityCommitment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCapacityCommitmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCapacityCommitment</td>
 *      <td><p> Updates an existing capacity commitment.
 * <p>  Only `plan` and `renewal_plan` fields can be updated.
 * <p>  Plan can only be changed to a plan of a longer commitment period. Attempting to change to a plan with shorter commitment period will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCapacityCommitment(UpdateCapacityCommitmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCapacityCommitment(CapacityCommitment capacityCommitment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCapacityCommitmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SplitCapacityCommitment</td>
 *      <td><p> Splits capacity commitment to two commitments of the same plan and `commitment_end_time`.
 * <p>  A common use case is to enable downgrading commitments.
 * <p>  For example, in order to downgrade from 10000 slots to 8000, you might split a 10000 capacity commitment into commitments of 2000 and 8000. Then, you delete the first one after the commitment end time passes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> splitCapacityCommitment(SplitCapacityCommitmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> splitCapacityCommitment(CapacityCommitmentName name, long slotCount)
 *           <li><p> splitCapacityCommitment(String name, long slotCount)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> splitCapacityCommitmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MergeCapacityCommitments</td>
 *      <td><p> Merges capacity commitments of the same plan into a single commitment.
 * <p>  The resulting capacity commitment has the greater commitment_end_time out of the to-be-merged capacity commitments.
 * <p>  Attempting to merge capacity commitments of different plan will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> mergeCapacityCommitments(MergeCapacityCommitmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> mergeCapacityCommitments(LocationName parent, List&lt;String&gt; capacityCommitmentIds)
 *           <li><p> mergeCapacityCommitments(String parent, List&lt;String&gt; capacityCommitmentIds)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> mergeCapacityCommitmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAssignment</td>
 *      <td><p> Creates an assignment object which allows the given project to submit jobs of a certain type using slots from the specified reservation.
 * <p>  Currently a resource (project, folder, organization) can only have one assignment per each (job_type, location) combination, and that reservation will be used for all jobs of the matching type.
 * <p>  Different assignments can be created on different levels of the projects, folders or organization hierarchy.  During query execution, the assignment is looked up at the project, folder and organization levels in that order. The first assignment found is applied to the query.
 * <p>  When creating assignments, it does not matter if other assignments exist at higher levels.
 * <p>  Example:
 * <ul>
 * <li>  The organization `organizationA` contains two projects, `project1`   and `project2`.
 * <li>  Assignments for all three entities (`organizationA`, `project1`, and   `project2`) could all be created and mapped to the same or different   reservations.
 * </ul>
 * <p>  "None" assignments represent an absence of the assignment. Projects assigned to None use on-demand pricing. To create a "None" assignment, use "none" as a reservation_id in the parent. Example parent: `projects/myproject/locations/US/reservations/none`.
 * <p>  Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin' permissions on the project using the reservation and the project that owns this reservation.
 * <p>  Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match location of the reservation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAssignment(CreateAssignmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAssignment(ReservationName parent, Assignment assignment)
 *           <li><p> createAssignment(String parent, Assignment assignment)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAssignmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAssignments</td>
 *      <td><p> Lists assignments.
 * <p>  Only explicitly created assignments will be returned.
 * <p>  Example:
 * <ul>
 * <li>  Organization `organizationA` contains two projects, `project1` and   `project2`.
 * <li>  Reservation `res1` exists and was created previously.
 * <li>  CreateAssignment was used previously to define the following   associations between entities and reservations: `&lt;organizationA, res1&gt;`   and `&lt;project1, res1&gt;`
 * </ul>
 * <p>  In this example, ListAssignments will just return the above two assignments for reservation `res1`, and no expansion/merge will happen.
 * <p>  The wildcard "-" can be used for reservations in the request. In that case all assignments belongs to the specified project and location will be listed.
 * <p>  &#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAssignments(ListAssignmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAssignments(ReservationName parent)
 *           <li><p> listAssignments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAssignmentsPagedCallable()
 *           <li><p> listAssignmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAssignment</td>
 *      <td><p> Deletes a assignment. No expansion will happen.
 * <p>  Example:
 * <ul>
 * <li>  Organization `organizationA` contains two projects, `project1` and   `project2`.
 * <li>  Reservation `res1` exists and was created previously.
 * <li>  CreateAssignment was used previously to define the following   associations between entities and reservations: `&lt;organizationA, res1&gt;`   and `&lt;project1, res1&gt;`
 * </ul>
 * <p>  In this example, deletion of the `&lt;organizationA, res1&gt;` assignment won't affect the other assignment `&lt;project1, res1&gt;`. After said deletion, queries from `project1` will still use `res1` while queries from `project2` will switch to use on-demand mode.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAssignment(DeleteAssignmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAssignment(AssignmentName name)
 *           <li><p> deleteAssignment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAssignmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchAssignments</td>
 *      <td><p> Deprecated: Looks up assignments for a specified resource for a particular region. If the request is about a project:
 * <p>  1. Assignments created on the project will be returned if they exist. 2. Otherwise assignments created on the closest ancestor will be    returned. 3. Assignments for different JobTypes will all be returned.
 * <p>  The same logic applies if the request is about a folder.
 * <p>  If the request is about an organization, then assignments created on the organization will be returned (organization doesn't have ancestors).
 * <p>  Comparing to ListAssignments, there are some behavior differences:
 * <p>  1. permission on the assignee will be verified in this API. 2. Hierarchy lookup (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is `projects/&#42;/locations/&#42;`, instead of    `projects/&#42;/locations/&#42;reservations/&#42;`.
 * <p>  &#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchAssignments(SearchAssignmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchAssignments(LocationName parent, String query)
 *           <li><p> searchAssignments(String parent, String query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchAssignmentsPagedCallable()
 *           <li><p> searchAssignmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchAllAssignments</td>
 *      <td><p> Looks up assignments for a specified resource for a particular region. If the request is about a project:
 * <p>  1. Assignments created on the project will be returned if they exist. 2. Otherwise assignments created on the closest ancestor will be    returned. 3. Assignments for different JobTypes will all be returned.
 * <p>  The same logic applies if the request is about a folder.
 * <p>  If the request is about an organization, then assignments created on the organization will be returned (organization doesn't have ancestors).
 * <p>  Comparing to ListAssignments, there are some behavior differences:
 * <p>  1. permission on the assignee will be verified in this API. 2. Hierarchy lookup (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is `projects/&#42;/locations/&#42;`, instead of    `projects/&#42;/locations/&#42;reservations/&#42;`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchAllAssignments(SearchAllAssignmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchAllAssignments(LocationName parent, String query)
 *           <li><p> searchAllAssignments(String parent, String query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchAllAssignmentsPagedCallable()
 *           <li><p> searchAllAssignmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MoveAssignment</td>
 *      <td><p> Moves an assignment under a new reservation.
 * <p>  This differs from removing an existing assignment and recreating a new one by providing a transactional change that ensures an assignee always has an associated reservation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> moveAssignment(MoveAssignmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> moveAssignment(AssignmentName name, ReservationName destinationId)
 *           <li><p> moveAssignment(AssignmentName name, String destinationId)
 *           <li><p> moveAssignment(String name, ReservationName destinationId)
 *           <li><p> moveAssignment(String name, String destinationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> moveAssignmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAssignment</td>
 *      <td><p> Updates an existing assignment.
 * <p>  Only the `priority` field can be updated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAssignment(UpdateAssignmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAssignment(Assignment assignment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAssignmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBiReservation</td>
 *      <td><p> Retrieves a BI reservation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBiReservation(GetBiReservationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBiReservation(BiReservationName name)
 *           <li><p> getBiReservation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBiReservationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBiReservation</td>
 *      <td><p> Updates a BI reservation.
 * <p>  Only fields specified in the `field_mask` are updated.
 * <p>  A singleton BI reservation always exists with default size 0. In order to reserve BI capacity it needs to be updated to an amount greater than 0. In order to release BI capacity reservation size must be set to 0.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBiReservation(UpdateBiReservationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBiReservation(BiReservation biReservation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBiReservationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. May return:
 * <ul>
 * <li>  A`NOT_FOUND` error if the resource doesn't exist or you don't have the   permission to view it.
 * <li>  An empty policy if the resource exists but doesn't have a set policy.
 * </ul>
 * <p>  Supported resources are: - Reservations - ReservationAssignments
 * <p>  To call this method, you must have the following Google IAM permissions:
 * <p>  - `bigqueryreservation.reservations.getIamPolicy` to get policies on reservations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(ResourceName resource)
 *           <li><p> getIamPolicy(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets an access control policy for a resource. Replaces any existing policy.
 * <p>  Supported resources are: - Reservations
 * <p>  To call this method, you must have the following Google IAM permissions:
 * <p>  - `bigqueryreservation.reservations.setIamPolicy` to set policies on reservations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(ResourceName resource, Policy policy)
 *           <li><p> setIamPolicy(String resource, Policy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Gets your permissions on a resource. Returns an empty set of permissions if the resource doesn't exist.
 * <p>  Supported resources are: - Reservations
 * <p>  No Google IAM permissions are required to call this method.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateReservationGroup</td>
 *      <td><p> Creates a new reservation group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReservationGroup(CreateReservationGroupRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReservationGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetReservationGroup</td>
 *      <td><p> Returns information about the reservation group.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getReservationGroup(GetReservationGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getReservationGroup(ReservationGroupName name)
 *           <li><p> getReservationGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReservationGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteReservationGroup</td>
 *      <td><p> Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has assignments.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteReservationGroup(DeleteReservationGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteReservationGroup(ReservationGroupName name)
 *           <li><p> deleteReservationGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteReservationGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReservationGroups</td>
 *      <td><p> Lists all the reservation groups for the project in the specified location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReservationGroups(ListReservationGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReservationGroups(LocationName parent)
 *           <li><p> listReservationGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReservationGroupsPagedCallable()
 *           <li><p> listReservationGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ReservationServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReservationServiceSettings reservationServiceSettings =
 *     ReservationServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReservationServiceClient reservationServiceClient =
 *     ReservationServiceClient.create(reservationServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReservationServiceSettings reservationServiceSettings =
 *     ReservationServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReservationServiceClient reservationServiceClient =
 *     ReservationServiceClient.create(reservationServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReservationServiceSettings reservationServiceSettings =
 *     ReservationServiceSettings.newHttpJsonBuilder().build();
 * ReservationServiceClient reservationServiceClient =
 *     ReservationServiceClient.create(reservationServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ReservationServiceClient implements BackgroundResource {
  private final ReservationServiceSettings settings;
  private final ReservationServiceStub stub;

  /** Constructs an instance of ReservationServiceClient with default settings. */
  public static final ReservationServiceClient create() throws IOException {
    return create(ReservationServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReservationServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReservationServiceClient create(ReservationServiceSettings settings)
      throws IOException {
    return new ReservationServiceClient(settings);
  }

  /**
   * Constructs an instance of ReservationServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ReservationServiceSettings).
   */
  public static final ReservationServiceClient create(ReservationServiceStub stub) {
    return new ReservationServiceClient(stub);
  }

  /**
   * Constructs an instance of ReservationServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ReservationServiceClient(ReservationServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReservationServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ReservationServiceClient(ReservationServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ReservationServiceSettings getSettings() {
    return settings;
  }

  public ReservationServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reservation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Reservation reservation = Reservation.newBuilder().build();
   *   String reservationId = "reservationId1116965383";
   *   Reservation response =
   *       reservationServiceClient.createReservation(parent, reservation, reservationId);
   * }
   * }</pre>
   *
   * @param parent Required. Project, location. E.g., `projects/myproject/locations/US`
   * @param reservation Definition of the new reservation to create.
   * @param reservationId The reservation ID. It must only contain lower case alphanumeric
   *     characters or dashes. It must start with a letter and must not end with a dash. Its maximum
   *     length is 64 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation createReservation(
      LocationName parent, Reservation reservation, String reservationId) {
    CreateReservationRequest request =
        CreateReservationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReservation(reservation)
            .setReservationId(reservationId)
            .build();
    return createReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reservation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Reservation reservation = Reservation.newBuilder().build();
   *   String reservationId = "reservationId1116965383";
   *   Reservation response =
   *       reservationServiceClient.createReservation(parent, reservation, reservationId);
   * }
   * }</pre>
   *
   * @param parent Required. Project, location. E.g., `projects/myproject/locations/US`
   * @param reservation Definition of the new reservation to create.
   * @param reservationId The reservation ID. It must only contain lower case alphanumeric
   *     characters or dashes. It must start with a letter and must not end with a dash. Its maximum
   *     length is 64 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation createReservation(
      String parent, Reservation reservation, String reservationId) {
    CreateReservationRequest request =
        CreateReservationRequest.newBuilder()
            .setParent(parent)
            .setReservation(reservation)
            .setReservationId(reservationId)
            .build();
    return createReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reservation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CreateReservationRequest request =
   *       CreateReservationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReservationId("reservationId1116965383")
   *           .setReservation(Reservation.newBuilder().build())
   *           .build();
   *   Reservation response = reservationServiceClient.createReservation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation createReservation(CreateReservationRequest request) {
    return createReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reservation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CreateReservationRequest request =
   *       CreateReservationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReservationId("reservationId1116965383")
   *           .setReservation(Reservation.newBuilder().build())
   *           .build();
   *   ApiFuture<Reservation> future =
   *       reservationServiceClient.createReservationCallable().futureCall(request);
   *   // Do something.
   *   Reservation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReservationRequest, Reservation> createReservationCallable() {
    return stub.createReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the reservations for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Reservation element : reservationServiceClient.listReservations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name containing project and location, e.g.:
   *     `projects/myproject/locations/US`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReservationsPagedResponse listReservations(LocationName parent) {
    ListReservationsRequest request =
        ListReservationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the reservations for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Reservation element : reservationServiceClient.listReservations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name containing project and location, e.g.:
   *     `projects/myproject/locations/US`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReservationsPagedResponse listReservations(String parent) {
    ListReservationsRequest request =
        ListReservationsRequest.newBuilder().setParent(parent).build();
    return listReservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the reservations for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListReservationsRequest request =
   *       ListReservationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Reservation element : reservationServiceClient.listReservations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReservationsPagedResponse listReservations(ListReservationsRequest request) {
    return listReservationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the reservations for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListReservationsRequest request =
   *       ListReservationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Reservation> future =
   *       reservationServiceClient.listReservationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Reservation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReservationsRequest, ListReservationsPagedResponse>
      listReservationsPagedCallable() {
    return stub.listReservationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the reservations for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListReservationsRequest request =
   *       ListReservationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListReservationsResponse response =
   *         reservationServiceClient.listReservationsCallable().call(request);
   *     for (Reservation element : response.getReservationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReservationsRequest, ListReservationsResponse>
      listReservationsCallable() {
    return stub.listReservationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   Reservation response = reservationServiceClient.getReservation(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the reservation to retrieve. E.g.,
   *     `projects/myproject/locations/US/reservations/team1-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation getReservation(ReservationName name) {
    GetReservationRequest request =
        GetReservationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString();
   *   Reservation response = reservationServiceClient.getReservation(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the reservation to retrieve. E.g.,
   *     `projects/myproject/locations/US/reservations/team1-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation getReservation(String name) {
    GetReservationRequest request = GetReservationRequest.newBuilder().setName(name).build();
    return getReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   GetReservationRequest request =
   *       GetReservationRequest.newBuilder()
   *           .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .build();
   *   Reservation response = reservationServiceClient.getReservation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation getReservation(GetReservationRequest request) {
    return getReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   GetReservationRequest request =
   *       GetReservationRequest.newBuilder()
   *           .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .build();
   *   ApiFuture<Reservation> future =
   *       reservationServiceClient.getReservationCallable().futureCall(request);
   *   // Do something.
   *   Reservation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReservationRequest, Reservation> getReservationCallable() {
    return stub.getReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   reservationServiceClient.deleteReservation(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the reservation to retrieve. E.g.,
   *     `projects/myproject/locations/US/reservations/team1-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReservation(ReservationName name) {
    DeleteReservationRequest request =
        DeleteReservationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString();
   *   reservationServiceClient.deleteReservation(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the reservation to retrieve. E.g.,
   *     `projects/myproject/locations/US/reservations/team1-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReservation(String name) {
    DeleteReservationRequest request = DeleteReservationRequest.newBuilder().setName(name).build();
    deleteReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   DeleteReservationRequest request =
   *       DeleteReservationRequest.newBuilder()
   *           .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .build();
   *   reservationServiceClient.deleteReservation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReservation(DeleteReservationRequest request) {
    deleteReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   DeleteReservationRequest request =
   *       DeleteReservationRequest.newBuilder()
   *           .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       reservationServiceClient.deleteReservationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReservationRequest, Empty> deleteReservationCallable() {
    return stub.deleteReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing reservation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   Reservation reservation = Reservation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Reservation response = reservationServiceClient.updateReservation(reservation, updateMask);
   * }
   * }</pre>
   *
   * @param reservation Content of the reservation to update.
   * @param updateMask Standard field mask for the set of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation updateReservation(Reservation reservation, FieldMask updateMask) {
    UpdateReservationRequest request =
        UpdateReservationRequest.newBuilder()
            .setReservation(reservation)
            .setUpdateMask(updateMask)
            .build();
    return updateReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing reservation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateReservationRequest request =
   *       UpdateReservationRequest.newBuilder()
   *           .setReservation(Reservation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Reservation response = reservationServiceClient.updateReservation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation updateReservation(UpdateReservationRequest request) {
    return updateReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing reservation resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateReservationRequest request =
   *       UpdateReservationRequest.newBuilder()
   *           .setReservation(Reservation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Reservation> future =
   *       reservationServiceClient.updateReservationCallable().futureCall(request);
   *   // Do something.
   *   Reservation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateReservationRequest, Reservation> updateReservationCallable() {
    return stub.updateReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fail over a reservation to the secondary location. The operation should be done in the current
   * secondary location, which will be promoted to the new primary location for the reservation.
   * Attempting to failover a reservation in the current primary location will fail with the error
   * code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   FailoverReservationRequest request =
   *       FailoverReservationRequest.newBuilder()
   *           .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .setFailoverMode(FailoverMode.forNumber(0))
   *           .build();
   *   Reservation response = reservationServiceClient.failoverReservation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Reservation failoverReservation(FailoverReservationRequest request) {
    return failoverReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fail over a reservation to the secondary location. The operation should be done in the current
   * secondary location, which will be promoted to the new primary location for the reservation.
   * Attempting to failover a reservation in the current primary location will fail with the error
   * code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   FailoverReservationRequest request =
   *       FailoverReservationRequest.newBuilder()
   *           .setName(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .setFailoverMode(FailoverMode.forNumber(0))
   *           .build();
   *   ApiFuture<Reservation> future =
   *       reservationServiceClient.failoverReservationCallable().futureCall(request);
   *   // Do something.
   *   Reservation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FailoverReservationRequest, Reservation>
      failoverReservationCallable() {
    return stub.failoverReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new capacity commitment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();
   *   CapacityCommitment response =
   *       reservationServiceClient.createCapacityCommitment(parent, capacityCommitment);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent reservation. E.g.,
   *     `projects/myproject/locations/US`
   * @param capacityCommitment Content of the capacity commitment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment createCapacityCommitment(
      LocationName parent, CapacityCommitment capacityCommitment) {
    CreateCapacityCommitmentRequest request =
        CreateCapacityCommitmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCapacityCommitment(capacityCommitment)
            .build();
    return createCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new capacity commitment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();
   *   CapacityCommitment response =
   *       reservationServiceClient.createCapacityCommitment(parent, capacityCommitment);
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent reservation. E.g.,
   *     `projects/myproject/locations/US`
   * @param capacityCommitment Content of the capacity commitment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment createCapacityCommitment(
      String parent, CapacityCommitment capacityCommitment) {
    CreateCapacityCommitmentRequest request =
        CreateCapacityCommitmentRequest.newBuilder()
            .setParent(parent)
            .setCapacityCommitment(capacityCommitment)
            .build();
    return createCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new capacity commitment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CreateCapacityCommitmentRequest request =
   *       CreateCapacityCommitmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCapacityCommitment(CapacityCommitment.newBuilder().build())
   *           .setEnforceSingleAdminProjectPerOrg(true)
   *           .setCapacityCommitmentId("capacityCommitmentId1185645802")
   *           .build();
   *   CapacityCommitment response = reservationServiceClient.createCapacityCommitment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment createCapacityCommitment(
      CreateCapacityCommitmentRequest request) {
    return createCapacityCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new capacity commitment resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CreateCapacityCommitmentRequest request =
   *       CreateCapacityCommitmentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCapacityCommitment(CapacityCommitment.newBuilder().build())
   *           .setEnforceSingleAdminProjectPerOrg(true)
   *           .setCapacityCommitmentId("capacityCommitmentId1185645802")
   *           .build();
   *   ApiFuture<CapacityCommitment> future =
   *       reservationServiceClient.createCapacityCommitmentCallable().futureCall(request);
   *   // Do something.
   *   CapacityCommitment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCapacityCommitmentRequest, CapacityCommitment>
      createCapacityCommitmentCallable() {
    return stub.createCapacityCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the capacity commitments for the admin project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CapacityCommitment element :
   *       reservationServiceClient.listCapacityCommitments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent reservation. E.g.,
   *     `projects/myproject/locations/US`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCapacityCommitmentsPagedResponse listCapacityCommitments(LocationName parent) {
    ListCapacityCommitmentsRequest request =
        ListCapacityCommitmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCapacityCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the capacity commitments for the admin project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CapacityCommitment element :
   *       reservationServiceClient.listCapacityCommitments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Resource name of the parent reservation. E.g.,
   *     `projects/myproject/locations/US`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCapacityCommitmentsPagedResponse listCapacityCommitments(String parent) {
    ListCapacityCommitmentsRequest request =
        ListCapacityCommitmentsRequest.newBuilder().setParent(parent).build();
    return listCapacityCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the capacity commitments for the admin project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListCapacityCommitmentsRequest request =
   *       ListCapacityCommitmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CapacityCommitment element :
   *       reservationServiceClient.listCapacityCommitments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCapacityCommitmentsPagedResponse listCapacityCommitments(
      ListCapacityCommitmentsRequest request) {
    return listCapacityCommitmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the capacity commitments for the admin project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListCapacityCommitmentsRequest request =
   *       ListCapacityCommitmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CapacityCommitment> future =
   *       reservationServiceClient.listCapacityCommitmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CapacityCommitment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsPagedResponse>
      listCapacityCommitmentsPagedCallable() {
    return stub.listCapacityCommitmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the capacity commitments for the admin project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListCapacityCommitmentsRequest request =
   *       ListCapacityCommitmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCapacityCommitmentsResponse response =
   *         reservationServiceClient.listCapacityCommitmentsCallable().call(request);
   *     for (CapacityCommitment element : response.getCapacityCommitmentsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>
      listCapacityCommitmentsCallable() {
    return stub.listCapacityCommitmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the capacity commitment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name =
   *       CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   CapacityCommitment response = reservationServiceClient.getCapacityCommitment(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the capacity commitment to retrieve. E.g.,
   *     `projects/myproject/locations/US/capacityCommitments/123`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment getCapacityCommitment(CapacityCommitmentName name) {
    GetCapacityCommitmentRequest request =
        GetCapacityCommitmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the capacity commitment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name =
   *       CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]").toString();
   *   CapacityCommitment response = reservationServiceClient.getCapacityCommitment(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the capacity commitment to retrieve. E.g.,
   *     `projects/myproject/locations/US/capacityCommitments/123`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment getCapacityCommitment(String name) {
    GetCapacityCommitmentRequest request =
        GetCapacityCommitmentRequest.newBuilder().setName(name).build();
    return getCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the capacity commitment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   GetCapacityCommitmentRequest request =
   *       GetCapacityCommitmentRequest.newBuilder()
   *           .setName(
   *               CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
   *                   .toString())
   *           .build();
   *   CapacityCommitment response = reservationServiceClient.getCapacityCommitment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment getCapacityCommitment(GetCapacityCommitmentRequest request) {
    return getCapacityCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the capacity commitment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   GetCapacityCommitmentRequest request =
   *       GetCapacityCommitmentRequest.newBuilder()
   *           .setName(
   *               CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<CapacityCommitment> future =
   *       reservationServiceClient.getCapacityCommitmentCallable().futureCall(request);
   *   // Do something.
   *   CapacityCommitment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCapacityCommitmentRequest, CapacityCommitment>
      getCapacityCommitmentCallable() {
    return stub.getCapacityCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a capacity commitment. Attempting to delete capacity commitment before its
   * commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name =
   *       CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   reservationServiceClient.deleteCapacityCommitment(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the capacity commitment to delete. E.g.,
   *     `projects/myproject/locations/US/capacityCommitments/123`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCapacityCommitment(CapacityCommitmentName name) {
    DeleteCapacityCommitmentRequest request =
        DeleteCapacityCommitmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a capacity commitment. Attempting to delete capacity commitment before its
   * commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name =
   *       CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]").toString();
   *   reservationServiceClient.deleteCapacityCommitment(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the capacity commitment to delete. E.g.,
   *     `projects/myproject/locations/US/capacityCommitments/123`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCapacityCommitment(String name) {
    DeleteCapacityCommitmentRequest request =
        DeleteCapacityCommitmentRequest.newBuilder().setName(name).build();
    deleteCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a capacity commitment. Attempting to delete capacity commitment before its
   * commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   DeleteCapacityCommitmentRequest request =
   *       DeleteCapacityCommitmentRequest.newBuilder()
   *           .setName(
   *               CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   reservationServiceClient.deleteCapacityCommitment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCapacityCommitment(DeleteCapacityCommitmentRequest request) {
    deleteCapacityCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a capacity commitment. Attempting to delete capacity commitment before its
   * commitment_end_time will fail with the error code `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   DeleteCapacityCommitmentRequest request =
   *       DeleteCapacityCommitmentRequest.newBuilder()
   *           .setName(
   *               CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       reservationServiceClient.deleteCapacityCommitmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCapacityCommitmentRequest, Empty>
      deleteCapacityCommitmentCallable() {
    return stub.deleteCapacityCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing capacity commitment.
   *
   * <p>Only `plan` and `renewal_plan` fields can be updated.
   *
   * <p>Plan can only be changed to a plan of a longer commitment period. Attempting to change to a
   * plan with shorter commitment period will fail with the error code
   * `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitment capacityCommitment = CapacityCommitment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CapacityCommitment response =
   *       reservationServiceClient.updateCapacityCommitment(capacityCommitment, updateMask);
   * }
   * }</pre>
   *
   * @param capacityCommitment Content of the capacity commitment to update.
   * @param updateMask Standard field mask for the set of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment updateCapacityCommitment(
      CapacityCommitment capacityCommitment, FieldMask updateMask) {
    UpdateCapacityCommitmentRequest request =
        UpdateCapacityCommitmentRequest.newBuilder()
            .setCapacityCommitment(capacityCommitment)
            .setUpdateMask(updateMask)
            .build();
    return updateCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing capacity commitment.
   *
   * <p>Only `plan` and `renewal_plan` fields can be updated.
   *
   * <p>Plan can only be changed to a plan of a longer commitment period. Attempting to change to a
   * plan with shorter commitment period will fail with the error code
   * `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateCapacityCommitmentRequest request =
   *       UpdateCapacityCommitmentRequest.newBuilder()
   *           .setCapacityCommitment(CapacityCommitment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CapacityCommitment response = reservationServiceClient.updateCapacityCommitment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment updateCapacityCommitment(
      UpdateCapacityCommitmentRequest request) {
    return updateCapacityCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing capacity commitment.
   *
   * <p>Only `plan` and `renewal_plan` fields can be updated.
   *
   * <p>Plan can only be changed to a plan of a longer commitment period. Attempting to change to a
   * plan with shorter commitment period will fail with the error code
   * `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateCapacityCommitmentRequest request =
   *       UpdateCapacityCommitmentRequest.newBuilder()
   *           .setCapacityCommitment(CapacityCommitment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CapacityCommitment> future =
   *       reservationServiceClient.updateCapacityCommitmentCallable().futureCall(request);
   *   // Do something.
   *   CapacityCommitment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCapacityCommitmentRequest, CapacityCommitment>
      updateCapacityCommitmentCallable() {
    return stub.updateCapacityCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Splits capacity commitment to two commitments of the same plan and `commitment_end_time`.
   *
   * <p>A common use case is to enable downgrading commitments.
   *
   * <p>For example, in order to downgrade from 10000 slots to 8000, you might split a 10000
   * capacity commitment into commitments of 2000 and 8000. Then, you delete the first one after the
   * commitment end time passes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CapacityCommitmentName name =
   *       CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]");
   *   long slotCount = -191518834;
   *   SplitCapacityCommitmentResponse response =
   *       reservationServiceClient.splitCapacityCommitment(name, slotCount);
   * }
   * }</pre>
   *
   * @param name Required. The resource name e.g.,:
   *     `projects/myproject/locations/US/capacityCommitments/123`
   * @param slotCount Number of slots in the capacity commitment after the split.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SplitCapacityCommitmentResponse splitCapacityCommitment(
      CapacityCommitmentName name, long slotCount) {
    SplitCapacityCommitmentRequest request =
        SplitCapacityCommitmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setSlotCount(slotCount)
            .build();
    return splitCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Splits capacity commitment to two commitments of the same plan and `commitment_end_time`.
   *
   * <p>A common use case is to enable downgrading commitments.
   *
   * <p>For example, in order to downgrade from 10000 slots to 8000, you might split a 10000
   * capacity commitment into commitments of 2000 and 8000. Then, you delete the first one after the
   * commitment end time passes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name =
   *       CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]").toString();
   *   long slotCount = -191518834;
   *   SplitCapacityCommitmentResponse response =
   *       reservationServiceClient.splitCapacityCommitment(name, slotCount);
   * }
   * }</pre>
   *
   * @param name Required. The resource name e.g.,:
   *     `projects/myproject/locations/US/capacityCommitments/123`
   * @param slotCount Number of slots in the capacity commitment after the split.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SplitCapacityCommitmentResponse splitCapacityCommitment(
      String name, long slotCount) {
    SplitCapacityCommitmentRequest request =
        SplitCapacityCommitmentRequest.newBuilder().setName(name).setSlotCount(slotCount).build();
    return splitCapacityCommitment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Splits capacity commitment to two commitments of the same plan and `commitment_end_time`.
   *
   * <p>A common use case is to enable downgrading commitments.
   *
   * <p>For example, in order to downgrade from 10000 slots to 8000, you might split a 10000
   * capacity commitment into commitments of 2000 and 8000. Then, you delete the first one after the
   * commitment end time passes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   SplitCapacityCommitmentRequest request =
   *       SplitCapacityCommitmentRequest.newBuilder()
   *           .setName(
   *               CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
   *                   .toString())
   *           .setSlotCount(-191518834)
   *           .build();
   *   SplitCapacityCommitmentResponse response =
   *       reservationServiceClient.splitCapacityCommitment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SplitCapacityCommitmentResponse splitCapacityCommitment(
      SplitCapacityCommitmentRequest request) {
    return splitCapacityCommitmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Splits capacity commitment to two commitments of the same plan and `commitment_end_time`.
   *
   * <p>A common use case is to enable downgrading commitments.
   *
   * <p>For example, in order to downgrade from 10000 slots to 8000, you might split a 10000
   * capacity commitment into commitments of 2000 and 8000. Then, you delete the first one after the
   * commitment end time passes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   SplitCapacityCommitmentRequest request =
   *       SplitCapacityCommitmentRequest.newBuilder()
   *           .setName(
   *               CapacityCommitmentName.of("[PROJECT]", "[LOCATION]", "[CAPACITY_COMMITMENT]")
   *                   .toString())
   *           .setSlotCount(-191518834)
   *           .build();
   *   ApiFuture<SplitCapacityCommitmentResponse> future =
   *       reservationServiceClient.splitCapacityCommitmentCallable().futureCall(request);
   *   // Do something.
   *   SplitCapacityCommitmentResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
      splitCapacityCommitmentCallable() {
    return stub.splitCapacityCommitmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges capacity commitments of the same plan into a single commitment.
   *
   * <p>The resulting capacity commitment has the greater commitment_end_time out of the
   * to-be-merged capacity commitments.
   *
   * <p>Attempting to merge capacity commitments of different plan will fail with the error code
   * `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   List<String> capacityCommitmentIds = new ArrayList<>();
   *   CapacityCommitment response =
   *       reservationServiceClient.mergeCapacityCommitments(parent, capacityCommitmentIds);
   * }
   * }</pre>
   *
   * @param parent Parent resource that identifies admin project and location e.g.,
   *     `projects/myproject/locations/us`
   * @param capacityCommitmentIds Ids of capacity commitments to merge. These capacity commitments
   *     must exist under admin project and location specified in the parent. ID is the last portion
   *     of capacity commitment name e.g., 'abc' for
   *     projects/myproject/locations/US/capacityCommitments/abc
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment mergeCapacityCommitments(
      LocationName parent, List<String> capacityCommitmentIds) {
    MergeCapacityCommitmentsRequest request =
        MergeCapacityCommitmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllCapacityCommitmentIds(capacityCommitmentIds)
            .build();
    return mergeCapacityCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges capacity commitments of the same plan into a single commitment.
   *
   * <p>The resulting capacity commitment has the greater commitment_end_time out of the
   * to-be-merged capacity commitments.
   *
   * <p>Attempting to merge capacity commitments of different plan will fail with the error code
   * `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   List<String> capacityCommitmentIds = new ArrayList<>();
   *   CapacityCommitment response =
   *       reservationServiceClient.mergeCapacityCommitments(parent, capacityCommitmentIds);
   * }
   * }</pre>
   *
   * @param parent Parent resource that identifies admin project and location e.g.,
   *     `projects/myproject/locations/us`
   * @param capacityCommitmentIds Ids of capacity commitments to merge. These capacity commitments
   *     must exist under admin project and location specified in the parent. ID is the last portion
   *     of capacity commitment name e.g., 'abc' for
   *     projects/myproject/locations/US/capacityCommitments/abc
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment mergeCapacityCommitments(
      String parent, List<String> capacityCommitmentIds) {
    MergeCapacityCommitmentsRequest request =
        MergeCapacityCommitmentsRequest.newBuilder()
            .setParent(parent)
            .addAllCapacityCommitmentIds(capacityCommitmentIds)
            .build();
    return mergeCapacityCommitments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges capacity commitments of the same plan into a single commitment.
   *
   * <p>The resulting capacity commitment has the greater commitment_end_time out of the
   * to-be-merged capacity commitments.
   *
   * <p>Attempting to merge capacity commitments of different plan will fail with the error code
   * `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   MergeCapacityCommitmentsRequest request =
   *       MergeCapacityCommitmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllCapacityCommitmentIds(new ArrayList<String>())
   *           .setCapacityCommitmentId("capacityCommitmentId1185645802")
   *           .build();
   *   CapacityCommitment response = reservationServiceClient.mergeCapacityCommitments(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CapacityCommitment mergeCapacityCommitments(
      MergeCapacityCommitmentsRequest request) {
    return mergeCapacityCommitmentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Merges capacity commitments of the same plan into a single commitment.
   *
   * <p>The resulting capacity commitment has the greater commitment_end_time out of the
   * to-be-merged capacity commitments.
   *
   * <p>Attempting to merge capacity commitments of different plan will fail with the error code
   * `google.rpc.Code.FAILED_PRECONDITION`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   MergeCapacityCommitmentsRequest request =
   *       MergeCapacityCommitmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllCapacityCommitmentIds(new ArrayList<String>())
   *           .setCapacityCommitmentId("capacityCommitmentId1185645802")
   *           .build();
   *   ApiFuture<CapacityCommitment> future =
   *       reservationServiceClient.mergeCapacityCommitmentsCallable().futureCall(request);
   *   // Do something.
   *   CapacityCommitment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MergeCapacityCommitmentsRequest, CapacityCommitment>
      mergeCapacityCommitmentsCallable() {
    return stub.mergeCapacityCommitmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an assignment object which allows the given project to submit jobs of a certain type
   * using slots from the specified reservation.
   *
   * <p>Currently a resource (project, folder, organization) can only have one assignment per each
   * (job_type, location) combination, and that reservation will be used for all jobs of the
   * matching type.
   *
   * <p>Different assignments can be created on different levels of the projects, folders or
   * organization hierarchy. During query execution, the assignment is looked up at the project,
   * folder and organization levels in that order. The first assignment found is applied to the
   * query.
   *
   * <p>When creating assignments, it does not matter if other assignments exist at higher levels.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>The organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Assignments for all three entities (`organizationA`, `project1`, and `project2`) could
   *       all be created and mapped to the same or different reservations.
   * </ul>
   *
   * <p>"None" assignments represent an absence of the assignment. Projects assigned to None use
   * on-demand pricing. To create a "None" assignment, use "none" as a reservation_id in the parent.
   * Example parent: `projects/myproject/locations/US/reservations/none`.
   *
   * <p>Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin'
   * permissions on the project using the reservation and the project that owns this reservation.
   *
   * <p>Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match
   * location of the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   Assignment assignment = Assignment.newBuilder().build();
   *   Assignment response = reservationServiceClient.createAssignment(parent, assignment);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name of the assignment E.g.
   *     `projects/myproject/locations/US/reservations/team1-prod`
   * @param assignment Assignment resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment createAssignment(ReservationName parent, Assignment assignment) {
    CreateAssignmentRequest request =
        CreateAssignmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAssignment(assignment)
            .build();
    return createAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an assignment object which allows the given project to submit jobs of a certain type
   * using slots from the specified reservation.
   *
   * <p>Currently a resource (project, folder, organization) can only have one assignment per each
   * (job_type, location) combination, and that reservation will be used for all jobs of the
   * matching type.
   *
   * <p>Different assignments can be created on different levels of the projects, folders or
   * organization hierarchy. During query execution, the assignment is looked up at the project,
   * folder and organization levels in that order. The first assignment found is applied to the
   * query.
   *
   * <p>When creating assignments, it does not matter if other assignments exist at higher levels.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>The organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Assignments for all three entities (`organizationA`, `project1`, and `project2`) could
   *       all be created and mapped to the same or different reservations.
   * </ul>
   *
   * <p>"None" assignments represent an absence of the assignment. Projects assigned to None use
   * on-demand pricing. To create a "None" assignment, use "none" as a reservation_id in the parent.
   * Example parent: `projects/myproject/locations/US/reservations/none`.
   *
   * <p>Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin'
   * permissions on the project using the reservation and the project that owns this reservation.
   *
   * <p>Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match
   * location of the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString();
   *   Assignment assignment = Assignment.newBuilder().build();
   *   Assignment response = reservationServiceClient.createAssignment(parent, assignment);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name of the assignment E.g.
   *     `projects/myproject/locations/US/reservations/team1-prod`
   * @param assignment Assignment resource to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment createAssignment(String parent, Assignment assignment) {
    CreateAssignmentRequest request =
        CreateAssignmentRequest.newBuilder().setParent(parent).setAssignment(assignment).build();
    return createAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an assignment object which allows the given project to submit jobs of a certain type
   * using slots from the specified reservation.
   *
   * <p>Currently a resource (project, folder, organization) can only have one assignment per each
   * (job_type, location) combination, and that reservation will be used for all jobs of the
   * matching type.
   *
   * <p>Different assignments can be created on different levels of the projects, folders or
   * organization hierarchy. During query execution, the assignment is looked up at the project,
   * folder and organization levels in that order. The first assignment found is applied to the
   * query.
   *
   * <p>When creating assignments, it does not matter if other assignments exist at higher levels.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>The organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Assignments for all three entities (`organizationA`, `project1`, and `project2`) could
   *       all be created and mapped to the same or different reservations.
   * </ul>
   *
   * <p>"None" assignments represent an absence of the assignment. Projects assigned to None use
   * on-demand pricing. To create a "None" assignment, use "none" as a reservation_id in the parent.
   * Example parent: `projects/myproject/locations/US/reservations/none`.
   *
   * <p>Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin'
   * permissions on the project using the reservation and the project that owns this reservation.
   *
   * <p>Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match
   * location of the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CreateAssignmentRequest request =
   *       CreateAssignmentRequest.newBuilder()
   *           .setParent(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .setAssignment(Assignment.newBuilder().build())
   *           .setAssignmentId("assignmentId-1603989304")
   *           .build();
   *   Assignment response = reservationServiceClient.createAssignment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment createAssignment(CreateAssignmentRequest request) {
    return createAssignmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an assignment object which allows the given project to submit jobs of a certain type
   * using slots from the specified reservation.
   *
   * <p>Currently a resource (project, folder, organization) can only have one assignment per each
   * (job_type, location) combination, and that reservation will be used for all jobs of the
   * matching type.
   *
   * <p>Different assignments can be created on different levels of the projects, folders or
   * organization hierarchy. During query execution, the assignment is looked up at the project,
   * folder and organization levels in that order. The first assignment found is applied to the
   * query.
   *
   * <p>When creating assignments, it does not matter if other assignments exist at higher levels.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>The organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Assignments for all three entities (`organizationA`, `project1`, and `project2`) could
   *       all be created and mapped to the same or different reservations.
   * </ul>
   *
   * <p>"None" assignments represent an absence of the assignment. Projects assigned to None use
   * on-demand pricing. To create a "None" assignment, use "none" as a reservation_id in the parent.
   * Example parent: `projects/myproject/locations/US/reservations/none`.
   *
   * <p>Returns `google.rpc.Code.PERMISSION_DENIED` if user does not have 'bigquery.admin'
   * permissions on the project using the reservation and the project that owns this reservation.
   *
   * <p>Returns `google.rpc.Code.INVALID_ARGUMENT` when location of the assignment does not match
   * location of the reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CreateAssignmentRequest request =
   *       CreateAssignmentRequest.newBuilder()
   *           .setParent(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .setAssignment(Assignment.newBuilder().build())
   *           .setAssignmentId("assignmentId-1603989304")
   *           .build();
   *   ApiFuture<Assignment> future =
   *       reservationServiceClient.createAssignmentCallable().futureCall(request);
   *   // Do something.
   *   Assignment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAssignmentRequest, Assignment> createAssignmentCallable() {
    return stub.createAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assignments.
   *
   * <p>Only explicitly created assignments will be returned.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Reservation `res1` exists and was created previously.
   *   <li>CreateAssignment was used previously to define the following associations between
   *       entities and reservations: `&lt;organizationA, res1&gt;` and `&lt;project1, res1&gt;`
   * </ul>
   *
   * <p>In this example, ListAssignments will just return the above two assignments for reservation
   * `res1`, and no expansion/merge will happen.
   *
   * <p>The wildcard "-" can be used for reservations in the request. In that case all assignments
   * belongs to the specified project and location will be listed.
   *
   * <p>&#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationName parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   for (Assignment element : reservationServiceClient.listAssignments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name e.g.:
   *     <p>`projects/myproject/locations/US/reservations/team1-prod`
   *     <p>Or:
   *     <p>`projects/myproject/locations/US/reservations/-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssignmentsPagedResponse listAssignments(ReservationName parent) {
    ListAssignmentsRequest request =
        ListAssignmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assignments.
   *
   * <p>Only explicitly created assignments will be returned.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Reservation `res1` exists and was created previously.
   *   <li>CreateAssignment was used previously to define the following associations between
   *       entities and reservations: `&lt;organizationA, res1&gt;` and `&lt;project1, res1&gt;`
   * </ul>
   *
   * <p>In this example, ListAssignments will just return the above two assignments for reservation
   * `res1`, and no expansion/merge will happen.
   *
   * <p>The wildcard "-" can be used for reservations in the request. In that case all assignments
   * belongs to the specified project and location will be listed.
   *
   * <p>&#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String parent = ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString();
   *   for (Assignment element : reservationServiceClient.listAssignments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name e.g.:
   *     <p>`projects/myproject/locations/US/reservations/team1-prod`
   *     <p>Or:
   *     <p>`projects/myproject/locations/US/reservations/-`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssignmentsPagedResponse listAssignments(String parent) {
    ListAssignmentsRequest request = ListAssignmentsRequest.newBuilder().setParent(parent).build();
    return listAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assignments.
   *
   * <p>Only explicitly created assignments will be returned.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Reservation `res1` exists and was created previously.
   *   <li>CreateAssignment was used previously to define the following associations between
   *       entities and reservations: `&lt;organizationA, res1&gt;` and `&lt;project1, res1&gt;`
   * </ul>
   *
   * <p>In this example, ListAssignments will just return the above two assignments for reservation
   * `res1`, and no expansion/merge will happen.
   *
   * <p>The wildcard "-" can be used for reservations in the request. In that case all assignments
   * belongs to the specified project and location will be listed.
   *
   * <p>&#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListAssignmentsRequest request =
   *       ListAssignmentsRequest.newBuilder()
   *           .setParent(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Assignment element : reservationServiceClient.listAssignments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAssignmentsPagedResponse listAssignments(ListAssignmentsRequest request) {
    return listAssignmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assignments.
   *
   * <p>Only explicitly created assignments will be returned.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Reservation `res1` exists and was created previously.
   *   <li>CreateAssignment was used previously to define the following associations between
   *       entities and reservations: `&lt;organizationA, res1&gt;` and `&lt;project1, res1&gt;`
   * </ul>
   *
   * <p>In this example, ListAssignments will just return the above two assignments for reservation
   * `res1`, and no expansion/merge will happen.
   *
   * <p>The wildcard "-" can be used for reservations in the request. In that case all assignments
   * belongs to the specified project and location will be listed.
   *
   * <p>&#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListAssignmentsRequest request =
   *       ListAssignmentsRequest.newBuilder()
   *           .setParent(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Assignment> future =
   *       reservationServiceClient.listAssignmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Assignment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAssignmentsRequest, ListAssignmentsPagedResponse>
      listAssignmentsPagedCallable() {
    return stub.listAssignmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assignments.
   *
   * <p>Only explicitly created assignments will be returned.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Reservation `res1` exists and was created previously.
   *   <li>CreateAssignment was used previously to define the following associations between
   *       entities and reservations: `&lt;organizationA, res1&gt;` and `&lt;project1, res1&gt;`
   * </ul>
   *
   * <p>In this example, ListAssignments will just return the above two assignments for reservation
   * `res1`, and no expansion/merge will happen.
   *
   * <p>The wildcard "-" can be used for reservations in the request. In that case all assignments
   * belongs to the specified project and location will be listed.
   *
   * <p>&#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListAssignmentsRequest request =
   *       ListAssignmentsRequest.newBuilder()
   *           .setParent(ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAssignmentsResponse response =
   *         reservationServiceClient.listAssignmentsCallable().call(request);
   *     for (Assignment element : response.getAssignmentsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAssignmentsRequest, ListAssignmentsResponse>
      listAssignmentsCallable() {
    return stub.listAssignmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a assignment. No expansion will happen.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Reservation `res1` exists and was created previously.
   *   <li>CreateAssignment was used previously to define the following associations between
   *       entities and reservations: `&lt;organizationA, res1&gt;` and `&lt;project1, res1&gt;`
   * </ul>
   *
   * <p>In this example, deletion of the `&lt;organizationA, res1&gt;` assignment won't affect the
   * other assignment `&lt;project1, res1&gt;`. After said deletion, queries from `project1` will
   * still use `res1` while queries from `project2` will switch to use on-demand mode.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name =
   *       AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   reservationServiceClient.deleteAssignment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, e.g.
   *     `projects/myproject/locations/US/reservations/team1-prod/assignments/123`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssignment(AssignmentName name) {
    DeleteAssignmentRequest request =
        DeleteAssignmentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a assignment. No expansion will happen.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Reservation `res1` exists and was created previously.
   *   <li>CreateAssignment was used previously to define the following associations between
   *       entities and reservations: `&lt;organizationA, res1&gt;` and `&lt;project1, res1&gt;`
   * </ul>
   *
   * <p>In this example, deletion of the `&lt;organizationA, res1&gt;` assignment won't affect the
   * other assignment `&lt;project1, res1&gt;`. After said deletion, queries from `project1` will
   * still use `res1` while queries from `project2` will switch to use on-demand mode.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name =
   *       AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]").toString();
   *   reservationServiceClient.deleteAssignment(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource, e.g.
   *     `projects/myproject/locations/US/reservations/team1-prod/assignments/123`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssignment(String name) {
    DeleteAssignmentRequest request = DeleteAssignmentRequest.newBuilder().setName(name).build();
    deleteAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a assignment. No expansion will happen.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Reservation `res1` exists and was created previously.
   *   <li>CreateAssignment was used previously to define the following associations between
   *       entities and reservations: `&lt;organizationA, res1&gt;` and `&lt;project1, res1&gt;`
   * </ul>
   *
   * <p>In this example, deletion of the `&lt;organizationA, res1&gt;` assignment won't affect the
   * other assignment `&lt;project1, res1&gt;`. After said deletion, queries from `project1` will
   * still use `res1` while queries from `project2` will switch to use on-demand mode.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   DeleteAssignmentRequest request =
   *       DeleteAssignmentRequest.newBuilder()
   *           .setName(
   *               AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
   *                   .toString())
   *           .build();
   *   reservationServiceClient.deleteAssignment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAssignment(DeleteAssignmentRequest request) {
    deleteAssignmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a assignment. No expansion will happen.
   *
   * <p>Example:
   *
   * <ul>
   *   <li>Organization `organizationA` contains two projects, `project1` and `project2`.
   *   <li>Reservation `res1` exists and was created previously.
   *   <li>CreateAssignment was used previously to define the following associations between
   *       entities and reservations: `&lt;organizationA, res1&gt;` and `&lt;project1, res1&gt;`
   * </ul>
   *
   * <p>In this example, deletion of the `&lt;organizationA, res1&gt;` assignment won't affect the
   * other assignment `&lt;project1, res1&gt;`. After said deletion, queries from `project1` will
   * still use `res1` while queries from `project2` will switch to use on-demand mode.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   DeleteAssignmentRequest request =
   *       DeleteAssignmentRequest.newBuilder()
   *           .setName(
   *               AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       reservationServiceClient.deleteAssignmentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAssignmentRequest, Empty> deleteAssignmentCallable() {
    return stub.deleteAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Looks up assignments for a specified resource for a particular region. If the
   * request is about a project:
   *
   * <p>1. Assignments created on the project will be returned if they exist. 2. Otherwise
   * assignments created on the closest ancestor will be returned. 3. Assignments for different
   * JobTypes will all be returned.
   *
   * <p>The same logic applies if the request is about a folder.
   *
   * <p>If the request is about an organization, then assignments created on the organization will
   * be returned (organization doesn't have ancestors).
   *
   * <p>Comparing to ListAssignments, there are some behavior differences:
   *
   * <p>1. permission on the assignee will be verified in this API. 2. Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is
   * `projects/&#42;/locations/&#42;`, instead of
   * `projects/&#42;/locations/&#42;reservations/&#42;`.
   *
   * <p>&#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String query = "query107944136";
   *   for (Assignment element :
   *       reservationServiceClient.searchAssignments(parent, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the admin project(containing project and
   *     location), e.g.: `projects/myproject/locations/US`.
   * @param query Please specify resource name as assignee in the query.
   *     <p>Examples:
   *     <ul>
   *       <li>`assignee=projects/myproject`
   *       <li>`assignee=folders/123`
   *       <li>`assignee=organizations/456`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SearchAssignmentsPagedResponse searchAssignments(LocationName parent, String query) {
    SearchAssignmentsRequest request =
        SearchAssignmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQuery(query)
            .build();
    return searchAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Looks up assignments for a specified resource for a particular region. If the
   * request is about a project:
   *
   * <p>1. Assignments created on the project will be returned if they exist. 2. Otherwise
   * assignments created on the closest ancestor will be returned. 3. Assignments for different
   * JobTypes will all be returned.
   *
   * <p>The same logic applies if the request is about a folder.
   *
   * <p>If the request is about an organization, then assignments created on the organization will
   * be returned (organization doesn't have ancestors).
   *
   * <p>Comparing to ListAssignments, there are some behavior differences:
   *
   * <p>1. permission on the assignee will be verified in this API. 2. Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is
   * `projects/&#42;/locations/&#42;`, instead of
   * `projects/&#42;/locations/&#42;reservations/&#42;`.
   *
   * <p>&#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String query = "query107944136";
   *   for (Assignment element :
   *       reservationServiceClient.searchAssignments(parent, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the admin project(containing project and
   *     location), e.g.: `projects/myproject/locations/US`.
   * @param query Please specify resource name as assignee in the query.
   *     <p>Examples:
   *     <ul>
   *       <li>`assignee=projects/myproject`
   *       <li>`assignee=folders/123`
   *       <li>`assignee=organizations/456`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SearchAssignmentsPagedResponse searchAssignments(String parent, String query) {
    SearchAssignmentsRequest request =
        SearchAssignmentsRequest.newBuilder().setParent(parent).setQuery(query).build();
    return searchAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Looks up assignments for a specified resource for a particular region. If the
   * request is about a project:
   *
   * <p>1. Assignments created on the project will be returned if they exist. 2. Otherwise
   * assignments created on the closest ancestor will be returned. 3. Assignments for different
   * JobTypes will all be returned.
   *
   * <p>The same logic applies if the request is about a folder.
   *
   * <p>If the request is about an organization, then assignments created on the organization will
   * be returned (organization doesn't have ancestors).
   *
   * <p>Comparing to ListAssignments, there are some behavior differences:
   *
   * <p>1. permission on the assignee will be verified in this API. 2. Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is
   * `projects/&#42;/locations/&#42;`, instead of
   * `projects/&#42;/locations/&#42;reservations/&#42;`.
   *
   * <p>&#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   SearchAssignmentsRequest request =
   *       SearchAssignmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Assignment element : reservationServiceClient.searchAssignments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final SearchAssignmentsPagedResponse searchAssignments(SearchAssignmentsRequest request) {
    return searchAssignmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Looks up assignments for a specified resource for a particular region. If the
   * request is about a project:
   *
   * <p>1. Assignments created on the project will be returned if they exist. 2. Otherwise
   * assignments created on the closest ancestor will be returned. 3. Assignments for different
   * JobTypes will all be returned.
   *
   * <p>The same logic applies if the request is about a folder.
   *
   * <p>If the request is about an organization, then assignments created on the organization will
   * be returned (organization doesn't have ancestors).
   *
   * <p>Comparing to ListAssignments, there are some behavior differences:
   *
   * <p>1. permission on the assignee will be verified in this API. 2. Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is
   * `projects/&#42;/locations/&#42;`, instead of
   * `projects/&#42;/locations/&#42;reservations/&#42;`.
   *
   * <p>&#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   SearchAssignmentsRequest request =
   *       SearchAssignmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Assignment> future =
   *       reservationServiceClient.searchAssignmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Assignment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsPagedResponse>
      searchAssignmentsPagedCallable() {
    return stub.searchAssignmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deprecated: Looks up assignments for a specified resource for a particular region. If the
   * request is about a project:
   *
   * <p>1. Assignments created on the project will be returned if they exist. 2. Otherwise
   * assignments created on the closest ancestor will be returned. 3. Assignments for different
   * JobTypes will all be returned.
   *
   * <p>The same logic applies if the request is about a folder.
   *
   * <p>If the request is about an organization, then assignments created on the organization will
   * be returned (organization doesn't have ancestors).
   *
   * <p>Comparing to ListAssignments, there are some behavior differences:
   *
   * <p>1. permission on the assignee will be verified in this API. 2. Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is
   * `projects/&#42;/locations/&#42;`, instead of
   * `projects/&#42;/locations/&#42;reservations/&#42;`.
   *
   * <p>&#42;&#42;Note&#42;&#42; "-" cannot be used for projects nor locations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   SearchAssignmentsRequest request =
   *       SearchAssignmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchAssignmentsResponse response =
   *         reservationServiceClient.searchAssignmentsCallable().call(request);
   *     for (Assignment element : response.getAssignmentsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public final UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsResponse>
      searchAssignmentsCallable() {
    return stub.searchAssignmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up assignments for a specified resource for a particular region. If the request is about
   * a project:
   *
   * <p>1. Assignments created on the project will be returned if they exist. 2. Otherwise
   * assignments created on the closest ancestor will be returned. 3. Assignments for different
   * JobTypes will all be returned.
   *
   * <p>The same logic applies if the request is about a folder.
   *
   * <p>If the request is about an organization, then assignments created on the organization will
   * be returned (organization doesn't have ancestors).
   *
   * <p>Comparing to ListAssignments, there are some behavior differences:
   *
   * <p>1. permission on the assignee will be verified in this API. 2. Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is
   * `projects/&#42;/locations/&#42;`, instead of
   * `projects/&#42;/locations/&#42;reservations/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String query = "query107944136";
   *   for (Assignment element :
   *       reservationServiceClient.searchAllAssignments(parent, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name with location (project name could be the wildcard
   *     '-'), e.g.: `projects/-/locations/US`.
   * @param query Please specify resource name as assignee in the query.
   *     <p>Examples:
   *     <ul>
   *       <li>`assignee=projects/myproject`
   *       <li>`assignee=folders/123`
   *       <li>`assignee=organizations/456`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllAssignmentsPagedResponse searchAllAssignments(
      LocationName parent, String query) {
    SearchAllAssignmentsRequest request =
        SearchAllAssignmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setQuery(query)
            .build();
    return searchAllAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up assignments for a specified resource for a particular region. If the request is about
   * a project:
   *
   * <p>1. Assignments created on the project will be returned if they exist. 2. Otherwise
   * assignments created on the closest ancestor will be returned. 3. Assignments for different
   * JobTypes will all be returned.
   *
   * <p>The same logic applies if the request is about a folder.
   *
   * <p>If the request is about an organization, then assignments created on the organization will
   * be returned (organization doesn't have ancestors).
   *
   * <p>Comparing to ListAssignments, there are some behavior differences:
   *
   * <p>1. permission on the assignee will be verified in this API. 2. Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is
   * `projects/&#42;/locations/&#42;`, instead of
   * `projects/&#42;/locations/&#42;reservations/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String query = "query107944136";
   *   for (Assignment element :
   *       reservationServiceClient.searchAllAssignments(parent, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name with location (project name could be the wildcard
   *     '-'), e.g.: `projects/-/locations/US`.
   * @param query Please specify resource name as assignee in the query.
   *     <p>Examples:
   *     <ul>
   *       <li>`assignee=projects/myproject`
   *       <li>`assignee=folders/123`
   *       <li>`assignee=organizations/456`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllAssignmentsPagedResponse searchAllAssignments(String parent, String query) {
    SearchAllAssignmentsRequest request =
        SearchAllAssignmentsRequest.newBuilder().setParent(parent).setQuery(query).build();
    return searchAllAssignments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up assignments for a specified resource for a particular region. If the request is about
   * a project:
   *
   * <p>1. Assignments created on the project will be returned if they exist. 2. Otherwise
   * assignments created on the closest ancestor will be returned. 3. Assignments for different
   * JobTypes will all be returned.
   *
   * <p>The same logic applies if the request is about a folder.
   *
   * <p>If the request is about an organization, then assignments created on the organization will
   * be returned (organization doesn't have ancestors).
   *
   * <p>Comparing to ListAssignments, there are some behavior differences:
   *
   * <p>1. permission on the assignee will be verified in this API. 2. Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is
   * `projects/&#42;/locations/&#42;`, instead of
   * `projects/&#42;/locations/&#42;reservations/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   SearchAllAssignmentsRequest request =
   *       SearchAllAssignmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Assignment element :
   *       reservationServiceClient.searchAllAssignments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllAssignmentsPagedResponse searchAllAssignments(
      SearchAllAssignmentsRequest request) {
    return searchAllAssignmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up assignments for a specified resource for a particular region. If the request is about
   * a project:
   *
   * <p>1. Assignments created on the project will be returned if they exist. 2. Otherwise
   * assignments created on the closest ancestor will be returned. 3. Assignments for different
   * JobTypes will all be returned.
   *
   * <p>The same logic applies if the request is about a folder.
   *
   * <p>If the request is about an organization, then assignments created on the organization will
   * be returned (organization doesn't have ancestors).
   *
   * <p>Comparing to ListAssignments, there are some behavior differences:
   *
   * <p>1. permission on the assignee will be verified in this API. 2. Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is
   * `projects/&#42;/locations/&#42;`, instead of
   * `projects/&#42;/locations/&#42;reservations/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   SearchAllAssignmentsRequest request =
   *       SearchAllAssignmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Assignment> future =
   *       reservationServiceClient.searchAllAssignmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Assignment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchAllAssignmentsRequest, SearchAllAssignmentsPagedResponse>
      searchAllAssignmentsPagedCallable() {
    return stub.searchAllAssignmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Looks up assignments for a specified resource for a particular region. If the request is about
   * a project:
   *
   * <p>1. Assignments created on the project will be returned if they exist. 2. Otherwise
   * assignments created on the closest ancestor will be returned. 3. Assignments for different
   * JobTypes will all be returned.
   *
   * <p>The same logic applies if the request is about a folder.
   *
   * <p>If the request is about an organization, then assignments created on the organization will
   * be returned (organization doesn't have ancestors).
   *
   * <p>Comparing to ListAssignments, there are some behavior differences:
   *
   * <p>1. permission on the assignee will be verified in this API. 2. Hierarchy lookup
   * (project-&gt;folder-&gt;organization) happens in this API. 3. Parent here is
   * `projects/&#42;/locations/&#42;`, instead of
   * `projects/&#42;/locations/&#42;reservations/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   SearchAllAssignmentsRequest request =
   *       SearchAllAssignmentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchAllAssignmentsResponse response =
   *         reservationServiceClient.searchAllAssignmentsCallable().call(request);
   *     for (Assignment element : response.getAssignmentsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>
      searchAllAssignmentsCallable() {
    return stub.searchAllAssignmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves an assignment under a new reservation.
   *
   * <p>This differs from removing an existing assignment and recreating a new one by providing a
   * transactional change that ensures an assignee always has an associated reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name =
   *       AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   ReservationName destinationId =
   *       ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   Assignment response = reservationServiceClient.moveAssignment(name, destinationId);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the assignment, e.g.
   *     `projects/myproject/locations/US/reservations/team1-prod/assignments/123`
   * @param destinationId The new reservation ID, e.g.:
   *     `projects/myotherproject/locations/US/reservations/team2-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment moveAssignment(AssignmentName name, ReservationName destinationId) {
    MoveAssignmentRequest request =
        MoveAssignmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationId(destinationId == null ? null : destinationId.toString())
            .build();
    return moveAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves an assignment under a new reservation.
   *
   * <p>This differs from removing an existing assignment and recreating a new one by providing a
   * transactional change that ensures an assignee always has an associated reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   AssignmentName name =
   *       AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   String destinationId =
   *       ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString();
   *   Assignment response = reservationServiceClient.moveAssignment(name, destinationId);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the assignment, e.g.
   *     `projects/myproject/locations/US/reservations/team1-prod/assignments/123`
   * @param destinationId The new reservation ID, e.g.:
   *     `projects/myotherproject/locations/US/reservations/team2-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment moveAssignment(AssignmentName name, String destinationId) {
    MoveAssignmentRequest request =
        MoveAssignmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationId(destinationId)
            .build();
    return moveAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves an assignment under a new reservation.
   *
   * <p>This differs from removing an existing assignment and recreating a new one by providing a
   * transactional change that ensures an assignee always has an associated reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name =
   *       AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]").toString();
   *   ReservationName destinationId =
   *       ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]");
   *   Assignment response = reservationServiceClient.moveAssignment(name, destinationId);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the assignment, e.g.
   *     `projects/myproject/locations/US/reservations/team1-prod/assignments/123`
   * @param destinationId The new reservation ID, e.g.:
   *     `projects/myotherproject/locations/US/reservations/team2-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment moveAssignment(String name, ReservationName destinationId) {
    MoveAssignmentRequest request =
        MoveAssignmentRequest.newBuilder()
            .setName(name)
            .setDestinationId(destinationId == null ? null : destinationId.toString())
            .build();
    return moveAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves an assignment under a new reservation.
   *
   * <p>This differs from removing an existing assignment and recreating a new one by providing a
   * transactional change that ensures an assignee always has an associated reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name =
   *       AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]").toString();
   *   String destinationId =
   *       ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString();
   *   Assignment response = reservationServiceClient.moveAssignment(name, destinationId);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the assignment, e.g.
   *     `projects/myproject/locations/US/reservations/team1-prod/assignments/123`
   * @param destinationId The new reservation ID, e.g.:
   *     `projects/myotherproject/locations/US/reservations/team2-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment moveAssignment(String name, String destinationId) {
    MoveAssignmentRequest request =
        MoveAssignmentRequest.newBuilder().setName(name).setDestinationId(destinationId).build();
    return moveAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves an assignment under a new reservation.
   *
   * <p>This differs from removing an existing assignment and recreating a new one by providing a
   * transactional change that ensures an assignee always has an associated reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   MoveAssignmentRequest request =
   *       MoveAssignmentRequest.newBuilder()
   *           .setName(
   *               AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
   *                   .toString())
   *           .setDestinationId(
   *               ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .setAssignmentId("assignmentId-1603989304")
   *           .build();
   *   Assignment response = reservationServiceClient.moveAssignment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment moveAssignment(MoveAssignmentRequest request) {
    return moveAssignmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves an assignment under a new reservation.
   *
   * <p>This differs from removing an existing assignment and recreating a new one by providing a
   * transactional change that ensures an assignee always has an associated reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   MoveAssignmentRequest request =
   *       MoveAssignmentRequest.newBuilder()
   *           .setName(
   *               AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
   *                   .toString())
   *           .setDestinationId(
   *               ReservationName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]").toString())
   *           .setAssignmentId("assignmentId-1603989304")
   *           .build();
   *   ApiFuture<Assignment> future =
   *       reservationServiceClient.moveAssignmentCallable().futureCall(request);
   *   // Do something.
   *   Assignment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveAssignmentRequest, Assignment> moveAssignmentCallable() {
    return stub.moveAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing assignment.
   *
   * <p>Only the `priority` field can be updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   Assignment assignment = Assignment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Assignment response = reservationServiceClient.updateAssignment(assignment, updateMask);
   * }
   * }</pre>
   *
   * @param assignment Content of the assignment to update.
   * @param updateMask Standard field mask for the set of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment updateAssignment(Assignment assignment, FieldMask updateMask) {
    UpdateAssignmentRequest request =
        UpdateAssignmentRequest.newBuilder()
            .setAssignment(assignment)
            .setUpdateMask(updateMask)
            .build();
    return updateAssignment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing assignment.
   *
   * <p>Only the `priority` field can be updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateAssignmentRequest request =
   *       UpdateAssignmentRequest.newBuilder()
   *           .setAssignment(Assignment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Assignment response = reservationServiceClient.updateAssignment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Assignment updateAssignment(UpdateAssignmentRequest request) {
    return updateAssignmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing assignment.
   *
   * <p>Only the `priority` field can be updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateAssignmentRequest request =
   *       UpdateAssignmentRequest.newBuilder()
   *           .setAssignment(Assignment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Assignment> future =
   *       reservationServiceClient.updateAssignmentCallable().futureCall(request);
   *   // Do something.
   *   Assignment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAssignmentRequest, Assignment> updateAssignmentCallable() {
    return stub.updateAssignmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a BI reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   BiReservationName name = BiReservationName.of("[PROJECT]", "[LOCATION]");
   *   BiReservation response = reservationServiceClient.getBiReservation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the requested reservation, for example:
   *     `projects/{project_id}/locations/{location_id}/biReservation`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BiReservation getBiReservation(BiReservationName name) {
    GetBiReservationRequest request =
        GetBiReservationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBiReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a BI reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name = BiReservationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BiReservation response = reservationServiceClient.getBiReservation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the requested reservation, for example:
   *     `projects/{project_id}/locations/{location_id}/biReservation`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BiReservation getBiReservation(String name) {
    GetBiReservationRequest request = GetBiReservationRequest.newBuilder().setName(name).build();
    return getBiReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a BI reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   GetBiReservationRequest request =
   *       GetBiReservationRequest.newBuilder()
   *           .setName(BiReservationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   BiReservation response = reservationServiceClient.getBiReservation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BiReservation getBiReservation(GetBiReservationRequest request) {
    return getBiReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a BI reservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   GetBiReservationRequest request =
   *       GetBiReservationRequest.newBuilder()
   *           .setName(BiReservationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<BiReservation> future =
   *       reservationServiceClient.getBiReservationCallable().futureCall(request);
   *   // Do something.
   *   BiReservation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBiReservationRequest, BiReservation> getBiReservationCallable() {
    return stub.getBiReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a BI reservation.
   *
   * <p>Only fields specified in the `field_mask` are updated.
   *
   * <p>A singleton BI reservation always exists with default size 0. In order to reserve BI
   * capacity it needs to be updated to an amount greater than 0. In order to release BI capacity
   * reservation size must be set to 0.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   BiReservation biReservation = BiReservation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BiReservation response =
   *       reservationServiceClient.updateBiReservation(biReservation, updateMask);
   * }
   * }</pre>
   *
   * @param biReservation A reservation to update.
   * @param updateMask A list of fields to be updated in this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BiReservation updateBiReservation(
      BiReservation biReservation, FieldMask updateMask) {
    UpdateBiReservationRequest request =
        UpdateBiReservationRequest.newBuilder()
            .setBiReservation(biReservation)
            .setUpdateMask(updateMask)
            .build();
    return updateBiReservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a BI reservation.
   *
   * <p>Only fields specified in the `field_mask` are updated.
   *
   * <p>A singleton BI reservation always exists with default size 0. In order to reserve BI
   * capacity it needs to be updated to an amount greater than 0. In order to release BI capacity
   * reservation size must be set to 0.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateBiReservationRequest request =
   *       UpdateBiReservationRequest.newBuilder()
   *           .setBiReservation(BiReservation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BiReservation response = reservationServiceClient.updateBiReservation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BiReservation updateBiReservation(UpdateBiReservationRequest request) {
    return updateBiReservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a BI reservation.
   *
   * <p>Only fields specified in the `field_mask` are updated.
   *
   * <p>A singleton BI reservation always exists with default size 0. In order to reserve BI
   * capacity it needs to be updated to an amount greater than 0. In order to release BI capacity
   * reservation size must be set to 0.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   UpdateBiReservationRequest request =
   *       UpdateBiReservationRequest.newBuilder()
   *           .setBiReservation(BiReservation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<BiReservation> future =
   *       reservationServiceClient.updateBiReservationCallable().futureCall(request);
   *   // Do something.
   *   BiReservation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBiReservationRequest, BiReservation>
      updateBiReservationCallable() {
    return stub.updateBiReservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May return:
   *
   * <ul>
   *   <li>A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view
   *       it.
   *   <li>An empty policy if the resource exists but doesn't have a set policy.
   * </ul>
   *
   * <p>Supported resources are: - Reservations - ReservationAssignments
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `bigqueryreservation.reservations.getIamPolicy` to get policies on reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ResourceName resource =
   *       AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   Policy response = reservationServiceClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May return:
   *
   * <ul>
   *   <li>A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view
   *       it.
   *   <li>An empty policy if the resource exists but doesn't have a set policy.
   * </ul>
   *
   * <p>Supported resources are: - Reservations - ReservationAssignments
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `bigqueryreservation.reservations.getIamPolicy` to get policies on reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String resource =
   *       AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]").toString();
   *   Policy response = reservationServiceClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May return:
   *
   * <ul>
   *   <li>A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view
   *       it.
   *   <li>An empty policy if the resource exists but doesn't have a set policy.
   * </ul>
   *
   * <p>Supported resources are: - Reservations - ReservationAssignments
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `bigqueryreservation.reservations.getIamPolicy` to get policies on reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = reservationServiceClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May return:
   *
   * <ul>
   *   <li>A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view
   *       it.
   *   <li>An empty policy if the resource exists but doesn't have a set policy.
   * </ul>
   *
   * <p>Supported resources are: - Reservations - ReservationAssignments
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `bigqueryreservation.reservations.getIamPolicy` to get policies on reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       reservationServiceClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets an access control policy for a resource. Replaces any existing policy.
   *
   * <p>Supported resources are: - Reservations
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `bigqueryreservation.reservations.setIamPolicy` to set policies on reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ResourceName resource =
   *       AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = reservationServiceClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets an access control policy for a resource. Replaces any existing policy.
   *
   * <p>Supported resources are: - Reservations
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `bigqueryreservation.reservations.setIamPolicy` to set policies on reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String resource =
   *       AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = reservationServiceClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets an access control policy for a resource. Replaces any existing policy.
   *
   * <p>Supported resources are: - Reservations
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `bigqueryreservation.reservations.setIamPolicy` to set policies on reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = reservationServiceClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets an access control policy for a resource. Replaces any existing policy.
   *
   * <p>Supported resources are: - Reservations
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `bigqueryreservation.reservations.setIamPolicy` to set policies on reservations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       reservationServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets your permissions on a resource. Returns an empty set of permissions if the resource
   * doesn't exist.
   *
   * <p>Supported resources are: - Reservations
   *
   * <p>No Google IAM permissions are required to call this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = reservationServiceClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets your permissions on a resource. Returns an empty set of permissions if the resource
   * doesn't exist.
   *
   * <p>Supported resources are: - Reservations
   *
   * <p>No Google IAM permissions are required to call this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AssignmentName.of("[PROJECT]", "[LOCATION]", "[RESERVATION]", "[ASSIGNMENT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       reservationServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reservation group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CreateReservationGroupRequest request =
   *       CreateReservationGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReservationGroupId("reservationGroupId-1636887922")
   *           .setReservationGroup(ReservationGroup.newBuilder().build())
   *           .build();
   *   ReservationGroup response = reservationServiceClient.createReservationGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReservationGroup createReservationGroup(CreateReservationGroupRequest request) {
    return createReservationGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reservation group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   CreateReservationGroupRequest request =
   *       CreateReservationGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReservationGroupId("reservationGroupId-1636887922")
   *           .setReservationGroup(ReservationGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<ReservationGroup> future =
   *       reservationServiceClient.createReservationGroupCallable().futureCall(request);
   *   // Do something.
   *   ReservationGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReservationGroupRequest, ReservationGroup>
      createReservationGroupCallable() {
    return stub.createReservationGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the reservation group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationGroupName name =
   *       ReservationGroupName.of("[PROJECT]", "[LOCATION]", "[RESERVATION_GROUP]");
   *   ReservationGroup response = reservationServiceClient.getReservationGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the reservation group to retrieve. E.g.,
   *     `projects/myproject/locations/US/reservationGroups/team1-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReservationGroup getReservationGroup(ReservationGroupName name) {
    GetReservationGroupRequest request =
        GetReservationGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getReservationGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the reservation group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name =
   *       ReservationGroupName.of("[PROJECT]", "[LOCATION]", "[RESERVATION_GROUP]").toString();
   *   ReservationGroup response = reservationServiceClient.getReservationGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the reservation group to retrieve. E.g.,
   *     `projects/myproject/locations/US/reservationGroups/team1-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReservationGroup getReservationGroup(String name) {
    GetReservationGroupRequest request =
        GetReservationGroupRequest.newBuilder().setName(name).build();
    return getReservationGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the reservation group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   GetReservationGroupRequest request =
   *       GetReservationGroupRequest.newBuilder()
   *           .setName(
   *               ReservationGroupName.of("[PROJECT]", "[LOCATION]", "[RESERVATION_GROUP]")
   *                   .toString())
   *           .build();
   *   ReservationGroup response = reservationServiceClient.getReservationGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReservationGroup getReservationGroup(GetReservationGroupRequest request) {
    return getReservationGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns information about the reservation group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   GetReservationGroupRequest request =
   *       GetReservationGroupRequest.newBuilder()
   *           .setName(
   *               ReservationGroupName.of("[PROJECT]", "[LOCATION]", "[RESERVATION_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ReservationGroup> future =
   *       reservationServiceClient.getReservationGroupCallable().futureCall(request);
   *   // Do something.
   *   ReservationGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReservationGroupRequest, ReservationGroup>
      getReservationGroupCallable() {
    return stub.getReservationGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ReservationGroupName name =
   *       ReservationGroupName.of("[PROJECT]", "[LOCATION]", "[RESERVATION_GROUP]");
   *   reservationServiceClient.deleteReservationGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the reservation group to retrieve. E.g.,
   *     `projects/myproject/locations/US/reservationGroups/team1-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReservationGroup(ReservationGroupName name) {
    DeleteReservationGroupRequest request =
        DeleteReservationGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteReservationGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String name =
   *       ReservationGroupName.of("[PROJECT]", "[LOCATION]", "[RESERVATION_GROUP]").toString();
   *   reservationServiceClient.deleteReservationGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name of the reservation group to retrieve. E.g.,
   *     `projects/myproject/locations/US/reservationGroups/team1-prod`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReservationGroup(String name) {
    DeleteReservationGroupRequest request =
        DeleteReservationGroupRequest.newBuilder().setName(name).build();
    deleteReservationGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   DeleteReservationGroupRequest request =
   *       DeleteReservationGroupRequest.newBuilder()
   *           .setName(
   *               ReservationGroupName.of("[PROJECT]", "[LOCATION]", "[RESERVATION_GROUP]")
   *                   .toString())
   *           .build();
   *   reservationServiceClient.deleteReservationGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReservationGroup(DeleteReservationGroupRequest request) {
    deleteReservationGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reservation. Returns `google.rpc.Code.FAILED_PRECONDITION` when reservation has
   * assignments.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   DeleteReservationGroupRequest request =
   *       DeleteReservationGroupRequest.newBuilder()
   *           .setName(
   *               ReservationGroupName.of("[PROJECT]", "[LOCATION]", "[RESERVATION_GROUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       reservationServiceClient.deleteReservationGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReservationGroupRequest, Empty>
      deleteReservationGroupCallable() {
    return stub.deleteReservationGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the reservation groups for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ReservationGroup element :
   *       reservationServiceClient.listReservationGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name containing project and location, e.g.:
   *     `projects/myproject/locations/US`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReservationGroupsPagedResponse listReservationGroups(LocationName parent) {
    ListReservationGroupsRequest request =
        ListReservationGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReservationGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the reservation groups for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ReservationGroup element :
   *       reservationServiceClient.listReservationGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name containing project and location, e.g.:
   *     `projects/myproject/locations/US`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReservationGroupsPagedResponse listReservationGroups(String parent) {
    ListReservationGroupsRequest request =
        ListReservationGroupsRequest.newBuilder().setParent(parent).build();
    return listReservationGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the reservation groups for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListReservationGroupsRequest request =
   *       ListReservationGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ReservationGroup element :
   *       reservationServiceClient.listReservationGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReservationGroupsPagedResponse listReservationGroups(
      ListReservationGroupsRequest request) {
    return listReservationGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the reservation groups for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListReservationGroupsRequest request =
   *       ListReservationGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ReservationGroup> future =
   *       reservationServiceClient.listReservationGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReservationGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReservationGroupsRequest, ListReservationGroupsPagedResponse>
      listReservationGroupsPagedCallable() {
    return stub.listReservationGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the reservation groups for the project in the specified location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReservationServiceClient reservationServiceClient = ReservationServiceClient.create()) {
   *   ListReservationGroupsRequest request =
   *       ListReservationGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListReservationGroupsResponse response =
   *         reservationServiceClient.listReservationGroupsCallable().call(request);
   *     for (ReservationGroup element : response.getReservationGroupsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReservationGroupsRequest, ListReservationGroupsResponse>
      listReservationGroupsCallable() {
    return stub.listReservationGroupsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListReservationsPagedResponse
      extends AbstractPagedListResponse<
          ListReservationsRequest,
          ListReservationsResponse,
          Reservation,
          ListReservationsPage,
          ListReservationsFixedSizeCollection> {

    public static ApiFuture<ListReservationsPagedResponse> createAsync(
        PageContext<ListReservationsRequest, ListReservationsResponse, Reservation> context,
        ApiFuture<ListReservationsResponse> futureResponse) {
      ApiFuture<ListReservationsPage> futurePage =
          ListReservationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReservationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReservationsPagedResponse(ListReservationsPage page) {
      super(page, ListReservationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReservationsPage
      extends AbstractPage<
          ListReservationsRequest, ListReservationsResponse, Reservation, ListReservationsPage> {

    private ListReservationsPage(
        PageContext<ListReservationsRequest, ListReservationsResponse, Reservation> context,
        ListReservationsResponse response) {
      super(context, response);
    }

    private static ListReservationsPage createEmptyPage() {
      return new ListReservationsPage(null, null);
    }

    @Override
    protected ListReservationsPage createPage(
        PageContext<ListReservationsRequest, ListReservationsResponse, Reservation> context,
        ListReservationsResponse response) {
      return new ListReservationsPage(context, response);
    }

    @Override
    public ApiFuture<ListReservationsPage> createPageAsync(
        PageContext<ListReservationsRequest, ListReservationsResponse, Reservation> context,
        ApiFuture<ListReservationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReservationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReservationsRequest,
          ListReservationsResponse,
          Reservation,
          ListReservationsPage,
          ListReservationsFixedSizeCollection> {

    private ListReservationsFixedSizeCollection(
        List<ListReservationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReservationsFixedSizeCollection createEmptyCollection() {
      return new ListReservationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReservationsFixedSizeCollection createCollection(
        List<ListReservationsPage> pages, int collectionSize) {
      return new ListReservationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListCapacityCommitmentsPagedResponse
      extends AbstractPagedListResponse<
          ListCapacityCommitmentsRequest,
          ListCapacityCommitmentsResponse,
          CapacityCommitment,
          ListCapacityCommitmentsPage,
          ListCapacityCommitmentsFixedSizeCollection> {

    public static ApiFuture<ListCapacityCommitmentsPagedResponse> createAsync(
        PageContext<
                ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse, CapacityCommitment>
            context,
        ApiFuture<ListCapacityCommitmentsResponse> futureResponse) {
      ApiFuture<ListCapacityCommitmentsPage> futurePage =
          ListCapacityCommitmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCapacityCommitmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCapacityCommitmentsPagedResponse(ListCapacityCommitmentsPage page) {
      super(page, ListCapacityCommitmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCapacityCommitmentsPage
      extends AbstractPage<
          ListCapacityCommitmentsRequest,
          ListCapacityCommitmentsResponse,
          CapacityCommitment,
          ListCapacityCommitmentsPage> {

    private ListCapacityCommitmentsPage(
        PageContext<
                ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse, CapacityCommitment>
            context,
        ListCapacityCommitmentsResponse response) {
      super(context, response);
    }

    private static ListCapacityCommitmentsPage createEmptyPage() {
      return new ListCapacityCommitmentsPage(null, null);
    }

    @Override
    protected ListCapacityCommitmentsPage createPage(
        PageContext<
                ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse, CapacityCommitment>
            context,
        ListCapacityCommitmentsResponse response) {
      return new ListCapacityCommitmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListCapacityCommitmentsPage> createPageAsync(
        PageContext<
                ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse, CapacityCommitment>
            context,
        ApiFuture<ListCapacityCommitmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCapacityCommitmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCapacityCommitmentsRequest,
          ListCapacityCommitmentsResponse,
          CapacityCommitment,
          ListCapacityCommitmentsPage,
          ListCapacityCommitmentsFixedSizeCollection> {

    private ListCapacityCommitmentsFixedSizeCollection(
        List<ListCapacityCommitmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCapacityCommitmentsFixedSizeCollection createEmptyCollection() {
      return new ListCapacityCommitmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCapacityCommitmentsFixedSizeCollection createCollection(
        List<ListCapacityCommitmentsPage> pages, int collectionSize) {
      return new ListCapacityCommitmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAssignmentsPagedResponse
      extends AbstractPagedListResponse<
          ListAssignmentsRequest,
          ListAssignmentsResponse,
          Assignment,
          ListAssignmentsPage,
          ListAssignmentsFixedSizeCollection> {

    public static ApiFuture<ListAssignmentsPagedResponse> createAsync(
        PageContext<ListAssignmentsRequest, ListAssignmentsResponse, Assignment> context,
        ApiFuture<ListAssignmentsResponse> futureResponse) {
      ApiFuture<ListAssignmentsPage> futurePage =
          ListAssignmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAssignmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAssignmentsPagedResponse(ListAssignmentsPage page) {
      super(page, ListAssignmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAssignmentsPage
      extends AbstractPage<
          ListAssignmentsRequest, ListAssignmentsResponse, Assignment, ListAssignmentsPage> {

    private ListAssignmentsPage(
        PageContext<ListAssignmentsRequest, ListAssignmentsResponse, Assignment> context,
        ListAssignmentsResponse response) {
      super(context, response);
    }

    private static ListAssignmentsPage createEmptyPage() {
      return new ListAssignmentsPage(null, null);
    }

    @Override
    protected ListAssignmentsPage createPage(
        PageContext<ListAssignmentsRequest, ListAssignmentsResponse, Assignment> context,
        ListAssignmentsResponse response) {
      return new ListAssignmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListAssignmentsPage> createPageAsync(
        PageContext<ListAssignmentsRequest, ListAssignmentsResponse, Assignment> context,
        ApiFuture<ListAssignmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssignmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAssignmentsRequest,
          ListAssignmentsResponse,
          Assignment,
          ListAssignmentsPage,
          ListAssignmentsFixedSizeCollection> {

    private ListAssignmentsFixedSizeCollection(
        List<ListAssignmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAssignmentsFixedSizeCollection createEmptyCollection() {
      return new ListAssignmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAssignmentsFixedSizeCollection createCollection(
        List<ListAssignmentsPage> pages, int collectionSize) {
      return new ListAssignmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchAssignmentsPagedResponse
      extends AbstractPagedListResponse<
          SearchAssignmentsRequest,
          SearchAssignmentsResponse,
          Assignment,
          SearchAssignmentsPage,
          SearchAssignmentsFixedSizeCollection> {

    public static ApiFuture<SearchAssignmentsPagedResponse> createAsync(
        PageContext<SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment> context,
        ApiFuture<SearchAssignmentsResponse> futureResponse) {
      ApiFuture<SearchAssignmentsPage> futurePage =
          SearchAssignmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchAssignmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchAssignmentsPagedResponse(SearchAssignmentsPage page) {
      super(page, SearchAssignmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAssignmentsPage
      extends AbstractPage<
          SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment, SearchAssignmentsPage> {

    private SearchAssignmentsPage(
        PageContext<SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment> context,
        SearchAssignmentsResponse response) {
      super(context, response);
    }

    private static SearchAssignmentsPage createEmptyPage() {
      return new SearchAssignmentsPage(null, null);
    }

    @Override
    protected SearchAssignmentsPage createPage(
        PageContext<SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment> context,
        SearchAssignmentsResponse response) {
      return new SearchAssignmentsPage(context, response);
    }

    @Override
    public ApiFuture<SearchAssignmentsPage> createPageAsync(
        PageContext<SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment> context,
        ApiFuture<SearchAssignmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAssignmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAssignmentsRequest,
          SearchAssignmentsResponse,
          Assignment,
          SearchAssignmentsPage,
          SearchAssignmentsFixedSizeCollection> {

    private SearchAssignmentsFixedSizeCollection(
        List<SearchAssignmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAssignmentsFixedSizeCollection createEmptyCollection() {
      return new SearchAssignmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAssignmentsFixedSizeCollection createCollection(
        List<SearchAssignmentsPage> pages, int collectionSize) {
      return new SearchAssignmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchAllAssignmentsPagedResponse
      extends AbstractPagedListResponse<
          SearchAllAssignmentsRequest,
          SearchAllAssignmentsResponse,
          Assignment,
          SearchAllAssignmentsPage,
          SearchAllAssignmentsFixedSizeCollection> {

    public static ApiFuture<SearchAllAssignmentsPagedResponse> createAsync(
        PageContext<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse, Assignment> context,
        ApiFuture<SearchAllAssignmentsResponse> futureResponse) {
      ApiFuture<SearchAllAssignmentsPage> futurePage =
          SearchAllAssignmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchAllAssignmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchAllAssignmentsPagedResponse(SearchAllAssignmentsPage page) {
      super(page, SearchAllAssignmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAllAssignmentsPage
      extends AbstractPage<
          SearchAllAssignmentsRequest,
          SearchAllAssignmentsResponse,
          Assignment,
          SearchAllAssignmentsPage> {

    private SearchAllAssignmentsPage(
        PageContext<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse, Assignment> context,
        SearchAllAssignmentsResponse response) {
      super(context, response);
    }

    private static SearchAllAssignmentsPage createEmptyPage() {
      return new SearchAllAssignmentsPage(null, null);
    }

    @Override
    protected SearchAllAssignmentsPage createPage(
        PageContext<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse, Assignment> context,
        SearchAllAssignmentsResponse response) {
      return new SearchAllAssignmentsPage(context, response);
    }

    @Override
    public ApiFuture<SearchAllAssignmentsPage> createPageAsync(
        PageContext<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse, Assignment> context,
        ApiFuture<SearchAllAssignmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAllAssignmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAllAssignmentsRequest,
          SearchAllAssignmentsResponse,
          Assignment,
          SearchAllAssignmentsPage,
          SearchAllAssignmentsFixedSizeCollection> {

    private SearchAllAssignmentsFixedSizeCollection(
        List<SearchAllAssignmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAllAssignmentsFixedSizeCollection createEmptyCollection() {
      return new SearchAllAssignmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAllAssignmentsFixedSizeCollection createCollection(
        List<SearchAllAssignmentsPage> pages, int collectionSize) {
      return new SearchAllAssignmentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReservationGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListReservationGroupsRequest,
          ListReservationGroupsResponse,
          ReservationGroup,
          ListReservationGroupsPage,
          ListReservationGroupsFixedSizeCollection> {

    public static ApiFuture<ListReservationGroupsPagedResponse> createAsync(
        PageContext<ListReservationGroupsRequest, ListReservationGroupsResponse, ReservationGroup>
            context,
        ApiFuture<ListReservationGroupsResponse> futureResponse) {
      ApiFuture<ListReservationGroupsPage> futurePage =
          ListReservationGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReservationGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReservationGroupsPagedResponse(ListReservationGroupsPage page) {
      super(page, ListReservationGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReservationGroupsPage
      extends AbstractPage<
          ListReservationGroupsRequest,
          ListReservationGroupsResponse,
          ReservationGroup,
          ListReservationGroupsPage> {

    private ListReservationGroupsPage(
        PageContext<ListReservationGroupsRequest, ListReservationGroupsResponse, ReservationGroup>
            context,
        ListReservationGroupsResponse response) {
      super(context, response);
    }

    private static ListReservationGroupsPage createEmptyPage() {
      return new ListReservationGroupsPage(null, null);
    }

    @Override
    protected ListReservationGroupsPage createPage(
        PageContext<ListReservationGroupsRequest, ListReservationGroupsResponse, ReservationGroup>
            context,
        ListReservationGroupsResponse response) {
      return new ListReservationGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListReservationGroupsPage> createPageAsync(
        PageContext<ListReservationGroupsRequest, ListReservationGroupsResponse, ReservationGroup>
            context,
        ApiFuture<ListReservationGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReservationGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReservationGroupsRequest,
          ListReservationGroupsResponse,
          ReservationGroup,
          ListReservationGroupsPage,
          ListReservationGroupsFixedSizeCollection> {

    private ListReservationGroupsFixedSizeCollection(
        List<ListReservationGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReservationGroupsFixedSizeCollection createEmptyCollection() {
      return new ListReservationGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReservationGroupsFixedSizeCollection createCollection(
        List<ListReservationGroupsPage> pages, int collectionSize) {
      return new ListReservationGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
