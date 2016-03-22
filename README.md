# Kubernetes Demo
Short kubernetes demo with a typical multi tiered web application for use in workshops.

## Architecture

The infrastructure to host the application is divided in the following tiers:

- frontend: an nginx server that serves the webapp (a simple javascript app) and provides proxy services for the different 
services of the infrastructure (backend api).
- backend-api: a REST api that the web front feeds upon
- mysql: the database that the REST api takes it's data from. Read only database that is already filled with some test data.

Each tier is load balanced and has at least 2 replicas. 

## Service discovery

Each tier has an associated service, which creates a dns entry on each pod with the name of the service. Such as in the frontend 
pods, the backend-api service may be accessed by requesting the http://backend-api URL, which will resolve to the service instance
ip (which in turn will load balance between the replicas created by the Replication Controller for the backend-api tier).

## Namespaces

A dev and prod namespace has been provided to test environments with kubernetes. The containers themselves use the short dns form
of a service (just the service name, instead of the fully qualified name with the namespace), so no special image should be made
to deploy on different environments.

## Cloud provider

Although Kubernetes should work on any cloud provider, this has only been tested on Google Cloud Engine, with Container Engine.
