# for k8s

put under `fluid-deployment-receiver.yaml`:
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: fluid-deployment-receiver
spec:
  replicas: 1
  selector:
    matchLabels:
      app: fluid
  template:
    metadata:
      labels:
        app: fluid
    spec:
      containers:
        - name: fluid-container
          image: fluid-test-docker
          imagePullPolicy: IfNotPresent
```

one shot deployment:
```
# remove from kubeernates
kubectl delete -f fluid-deployment-receiver.yaml
kubectl delete -f fluid-deployment-receiver.yaml -n fluid-test 
# kafka-cluster:9092
docker build -t fluid-test-docker .
minikube image load fluid-test-docker
kubectl apply -f fluid-deployment-receiver.yaml -n fluid-test 
```