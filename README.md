# BoundedFlow
Java 21 real-time stream processing engine for e-commerce events with windowing, backpressure and anomaly detection.

## Data

Download the full "Retailrocket E-commerce Dataset" from Kaggle:
https://www.kaggle.com/datasets/retailrocket/ecommerce-dataset

Extract `events.csv` and place it at `data/events.csv` (not committed, see `.gitignore`).

A 1000-row sample lives at `data/sample/events-sample.csv` for tests and a quick first run; its header is `timestamp,visitorid,event,itemid,transactionid`.
