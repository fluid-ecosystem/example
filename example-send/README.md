# for k8s

put under `fluid-deployment-sender.yaml`:
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: fluid-deployment-sender
spec:
  replicas: 1
  selector:
    matchLabels:
      app: fluid-sender
  template:
    metadata:
      labels:
        app: fluid-sender
    spec:
      containers:
        - name: fluid-container
          image: fluid-test-sender-docker
          imagePullPolicy: IfNotPresent
```

one shot deployment:
```
# remove any existing deployment
kubectl delete -f fluid-deployment-sender.yaml -n fluid-test --ignore-not-found
# kafka-cluster:9092
docker build -t fluid-test-sender-docker . -f Dockerfile
minikube image load fluid-test-sender-docker
kubectl apply -f fluid-deployment-sender.yaml -n fluid-test 
```