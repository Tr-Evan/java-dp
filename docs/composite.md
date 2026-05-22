# TP Composite

```mermaid
classDiagram
    Component <|-- FileLeaf
    Component <|-- DirectoryComposite
    DirectoryComposite : +add(c : Component)
    DirectoryComposite : +remove(c : Component)
    DirectoryComposite : +getSize() : int
```