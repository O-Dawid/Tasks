# StructureWithStream
Nested Structures using Stream
--------
Przykład dotyczy wzorca projektowego typu: Composite Structure Pattern;<br />
![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Composite_UML_class_diagram_%28fixed%29.svg/330px-Composite_UML_class_diagram_%28fixed%29.svg.png)
![alt text](https://upload.wikimedia.org/wikipedia/commons/6/65/W3sDesign_Composite_Design_Pattern_UML.jpg)
Composite Structure Pattern zaprezentowano na przykładzie
struktury w firmie.
Każda struktura składa się z pracowników (Node) lub ich 
przełożonych (Composite Node). Do struktury można dodawać pojedynczych 
managerów lub pracowników, jak również całe podstruktury, 
tzn. Managera(Composite Node) z pracownikami (Node).</br>
Pierwotnie klient powinien mieć dostęp do klas za 
pomocą metod interfejsów które te klasy implementują.
Tu funkcjonalność jest trochę roszerzona, np. w klasie
MyStructure możemy wylistowac jej wszystkie elementy.




Zagadnienia jakie wykorzystano do rozwiązania zadania to między innymi:

- Wyrażenia Lambda
- Strumienie
- Operowanie na strukturach zagnieżdżonych

W ramach zadania przygotowano 12 testów jednostkowych sprawdzających m.in.:
- liczbę węzłów w strukturze
- liczbę węzłów w compositenode
- szukanie węzłów po kodzie
- szukanie węzłów po rendererze
- wychwytywanie wyjątków
- dodawanie węzłów
- dodawanie compositenode
