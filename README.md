#Calculo de Stock

Pre Requisitos:

- JDK 8 
****
**Uso:**

ejecutar en una terminal el siguiente comando desde el root del proyecto. 
```
./mvnw clean spring-boot:run
```

esto va a levantar un proyecto SpringBoot el cual se va a ver por salida de la terminal y tambien se va a poder ver 
el output del calculo de stock haciendole una llamada por get a la siguiente URL:
```
http://localhost:8080/stock/products/available
```
****

**Estructuras de datos utilizadas en el algoritmo:**

Se utilizo ArrayLists para el parseo de csv a clases para evitar borrar datos que esteen duplicados en los CSVs, 
TreeSet para el ordenamiento de la lista de productos ya que esta implementación está basada en el uso de una estructura
de árbol permitiendo que los elementos estén ordenados y set para la lista filtrada de Sizes ya que.

**Complejidad temporal del algoritmo:**

La complejidad temporal del metodo __*getProductsWithStock*__ dentro de la clase __*CalculateStock*__, que es la implementacion
del algoritmo a resolver, es de **O(n^3)**.
Se puede mejorar implementando una busqueda binaria sobre la lista de
*Stocks* para reducirlo a __O((n^2)*log(n))__