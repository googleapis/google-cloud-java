terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
resource "google_project_service" "compute" {
  service            = "compute.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
resource "google_project_service" "dataproc" {
  service            = "dataproc.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
data "google_compute_default_service_account" "default" {
  depends_on = [google_project_service.compute, google_project_service.dataproc]
}
resource "google_project_iam_member" "dataproc_iam" {
  project = var.inputs.project_id
  role    = "roles/dataproc.worker"
  member  = "serviceAccount:${data.google_compute_default_service_account.default.email}"
}
