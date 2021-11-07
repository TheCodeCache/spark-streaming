# Stream Processing Architectures  

At a high level, modern distributed stream processing pipelines execute as follows:  
1. **Recieve**  
  i.e. reads from data sources, for ex: live logs, IoT device data, flight sensor data, sports live streams, etc.  
2. **Process**  
  i.e. process the data in parallel, this is what streaming engines are designed to do.  
3. **Output**  
  i.e. writes the results out to downstream systems like HBase, Cassandra, Kafka, etc.  

To process the data,  
  most **traditional stream processing systems** are designed with a `continuous operator model`,  
  which works as follows:  
  - There is a set of worker nodes, each of which run one or more continuous operators  
  - Each continuous operator processes the streaming data one record at a time and  
  forwards the records to other operators in the pipeline.  
  - continuous operations can **not** be added dynamically at run time.  
  - There are `source` operators for receiving data from ingestion systems, and `sink` operators that output to downstream systems  

        <img src="https://databricks.com/wp-content/uploads/2015/07/image11.png" width=50% height=50% name="Architecture of traditional stream processing systems"/>  

The above architecture is also called as `Continous Operator Model`.  

But, this traditional streaming system fails to meet today's demands  
  for ex: like procesing at a very high scale and perform complex real-time analytics:  
Traditional streaming systems have following challenges or limitations:  

1. Fast failure and straggler (slow) recovery:  
2. Load Balancing:  
3. Unification of streaming, batch and interactive workloads:  
4. Advanced analytics like machine learning and SQL queries:  

To address the above requirements or issues with traditional streaming systems,  
 `Spark Streaming` uses a new architecture called `discretized streams`  
  that directly levarages the rich libraries and fault tolenrence of the spark engine.  

# Architecture of Spark Streaming: Discretized Streams  

Instead of processing the streaming data one record at a time,  
  Spark Streaming discretizes the streaming data into tiny, sub-second micro-batches.  
  In other words, Spark Streaming’s Receivers accept data in parallel and buffer it in the memory of Spark’s workers nodes.  
  Then the latency-optimized Spark engine runs short tasks (tens of milliseconds) to process the batches and output the results to other systems.  
  Note that unlike the traditional continuous operator model,  
  where the computation is statically allocated to a node,  
  Spark tasks are assigned dynamically to the workers based on the locality of the data and available resources.  
  This enables both better load balancing and faster fault recovery, as we will illustrate next.  

In addition, each batch of data is a Resilient Distributed Dataset (RDD), which is the basic abstraction of a fault-tolerant dataset in Spark.  
  This allows the streaming data to be processed using any Spark code or library.  

        <img src="https://databricks.com/wp-content/uploads/2015/07/image21.png" name="Spark Streaming Architecture" width=50% height=50% />  

**Benefits of Discretized Stream Processing:**

1. Dynamic load balancing:
2. Fast failure and straggler recovery
3. Unification of batch, streaming and interactive analytics
4. Advanced analytics like machine learning and interactive SQL

Performance:  

Other Concepts:  
1. Backpressure
2. Dynamic Scaling
3. Event time and out-of-order data 


Reference:  
  https://databricks.com/blog/2015/07/30/diving-into-apache-spark-streamings-execution-model.html  
