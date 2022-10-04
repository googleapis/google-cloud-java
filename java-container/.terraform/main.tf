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
    "container.googleapis.com",
  ]
}
resource "google_compute_network" "java_container_network" {
  name                    = "java-container-network"
  auto_create_subnetworks = true
  depends_on              = [module.project-services]
}
