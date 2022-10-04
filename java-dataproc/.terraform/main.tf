terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
module "project-services" {
  source = "terraform-google-modules/project-factory/google//modules/project_services"

  project_id                  = var.inputs.project_id
  enable_apis                 = var.inputs.should_enable_apis_on_apply
  disable_services_on_destroy = var.inputs.should_disable_apis_on_destroy
  activate_apis               = [
    "compute.googleapis.com",
    "dataproc.googleapis.com"
  ]
}
data "google_compute_default_service_account" "default" {
  depends_on = [module.project-services]
}
resource "google_project_iam_member" "dataproc_iam" {
  project = var.inputs.project_id
  role    = "roles/dataproc.worker"
  member  = "serviceAccount:${data.google_compute_default_service_account.default.email}"
}
