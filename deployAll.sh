#!/bin/bash
#Mysql
kubectl create -f mysql/kubernetes/mysql_rc
kubectl create -f mysql/kubernetes/mysql_service

#Backend
kubectl create -f backend/kubernetes/backend-api_rc
kubectl create -f backend/kubernetes/backend-api_service

#Frontend
kubectl create -f frontend/kubernetes/frontend_rc
kubectl create -f frontend/kubernetes/frontend_service
