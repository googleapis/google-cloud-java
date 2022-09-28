terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
provider "google" {
  region = var.region
  zone   = var.zone
}

resource "random_id" "id" {
  byte_length = 3

  # Calculate a new ID (thus destroying the old project and creating
  # a new one) if any of the following input variables has changed.
  keepers = {
    folder_id       = var.folder_id
    billing_account = var.billing_account
  }
}

locals {
  project_id         = lower("${var.project_prefix}-${random_id.id.hex}")
  service_account_id = "service-account-${random_id.id.hex}"
}

resource "google_project" "project" {
  name            = local.project_id
  project_id      = local.project_id
  folder_id       = random_id.id.keepers.folder_id
  billing_account = random_id.id.keepers.billing_account
}

module "project-services" {
  source = "terraform-google-modules/project-factory/google//modules/project_services"

  project_id                  = local.project_id
  enable_apis                 = true
  disable_services_on_destroy = false
  depends_on                  = [google_project.project]
  activate_apis               = [
    "cloudresourcemanager.googleapis.com",
    "iam.googleapis.com",
    "iamcredentials.googleapis.com",
    "serviceusage.googleapis.com",
  ]
}

# Create a service account in the project.
resource "google_service_account" "service_account" {
  project    = local.project_id
  account_id = local.service_account_id
  depends_on = [google_project.project]
}

# Grant the current gcloud account permission to impersonate the new service account.
resource "google_service_account_iam_member" "admin_account_iam" {
  service_account_id = google_service_account.service_account.name
  role               = "roles/iam.serviceAccountTokenCreator"
  member             = "user:${var.gcloud_account}"
  depends_on         = [
    google_service_account.service_account,
    module.project-services
  ]
}

# Grant roles to the service account so it has necessary permissions.
resource "google_project_iam_member" "service_account_editor" {
  project    = local.project_id
  # See https://cloud.google.com/iam/docs/understanding-roles#basic
  role       = "roles/editor"
  member     = "serviceAccount:${google_service_account.service_account.email}"
  depends_on = [google_service_account.service_account]
}
resource "google_project_iam_member" "service_account_projectIamAdmin" {
  project    = local.project_id
  # See https://cloud.google.com/iam/docs/understanding-roles#resourcemanager.projectIamAdmin
  role       = "roles/resourcemanager.projectIamAdmin"
  member     = "serviceAccount:${google_service_account.service_account.email}"
  depends_on = [google_service_account.service_account]
}
