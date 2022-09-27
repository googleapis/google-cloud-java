terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "dataproc_api" {
  service            = "dataproc.googleapis.com"
  disable_on_destroy = false
}
resource "google_project_service" "compute_api" {
  service            = "compute.googleapis.com"
  disable_on_destroy = false
}
data "google_compute_default_service_account" "default" {
  depends_on = [google_project_service.compute_api]
}
resource "google_project_iam_member" "dataproc_iam" {
  project = var.inputs.project_id
  role    = "roles/dataproc.worker"
  member  = "serviceAccount:${data.google_compute_default_service_account.default.email}"
}
