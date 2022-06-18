#!/bin/bash
echo "kubectl delete rc arun-rc -n arun"
if [ $? != 0 ] ;then
echo "kubectl apply -f rs_final.yaml" 
exit 0
fi

echo "kubectl apply -f rs_final.yaml" 
