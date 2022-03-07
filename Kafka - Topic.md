# Basic examples with Kafka Topic – 

```cmd
c:\kafka_2.12-3.1.0>bin\windows\kafka-topics.bat --create --replication-factor 1 --partitions 1 --topic test --bootstrap-server localhost:9092
Created topic test.

c:\kafka_2.12-3.1.0>bin\windows\kafka-topics.bat --describe --topic test --bootstrap-server localhost:9092
Topic: test     TopicId: im3xcub3RBqXtAIdrGGBAw PartitionCount: 1       ReplicationFactor: 1    Configs: segment.bytes=1073741824
        Topic: test     Partition: 0    Leader: 0       Replicas: 0     Isr: 0
```

**Kafka Producer:**  

![image](https://user-images.githubusercontent.com/26399543/157089133-d8dfd624-9ea6-4a92-a676-7aaf55ecc157.png)  

**Kafka Consumer:**  

![image](https://user-images.githubusercontent.com/26399543/157089050-4982831a-10af-4e26-aea6-ac8f21275cd9.png)  

**Complete Communication View b/w Producer and Consumer:**  

![image](https://user-images.githubusercontent.com/26399543/157088968-c15728b1-1092-40bb-aaa4-fdd51a34a409.png)  

