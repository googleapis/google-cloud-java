# Terraform Integration Testing Script

### Command:

`test.sh [module]`

#### Examples:

```shell
test.sh java-accessapproval
```

Performs integration testing on the `java-accessapproval` submodule only.

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