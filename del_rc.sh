#!/bin/bash
kubectl delete rc arun-rc -n arun
if [ $? != 0 ] ;then
kubectl apply -f rs_final.yaml
exit 0
fi
kubectl apply -f rs_final.yaml
