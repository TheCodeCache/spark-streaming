# What is Stream Processing?

`Stream Processing` is the act of continuously incorporating new data to compute a result.  
It simply forms a series of events that arrive at the stream processing system  
(e.g., credit card transactions, clicks on a website, or sensor readings from Internet of Things [IoT] devices)  

User applications can then compute various queries over this stream of events  
(e.g., tracking a running count of each type of event or aggregating them into hourly windows)  

The application will output multiple versions of the result as it runs,  

In contrast, `Batch Processing`, is a system in which the computation runs on a fixedinput dataset.  

> Although streaming and batch processing sound different, in practice, they often need to work together.  
For example, streaming applications often need to join input data against a dataset written periodically by a batch job,  
and the output of streaming jobs is often files or tables that are queried in batch jobs.  

> other need is: any business logic in our applications needs to work consistently across `streaming` and `batch` execution:  
for example -  
> 1. if we have a custom code to compute a user’s billing amount  
> 2. creating a real-time version of an existing batch job  

To handle these needs, `Structured Streaming` was designed from the beginning to interoperate  
easily with the rest of Spark, including batch applications  

**Reference:**  
1. Spark - The Definitive Guide

