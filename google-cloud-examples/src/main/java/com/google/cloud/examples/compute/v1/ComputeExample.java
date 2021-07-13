package com.google.cloud.examples.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressesClient;
import com.google.cloud.compute.v1.AddressesSettings;
import com.google.cloud.compute.v1.DeleteAddressRequest;
import com.google.cloud.compute.v1.GetAddressRequest;
import com.google.cloud.compute.v1.InsertAddressRequest;
import com.google.cloud.compute.v1.ListAddressesRequest;
import com.google.cloud.compute.v1.Operation;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/** Working example code to make live calls on Addresses resources in a GCP Compute project. */
public class ComputeExample {

  // Replace the following String values with your Project and Region ids.
  private static String PROJECT_NAME = "my-project-id";
  private static String REGION = "us-central1";

  /**
   * List addresses, Insert an address, and then delete the address. Use ResourceNames in the
   * request objects.
   */
  public static void main(String[] args) throws IOException {
    AddressesClient client = createCredentialedClient();

    System.out.println("Running with Gapic Client.");
    AddressesClient.ListPagedResponse listResponse = listAddresses(client);
    verifyListAddressWithGets(client, listResponse);

    System.out.println("Running with Gapic Client and Resource Name.");
    String newAddressName = "new_address_name";
    System.out.println("Inserting address:");

    insertNewAddressJustClient(client, newAddressName);

    listAddresses(client);

    System.out.println("Deleting address:");
    Operation deleteResponse =
        client.delete(
            DeleteAddressRequest.newBuilder()
                .setProject(PROJECT_NAME)
                .setAddress(newAddressName)
                .setRegion(REGION)
                .build());
    System.out.format("Result of delete: %s\n", deleteResponse.toString());
    int sleepTimeInSeconds = 3;
    System.out.format("Waiting %d seconds for server to update...\n", sleepTimeInSeconds);
    // Wait for the delete operation to finish on the server.
    try {
      TimeUnit.SECONDS.sleep(sleepTimeInSeconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    listAddresses(client);
  }

  private static AddressesClient createCredentialedClient() throws IOException {
    Credentials myCredentials = GoogleCredentials.getApplicationDefault();
    String myEndpoint = AddressesSettings.getDefaultEndpoint();

    AddressesSettings addressesSettings =
        AddressesSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
            .setTransportChannelProvider(
                AddressesSettings.defaultHttpJsonTransportProviderBuilder()
                    .setEndpoint(myEndpoint)
                    .build())
            .build();
    return AddressesClient.create(addressesSettings);
  }

  private static void insertNewAddressJustClient(AddressesClient client, String newAddressName) {
    // Begin samplegen code for insertAddress().
    Address newAddress = Address.newBuilder().setName(newAddressName).build();
    Operation response = client.insert(PROJECT_NAME, REGION, newAddress);
    // End samplegen code for insertAddress().
    System.out.format("Result of insert: %s\n", response.toString());
  }

  /** Use an InsertAddressRequest object to make an addresses.insert method call. */
  private static void insertNewAddressUsingRequest(AddressesClient client, String newAddressName)
      throws InterruptedException, ExecutionException {
    // Begin samplegen code for insertAddress().
    Address address = Address.newBuilder().build();
    InsertAddressRequest request =
        InsertAddressRequest.newBuilder().setRegion(REGION).setAddressResource(address).build();
    // Do something
    Operation response = client.insert(request);

    // End samplegen code for insertAddress().
    System.out.format("Result of insert: %s\n", response.toString());
  }

  /** Use an callable object to make an addresses.insert method call. */
  private static void insertAddressUsingCallable(AddressesClient client, String newAddressName)
      throws InterruptedException, ExecutionException {
    // Begin samplegen code for insertAddress().
    Address address = Address.newBuilder().build();
    InsertAddressRequest request =
        InsertAddressRequest.newBuilder()
            .setProject(PROJECT_NAME)
            .setRegion(REGION)
            .setAddressResource(address)
            .build();
    ApiFuture<Operation> future = client.insertCallable().futureCall(request);
    // Do something
    Operation response = future.get();

    // End samplegen code for insertAddress().
    System.out.format("Result of insert: %s\n", response.toString());
  }

  /** List Addresses in the under the project PROJECT_NAME and region REGION. */
  private static AddressesClient.ListPagedResponse listAddresses(AddressesClient client) {
    System.out.println("Listing addresses:");
    ListAddressesRequest listRequest =
        ListAddressesRequest.newBuilder().setProject(PROJECT_NAME).setRegion(REGION).build();
    AddressesClient.ListPagedResponse response = client.list(listRequest);
    for (Address address : response.iterateAll()) {
      System.out.println("\t - " + address.toString());
    }
    return response;
  }

  private static void verifyListAddressWithGets(
      AddressesClient client, AddressesClient.ListPagedResponse listResponse) {
    for (Address address : listResponse.iterateAll()) {
      System.out.format("Making get request for address \"%s\"...\n", address.getName());

      Address fetchedAddress =
          client.get(
              GetAddressRequest.newBuilder()
                  .setAddress(address.getName())
                  .setProject(PROJECT_NAME)
                  .setRegion(REGION)
                  .build());
      System.out.format("addresses.get returns \n\t%s\n\n", fetchedAddress.toString());
    }
  }
}
