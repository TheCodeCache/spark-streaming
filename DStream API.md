# DStream API:
`Discretized Stream` or `DStream` is the basic abstraction provided by `Spark Streaming`.  
It represents a continuous stream of data  
It can either be created from an input source or by transforming another `DStream`  
Internally, a DStream is represented by a `continuous series of RDDs`  
Each RDD in a DStream contains data from a certain interval, as follows:  

![image](https://user-images.githubusercontent.com/26399543/145887997-1bee7eab-275a-4e2f-b850-ea6aaa833fb6.png)

When we apply transformations, it gets applied to individual DStream thus generating a series of transformed DStreams like follows  

![image](https://user-images.githubusercontent.com/26399543/145888205-7bb3513b-fc21-4af7-9ec8-07dcd049b2f5.png)



# Drawbacks:
The DStreams API has multiple limitationsas follows.  
1. It is based purely on Java/Python objects and functions, as opposed to the richer concept of structured tables in DataFrames and Datasets,  
   This limits the engine’s opportunity to perform optimizations  
2. The API is purely based on processing time -  
   to handle event-time operations, applications need to implement them on their own.  
3. DStreams can only operate in a micro-batch fashion, and exposes the duration of micro-batches in some parts of its API  
   this makes ot difficult to support alternative execution modes  

**Reference:**  
1. Spark - The Definitive Guide  
2. https://spark.apache.org/docs/latest/streaming-programming-guide.html#discretized-streams-dstreams

