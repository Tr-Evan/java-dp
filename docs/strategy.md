# TP Strategy

```mermaid
classDiagram
    Sorter <|-- StrategySorter
    SortStrategy <|.. BubbleSortStrategy
    SortStrategy <|.. InsertionSortStrategy
    SortStrategy <|.. SelectionSortStrategy
    StrategySorter : -SortStrategy strategy
    StrategySorter : +setStrategy(s : SortStrategy)
    StrategySorter : +sort(arr : Integer[])
```