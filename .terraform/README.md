# Terraform + Integration Testing

[Terraform](https://www.terraform.io/) is an "Infrastructure as Code" (IaC) tool that allows cloud
and on-prem resources to be defined in configuration files to be versioned, reused, and shared. By
using Terraform to provision our GCP projects prior to running integration tests we:

* Ensure infrastructure provisioning consistency,
* Prevent conflicts between concurrent integration test invocations using the same GCP project by
  randomizing resource names,
* Provide a managed lifecycle including the ability to destroy short-lived testing environments,
* Version the infrastructure requirements with the test source.

The scripts in this directory:

* Generate a 'root' Terraform configuration based on a set of chosen client libraries.
* Invoke OAuth2 authentication as necessary for the `gcloud` CLI and for the client libraries using
  [Application Default Credentials](https://cloud.google.com/docs/authentication/application-default-credentials)
  .
* (Optionally) Create a new GCP project in which to run integration tests.
* Create and [impersonate](https://cloud.google.com/iam/docs/impersonating-service-accounts) a
  [service account](https://cloud.google.com/iam/docs/understanding-service-accounts) in the
  provided GCP project.
* Invoke Terraform's `init`, `plan`, and `apply` to provision the GCP project with
  the resources, permissions, and enabled APIs needed for the integration tests.
* Invoke `mvn verify` to run the integration tests.
* (Optionally) Destroy Terraform-managed resources from the GCP project when no longer being used
  for testing.

### Command:

```
test.sh [module][:module ...]
```

Primary command to be used to

#### Examples:

```shell
test.sh java-accessapproval:java-container:java-vision
```

Performs Terraform setup and integration testing on three submodules, where:

* `:` is the delimiter
* `java-accessapproval`, `java-container`, and `java-vision` are to be tested

```shell
test.sh
```

Performs integration testing on all modules defined in `modules-under-test.txt`.

### GCP Project Selection or Creation+Deletion

#### Using an existing project

If the environment variable `GOOGLE_CLOUD_PROJECT` is defined with a
GCP Project ID, that project will be used for all integration tests and
will not be deleted after use.

#### Automatic creation and deletion of single-use project

If the environment variable `GOOGLE_CLOUD_PROJECT` is not defined,
a single-use project will be created with a random suffix. In this
situation, the following environment variables will be used or
values will be prompted for them:

* `TF_VAR_folder_id` : [GCP Folder](https://cloud.google.com/resource-manager/docs/creating-managing-folders)
  in which new GCP projects will be created
* `TF_VAR_billing_account` : [Billing account](https://cloud.google.com/billing/docs/concepts) to be
  used for created GCP projects
* `TF_VAR_project_prefix` : Prefix to use for all created GCP projects

## Troubleshooting

### Error waiting for Deleting Network: The network resource `X` is already being used by `Y`

```
module.java_container.google_compute_network.java_container_network: Destroying... [id=projects/<project_id>/global/networks/java-container-network-<random_id>]
module.java_container.google_compute_network.java_container_network: Still destroying... [id=projects/<project_id>/global/networks/java-container-network-<random_id>, 10s elapsed]
╷
│ Error: Error waiting for Deleting Network: The network resource 'projects/<project_id>/global/networks/java-container-network-<random_id>' is already being used by 'projects/<project_id>/global/firewalls/java-container-network-<random_id>-<$RANDOM>'
│ 
│ 
│ 
╵
```

Your organization's policies may automatically add firewall rules to networks created by Terraform.
If this happens, Terraform will be unable to delete the network from the project unless the
[firewall rules](https://pantheon.corp.google.com/networking/firewalls/list) are removed, but your
organization's policies may prevent this.

The default behavior of these Terraform scripts is to avoid this situation by not destroying the
network. This is not a feature of Terraform, and is subject to limitations.

* When explicitly invoking `./destroy.sh`, we first invoke a client library's
  `./<client-library>/.terraform/predestroy.sh` hook if it exists. Client libraries are then able to
  remove the VPC network from Terraform's state prior to the `terraform destroy` command.
* However, Terraform will implicitly destroy the network if the client library is removed from the
  configuration and `terraform apply` is invoked. **This produces the above error.**

To resolve the error, either:

* Explicitly destroy the client library: `./destroy.sh <client-library>` (
  ex: `./destroy.sh java-container`),
* Explicitly destroy the full configuration: `./destroy.sh`, or
* Manually invoke the client library's `predestroy.sh` hook from the `<root>/.terraform` directory.

Example:

```shell
 repo-root$ cd .terraform
.terraform$ ./../java-container/.terraform/predestroy.sh
Removed module.java_container.google_compute_network.java_container_network
Successfully removed 1 resource instance(s).
```

